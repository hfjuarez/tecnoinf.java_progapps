package logica.instituto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Instituto;
import logica.datatypes.DTInstituto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObtenerInstituto {
    private String nombre;

    public ObtenerInstituto(String name) {
        nombre = name;
    }

    public Instituto getInstituto() {

        ExisteInstituto existeInstituto = new ExisteInstituto(nombre);
        if (existeInstituto.existe()) {
            Instituto ret = new Instituto();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            ret = entitymanager.find(Instituto.class, nombre);
            entitymanager.close();
            emfactory.close();
            return ret;

        } else {
            return null;
        }

    }

    public DTInstituto geDTInstituto() {
        Instituto instituto = getInstituto();
        return new DTInstituto(instituto);
    }
}