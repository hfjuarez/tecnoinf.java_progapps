package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class ListaCursos extends JInternalFrame {

	private static ArrayList<String> cursos;
	
	/**
	 * Create the frame.
	 */
	public ListaCursos(ArrayList<String> cursos) {
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 489, 320);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 450, 200);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.cursos = cursos;
		getContentPane().setLayout(null);
		JCheckBox cb[] =new JCheckBox[cursos.size()];
		
		for(int i=0;i<cursos.size();i++) {
			cb[i]=new JCheckBox(cursos.get(i));
			panel.add(cb[i]);
		}
		
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> previas = new ArrayList<>();
				for(int i=0;i<cursos.size();i++) {
					if(cb[i].isSelected()) {
						previas.add(cb[i].getText());
					}
				}
				AltaCurso.previas = previas;
				setVisible(false);
			}
		});
		btnNewButton.setBounds(297, 234, 117, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(151, 234, 117, 25);
		getContentPane().add(btnCancelar);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCursos frame = new ListaCursos(cursos);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
