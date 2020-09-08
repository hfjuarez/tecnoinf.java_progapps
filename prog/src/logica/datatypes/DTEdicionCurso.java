package logica.datatypes;

import java.lang.String;
import java.sql.Date;
import java.util.*;

import logica.entidades.EdicionCurso;
import logica.entidades.Docente;

public class DTEdicionCurso {

	public String nombreEdicion;
	public DTCurso curso;
	public Date fechaIncio;
	public Date fechaFin;
	public int cupo;
	public Date fechaAltaEdicion;
	public List docentes;

	public DTEdicionCurso(EdicionCurso eCurso) {
		nombreEdicion = eCurso.getNombreEdicion();
		curso = new DTCurso(eCurso.getCurso());
		fechaIncio = eCurso.getFechaIncio();
		fechaFin = eCurso.getFechaFin();
		cupo = eCurso.getCupo();
		fechaAltaEdicion = eCurso.getFechaAltaEdicion();
		List<Docente> docentesList = eCurso.getDocentes();
		ArrayList<DTDocente> listDTDocentes = new ArrayList();
		for (Docente doc : docentesList) {
			DTDocente dtDoc = new DTDocente(doc);
			listDTDocentes.add(dtDoc);
		}
		docentes = listDTDocentes;
	}

	@Override
	public String toString() {
		return "DTEdicionCurso [nombreEdicion=" + nombreEdicion + ", curso=" + curso + ", fechaIncio=" + fechaIncio
				+ ", fechaFin=" + fechaFin + ", cupo=" + cupo + ", fechaAltaEdicion=" + fechaAltaEdicion + ", docentes="
				+ docentes + "]";
	}

}
