package logica.cursos;

import logica.entidades.Valoracion;
import API.datatypes.*;
import logica.entidades.Curso;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Valoraciones {

    public String nickuser;
    public String nombreCurso;
    public int puntaje;

    public Valoraciones(String Nick, String Curso, int puntos)
    {
        nickuser = Nick;
        nombreCurso = Curso;
        puntaje = puntos;
    }
    
    private String hasErrorAlredyExists() {

        ExisteValoracion existv = new ExisteValoracion();
        String ret = "";
        if (existv.existeValoracion(nickuser,nombreCurso))
            ret = ret + "ERROR: Ya existe una valoracion para este curso";

        return ret;
    }    

    public List<Valoracion> ListValoraciones()
    {
        List<Valoracion> valoraciones=null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery("Select i from Valoracion as i");

        valoraciones = (List<Valoracion>) query.getResultList();

        entitymanager.close();
        emfactory.close();
        return valoraciones;
    }

    public List<DTValoracion> ListDTValoraciones()
    {
        List<DTValoracion> DTValoraciones=new ArrayList();
        List<Valoracion> valo=ListValoraciones();
        for(Valoracion val : valo)
        {
            DTValoracion dou=new DTValoracion();
            dou.nick=val.getNick();
            dou.NombreCurso=val.getNombreCurso();
            dou.rating=val.getRating();
            DTValoraciones.add(dou);
        }
        return DTValoraciones;
    }
    

    public String CrearValoracion()
    {
        String retorno = hasErrorAlredyExists();
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        if(retorno.isEmpty()) {

            Valoracion buenardo = new Valoracion();
            buenardo.setNick(nickuser);
            buenardo.setNombreCurso(nombreCurso);
            buenardo.setRating(puntaje);

            entitymanager.persist(buenardo);

            entitymanager.getTransaction().commit();
            entitymanager.close();
            emfactory.close();
            
            HacerPromedioPuntuacion(nombreCurso);

        }

        return retorno;
     
    }
    
    public void HacerPromedioPuntuacion(String nombreCurso)
    {
    	int promediazo=0,cont=0;
    	List<DTValoracion> valoraciones = new ArrayList();
    	valoraciones=ListDTValoraciones();
    	for(DTValoracion valoracion : valoraciones)
    	{
    		if(valoracion.NombreCurso.equals(nombreCurso))
    		{
    			promediazo=promediazo+valoracion.rating;
    			cont++;
    		}
    	}
    	promediazo=promediazo/cont; 	
    	    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
    	    EntityManager entitymanager = emfactory.createEntityManager();
    	    entitymanager.getTransaction().begin();
    	    
    	    Curso curso = entitymanager.find(Curso.class, nombreCurso);
    	    
    	    curso.setValoracionPromedio(promediazo);
    	    
    	    entitymanager.getTransaction().commit();
            entitymanager.close();
            emfactory.close();
    	    
    }
    
    
    
    
}
