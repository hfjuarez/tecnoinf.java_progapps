package logica.cursos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import API.datatypes.DTValoracion;
import logica.entidades.Valoracion;

public class ExisteValoracion {

    public boolean existeValoracionPorCurso(String NombreCurso) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Valoracion val = null;
        if (NombreCurso != null) { 
            val = entitymanager.find(Valoracion.class, NombreCurso);

        } else {
            JOptionPane.showMessageDialog(null, " curso vacia ");
        }

        if (val != null) {
            ret = true;
        }
        entitymanager.close();
        emfactory.close();
        return ret;
    }

    public boolean existeValoracionPorAlumno(String Nick) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Valoracion val = null;
        if (Nick != null) { 
            val = entitymanager.find(Valoracion.class, Nick);

        } else {
            JOptionPane.showMessageDialog(null, " nick vacia ");
        }

        if (val != null) {
            ret = true;
        }
        entitymanager.close();
        emfactory.close();
        return ret;
    }

    public boolean existeValoracion(String nick, String nombrecurso)
    {
    	Valoraciones ListValoraciones=new Valoraciones(nick,nombrecurso,0);
        List<DTValoracion> valoraciones = ListValoraciones.ListDTValoraciones();
        for(DTValoracion val : valoraciones)
        {
            if(val.NombreCurso.equals(nombrecurso))
            {
            	if(val.nick.equals(nick))
            	{
            		return true;
            	}
            }
        }
        return false;
    }

}