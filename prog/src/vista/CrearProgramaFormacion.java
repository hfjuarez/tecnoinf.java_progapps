package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CrearProgramaFormacion extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProgramaFormacion frame = new CrearProgramaFormacion();
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
	public CrearProgramaFormacion() {
		setTitle("Crear programa de formacion");
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 450, 300);

	}

}
