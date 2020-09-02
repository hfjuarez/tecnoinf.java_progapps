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
    private String nomIma;
    private Date nacDate;

    public ModificarUsuario() {

    }

    public ModificarUsuario(String nickName, String nombre, String apellido, String nombreImagen, Date fechaNaci) {
        nick = nickName;
        ape = apellido;
        nomIma = nombreImagen;
    }

    private String hasErrorNotExists() {
        ExisteUsuario existeUsuario = new ExisteUsuario(nick);
        if (!existeUsuario.existeNickname())
            return "ERROR: NO existe el usuario con nickname: " + nick;
        return "";
    }

    public String ModifEst() {
        String retorno = hasErrorNotExists();
        if (retorno.isEmpty()) {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();
            ObtenerUsuario obtusr = new ObtenerUsuario(nick);
            Estudiante usr = new Estudiante();
            usr = obtusr.getEstudianteByNickname();
            usr.setNombre(name);
            usr.setApellido(ape);
            usr.setFechaNac(nacDate);
            usr.setNombreImagen(nomIma);

            entitymanager.refresh(usr);
            entitymanager.getTransaction().commit();

            entitymanager.close();
            emfactory.close();

        }
        return retorno;
    }

    public String ModifDoc(String Inst) {
        String retorno = hasErrorNotExists();
        if (retorno.isEmpty()) {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            entitymanager.getTransaction().begin();
            ObtenerUsuario obtusr = new ObtenerUsuario(nick);
            Docente usr = new Docente();
            usr = obtusr.getDocenteByNickname();
            usr.setNombre(name);
            usr.setApellido(ape);
            usr.setFechaNac(nacDate);
            usr.setNombreImagen(nomIma);
            usr.setInstituto(Inst);

            entitymanager.refresh(usr);
            entitymanager.getTransaction().commit();

            entitymanager.close();
            emfactory.close();

        }
        return retorno;
    }
}