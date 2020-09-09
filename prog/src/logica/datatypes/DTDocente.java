package logica.datatypes;

import logica.entidades.Docente;

import java.sql.Date;

public class DTDocente extends DTUsuario {

	public DTInstituto instituto;

	public DTDocente() {
		super();
	}

public DTDocente(Docente docente) {
		super(docente.getNickname(), docente.getNombre(), docente.getApellido(), docente.getMail(),
				docente.getFechaNac());
		instituto = new DTInstituto(docente.getInstituto());
	}

	public DTDocente(String nick, String name, String ape, String mail, Date nac, DTInstituto ins) {
		super(nick, name, ape, mail, nac);
		instituto = ins;
	}

	@Override
	public String toString() {
		return "DTDocente [instituto=" + instituto + ", nickname=" + nickname + ", nombre=" + nombre + ", apellido="
				+ apellido + ", mail=" + mail + ", fechaNac=" + fechaNac + ", image=" + image + "]";
	}

}
