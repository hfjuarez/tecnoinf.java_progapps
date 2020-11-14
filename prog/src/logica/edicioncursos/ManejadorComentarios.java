package logica.edicioncursos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import API.datatypes.DTComentarios;
import API.datatypes.DTEdicionCurso;
import logica.entidades.Comentarios;
import logica.entidades.ContCom;
import logica.entidades.Docente;
import logica.entidades.EdicionCurso;

public class ManejadorComentarios {

	public String AltaComentario(String out,String nik,String edi)
	{
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        
        if(entitymanager.find(ContCom.class,"buenazo")==null)
        {
        	entitymanager.getTransaction().begin();
            ContCom ret =new ContCom();
            entitymanager.persist(ret);
            entitymanager.getTransaction().commit();
        }
        
        ContCom ret = entitymanager.find(ContCom.class,"buenazo");
        
		entitymanager.getTransaction().begin();
		int id = ret.getCont();
		Comentarios comentario = new Comentarios(out,nik,edi,id);
		entitymanager.persist(comentario);
		entitymanager.getTransaction().commit();
		
		entitymanager.getTransaction().begin();
		int r= id+1;
		ret.setCont(r);
		//int a = entitymanager.createQuery("update ContCom set cont="+r+" where nefasto='buenazo'").executeUpdate();
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emfactory.close();
	
		
		return "";
	}
	
	public String AltaRespuesta(int idCom,String nik,String edi,String out)
	{
		ContCom ret = null;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        String dou = AltaComentario(out,nik,edi);
        
        entitymanager.getTransaction().begin();
        ret = entitymanager.find(ContCom.class,"buenazo");
        Comentarios ret2=null;
        ret2 = entitymanager.find(Comentarios.class, idCom);
        Comentarios ret3 = entitymanager.find(Comentarios.class, ret.getCont()-1);
        List<Comentarios> coms = ret2.getRespuestas();
        if(coms==null)
        {
        	coms = new ArrayList<Comentarios>();
        }
        coms.add(ret3);
        ret2.setRespuestas(coms);
		entitymanager.getTransaction().commit();
		
        entitymanager.close();
        emfactory.close();
        
        
		return "";
	}
	
	 public List<Comentarios> getList() {
	        List<Comentarios> list = null;
	        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
	        EntityManager entitymanager = emfactory.createEntityManager();

	        Query query = entitymanager.createQuery("Select i from Comentarios as i");
	        list = (List<Comentarios>) query.getResultList();

	        entitymanager.close();
	        emfactory.close();
	        return list;
	    }

	 public List<DTComentarios> getDataTypeList() {
	        List<Comentarios> list = getList();
	        List<DTComentarios> listOfDT = new ArrayList();
	        for (Comentarios ec : list) {
	            DTComentarios dtEC = new DTComentarios(ec);
	            listOfDT.add(dtEC);
	        }
	        return listOfDT;
	    }
	
}
