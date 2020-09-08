package logica.formacion;

import java.util.List;
import java.util.ArrayList;
import logica.entidades.Formacion;
import logica.datatypes.DTFormacionCurso;

import javax.persistence.*;

public class ListaFormacion {
    public List<Formacion> getList() {
        List<Formacion> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FormacionJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Formacion as i");
        list = (List<Formacion>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;

    }

    public List<DTFormacion> getDataTypeList() {
        List<Formacion> list = getList();
        List<DTFormacion> listOfDT = new ArrayList();
        for (Formacion formacion : list) {
            DTFormacion dtFormacion = new DTFormacion(formacion);
            listOfDT.add(dtFormacion);
        }
        return listOfDT;
    }
}