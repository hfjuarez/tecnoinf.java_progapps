package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaInstituto extends JInternalFrame {
	private JTextField textField;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaInstituto frame = new AltaInstituto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaInstituto() {
		setResizable(true);
		setTitle("Alta de instituto");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 287, 196);
		getContentPane().setLayout(null);
		
		JLabel lblNombreInstituto = new JLabel("Nombre instituto");
		lblNombreInstituto.setBounds(12, 33, 188, 15);
		getContentPane().add(lblNombreInstituto);
		
		textField = new JTextField();
		textField.setBounds(12, 72, 248, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Agregado");
					textField.setText("");
				}else {
					JOptionPane.showMessageDialog(null,"El campo no debe ser vacio");
				}
				
			}
		});
		btnAgregar.setBounds(143, 123, 117, 25);
		getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(14, 123, 117, 25);
		getContentPane().add(btnCancelar);

	}
}
