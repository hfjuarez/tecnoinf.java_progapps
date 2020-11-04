package API;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import API.datatypes.*;
import logica.usuarios.ListaUsuarios;

import java.io.File;

public interface IWeb {
	// Web

	public boolean validateUser(String nick, String pass);

	public File getImagen(String folder, String name);

	public boolean setImagen(String folder, String name, File img);

	public List<DTFormacion> BusquedaFiltroFormacion(String busqueda);

	public List<DTCurso> BusquedaFiltroCurso(String busqueda);

	// Listas

	public List<String> listaNicknames();

	public List<String> listaEmails();

	public List<DTInstituto> listaInstitutos();

	public List<DTEstudiante> listaEstudiantes();

	public List<DTDocente> listaDocentes();

	public List<DTDocente> listaDocentesPorInstituto(String instituto);

	public List<DTCurso> listaCursosPorInstituto(String nombreInstituto);

	public List<DTEdicionCurso> ListaEdicionesCurso(String nombreCurso);

	public List<DTInscripcion_Edicion> listaIns();

	public List<DTCurso> ListaCursos();

	public List<DTCurso> listaCursoPorCategoria(String cat);

	public List<DTCategoria> listaCat();

	public List<DTCategoria> listaCatDeFormacion(String nombreFormacion);

	public List<DTInscripcion_Edicion> listaInscripcionesPorEstudiante(String nick);

	public List<DTInscripcion_Edicion> listaInscripcionesPorEdicion(String edicion);

	public List<DTInscripcion_Formacion> listaInsFor();

	public List<DTInscripcion_Formacion> listaInscForPorEstudiante(String nick);

	public List<DTInscripcion_Formacion> listaInscForPorFormacion(String formacion);

	public List<DTFormacion> listaFormacionesPorCurso(String name);

	public List<DTFormacion> listFormaciones();

	// Obtener DT
	public boolean existeUsuario(String nick);

	public List<DTEdicionCurso> getDTEdicionCursoByDocente(String Nicknamedeltipo);

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

	public String crearUsuarioEstudiante(String nickname, String nombre, String apellido, String mail, Date fechaNac,
			File imagen, String passw, String passw2);

	public String crearUsuarioDocente(String nickname, String nombre, String apellido, String mail, Date fechaNac,
			String Instituto, File imagen, String passw, String passw2);

	// Modificar Datos de Usuario

	public String ModificarUsuario(String nick, String nombre, String apellido, Date fechaNac, File imagen);

	// Seguir Usuario

	public String SeguirUsuarioo(String nickName, String nickName2);

	// Dejar Seguir Usuario

	public String DejarSeguirUsuario(String nickName, String nickName2);

	// Alta Curso

	public String crearCurso(String nombre, String desc, int Duracion, int CantHoras, int CantCred, String URL,
			Date Fecha, List<String> previas, String nombreInstituto, List<String> categorias, File imagen);

	// Alta Edicion

	public String crearEdicion(String nombreEdicion, String curso, Date FechaInicio, Date FechaFin, int Cupo,
			Date fechaAlta, List<String> docentes, File imagen);

	public void cambiarestado(String solteroHastaLaTumba, String ediCavani, String nik);

	public void asignarNotaAEstudianteEdicionCurso(int nota, String ediCavani, String nik);
	// Crear Programa de Formacion

	public String crearFormacion(String nombreFormacion, String descr, Date FechaIni, Date FechaFin, Date FechaAlta,
			File imagen);

	// Agregar Curso a Programa de Formaci�n

	public String AgregoCurEnForm(String nombreFormacion, List<String> nombreCursos);

	// Inscripcion a edicion de curso

	public String regInscDeUsrEnCurso(String nickname, String nombrecurso, Date Finsc, String urlVideo);

	// Inscripcion a formacion

	public String regInscDeUsrEnFormacion(String nickname, String nombreFormacion, Date Finsc);

	// Consulta edicion Cursos

	public List<DTEdicionCurso> consultaEdicion(String nombreCurso);

	// Consulta de Programa de Formacion

	public List<DTFormacion> consultaFormacion();

	// Consulta Curso

	public List<DTCurso> consultaCurso(String nombreInstituto);

	// Consulta Usuario

	public boolean isEstudiante(String nickname);

	public List<DTDocente> consultaUsuarioDocente();

	public List<DTEstudiante> consultaUsuarioEstudiante();
	
	public void cerrarEdicionCurso(String nombreEdicion);

	public List<String> ObtenerCursoPorEstudiante(String nick);

	public String AltaValoracion(String nick, String NombreCurso, int puntos);
	
	public String BorrarInscripcion(String nedicion,String nickname);
	
	public List<String> ListSeguidores(String Seguido);

}
