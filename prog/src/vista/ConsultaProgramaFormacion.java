package vista;
import API.*;
import logica.*;
import API.datatypes.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConsultaProgramaFormacion extends JInternalFrame {
	private DTFormacion programaElegido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String programa;
	private ILogica Interfaz = new BizcochoEnARG().getInterface();
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProgramaFormacion frame = new ConsultaProgramaFormacion();
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
	public ConsultaProgramaFormacion() {
		setTitle("Consulta de programa de formacion");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 576, 407);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 12, 400, 20);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblProgramasDeFormacion = new JLabel("Programas de formacion");
		lblProgramasDeFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProgramasDeFormacion);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JComboBox comboBox = new JComboBox();
//		comboBox.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				programa = e.getItem().toString();
//				List<DTFormacion> formaciones = Interfaz.consultaFormacion();
//				for(DTFormacion programa: formaciones) {
//					comboBox.addItem(programa.nombreFormacion);
//				}
//				for(DTFormacion form : formaciones) {
//					if(form.nombreFormacion.equals(programa)) {
//						programaElegido = form;
//					}
//				}
//				//Nombre
//					textField.setText(programaElegido.nombreFormacion);
//					//Fecha inicio
//					textField_1.setText(programaElegido.fechaInicio.toString());
//					//Fecha fin
//					textField_2.setText(programaElegido.fechaFin.toString());
//					//Descripcion
//					textArea.setText(programaElegido.descFormacion);
//			}
//		});
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(35, 59, 400, 100);
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNombre);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		panel_3.add(textArea);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblFechaInicio);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblFechaFin);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(318, 323, 117, 25);
		getContentPane().add(btnCerrar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(35, 171, 400, 140);
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Cursos");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 0;
		panel_5.add(comboBox_1, gbc_comboBox_1);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				List<DTFormacion> formaciones = Interfaz.consultaFormacion();
				for(DTFormacion formacion : formaciones)
				{
					comboBox.addItem(formacion.nombreFormacion);
				}
			}
		});
		btnNewButton.setBounds(461, 12, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver datos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				List<DTFormacion> formaciones = Interfaz.consultaFormacion();
				for(DTFormacion formacion : formaciones)
				{
					if(formacion.nombreFormacion.equals(comboBox.getSelectedItem().toString()))
					{
						Calendar c1 = Calendar.getInstance();
						c1.setTime(formacion.fechaInicio);
						String dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
						String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
						String anio = Integer.toString(c1.get(Calendar.YEAR));
						String dou=(dia + "-" + mes + "-" + anio);
						Calendar c = Calendar.getInstance();
						c1.setTime(formacion.fechaFin);
						String diaa = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
						String mess = Integer.toString(c.get(Calendar.MONTH) + 1);
						String anioo = Integer.toString(c.get(Calendar.YEAR));
						String douu=(diaa + "-" + mess + "-" + anioo);
						textField.setText(formacion.nombreFormacion);
						//Fecha inicio
						textField_1.setText(dou);
						//Fecha fin
						textField_2.setText(douu);
						//Descripcion
						textArea.setText(formacion.descFormacion);
						
						List<DTCurso> cursos = formacion.cursos;
						for(DTCurso curso : cursos)
						{
							comboBox_1.addItem(curso.nombreCurso);
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(461, 59, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ver curso");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTCurso curso = Interfaz.obtenerCurso(comboBox_1.getSelectedItem().toString());
				Calendar c1 = Calendar.getInstance();
				c1.setTime(curso.fechaAlta);
				String dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
				String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
				String anio = Integer.toString(c1.get(Calendar.YEAR));
				String dou=(dia + "-" + mes + "-" + anio);
				String categorias = "\nCategorias:";
				List<DTCategoria> cat = curso.categorias;
				for(DTCategoria c:cat) {
					categorias+=" " + c.nombreCategoria+" ";
				}
				JOptionPane.showMessageDialog(null,"Curso: "+curso.nombreCurso+"\n"+"Descripcion: "+curso.descCurso+"\n"+"Fecha alta: "+dou+"\n"+"Cantidad horas: "+curso.cantidadHoras+"Cantidad creditos: "+curso.cantidadCreditos+"\n"+"Duracion en semanas: "+curso.duracionMeses+ categorias);
			}
		});
		btnNewButton_2.setBounds(445, 171, 105, 23);
		getContentPane().add(btnNewButton_2);
		
		ArrayList<JButton> botones = new ArrayList<>();
//		List<DTCurso> cursos = listaCursos();
//		for(DTCurso curso: cursos) {
//			botones.add(new JButton(curso.nombreCurso));
//		}
		
		for(JButton boton: botones) {
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(boton.getLabel());
					ConsultaCurso cc = new ConsultaCurso();
					cc.setCurso(boton.getLabel());
					VentanaPrincipal.desktopPane.add(cc);
					cc.setVisible(true);
				}
			});
			panel_5.add(boton);
		}
		
	}
	
	private List<DTFormacion> listaProgramas() {
		List<DTFormacion> lista = Interfaz.consultaFormacion();
		return lista;
	}
	
	private List<DTCurso> listaCursos() {
		List<DTFormacion> lista = Interfaz.consultaFormacion();
		List<DTCurso> listaCursos = null;
		for(DTFormacion form:lista) {
			if(form.nombreFormacion.equals(programa)) {
				listaCursos = form.cursos;
			}
		}
		return listaCursos;
	}
	
	public void setPrograma(String programa) {
		this.programa = programa;
	}
}
