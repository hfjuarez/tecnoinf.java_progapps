package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import API.*;
import API.datatypes.*;
import java.util.List;

public class ListaDocentes extends JInternalFrame {
	
	private JCheckBox cb[];
	private ArrayList<String> docentes=null;
	private ArrayList<String> docentesAgregados=null;
	/**
	 * Create the frame.
	 */
	public ListaDocentes() {
		setTitle("Lista Docentes");
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 373, 319);
		getContentPane().setLayout(null);
		
		docentes = new ArrayList<>();
		ILogica Interfaz = new BizcochoEnARG().getInterface();
		List <DTDocente> Docentes = Interfaz.listaDocentes();
		for (DTDocente docentito : Docentes)
		{
			docentes.add(docentito.nickname);
		}
		this.cb = new JCheckBox[docentes.size()];
		
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 300, 200);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		for(int i=0;i<docentes.size();i++) {
			cb[i] = new JCheckBox(docentes.get(i));
			cb[i].setHorizontalAlignment(SwingConstants.LEFT);
			panel.add(cb[i]);
		}
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				docentesAgregados = new ArrayList<>();
				for(int i=0; i<docentes.size();i++) {
					if(cb[i].isSelected()) {
						docentesAgregados.add(cb[i].getText());
					}
				}
				
				setVisible(false);
			}
		});
		btnAceptar.setBounds(213, 242, 117, 25);
		getContentPane().add(btnAceptar);
		
		

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDocentes frame = new ListaDocentes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ArrayList<String> getDocentesSeleccionados(){
		return docentesAgregados;
	}
 }
