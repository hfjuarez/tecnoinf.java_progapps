package logica.controladores;

import API.ILogica;

import java.sql.Date;
import java.util.List;

import java.io.File;

import logica.datatypes.*;
import logica.instituto.AltaInstituto;
import logica.instituto.ListaInstitutos;

import logica.usuarios.*;

import logica.curso.ExisteCurso;
import logica.curso.ListaCursos;
import logica.curso.AltaCurso;

import logica.edicioncurso.ListaEdicionCurso;
import logica.edicioncurso.AltaEdicionCurso;
import logica.edicioncurso.InscripcionAEdicion;
import logica.formacion.AltaFormacion;
import logica.formacion.AgregarCursoAFormacion;
import logica.formacion.ListaFormacion;

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

        public List<DTCurso> ListaCursos() {
                return new ListaCursos().getDataTypeList();
        }

        public List<DTFormacion> listFormaciones() {
                return new ListaFormacion().getDataTypeList();
        }

        // Obtener DT

        public DTEstudiante obtenerEstudiante(String nickname) {
                return new ObtenerUsuario().getDTEstudianteByNickname(nickname);
        }

        public DTDocente obtenerDocente(String nickname) {
                return new ObtenerUsuario().getDTDocenteByNickname(nickname);
        }

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

        // Alta edicion de Curso

        public String crearEdicion(String nombreEdicion, String curso, Date FechaInicio, Date FechaFin, int Cupo,
                        Date fechaAlta, List<String> docentes) {
                return new AltaEdicionCurso(nombreEdicion, curso, FechaInicio, FechaFin, Cupo, fechaAlta)
                                .createEdicionCurso(docentes);
        }

        // Crear Programa de Formacion

        public String crearFormacion(String nombreFormacion, String descr, Date FechaIni, Date FechaFin,
                        Date FechaAlta) {
                return new AltaFormacion(nombreFormacion, descr, FechaIni, FechaFin, FechaAlta).createFormacion();
        }

        // Agregar Curso a Programa de Formación

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
}
