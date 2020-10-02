package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import API.datatypes.*;
import API.*;

import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class ConsultaCurso extends JInternalFrame {
	private String curso;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ILogica interfaz = new BizcochoEnARG().getInterface();
	DTCurso cursito;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCurso frame = new ConsultaCurso();
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
	public ConsultaCurso() {
		setTitle("Consulta de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 617, 470);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 350, 81);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel = new JLabel("Instituto");
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		comboBox.addItem("");
		List<DTInstituto> insts = interfaz.listaInstitutos();
		for (DTInstituto inst : insts) {
			comboBox.addItem(inst.nombreInstituto);
		}
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Curso");
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem(this.curso);
		panel.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(30, 125, 350, 150);
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_3.add(lblNombre);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		panel_3.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		panel_3.add(textArea);
		
		JLabel lblDuracion = new JLabel("Duracion");
		panel_3.add(lblDuracion);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas");
		panel_3.add(lblCantidadDeHoras);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de creditos");
		panel_3.add(lblCantidadDeCreditos);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUrl = new JLabel("Url");
		panel_3.add(lblUrl);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblF = new JLabel("Fecha de alta");
		panel_3.add(lblF);
		
		textField_5 = new JTextField();
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(30, 282, 525, 100);
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblEdicionDeCurso = new JLabel("Edicion de curso");
		lblEdicionDeCurso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblEdicionDeCurso);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_5.add(comboBox_2);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		
		JLabel lblProgramaDeFormacion = new JLabel("Programa de formacion");
		lblProgramaDeFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblProgramaDeFormacion);
		
		JComboBox comboBox_3 = new JComboBox();
		panel_6.add(comboBox_3);
		
		JButton btnNewButton = new JButton("Ver edicion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTEdicionCurso edicion = interfaz.obtenerEdicionCurso(comboBox_2.getSelectedItem().toString());
				Calendar c1 = Calendar.getInstance();
				c1.setTime(edicion.fechaAltaEdicion);
				String dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
				String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
				String anio = Integer.toString(c1.get(Calendar.YEAR));
				String dou=(dia + "-" + mes + "-" + anio);
				JOptionPane.showMessageDialog(null,"Nombre edicion: "+edicion.nombreEdicion+"\n"+"Curso: "+edicion.curso.nombreCurso+"\n"+"Cupos: "+edicion.cupo+"\n"+"Fecha alta: "+dou);
			}
		});
		panel_5.add(btnNewButton);
		
		JLabel label = new JLabel("");
		panel_5.add(label);
				
		JButton btnNewButton_1 = new JButton("Ver formacion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<DTFormacion> formaciones = interfaz.consultaFormacion();
				for(DTFormacion formacion : formaciones)
				{
					if(formacion.nombreFormacion.equals(comboBox_3.getSelectedItem().toString()))
					{
						Calendar c1 = Calendar.getInstance();
						c1.setTime(formacion.fechaAlta);
						String dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
						String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
						String anio = Integer.toString(c1.get(Calendar.YEAR));
						String dou=(dia + "-" + mes + "-" + anio);
						JOptionPane.showMessageDialog(null,"Nombre: "+formacion.nombreFormacion+"\n"+"Descripcion: "+formacion.descFormacion+"\n"+"Fecha alta: "+dou);
					}
					
				}
			}
		});
		panel_6.add(btnNewButton_1);
				
				JLabel label_1 = new JLabel("");
				panel_6.add(label_1);
				
				
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(263, 401, 117, 25);
		getContentPane().add(btnCerrar);
		
		JButton btnNewButton_3 = new JButton("Ver Cursos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				List<DTCurso> cursoos = interfaz.listaCursosPorInstituto(comboBox.getSelectedItem().toString());
				for (DTCurso curso : cursoos) {
					comboBox_1.addItem(curso.nombreCurso);
				}
			}
		});
		btnNewButton_3.setBounds(408, 88, 123, 23);
		getContentPane().add(btnNewButton_3);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblCategorias);
		
		JComboBox comboBox_4 = new JComboBox();
		panel_9.add(comboBox_4);
		
		JButton btnNewButton_4 = new JButton("Ver datos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				comboBox_4.removeAllItems();
				cursito = interfaz.obtenerCurso(comboBox_1.getSelectedItem().toString());
				textField.setText(cursito.nombreCurso);
				textArea.setText(cursito.descCurso);
				textField_1.setText(cursito.duracionMeses + "");
				textField_2.setText(cursito.cantidadHoras + "");
				textField_3.setText(cursito.cantidadCreditos + "");
				textField_4.setText(cursito.URL);
				Calendar c = Calendar.getInstance();
				c.setTime(cursito.fechaAlta);
				String dia = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
				String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
				String anio = Integer.toString(c.get(Calendar.YEAR));
				textField_5.setText(dia + "-" + mes + "-" + anio);
				List<DTEdicionCurso> ediciones = interfaz.ListaEdicionesCurso(cursito.nombreCurso);
				for(DTEdicionCurso edicion : ediciones)
				{
					comboBox_2.addItem(edicion.nombreEdicion);
				}
				List<DTFormacion> formaciones = interfaz.consultaFormacion();
				for(DTFormacion formacion : formaciones)
				{
					List<DTCurso> cursovichs = formacion.cursos;
					for(DTCurso cursovich : cursovichs)
					{
						if(cursovich.nombreCurso.equals(cursito.nombreCurso)) {
							comboBox_3.addItem(formacion.nombreFormacion);
						}
					}
				}
				Boolean esta = false;
				String testo = "";
				List<DTCategoria> categorias = cursito.categorias;
				for(DTCategoria cate: categorias) {
					comboBox_4.addItem(cate.nombreCategoria);
				}
			}
		});
		btnNewButton_4.setBounds(408, 159, 123, 23);
		getContentPane().add(btnNewButton_4);
		
		JPanel panel_7 = new JPanel();
		panel_9.add(panel_7);
		
		JLabel label_2 = new JLabel("");
		panel_9.add(label_2);
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
}
