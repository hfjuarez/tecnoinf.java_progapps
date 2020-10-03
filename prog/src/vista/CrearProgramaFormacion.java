package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import java.awt.GridBagConstraints;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import API.*;

import javax.swing.JTextArea;
import java.sql.Date;

public class CrearProgramaFormacion extends JInternalFrame {
	private JTextField textField;
	private ILogica Interfaz = new BizcochoEnARG().getInterface();
	JFileChooser jf = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
	File imagen = null;
	// private Date fechaInicio = null;
	// private Date fechaFin = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProgramaFormacion frame = new CrearProgramaFormacion();
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
	public CrearProgramaFormacion() {
		setTitle("Crear programa de formacion");
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 400, 275);
		getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 10, 10);
		getContentPane().add(panel_4);

		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 350, 200);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNombre);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblDescripcion);

		JTextArea textArea = new JTextArea();
		panel_2.add(textArea);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);

		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		panel_8.add(lblFechaInicio);

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 3, 0, 0));

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(31), new Integer(1)));
		panel_9.add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(12), new Integer(1)));
		panel_9.add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(
				new SpinnerNumberModel(new Integer(2020), new Integer(2020), new Integer(2050), new Integer(1)));
		panel_9.add(spinner_2);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);

		JLabel lblFechaFin = new JLabel("Fecha fin");
		panel_10.add(lblFechaFin);

		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 3, 0, 0));

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(31), new Integer(1)));
		panel_11.add(spinner_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(12), new Integer(1)));
		panel_11.add(spinner_4);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(
				new SpinnerNumberModel(new Integer(2020), new Integer(2020), new Integer(2050), new Integer(1)));
		panel_11.add(spinner_5);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_13 = new JPanel();
		panel_6.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblEmpty = new JLabel("Empty");
		lblEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblEmpty);
		
		JButton btnAgregarImage = new JButton("Agregar image");
		btnAgregarImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r;
				JFileChooser jf = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
				jf.setFileFilter(filter);
				r = jf.showOpenDialog(CrearProgramaFormacion.this);
				if (r == JFileChooser.APPROVE_OPTION) {
					imagen = jf.getSelectedFile();
					lblEmpty.setText(imagen.getName());
				} else {
					System.err.println("Te falta calle.");
				}
			}
		});
		panel_6.add(btnAgregarImage);

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_15 = new JPanel();
		panel_7.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancelar");
				dispose();
			}
		});
		panel_15.add(btnCancelar);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Calendar c = Calendar.getInstance();
				String dia = Integer.toString(c.get(Calendar.DATE));
				String mes = Integer.toString(c.get(Calendar.MONTH));
				String annio = Integer.toString(c.get(Calendar.YEAR));
				Date FechaAlta = Date.valueOf(annio + "-" + mes + "-" + dia);

				Date FechaIni = Date.valueOf(spinner_2.getValue().toString() + "-" + spinner_1.getValue().toString()
						+ "-" + spinner.getValue().toString());

				Date FechaFin = Date.valueOf(spinner_5.getValue().toString() + "-" + spinner_4.getValue().toString()
						+ "-" + spinner_3.getValue().toString());

				String nombreFormacion = textField.getText();
				String descr = textArea.getText();

				String pp = "";

				pp = Interfaz.crearFormacion(nombreFormacion, descr, FechaIni, FechaFin, FechaAlta,imagen);
				if (pp.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Se ha agregado el programa formacion con nombre: " + nombreFormacion);
					textField.setText("");
					textArea.setText("");
				} else {
					JOptionPane.showMessageDialog(null, pp);
				}

			}
		});
		panel_15.add(btnAceptar);

	}

	public boolean existeFormCur(String nombreFormacion) {
		boolean ret = true;

		return ret;
	}
}
