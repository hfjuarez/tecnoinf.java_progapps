package logica.entidades;

import java.io.Serializable;
import javax.persistence.*;

import logica.controladores.LControlador;

/**
 * Entity implementation class for Entity: ContCom
 *
 */
@Entity
@Table
public class ContCom implements Serializable {

	@Id
	private String nefasto="buenazo";
	private int cont=1;
	 
	//private static final long serialVersionUID = 1L;

	
	public ContCom() {
		super();
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int c) {
		this.cont=c;
	}
   
}
