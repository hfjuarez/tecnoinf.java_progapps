package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AgregarCursoAProgramaFormacion extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCursoAProgramaFormacion frame = new AgregarCursoAProgramaFormacion();
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
	public AgregarCursoAProgramaFormacion() {
		setTitle("Agregar curso aprograma de formacion");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
