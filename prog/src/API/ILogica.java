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

}