package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import API.BizcochoEnARG;
import API.ILogica;

import API.datatypes.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ItemEvent;

import javax.swing.JInternalFrame;
import java.awt.Checkbox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.List;

import java.io.File;
import javax.swing.JOptionPane;

public class ModificarDatosUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String usuario;
	private String inti;
	private JComboBox comboBox_1;
	private ILogica Interfaz = new BizcochoEnARG().getInterface();
	private List<DTEstudiante> ListaEstudiante;
	private List<DTDocente> ListaDocente;

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
		setResizable(true);
		setTitle("Modificar datos de usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 442, 260);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				usuario = e.getItem().toString();
			}
		});

		ListaEstudiante = Interfaz.listaEstudiantes();
		for (DTEstudiante estudiante : ListaEstudiante) {
			comboBox.addItem(estudiante.nickname);
		}
		ListaDocente = Interfaz.listaDocentes();
		for (DTDocente docente : ListaDocente) {
			comboBox.addItem(docente.nickname);
		}

		getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Ver datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Interfaz.isEstudiante(usuario)) {
					for (DTEstudiante estudiante : ListaEstudiante) {
						if (estudiante.nickname.equals(usuario)) {
							setCamposEstudiandes(estudiante);
						}
					}
				} else {
					for (DTDocente docente : ListaDocente) {
						if (docente.nickname.equals(usuario)) {
							setCamposDocentes(docente);
						}
					}
				}
			}
		});
		getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(600, 400));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNickname);

		textField = new JTextField();
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre);

		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblApellido);

		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFechaDeNacimiento);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		textField_5 = new JTextField();
		panel_1.add(textField_5);
		textField_5.setColumns(5);

		textField_6 = new JTextField();
		panel_1.add(textField_6);
		textField_6.setColumns(5);

		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(5);

		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblInstituto);

		comboBox_1 = new JComboBox();
		List<DTInstituto> ListaInstituto = Interfaz.listaInstitutos();
		for (DTInstituto instituto : ListaInstituto) {
			comboBox_1.addItem(instituto.nombreInstituto);
		}
		panel.add(comboBox_1);

		JButton btnAceptar = new JButton("Cancelar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(btnAceptar);

		JButton btnCancelar = new JButton("Aceptar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("")) {
					// Falta validar que no exista el instituto
					String nickname = textField.getText();
					String nombre = textField_2.getText();
					String apellido = textField_3.getText();
					String email = textField_1.getText();
					String fecha = (textField_4.getText() + "-" + textField_6.getText() + "-" + textField_5.getText());
					Date nacDate = Date.valueOf(fecha);
					File imagen = null;
					String xd = Interfaz.ModificarUsuario(nickname, nombre, apellido, nacDate, imagen);

					if (xd.isEmpty()) {
						DTEstudiante est = null;
						DTDocente doc = null;
						if (Interfaz.isEstudiante(nickname)) {
							est = Interfaz.obtenerEstudiante(nickname);
							JOptionPane.showMessageDialog(null,
									"Se ha modificado el usuario con nickname: " + nickname + "\n" + "Datos anteriores:"
											+ "\n  - Nombre:" + est.nombre + "\n  - Apellido:" + est.apellido
											+ "\n  - Fecha nac:" + est.fechaNac.toString() + "\n\n" + "Datos nuevos:"
											+ "\n  - Nombre:" + nombre + "\n  - Apellido:" + apellido
											+ "\n  - Fecha nac:" + nacDate.toString());
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_6.setText("");

						} else {
							doc = Interfaz.obtenerDocente(nickname);
							JOptionPane.showMessageDialog(null,
									"Se ha modificado el usuario con nickname: " + nickname + "\n" + "Datos anteriores:"
											+ "\n  - Nombre:" + doc.nombre + "\n  - Apellido:" + doc.apellido
											+ "\n  - Fecha nac:" + doc.fechaNac.toString() + "\n\n" + "Datos nuevos:"
											+ "\n  - Nombre:" + nombre + "\n  - Apellido:" + apellido
											+ "\n  - Fecha nac:" + nacDate.toString());
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_6.setText("");

						}
					} else {
						JOptionPane.showMessageDialog(null, xd);
					}
				}
			}
		});

		getContentPane().add(btnCancelar);

	}

	private void setCamposEstudiandes(DTEstudiante estudiante) {
		// Se busca el dtusuario con el nickname usuairo, se rellena los campos con esos
		// datos
		// Nikname
		textField.setText(estudiante.nickname);
		// Email
		textField_1.setText(estudiante.mail);
		// Nombre
		textField_2.setText(estudiante.nombre);
		// Apellido
		textField_3.setText(estudiante.apellido);
		// fecha nacimiento
		// dia
		Calendar c = Calendar.getInstance();
		c.setTime(estudiante.fechaNac);
		String dia = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
		String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
		String anio = Integer.toString(c.get(Calendar.YEAR));

		textField_5.setText(dia);
		// mes
		textField_4.setText(anio);
		// anio
		textField_6.setText(mes);
		setComboBox_1Visible(false);

	}

	private void setCamposDocentes(DTDocente docente) {
		// Se busca el dtusuario con el nickname usuairo, se rellena los campos con esos
		// datos
		// Nikname
		textField.setText(docente.nickname);
		// Email
		textField_1.setText(docente.mail);
		// Nombre
		textField_2.setText(docente.nombre);
		// Apellido
		textField_3.setText(docente.apellido);
		// fecha nacimiento
		// dia
		Calendar c = Calendar.getInstance();
		c.setTime(docente.fechaNac);
		String dia = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
		String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
		String anio = Integer.toString(c.get(Calendar.YEAR));

		textField_4.setText(dia);
		// mes
		textField_5.setText(anio);
		// anio
		textField_6.setText(mes);
		setComboBox_1Visible(true);
	}

	public boolean getComboBox_1Visible() {
		return comboBox_1.isVisible();
	}

	public void setComboBox_1Visible(boolean visible) {
		comboBox_1.setVisible(visible);
	}
}
