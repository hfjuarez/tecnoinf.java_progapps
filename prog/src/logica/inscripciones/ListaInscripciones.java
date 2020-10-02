package logica.inscripciones;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import API.datatypes.*;
import logica.entidades.Inscripcion_Edicion;

public class ListaInscripciones {

    public DTInscripcion_Edicion ObtenerInscripcion(String nombreEdicion, String nicknameEstudiante) {
        List<Inscripcion_Edicion> list = getList();
        for (Inscripcion_Edicion inscripcion : list) {
            if (inscripcion.getEdicionCurso().getNombreEdicion().equals(nombreEdicion)) {
                if (inscripcion.getEstudiante().getNickname().equals(nicknameEstudiante)) {
                    return new DTInscripcion_Edicion(inscripcion);
                }
            }
        }
        return null;
    }

    public List<Inscripcion_Edicion> getList() {
        List<Inscripcion_Edicion> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from Inscripcion_Edicion as i");
        list = (List<Inscripcion_Edicion>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;
    }

    public List<DTInscripcion_Edicion> getDTlist() {
        List<Inscripcion_Edicion> list = getList();
        List<DTInscripcion_Edicion> dtlist = new ArrayList();
        for (Inscripcion_Edicion i : list) {
            DTInscripcion_Edicion ins = new DTInscripcion_Edicion(i);
            dtlist.add(ins);
        }
        return dtlist;

    }

    public List<DTInscripcion_Edicion> getDTlistPorEstudiante(String nickEstudiante) {
        List<DTInscripcion_Edicion> list = getDTlist();
        List<DTInscripcion_Edicion> dtlistEstudiante = new ArrayList<DTInscripcion_Edicion>();
        for (DTInscripcion_Edicion i : list) {
            if (i.estudiante.nickname.equals(nickEstudiante)) {
                dtlistEstudiante.add(i);
            }
        }
        return dtlistEstudiante;
    }

    public List<DTInscripcion_Edicion> getDTlistPorEdicion(String nombreEdicion) {
        List<DTInscripcion_Edicion> list = getDTlist();
        List<DTInscripcion_Edicion> ret = new ArrayList<DTInscripcion_Edicion>();
        for (DTInscripcion_Edicion ins : list) {
            if (ins.edicionCurso.nombreEdicion.equals(nombreEdicion)) {
                ret.add(ins);
            }
        }
        return ret;
    }
}
