package API.datatypes;

import java.sql.Date;

import logica.entidades.Inscripcion_Formacion;

public class DTInscripcion_Formacion {
    public DTFormacion formita;
    public DTEstudiante estudiante;
    public Date fecha;
    public String estado;

    public DTInscripcion_Formacion() {

    }

    public DTInscripcion_Formacion(Inscripcion_Formacion ins) {
        this.formita = new DTFormacion(ins.getFormacionInsc());
        this.estudiante = new DTEstudiante(ins.getEstudiante());
        this.fecha = ins.getFecha();
        this.estado = ins.getEstado();
    }
}
