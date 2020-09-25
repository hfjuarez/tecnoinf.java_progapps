package logica.formaciones;

import logica.entidades.Formacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import API.datatypes.DTFormacion;

public class ObtenerFormacion {

    public Formacion getFormacion(String name) {

        ExisteFormacion existeFormacion = new ExisteFormacion();
        if (existeFormacion.existeFormCur(name)) {
            Formacion ret = new Formacion();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            ret = entitymanager.find(Formacion.class, name);
            entitymanager.close();
            emfactory.close();
            return ret;

        } else {
            return null;
        }

    }

    public DTFormacion getDTFormacion(String name) {
        Formacion formacion = getFormacion(name);
        return new DTFormacion(formacion);
    }
}