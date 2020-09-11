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
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaEdicionCurso extends JInternalFrame {
	private JTable table;
	private String edicion;

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
		setBounds(100, 100, 410, 353);
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
		panel_8.setBounds(20, 171, 350, 80);
		getContentPane().add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre edicion", null},
				{"Fecha inicio", null},
				{"Fecha fin", null},
				{"Cupos", null},
				{"Docentes", null},
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
		table.getColumnModel().getColumn(0).setResizable(false);
		panel_8.add(table);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(254, 274, 117, 25);
		getContentPane().add(btnCerrar);

	}
	
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
}
