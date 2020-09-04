package logica.usuarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import logica.entidades.Estudiante;
import logica.entidades.Docente;

public class ExisteUsuario {

    public boolean existeNickname(String nickname) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Estudiante est = null;
        est = entitymanager.find(Estudiante.class, nickname);
        Docente doc = null;
        doc = entitymanager.find(Docente.class, nickname);

        if (est != null || doc != null) {
            ret = true;
        }
        entitymanager.close();
        emfactory.close();
        return ret;
    }

    public boolean existeMail(String mail) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        
        Query query1 = entitymanager.createQuery("SELECT e.mail FROM Estudiante as e");
        List<String> listMailEstudiantes=query1.getResultList();
        
        Query query2 = entitymanager.createQuery("SELECT d.mail FROM Docente as d");
        List<String> listMailDocentes=query2.getResultList();

        entitymanager.close();
        emfactory.close();
        if (listMailEstudiantes.contains(mail) || listMailDocentes.contains(mail)) {
            return true;
        } else {
            return false;
        }

    }

}
