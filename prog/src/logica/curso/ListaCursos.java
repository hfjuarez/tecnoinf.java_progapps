package logica.curso;

import java.util.List;
import java.util.ArrayList;
import logica.entidades.Curso;
import logica.datatypes.DTCurso;

import javax.persistence.*;

public class ListaCursos {
    public List<Curso> getList() {
        List<Curso> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Curso as i");
        list = (List<Curso>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;

    }

    public List<DTCurso> getDataTypeList() {
        List<Curso> list = getList();
        List<DTCurso> listOfDT = new ArrayList();
        for (Curso curso : list) {
            DTCurso dtCurso = new DTCurso(curso);
            listOfDT.add(dtCurso);
        }
        return listOfDT;
    }
}
