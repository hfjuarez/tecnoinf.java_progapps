package logica.edicioncursos;

import logica.entidades.EdicionCurso;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import API.datatypes.DTEdicionCurso;
import logica.entidades.Curso;
import logica.entidades.Docente;

public class ListaEdicionCurso {

    public List<EdicionCurso> getList() {
        List<EdicionCurso> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from EdicionCurso as i");
        list = (List<EdicionCurso>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;
    }

    public List<EdicionCurso> getlistByDosente(String Nombredoc) {
        List<EdicionCurso> list = getList();
        List<EdicionCurso> EdicionCursosFiltrados = new ArrayList();

        for (EdicionCurso edicioncurso : list) {
            List<Docente> lalista = edicioncurso.getDocentes();
            for (Docente doc : lalista) {

                if (Nombredoc.equals(doc.getNickname())) {
                    EdicionCursosFiltrados.add(edicioncurso);

                }
            }

        }

        return EdicionCursosFiltrados;
    }

    public List<EdicionCurso> getlistByCurso(String NombreCurso) {
        List<EdicionCurso> list = getList();
        List<EdicionCurso> EdicionCursosFiltrados = new ArrayList();

        for (EdicionCurso edicioncurso : list) {

            if (NombreCurso.equals(edicioncurso.getCurso().getNombreCurso())) {
                EdicionCursosFiltrados.add(edicioncurso);

            }
        }

        return EdicionCursosFiltrados;
    }

    public List<DTEdicionCurso> getDataTypeList() {
        List<EdicionCurso> list = getList();
        List<DTEdicionCurso> listOfDT = new ArrayList();
        for (EdicionCurso ec : list) {
            DTEdicionCurso dtEC = new DTEdicionCurso(ec);
            listOfDT.add(dtEC);
        }
        return listOfDT;
    }

    public List<DTEdicionCurso> getDataTypeListByCurso(String NombreCurso) {
        List<EdicionCurso> list = getlistByCurso(NombreCurso);
        List<DTEdicionCurso> listOfDT = new ArrayList();
        for (EdicionCurso ec : list) {
            DTEdicionCurso dtEC = new DTEdicionCurso(ec);
            listOfDT.add(dtEC);
        }
        return listOfDT;
    }

    public List<DTEdicionCurso> getDataTypeListByDosente(String Nombredoc) {
        List<EdicionCurso> list = getlistByDosente(Nombredoc);
        List<DTEdicionCurso> listOfDT = new ArrayList();
        for (EdicionCurso ec : list) {
            DTEdicionCurso dtEC = new DTEdicionCurso(ec);
            listOfDT.add(dtEC);
        }
        return listOfDT;
    }
}