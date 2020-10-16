package logica.categorias;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Categoria;

public class AltaCategoria {

    public String create(String nombreCategoria) {

        // Logica
        if (new ExisteCategoria(nombreCategoria).existe()) {
            return "ERROR: Ya existe una categoria con el nombre: " + nombreCategoria;
        } else {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
            // @PersistenceContext(unitName="Eclipselink_JPA_Curso")
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();

            Categoria categoria = new Categoria();
            categoria.setNombreCategoria(nombreCategoria);

            entitymanager.persist(categoria);
            entitymanager.getTransaction().commit();

            entitymanager.close();
            emfactory.close();
        }
        return "";
    }
}