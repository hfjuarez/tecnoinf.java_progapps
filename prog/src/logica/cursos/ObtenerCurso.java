package logica.cursos;

import logica.entidades.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import API.datatypes.DTCurso;

public class ObtenerCurso {

    public Curso getCurso(String name) {

        ExisteCurso existeCurso = new ExisteCurso();
        if (existeCurso.existeNombreCur(name)) {
            Curso ret = new Curso();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            ret = entitymanager.find(Curso.class, name);
            entitymanager.close();
            emfactory.close();
            return ret;

        } else {
            return null;
        }

    }

    public DTCurso getDTCurso(String name) {
        Curso curso = getCurso(name);
        return new DTCurso(curso);
    }
}
