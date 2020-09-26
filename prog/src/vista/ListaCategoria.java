package vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import API.datatypes.*;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCategoria extends JInternalFrame {
	private static List<DTCategoria> cat;


	/**
	 * Create the frame.
	 */
	public ListaCategoria(List<DTCategoria> cat) {
		setTitle("Lista de categorias");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		this.cat = cat;
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 23, 378, 175);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JCheckBox cb[] =new JCheckBox[cat.size()];
		
		for(int i=0;i<cat.size();i++) {
			cb[i]=new JCheckBox(cat.get(i).nombreCategoria);
			panel.add(cb[i]);
		}
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> cats = new ArrayList<>();
				for(int i=0;i<cat.size();i++) {
					if(cb[i].isSelected()) {
						cats.add(cb[i].getText());
					}
				}
				AltaCurso.categorias = cats;
				setVisible(false);
			}
		});
		btnAceptar.setBounds(279, 220, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(102, 220, 117, 25);
		getContentPane().add(btnCancelar);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCategoria frame = new ListaCategoria(cat);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
