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

	public Estudiante() {
		super();
	}

	public Estudiante(String nick, String name, String ape, String mail, Date nac) {
		super(nick, name, ape, mail, nac);

	}

	public List getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion_Edicion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	@Override
	public String toString() {
		return "Estudiante [getNickname()=" + getNickname() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getMail()=" + getMail() + ", getFechaNac()=" + getFechaNac() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
