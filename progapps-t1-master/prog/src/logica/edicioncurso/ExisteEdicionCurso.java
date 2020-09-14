package logica.edicioncurso;

import logica.entidades.EdicionCurso;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExisteEdicionCurso {
    public boolean existeNombreCur(String nombreEdicionCurso) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        EdicionCurso est = null;
        est = entitymanager.find(EdicionCurso.class, nombreEdicionCurso);

        if (est != null) {
            ret = true;
        }
        entitymanager.close();
        emfactory.close();
        return ret;
    }
}
