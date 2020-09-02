package logica.entidades;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Curso
 *
 */
@Entity
@Table
public class Curso {

    @Id
    private String nombre;
    private String desc;
    private int duracion;
    private int cantHoras;
    private int cantCred;
    private String URL;
    private Date FechaAlta;

    private Instituto instituto;
    // private static final long serialVersionUID = 3L;

    public Curso() {
        super();
    }

    public String getNombreCurso() {
        return this.nombre;
    }

    public void setNombreCurso(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.desc;
    }

    public void setDescripcion(String desc) {
        this.desc = desc;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCantHoras() {
        return this.cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public int getCantCred() {
        return this.cantCred;
    }

    public void setCantCred(int cantCred) {
        this.cantCred = cantCred;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Date getFecha() {
        return this.FechaAlta;
    }

    public void setFecha(Date Fecha) {
        this.FechaAlta = Fecha;
    }

}