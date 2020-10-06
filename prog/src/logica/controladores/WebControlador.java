package logica.controladores;

import API.datatypes.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import java.io.File;

import logica.cursos.*;
import logica.categorias.*;
import logica.edicioncursos.*;
import logica.formaciones.*;
import logica.inscripciones.InscripcionAEdicion;
import logica.inscripciones.ListaInscripciones;
import logica.institutos.*;
import logica.usuarios.*;
import API.*;

public class WebControlador implements IWeb {

	private static WebControlador controller = null;

	public static WebControlador getController() {
		if (controller == null) {
			controller = new WebControlador();
		}
		return controller;
	}

	private WebControlador() {
	}

	// Web Controller

	public boolean validateUser(String nick, String pass) {
		if (new ExisteUsuario().existeNickname(nick)) {
			if (new ObtenerUsuario().isEstudiante(nick)) {
				if (new ObtenerUsuario().getDTEstudianteByNickname(nick).passw.equals(pass)) {
					return true;
				} else {
					return false;
				}
			} else {
				if (new ObtenerUsuario().getDTDocenteByNickname(nick).passw.equals(pass)) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	public List<DTEdicionCurso> getDTEdicionCursoByDocente(String Nicknamedeltipo) {

		List<DTEdicionCurso> retur = new ListaEdicionCurso().getDataTypeListByDosente(Nicknamedeltipo);
		return retur;

	}

	public File getImagen(String folder, String name) {
		return ControladorImagen.getController().getImagen(name, folder, RutaDir.getController().getDir());
	}

	// Listas

	public List<DTInstituto> listaInstitutos() {
		return new ListaInstitutos().getDataTypeList();
	}

	public List<DTEstudiante> listaEstudiantes() {
		return new ListaUsuarios().getDataTypeListEstudiante();
	}

	public List<DTDocente> listaDocentes() {
		return new ListaUsuarios().getDataTypeListDocente();
	}

	public List<DTDocente> listaDocentesPorInstituto(String instituto) {
		List<DTDocente> listParcial = new ListaUsuarios().getDataTypeListDocente();
		List<DTDocente> list = new ArrayList();
		for (DTDocente dtDocente : list) {
			if (dtDocente.instituto.nombreInstituto.equals(instituto)) {
				list.add(dtDocente);
			}
		}
		return list;
	}

	public List<DTCurso> listaCursosPorInstituto(String nombreInstituto) {
		return new ListaCursos().getDataTypeListConInstituto(nombreInstituto);
	}

	public List<DTEdicionCurso> ListaEdicionesCurso(String nombreCurso) {
		return new ListaEdicionCurso().getDataTypeListByCurso(nombreCurso);
	}

	public List<DTCurso> ListaCursos() {
		return new ListaCursos().getDataTypeList();
	}
	
	public List<DTCurso> listaCursoPorCategoria(String cat){
		return new ListaCursos().getDataTypeListPorCat(cat);
	}

	public List<DTFormacion> listFormaciones() {
		return new ListaFormacion().getDataTypeList();
	}
	
	public List<DTFormacion> listaFormacionesPorCurso(String name){
		return new ListaFormacion().listaFormacionesPorCurso(name);
	}

	public List<DTInscripcion_Edicion> listaIns() {
		return new ListaInscripciones().getDTlist();
	}

	public List<DTCategoria> listaCat() {
		return new ListaCategoria().getDataTypeList();
	}

	public List<DTCategoria> listaCatDeFormacion(String nombreFormacion) {
		List<String> list = new ListaCategoria().getListPorFormacion(nombreFormacion);
		List<DTCategoria> dtCategorias = new ArrayList();
		for (String s : list) {
			DTCategoria curr = new DTCategoria(s);
			dtCategorias.add(curr);
		}
		return dtCategorias;
	}
	
	public List<DTInscripcion_Edicion> listaInscripcionesPorEstudiante(String nick){
		return new ListaInscripciones().getDTlistPorEstudiante(nick);
	}
	
	public List<DTInscripcion_Edicion> listaInscripcionesPorEdicion(String edicion){
		return new ListaInscripciones().getDTlistPorEdicion(edicion);
	}

	// Obtener DT

	public boolean existeUsuario(String nick) {
		return new ExisteUsuario().existeNickname(nick);
	}

	public DTEstudiante obtenerEstudiante(String nickname) {
		return new ObtenerUsuario().getDTEstudianteByNickname(nickname);
	}

	public DTDocente obtenerDocente(String nickname) {
		return new ObtenerUsuario().getDTDocenteByNickname(nickname);
	}

	public DTEdicionCurso obtenerEdicionCurso(String nombreEdicion) {
		return new ObtenerEdicionCurso().getDTEdicionCurso(nombreEdicion);
	}

	public DTCurso obtenerCurso(String nombrecurso) {
		return new ObtenerCurso().getDTCurso(nombrecurso);
	}

	public DTFormacion obtenerFormacion(String nombre) {
		return new ObtenerFormacion().getDTFormacion(nombre);
	}

	public DTInstituto obtenerInstituto(String name) {
		return new ObtenerInstituto(name).geDTInstituto();
	}

	public DTCategoria obtenerCategoria(String nombreCategoria) {
		return new ObtenerCategoria().geDTCategoria(nombreCategoria);
	}

	// public DTInscripcion_Edicion obtenerDTInscripcion_Edicion(String
	// nombreEdicion, String nickname) {
	// return
	// }

	// Alta Instituto

	public String crearInstituto(String nombre) {
		return new AltaInstituto().create(nombre);
	}

	// Alta de Usuario

	public String crearUsuarioEstudiante(String nickname, String nombre, String apellido, String mail, Date fechaNac,
			File imagen, String passw, String passw2) {

		if (passw.equals(passw2)) {
			String ret = new AltaUsuario(nickname, nombre, apellido, mail, fechaNac, passw).createEstudiante();
			if (ret.isEmpty()) {
				ControladorImagen i = ControladorImagen.getController();
				if (imagen != null) {
					try {
						System.out.println("imagino");
						i.setImagen(nickname, imagen, "usuarios", RutaDir.getController().getDir());
					} catch (Exception e) {
						System.out.println("Errovich");
					}
				}

			}
			return ret;
		} else {
			return "ERROR: La contrase�as ingresadas no son iguales, por favor revise los campos!\n";
		}

	}

	public String crearUsuarioDocente(String nickname, String nombre, String apellido, String mail, Date fechaNac,
			String instituto, File imagen, String passw, String passw2) {
		if (passw.equals(passw2)) {
			String ret = new AltaUsuario(nickname, nombre, apellido, mail, fechaNac, passw).createDocente(instituto);
			if (ret.isEmpty()) {
				ControladorImagen i = ControladorImagen.getController();
				if (imagen != null) {
					try {
						i.setImagen(nickname, imagen, "usuarios", RutaDir.getController().getDir());
					} catch (Exception e) {

					}
				}

			}
			return ret;
		} else {
			return "ERROR: La contrase�as ingresadas no son iguales, por favor revise los campos!\n";
		}

	}

	// Modificar Datos de Usuario

	public String ModificarUsuario(String nick, String nombre, String apellido, Date fechaNac, File imagen) {
		if (new ExisteUsuario().existeNickname(nick)) {
			// MODIFICAR IMAGEN SI NO ES NULO
			if (new ObtenerUsuario().isEstudiante(nick)) {

				return new ModificarUsuario(nick, nombre, apellido, fechaNac).modificarEstudiante();
			} else {
				return new ModificarUsuario(nick, nombre, apellido, fechaNac).modificarDocente();
			}
		} else {
			return "ERROR: No existe ese nickname, por favor ingrese uno correcto!";
		}

	}

	// Alta Curso

	public String crearCurso(String nombre, String desc, int Duracion, int CantHoras, int CantCred, String URL,
			Date Fecha, List<String> previas, String nombreInstituto, List<String> categorias, File imagen) {
		if (!new ExisteCurso().existeNombreCur(nombre)) {

			String ret = new AltaCurso(nombre, desc, Duracion, CantHoras, CantCred, URL, Fecha)
					.createCurso(nombreInstituto, previas, categorias);
			if (ret.isEmpty()) {
				ControladorImagen i = ControladorImagen.getController();
				if (imagen != null) {
					try {

						i.setImagen(nombre, imagen, "cursos", RutaDir.getController().getDir());
					} catch (Exception e) {
						System.out.println("Errovich");
					}
				}

			}
			return ret;
		} else {
			return "ERROR: YA existe ese nombre de curso, por favor ingrese uno nuevo!";
		}
	}

	// Alta edicion de Curso

	public String crearEdicion(String nombreEdicion, String curso, Date FechaInicio, Date FechaFin, int Cupo,
			Date fechaAlta, List<String> docentes, File imagen) {
		String ret = new AltaEdicionCurso(nombreEdicion, curso, FechaInicio, FechaFin, Cupo, fechaAlta)
				.createEdicionCurso(docentes);
		if (ret.isEmpty()) {
			ControladorImagen i = ControladorImagen.getController();
			if (imagen != null) {
				try {

					i.setImagen(nombreEdicion, imagen, "ediciones", RutaDir.getController().getDir());
				} catch (Exception e) {
					System.out.println("Errovich");
				}
			}

		}
		return ret;

	}

	// Crear Programa de Formacion

	public String crearFormacion(String nombreFormacion, String descr, Date FechaIni, Date FechaFin, Date FechaAlta,
			File imagen) {

		String ret = new AltaFormacion(nombreFormacion, descr, FechaIni, FechaFin, FechaAlta).createFormacion();
		if (ret.isEmpty()) {
			ControladorImagen i = ControladorImagen.getController();
			if (imagen != null) {
				try {

					i.setImagen(nombreFormacion, imagen, "formaciones", RutaDir.getController().getDir());
				} catch (Exception e) {
					System.out.println("Errovich");
				}
			}

		}
		return ret;
	}

	// Agregar Curso a Programa de Formaci�n

	public String AgregoCurEnForm(String nombreFormacion, List<String> nombreCursos) {
		return new AgregarCursoAFormacion(nombreFormacion).agregarCursosAFor(nombreCursos);
	}

	// Inscripcion a edicion de curso

	public String regInscDeUsrEnCurso(String nickname, String nombreEdicion, Date Finsc) {
		return new InscripcionAEdicion(nickname, Finsc, nombreEdicion).inscripcion();
	}

	// Consulta edicion Cursos

	public List<DTEdicionCurso> consultaEdicion(String nombreCurso) {
		return new ListaEdicionCurso().getDataTypeListByCurso(nombreCurso);
	}

	// Consulta de Programa de Formacion

	public List<DTFormacion> consultaFormacion() {
		return new ListaFormacion().getDataTypeList();
	}

	// Consulta Curso

	public List<DTCurso> consultaCurso(String nombreInstituto) {
		return new ListaCursos().getDataTypeListConInstituto(nombreInstituto);
	}

	// Consulta Usuario

	public boolean isEstudiante(String nickname) {
		return new ObtenerUsuario().isEstudiante(nickname);
	}

	public List<DTDocente> consultaUsuarioDocente() {
		return new ListaUsuarios().getDataTypeListDocente();
	}

	public List<DTEstudiante> consultaUsuarioEstudiante() {
		return new ListaUsuarios().getDataTypeListEstudiante();
	}

	// Alta categoria

	public String crearCategoria(String nombreCategoria) {
		return new AltaCategoria().create(nombreCategoria);
	}

}
