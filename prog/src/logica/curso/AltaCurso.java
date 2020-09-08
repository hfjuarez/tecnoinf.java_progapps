package logica.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

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

    public AltaCurso(String nombreCurso, String descCurso, int duracionMeses, int cantidadHoras, int cantidadCreditos,
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
        boolean tienePrevias = false;
        String retorno = "";
        List<Curso> previas = new ArrayList();

        if (hasErrorEmpty() || nombreInstituto.isEmpty()) {
            retorno = retorno + "ERROR: No se permiten campos nulos, por favor complete todos los campos!\n";
        }
        retorno = retorno + hasErrorAlredyExists();

        if (retorno.isEmpty()) {

            if (!nombrePrevias.isEmpty()) {
                tienePrevias = true;
                ObtenerCurso oc = new ObtenerCurso();
                for (String previaString : nombrePrevias) {
                    Curso previa = oc.getCurso(previaString);
                    if (previa == null) {
                        return retorno + "ERROR: No existe el curso: " + previaString
                                + ", por favor ingrese un curso existente!\n";
                    }

                    previas.add(previa);
                }
            }

            Instituto instituto = new ObtenerInstituto(nombreInstituto).getInstituto();

            if (instituto != null) {
                EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
                EntityManager entitymanager = emfactory.createEntityManager();
                entitymanager.getTransaction().begin();

                Curso curso = new Curso(nom_cur, des_cur, dur_mes, cant_horas, cant_credito, curURL, fech_alta,
                        instituto);
                if (tienePrevias) {
                    curso.setPrevias(previas);
                }

                entitymanager.persist(curso);

                entitymanager.getTransaction().commit();
                entitymanager.close();
                emfactory.close();
            } else {
                return retorno + "No existe el Instituto: " + nombreInstituto
                        + ", por favor ingrese un Instituto existente!\n";
            }

        }
        return retorno;
    }
}