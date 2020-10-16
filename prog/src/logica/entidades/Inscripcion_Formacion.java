package logica.entidades;

import java.lang.String;
import java.sql.Date;
import java.util.*;
import javax.persistence.*;

import logica.entidades.Formacion;

/**
 * Entity implementation class for Entity: EdicionCurso
 *
 */
@Entity
@Table
public class Inscripcion_Formacion {
    // @Id
    // private String nicknameEstudiante;
    // @Id

    // private String nombreEdicionCurso;
    @Id
    private Formacion formita;
    @Id
    private Estudiante estudiante;
    private Date fecha;
    private String estado;

    public Inscripcion_Formacion() {
        super();
    }

    public Inscripcion_Formacion(Formacion formita, Estudiante estudiante, Date fecha) {
        super();
        // this.nicknameEstudiante = estudiante.getNickname();
        // this.nombreEdicionCurso = edicionCurso.getNombreEdicion();
        this.formita = formita;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = "Inscripto";
    }

    public void setFormacionInsc(Formacion formita) {
        this.formita = formita;
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

    public Formacion getFormacionInsc() {
        return formita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

}
