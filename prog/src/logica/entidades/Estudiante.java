package logica.entidades;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

import javax.persistence.*;
import logica.entidades.Usuario;

/**
 * Entity implementation class for Entity: Estudiante
 *
 */
@Entity
@Table()

public class Estudiante extends Usuario {

	@OneToMany(targetEntity = Inscripcion_Edicion.class)
	private List inscripciones;
	
	@OneToMany(targetEntity = Inscripcion_Formacion.class)
	private List insc_formacion;

	public Estudiante() {
		super();
	}

	public Estudiante(String nick, String name, String ape, String mail, Date nac, String passp) {
		super(nick, name, ape, mail, nac, passp);
		inscripciones=null;
		insc_formacion=null;

	}

	public List getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion_Edicion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	public List getInscFormacion() {
		return insc_formacion;
	}

	public void setInscFormacion(List<Inscripcion_Formacion> insc_formacion) {
		this.insc_formacion = insc_formacion;
	}



}
