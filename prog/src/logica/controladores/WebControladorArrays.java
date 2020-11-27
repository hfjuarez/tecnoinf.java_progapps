package logica.controladores;

import java.util.Arrays;
import java.util.Calendar;
import API.datatypes.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.io.IOException;

import java.io.File;

import logica.cursos.*;
import logica.categorias.*;
import logica.edicioncursos.*;
import logica.entidades.EdicionCurso;
import logica.entidades.Valoracion;
import logica.entidades.Inscripcion_Edicion;
import logica.formaciones.*;
import logica.inscripciones.InscripcionAEdicion;
import logica.inscripciones.ListaInscripciones;
import logica.inscripciones.InscripcionAFormacion;
import logica.inscripciones.ListaInscripcionesFor;
import logica.institutos.*;
import logica.usuarios.*;
import API.*;

public class WebControladorArrays implements IWebArrays {

	private static WebControladorArrays controller = null;

	public static WebControladorArrays getController() {
		if (controller == null) {
			controller = new WebControladorArrays();
		}
		return controller;
	}

	private WebControladorArrays() {
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

	public String[] listaNicknames() {
		// ArrayList<DTComentarios>l = new ArrayList(new
		// ManejadorComentarios().getDataTypeList());
		// return (DTComentarios[]) l.toArray();

		ArrayList<String> nickis = new ArrayList<String>();
		ArrayList<DTDocente> ld = new ArrayList<DTDocente>(new ListaUsuarios().getDataTypeListDocente());
		for (DTDocente d : ld) {
			String s = "'" + d.nickname + "'";
			nickis.add(s);
		}

		ArrayList<DTEstudiante> le = new ArrayList<DTEstudiante>(new ListaUsuarios().getDataTypeListEstudiante());
		for (DTEstudiante d : le) {
			String s = "'" + d.nickname + "'";
			nickis.add(s);
		}

		String[] ret = new String[nickis.size()];

		int i = 0;
		for (String ins : nickis) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public String[] listaEmails() {
		ArrayList<String> mails = new ArrayList<String>();
		ArrayList<DTDocente> ld = new ArrayList<DTDocente>(new ListaUsuarios().getDataTypeListDocente());
		for (DTDocente d : ld) {
			String s = "'" + d.mail + "'";
			mails.add(s);
		}

		ArrayList<DTEstudiante> le = new ArrayList<DTEstudiante>(new ListaUsuarios().getDataTypeListEstudiante());
		for (DTEstudiante d : le) {
			String s = "'" + d.mail + "'";
			mails.add(s);
		}

		String[] ret = new String[mails.size()];

		int i = 0;
		for (String ins : mails) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTEdicionCurso[] getDTEdicionCursoByDocente(String Nicknamedeltipo) {

		// ArrayList<DTComentarios>l = new ArrayList(new
		// ManejadorComentarios().getDataTypeList());
		// return (DTComentarios[]) l.toArray();
		ArrayList<DTEdicionCurso> retur = new ArrayList<DTEdicionCurso>(
				new ListaEdicionCurso().getDataTypeListByDosente(Nicknamedeltipo));

		DTEdicionCurso[] ret = new DTEdicionCurso[retur.size()];

		int i = 0;
		for (DTEdicionCurso ins : retur) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public File getImagen(String folder, String name) {
		return ControladorImagen.getController().getImagen(name, folder, RutaDir.getController().getDir());
	}

	public boolean setImagen(String folder, String name, File img) {
		try {
			ControladorImagen.getController().setImagen(name, img, folder, RutaDir.getController().getDir());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public DTFormacion[] BusquedaFiltroFormacion(String busqueda) {
		ArrayList<DTFormacion> l = new ArrayList<DTFormacion>(new ListaFormacion().BusquedaFiltro(busqueda));
		DTFormacion[] ret = new DTFormacion[l.size()];
		int i = 0;
		for (DTFormacion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}

		}
		return ret;

	}

	public DTCurso[] BusquedaFiltroCurso(String busqueda) {
		ArrayList<DTCurso> l = new ArrayList<DTCurso>(new ListaCursos().BusquedaFiltro(busqueda));

		DTCurso[] ret = new DTCurso[l.size()];

		int i = 0;
		for (DTCurso ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	// Listas

	public DTInstituto[] listaInstitutos() {
		ArrayList<DTInstituto> l = new ArrayList<DTInstituto>(new ListaInstitutos().getDataTypeList());
		DTInstituto[] ret = new DTInstituto[l.size()];
		int i = 0;
		for (DTInstituto ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}

		}
		return ret;
	}

	public DTEstudiante[] listaEstudiantes() {
		ArrayList<DTEstudiante> l = new ArrayList<DTEstudiante>(new ListaUsuarios().getDataTypeListEstudiante());
		DTEstudiante[] ret = new DTEstudiante[l.size()];

		int i = 0;
		for (DTEstudiante ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public DTDocente[] listaDocentes() {
		ArrayList<DTDocente> l = new ArrayList<DTDocente>(new ListaUsuarios().getDataTypeListDocente());

		DTDocente[] ret = new DTDocente[l.size()];

		int i = 0;
		for (DTDocente ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTDocente[] listaDocentesPorInstituto(String instituto) {
		List<DTDocente> listParcial = new ListaUsuarios().getDataTypeListDocente();
		ArrayList<DTDocente> list = new ArrayList<DTDocente>();
		for (DTDocente dtDocente : listParcial) {
			if (dtDocente.instituto.nombreInstituto.equals(instituto)) {
				list.add(dtDocente);
			}
		}

		DTDocente[] ret = new DTDocente[list.size()];

		int i = 0;
		for (DTDocente ins : list) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTCurso[] listaCursosPorInstituto(String nombreInstituto) {
		ArrayList<DTCurso> l = new ArrayList<DTCurso>(new ListaCursos().getDataTypeListConInstituto(nombreInstituto));

		DTCurso[] ret = new DTCurso[l.size()];

		int i = 0;
		for (DTCurso ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTEdicionCurso[] ListaEdicionesCurso(String nombreCurso) {

		ArrayList<DTEdicionCurso> l = new ArrayList<DTEdicionCurso>(
				new ListaEdicionCurso().getDataTypeListByCurso(nombreCurso));

		DTEdicionCurso[] ret = new DTEdicionCurso[l.size()];

		int i = 0;
		for (DTEdicionCurso ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public DTInscripcion_Formacion[] listaInsFor() {
		ArrayList<DTInscripcion_Formacion> l = new ArrayList<DTInscripcion_Formacion>(
				new ListaInscripcionesFor().getDTlist());
		DTInscripcion_Formacion[] ret = new DTInscripcion_Formacion[l.size()];

		int i = 0;
		for (DTInscripcion_Formacion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTCurso[] ListaCursos() {
		ArrayList<DTCurso> l = new ArrayList<DTCurso>(new ListaCursos().getDataTypeList());
		DTCurso[] ret = new DTCurso[l.size()];

		int i = 0;
		for (DTCurso ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTCurso[] listaCursoPorCategoria(String cat) {
		ArrayList<DTCurso> l = new ArrayList<DTCurso>(new ListaCursos().getDataTypeListPorCat(cat));

		DTCurso[] ret = new DTCurso[l.size()];

		int i = 0;
		for (DTCurso ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTFormacion[] listFormaciones() {
		ArrayList<DTFormacion> l = new ArrayList<DTFormacion>(new ListaFormacion().getDataTypeList());

		DTFormacion[] ret = new DTFormacion[l.size()];

		int i = 0;
		for (DTFormacion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public DTFormacion[] listaFormacionesPorCurso(String name) {

		ArrayList<DTFormacion> l = new ArrayList<DTFormacion>(new ListaFormacion().listaFormacionesPorCurso(name));

		DTFormacion[] ret = new DTFormacion[l.size()];

		int i = 0;
		for (DTFormacion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTInscripcion_Edicion[] listaIns() {
		ArrayList<DTInscripcion_Edicion> l = new ArrayList<DTInscripcion_Edicion>(new ListaInscripciones().getDTlist());

		DTInscripcion_Edicion[] ret = new DTInscripcion_Edicion[l.size()];

		int i = 0;
		for (DTInscripcion_Edicion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public DTCategoria[] listaCat() {
		ArrayList<DTCategoria> l = new ArrayList<DTCategoria>(new ListaCategoria().getDataTypeList());

		DTCategoria[] ret = new DTCategoria[l.size()];

		int i = 0;
		for (DTCategoria ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTCategoria[] listaCatDeFormacion(String nombreFormacion) {
		List<String> list = new ListaCategoria().getListPorFormacion(nombreFormacion);
		ArrayList<DTCategoria> dtCategorias = new ArrayList<DTCategoria>();
		for (String s : list) {
			DTCategoria curr = new DTCategoria(s);
			dtCategorias.add(curr);
		}

		DTCategoria[] ret = new DTCategoria[dtCategorias.size()];

		int i = 0;
		for (DTCategoria ins : dtCategorias) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTInscripcion_Edicion[] listaInscripcionesPorEstudiante(String nick) {
		ArrayList<DTInscripcion_Edicion> l = new ArrayList<DTInscripcion_Edicion>(
				new ListaInscripciones().getDTlistPorEstudiante(nick));

		DTInscripcion_Edicion[] ret = new DTInscripcion_Edicion[l.size()];

		int i = 0;
		for (DTInscripcion_Edicion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public DTInscripcion_Edicion[] listaInscripcionesPorEdicion(String edicion) {
		ArrayList<DTInscripcion_Edicion> l = new ArrayList<DTInscripcion_Edicion>(
				new ListaInscripciones().getDTlistPorEdicion(edicion));

		DTInscripcion_Edicion[] ret = new DTInscripcion_Edicion[l.size()];

		int i = 0;
		for (DTInscripcion_Edicion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTInscripcion_Formacion[] listaInscForPorEstudiante(String nick) {
		ArrayList<DTInscripcion_Formacion> l = new ArrayList<DTInscripcion_Formacion>(
				new ListaInscripcionesFor().getDTlistPorEstudiante(nick));

		DTInscripcion_Formacion[] ret = new DTInscripcion_Formacion[l.size()];

		int i = 0;
		for (DTInscripcion_Formacion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public DTInscripcion_Formacion[] listaInscForPorFormacion(String formacion) {

		ArrayList<DTInscripcion_Formacion> l = new ArrayList<DTInscripcion_Formacion>(
				new ListaInscripcionesFor().getDTlistPorFormacion(formacion));

		DTInscripcion_Formacion[] ret = new DTInscripcion_Formacion[l.size()];

		int i = 0;
		for (DTInscripcion_Formacion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

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

	public DTEdicionCurso getEdicionActual(String nombreCurso) {
		DTEdicionCurso[] list = ListaEdicionesCurso(nombreCurso);
		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
		String annio = Integer.toString(c.get(Calendar.YEAR));
		Date fechaActual = Date.valueOf(annio + "-" + mes + "-" + dia);

		for (DTEdicionCurso ediCavani : list) {

			if (ediCavani.fechaFin.compareTo(fechaActual.toString()) >= 0) {
				return ediCavani;
			}
		}
		return null;
	}

	public void cambiarestado(String solteroHastaLaTumba, String ediCavani, String nik) {
		new InscripcionAEdicion().cambiarestado(solteroHastaLaTumba, ediCavani, nik);
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

	public String crearUsuarioEstudiante(String nickname, String nombre, String apellido, String mail, String fechaNac,
			File imagen, String passw, String passw2) {

		if (passw.equals(passw2)) {
			Date fecha1 = Date.valueOf(fechaNac);
			String ret = new AltaUsuario(nickname, nombre, apellido, mail, fecha1, passw).createEstudiante();
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

	public String crearUsuarioDocente(String nickname, String nombre, String apellido, String mail, String fechaNac,
			String instituto, File imagen, String passw, String passw2) {
		if (passw.equals(passw2)) {
			Date fecha1 = Date.valueOf(fechaNac);
			String ret = new AltaUsuario(nickname, nombre, apellido, mail, fecha1, passw).createDocente(instituto);
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

	public String ModificarUsuario(String nick, String nombre, String apellido, String fechaNac, File imagen) {
		if (new ExisteUsuario().existeNickname(nick)) {
			// MODIFICAR IMAGEN SI NO ES NULO
			if (new ObtenerUsuario().isEstudiante(nick)) {
				Date fecha1 = Date.valueOf(fechaNac);
				return new ModificarUsuario(nick, nombre, apellido, fecha1).modificarEstudiante();
			} else {
				Date fecha2 = Date.valueOf(fechaNac);
				return new ModificarUsuario(nick, nombre, apellido, fecha2).modificarDocente();
			}
		} else {
			return "ERROR: No existe ese nickname, por favor ingrese uno correcto!";
		}

	}

	// Seguir Usuario

	// public String SeguirUsuario(String nickName, String nickName2) {
	// if (new ObtenerUsuario().isEstudiante(nickName)) {
	// return new SeguirUsuario(nickName, nickName2).SeguirUserEstudiante();
	// } else {
	// return new SeguirUsuario(nickName, nickName2).SeguirUserDocente();
	// }
	// }

	// Dejar de Seguir usuario

	public String DejarSeguirUsuario(String nickName, String nickName2) {
		return new DejarSeguirUsuario(nickName, nickName2).DejarSeguir();
	}

	// Este me sigue

	public String SeguirUsuarioo(String este1, String este2) {
		return new SeguirUsuario(este1, este2).Seguirr();
	}

	// Alta Curso

	public String crearCurso(String nombre, String desc, int Duracion, int CantHoras, int CantCred, String URL,
			String Fecha, String[] previas, String nombreInstituto, String[] categorias, File imagen) {
		if (!new ExisteCurso().existeNombreCur(nombre)) {
			ArrayList<String> listC = new ArrayList<String>();

			for (String ins : categorias) {
				listC.add(ins);
			}

			ArrayList<String> listP = new ArrayList<String>();

			for (String ins : previas) {
				listP.add(ins);
			}
			Date fecha1 = Date.valueOf(Fecha);
			String ret = new AltaCurso(nombre, desc, Duracion, CantHoras, CantCred, URL, fecha1)
					.createCurso(nombreInstituto, listP, listC);
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

	public String crearEdicion(String nombreEdicion, String curso, String FechaInicio, String FechaFin, int Cupo,
			String fechaAlta, String[] docentes, File imagen) {

		ArrayList<String> listD = new ArrayList<String>();

		for (String ins : docentes) {
			listD.add(ins);
		}
		Date fechaA = Date.valueOf(fechaAlta);
		Date fechaF = Date.valueOf(FechaFin);
		Date fechaI = Date.valueOf(FechaInicio);

		String ret = new AltaEdicionCurso(nombreEdicion, curso, fechaI, fechaF, Cupo, fechaA).createEdicionCurso(listD);
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

	public void asignarNotaAEstudianteEdicionCurso(int nota, String ediCavani, String nik) {
		new InscripcionAEdicion().asignarNota(nota, ediCavani, nik);
	}

	// Crear Programa de Formacion

	public String crearFormacion(String nombreFormacion, String descr, String FechaIni, String FechaFin,
			String FechaAlta, File imagen) {
		Date fechaF = Date.valueOf(FechaFin);
		Date fechaI = Date.valueOf(FechaIni);
		Date fechaA = Date.valueOf(FechaAlta);

		String ret = new AltaFormacion(nombreFormacion, descr, fechaF, fechaI, fechaA).createFormacion();
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

	public String AgregoCurEnForm(String nombreFormacion, String[] nombreCursos) {

		ArrayList<String> list = new ArrayList<String>();

		for (String ins : nombreCursos) {
			list.add(ins);
		}
		return new AgregarCursoAFormacion(nombreFormacion).agregarCursosAFor(list);

	}

	// Inscripcion a edicion de curso

	public String regInscDeUsrEnCurso(String nickname, String nombreEdicion, String Finsc, String urlVideo) {
		Date fecha1 = Date.valueOf(Finsc);
		return new InscripcionAEdicion(nickname, fecha1, nombreEdicion, urlVideo).inscripcion();
	}

	// Inscripcion a formacion

	public String regInscDeUsrEnFormacion(String nickname, String nombreFormacion, String Finsc) {
		Date fecha1 = Date.valueOf(Finsc);

		return new InscripcionAFormacion(nickname, fecha1, nombreFormacion).inscripcion();
	}

	// Consulta edicion Cursos

	public DTEdicionCurso[] consultaEdicion(String nombreCurso) {
		ArrayList<DTEdicionCurso> l = new ArrayList<DTEdicionCurso>(
				new ListaEdicionCurso().getDataTypeListByCurso(nombreCurso));

		DTEdicionCurso[] ret = new DTEdicionCurso[l.size()];

		int i = 0;
		for (DTEdicionCurso ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	// Consulta de Programa de Formacion

	public DTFormacion[] consultaFormacion() {

		ArrayList<DTFormacion> l = new ArrayList<DTFormacion>(new ListaFormacion().getDataTypeList());

		DTFormacion[] ret = new DTFormacion[l.size()];

		int i = 0;
		for (DTFormacion ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	// Consulta Curso

	public DTCurso[] consultaCurso(String nombreInstituto) {
		ArrayList<DTCurso> l = new ArrayList<DTCurso>(new ListaCursos().getDataTypeListConInstituto(nombreInstituto));
		DTCurso[] ret = new DTCurso[l.size()];

		int i = 0;
		for (DTCurso ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	// Consulta Usuario

	public boolean isEstudiante(String nickname) {
		return new ObtenerUsuario().isEstudiante(nickname);
	}

	public DTDocente[] consultaUsuarioDocente() {

		ArrayList<DTDocente> l = new ArrayList<DTDocente>(new ListaUsuarios().getDataTypeListDocente());
		DTDocente[] ret = new DTDocente[l.size()];

		int i = 0;
		for (DTDocente ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	public DTEstudiante[] consultaUsuarioEstudiante() {
		ArrayList<DTEstudiante> l = new ArrayList<DTEstudiante>(new ListaUsuarios().getDataTypeListEstudiante());

		DTEstudiante[] ret = new DTEstudiante[l.size()];

		int i = 0;
		for (DTEstudiante ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;

	}

	// Alta categoria

	public String crearCategoria(String nombreCategoria) {
		return new AltaCategoria().create(nombreCategoria);
	}

	/**
	 * 
	 */
	public void cerrarEdicionCurso(String nombreEdicion) {
		EdicionCurso edi = new ObtenerEdicionCurso().getEdicionCurso(nombreEdicion);
		if (edi != null) {

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();
			EdicionCurso ediCavani = entitymanager.find(EdicionCurso.class, nombreEdicion);
			ediCavani.setCerrado();
			// entitymanager.persist(ediCavani);

			entitymanager.getTransaction().commit();
			entitymanager.close();
			emfactory.close();
		}

	}

	public String[] ObtenerCursoPorEstudiante(String nick) {
		ListaCursos curso = new ListaCursos();

		ArrayList<String> l = new ArrayList<String>(curso.ListCursosPorUsuario(nick));

		String[] ret = new String[l.size()];

		int i = 0;
		for (String ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public String AltaValoracion(String nick, String NombreCurso, int puntos) {
		String valo = new Valoraciones(nick, NombreCurso, puntos).CrearValoracion();
		return valo;
	}

	public String BorrarInscripcion(String nedicion, String nickname) {
		return new InscripcionAEdicion().BorrarInscripcion(nedicion, nickname);
	}

	public String[] ListSeguidores(String Seguido) {

		ArrayList<String> l = new ArrayList<String>(new SeguirUsuario().seguidores(Seguido));

		String[] ret = new String[l.size()];

		int i = 0;
		for (String ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public boolean obtenerCertificado(String nFormacion, String nickname) {
		boolean ret = new obtenerCertificado().aproboFormacion(nFormacion, nickname);
		return ret;

	}

	public String HacerComentario(String out, String nik, String edi) {
		return new ManejadorComentarios().AltaComentario(out, nik, edi);
	}

	public String HacerRespuesta(int idCom, String nik, String edi, String out) {
		return new ManejadorComentarios().AltaRespuesta(idCom, nik, edi, out);
	}

	public DTComentarios[] getDTListComentarios() {
		ArrayList<DTComentarios> l = new ArrayList<DTComentarios>(new ManejadorComentarios().getDataTypeList());

		DTComentarios[] ret = new DTComentarios[l.size()];

		int i = 0;
		for (DTComentarios ins : l) {
			if (i < ret.length) {
				ret[i] = ins;
				i++;
			}
		}
		return ret;
	}

	public boolean UsuarioInscriptoo(String nEdicion, String nick) {
		return new ListaInscripciones().UsuarioInscripto(nEdicion, nick);
	}
}
