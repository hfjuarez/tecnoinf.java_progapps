package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

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
		setBounds(100, 100, 450, 300);

	}

}
