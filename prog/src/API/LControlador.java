package API;

import java.sql.Date;
import java.util.List;

import java.io.File;

import logica.datatypes.*;
import logica.entidades.EdicionCurso;
import logica.instituto.AltaInstituto;
import logica.instituto.ListaInstitutos;

import logica.usuarios.*;

import logica.curso.ExisteCurso;
import logica.curso.ListaCursos;
import logica.curso.AltaCurso;

import logica.edicioncurso.ListaEdicionCurso;

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

        public List<DTInstituto> listaInstitutos() {
                return new ListaInstitutos().getDataTypeList();
        }

        public List<DTEstudiante> listaEstudiantes() {
                return new ListaUsuarios().getDataTypeListEstudiante();
        }

        public List<DTDocente> listaDocentes() {
                return new ListaUsuarios().getDataTypeListDocente();
        }

        public List<DTCurso> listaCursosPorInstituto(String nombreInstituto) {
                return new ListaCursos().getDataTypeListConInstituto(nombreInstituto);
        }

        public List<DTEdicionCurso> ListaEdicionesCurso(String nombreCurso) {
                return new ListaEdicionCurso().getDataTypeListByCurso(nombreCurso);
        }

        // public List</* Clase DT Formacion */> listFormaciones(){}

        // public List</* Clase DT Cursos */> listCurEnFormacion(String
        // nombreFormacion){}

        // public List</* Clase DT Cursos */> listCursos(String nombreInstituto){}

        // public List</* Clase DT Ediciones */> listEdiciones(String nombreCurso){}

        // Alta Instituto

        public String crearInstituto(String nombre) {
                return new AltaInstituto().create(nombre);
        }

        // Alta de Usuario

        public String crearUsuarioEstudiante(String nickname, String nombre, String apellido, String mail,
                        Date fechaNac, File imagen) {
                return new AltaUsuario(nickname, nombre, apellido, mail, fechaNac).createEstudiante();

        }

        public String crearUsuarioDocente(String nickname, String nombre, String apellido, String mail, Date fechaNac,
                        String instituto, File imagen) {
                return new AltaUsuario(nickname, nombre, apellido, mail, fechaNac).createDocente(instituto);

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
                        Date Fecha, List<String> previas, String nombreInstituto) {
                if (!new ExisteCurso().existeNombreCur(nombre)) {
                        return new AltaCurso(nombre, desc, Duracion, CantHoras, CantCred, URL, Fecha)
                                        .createCurso(nombreInstituto, previas);
                } else {
                        return "ERROR: YA existe ese nombre de curso, por favor ingrese uno nuevo!";
                }
        }

        // // Alta edicion de Curso

        // public boolean existeEdicion(String nombreEdicion, String nombreCurso) {
        // }

        // public String crearEdicion(String nombreEdicion, Date FechaInicio, Date
        // FechaFin, int Cupo) {
        // }

        // // Crear Programa de Formacion

        // public boolean existeFormacion(String nombreInstituto, String
        // nombreFormacion) {
        // }

        // public String crearFormacion(String nombreInstituto, String nombreFormacion,
        // String descr, Date FechaIni,
        // Date FechaFin) {
        // }

        // // Agregar Curso a Programa de Formación

        // public boolean existeCurEnForm(String nombreInstituto, String nombreCurso,
        // String nombreFormacion) {
        // }

        // public String AgregoCurEnForm(String nombreFormacion, String nombreCurso) {
        // }

        // // Inscripcion a edicion de curso

        // public boolean existEstudEnCur(String nickname, String nombreCurso) {
        // }

        // public String regInscDeUsrEnCurso(String nickname, String nombrecurso, Date
        // Finsc) {
        // }

        // // Consulta edicion Cursos

        // public /* Clase Edicion con inscriptos? */ void consultaEdicion(String
        // nombreEdicion, String nombreCurso) {
        // }

        // // Consulta de Programa de Formacion

        // public /* Clase formacion con sus cursos */ void consultaFormacion(String
        // nombreFormacion) {
        // }

        // // Consulta Curso

        // public /* Clase Cursos mas Ediciones con inscriptos? */ void
        // consultaCurso(String nombreCurso) {
        // }

        // // Consulta Usuario
        // public boolean esEstudiante(String Docente) {
        // }

        // public /* Clase Usuario con cursos, ediciones, programas */ void
        // consultaUsuarioDocente(String nombre) {
        // }

        // public /* Clase Usuario con cursos, ediciones, programas */ void
        // consultaUsuarioEstudiante(String nombre) {
        // }
}
