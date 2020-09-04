package logica.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.File;
import java.sql.Date;

import logica.entidades.Curso;
import logica.instituto.ObtenerInstituto;
import logica.entidades.Docente;
import logica.entidades.Instituto;
import logica.entidades.Estudiante;

public class AltaCurso {

    private String nick;
    private String name;
    private String ape;
    private String mail;
    private Date nacDate;

    AltaUsuario(String nickname, String nombre, String apellido, String email, Date nac) {
        nick = nickname;
        name = nombre;
        ape = apellido;
        mail = email;
        nacDate = nac;
    }

    private boolean hasErrorEmpty() {
        if (nick.isEmpty())
            return true;
        if (name.isEmpty())
            return true;
        if (ape.isEmpty())
            return true;
        if (mail.isEmpty())
            return true;
        if (nacDate.toString().isEmpty())
            return true;
        return false;
    }

    private String hasErrorAlredyExists() {
        ExisteUsuario existeUsuario = new ExisteUsuario();
        String ret = "";
        if (existeUsuario.existeNickname(nick))
            ret = ret + "ERROR: Ya existe el usuario con nickname: " + nick + "\n";
        if (existeUsuario.existeMail(mail))
            ret = ret + "ERROR: Ya existe el usuario con mail: " + mail + "\n";
        return ret;
    }

    public String createEstudiante() {
        /*
         * String fecha = "2015-04-23"; Date nacDate = Date.valueOf(fecha);// converting
         * string into sql date
         */
        if (hasErrorEmpty()) {
            return "ERROR: No se permiten campos nulos, por favor complete todos los campos!";
        }
        String retorno = hasErrorAlredyExists();
        if (retorno.isEmpty()) {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();

            Estudiante estudiante = new Estudiante(nick, name, ape, mail, nacDate);

            entitymanager.persist(estudiante);
            entitymanager.getTransaction().commit();

            entitymanager.close();
            emfactory.close();
        }
        return retorno;
    }

    public String createDocente(String nombreInstituto) {
        /*
         * String fecha = "2015-04-23"; Date nacDate = Date.valueOf(fecha);// converting
         * string into sql date
         */
        if (hasErrorEmpty() || nombreInstituto.isEmpty()) {
            return "ERROR: No se permiten campos nulos, por favor complete todos los campos!";
        }
        String retorno = hasErrorAlredyExists();

        if (retorno.isEmpty()) {
            Instituto instituto = new ObtenerInstituto(nombreInstituto).getInstituto();
            if (instituto != null) {
                EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
                EntityManager entitymanager = emfactory.createEntityManager();
                entitymanager.getTransaction().begin();

                Docente docente = new Docente(nick, name, ape, mail, nacDate, instituto);

                entitymanager.persist(docente);

                entitymanager.getTransaction().commit();
                entitymanager.close();
                emfactory.close();
            } else {
                return "ERROR: No se permiten campos nulos, por favor complete todos los campos!";
            }

        }
        return retorno;
    }

    public static void main(String[] args) {
        ;
        String fecha = "2015-04-23";
        Date nacDate = Date.valueOf(fecha);
        // AltaUsuario au1 = new AltaUsuario("nick1", "nombre", "apellido", "mail",
        // nacDate);
        AltaUsuario au2 = new AltaUsuario("nick1", "nombdsfre", "apelsdfsdflido", "mail", nacDate);

        // String es = au1.createEstudiante();

        String dos = au2.createDocente("Fing");
        System.out.println(dos);
    }
}