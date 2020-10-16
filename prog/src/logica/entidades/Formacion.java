package logica.entidades;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Formacion
 *
 */
@Entity
@Table
public class Formacion {

	@Id
	private String nombreFormacion;
	private String descFormacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaAlta;

	@OneToMany(targetEntity = Curso.class)
	private List cursos;
	@OneToMany(targetEntity = Inscripcion_Formacion.class)
	private List inscriptos;

	public Formacion() {
		super();
	}

	public Formacion(String nombreFormacion, String descFormacion, Date fechaInicio, Date fechaFin, Date fechaAlta) {
		super();
		this.nombreFormacion = nombreFormacion;
		this.descFormacion = descFormacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaAlta = fechaAlta;
		this.cursos = null;
		this.inscriptos = null;
	}

	public String getNombreFormacion() {
		return this.nombreFormacion;
	}

	public void setNombreFormacion(String nombreFormacion) {
		this.nombreFormacion = nombreFormacion;
	}

	public String getDescFormacion() {
		return this.descFormacion;
	}

	public void setDescFormacion(String descFormacion) {
		this.descFormacion = descFormacion;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List getCursos() {
		return this.cursos;
	}

	public void setCursos(List cursos) {
		this.cursos = cursos;
	}

	public void addCurso(Curso cursoForm) {
		if (cursos == null) {
			cursos = new ArrayList<Curso>();
		}
		this.cursos.add(cursoForm);
	}

	public List<String> getCategorias() {
		List<String> cats = new ArrayList<String>();
		List<Curso> cursitos = cursos;
		for (Curso curso : cursitos) {
			List<Categoria> catsCurso = curso.getCategoria();
			for (Categoria cat : catsCurso) {
				cats.add(cat.getNombreCategoria());
			}
		}
		return cats;
	}
	
	public List getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List inscriptos) {
		this.inscriptos = inscriptos;
	}


}
