package logica.edicioncurso;

import logica.entidades.Curso;
import logica.entidades.Docente;
import logica.entidades.EdicionCurso;

import java.sql.Date;
import java.util.*;
import logica.curso.ObtenerCurso;
import logica.usuarios.ObtenerUsuario;

public class AltaEdicionCurso {
    private String nombreEdicion;
    private String curso;
    private Date fechaInicio;
    private Date fechaFin;
    private int cupo;
    private Date fechaAltaEdicion;

    public AltaEdicionCurso(String nombreEdi, String curso, Date fInicio, Date fFin, int cupoo, Date fAltaEdicion) {
        nombreEdicion = nombreEdi;
        this.curso = curso;
        fechaInicio = fInicio;
        fechaFin = fFin;
        cupo = cupoo;
        fechaAltaEdicion = fAltaEdicion;

    }

    private boolean hasErrorEmpty() {
        if (nombreEdicion.isEmpty())
            return true;
        if (curso.isEmpty())
            return true;
        if (cupo < -1)
            return true;
        if (fechaInicio.toString().isEmpty())
       ?     return true;
        if (fechaFin.toString().isEmpty())
            return true;
        if (fechaAltaEdicion.toString().isEmpty())
            return true;
        return false;
    }

    private String hasErrorAlredyExists() {
        ExisteEdicionCurso existeECurso = new ExisteEdicionCurso();
        String ret = "";
        if (existeECurso.existeNombreCur(nombreEdicion))
            ret = ret + "ERROR: Ya existe una edicion curso con ese nombre: " + nombreEdicion + "\n";

        return ret;
    }

    public String createEdicionCurso(List<String> docentes) {

        String retorno = "";
        List<Docente> docentesEdicion = new ArrayList();

        if (hasErrorEmpty()) {
            retorno = retorno + "ERROR: No se permiten campos nulos, por favor complete todos los campos!\n";
        }
        retorno = retorno + hasErrorAlredyExists();

        if (retorno.isEmpty()) {

            if (!docentes.isEmpty()) {
                ObtenerUsuario oc = new ObtenerUsuario();
                for (String docenteString : docentes) {
                    if (oc.isEstudiante(docenteString)) {
                        return retorno + "ERROR: No existe el docente: " + docenteString
                                + ", por favor ingrese un existente!\n";
                    }
                    Docente doc = oc.getDocenteByNickname(docenteString);
                    if (doc == null) {
                        return retorno + "ERROR: No existe el docente: " + docenteString
                                + ", por favor ingrese un existente!\n";
                    }

                    docentesEdicion.add(doc);
                }
            } else {
                return retorno + "ERROR: No se ingresaron docentes para esta edicion, por foavor ingrese minimo uno!\n";
            }
            ObtenerCurso oCurso = new ObtenerCurso();
            Curso cursoCurso = oCurso.getCurso(curso);
            if (cursoCurso == null) {
                EdicionCurso edicion = new EdicionCurso(nombreEdicion, cursoCurso, fechaInicio, fechaFin, cupo,
                        fechaAltaEdicion, docentes);

                EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
                EntityManager entitymanager = emfactory.createEntityManager();
                entitymanager.getTransaction().begin();

                entitymanager.persist(edicion);

                entitymanager.getTransaction().commit();
                entitymanager.close();
                emfactory.close();
            }
        } else {
            return retorno + "ERROR: No se permiten campos nulos, por favor complete todos los campos!\n";
        }

    }
}
