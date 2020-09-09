package logica.entidades;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import logica.entidades.Usuario;

/**
 * Entity implementation class for Entity: Estudiante
 *
 */
@Entity
@Table()

public class Estudiante extends Usuario {

	public Estudiante() {
		super();
	}

	public Estudiante(String nick, String name, String ape, String mail, Date nac) {
		super(nick, name, ape, mail, nac);
		
	}

	@Override
	public String toString() {
		return "Estudiante [getNickname()=" + getNickname() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getMail()=" + getMail() + ", getFechaNac()=" + getFechaNac() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
