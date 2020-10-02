package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import API.BizcochoEnARG;
import API.ILogica;

import API.datatypes.*;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AgregarCursoAProgramaFormacion extends JInternalFrame {

	private ILogica Interfaz = new BizcochoEnARG().getInterface();
	private String formacion;
	private String curso;
	private List<DTFormacion> ListaFormacion;
	private List<DTCurso> ListaCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCursoAProgramaFormacion frame = new AgregarCursoAProgramaFormacion();
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
	public AgregarCursoAProgramaFormacion() {
		setTitle("Agregar curso aprograma de formacion");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 440, 206);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(38, 25, 350, 90);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblProgramaDeFormacion = new JLabel("Programa de formacion");
		panel_1.add(lblProgramaDeFormacion);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		ListaFormacion = Interfaz.consultaFormacion();
		for (DTFormacion formacion : ListaFormacion) {
			comboBox.addItem(formacion.nombreFormacion);
		}
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				formacion = e.getItem().toString();
			}
		});
		panel_1.add(comboBox);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		JLabel lblNewLabel = new JLabel("Cursos");
		panel_1.add(lblNewLabel);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("");
		ListaCurso = Interfaz.ListaCursos();
		for (DTCurso curso : ListaCurso) {
			comboBox_1.addItem(curso.nombreCurso);

		}
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curso = e.getItem().toString();
			}
		});
		panel_1.add(comboBox_1);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(curso!=null && formacion!=null) {
					List<String> curso1 = new ArrayList();
					curso1.add(curso);
					String pp = Interfaz.AgregoCurEnForm(comboBox.getSelectedItem().toString(), curso1);
					if (pp.isEmpty()) {

						System.out.println("Se agrego: " + formacion + " " + curso);
						JOptionPane.showInternalMessageDialog(VentanaPrincipal.desktopPane, "Se agrego el curso correctamente.");

					} else {
						JOptionPane.showInternalMessageDialog(VentanaPrincipal.desktopPane, pp);

					}
				}
			}

		});
		btnAceptar.setBounds(271, 131, 117, 25);
		getContentPane().add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(95, 131, 117, 25);
		getContentPane().add(btnCancelar);

	}
}
