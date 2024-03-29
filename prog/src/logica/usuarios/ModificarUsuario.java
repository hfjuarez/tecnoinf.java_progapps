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

    public ModificarUsuario(String nickName, String nombre, String apellido, Date fechaNaci) {
        nick = nickName;
        name = nombre;
        ape = apellido;
        nacDate = fechaNaci;
    }

    private String hasErrorNotExists() {
        ExisteUsuario existeUsuario = new ExisteUsuario();
        if (!existeUsuario.existeNickname(nick))
            return "ERROR: NO existe el usuario con nickname: " + nick + " \n";
        return "";
    }

    public String modificarEstudiante() {
        String retorno = hasErrorNotExists();
        if (retorno.isEmpty()) {

            if (new ObtenerUsuario().isEstudiante(nick)) {
                // Estudiante usr = new ObtenerUsuario().getEstudianteByNickname(nick);
                // System.out.println("EL estudiante es: "+ usr);
                EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
                EntityManager entitymanager = emfactory.createEntityManager();
                entitymanager.getTransaction().begin();

                Estudiante usr = entitymanager.find(Estudiante.class, nick);

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

                // entitymanager.refresh(usr);
                entitymanager.getTransaction().commit();

                entitymanager.close();
                emfactory.close();
            } else {
                return retorno + "ERROR: El nickname ingresado no pertenece a un estudiante \n";
            }

        }
        return retorno;
    }

    public String modificarDocente() {
        String retorno = hasErrorNotExists();

        if (retorno.isEmpty()) {
            if (!new ObtenerUsuario().isEstudiante(nick)) {
                // Docente usr = new ObtenerUsuario().getDocenteByNickname(nick);
                EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
                EntityManager entitymanager = emfactory.createEntityManager();
                entitymanager.getTransaction().begin();

                Docente usr = entitymanager.find(Docente.class, nick);

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

                // entitymanager.refresh(usr);
                entitymanager.getTransaction().commit();

                entitymanager.close();
                emfactory.close();
            } else {
                return retorno + "ERROR: El nickname ingresado no pertenece a un docente \n";
            }

        }
        return retorno;
    }

}