package logica.usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import API.datatypes.DTEstudiante;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import logica.entidades.Usuario;
import logica.formaciones.ObtenerFormacion;
import logica.entidades.Estudiante;
import logica.entidades.Formacion;
import logica.entidades.Seguir;
import logica.entidades.Curso;
import logica.entidades.Docente;
import API.datatypes.*;

public class SeguirUsuario {

	private String nickSeguido;
	private String nickSeguidor;

	public SeguirUsuario(String nickName, String nickName2) {
		nickSeguido = nickName;
		nickSeguidor = nickName2;
	}
	
	public SeguirUsuario(){}

	public String Seguirr()
	{
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        Seguir seg = new Seguir();
        seg.setSeguido(nickSeguido);
        seg.setSeguidor(nickSeguidor);
        
        
        entitymanager.persist(seg);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        
        return "";
        
	}
	
	public List<Seguir> getList()
	{
	        List<Seguir> list = null;
	        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
	        EntityManager entitymanager = emfactory.createEntityManager();

	        Query query = entitymanager.createQuery("Select s from Seguir as s");
	        list = (List<Seguir>) query.getResultList();

	        entitymanager.close();
	        emfactory.close();
	        return list;

	}
	
	 public List<DTSeguir> getDataTypeListSeguir() {
	        List<Seguir> list = getList();
	        List<DTSeguir> listOfDT = new ArrayList();
	        for (Seguir estudiante : list) {
	            DTSeguir dtEstudiante = new DTSeguir(estudiante.getSeguidor(),estudiante.getSeguido());
	            listOfDT.add(dtEstudiante);
	        }
	        return listOfDT;
	    }
	
	
	
	public List<String> seguidores(String seguid)
	{
		List<DTSeguir> list = new ArrayList<DTSeguir>();
		List<String> lists = new ArrayList<String>();
		list=getDataTypeListSeguir();
		for(DTSeguir seguido : list)
		{
			if(seguid.equals(seguido.Seguido))
			{
				lists.add("'"+seguido.Seguidor+"'");
			}
		}
		
		
		return lists;
	}
}