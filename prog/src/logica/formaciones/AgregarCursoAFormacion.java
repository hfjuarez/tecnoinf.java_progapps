package logica.formaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.cursos.*;
import logica.entidades.Curso;
import logica.entidades.Formacion;
import java.util.*;

public class AgregarCursoAFormacion {

    private String nom_for;

    public AgregarCursoAFormacion(String nombreFormacion) {
        nom_for = nombreFormacion;
    }

    private boolean existeCursoEnFormacion(List<String> nombreCursos) {
        Formacion f = new ObtenerFormacion().getFormacion(nom_for);
        List<Curso> cursos = f.getCursos();
        if (cursos == null)
            return false;
        for (Curso cursito : cursos) {
            if (nombreCursos.contains(cursito.getNombreCurso())) {
                return true;
            }
        }
        return false;
    }

    private String hasErrorNotExists() {
        ExisteFormacion existeFormacion = new ExisteFormacion();
        if (!existeFormacion.existeFormCur(nom_for))
            return "ERROR: NO existe la formacion con ese nombre: " + nom_for + " \n";
        return "";
    }

    public String agregarCursosAFor(List<String> nombreCursos) {

        String retorno = "";
        String cur;
        List<Curso> cursos = new ArrayList();
        // if(nombreCursos.size()==1) {
        // cur=nombreCursos.get(0);
        // ObtenerCurso oc = new ObtenerCurso();
        // Curso cursoFor = oc.getCurso(cur);
        // if( cursoFor != null) {
        // cursos.add(cursoFor);

        // }else {
        // return retorno + "ERROR: No existe el curso: " + cur
        // + ", por favor ingrese un curso existente!\n";
        // }
        // }

        if (retorno.isEmpty()) {

            if (!nombreCursos.isEmpty()) {

                ObtenerCurso oc = new ObtenerCurso();
                for (String cursoString : nombreCursos) {
                    Curso cursoFor = oc.getCurso(cursoString);
                    if (cursoFor == null) {
                        return retorno + "ERROR: No existe el curso: " + cursoString
                                + ", por favor ingrese un curso existente!\n";
                    }
                    cursos.add(cursoFor);
                }
            }
        }

        if (!existeCursoEnFormacion(nombreCursos)) {

            if (hasErrorNotExists().isEmpty()) {
                EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
                EntityManager entitymanager = emfactory.createEntityManager();
                entitymanager.getTransaction().begin();

                Formacion form = entitymanager.find(Formacion.class, nom_for);

                for (Curso cursito : cursos) {
                    form.addCurso(cursito);
                }

                entitymanager.getTransaction().commit();

                entitymanager.close();
                emfactory.close();
                return "";
            } else {
                return hasErrorNotExists();
            }
        } else {
            return retorno + "ERROR: Ya existe el curso a agregar en la formacion:" + nom_for;
        }
    }
}