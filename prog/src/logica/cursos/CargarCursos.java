package logica.cursos;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class CargarCursos {
        public String cargarCursos() {
                String ret = "";
                Date date1 = Date.valueOf("2019-02-01");
                Date date2 = Date.valueOf("2019-07-12");
                Date date3 = Date.valueOf("2025-06-25");
                Date date4 = Date.valueOf("2018-06-16");
                Date date5 = Date.valueOf("2019-02-01");
                Date date6 = Date.valueOf("2008-07-27");
                Date date7 = Date.valueOf("2017-02-02");
                Date date8 = Date.valueOf("2019-06-15");
                Date date9 = Date.valueOf("2019-05-24");
                Date date10 = Date.valueOf("2019-03-13");

                AltaCurso ac1 = new AltaCurso("Talleres plenarios",
                                "*Talleres plenarios*: presentados por cuatro reconocidos matematicos uruguayos, plantearan diversos topicos de matematica en el marco cuales se realizaran actividades fomentando la integracion entre estudiantes, docentes e investigadores.",
                                3, 15, 1, "http://www.tmu.edu.uy", date1);
                List<String> l1 = new ArrayList();
                List<String> lc1 = new ArrayList();
                ret += ac1.createCurso("IMERL", l1,lc1);

                AltaCurso ac2 = new AltaCurso("Seminarios de Resolucion de Problemas",
                                "Seminario, *todos los jueves* en Facultad de Ingenieria a partir del jueves 25 de Julio, en las areas en que se desarrollan los problemas de las Olimpiadas de Matematica.",
                                5, 30, 2, "http://www.tmu.edu.uy", date2);
                List<String> l2 = new ArrayList();
                l2.add("Talleres plenarios");
                ret += ac2.createCurso("IMERL", l2);

                AltaCurso ac3 = new AltaCurso("Dalavuelta",
                                "Dalavuelta es un proyecto de extension que nace en el Instituto de Ingenieria Mecanica y Produccion Industrial (IIMPI) de Fing, que, si bien inicia su trabajo en el desarrollo de bicicletas accesibles para personas en situacion de discapacidad motriz a partir de bicicletas abandonadas, se propuso disenar otras herramientas para fomentar la accesibilidad.",
                                10, 60, 4, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", date3);
                List<String> l3 = new ArrayList();
                l3.add("Talleres plenarios");
                ret += ac3.createCurso("IMPII", l3);

                AltaCurso ac4 = new AltaCurso("Extensionismo Industrial",
                                "El proyecto tiene como objetivo desarrollar intervenciones curriculares en pequeños emprendimientos productivos de diferentes sectores de la industria nacional.La metodologias de trabajo permite articular diversas intervenciones, combinando actividades de enseñanza, extension e investigacion por parte de docentes del IMPII.",
                                12, 75, 5, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", date4);
                List<String> l4 = new ArrayList();
                l4.add("Talleres plenarios");
                ret += ac4.createCurso("IMPII", l4);

                AltaCurso ac5 = new AltaCurso("Inclusion Energetica",
                                "En el proyecto se conjuga el trabajo de docentes y estudiantes de la carrera Ingenieria Industrial Mecanica a traves del Modulo de Extension, en donde se trabaja en el diseño, construccion y prueba de un prototipo de colector solar adquiriendo conocimientos relevantes para luego poder replicarlos junto a las familias en los talleres. Las premisas fundamentales a la hora de pensar los diseñosson: por un lado el bajo costo de los materiales y por otro la facil construccion de forma de poder construirlos ellos mismos.",
                                6, 45, 3, "https://eva.fing.edu.uy/course/view.php?id=783#section-2", date5);
                List<String> l5 = new ArrayList();
                ret += ac5.createCurso("IMPII", l5);

                AltaCurso ac6 = new AltaCurso("Flor del Ceibo",
                                "Flor de Ceibo es un proyecto central de la Universidad de la Republica, que tiene mision por movilizar la participacion de estudiantes universitarios en diversas tareas vinculadas con la puesta en funcionamiento del Plan Ceibal en el territorio nacional.",
                                15, 150, 10, "http://www.flordeceibo.edu.uy/", date6);
                List<String> l6 = new ArrayList();
                ret += ac6.createCurso("DISI", l6);

                AltaCurso ac7 = new AltaCurso("Taller de robotica educativa.",
                                "La asignatura se organiza en dos etapas. La primer etapa se dicta a traves de clases teoricopracticas, donde se espera ademas que cada estudiante le dedique horas de estudio. La segunda etapa consiste en que los estudiantes trabajen en grupo sobre el diseño e implementacion de una experiencia didactica de inclusion del robot Butia en el aula, utilizando los conocimientos aprendidos en clase.",
                                8, 90, 6, "https://eva.fing.edu.uy/course/view.php?id=1187", date7);
                List<String> l7 = new ArrayList();
                ret += ac7.createCurso("INCO", l7);

                AltaCurso ac8 = new AltaCurso(
                                "Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela",
                                "Se propone desarrollar una aplicacion interactiva para tablet Android basada en el juego de tablero Komikan (version web del juego https://codepen.io/Borborem/full/OvZBvZ/), que incluya los distintos aspectos concernientes al juego, asi como a situaciones especificas particulares.",
                                9, 45, 3, "https://eva.fing.edu.uy/mod/folder/view.php?id=89398", date8);
                List<String> l8 = new ArrayList();
                ret += ac8.createCurso("INCO", l8);

                AltaCurso ac9 = new AltaCurso(
                                "Herramientas de apoyo a la enseñanza de ingles. Instalacion y evaluacion",
                                "Se realizaran visitas a escuelas rurales participantes en un proyecto conjunto del grupo PLN y el Programa de Politicas Lingüisticas de ANEP, en el marco del cual se desarrollaron diferentes herramientas para uso de maestros que enseñan ingles con apoyo remoto de profesores especializados desde Montevideo.",
                                12, 60, 4, "https://eva.fing.edu.uy/mod/folder/view.php?id=89398", date9);
                List<String> l9 = new ArrayList();
                ret += ac9.createCurso("INCO", l9);

                AltaCurso ac10 = new AltaCurso("MicroBit",
                                "El Centro Ceibal se encuentra distribuyendo placas micro:bit (https://microbit.ceibal.edu.uy/) para que estudiantes de primaria y secundaria aprendan nociones basicas de robotica, electronica y programacion de forma autonoma y ludica. Estas placas se basan en un microcontrolador y cuentan con leds, botones, acelerometro, brujula, bluetooth y otros sensores. Ademas, las placas se programan facilmente con lenguaje tipo “scratch�? y python, por lo que son muy utiles para un primer acercamiento a la tematica.",
                                15, 105, 7,
                                "https://www.fing.edu.uy/noticias/extension/modulo-detallerextensionmicrobit", date10);
                List<String> l10 = new ArrayList();
                ret += ac10.createCurso("Electrica", l10);

                return ret;
        }
}
