package API;

import logica.instituto.CargarInstituto;
import logica.usuarios.CargarUsuarios;
import logica.curso.CargarCursos;
import logica.edicioncurso.CargarEdicion;
import logica.formacion.CargarFormacion;

public class CargarDatosPrueba {

	public static void main(String[] args) {
		CargarInstituto ci = new CargarInstituto();
		System.out.println(ci.cargarInstitutos());

		CargarUsuarios cu = new CargarUsuarios();
		System.out.println(cu.cargarUsuarios());

		CargarCursos cc = new CargarCursos();
		System.out.println(cc.cargarCursos());

		CargarEdicion ce = new CargarEdicion();
		System.out.println(ce.cargarEdicion());
		System.out.println(ce.cargarInscripciones());

		CargarFormacion cf = new CargarFormacion();
		System.out.println(cf.cargarFormacion());
	}

}
