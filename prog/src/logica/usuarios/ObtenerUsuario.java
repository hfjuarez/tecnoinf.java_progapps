package logica.usuarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import API.datatypes.DTDocente;
import API.datatypes.DTEstudiante;
import logica.entidades.Usuario;
import logica.entidades.Docente;
import logica.entidades.Estudiante;

public class ObtenerUsuario {

    /*
     * public ObtenerUsuario(String nickname, String email) { nick = nickname; mail
     * = email; }
     */

    public ObtenerUsuario() {
    }

    public boolean isEstudiante(String nickname) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Estudiante est = null;
        est = entitymanager.find(Estudiante.class, nickname);

        if (est != null) {
            ret = true;
        }
        entitymanager.close();
        emfactory.close();
        return ret;
    }

    public Estudiante getEstudianteByNickname(String nick) {

        if (new ExisteUsuario().existeNickname(nick)) {

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();

            Estudiante Uret = new Estudiante();
            Uret = entitymanager.find(Estudiante.class, nick);

            entitymanager.close();
            emfactory.close();
            return Uret;

        } else {
            return null;
        }

    }

    public Docente getDocenteByNickname(String nick) {

        if (new ExisteUsuario().existeNickname(nick)) {

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();

            Docente Uret = new Docente();
            Uret = entitymanager.find(Docente.class, nick);

            entitymanager.close();
            emfactory.close();
            return Uret;

        } else {
            return null;
        }

    }

    public DTDocente getDTDocenteByNickname(String nick) {
        Docente docente = getDocenteByNickname(nick);
        return new DTDocente(docente);
    }

    public DTEstudiante getDTEstudianteByNickname(String nick) {
        Estudiante estudiante = getEstudianteByNickname(nick);
        return new DTEstudiante(estudiante);
    }

    /*
     * public Usuario getUsuarioByMail() {
     * 
     * ExisteUsuario existeUsuario = new ExisteUsuario(nick, mail); if
     * (existeUsuario.existeMail()) { EntityManagerFactory emfactory =
     * Persistence.createEntityManagerFactory("UsuarioJPA"); EntityManager
     * entitymanager = emfactory.createEntityManager();
     * entitymanager.getTransaction().begin(); List<String> nicks = entitymanager
     * .createQuery("SELECT nickname FROM TABLE usuario WHERE mail=" + mail,
     * Usuario.class) .getResultList();
     * 
     * entitymanager.close(); emfactory.close(); nick = nicks.get(0); return
     * getUsuarioByNickname();
     * 
     * } else { return null; }
     * 
     * }
     */
}