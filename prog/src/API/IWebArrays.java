package API;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import API.datatypes.*;
import logica.usuarios.ListaUsuarios;

import java.io.File;

public interface IWebArrays {
	// Web

	public boolean validateUser(String nick, String pass);

	public File getImagen(String folder, String name);

	public boolean setImagen(String folder, String name, File img);

	public DTFormacion[] BusquedaFiltroFormacion(String busqueda);

	public DTCurso[] BusquedaFiltroCurso(String busqueda);

	// Listas

	public String[] listaNicknames();

	public String[] listaEmails();

	public DTInstituto[] listaInstitutos();

	public DTEstudiante[] listaEstudiantes();

	public DTDocente[] listaDocentes();

	public DTDocente[] listaDocentesPorInstituto(String instituto);

	public DTCurso[] listaCursosPorInstituto(String nombreInstituto);

	public DTEdicionCurso[] ListaEdicionesCurso(String nombreCurso);

	public DTInscripcion_Edicion[] listaIns();

	public DTCurso[] ListaCursos();

	public DTCurso[] listaCursoPorCategoria(String cat);

	public DTCategoria[] listaCat();

	public DTCategoria[] listaCatDeFormacion(String nombreFormacion);

	public DTInscripcion_Edicion[] listaInscripcionesPorEstudiante(String nick);

	public DTInscripcion_Edicion[] listaInscripcionesPorEdicion(String edicion);

	public DTInscripcion_Formacion[] listaInsFor();

	public DTInscripcion_Formacion[] listaInscForPorEstudiante(String nick);

	public DTInscripcion_Formacion[] listaInscForPorFormacion(String formacion);

	public DTFormacion[] listaFormacionesPorCurso(String name);

	public DTFormacion[] listFormaciones();

	// Obtener DT
	public boolean existeUsuario(String nick);

	public DTEdicionCurso[] getDTEdicionCursoByDocente(String Nicknamedeltipo);

	public DTEstudiante obtenerEstudiante(String nickname);

	public DTDocente obtenerDocente(String nickname);

	public DTEdicionCurso obtenerEdicionCurso(String nombreEdicion);

	public DTCurso obtenerCurso(String nombrecurso);

	public DTCategoria obtenerCategoria(String nombreCategoria);

	public DTFormacion obtenerFormacion(String nombre);

	public DTInstituto obtenerInstituto(String name);

	public DTEdicionCurso getEdicionActual(String nombreCurso);

	// Alta categoria

	public String crearCategoria(String nombreCategoria);

	// Alta Instituto

	public String crearInstituto(String nombre);

	// Alta de Usuario

	public String crearUsuarioEstudiante(String nickname, String nombre, String apellido, String mail, String fechaNac,
			File imagen, String passw, String passw2);

	public String crearUsuarioDocente(String nickname, String nombre, String apellido, String mail, String fechaNac,
			String Instituto, File imagen, String passw, String passw2);

	// Modificar Datos de Usuario

	public String ModificarUsuario(String nick, String nombre, String apellido, String fechaNac, File imagen);

	// Seguir Usuario

	public String SeguirUsuarioo(String nickName, String nickName2);

	// Dejar Seguir Usuario

	public String DejarSeguirUsuario(String nickName, String nickName2);

	// Alta Curso

	public String crearCurso(String nombre, String desc, int Duracion, int CantHoras, int CantCred, String URL,
			String Fecha, String[] previas, String nombreInstituto, String[] categorias, File imagen);

	// Alta Edicion

	public String crearEdicion(String nombreEdicion, String curso, String FechaInicio, String FechaFin, int Cupo,
			String fechaAlta, String[] docentes, File imagen);

	public void cambiarestado(String solteroHastaLaTumba, String ediCavani, String nik);

	public void asignarNotaAEstudianteEdicionCurso(int nota, String ediCavani, String nik);
	// Crear Programa de Formacion

	public String crearFormacion(String nombreFormacion, String descr, String FechaIni, String FechaFin,
			String FechaAlta, File imagen);

	// Agregar Curso a Programa de Formaci�n

	public String AgregoCurEnForm(String nombreFormacion, String[] nombreCursos);

	// Inscripcion a edicion de curso

	public String regInscDeUsrEnCurso(String nickname, String nombrecurso, String Finsc, String urlVideo);

	// Inscripcion a formacion

	public String regInscDeUsrEnFormacion(String nickname, String nombreFormacion, String Finsc);

	// Consulta edicion Cursos

	public DTEdicionCurso[] consultaEdicion(String nombreCurso);

	// Consulta de Programa de Formacion

	public DTFormacion[] consultaFormacion();

	// Consulta Curso

	public DTCurso[] consultaCurso(String nombreInstituto);

	// Consulta Usuario

	public boolean isEstudiante(String nickname);

	public DTDocente[] consultaUsuarioDocente();

	public DTEstudiante[] consultaUsuarioEstudiante();

	public void cerrarEdicionCurso(String nombreEdicion);

	public String[] ObtenerCursoPorEstudiante(String nick);

	public String AltaValoracion(String nick, String NombreCurso, int puntos);

	public String BorrarInscripcion(String nedicion, String nickname);

	public String[] ListSeguidores(String Seguido);

	public boolean obtenerCertificado(String nFormacion, String nickname);

	public String HacerComentario(String out, String nik, String edi);

	public String HacerRespuesta(int idCom, String nik, String edi, String out);

	public DTComentarios[] getDTListComentarios();

	public boolean UsuarioInscriptoo(String nEdicion, String nick);

}
