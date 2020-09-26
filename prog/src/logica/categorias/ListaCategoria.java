package logica.categorias;

import java.util.List;
import java.util.ArrayList;
import logica.entidades.Categoria;
import logica.formaciones.ObtenerFormacion;

import javax.persistence.*;

import API.datatypes.DTCategoria;

public class ListaCategoria {

    public List<Categoria> getList() {
        List<Categoria> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Categoria as i");
        list = (List<Categoria>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;

    }

    public List<DTCategoria> getDataTypeList() {
        List<Categoria> list = getList();
        List<DTCategoria> listOfDT = new ArrayList<>();
        for (Categoria categoria : list) {
            DTCategoria dtCategoria = new DTCategoria(categoria);
            listOfDT.add(dtCategoria);
        }
        return listOfDT;
    }

    public List<String> getListPorFormacion(String nombreFormacion) {
        List<String> list = new ObtenerFormacion().getFormacion(nombreFormacion).getCategorias();
        return list;

    }
}