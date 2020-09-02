package API;

import java.sql.Date;
import java.util.List;
import java.io.File;

import logica.*;

public class LControlador implements ILogica {

        private static LControlador controller = null;

        public static LControlador getController() {
                if (controller == null) {
                        controller = new LControlador();
                }
                return controller;
        }

        private LControlador() {
        }

        // Listas
        // public List</*Clase DT Usuario*/> listaUsuarios(){}

        // public List</* Clase DT Formacion */> listFormaciones(){}

        // public List</* Clase DT Cursos */> listCurEnFormacion(String
        // nombreFormacion){}

        // public List</* Clase DT Cursos */> listCursos(String nombreInstituto){}

        // public List</* Clase DT Ediciones */> listEdiciones(String nombreCurso){}

        // Alta Instituto
        public boolean existeInstituto(String nombre) {
        }

        public boolean crearInstituto(String nombre) {
        }

        // Alta de Usuario

        public boolean existeUsuario(String nickname, String email) {
        }

        public String crearUsuarioEstudiante(String nickname, String nombre, String apellido, String mail,
                        Date fechaNac, File imagen) {
        }

        public String crearUsuarioDocente(String nickname, String nombre, String apellido, String mail, Date fechaNac,
                        String instituto, File imagen) {
        }

        // Modificar Datos de Usuario

        public String ModificarUsuario(String nombre, String apellido, Date fechaNac, File imagen) {
        }

        // Alta Curso

        public boolean existeCurso(String nombreCurso, String nombreInstituto) {
        }

        public String crearCurso(String nombre, String desc, int Duracion, int CantHoras, int CantCred, String URL,
                        Date Fecha) {
        }

        // Alta edicion de Curso

        public boolean existeEdicion(String nombreEdicion, String nombreCurso) {
        }

        public String crearEdicion(String nombreEdicion, Date FechaInicio, Date FechaFin, int Cupo) {
        }

        // Crear Programa de Formacion

        public boolean existeFormacion(String nombreInstituto, String nombreFormacion) {
        }

        public String crearFormacion(String nombreInstituto, String nombreFormacion, String descr, Date FechaIni,
                        Date FechaFin) {
        }

        // Agregar Curso a Programa de Formación

        public boolean existeCurEnForm(String nombreInstituto, String nombreCurso, String nombreFormacion) {
        }

        public String AgregoCurEnForm(String nombreFormacion, String nombreCurso) {
        }

        // Inscripcion a edicion de curso

        public boolean existEstudEnCur(String nickname, String nombreCurso) {
        }

        public String regInscDeUsrEnCurso(String nickname, String nombrecurso, Date Finsc) {
        }

        // Consulta edicion Cursos

        public /* Clase Edicion con inscriptos? */ void consultaEdicion(String nombreEdicion, String nombreCurso) {
        }

        // Consulta de Programa de Formacion

        public /* Clase formacion con sus cursos */ void consultaFormacion(String nombreFormacion) {
        }

        // Consulta Curso

        public /* Clase Cursos mas Ediciones con inscriptos? */ void consultaCurso(String nombreCurso) {
        }

        // Consulta Usuario
        public boolean esEstudiante(String Docente) {
        }

        public /* Clase Usuario con cursos, ediciones, programas */ void consultaUsuarioDocente(String nombre) {
        }

        public /* Clase Usuario con cursos, ediciones, programas */ void consultaUsuarioEstudiante(String nombre) {
        }
}
