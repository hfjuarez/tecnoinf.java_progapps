package API.datatypes;

import java.util.*;
import java.sql.Date;
import logica.entidades.Estudiante;

public class DTEstudiante extends DTUsuario {

	public List inscripciones;

	public DTEstudiante() {
		super();
	}

	public DTEstudiante(Estudiante estudiante) {
		super(estudiante.getNickname(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getMail(),
				estudiante.getFechaNac(), estudiante.getPass());
	}

	public DTEstudiante(String nick, String name, String ape, String mail, Date nac, String passp) {
		super(nick, name, ape, mail, nac, passp);
	}

	@Override
	public String toString() {
		return "DTEstudiante [nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", fechaNac=" + fechaNac + ", image=" + image + "]";
	}

}
