package logica.instituto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Instituto;

public class ExisteInstituto {

    private String id;

    public ExisteInstituto(String nombreInstituto) {
        id = nombreInstituto;
    }

    public boolean existe() {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Instituto instituto = null;
        instituto = entitymanager.find(Instituto.class, id);
        
        entitymanager.close();
        emfactory.close();
        
        if (instituto != null) {
            ret = true;
        }

        return ret;
    }
}