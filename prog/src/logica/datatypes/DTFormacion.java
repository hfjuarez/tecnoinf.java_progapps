package logica.datatypes;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import logica.entidades.Formacion;
import logica.entidades.Curso;

public class DTFormacion {

	public String nombreFormacion;
	public String descFormacion;
	public Date fechaInicio;
	public Date fechaFin;
	public Date fechaAlta;
	public List cursos;

	public DTFormacion() {
		super();
	}

	public DTFormacion(Formacion formacion) {
		super();
		this.nombreFormacion = formacion.getNombreFormacion();
		this.descFormacion = formacion.getDescFormacion();
		this.fechaInicio = formacion.getFechaInicio();
		this.fechaFin = formacion.getFechaFin();
		this.fechaAlta = formacion.getFechaAlta();

		List<Curso> cursosFormacion = formacion.getCursos();
		List<DTCurso> dtCursos = new ArrayList();

		for (Curso curso : cursosFormacion) {
			DTCurso dtCurso = new DTCurso(curso);
			dtCursos.add(dtCurso);
		}
		this.cursos = dtCursos; 

	}

}
