package API.datatypes;

import java.sql.Date;

import logica.entidades.Inscripcion_Edicion;

public class DTInscripcion_Edicion {
    public DTEdicionCurso edicionCurso;
    public DTEstudiante estudiante;
    public String fecha;
    public String estado;
    public String urlVideo;
    public int nota;

    public DTInscripcion_Edicion() {

    }

    public DTInscripcion_Edicion(Inscripcion_Edicion ins) {
        this.edicionCurso = new DTEdicionCurso(ins.getEdicionCurso());
        this.estudiante = new DTEstudiante(ins.getEstudiante());
        this.fecha = ins.getFecha().toString();
        this.estado = ins.getEstado();
        this.urlVideo = ins.getUrlVideo();
        this.nota = ins.getNota();
    }
}
