package logica.instituto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Instituto;

public class AltaInstituto {
    public String create(String nombreInstituto) {

        // Logica
        if (new ExisteInstituto(nombreInstituto).existe()) {
            return "ERROR: Ya existe un instituto con el nombre: " + nombreInstituto;
        } else {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
            // @PersistenceContext(unitName="Eclipselink_JPA_Instituto")
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();

            Instituto instituto = new Instituto();
            instituto.setNombreInstituto(nombreInstituto);

            entitymanager.persist(instituto);
            entitymanager.getTransaction().commit();

            entitymanager.close();
            emfactory.close();
        }
        return "";
    }
}
