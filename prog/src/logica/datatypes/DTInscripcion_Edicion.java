package logica.datatypes;

import java.sql.Date;

import logica.entidades.Inscripcion_Edicion;

public class DTInscripcion_Edicion {
    public DTEdicionCurso edicionCurso;
    public DTEstudiante estudiante;
    public Date fecha;

    public DTInscripcion_Edicion() {

    }

    public DTInscripcion_Edicion(Inscripcion_Edicion ins) {
        this.edicionCurso = new DTEdicionCurso(ins.getEdicionCurso());
        this.estudiante = new DTEstudiante(ins.getEstudiante());
        this.fecha = ins.getFecha();
    }
}
