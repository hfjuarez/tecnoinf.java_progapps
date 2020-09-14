package logica.edicioncurso;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import logica.entidades.Inscripcion_Edicion;
import logica.datatypes.*;

public class ListaInscripciones {

    public List<Inscripcion_Edicion> getList() {
        List<Inscripcion_Edicion> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Inscripcion_Edicion as i");
        list = (List<Inscripcion_Edicion>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;
    }

    public List<DTInscripcion_Edicion> getDTlist() {
        List<Inscripcion_Edicion> list = getList();
        List<DTInscripcion_Edicion> dtlist = new ArrayList();
        for (Inscripcion_Edicion i : list) {
            DTInscripcion_Edicion ins = new DTInscripcion_Edicion(i);
            dtlist.add(ins);
        }
        return dtlist;

    }
}

