package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ModificarDatosUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosUsuario frame = new ModificarDatosUsuario();
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
	public ModificarDatosUsuario() {
		setTitle("Modificar datos de usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
