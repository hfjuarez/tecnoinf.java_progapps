package logica.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Seguir
 *
 */
@Entity

public class Seguir implements Serializable {

	@Id
	private String Seguidor;
	@Id
	private String Seguido;
	//private static final long serialVersionUID = 1L;

	public Seguir() {
		super();
	}

	public String getSeguidor() {
		return Seguidor;
	}

	public void setSeguidor(String seguidor) {
		Seguidor = seguidor;
	}

	public String getSeguido() {
		return Seguido;
	}

	public void setSeguido(String seguido) {
		Seguido = seguido;
	}
   
}
