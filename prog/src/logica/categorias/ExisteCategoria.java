package logica.categorias;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Categoria;

public class ExisteCategoria {

    private String id;

    public ExisteCategoria(String nombreCategoria) {
        id = nombreCategoria;
    }

    public boolean existe() {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Categoria categoria = null;
        categoria = entitymanager.find(Categoria.class, id);

        entitymanager.close();
        emfactory.close();

        if (categoria != null) {
            ret = true;
        }

        return ret;
    }
}