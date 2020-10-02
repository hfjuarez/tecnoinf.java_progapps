package vista;

import java.awt.EventQueue;
import API.*;
import API.datatypes.*;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ConsultaUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String usuario;
	private ILogica Interfaz = new BizcochoEnARG().getInterface();
	private DTDocente docenteSelec;
	private DTEstudiante estudianteSelec;
	private List<String> ListaCursos = new ArrayList();
	private List<String> ListaFormacion = new ArrayList();
	private List<String> CursosUsados = new ArrayList();
	private boolean nefasdou;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
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
	public ConsultaUsuario() {
		setTitle("Consulta de usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 582, 471);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 400, 40);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();

		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 60, 400, 120);
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNickname);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNombre);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblApellido);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel_3.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblEmail);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel_3.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblFechaDeNacimiento);

		textField = new JTextField();
		textField.setEditable(false);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblInstituto);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		panel_3.add(textField_5);
		textField_5.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(20, 200, 400, 200);
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{200, 0};
		gbl_panel_5.rowHeights = new int[]{12, 12, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCursos = new GridBagConstraints();
		gbc_lblCursos.fill = GridBagConstraints.BOTH;
		gbc_lblCursos.insets = new Insets(0, 0, 5, 0);
		gbc_lblCursos.gridx = 0;
		gbc_lblCursos.gridy = 0;
		panel_5.add(lblCursos, gbc_lblCursos);

		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel_5.add(panel_9, gbc_panel_9);
		
		JComboBox comboBox_curso = new JComboBox();
		GridBagConstraints gbc_comboBox_curso = new GridBagConstraints();
		gbc_comboBox_curso.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_curso.gridx = 0;
		gbc_comboBox_curso.gridy = 2;
		panel_5.add(comboBox_curso, gbc_comboBox_curso);
		
		List<DTEstudiante> estudiantes = Interfaz.listaEstudiantes();
		for (DTEstudiante es : estudiantes) {
			comboBox.addItem(es.nickname);
		}

		List<DTDocente> docs = Interfaz.listaDocentes();
		for (DTDocente d : docs) {
			comboBox.addItem(d.nickname);
		}

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{200, 0};
		gbl_panel_6.rowHeights = new int[]{12, 12, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblProgramasDeFormacion = new JLabel("Programas de formacion");
		lblProgramasDeFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblProgramasDeFormacion = new GridBagConstraints();
		gbc_lblProgramasDeFormacion.fill = GridBagConstraints.BOTH;
		gbc_lblProgramasDeFormacion.insets = new Insets(0, 0, 5, 0);
		gbc_lblProgramasDeFormacion.gridx = 0;
		gbc_lblProgramasDeFormacion.gridy = 0;
		panel_6.add(lblProgramasDeFormacion, gbc_lblProgramasDeFormacion);

		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 1;
		panel_6.add(panel_10, gbc_panel_10);
		
		JComboBox comboBox_formacion = new JComboBox();
		GridBagConstraints gbc_comboBox_formacion = new GridBagConstraints();
		gbc_comboBox_formacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_formacion.gridx = 0;
		gbc_comboBox_formacion.gridy = 2;
		panel_6.add(comboBox_formacion, gbc_comboBox_formacion);

//		for (String curso : listaProgramas()) {
//			JButton btnCurso = new JButton(curso);
//			btnCurso.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					ConsultaProgramaFormacion cc = new ConsultaProgramaFormacion();
//					cc.setPrograma(curso);
//					VentanaPrincipal.desktopPane.add(cc);
//					cc.setVisible(true);
//				}
//			});
//			panel_6.add(btnCurso);
//		}

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{200, 0};
		gbl_panel_7.rowHeights = new int[]{12, 12, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblEdicionesDeCursos = new JLabel("Ediciones de cursos");
		lblEdicionesDeCursos.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblEdicionesDeCursos = new GridBagConstraints();
		gbc_lblEdicionesDeCursos.fill = GridBagConstraints.BOTH;
		gbc_lblEdicionesDeCursos.insets = new Insets(0, 0, 5, 0);
		gbc_lblEdicionesDeCursos.gridx = 0;
		gbc_lblEdicionesDeCursos.gridy = 0;
		panel_7.add(lblEdicionesDeCursos, gbc_lblEdicionesDeCursos);

		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 1;
		panel_7.add(panel_11, gbc_panel_11);
		
		JComboBox comboBox_edicion = new JComboBox();
		GridBagConstraints gbc_comboBox_edicion = new GridBagConstraints();
		gbc_comboBox_edicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_edicion.gridx = 0;
		gbc_comboBox_edicion.gridy = 2;
		panel_7.add(comboBox_edicion, gbc_comboBox_edicion);

//		for (String curso : listaEdiciones()) {
//			JButton btnCurso = new JButton(curso);
//			btnCurso.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					ConsultaEdicionCurso cc = new ConsultaEdicionCurso();
//					cc.setEdicion(curso);
//					VentanaPrincipal.desktopPane.add(cc);
//					cc.setVisible(true);
//				}
//			});
//			panel_7.add(btnCurso);
//		}

		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);

		JButton btnAceptar = new JButton("Cerrar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(432, 375, 117, 25);
		getContentPane().add(btnAceptar);

		JButton btnRefresh = new JButton("Ver datos");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_edicion.removeAllItems();
				comboBox_formacion.removeAllItems();
				comboBox_curso.removeAllItems();
				ListaCursos.clear();
				CursosUsados.clear();
				CursosUsados.add("doou");
				String usuario = comboBox.getSelectedItem().toString();
				if (Interfaz.isEstudiante(usuario)) {
					estudianteSelec = Interfaz.obtenerEstudiante(usuario);
					textField_1.setText(estudianteSelec.nickname);
					textField_2.setText(estudianteSelec.nombre);
					textField_3.setText(estudianteSelec.apellido);
					textField_4.setText(estudianteSelec.mail);
					textField_5.setText("");
					textField.setText(estudianteSelec.fechaNac.toString());
					List<DTInscripcion_Edicion> lins = Interfaz.listaIns();
					List<String> liste = new ArrayList();
					for (DTInscripcion_Edicion i : lins) {
						if (i.estudiante.nickname.equals(estudianteSelec.nickname)) {
							liste.add(i.edicionCurso.nombreEdicion);
							comboBox_curso.addItem(i.edicionCurso.curso.nombreCurso);
							ListaCursos.add(i.edicionCurso.curso.nombreCurso);
						}
					}
					for (String e1 : liste) {
						
						comboBox_edicion.addItem(e1);
					}
					List<DTFormacion> formaciones = Interfaz.consultaFormacion();
					ListaFormacion.clear();
					ListaFormacion.add("dou");
					for(DTFormacion formacion : formaciones)
					{		
						nefasdou=false;
							List<DTCurso> cursos = formacion.cursos;
							for(DTCurso curso : cursos)
							{
								for(String nombrecurso : ListaCursos)
								{
									if(curso.nombreCurso.equals(nombrecurso))
									{
										for(String dou : ListaFormacion)
										{
											if(dou.equals(formacion.nombreFormacion))
											{
												nefasdou=true;
											}
										}
										if(nefasdou==true)
										{
											
										}
										else
										{
											ListaFormacion.add(formacion.nombreFormacion);
											comboBox_formacion.addItem(formacion.nombreFormacion);
										}
									}
								}
							}
					}
				} else {
					List<DTDocente> docentes;
					docenteSelec = Interfaz.obtenerDocente(usuario);
					textField_1.setText(docenteSelec.nickname);
					textField_2.setText(docenteSelec.nombre);
					textField_3.setText(docenteSelec.apellido);
					textField_4.setText(docenteSelec.mail);
					textField_5.setText(docenteSelec.instituto.nombreInstituto);
					textField.setText(docenteSelec.fechaNac.toString());
					List<DTInscripcion_Edicion> lins = Interfaz.listaIns();
					List<String> liste = new ArrayList();
					for (DTInscripcion_Edicion i : lins) {
						docentes = i.edicionCurso.docentes;
						for(DTDocente doc : docentes)
						{
							nefasdou=false;
							if (doc.nickname.equals(docenteSelec.nickname)) {
								for(String curso : CursosUsados)
								{
									if(i.edicionCurso.curso.nombreCurso.equals(curso))
									{
										nefasdou=true;
									}
								}
								if(nefasdou==true)
								{
									
								}
								else
								{
									liste.add(i.edicionCurso.nombreEdicion);
									comboBox_curso.addItem(i.edicionCurso.curso.nombreCurso);
									ListaCursos.add(i.edicionCurso.curso.nombreCurso);
									CursosUsados.add(i.edicionCurso.curso.nombreCurso);
								}
							}
						}
					}
					for (String e1 : liste) {
						
						comboBox_edicion.addItem(e1);
					}
					List<DTFormacion> formaciones = Interfaz.consultaFormacion();
					ListaFormacion.clear();
					ListaFormacion.add("dou");
					for(DTFormacion formacion : formaciones)
					{		
						nefasdou=false;
							List<DTCurso> cursos = formacion.cursos;
							for(DTCurso curso : cursos)
							{
								for(String nombrecurso : ListaCursos)
								{
									if(curso.nombreCurso.equals(nombrecurso))
									{
										for(String dou : ListaFormacion)
										{
											if(dou.equals(formacion.nombreFormacion))
											{
												nefasdou=true;
											}
										}
										if(nefasdou==true)
										{
											
										}
										else
										{
											ListaFormacion.add(formacion.nombreFormacion);
											comboBox_formacion.addItem(formacion.nombreFormacion);
										}
									}
								}
							}
					}

				}

			}
		});
		btnRefresh.setBounds(432, 20, 117, 25);
		getContentPane().add(btnRefresh);

	}
}
