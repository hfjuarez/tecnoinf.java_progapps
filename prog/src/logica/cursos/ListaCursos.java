package logica.cursos;

import java.util.List;
import java.util.ArrayList;
import logica.entidades.Curso;
import logica.entidades.Instituto;
import logica.edicioncursos.ListaEdicionCurso;
import logica.entidades.EdicionCurso;

import javax.persistence.*;

import API.datatypes.*;

public class ListaCursos {
    public List<Curso> getList() {
        List<Curso> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Curso as i");
        list = (List<Curso>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;
    }

    public List<Curso> getListConInstituto(String nameInstituto) {
        List<Curso> list = getList();
        List<Curso> cursosFiltrados = new ArrayList();

        for (Curso curso : list) {
            Instituto inst = curso.getInstituto();
            if (inst != null) {

                if (nameInstituto.equals(inst.getNombreInstituto())) {
                    cursosFiltrados.add(curso);

                }
            }
        }

        return cursosFiltrados;
    }

    public List<DTCurso> getDataTypeList() {
        List<Curso> list = getList();
        List<DTCurso> listOfDT = new ArrayList();
        for (Curso curso : list) {
            DTCurso dtCurso = new DTCurso(curso);
            listOfDT.add(dtCurso);
        }
        return listOfDT;
    }

    public List<DTCurso> getDataTypeListConInstituto(String nameInstituto) {
        List<Curso> list = getListConInstituto(nameInstituto);
        List<DTCurso> listOfDT = new ArrayList();
        for (Curso curso : list) {
            DTCurso dtCurso = new DTCurso(curso);
            listOfDT.add(dtCurso);
        }
        return listOfDT;
    }

    public List<DTCurso> BusquedaFiltro(String busqueda) {
        List<Curso> ListaCursos = getList();
        List<DTCurso> DTList = new ArrayList();
        for (Curso curso : ListaCursos) {
            if (curso.getNombreCurso().toLowerCase().contains(busqueda.toLowerCase())) {
                DTList.add(new DTCurso(curso));
            } else {
                if (curso.getDescCurso().toLowerCase().contains(busqueda.toLowerCase())) {
                    DTList.add(new DTCurso(curso));
                }
            }
        }
        return DTList;
    }
}
