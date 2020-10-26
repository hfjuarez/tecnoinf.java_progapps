package test;

import logica.institutos.*;
import logica.categorias.*;
import logica.usuarios.*;
import logica.cursos.*;
import logica.edicioncursos.*;
import logica.inscripciones.*;
import logica.formaciones.*;
import API.datatypes.*;
import java.sql.Date;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testCargaDatos {

	@Test
	void test() {

		// Alta Institutos

		AltaInstituto ai = new AltaInstituto();
		String ret = "";

		ret = ai.create("INCO");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ai.create("IMERL");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ai.create("Fisica");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ai.create("IMPII");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ai.create("Electrica");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ai.create("DISI");
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Alta Categoria

		AltaCategoria ac = new AltaCategoria();

		ret = ac.create("Social");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ac.create("Industrial");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ac.create("Educativo");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = ac.create("Interdisciplinario");
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Alta Usuarios

		// Estudiantes
		Date datee1 = Date.valueOf("1971-12-31");
		Date datee2 = Date.valueOf("1983-11-15");
		Date datee3 = Date.valueOf("1975-08-02");
		Date datee4 = Date.valueOf("1987-09-12");
		Date datee5 = Date.valueOf("1964-11-27");
		Date datee6 = Date.valueOf("1978-12-23");
		Date dateH = Date.valueOf("2000-06-04");
		AltaUsuario aueh = new AltaUsuario("hrfj", "Hernan", "Fabrica", "hrfj@gmail.com", dateH, "h");
		ret = aueh.createEstudiante();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aue1 = new AltaUsuario("eleven11", "Eleven", "", "eleven11@gmail.com", datee1, "LzrZzge5");
		ret = aue1.createEstudiante();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aue2 = new AltaUsuario("costas", "Gerardo", "Costas", "gcostas@gmail.com", datee2, "nQ57u5az");
		ret = aue2.createEstudiante();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aue3 = new AltaUsuario("roro", "Rodrigo", "Cotelo", "rcotelo@yahoo.com", datee3, "Xci95w9i");
		ret = aue3.createEstudiante();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aue4 = new AltaUsuario("chechi", "Cecilia", "Garrido", "cgarrido@hotmail.com", datee4, "RqF7U579");
		ret = aue4.createEstudiante();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aue5 = new AltaUsuario("jeffw", "Jeff", "Williams", "jwilliams@gmail.com", datee5, "CQQ8MqpJ");
		ret = aue5.createEstudiante();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aue6 = new AltaUsuario("weiss", "Adrian", "Weiss", "aweiss@hotmail.com", datee6, "CN3zuf8Y");
		ret = aue6.createEstudiante();
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Docentes
		Date date1 = Date.valueOf("1956-03-15");
		Date date2 = Date.valueOf("1914-04-02");
		Date date3 = Date.valueOf("1990-04-15");
		Date date4 = Date.valueOf("1959-05-15");
		Date date5 = Date.valueOf("1960-11-01");
		Date date6 = Date.valueOf("1963-07-05");
		Date date7 = Date.valueOf("1961-10-07");
		Date date8 = Date.valueOf("1959-12-03");
		Date date9 = Date.valueOf("1978-07-28");
		AltaUsuario aud1 = new AltaUsuario("heisenberg", "Walter", "White", "heisenberg@gmail.com", date1, "zDUTwJD7");
		ret = aud1.createDocente("INCO");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud2 = new AltaUsuario("benkenobi", "Obi-Wan", "Kenobi", "benKenobi@gmail.com", date2, "5aM8CGch");
		ret = aud2.createDocente("INCO");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud3 = new AltaUsuario("waston", "Emma", "Watson", "e.waton@gmail.com", date3, "ahtL8FzL");
		ret = aud3.createDocente("INCO");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud4 = new AltaUsuario("house", "Gregory", "House", "greghouse@gmail.com", date4, "XTMWJ8iT");
		ret = aud4.createDocente("Electrica");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud5 = new AltaUsuario("timmy ", "Tim", "Cook", "tim.cook@apple.com", date5, "6McCUA9g");
		ret = aud5.createDocente("IMERL");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud6 = new AltaUsuario("danny", "Daniel", "Riccio", "dan.riccio@gmail.com", date6, "4WgRR6nL");
		ret = aud6.createDocente("IMERL");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud7 = new AltaUsuario("phils", "Philip", "Schiller", "schiller@gmail.com", date7, "4KJeAikG");
		ret = aud7.createDocente("IMPII");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud8 = new AltaUsuario("bruces", "Bruce", "Sewell", "sewell@gmail.com", date8, "7KTCP7YL");
		ret = aud8.createDocente("DISI");
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaUsuario aud9 = new AltaUsuario("adri", "Adriana", "Garcia", "agarcia@gmail.com", date9, "EB6Vq6Dj");
		ret = aud9.createDocente("DISI");
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Alta Curso

		date1 = Date.valueOf("2019-02-01");
		date3 = Date.valueOf("2025-06-25");
		date2 = Date.valueOf("2019-07-12");
		date4 = Date.valueOf("2018-06-16");
		date5 = Date.valueOf("2019-02-01");
		date6 = Date.valueOf("2008-07-27");
		date7 = Date.valueOf("2017-02-02");
		date8 = Date.valueOf("2019-06-15");
		date9 = Date.valueOf("2019-05-24");
		Date date10 = Date.valueOf("2019-03-13");

		String T1 = "Social";
		String T2 = "Industrial";
		String T3 = "Educativo";
		String T4 = "Interdisciplinario";

		AltaCurso ac1 = new AltaCurso("Talleres plenarios",
				"*Talleres plenarios*: presentados por cuatro reconocidos matematicos uruguayos, plantearan diversos topicos de matematica en el marco cuales se realizaran actividades fomentando la integracion entre estudiantes, docentes e investigadores.",
				3, 15, 1, "http://www.tmu.edu.uy", date1);
		List<String> l1 = new ArrayList();
		List<String> lc1 = new ArrayList();
		ret = ac1.createCurso("IMERL", l1, lc1);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac2 = new AltaCurso("Seminarios de Resolucion de Problemas",
				"Seminario, *todos los jueves* en Facultad de Ingenieria a partir del jueves 25 de Julio, en las areas en que se desarrollan los problemas de las Olimpiadas de Matematica.",
				5, 30, 2, "http://www.tmu.edu.uy", date2);
		List<String> l2 = new ArrayList();
		List<String> lc2 = new ArrayList();
		l2.add("Talleres plenarios");
		ret = ac2.createCurso("IMERL", l2, lc2);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac3 = new AltaCurso("Dalavuelta",
				"Dalavuelta es un proyecto de extension que nace en el Instituto de Ingenieria Mecanica y Produccion Industrial (IIMPI) de Fing, que, si bien inicia su trabajo en el desarrollo de bicicletas accesibles para personas en situacion de discapacidad motriz a partir de bicicletas abandonadas, se propuso disenar otras herramientas para fomentar la accesibilidad.",
				10, 60, 4, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", date3);
		List<String> l3 = new ArrayList();
		List<String> lc3 = new ArrayList();
		lc3.add(T1);
		l3.add("Talleres plenarios");
		ret = ac3.createCurso("IMPII", l3, lc3);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac4 = new AltaCurso("Extensionismo Industrial",
				"El proyecto tiene como objetivo desarrollar intervenciones curriculares en pequeños emprendimientos productivos de diferentes sectores de la industria nacional.La metodologias de trabajo permite articular diversas intervenciones, combinando actividades de enseñanza, extension e investigacion por parte de docentes del IMPII.",
				12, 75, 5, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", date4);
		List<String> l4 = new ArrayList();
		List<String> lc4 = new ArrayList();
		lc4.add(T2);
		l4.add("Talleres plenarios");
		ret = ac4.createCurso("IMPII", l4, lc4);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac5 = new AltaCurso("Inclusion Energetica",
				"En el proyecto se conjuga el trabajo de docentes y estudiantes de la carrera Ingenieria Industrial Mecanica a traves del Modulo de Extension, en donde se trabaja en el diseño, construccion y prueba de un prototipo de colector solar adquiriendo conocimientos relevantes para luego poder replicarlos junto a las familias en los talleres. Las premisas fundamentales a la hora de pensar los diseñosson: por un lado el bajo costo de los materiales y por otro la facil construccion de forma de poder construirlos ellos mismos.",
				6, 45, 3, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", date5);
		List<String> l5 = new ArrayList();
		List<String> lc5 = new ArrayList();
		lc5.add(T2);
		ret = ac5.createCurso("IMPII", l5, lc5);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac6 = new AltaCurso("Flor del Ceibo",
				"Flor de Ceibo es un proyecto central de la Universidad de la Republica, que tiene mision por movilizar la participacion de estudiantes universitarios en diversas tareas vinculadas con la puesta en funcionamiento del Plan Ceibal en el territorio nacional.",
				15, 150, 10, "http://www.flordeceibo.edu.uy/", date6);
		List<String> l6 = new ArrayList();
		List<String> lc6 = new ArrayList();
		lc6.add(T3);
		lc6.add(T4);
		ret = ac6.createCurso("DISI", l6, lc6);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac7 = new AltaCurso("Taller de robotica educativa.",
				"La asignatura se organiza en dos etapas. La primer etapa se dicta a traves de clases teoricopracticas, donde se espera ademas que cada estudiante le dedique horas de estudio. La segunda etapa consiste en que los estudiantes trabajen en grupo sobre el diseño e implementacion de una experiencia didactica de inclusion del robot Butia en el aula, utilizando los conocimientos aprendidos en clase.",
				8, 90, 6, "https://eva.fing.edu.uy/course/view.php?id=1187", date7);
		List<String> l7 = new ArrayList();
		List<String> lc7 = new ArrayList();
		lc7.add(T1);
		lc7.add(T3);
		ret = ac7.createCurso("INCO", l7, lc7);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac8 = new AltaCurso(
				"Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela",
				"Se propone desarrollar una aplicacion interactiva para tablet Android basada en el juego de tablero Komikan (version web del juego https://codepen.io/Borborem/full/OvZBvZ/), que incluya los distintos aspectos concernientes al juego, asi como a situaciones especificas particulares.",
				9, 45, 3, "https://eva.fing.edu.uy/mod/folder/view.php?id=89398", date8);
		List<String> l8 = new ArrayList();
		List<String> lc8 = new ArrayList();
		lc8.add(T3);
		ret = ac8.createCurso("INCO", l8, lc8);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac9 = new AltaCurso("Herramientas de apoyo a la ensenianza de ingles. Instalacion y evaluacion",
				"Se realizaran visitas a escuelas rurales participantes en un proyecto conjunto del grupo PLN y el Programa de Politicas Lingüisticas de ANEP, en el marco del cual se desarrollaron diferentes herramientas para uso de maestros que enseñan ingles con apoyo remoto de profesores especializados desde Montevideo.",
				12, 60, 4, "https://eva.fing.edu.uy/mod/folder/view.php?id=89398", date9);
		List<String> l9 = new ArrayList();
		List<String> lc9 = new ArrayList();
		lc9.add(T1);
		lc9.add(T3);
		ret = ac9.createCurso("INCO", l9, lc9);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AltaCurso ac10 = new AltaCurso("MicroBit",
				"El Centro Ceibal se encuentra distribuyendo placas micro:bit (https://microbit.ceibal.edu.uy/) para que estudiantes de primaria y secundaria aprendan nociones basicas de robotica, electronica y programacion de forma autonoma y ludica. Estas placas se basan en un microcontrolador y cuentan con leds, botones, acelerometro, brujula, bluetooth y otros sensores. Ademas, las placas se programan facilmente con lenguaje tipo “scratch�? y python, por lo que son muy utiles para un primer acercamiento a la tematica.",
				15, 105, 7, "https://www.fing.edu.uy/noticias/extension/modulo-detallerextensionmicrobit", date10);
		List<String> l10 = new ArrayList();
		List<String> lc10 = new ArrayList();
		lc10.add(T2);
		lc10.add(T3);
		ret = ac10.createCurso("Electrica", l10, lc10);
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Alta Edicion Curso

		Date fInicio1 = Date.valueOf("2010-03-15");
		Date fFin1 = Date.valueOf("2010-07-07");
		Date fAlta1 = Date.valueOf("2010-02-16");
		AltaEdicionCurso aec1 = new AltaEdicionCurso("Flor del Ceibo - 2010", "Flor del Ceibo", fInicio1, fFin1, 0,
				fAlta1);
		List<String> l11 = new ArrayList();
		l11.add("bruces");
		ret = aec1.createEdicionCurso(l11);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio2 = Date.valueOf("2012-08-01");
		Date fFin2 = Date.valueOf("2012-11-20");
		Date fAlta2 = Date.valueOf("2012-07-10");
		AltaEdicionCurso aec2 = new AltaEdicionCurso("Flor del Ceibo - 2012", "Flor del Ceibo", fInicio2, fFin2, 0,
				fAlta2);
		List<String> l22 = new ArrayList();
		l22.add("bruces");
		l22.add("adri");
		ret = aec2.createEdicionCurso(l22);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio3 = Date.valueOf("2018-04-10");
		Date fFin3 = Date.valueOf("2018-08-07");
		Date fAlta3 = Date.valueOf("2018-03-06");
		AltaEdicionCurso aec3 = new AltaEdicionCurso("Flor del Ceibo - 2018", "Flor del Ceibo", fInicio3, fFin3, 0,
				fAlta3);
		List<String> l33 = new ArrayList();
		l33.add("bruces");
		l33.add("adri");
		ret = aec3.createEdicionCurso(l33);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio4 = Date.valueOf("2017-08-20");
		Date fFin4 = Date.valueOf("2017-11-10");
		Date fAlta4 = Date.valueOf("2017-07-20");
		AltaEdicionCurso aec4 = new AltaEdicionCurso("Dalavuelta - 2018", "Dalavuelta", fInicio4, fFin4, 15, fAlta4);
		List<String> l44 = new ArrayList();
		l44.add("phils");
		ret = aec4.createEdicionCurso(l44);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio44 = Date.valueOf("2020-08-20");
		Date fFin44 = Date.valueOf("2020-12-25");
		Date fAlta44 = Date.valueOf("2020-10-20");
		AltaEdicionCurso aec44 = new AltaEdicionCurso("Dalavuelta - 2020", "Dalavuelta", fInicio44, fFin44, 15, fAlta44);
		List<String> l444 = new ArrayList();
		l444.add("phils");
		ret = aec44.createEdicionCurso(l444);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio5 = Date.valueOf("2018-08-10");
		Date fFin5 = Date.valueOf("2018-11-10");
		Date fAlta5 = Date.valueOf("2018-07-08");
		AltaEdicionCurso aec5 = new AltaEdicionCurso("Extensionismo Industrial - 2018", "Extensionismo Industrial",
				fInicio5, fFin5, 15, fAlta5);
		List<String> l55 = new ArrayList();
		l55.add("phils");
		ret = aec5.createEdicionCurso(l55);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio6 = Date.valueOf("2019-03-15");
		Date fFin6 = Date.valueOf("2019-04-30");
		Date fAlta6 = Date.valueOf("2019-02-20");
		AltaEdicionCurso aec6 = new AltaEdicionCurso("Inclusion Energetica - 2019", "Inclusion Energetica", fInicio6,
				fFin6, 30, fAlta6);
		List<String> l66 = new ArrayList();
		l66.add("phils");
		ret = aec6.createEdicionCurso(l66);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio7 = Date.valueOf("2017-03-10");
		Date fFin7 = Date.valueOf("2017-05-17");
		Date fAlta7 = Date.valueOf("2017-02-17");
		List<String> l77 = new ArrayList();
		l77.add("heisenberg");
		AltaEdicionCurso aec7 = new AltaEdicionCurso("Taller de robotica educativa - 2017",
				"Taller de robotica educativa.", fInicio7, fFin7, 10, fAlta7);
		ret = aec7.createEdicionCurso(l77);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio8 = Date.valueOf("2019-03-10");
		Date fFin8 = Date.valueOf("2019-05-10");
		Date fAlta8 = Date.valueOf("2019-02-15");
		List<String> l88 = new ArrayList();
		l88.add("heisenberg");
		l88.add("benkenobi");
		AltaEdicionCurso aec8 = new AltaEdicionCurso("Taller de robotica educativa - 2019",
				"Taller de robotica educativa.", fInicio8, fFin8, 10, fAlta8);
		ret = aec8.createEdicionCurso(l88);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio9 = Date.valueOf("2019-09-10");
		Date fFin9 = Date.valueOf("2019-11-08");
		Date fAlta9 = Date.valueOf("2019-08-15");
		List<String> l99 = new ArrayList();
		l99.add("benkenobi");
		l99.add("waston");
		AltaEdicionCurso aec9 = new AltaEdicionCurso("Taller de robotica educativa - 2019-2",
				"Taller de robotica educativa.", fInicio9, fFin9, 20, fAlta9);
		ret = aec9.createEdicionCurso(l99);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio10 = Date.valueOf("2019-07-29");
		Date fFin10 = Date.valueOf("2019-10-07");
		Date fAlta10 = Date.valueOf("2019-07-10");
		List<String> l101 = new ArrayList();
		l101.add("waston");
		AltaEdicionCurso aec10 = new AltaEdicionCurso(
				"Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela - 2019",
				"Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela",
				fInicio10, fFin10, 5, fAlta10);
		ret = aec10.createEdicionCurso(l101);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio11 = Date.valueOf("2019-09-15");
		Date fFin11 = Date.valueOf("2019-12-15");
		Date fAlta11 = Date.valueOf("2019-06-02");
		AltaEdicionCurso aec11 = new AltaEdicionCurso(
				"Herramientas de apoyo a la ensenianza de ingles. Instalacion y evaluacion - 2019",
				"Herramientas de apoyo a la ensenianza de ingles. Instalacion y evaluacion", fInicio11, fFin11, 5,
				fAlta11);
		List<String> l111 = new ArrayList();
		l111.add("heisenberg");
		ret = aec11.createEdicionCurso(l111);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio12 = Date.valueOf("2019-08-12");
		Date fFin12 = Date.valueOf("2019-12-5");
		Date fAlta12 = Date.valueOf("2019-07-02");
		AltaEdicionCurso aec12 = new AltaEdicionCurso("MicroBit - 2019", "MicroBit", fInicio12, fFin12, 30, fAlta12);
		List<String> l12 = new ArrayList();
		l12.add("house");
		ret = aec12.createEdicionCurso(l12);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio13 = Date.valueOf("2019-03-10");
		Date fFin13 = Date.valueOf("2019-03-30");
		Date fAlta13 = Date.valueOf("2019-03-02");
		AltaEdicionCurso aec13 = new AltaEdicionCurso("Talleres plenarios - 2019", "Talleres plenarios ", fInicio13,
				fFin13, 0, fAlta13);
		List<String> l13 = new ArrayList();
		l13.add("timmy");
		l13.add("danny");
		ret = aec13.createEdicionCurso(l13);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date fInicio14 = Date.valueOf("2019-09-10");
		Date fFin14 = Date.valueOf("2019-10-20");
		Date fAlta14 = Date.valueOf("2019-07-12");
		AltaEdicionCurso aec14 = new AltaEdicionCurso("Seminarios de Resolucion de Problemas - 2019",
				"Seminarios de Resolucion de Problemas", fInicio14, fFin14, 0, fAlta14);
		List<String> l14 = new ArrayList();
		l14.add("timmy");
		ret = aec14.createEdicionCurso(l14);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		
		

		// Cargar Inscripciones Edicion

		String e1 = "Flor del Ceibo - 2010";
		String e2 = "Flor del Ceibo - 2012";
		String e3 = "Flor del Ceibo - 2018";
		String e4 = "Dalavuelta - 2018";
		String e5 = "Extensionismo Industrial - 2018";
		String e6 = "Inclusion Energetica - 2019";
		String e7 = "Taller de robotica educativa - 2017";
		String e8 = "Taller de robotica educativa - 2019";
		String e9 = "Taller de robotica educativa - 2019-2";
		String e10 = "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela - 2019";
		String e11 = "Herramientas de apoyo a la ensenianza de ingles. Instalacion y evaluacion - 2019";
		String e12 = "MicroBit - 2019";
		String e13 = "Talleres plenarios - 2019";
		String e14 = "Seminarios de Resolucion de Problemas - 2019";

		Date i1 = Date.valueOf("2010-02-20");
		InscripcionAEdicion ieh1 = new InscripcionAEdicion("hrfj", i1, e1, "");
		ret = ieh1.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		i1 = Date.valueOf("2010-02-20");
		InscripcionAEdicion ie1 = new InscripcionAEdicion("eleven11", i1, e1, "");
		ret = ie1.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i2 = Date.valueOf("2010-02-25");
		InscripcionAEdicion ie2 = new InscripcionAEdicion("chechi", i2, e1, "");
		ret = ie2.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i3 = Date.valueOf("2012-07-12");
		InscripcionAEdicion ie3 = new InscripcionAEdicion("costas", i3, e2, "");
		ret = ie3.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i4 = Date.valueOf("2012-07-15");
		InscripcionAEdicion ie4 = new InscripcionAEdicion("roro", i4, e2, "");
		ret = ie4.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i5 = Date.valueOf("2012-07-30");
		InscripcionAEdicion ie5 = new InscripcionAEdicion("weiss", i5, e2, "");
		ret = ie5.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i6 = Date.valueOf("2018-03-10");
		InscripcionAEdicion ie6 = new InscripcionAEdicion("roro", i6, e3, "");
		ret = ie6.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i7 = Date.valueOf("2018-03-15");
		InscripcionAEdicion ie7 = new InscripcionAEdicion("jeffw", i7, e3, "");
		ret = ie7.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i8 = Date.valueOf("2017-07-25");
		InscripcionAEdicion ie8 = new InscripcionAEdicion("chechi", i8, e4, "");
		ret = ie8.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i9 = Date.valueOf("2017-07-28");
		InscripcionAEdicion ie9 = new InscripcionAEdicion("eleven11", i9, e4, "");
		ret = ie9.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i10 = Date.valueOf("2017-08-02");
		InscripcionAEdicion ie10 = new InscripcionAEdicion("roro", i10, e4, "");
		ret = ie10.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i11 = Date.valueOf("2017-08-10");
		InscripcionAEdicion ie11 = new InscripcionAEdicion("costas", i11, e4, "");
		ret = ie11.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i12 = Date.valueOf("2017-08-15");
		InscripcionAEdicion ie12 = new InscripcionAEdicion("jeffw", i12, e4, "");
		ret = ie12.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i13 = Date.valueOf("2018-07-18");
		InscripcionAEdicion ie13 = new InscripcionAEdicion("costas", i13, e5, "");
		ret = ie13.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i14 = Date.valueOf("2018-07-20");
		InscripcionAEdicion ie14 = new InscripcionAEdicion("chechi", i14, e5, "");
		ret = ie14.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i15 = Date.valueOf("2018-07-29");
		InscripcionAEdicion ie15 = new InscripcionAEdicion("eleven11", i15, e5, "");
		ret = ie15.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i16 = Date.valueOf("2018-08-05");
		InscripcionAEdicion ie16 = new InscripcionAEdicion("weiss", i16, e5, "");
		ret = ie16.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i17 = Date.valueOf("2019-02-23");
		InscripcionAEdicion ie17 = new InscripcionAEdicion("roro", i17, e6, "");
		ret = ie17.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i18 = Date.valueOf("2019-02-25");
		InscripcionAEdicion ie18 = new InscripcionAEdicion("weiss", i18, e6, "");
		ret = ie18.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i19 = Date.valueOf("2019-02-28");
		InscripcionAEdicion ie19 = new InscripcionAEdicion("chechi", i19, e6, "");
		ret = ie19.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i20 = Date.valueOf("2019-03-03");
		InscripcionAEdicion ie20 = new InscripcionAEdicion("eleven11", i20, e6, "");
		ret = ie20.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i21 = Date.valueOf("2017-02-18");
		InscripcionAEdicion ie21 = new InscripcionAEdicion("weiss", i21, e7, "");
		ret = ie21.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i22 = Date.valueOf("2017-02-20");
		InscripcionAEdicion ie22 = new InscripcionAEdicion("roro", i22, e7, "");
		ret = ie22.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i23 = Date.valueOf("2017-03-03");
		InscripcionAEdicion ie23 = new InscripcionAEdicion("eleven11", i23, e7, "");
		ret = ie23.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i24 = Date.valueOf("2017-03-05");
		InscripcionAEdicion ie24 = new InscripcionAEdicion("chechi", i24, e7, "");
		ret = ie24.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i25 = Date.valueOf("2019-02-18");
		InscripcionAEdicion ie25 = new InscripcionAEdicion("jeffw", i25, e8, "");
		ret = ie25.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i26 = Date.valueOf("2019-02-22");
		InscripcionAEdicion ie26 = new InscripcionAEdicion("costas", i26, e8, "");
		ret = ie26.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i27 = Date.valueOf("2019-08-18");
		InscripcionAEdicion ie27 = new InscripcionAEdicion("weiss", i27, e9, "");
		ret = ie27.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i28 = Date.valueOf("2019-08-22");
		InscripcionAEdicion ie28 = new InscripcionAEdicion("chechi", i28, e9, "");
		ret = ie28.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i29 = Date.valueOf("2019-09-03");
		InscripcionAEdicion ie29 = new InscripcionAEdicion("roro", i29, e9, "");
		ret = ie29.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i30 = Date.valueOf("2019-07-13");
		InscripcionAEdicion ie30 = new InscripcionAEdicion("chechi", i30, e10, "");
		ret = ie30.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i31 = Date.valueOf("2019-07-20");
		InscripcionAEdicion ie31 = new InscripcionAEdicion("weiss", i31, e10, "");
		ret = ie31.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i32 = Date.valueOf("2019-07-22");
		InscripcionAEdicion ie32 = new InscripcionAEdicion("roro", i32, e10, "");
		ret = ie32.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i33 = Date.valueOf("2019-06-04");
		InscripcionAEdicion ie33 = new InscripcionAEdicion("weiss", i33, e11, "");
		ret = ie33.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i34 = Date.valueOf("2019-07-18");
		InscripcionAEdicion ie34 = new InscripcionAEdicion("eleven11", i34, e11, "");
		ret = ie34.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i35 = Date.valueOf("2019-08-20");
		InscripcionAEdicion ie35 = new InscripcionAEdicion("jeffw", i35, e11, "");
		ret = ie35.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i36 = Date.valueOf("2019-07-12");
		InscripcionAEdicion ie36 = new InscripcionAEdicion("chechi", i36, e12, "");
		ret = ie36.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i37 = Date.valueOf("2019-07-14");
		InscripcionAEdicion ie37 = new InscripcionAEdicion("roro", i37, e12, "");
		ret = ie37.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i38 = Date.valueOf("2019-07-25");
		InscripcionAEdicion ie38 = new InscripcionAEdicion("eleven11", i38, e12, "");
		ret = ie38.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i39 = Date.valueOf("2019-08-05");
		InscripcionAEdicion ie39 = new InscripcionAEdicion("jeffw", i39, e12, "");
		ret = ie39.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i40 = Date.valueOf("2019-03-05");
		InscripcionAEdicion ie40 = new InscripcionAEdicion("costas", i40, e13, "");
		ret = ie40.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}

		Date i41 = Date.valueOf("2019-03-04");
		InscripcionAEdicion ie41 = new InscripcionAEdicion("weiss", i41, e13, "");
		ret = ie41.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i42 = Date.valueOf("2019-03-07");
		InscripcionAEdicion ie42 = new InscripcionAEdicion("roro", i42, e13, "");
		ret = ie42.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i43 = Date.valueOf("2019-07-15");
		InscripcionAEdicion ie43 = new InscripcionAEdicion("weiss", i43, e14, "");
		ret = ie43.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i44 = Date.valueOf("2019-07-20");
		InscripcionAEdicion ie44 = new InscripcionAEdicion("costas", i44, e14, "");
		ret = ie44.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i45 = Date.valueOf("2019-08-06");
		InscripcionAEdicion ie45 = new InscripcionAEdicion("roro", i45, e14, "");
		ret = ie45.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		Date i46 = Date.valueOf("2019-08-30");
		InscripcionAEdicion ie46 = new InscripcionAEdicion("chechi", i46, e14, "");
		ret = ie46.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Alta Formacion & Agregar Cursos a Formacion

		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		Date fecha = Date.valueOf(annio + "-" + mes + "-" + dia);

		fInicio1 = Date.valueOf("2019-05-01");
		fFin1 = Date.valueOf("2019-10-31");
		AltaFormacion f1 = new AltaFormacion("EFI Ingenieria Mecanica", "Programa mecanica", fInicio1, fFin1, fecha);
		ret = f1.createFormacion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AgregarCursoAFormacion af1 = new AgregarCursoAFormacion("EFI Ingenieria Mecanica");
		List<String> lf1 = new ArrayList();
		lf1.add("Dalavuelta");
		lf1.add("Extensionismo Industrial");
		lf1.add("Inclusion Energetica");
		ret = af1.agregarCursosAFor(lf1);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		fInicio2 = Date.valueOf("2019-07-15");
		fFin2 = Date.valueOf("2020-01-01");
		AltaFormacion f2 = new AltaFormacion("Formacion integral", "Programa varios institutos", fInicio2, fFin2,
				fecha);
		ret = f2.createFormacion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AgregarCursoAFormacion af2 = new AgregarCursoAFormacion("Formacion integral");
		List<String> lf2 = new ArrayList();
		lf2.add("Seminarios de Resolucion de Problemas");
		lf2.add("Extensionismo Industrial");
		lf2.add("Flor del Ceibo");
		lf2.add("Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela");
		ret = af2.agregarCursosAFor(lf2);
		if (!ret.isEmpty()) {
			fail(ret);
		}
		fInicio3 = Date.valueOf("2019-09-03");
		fFin3 = Date.valueOf("2019-11-18");
		AltaFormacion f3 = new AltaFormacion("EFI Robotica", "Programa robotica", fInicio3, fFin3, fecha);
		ret = f3.createFormacion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		AgregarCursoAFormacion af3 = new AgregarCursoAFormacion("EFI Robotica");
		List<String> lf3 = new ArrayList();
		lf3.add("Taller de robotica educativa.");
		lf3.add("MicroBit");
		ret = af3.agregarCursosAFor(lf3);
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Inscripcion a Formacion

		String el = "eleven11";
		String ch = "chechi";
		String co = "costas";
		String we = "weiss";
		String ro = "roro";
		String jw = "jeffw";
		String p1 = "EFI Ingenieria Mecanica";
		String p2 = "Formacion integral";
		String p3 = "EFI Robotica";

		InscripcionAFormacion if1 = new InscripcionAFormacion(el, fecha, p1);
		InscripcionAFormacion if2 = new InscripcionAFormacion(ch, fecha, p1);
		InscripcionAFormacion if3 = new InscripcionAFormacion(co, fecha, p2);
		InscripcionAFormacion if4 = new InscripcionAFormacion(ch, fecha, p2);
		InscripcionAFormacion if5 = new InscripcionAFormacion(el, fecha, p2);
		InscripcionAFormacion if6 = new InscripcionAFormacion(we, fecha, p2);
		InscripcionAFormacion if7 = new InscripcionAFormacion(ro, fecha, p2);
		InscripcionAFormacion if8 = new InscripcionAFormacion(co, fecha, p3);
		InscripcionAFormacion if9 = new InscripcionAFormacion(ch, fecha, p3);
		InscripcionAFormacion if10 = new InscripcionAFormacion(ro, fecha, p3);
		InscripcionAFormacion if11 = new InscripcionAFormacion(jw, fecha, p3);
		ret = if1.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if2.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if3.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if4.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if5.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if6.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if7.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if8.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if9.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if10.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}
		ret = if11.inscripcion();
		if (!ret.isEmpty()) {
			fail(ret);
		}

		// Lista categorias

		List<DTCategoria> list = new ListaCategoria().getDataTypeList();
		if (list.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<String> list1 = new ListaCategoria().getListPorFormacion("EFI Ingenieria Mecanica");
		if (list1.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTCurso> list2 = new ListaCursos().getDataTypeListPorCat("Educativo");
		if (list2.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTCurso> list3 = new ListaCursos().getDataTypeListConInstituto("IMPII");
		if (list3.isEmpty()) {
			fail("Lista no esperada!");
		}

		list3 = new ListaCursos().BusquedaFiltro("o");
		if (list3.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTEdicionCurso> list4 = new ListaEdicionCurso().getDataTypeList();
		if (list4.isEmpty()) {
			fail("Lista no esperada!");
		}
		list4 = new ListaEdicionCurso().getDataTypeListByCurso("Dalavuelta");
		if (list4.isEmpty()) {
			fail("Lista no esperada!");
		}
		list4 = new ListaEdicionCurso().getDataTypeListByDosente("phils");
		if (list4.isEmpty()) {
			fail("Lista no esperada!");
		}
		List<DTFormacion> list5 = new ListaFormacion().listaFormacionesPorCurso("Flor del Ceibo");
		if (list5.isEmpty()) {
			fail("Lista no esperada!");
		}

		list5 = new ListaFormacion().BusquedaFiltro("o");
		if (list5.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTInscripcion_Edicion> list6 = new ListaInscripciones().getDTlist();
		if (list6.isEmpty()) {
			fail("Lista no esperada!");
		}
		list6 = new ListaInscripciones().getDTlistPorEstudiante("hrfj");
		if (list6.isEmpty()) {
			fail("Lista no esperada!");
		}
		list6 = new ListaInscripciones().getDTlistPorEdicion("Dalavuelta - 2018");
		if (list6.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTInstituto> listi = new ListaInstitutos().getDataTypeList();
		if (list6.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTInscripcion_Formacion> list7 = new ListaInscripcionesFor().getDTlist();
		if (list7.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTInscripcion_Formacion> list8 = new ListaInscripcionesFor().getDTlistPorEstudiante("costas");
		if (list7.isEmpty()) {
			fail("Lista no esperada!");
		}

		list8 = new ListaInscripcionesFor().getDTlistPorFormacion("EFI Ingenieria Mecanica");
		if (list7.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTEstudiante> list0 = new ListaUsuarios().getDataTypeListEstudiante();
		if (list0.isEmpty()) {
			fail("Lista no esperada!");
		}

		List<DTDocente> list01 = new ListaUsuarios().getDataTypeListDocente();
		if (list01.isEmpty()) {
			fail("Lista no esperada!");
		}
		ModificarUsuario mu = new ModificarUsuario("hrfj", "Hernan", "Fabrica", Date.valueOf("2000-06-04"));
		mu.modificarEstudiante();
		ModificarUsuario mu1 = new ModificarUsuario("phils", "Philip", "Schiller", date7);
		mu1.modificarDocente();
	}

}
