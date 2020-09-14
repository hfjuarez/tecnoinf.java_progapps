package logica.entidades;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Instituto
 *
 */
@Entity
@Table
public class Instituto {

	@Id
	private String nombreInstituto;
	// private static final long serialVersionUID = 1L;

	public Instituto() {
		super();
	}

	public String getNombreInstituto() {
		return this.nombreInstituto;
	}

	public void setNombreInstituto(String nombreInstituto) {
		this.nombreInstituto = nombreInstituto;
	}

}
