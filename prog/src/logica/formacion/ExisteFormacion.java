package logica.formacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Formacion;

public class ExisteFormacion {

    public boolean existeFormCur(String nombreFormacion) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Formacion formacion = null;
        formacion = entitymanager.find(formacion.class, nombreFormacion);

        entitymanager.close();
        emfactory.close();

        if (formacion != null) {
            ret = true;
        }

        return ret;
    }
}