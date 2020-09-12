package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class InscripcionEdicionCurso extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionEdicionCurso frame = new InscripcionEdicionCurso();
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
	public InscripcionEdicionCurso() {
		setTitle("Inscripcion a edicion de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 415, 368);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 12, 350, 250);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblInstituto);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblEdicion = new JLabel("Edicion");
		lblEdicion.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEdicion);
		
		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblEstudiante = new JLabel("Estudiante");
		lblEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEstudiante);
		
		JComboBox comboBox_3 = new JComboBox();
		panel.add(comboBox_3);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha inscripcion");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 3, 0, 0));
		
		JSpinner spinner = new JSpinner();
		panel_10.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		panel_10.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		panel_10.add(spinner_2);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(212, 287, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(83, 287, 117, 25);
		getContentPane().add(btnCancelar);

	}
}
