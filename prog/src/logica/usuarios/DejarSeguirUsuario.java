package logica.usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

import logica.entidades.Usuario;
import logica.formaciones.ObtenerFormacion;
import logica.entidades.Estudiante;
import logica.entidades.Formacion;
import logica.entidades.Curso;
import logica.entidades.Docente;

public class DejarSeguirUsuario {

	private String nickSeguido;
	private String nickSeguidor;

	public DejarSeguirUsuario(String nickName, String nickName2) {
		nickSeguido = nickName;
		nickSeguidor = nickName2;
	}
	
	public DejarSeguirUsuario() {}

	public String DejarSeguir()
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        int a = entitymanager.createQuery("delete from Seguir as s where s.Seguidor=("+"'"+nickSeguidor+"'"+") and s.Seguido=("+"'"+nickSeguido+"'"+")").executeUpdate();
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
        
        return "";
        
	}

}