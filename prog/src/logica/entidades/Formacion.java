package logica.entidades;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Formacion
 *
 */
@Entity

public class Formacion implements Serializable {

	   
	@Id
	private String nombreFormacion;
	private String descFormacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaAlta;
	private List cursos;
	private static final long serialVersionUID = 1L;

	public Formacion() {
		super();
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
   
}
