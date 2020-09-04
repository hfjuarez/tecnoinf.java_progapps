package logica.usuarios;

import java.util.List;
import java.util.ArrayList;
import logica.datatypes.DTEstudiante;
import logica.datatypes.DTDocente;
import logica.entidades.Estudiante;
import logica.entidades.Docente;

public class ListaUsuarios {
   public List<Estudiante> getListEstudiante() {
        List<Estudiante> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select e from Estudiante e");
        list = (List<Estudiante>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;

    }

    public List<DTEstudiante> getDataTypeListEstudiante() {
        List<Estudiante> list = getList();
        List<DTEstudiante> listOfDT = new ArrayList();
        for (Estudiante estudiante : list) {
            DTEstudiante dtEstudiante = new DTEstudiante(estudiante);
            listOfDT.add(dtEstudiante);
        }
        return listOfDT;
    }
     public List<Docente> getListDocente() {
        List<Docente> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsuarioJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select d from Docente d");
        list = (List<Docente>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;

    }

    public List<DTDocente> getDataTypeListEstudiante() {
        List<Docente> list = getList();
        List<DTDocente> listOfDT = new ArrayList();
        for (Docente docente : list) {
            DTDocente dtDocente = new DTDocente(docente);
            listOfDT.add(dtDocente);
        }
        return listOfDT;
    }
}