package logica.edicioncurso;

import logica.entidades.EdicionCurso;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import logica.entidades.Curso;

public class ListaEdicionCurso {

    public List<EdicionCurso> getList() {
        List<Curso> list = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select i from EdicionCurso as i");
        list = (List<EdicionCurso>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return list;
    }

    public getlistByCurso(String NombreCurso)
    {
        List<EdicionCurso> list = getList();
        for(EdicionCurso edicioncurso : list){
            
            List<EdicionCurso> EdicionCursosFiltrados = new ArrayList();
            if(NombreCurso.equals(edicioncurso.getCurso().getNombreCurso())){
                EdicionCursosFiltrados.add(edicioncurso);
                
            }
        }
        
        return EdicionCursosFiltrados;
    }                
    
}