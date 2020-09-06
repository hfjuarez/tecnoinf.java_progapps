package logica.datatypes;

import java.sql.Date;
import logica.entidades.Estudiante;

public class DTEstudiante extends DTUsuario {

	public DTEstudiante() {
		super();
	}

	public DTEstudiante(Estudiante estudiante) {
		super(estudiante.getNickname(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getMail(),
				estudiante.getFechaNac());
	}

	public DTEstudiante(String nick, String name, String ape, String mail, Date nac) {
		super(nick, name, ape, mail, nac);
	}

	@Override
	public String toString() {
		return "DTEstudiante [nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", fechaNac=" + fechaNac + ", image=" + image + "]";
	}

}
