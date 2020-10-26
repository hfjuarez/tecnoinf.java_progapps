package logica.inscripciones;

import logica.cursos.ObtenerCurso;
import logica.edicioncursos.ObtenerEdicionCurso;
import logica.entidades.Curso;
import logica.entidades.EdicionCurso;
import logica.entidades.Estudiante;
import logica.entidades.Inscripcion_Edicion;
import logica.usuarios.ObtenerUsuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import API.datatypes.DTInscripcion_Edicion;

import java.sql.Date;
import java.util.*;

import logica.usuarios.ObtenerUsuario;

public class InscripcionAEdicion {
	Date FInscripcion;
	String NEstudiante;
	String NEdicion;
	String urlVideo;

	public InscripcionAEdicion() {
	}

	public InscripcionAEdicion(String nombreEstudiante, Date FechaIns, String Edicion, String urlVideo) {
		NEstudiante = nombreEstudiante;
		FInscripcion = FechaIns;
		NEdicion = Edicion;
		this.urlVideo = urlVideo;
	}

	public boolean existeCupo() {

		EdicionCurso edicionCurso = new ObtenerEdicionCurso().getEdicionCurso(NEdicion);
		int cupo = edicionCurso.getCupo();
		if (cupo <= 0) {
			return true;
		} else {
			List<DTInscripcion_Edicion> listaInscripciones = new ListaInscripciones().getDTlistPorEdicion(NEdicion);
			int count = 0;
			for (DTInscripcion_Edicion ie : listaInscripciones) {
				if (!ie.estado.equals("Rechazado")) {
					count++;
				}
			}
			if (count < cupo) {
				return true;
			} else {
				return false;
			}

		}
	}

	public boolean existeInscripcion2(String nk, String ediCavani) {

		List<Inscripcion_Edicion> list = new ListaInscripciones().getList();
		for (Inscripcion_Edicion inscripcion : list) {
			if ((inscripcion.getEdicionCurso().getNombreEdicion().equals(ediCavani))
					&& (inscripcion.getEstudiante().getNickname().equals(nk))) {
				return true;

			}
		}
		return false;
	}

	public void asignarNota(int nota, String ediCavani, String nik) {
		List<Inscripcion_Edicion> list = null;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Inscripcion_Edicion inss = null;

		Query query = entitymanager.createQuery("Select i from Inscripcion_Edicion as i");
		list = (List<Inscripcion_Edicion>) query.getResultList();
		for (Inscripcion_Edicion inscripcion : list) {
			if ((inscripcion.getEdicionCurso().getNombreEdicion().equals(ediCavani))
					&& (inscripcion.getEstudiante().getNickname().equals(nik))) {
				inss = inscripcion;
				inss.setNota(nota);
				entitymanager.persist(inss);

			}
		}

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		// }

	}

	public void cambiarestado(String solteroHastaLaTumba, String ediCavani, String nik) {
		System.out.println("aca estoy" + solteroHastaLaTumba + " " + ediCavani + " " + nik);

		// if (new InscripcionAEdicion().existeInscripcion2(nik, ediCavani)) {
		System.out.println("aca me tenes");
		List<Inscripcion_Edicion> list = null;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Inscripcion_Edicion inss = null;

		Query query = entitymanager.createQuery("Select i from Inscripcion_Edicion as i");
		list = (List<Inscripcion_Edicion>) query.getResultList();
		for (Inscripcion_Edicion inscripcion : list) {
			if ((inscripcion.getEdicionCurso().getNombreEdicion().equals(ediCavani))
					&& (inscripcion.getEstudiante().getNickname().equals(nik))) {
				System.out.println("el rejjjaa");
				inss = inscripcion;
				inss.setEstado(solteroHastaLaTumba);
				entitymanager.persist(inss);

			}
		}

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		// }

	}

	public boolean existeInscripcion() {

		List<Inscripcion_Edicion> list = new ListaInscripciones().getList();
		for (Inscripcion_Edicion inscripcion : list) {
			if ((inscripcion.getEdicionCurso().getNombreEdicion().equals(NEdicion))
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

		if (NEdicion.isEmpty()) {
			return "ERROR: El nombre de la edicion no debe ser vacio.";
		}

		ObtenerEdicionCurso ObtEdicion = new ObtenerEdicionCurso();
		EdicionCurso edicion = ObtEdicion.getEdicionCurso(NEdicion);

		if (edicion == null) {
			return "ERROR: La edicion no existe.";
		}

		ObtenerUsuario ObtUsuario = new ObtenerUsuario();

		if (ObtUsuario.isEstudiante(NEstudiante)) {
			es = ObtUsuario.getEstudianteByNickname(NEstudiante);
		} else {
			return "ERROR: El usuario no es un estudiante";
		}

		if (!existeCupo()) {
			return "ERROR: No existen cupos disponibles, para la edicion";
		}

		if (existeInscripcion()) {
			return "ERROR: Ya se inscribio a esta edici�n";
		}

		// ------------------------------------
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Inscripcion_Edicion InscEdc = new Inscripcion_Edicion(edicion, es, FInscripcion, urlVideo);

		List<Inscripcion_Edicion> inscriptosE = edicion.getInscriptos();
		if (inscriptosE == null) {
			inscriptosE = new ArrayList<Inscripcion_Edicion>();
		}

		inscriptosE.add(InscEdc);
		edicion.setInscriptos(inscriptosE);

		List<Inscripcion_Edicion> inscripciones = es.getInscripciones();
		if (inscripciones == null) {
			inscripciones = new ArrayList<Inscripcion_Edicion>();
		}
		inscripciones.add(InscEdc);
		es.setInscripciones(inscripciones);

		entitymanager.persist(InscEdc);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

		return "";
	}
}