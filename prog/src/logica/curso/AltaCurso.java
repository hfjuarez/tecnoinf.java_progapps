package logica.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.File;
import java.sql.Date;

import logica.entidades.Curso;
import logica.instituto.ObtenerInstituto;
import logica.entidades.Instituto;

public class AltaCurso {

    private String nom_cur;
    private String des_cur;
    private int dur_mes;

    private int cant_horas;

    private int cant_credito;

    private String curURL;
    private Date fech_alta;

    // @OneToMany(targetEntity=Curso.class)
    // private List previas;

    AltaCurso(String nombreCurso, String descCurso, int duracionMeses, int cantidadHoras, int cantidadCreditos,
            String URL, Date fechaAlta) {
        nom_cur = nombreCurso;
        des_cur = descCurso;
        dur_mes = duracionMeses;
        cant_horas = cantidadHoras;
        cant_credito = cantidadCreditos;
        curURL = URL;
        fech_alta = fechaAlta;
    }

    private boolean hasErrorEmpty() {
        if (nom_cur.isEmpty())
            return true;
        if (des_cur.isEmpty())
            return true;
        if (curURL.isEmpty())
            return true;
        if (fech_alta.toString().isEmpty())
            return true;
        return false;
    }

    private String hasErrorAlredyExists() {
        ExisteCurso existeCurso = new ExisteCurso();
        String ret = "";
        if (existeCurso.existeNombreCur(nom_cur))
            ret = ret + "ERROR: Ya existe un curso con ese nombre: " + nom_cur + "\n";

        return ret;
    }

    public String createCurso(String nombreInstituto, List<String> nombrePrevias) {
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

                Curso curso = new Curso(nom_cur, des_cur, dur_mes, cant_horas, cant_credito, curURL, fech_alta,
                        instituto);

                List<Cursos> previas = new ArrayList();
                ObtenerCurso oc = new ObtenerCurso();
                for (String previaString : nombrePrevias) {
                    Curso previa = oc.getCurso(previaString);
                    previas.add(previa);
                }
                curso.setPrevias(previas);

                entitymanager.persist(curso);

                entitymanager.getTransaction().commit();
                entitymanager.close();
                emfactory.close();
            } else {
                return "ERROR: No se permiten campos nulos, por favor complete todos los campos!";
            }

        }
        return retorno;
    }

    // public static void main(String[] args) {
    // ;
    // String fecha = "2015-04-23";
    // Date nacDate = Date.valueOf(fecha);
    // // AltaUsuario au1 = new AltaUsuario("nick1", "nombre", "apellido", "mail",
    // // nacDate);
    // AltaUsuario au2 = new AltaUsuario("nick1", "nombdsfre", "apelsdfsdflido",
    // "mail", nacDate);

    // // String es = au1.createEstudiante();

    // String dos = au2.createDocente("Fing");
    // System.out.println(dos);
    // }
}