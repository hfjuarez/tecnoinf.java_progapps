package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
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

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class ConsultaProgramaFormacion extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 468, 392);
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
		comboBox.addItem("");
		for(String programa: listaProgramas()) {
			comboBox.addItem(programa);
		}
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
		
		JTextArea textArea = new JTextArea();
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
		panel_5.setLayout(new GridLayout(10, 1, 0, 0));
		
		ArrayList<JButton> botones = new ArrayList<>();
		for(String curso: listaCursos()) {
			botones.add(new JButton(curso));
		}
		
		for(JButton boton: botones) {
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(boton.getLabel());
				}
			});
			panel_5.add(boton);
		}
		
	}
	
	private ArrayList<String> listaProgramas() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Programa 1");
		lista.add("Programa 2");
		lista.add("Programa 3");
		lista.add("Programa 4");
		lista.add("Programa 5");
		lista.add("Programa 6");
		return lista;
	}
	
	private ArrayList<String> listaCursos() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Curso 1");
		lista.add("Curso 2");
		lista.add("Curso 3");
		lista.add("Curso 4");
		return lista;
	}
}
