package logica.cursos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import logica.entidades.Curso;

public class ExisteCurso {

    public boolean existeNombreCur(String nombreCurso) {
        boolean ret = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();

        Curso est = null;
        if(nombreCurso!=null ) {
        	est = entitymanager.find(Curso.class, nombreCurso);
        }else {
        	JOptionPane.showMessageDialog(null, "Curso vacio ");
        }
        

        if (est != null) {
            ret = true;
        }
        entitymanager.close();
        emfactory.close();
        return ret;
    }

}