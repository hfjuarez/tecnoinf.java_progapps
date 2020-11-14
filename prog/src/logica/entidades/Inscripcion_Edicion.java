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
    // @Id
    // private String nicknameEstudiante;
    // @Id

    // private String nombreEdicionCurso;
    @Id
    private EdicionCurso edicionCurso;
    @Id
    private Estudiante estudiante;
    private Date fecha;
    private String estado;
    private String urlVideo;
    private int nota;
    private String nEstudiante;
    private String nEdicion;
 

    public Inscripcion_Edicion() {
        super();
    }

    public Inscripcion_Edicion(EdicionCurso edicionCurso, Estudiante estudiante, Date fecha, String urlVideo) {
        super();
        // this.nicknameEstudiante = estudiante.getNickname();
        // this.nombreEdicionCurso = edicionCurso.getNombreEdicion();
        this.edicionCurso = edicionCurso;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = "Inscripto";
        this.urlVideo = urlVideo;
        this.nota = 0;
        this.nEstudiante= estudiante.getNickname();
        this.nEdicion = edicionCurso.getNombreEdicion();
    }

    public int getNota() {
        return nota;
    }
    

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public EdicionCurso getEdicionCurso() {
        return edicionCurso;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

	public String getnEstudiante() {
		return nEstudiante;
	}

	public void setnEstudiante(String nEstudiante) {
		this.nEstudiante = nEstudiante;
	}

	public String getnEdicion() {
		return nEdicion;
	}

	public void setnEdicion(String nEdicion) {
		this.nEdicion = nEdicion;
	}

}
