package logica.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comentarios
 *
 */
@Entity
@Table

public class Comentarios implements Serializable {

	@Id
	private int id;
	private String nick;
	private String Comentario;
	private String edi;
	@OneToMany(targetEntity = Comentarios.class)
	private List<Comentarios> Respuestas=null;
//	private static final long serialVersionUID = 1L;

	public Comentarios() {super();}
	
	public Comentarios(String Com,String nik,String edii,int num) {
		super();
		this.id=num;
		this.nick=nik;
		this.Comentario=Com;
		this.edi=edii;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public List<Comentarios> getRespuestas() {
		return Respuestas;
	}

	public void setRespuestas(List<Comentarios> respuestas) {
		Respuestas = respuestas;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEdi() {
		return edi;
	}

	public void setEdi(String edi) {
		this.edi = edi;
	}
   
}
