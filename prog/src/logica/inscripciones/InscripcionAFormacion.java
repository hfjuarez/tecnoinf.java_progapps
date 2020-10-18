package logica.inscripciones;

import logica.formaciones.ObtenerFormacion;
import logica.entidades.Formacion;
import logica.entidades.Estudiante;
import logica.entidades.Inscripcion_Formacion;
import logica.usuarios.ObtenerUsuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import API.datatypes.DTInscripcion_Formacion;

import java.sql.Date;
import java.util.*;

import logica.usuarios.ObtenerUsuario;

public class InscripcionAFormacion {
	Date FInscripcion;
	String NEstudiante;
	String NFormacion;

	public InscripcionAFormacion() {
	}

	public InscripcionAFormacion(String nombreEstudiante, Date FechaIns, String NFor) {
		NEstudiante = nombreEstudiante;
		FInscripcion = FechaIns;
		NFormacion = NFor;

	}

	public boolean existeInscripcion2(String nk, String ediCavani) {

		List<Inscripcion_Formacion> list = new ListaInscripcionesFor().getList();
		for (Inscripcion_Formacion inscripcion : list) {
			if ((inscripcion.getFormacionInsc().getNombreFormacion().equals(ediCavani))
					&& (inscripcion.getEstudiante().getNickname().equals(nk))) {
				return true;

			}
		}
		return false;
	}

	// public void cambiarestado(String solteroHastaLaTumba, String ediCavani,
	// String nik) {
	// System.out.println("aca estoy" + solteroHastaLaTumba + " " + ediCavani + " "
	// + nik);

	// // if (new InscripcionAEdicion().existeInscripcion2(nik, ediCavani)) {
	// System.out.println("aca me tenes");
	// List<Inscripcion_Formacion> list = null;
	// EntityManagerFactory emfactory =
	// Persistence.createEntityManagerFactory("InstitutoJPA");
	// EntityManager entitymanager = emfactory.createEntityManager();
	// entitymanager.getTransaction().begin();
	// Inscripcion_Formacion inss = null;

	// Query query = entitymanager.createQuery("Select i from Inscripcion_Formacion
	// as i");
	// list = (List<Inscripcion_Formacion>) query.getResultList();
	// for (Inscripcion_Formacion inscripcion : list) {
	// if ((inscripcion.getFormacionInsc().getNombreFormacion().equals(ediCavani))
	// && (inscripcion.getEstudiante().getNickname().equals(nik))) {
	// System.out.println("el rejjjaa");
	// inss = inscripcion;
	// inss.setEstado(solteroHastaLaTumba);
	// entitymanager.persist(inss);

	// }
	// }

	// entitymanager.getTransaction().commit();
	// entitymanager.close();
	// emfactory.close();
	// // }

	// }

	public boolean existeInscripcionFor() {

		List<Inscripcion_Formacion> list = new ListaInscripcionesFor().getList();
		for (Inscripcion_Formacion inscripcion : list) {
			if ((inscripcion.getFormacionInsc().getNombreFormacion().equals(NFormacion))
					&& (inscripcion.getEstudiante().getNickname().equals(NEstudiante))) {
				return true;

			}
		}

		return false;
	}

	public String inscripcion() {

		Estudiante es = null;

		if (NEstudiante.isEmpty()) {
			return "ERROR: El nombre del estudiante no debe estar vacio";
		}

		if (NFormacion.isEmpty()) {
			return "ERROR: El nombre de la formacion no debe ser vacio.";
		}

		ObtenerFormacion ObtForma = new ObtenerFormacion();
		Formacion forma = ObtForma.getFormacion(NFormacion);

		if (forma == null) {
			return "ERROR: La formacion no existe.";
		}

		ObtenerUsuario ObtUsuario = new ObtenerUsuario();

		if (ObtUsuario.isEstudiante(NEstudiante)) {
			es = ObtUsuario.getEstudianteByNickname(NEstudiante);
		} else {
			return "ERROR: El usuario no es un estudiante";
		}

		if (existeInscripcionFor()) {
			return "ERROR: Ya se inscribio a esta edicion";
		}

		// ------------------------------------
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Inscripcion_Formacion InscEdc = new Inscripcion_Formacion(forma, es, FInscripcion);

//		List<Inscripcion_Formacion> inscriptosE = forma.getInscriptos();
//		if (inscriptosE == null) {
//			inscriptosE = new ArrayList<Inscripcion_Formacion>();
//		}
//
//		inscriptosE.add(InscEdc);
//		forma.setInscriptos(inscriptosE);
//		// entitymanager.persist(forma);
//
//		List<Inscripcion_Formacion> inscripciones = es.getInscFormacion();
//		if (inscripciones == null) {
//			inscripciones = new ArrayList<Inscripcion_Formacion>();
//		}
//		inscripciones.add(InscEdc);
//		es.setInscFormacion(inscripciones);
		// entitymanager.persist(es);

		entitymanager.persist(InscEdc);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

		return "";
	}
}