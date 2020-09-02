package logica.usuarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.entidades.Usuario;

public class ExisteUsuario {

    private String nick;
    private String email;

    public ExisteUsuario(String nickname, String mail) {
        nick = nickname;
        email = mail;
    }

    public ExisteUsuario(String nickname) {
        nick = nickname;
    }

    public boolean existeNickname() {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        Usuario user = null;
        user = entitymanager.find(Usuario.class, nick);
        if (user != null) {
            ret = true;
        }
        return ret;
    }

    public boolean existeMail() {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        List<Usuario> users = entitymanager.createQuery("SELECT mail FROM TABLE usuario", Usuario.class)
                .getResultList();
        if (!users.isEmpty()) {
            ret = true;
        }
        return ret;
    }

}
