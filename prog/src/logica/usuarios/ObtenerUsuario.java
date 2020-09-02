package logica.usuarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Usuario;
import logica.entidades.Docente;
import logica.entidades.Estudiante;

public class ObtenerUsuario {
    private String nick;
    private String mail;

    public ObtenerUsuario(String nickname, String email) {
        nick = nickname;
        mail = email;
    }

    public ObtenerUsuario(String nickname) {
        nick = nickname;
        mail = "";
    }

    public Estudiante getEstudianteByNickname() {

        ExisteUsuario existeUsuario = new ExisteUsuario(nick, mail);
        if (existeUsuario.existeNickname()) {
            Estudiante Uret = new Estudiante();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();
            Uret = entitymanager.find(Estudiante.class, nick);
            entitymanager.close();
            emfactory.close();
            return Uret;

        } else {
            return null;
        }

    }

    public Docente getDocenteByNickname() {

        ExisteUsuario existeUsuario = new ExisteUsuario(nick, mail);
        if (existeUsuario.existeNickname()) {
            Docente Uret = new Docente();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();
            Uret = entitymanager.find(Docente.class, nick);
            entitymanager.close();
            emfactory.close();
            return Uret;

        } else {
            return null;
        }

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