package API;

import logica.usuarios.CargarUsuarios;
import logica.cursos.CargarCursos;
import logica.edicioncursos.CargarEdicion;
import logica.formaciones.CargarFormacion;
import logica.institutos.CargarInstituto;

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
