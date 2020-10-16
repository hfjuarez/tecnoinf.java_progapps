package logica.edicioncursos;

import logica.entidades.EdicionCurso;
import logica.entidades.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import API.datatypes.DTEdicionCurso;

public class ObtenerEdicionCurso {

    public EdicionCurso getEdicionCurso(String name) {

        ExisteEdicionCurso existeCurso = new ExisteEdicionCurso();
        if (existeCurso.existeNombreCur(name)) {
            EdicionCurso ret = new EdicionCurso();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            ret = entitymanager.find(EdicionCurso.class, name);
            entitymanager.close();
            emfactory.close();
            return ret;

        } else {
            return null;
        }

    }

    public DTEdicionCurso getDTEdicionCurso(String name) {
        EdicionCurso curso = getEdicionCurso(name);
        return new DTEdicionCurso(curso);
    }
}
