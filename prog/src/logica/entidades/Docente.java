package logica.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import logica.entidades.Instituto;
import logica.entidades.Usuario;

/**
 * Entity implementation class for Entity: Docente
 *
 */
@Entity
@Table
public class Docente extends Usuario {

	// private Instituto instituto;
	// private static final long serialVersionUID = 1L;

	public Docente() {
		super();
	}

	public Docente(String nick, String name, String ape, String mail, Date nac, Instituto ins) {
		super(nick, name, ape, mail, nac);
		// instituto = ins;
	}

	public Instituto getInstituto() {
		// return this.instituto;
	}

	public void setInstituto(Instituto instituto) {
		// this.instituto = instituto;
	}

}
