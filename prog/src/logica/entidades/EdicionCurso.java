package logica.entidades;

import java.lang.String;
import java.sql.Date;
import java.util.*;
import javax.persistence.*;
import logica.entidades.Curso;

/**
 * Entity implementation class for Entity: EdicionCurso
 *
 */
@Entity
@Table
public class EdicionCurso {

	@Id
	private String nombreEdicion;
	@ManyToOne
	private Curso curso;
	private Date fechaInicio;
	private Date fechaFin;
	private int cupo;
	private Date fechaAltaEdicion;
	@OneToMany(targetEntity = Docente.class)
	private List docentes;
	@OneToMany(targetEntity = Inscripcion_Edicion.class)
	private List inscriptos;

	public EdicionCurso() {
		super();
	}

	public EdicionCurso(String ed, Curso cur, Date Fi, Date Ff, int cup, Date FAE, List Doc) {
		super();
		nombreEdicion = ed;
		curso = cur;
		fechaInicio = Fi;
		fechaFin = Ff;
		cupo = cup;
		fechaAltaEdicion = FAE;
		docentes = Doc;
		inscriptos=null;
	}

	public String getNombreEdicion() {
		return this.nombreEdicion;
	}

	public void setNombreEdicion(String nombreEdicion) {
		this.nombreEdicion = nombreEdicion;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaIncio) {
		this.fechaInicio = fechaIncio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCupo() {
		return this.cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public Date getFechaAltaEdicion() {
		return this.fechaAltaEdicion;
	}

	public void setFechaAltaEdicion(Date fechaAltaEdicion) {
		this.fechaAltaEdicion = fechaAltaEdicion;
	}

	public List getDocentes() {
		return this.docentes;
	}

	public void setDocentes(List docentes) {
		this.docentes = docentes;
	}

	public void addDocente(Docente docente) {
		this.docentes.add(docente);
	}

	public List getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List inscriptos) {
		this.inscriptos = inscriptos;
	}

}
