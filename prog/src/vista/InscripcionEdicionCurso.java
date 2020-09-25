package vista;

import java.awt.EventQueue;

import API.*;
import API.datatypes.*;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class InscripcionEdicionCurso extends JInternalFrame {
	private ILogica interfaz = new BizcochoEnARG().getInterface(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionEdicionCurso frame = new InscripcionEdicionCurso();
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
	public InscripcionEdicionCurso() {
		setTitle("Inscripcion a edicion de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 597, 368);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 12, 350, 250);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblInstituto);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblEdicion = new JLabel("Edicion");
		lblEdicion.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEdicion);
		
		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblEstudiante = new JLabel("Estudiante");
		lblEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEstudiante);
		
		JComboBox comboBox_3 = new JComboBox();
		panel.add(comboBox_3);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha inscripcion");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 3, 0, 0));
		
		JSpinner spinner = new JSpinner();
		panel_10.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		panel_10.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		panel_10.add(spinner_2);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date fechaIni = Date.valueOf(spinner_2.getValue().toString() + "-" + spinner_1.getValue().toString()
						+ "-" + spinner.getValue().toString());
				if(!(comboBox_1.getSelectedItem().toString().equals(""))) {
					String ret = interfaz.regInscDeUsrEnCurso(comboBox_3.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString(), fechaIni);
					if (ret.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Se ha registrado al estudiante con el nickname: " + comboBox_3.getSelectedItem().toString());
						comboBox.removeAllItems();
						comboBox_1.removeAllItems();
						comboBox_2.removeAllItems();
						comboBox_3.removeAllItems();
					} else {
						JOptionPane.showMessageDialog(null, ret);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR: No se ha selecionado un curso");
				}
				
			}
		});
		btnAceptar.setBounds(212, 287, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(83, 287, 117, 25);
		getContentPane().add(btnCancelar);
		
		JButton btnNewButton = new JButton("Refesh Estudiante");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_3.removeAllItems();
				List<DTEstudiante> estudiantes = interfaz.listaEstudiantes();
				for (DTEstudiante estudiante : estudiantes) {
					comboBox_3.addItem(estudiante.nickname);
				}
				
			}
		});
		btnNewButton.setBounds(421, 166, 129, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh Edicion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2.removeAllItems();
				List<DTEdicionCurso> ediciones = interfaz.ListaEdicionesCurso(comboBox_1.getSelectedItem().toString());
				for (DTEdicionCurso edicion : ediciones) {
					comboBox_2.addItem(edicion.nombreEdicion);
				}
			}
		});
		btnNewButton_1.setBounds(421, 112, 129, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Refresh Curso");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				List<DTCurso> cursos = interfaz.listaCursosPorInstituto(comboBox.getSelectedItem().toString());
				for (DTCurso curso : cursos) {
					comboBox_1.addItem(curso.nombreCurso);
				}
			}
		});
		btnNewButton_2.setBounds(421, 62, 129, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Refresh Instituto");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				List<DTInstituto> insts = interfaz.listaInstitutos();
				for (DTInstituto inst : insts) {
					comboBox.addItem(inst.nombreInstituto);
				}
			}
		});
		btnNewButton_3.setBounds(421, 12, 129, 23);
		getContentPane().add(btnNewButton_3);

	}
}

