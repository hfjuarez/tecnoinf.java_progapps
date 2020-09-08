package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaEdicionCurso extends JInternalFrame {
	private JTextField textField;
	private ArrayList<String> docentesAgregados=null;
	private ListaDocentes listaDocentes = null;

	/**
	 * Create the frame.
	 */
	public AltaEdicionCurso() {
		setTitle("Alta edicion de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 372, 357);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 300, 25);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.LEFT);		
		panel.add(lblInstituto);
		
		JComboBox comboBox = new JComboBox();
		ArrayList<String> institutos = getInstitutos();
		comboBox.addItem("");
		for(String instituto: institutos) {
			comboBox.addItem(instituto);
		}
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String eleccion = arg0.getItem().toString();
				System.out.println(eleccion);
			}
		});
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 67, 300, 25);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
			}
		});
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 107, 300, 100);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombreEdicion = new JLabel("Nombre edicion");
		lblNombreEdicion.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNombreEdicion);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblFechaInicio);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JSpinner spinner_4 = new JSpinner();
		panel_3.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		panel_3.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		panel_3.add(spinner_6);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblFechaFin);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		JSpinner spinner_1 = new JSpinner();
		panel_4.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		panel_4.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		panel_4.add(spinner_3);
		
		JLabel lblCuposopcional = new JLabel("Cupos (Opcional)");
		lblCuposopcional.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCuposopcional);
		
		JSpinner spinner = new JSpinner();
		panel_2.add(spinner);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(30, 219, 300, 25);
		getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblProfesores = new JLabel("Docentes");
		lblProfesores.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblProfesores);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaDocentes == null) {
					listaDocentes = new ListaDocentes();
					VentanaPrincipal.desktopPane.add(listaDocentes);
					listaDocentes.setVisible(true);
				}else {
					listaDocentes.setVisible(true);
				}				
			}
		});
		panel_5.add(btnAgregar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				docentesAgregados = listaDocentes.getDocentesSeleccionados();
				
				
				JOptionPane.showMessageDialog(null, "Se guarda datos");
				resetDatos();
			}
		});
		btnAceptar.setBounds(208, 273, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(67, 273, 117, 25);
		getContentPane().add(btnCancelar);

	}
	
	private void resetDatos() {
		docentesAgregados.clear();
	}
	
	private ArrayList<String> getInstitutos(){
		ArrayList<String> lista = new ArrayList<>();
		lista.add("instituto 1");
		lista.add("instituto 2");
		lista.add("instituto 3");
		lista.add("instituto 4");
		lista.add("instituto 5");
		lista.add("instituto 6");
		return lista;
	} 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaEdicionCurso frame = new AltaEdicionCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
