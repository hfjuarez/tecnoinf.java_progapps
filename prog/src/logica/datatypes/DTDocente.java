package logica.datatypes;

import java.sql.Date;

public class DTDocente extends DTUsuario {

	public DTInstituto instituto;

	public DTDocente() {
		super();
	}

	public DTDocente(String nick, String name, String ape, String mail, Date nac, DTInstituto ins) {
		super(nick, name, ape, mail, nac);
		instituto = ins;
	}

}
