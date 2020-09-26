package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.Date;

import java.util.List;
import API.datatypes.*;
import API.*;

public class AltaCurso extends JInternalFrame {
	private String instituto;
	private JTextField textField;
	private JTextField textField_4;
	private final JButton btnNewButton = new JButton("Cancelar");
	private JTextField textField_8;
	public static ArrayList<String> previas = new ArrayList<>();
	public static ArrayList<String> categorias = new ArrayList<>();
	private ListaCursos listaCursos = null;
	private ListaCategoria listaCat = null;
	private ILogica Interfaz = new BizcochoEnARG().getInterface();
	private List<DTCurso> listaDTCursos;
	private List<DTInstituto> ListaInstitutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCurso frame = new AltaCurso();
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
	public AltaCurso() {
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Alta de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 540, 407);
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblInstituto);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				instituto = e.getItem().toString();
			}
		});
		List<DTInstituto> ListaInstituto = Interfaz.listaInstitutos();
		for (DTInstituto instituto : ListaInstituto) {
			comboBox.addItem(instituto.nombreInstituto);
		}
		getContentPane().add(comboBox);

		JLabel lblCursos = new JLabel("Nombre curso");
		lblCursos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCursos);

		textField = new JTextField();
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDescripcion);

		textField_8 = new JTextField();
		getContentPane().add(textField_8);
		textField_8.setColumns(10);

		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDuracion);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), new Integer(100), new Integer(1)));
		getContentPane().add(spinner_3);

		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas");
		lblCantidadDeHoras.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCantidadDeHoras);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), new Integer(300), new Integer(1)));
		getContentPane().add(spinner_4);

		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de creditos");
		lblCantidadDeCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCantidadDeCreditos);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), new Integer(100), new Integer(1)));
		getContentPane().add(spinner_5);

		JLabel lblUrl = new JLabel("Url");
		lblUrl.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblUrl);

		textField_4 = new JTextField();
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha de alta");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(31), new Integer(1)));
		panel.add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(12), new Integer(1)));
		panel.add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(
				new SpinnerNumberModel(new Integer(2020), new Integer(2020), new Integer(2050), new Integer(1)));
		panel.add(spinner_2);

		JLabel lblPrevias = new JLabel("Previaturas");
		lblPrevias.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPrevias);

		JButton btnNewButton_1 = new JButton("Agregar previas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<String> cursos = new ArrayList<>();
				listaDTCursos = Interfaz.ListaCursos();
				for (DTCurso cur : listaDTCursos) {
					cursos.add(cur.nombreCurso);
				}

				if (listaCursos == null) {
					listaCursos = new ListaCursos(cursos);
					VentanaPrincipal.desktopPane.add(listaCursos);
				}
				listaCursos.setVisible(true);
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCategorias);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		
		JButton btnNewButton_1_1 = new JButton("Agregar categorias");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<DTCategoria> todasCategorias = Interfaz.listaCat();
				
				if(listaCat == null) {
					listaCat = new ListaCategoria(todasCategorias);
					VentanaPrincipal.desktopPane.add(listaCat);
				}
				listaCat.setVisible(true);
			}
		});
		getContentPane().add(btnNewButton_1_1);
		
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String  nombre = textField.getText();
						String  descripcion = textField_8.getText();
						int 	duracion = Integer.parseInt( spinner_3.getValue().toString());
						int  cantHs = Integer.parseInt( spinner_4.getValue().toString());
						int cantCred = Integer.parseInt( spinner_5.getValue().toString());
						String url = textField_4.getText();
						Date Fecha = Date.valueOf(spinner_2.getValue().toString() + "-" + spinner_1.getValue().toString() + "-"
								+ spinner.getValue().toString());
						List<String> prevs = previas;

						if(!nombre.equals("") && !descripcion.equals("") && !url.equals("") ) {
							String xd = Interfaz.crearCurso(nombre, descripcion, duracion,cantHs, cantCred, url, Fecha, prevs,
									comboBox.getSelectedItem().toString(),categorias);
							if (xd.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Se ha agregado el curso con nombre: " + textField.getText());
								textField.setText("");
								spinner_3.setValue(new Integer(1));
								spinner_4.setValue(new Integer(1));
								spinner_5.setValue(new Integer(1));
								textField_4.setText("");
								textField_8.setText("");

							} else {
								JOptionPane.showMessageDialog(null, xd);
							}
							textField.setText("");
						}else {
							JOptionPane.showMessageDialog(null, "No pueden haber campos vacios");
						}
						
						
						

					}
				});
				
				
				getContentPane().add(btnAceptar);
		getContentPane().add(btnNewButton);

	}

}
