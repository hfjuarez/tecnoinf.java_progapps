package logica.entidades;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable {

	@Id
	private String nickname;
	private String nombre;
	private String apellido;
	private String mail;
	private Date fechaNac;
	// private static final long serialVersionUID = 2L;

	public Usuario() {
		super();
	}

	public Usuario(String nick, String name, String ape, String email, Date nac) {
		super();
		nickname = nick;
		nombre = name;
		apellido = ape;
		mail = email;
		fechaNac = nac;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String email) {
		this.mail = email;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

}
