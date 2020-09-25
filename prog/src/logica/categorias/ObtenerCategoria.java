package logica.categorias;

import logica.entidades.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import API.datatypes.DTCategoria;

public class ObtenerCategoria {

    public Categoria getCategoria(String name) {

        ExisteCategoria existeCategoria = new ExisteCategoria(name);
        if (existeCategoria.existe()) {
            Categoria ret = new Categoria();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            ret = entitymanager.find(Categoria.class, name);
            entitymanager.close();
            emfactory.close();
            return ret;

        } else {
            return null;
        }

    }

    public DTCategoria geDTCategoria(String name) {
        Categoria categoria = getCategoria(name);
        return new DTCategoria(categoria);
    }
}