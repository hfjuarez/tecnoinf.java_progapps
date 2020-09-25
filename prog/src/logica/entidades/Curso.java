package logica.entidades;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;
import logica.entidades.Instituto;
import java.util.List;

/**
 * Entity implementation class for Entity: Curso
 *
 */
@Entity
@Table
public class Curso {

	@Id
	private String nombreCurso;
	@Column(length = 1337)
	private String descCurso;
	private int duracionSemanas;
	private int cantidadHoras;
	private int cantidadCreditos;
	private String URL;
	private Date fechaAlta;
	@ManyToOne
	private Instituto instituto;
	@OneToMany(targetEntity = Curso.class)
	private List previas;
	@OneToMany(targetEntity = Categoria.class)
	private List categorias;
	// private static final long serialVersionUID = 1L;

	public Curso() {
		super();
	}

	public Curso(String nombreCurso, String descCurso, int duracionSemanas, int cantidadHoras, int cantidadCreditos,
			String uRL, Date fechaAlta, Instituto instituto, List<Categoria> categorias) {
		super();
		this.nombreCurso = nombreCurso;
		this.descCurso = descCurso;
		this.duracionSemanas = duracionSemanas;
		this.cantidadHoras = cantidadHoras;
		this.cantidadCreditos = cantidadCreditos;
		URL = uRL;
		this.fechaAlta = fechaAlta;
		this.instituto = instituto;
		this.categorias = categorias;
	}

	public String getNombreCurso() {
		return this.nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getDescCurso() {
		return this.descCurso;
	}

	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}

	public int getDuracionSemanas() {
		return this.duracionSemanas;
	}

	public void setDuracionSemanas(int duracionSemanas) {
		this.duracionSemanas = duracionSemanas;
	}

	public int getCantidadHoras() {
		return this.cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public int getCantidadCreditos() {
		return this.cantidadCreditos;
	}

	public void setCantidadCreditos(int cantidadCreditos) {
		this.cantidadCreditos = cantidadCreditos;
	}

	public String getURL() {
		return this.URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Instituto getInstituto() {
		return this.instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}

	public List getPrevias() {
		return previas;
	}

	public void setPrevias(List previas) {
		this.previas = previas;
	}

	public void addPrevia(Curso cursoPrevio) {
		this.previas.add(cursoPrevio);
	}

	public List<Categoria> getCategoria() {
		return categorias;
	}

	public void setCategoria(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void addCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}

}
