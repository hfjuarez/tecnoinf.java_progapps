package logica.cursos;

import logica.entidades.Valoracion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import API.datatypes.DTValoracion;

public class ObtenerValoracion {

    public Valoracion getValoracionPorCurso(String nombrecurso) {

        ExisteValoracion existevalcur = new ExisteValoracion();
        if (existevalcur.existeValoracionPorCurso(nombrecurso)) {
            Valoracion valc = new Valoracion();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            valc = entitymanager.find(Valoracion.class, nombrecurso);
            entitymanager.close();
            emfactory.close();
            return valc;

        } else {
            return null;
        }

    }

    public DTValoracion getDTValoracionPorCurso(String nombrecurso) {
        Valoracion valoracion = getValoracionPorCurso(nombrecurso);
        return new DTValoracion(valoracion.getNick(),valoracion.getNombreCurso(),valoracion.getRating());
    }

    public Valoracion getValoracionPorAlumno(String nick) {

        ExisteValoracion existevalalu = new ExisteValoracion();
        if (existevalalu.existeValoracionPorAlumno(nick)) {
            Valoracion vala = new Valoracion();

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
            EntityManager entitymanager = emfactory.createEntityManager();
            vala = entitymanager.find(Valoracion.class, nick);
            entitymanager.close();
            emfactory.close();
            return vala;

        } else {
            return null;
        }

    }

    public DTValoracion getDTValoracionPorAlumno(String nick) {
        Valoracion valoracion = getValoracionPorAlumno(nick);
        return new DTValoracion(valoracion.getNick(),valoracion.getNombreCurso(),valoracion.getRating());
    }

}
