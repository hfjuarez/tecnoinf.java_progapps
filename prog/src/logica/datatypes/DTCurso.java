package logica.datatypes;

import java.lang.String;
import java.sql.Date;
import java.util.List;

public class DTCurso {

	public String nombreCurso;
	public String descCurso;
	public int duracionMeses;
	public int cantidadHoras;
	public int cantidadCreditos;
	public String URL;
	public Date fechaAlta;
	public DTInstituto instituto;
	public List previas;

	public DTCurso() {
		super();
	}

	public DTCurso(String nombreCurso, String descCurso, int duracionMeses, int cantidadHoras, int cantidadCreditos,
			String uRL, Date fechaAlta, DTInstituto instituto) {
		super();
		this.nombreCurso = nombreCurso;
		this.descCurso = descCurso;
		this.duracionMeses = duracionMeses;
		this.cantidadHoras = cantidadHoras;
		this.cantidadCreditos = cantidadCreditos;
		URL = uRL;
		this.fechaAlta = fechaAlta;
		this.instituto = instituto;
	}

}
