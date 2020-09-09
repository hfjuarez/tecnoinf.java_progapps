package API;

import logica.instituto.CargarInstituto;
import logica.usuarios.CargarUsuarios;

public class CargarDatosPrueba {

	public static void main(String[] args) {
		CargarInstituto ci=new CargarInstituto();
		System.out.println(ci.cargarInstitutos());
		
		CargarUsuarios cu=new CargarUsuarios();
		System.out.println(cu.cargarUsuarios());
	}

}
