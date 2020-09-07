package logica.entidades;

import java.lang.String;
import java.sql.Date;
import java.util.*;
import javax.persistence.*;

import logica.entidades.Curso;

/**
 * Entity implementation class for Entity: EdicionCurso
 *
 */
@Entity
@Table
public class Inscripcion_Edicion {
    @Id
    EdicionCurso edicionCurso;
    @Id
    Estudiante estudiante;
    Date fecha;

    public Inscripcion_Edicion() {
        super();
    }

    public Inscripcion_Edicion(EdicionCurso edicionCurso, Estudiante estudiante, Date fecha) {
        super();
        this.edicionCurso = edicionCurso;
        this.estudiante = estudiante;
        this.fecha = fecha;
    }

    public void setEdicionCurso(EdicionCurso edicionCurso) {
        this.edicionCurso = edicionCurso;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public EdicionCurso getEdicionCurso() {
        return edicionCurso;
    }

    public Date getFecha() {
        return fecha;
    }

}
