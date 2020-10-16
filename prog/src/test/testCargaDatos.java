package test;

import static org.junit.jupiter.api.Assertions.*;
import API.CargarDatosPrueba;
import org.junit.jupiter.api.Test;

class testCargaDatos {

	@Test
	void test() {
		CargarDatosPrueba c = new CargarDatosPrueba();
		CargarDatosPrueba.main(null);
	}

}
