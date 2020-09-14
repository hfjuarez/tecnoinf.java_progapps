package logica.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import logica.entidades.Curso;

public class ExisteCurso {

    public boolean existeNombreCur(String nombreCurso) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Curso est = null;
        est = entitymanager.find(Curso.class, nombreCurso);

        if (est != null ) {
            ret = true;
        }
        entitymanager.close();
        emfactory.close();
        return ret;
    }

}