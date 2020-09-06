package logica.datatypes;

import logica.entidades.Curso;
import java.lang.String;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class DTCurso {

	public String nombreCurso;
	public String descCurso;
	public int duracionMeses;
	public int cantidadHoras;
	public int cantidadCreditos;
	public String URL;
	public Date fechaAlta;
	public DTInstituto instituto;
	public List<DTCurso> previas;

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

	public DTCurso(Curso curso) {
		super();
		this.nombreCurso = curso.getNombreCurso();
		this.descCurso = curso.getDescCurso();
		this.duracionMeses = curso.getDuracionMeses();
		this.cantidadHoras = curso.getCantidadHoras();
		this.cantidadCreditos = curso.getCantidadCreditos();
		URL = curso.getURL();
		this.fechaAlta = curso.getFechaAlta();
		this.instituto = new DTInstituto(curso.getInstituto());
		List<Curso> previaList = new ArrayList();
		previaList = curso.getPrevias();

		List<DTCurso> previaDTList = new ArrayList();

		for (Curso p : previaList) {
			DTCurso dtp = new DTCurso(p);
			previaDTList.add(dtp);
		}
		this.previas = previaDTList;
	}

}
