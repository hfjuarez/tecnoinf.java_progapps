package logica.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Valoracion
 *
 */
@Entity
@Table



public class Valoracion implements Serializable {

@Id
private String nick;
private String NombreCurso;
private int rating;
	
	//private static final long serialVersionUID = 1L;

	public Valoracion() {
		super();
	}

	public Valoracion(String nick, String NombreCurso, int rating) {
		super();
		this.nick = nick;
		this.NombreCurso = NombreCurso;
		this.rating = rating;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombreCurso() {
		return NombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		NombreCurso = nombreCurso;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

   
}
