package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	public static JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("edEXT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 638);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnSistema.add(mntmSalir);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AltaUsuario alta = new AltaUsuario();
				desktopPane.add(alta);
				alta.setVisible(true);
				
			}
		});
		mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmConsultaUsuario = new JMenuItem("Consultar usuario");
		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaUsuario alta = new ConsultaUsuario();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnUsuario.add(mntmConsultaUsuario);
		
		JMenuItem mntmModificarDatos = new JMenuItem("Modificar datos");
		mntmModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarDatosUsuario alta = new ModificarDatosUsuario();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnUsuario.add(mntmModificarDatos);
		
		JMenu mnCurso = new JMenu("Curso");
		menuBar.add(mnCurso);
		
		JMenuItem mntmAltaCurso = new JMenuItem("Alta curso");
		mntmAltaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaCurso alta = new AltaCurso();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnCurso.add(mntmAltaCurso);
		
		JMenuItem mntmConsultaCurso = new JMenuItem("Consultar curso");
		mntmConsultaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCurso alta = new ConsultaCurso();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnCurso.add(mntmConsultaCurso);
		
		JMenuItem mntmAltaEdicionCurso = new JMenuItem("Alta edicion curso");
		mntmAltaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaEdicionCurso alta = new AltaEdicionCurso();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnCurso.add(mntmAltaEdicionCurso);
		
		JMenuItem mntmConsultaEdicionCurso = new JMenuItem("Consultar edicion curso");
		mntmConsultaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaEdicionCurso alta = new ConsultaEdicionCurso();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnCurso.add(mntmConsultaEdicionCurso);
		
		JMenuItem mntmInscripcionEdicionCurso = new JMenuItem("Inscripcion edicion curso");
		mntmInscripcionEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionEdicionCurso alta = new InscripcionEdicionCurso();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnCurso.add(mntmInscripcionEdicionCurso);
		
		JMenu mnFormacion = new JMenu("Programa de formacion");
		menuBar.add(mnFormacion);
		
		JMenuItem mntmCrearPrograma = new JMenuItem("Crear programa");
		mntmCrearPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProgramaFormacion alta = new CrearProgramaFormacion();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnFormacion.add(mntmCrearPrograma);
		
		JMenuItem mntmAgregarCurso = new JMenuItem("Agregar curso");
		mntmAgregarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarCursoAProgramaFormacion alta = new AgregarCursoAProgramaFormacion();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnFormacion.add(mntmAgregarCurso);
		
		JMenuItem mntmConsultarPrograma = new JMenuItem("Consultar programa");
		mntmConsultarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProgramaFormacion alta = new ConsultaProgramaFormacion();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnFormacion.add(mntmConsultarPrograma);
		
		JMenu mnInstituto = new JMenu("Instituto");
		menuBar.add(mnInstituto);
		
		JMenuItem mntmAltaInstituto = new JMenuItem("Alta instituto");
		mntmAltaInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaInstituto alta = new AltaInstituto();
				desktopPane.add(alta);
				alta.setVisible(true);
			}
		});
		mnInstituto.add(mntmAltaInstituto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_10896363501344");
		desktopPane.setLayout(null);
	}

}
