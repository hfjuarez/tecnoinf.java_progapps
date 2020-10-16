package logica.inscripciones;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import API.datatypes.*;
import logica.entidades.Inscripcion_Formacion;

public class ListaInscripcionesFor {

    public DTInscripcion_Formacion ObtenerInscFormacion(String nombreFormacion, String nicknameEstudiante) {
        List<Inscripcion_Formacion> list = getList();
        for (Inscripcion_Formacion inscripcion : list) {
            if (inscripcion.getFormacionInsc().getNombreFormacion().equals(nombreFormacion)) {
                if (inscripcion.getEstudiante().getNickname().equals(nicknameEstudiante)) {
                    return new DTInscripcion_Formacion(inscripcion);
                }
            }
        }
        return null;
    }

    public List<Inscripcion_Formacion> getList() {
        List<Inscripcion_Formacion> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Inscripcion_Formacion as i");
        list = (List<Inscripcion_Formacion>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;
    }

    public List<DTInscripcion_Formacion> getDTlist() {
        List<Inscripcion_Formacion> list = getList();
        List<DTInscripcion_Formacion> dtlist = new ArrayList();
        for (Inscripcion_Formacion i : list) {
            DTInscripcion_Formacion ins = new DTInscripcion_Formacion(i);
            dtlist.add(ins);
        }
        return dtlist;

    }

    public List<DTInscripcion_Formacion> getDTlistPorEstudiante(String nickEstudiante) {
        List<DTInscripcion_Formacion> list = getDTlist();
        List<DTInscripcion_Formacion> dtlistEstudiante = new ArrayList<DTInscripcion_Formacion>();
        for (DTInscripcion_Formacion i : list) {
            if (i.estudiante.nickname.equals(nickEstudiante)) {
                dtlistEstudiante.add(i);
            }
        }
        return dtlistEstudiante;
    }

    public List<DTInscripcion_Formacion> getDTlistPorFormacion(String nombreFormacion) {
        List<DTInscripcion_Formacion> list = getDTlist();
        List<DTInscripcion_Formacion> ret = new ArrayList<DTInscripcion_Formacion>();
        for (DTInscripcion_Formacion ins : list) {
            if (ins.formita.nombreFormacion.equals(nombreFormacion)) {
                ret.add(ins);
            }
        }
        return ret;
    }
}
