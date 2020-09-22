package API;

import java.sql.Date;
import java.util.List;

import logica.datatypes.*;

import java.io.File;

public interface ILogica {

      // Listas

      public List<DTInstituto> listaInstitutos();

      public List<DTEstudiante> listaEstudiantes();

      public List<DTDocente> listaDocentes();

      public List<DTCurso> listaCursosPorInstituto(String nombreInstituto);

      public List<DTEdicionCurso> ListaEdicionesCurso(String nombreCurso);

      public List<DTInscripcion_Edicion> listaIns(); 

      public List<DTCurso> ListaCursos();

      // Obtener DT

      public DTEstudiante obtenerEstudiante(String nickname);

      public DTDocente obtenerDocente(String nickname);
      
      public DTEdicionCurso obtenerEdicionCurso(String nombreEdicion);
      
      public DTCurso obtenerCurso(String nombrecurso);

      // Alta Instituto

      public String crearInstituto(String nombre);

      // Alta de Usuario

      public String crearUsuarioEstudiante(String nickname, String nombre, String apellido, String mail, Date fechaNac,
                  File imagen);

      public String crearUsuarioDocente(String nickname, String nombre, String apellido, String mail, Date fechaNac,
                  String Instituto, File imagen);

      // Modificar Datos de Usuario

      public String ModificarUsuario(String nick, String nombre, String apellido, Date fechaNac, File imagen);

      // Alta Curso

      public String crearCurso(String nombre, String desc, int duracion, int cantHoras, int CantCred, String URL,
                  Date Fecha, List<String> previas, String nombreInstituto);

      // Alta Edicion

      public String crearEdicion(String nombreEdicion, String curso, Date FechaInicio, Date FechaFin, int Cupo,
                  Date fechaAlta, List<String> docentes);

      // Crear Programa de Formacion

      public String crearFormacion(String nombreFormacion, String descr, Date FechaIni, Date FechaFin, Date FechaAlta);

      // Agregar Curso a Programa de Formación

      public String AgregoCurEnForm(String nombreFormacion, List<String> nombreCursos);

      // Inscripcion a edicion de curso

      public String regInscDeUsrEnCurso(String nickname, String nombrecurso, Date Finsc);

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
}