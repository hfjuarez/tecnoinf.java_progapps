package API.datatypes;

import logica.entidades.Curso;
import java.lang.String;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import logica.entidades.*;

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
	public List<DTCategoria> categorias;

	public DTCurso() {
		super();
	}

	public DTCurso(String nombreCurso, String descCurso, int duracionMeses, int cantidadHoras, int cantidadCreditos,
			String uRL, Date fechaAlta, DTInstituto instituto, List<DTCategoria> categorias) {
		super();
		this.nombreCurso = nombreCurso;
		this.descCurso = descCurso;
		this.duracionMeses = duracionMeses;
		this.cantidadHoras = cantidadHoras;
		this.cantidadCreditos = cantidadCreditos;
		URL = uRL;
		this.fechaAlta = fechaAlta;
		this.instituto = instituto;
		this.categorias = categorias;
	}

	public DTCurso(Curso curso) {
		super();
		this.nombreCurso = curso.getNombreCurso();
		this.descCurso = curso.getDescCurso();
		this.duracionMeses = curso.getDuracionSemanas();
		this.cantidadHoras = curso.getCantidadHoras();
		this.cantidadCreditos = curso.getCantidadCreditos();
		URL = curso.getURL();
		this.fechaAlta = curso.getFechaAlta();
		this.instituto = new DTInstituto(curso.getInstituto());

		List<Curso> previaList = curso.getPrevias();
		List<DTCurso> previaDTList = new ArrayList();

		for (Curso p : previaList) {
			DTCurso dtp = new DTCurso(p);
			previaDTList.add(dtp);
		}
		this.previas = previaDTList;

		List<Categoria> categoriasList = curso.getCategoria();
		List<DTCategoria> categoriasDTList = new ArrayList();

		for (Categoria ct : categoriasList) {
			DTCategoria dct = new DTCategoria(ct);
			categoriasDTList.add(dct);
		}
		this.categorias = categoriasDTList;

	}

	@Override
	public String toString() {
		return "DTCurso [nombreCurso=" + nombreCurso + ", descCurso=" + descCurso + ", duracionMeses=" + duracionMeses
				+ ", cantidadHoras=" + cantidadHoras + ", cantidadCreditos=" + cantidadCreditos + ", URL=" + URL
				+ ", fechaAlta=" + fechaAlta + ", instituto=" + instituto + ", previas=" + previas + ", categorias="
				+ categorias + "]";
	}

}
