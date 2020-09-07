package logica.edicioncurso;

import logica.entidades.Curso;
import logica.entidades.EdicionCurso;
import logica.entidades.Estudiante;
import logica.entidades.Inscripcion_Edicion;
import logica.usuarios.ObtenerUsuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.sql.Date;
import java.util.*;
import logica.curso.ObtenerCurso;
import logica.usuarios.ObtenerUsuario;

public class InscripcionAEdicion {
    Date FInscripcion;
    String NEstudiante;
    String NEdicion;

    public InscripcionAEdicion(String nombreEstudiante, Date FechaIns, String Edicion) {
        NEstudiante = nombreEstudiante;
        FInscripcion = FechaIns;
        NEdicion = Edicion;

    }

    public String inscripcion() {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Estudiante es;

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

        Inscripcion_Edicion InscEdc = new Inscripcion_Edicion(edicion, es, FInscripcion);

        entitymanager.persist(InscEdc);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();

        return "";
    }
}