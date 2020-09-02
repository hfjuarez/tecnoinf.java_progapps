package logica.instituto;

import logica.entidades.Instituto;

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
            entitymanager.getTransaction().begin();
            ret = entitymanager.find(Instituto.class, nombre);
            entitymanager.close();
            emfactory.close();
            return ret;

        } else {
            return null;
        }

    }
}mr.