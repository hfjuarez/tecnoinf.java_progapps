package logica.formacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import logica.entidades.Curso;
import logica.entidades.Formacion;

public class AltaFormacion {

    private String nom_for;
    private String des_for;
    private Date Finicio_for;
    private Date Ffin_for;
    private Date FechAlta_for;

    public AltaFormacion(String nombreFormacion, String descFormacion, Date fechaInicio, Date fechaFin,
            Date fechaAlta) {
        nom_for = nombreFormacion;
        des_for = descFormacion;
        Finicio_for = fechaInicio;
        Ffin_for = fechaFin;
        FechAlta_for = fechaAlta;
    }

    private boolean hasErrorEmpty() {
        if (nom_for.isEmpty())
            return true;
        if (des_for.isEmpty())
            return true;
        if (Finicio_for.toString().isEmpty())
            return true;
        if (Ffin_for.toString().isEmpty())
            return true;
        if (FechAlta_for.toString().isEmpty())
            return true;
        return false;
    }

    private String hasErrorAlredyExists() {
        ExisteFormacion existeFormacion = new ExisteFormacion();
        String ret = "";
        if (existeFormacion.existeFormCur(nom_for))
            ret = ret + "ERROR: Ya existe una formacion con ese nombre: " + nom_for + "\n";

        return ret;
    }

    public String createFormacion() {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FormacionJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Formacion formacion = new Formacion(nom_for, des_for, Finicio_for, Ffin_for, FechAlta_for);

        entitymanager.persist(formacion);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();

        return "";
    }
}