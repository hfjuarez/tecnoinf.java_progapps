package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import API.datatypes.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import API.*;

import java.awt.Dimension;

public class ConsultaEdicionCurso extends JInternalFrame {
	private JTable table;
	private String edicion;
	private ILogica interfaz = new BizcochoEnARG().getInterface();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEdicionCurso frame = new ConsultaEdicionCurso();
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
	public ConsultaEdicionCurso() {
		setTitle("Consulta edicion de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 527, 339);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 20, 310, 120);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInstitutos = new JLabel("Institutos");
		lblInstitutos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblInstitutos);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCursos);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel lblEdicionDeCurso = new JLabel("Edicion de curso");
		lblEdicionDeCurso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEdicionDeCurso);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_1.add(comboBox_2);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(20, 171, 364, 80);
		getContentPane().add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		table = new JTable();
		panel_8.add(table);
		table.setFont(new Font("Dialog", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre edicion", null},
				{"Fecha inicio", null},
				{"Fecha fin", null},
				{"Cupos", null},
				{"Docentes", null},
				//{"Estudiantes", null},
			},
			new String[] {
				"New column", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(192, 262, 117, 25);
		getContentPane().add(btnCerrar);
		
		JButton btnNewButton = new JButton("Refresh Instituto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<DTInstituto> insts = interfaz.listaInstitutos();
				for (DTInstituto inst : insts) {
					comboBox.addItem(inst.nombreInstituto);
				}
			}
		});
		btnNewButton.setBounds(380, 20, 120, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh Cursos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				List<DTCurso> cursos = interfaz.listaCursosPorInstituto(comboBox.getSelectedItem().toString());
				for (DTCurso curso : cursos) {
					comboBox_1.addItem(curso.nombreCurso);
				}
			}
		});
		btnNewButton_1.setBounds(380, 62, 120, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Refresh Edicion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2.removeAllItems();
				List<DTEdicionCurso> ediciones = interfaz.ListaEdicionesCurso(comboBox_1.getSelectedItem().toString());
				for (DTEdicionCurso edicion : ediciones) {
					comboBox_2.addItem(edicion.nombreEdicion);
				}
			}
		});
		btnNewButton_2.setBounds(380, 96, 120, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver datos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTEdicionCurso edicion = interfaz.obtenerEdicionCurso(comboBox_2.getSelectedItem().toString());
				List<DTDocente> ListaDocentes = edicion.docentes;
				List<String> docente = new ArrayList();
				for(DTDocente doc : ListaDocentes)
				{
					docente.add(doc.nickname);
				}
//				List<DTInscripcion_Edicion> ListaEstudiantes = edicion.inscriptos;
//				List<String> estudiante = new ArrayList();
//				for(DTInscripcion_Edicion est : ListaEstudiantes)
//				{
//					System.out.println(est.estudiante);
//					estudiante.add(est.estudiante.nickname);
//				}
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"Nombre edicion", edicion.nombreEdicion},
							{"Fecha inicio", edicion.fechaIncio.toString()},
							{"Fecha fin", edicion.fechaFin.toString()},
							{"Cupos", edicion.cupo},
							{"Docentes", docente},
							//{"Estudiantes", estudiante},
						},
						new String[] {
							"New column", ""
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
						boolean[] columnEditables = new boolean[] {
							false, true
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			}
		});
		btnNewButton_3.setBounds(393, 145, 89, 23);
		getContentPane().add(btnNewButton_3);

	}
	
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
}
