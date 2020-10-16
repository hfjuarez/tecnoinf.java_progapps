package logica.formaciones;

import java.util.List;
import java.util.ArrayList;
import logica.entidades.Formacion;

import javax.persistence.*;

import API.datatypes.DTCurso;
import API.datatypes.DTFormacion;

public class ListaFormacion {
    public List<Formacion> getList() {
        List<Formacion> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
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

    public List<DTFormacion> listaFormacionesPorCurso(String curso) {
        List<DTFormacion> listOfDT = getDataTypeList();
        List<DTFormacion> ret = new ArrayList();
        for (DTFormacion dt : listOfDT) {
            List<DTCurso> curs = dt.cursos;
            for (DTCurso c : curs) {
                if (c.nombreCurso.equals(curso)) {
                    ret.add(dt);
                }
            }
        }
        return ret;
    }

    public List<DTFormacion> BusquedaFiltro(String busqueda) {
        List<Formacion> ListaFormacion = getList();
        List<DTFormacion> DTListFormacion = new ArrayList();
        for (Formacion formacion : ListaFormacion) {
            if (formacion.getNombreFormacion().toLowerCase().contains(busqueda.toLowerCase())) {
                DTListFormacion.add(new DTFormacion(formacion));
            } else {
                if (formacion.getDescFormacion().toLowerCase().contains(busqueda.toLowerCase())) {
                    DTListFormacion.add(new DTFormacion(formacion));
                }
            }
        }
        return DTListFormacion;
    }
}