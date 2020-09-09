package logica.curso;

import logica.datatypes.DTEdicionCurso;
import logica.entidades.EdicionCurso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObtenerEdicionCurso {

    public EdicionCurso getEdicionCurso(String name) {

        ExisteEdicionCurso existeCurso = new ExisteEdicionCurso();
        if (existeCurso.existeNombreCur(name)) {
            Curso ret = new Curso();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
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
