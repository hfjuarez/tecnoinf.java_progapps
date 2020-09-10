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
		setBounds(100, 100, 483, 408);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 12, 400, 35);
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
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(45, 59, 380, 120);
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_3.add(lblNombre);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		panel_3.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		panel_3.add(textArea);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		panel_3.add(lblFechaInicio);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		panel_3.add(lblFechaFin);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JTree tree = new JTree();
		tree.setBounds(64, 203, 356, 139);
		getContentPane().add(tree);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Cursos") {
				{
					add(new DefaultMutableTreeNode("curso1"));
					add(new DefaultMutableTreeNode("curso2"));
					add(new DefaultMutableTreeNode("curso3"));
					add(new DefaultMutableTreeNode("curso4"));
				}
			}
		));

	}
}
