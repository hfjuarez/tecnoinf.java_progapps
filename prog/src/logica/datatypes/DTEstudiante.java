package logica.datatypes;

import java.sql.Date;

public class DTEstudiante extends DTUsuario {

	public DTEstudiante() {
		super();
	}

	public DTEstudiante(String nick, String name, String ape, String mail, Date nac) {
		super(nick, name, ape, mail, nac);

	}

}
