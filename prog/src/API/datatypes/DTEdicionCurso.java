package API.datatypes;

import java.lang.String;
import java.sql.Date;
import java.util.*;

import logica.entidades.EdicionCurso;
import logica.entidades.Docente;
import logica.entidades.*;

public class DTEdicionCurso {

	public String nombreEdicion;
	public DTCurso curso;
	public String fechaIncio;
	public String fechaFin;
	public int cupo;
	public String fechaAltaEdicion;
	public List docentes;
	public List inscriptos;
	public boolean cerrado;

	public DTEdicionCurso(EdicionCurso eCurso) {
		nombreEdicion = eCurso.getNombreEdicion();
		curso = new DTCurso(eCurso.getCurso());
		fechaIncio = eCurso.getFechaInicio().toString();
		fechaFin = eCurso.getFechaFin().toString();
		cupo = eCurso.getCupo();
		fechaAltaEdicion = eCurso.getFechaAltaEdicion().toString();
		List<Docente> docentesList = eCurso.getDocentes();
		ArrayList<DTDocente> listDTDocentes = new ArrayList();
		for (Docente doc : docentesList) {
			DTDocente dtDoc = new DTDocente(doc);
			listDTDocentes.add(dtDoc);
		}
		docentes = listDTDocentes;
		List<Inscripcion_Edicion> estudiantesList = eCurso.getInscriptos();
		ArrayList<DTInscripcion_Edicion> inscripto = new ArrayList();
		for (Inscripcion_Edicion insc : estudiantesList) {
			DTInscripcion_Edicion ins = new DTInscripcion_Edicion(insc);
			inscripto.add(ins);
		}
		this.inscriptos = inscripto;
		this.cerrado = eCurso.getCerrado();
	}

	@Override
	public String toString() {
		return "DTEdicionCurso [nombreEdicion=" + nombreEdicion + ", curso=" + curso + ", fechaIncio=" + fechaIncio
				+ ", fechaFin=" + fechaFin + ", cupo=" + cupo + ", fechaAltaEdicion=" + fechaAltaEdicion + ", docentes="
				+ docentes + "]";
	}

}
