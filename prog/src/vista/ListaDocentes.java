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
		setBounds(100, 100, 326, 380);
		getContentPane().setLayout(null);
		
		docentes = new ArrayList<>();
		docentes.add("Pepe");
		docentes.add("Carlos");
		docentes.add("Maria");
		docentes.add("Teresa");
		docentes.add("Juan");
		docentes.add("Karina");
		docentes.add("Rosario");
		this.cb = new JCheckBox[docentes.size()];
		
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 30, 200, 250);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
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
		btnAceptar.setBounds(174, 292, 117, 25);
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
