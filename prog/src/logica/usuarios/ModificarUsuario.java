package logica.usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

import logica.entidades.Usuario;
import logica.entidades.Estudiante;
import logica.entidades.Docente;

public class ModificarUsuario {

    private String nick;
    private String name;
    private String ape;
    private Date nacDate;

    public ModificarUsuario() {

    }

    public ModificarUsuario(String nickName, String nombre, String apellido, Date fechaNaci) {
        nick = nickName;
        name = nombre;
        ape = apellido;
        nacDate = fechaNaci;
    }

    private String hasErrorNotExists() {
        ExisteUsuario existeUsuario = new ExisteUsuario();
        if (!existeUsuario.existeNickname(nick))
            return "ERROR: NO existe el usuario con nickname: " + nick;
        return "";
    }

    public String ModificarEstudiante() {
        String retorno = hasErrorNotExists();
        if (retorno.isEmpty()) {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();

            Estudiante usr = new ObtenerUsuario().getEstudianteByNickname(nick);

            if (!name.isEmpty()) {
                usr.setNombre(name);
            }
            if (!ape.isEmpty()) {
                usr.setApellido(ape);
            }
            if (!ape.isEmpty()) {
                usr.setApellido(ape);
            }
            if (!nacDate.toString().isEmpty()) {
                usr.setFechaNac(nacDate);
            }

            entitymanager.persist(usr);
            entitymanager.getTransaction().commit();

            entitymanager.close();
            emfactory.close();

        }
        return retorno;
    }

    public String ModificarDocente() {
        String retorno = hasErrorNotExists();

        if (retorno.isEmpty()) {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();

            Docente usr = new ObtenerUsuario().getDocenteByNickname(nick);

            if (!name.isEmpty()) {
                usr.setNombre(name);
            }
            if (!ape.isEmpty()) {
                usr.setApellido(ape);
            }
            if (!ape.isEmpty()) {
                usr.setApellido(ape);
            }
            if (!nacDate.toString().isEmpty()) {
                usr.setFechaNac(nacDate);
            }

            entitymanager.persist(usr);
            entitymanager.getTransaction().commit();

            entitymanager.close();
            emfactory.close();

        }
        return retorno;
    }
}