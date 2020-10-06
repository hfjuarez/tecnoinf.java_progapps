package logica.edicioncursos;

import java.sql.Date;
import java.util.*;

import logica.inscripciones.InscripcionAEdicion;

public class CargarEdicion {
    public String cargarEdicion() {
        String ret = "";
        Date fInicio1 =  Date.valueOf("2010-03-15");
        Date fFin1 =  Date.valueOf("2010-07-07");
        Date fAlta1 =  Date.valueOf("2010-02-16");
        AltaEdicionCurso aec1 = new AltaEdicionCurso("Flor del Ceibo - 2010", "Flor de Ceibo", fInicio1, fFin1, 0, fAlta1);
        List<String> l1 = new ArrayList();
        l1.add("bruces");
        ret += aec1.createEdicionCurso(l1);
        
        Date fInicio2 =  Date.valueOf("2012-08-01");
        Date fFin2 =  Date.valueOf("2012-11-20");
        Date fAlta2 =  Date.valueOf("2012-07-10");
        AltaEdicionCurso aec2 = new AltaEdicionCurso("Flor del Ceibo - 2010", "Flor de Ceibo", fInicio2, fFin2, 0, fAlta2);
        List<String> l2 = new ArrayList();
        l2.add("bruces");
        l2.add("adri");
        ret += aec2.createEdicionCurso(l2);

        Date fInicio3 =  Date.valueOf("2018-04-10");
        Date fFin3 =  Date.valueOf("2018-08-07");
        Date fAlta3 =  Date.valueOf("2018-03-06");
        AltaEdicionCurso aec3 = new AltaEdicionCurso("Flor del Ceibo - 2018", "Flor de Ceibo", fInicio3, fFin3, 0, fAlta3);
        List<String> l3 = new ArrayList();
        l3.add("bruces");
        l3.add("adri");
        ret += aec3.createEdicionCurso(l3);

        Date fInicio4 =  Date.valueOf("2017-08-20");
        Date fFin4 =  Date.valueOf("2017-11-10");
        Date fAlta4 =  Date.valueOf("2017-07-20");
        AltaEdicionCurso aec4 = new AltaEdicionCurso("Dalavuelta - 2018", "Dalavuelta", fInicio4, fFin4, 15, fAlta4);
        List<String> l4 = new ArrayList();
        l4.add("phils");
        ret += aec4.createEdicionCurso(l4);

        Date fInicio5 =  Date.valueOf("2018-08-10");
        Date fFin5 =  Date.valueOf("2018-11-10");
        Date fAlta5 =  Date.valueOf("2018-07-08");
        AltaEdicionCurso aec5 = new AltaEdicionCurso("Extensionismo Industrial - 2018", "Extensionismo Industrial", fInicio5, fFin5, 15, fAlta5);
        List<String> l5 = new ArrayList();
        l5.add("phils");
        ret += aec5.createEdicionCurso(l5);

        Date fInicio6 =  Date.valueOf("2019-03-15");
        Date fFin6 =  Date.valueOf("2019-04-30");
        Date fAlta6 =  Date.valueOf("2019-02-20");
        AltaEdicionCurso aec6 = new AltaEdicionCurso("Inclusion Energetica - 2019", "Inclusion Energetica", fInicio6, fFin6, 30, fAlta6);
        List<String> l6 = new ArrayList();
        l6.add("phils");
        ret += aec6.createEdicionCurso(l6);
        
        Date fInicio7 =  Date.valueOf("2017-03-10");
        Date fFin7 =  Date.valueOf("2017-05-17");
        Date fAlta7 =  Date.valueOf("2017-02-17");
        List <String> l7 = new ArrayList();
        l7.add("heisenberg");
        AltaEdicionCurso aec7 = new AltaEdicionCurso("Taller de robotica educativa - 2017", "Taller de robotica educativa",fInicio7,fFin7,10,fAlta7 );
        ret += aec7.createEdicionCurso(l7);
        
        Date fInicio8 =  Date.valueOf("2019-03-10");
        Date fFin8 =  Date.valueOf("2019-05-10");
        Date fAlta8 =  Date.valueOf("2019-02-15");
        List <String> l8 = new ArrayList();
        l8.add("heisenberg");
        l8.add("benkenobi");
        AltaEdicionCurso aec8 = new AltaEdicionCurso("Taller de robotica educativa - 2019", "Taller de robotica educativa",fInicio8,fFin8,10,fAlta8);
        ret += aec8.createEdicionCurso(l8);

        Date fInicio9 =  Date.valueOf("2019-09-10");
        Date fFin9 =  Date.valueOf("2019-11-08");
        Date fAlta9 =  Date.valueOf("2019-08-15");
        List <String> l9 = new ArrayList();
        l9.add("benkenobi");
        l9.add("waston");
        AltaEdicionCurso aec9 = new AltaEdicionCurso("Taller de robotica educativa - 2019-2", "Taller de robotica educativa",fInicio9,fFin9,20,fAlta9);
        ret += aec9.createEdicionCurso(l9);

        Date fInicio10 =  Date.valueOf("2019-07-29");
        Date fFin10 =  Date.valueOf("2019-10-07");
        Date fAlta10 =  Date.valueOf("2019-07-10");
        List <String> l10 = new ArrayList();
        l10.add("waston");
        AltaEdicionCurso aec10 = new AltaEdicionCurso("Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela - 2019", "Participacion en investigacion sobre el empleo del juego Komikan como recurso didáctico en la Escuela",fInicio10,fFin10,5,fAlta10);
        ret += aec10.createEdicionCurso(l10);
        
        Date fInicio11 =  Date.valueOf("2019-09-15");
        Date fFin11 =  Date.valueOf("2019-12-15");
        Date fAlta11 =  Date.valueOf("2019-06-02");
        AltaEdicionCurso aec11 = new AltaEdicionCurso("Herramientas de apoyo a la ensenianza de ingles. Instalacion y evaluacion - 2019","Herramientas de apoyo a la ensenianza de ingles. Instalacion y evaluacion",fInicio11,fFin11,5,fAlta11);
        List<String> l11 = new ArrayList();
        l11.add("heisenberg");
        ret += aec11.createEdicionCurso(l11);
        
        Date fInicio12 =  Date.valueOf("2019-08-12");
        Date fFin12 =  Date.valueOf("2019-12-5");
        Date fAlta12 =  Date.valueOf("2019-07-02");
        AltaEdicionCurso aec12 = new AltaEdicionCurso("MicroBit - 2019", "MicroBit",fInicio12,fFin12,30,fAlta12);
        List<String> l12 = new ArrayList();
        l12.add("house");
        ret += aec12.createEdicionCurso(l12);


        Date fInicio13 =  Date.valueOf("2019-03-10");
        Date fFin13 =  Date.valueOf("2019-03-30");
        Date fAlta13 =  Date.valueOf("2019-03-02");
        AltaEdicionCurso aec13 = new AltaEdicionCurso("Talleres plenarios - 2019", "Talleres plenarios ",fInicio13,fFin13,0,fAlta13);
        List<String> l13 = new ArrayList();
        l13.add("timmy");
        l13.add("danny");
        ret += aec13.createEdicionCurso(l13);


        Date fInicio14 =  Date.valueOf("2019-09-10");
        Date fFin14 =  Date.valueOf("2019-10-20");
        Date fAlta14 =  Date.valueOf("2019-07-12");
        AltaEdicionCurso aec14 = new AltaEdicionCurso("Seminarios de Resolucion deProblemas - 2019", "Seminarios de Resolucion de Problemas",fInicio14,fFin14,0,fAlta14);
        List<String> l14 = new ArrayList();
        l14.add("timmy");
        ret += aec14.createEdicionCurso(l14);

        

        return ret;
    }

    public String cargarInscripciones() {
        String ret = "";

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
        InscripcionAEdicion ie1 = new InscripcionAEdicion("eleven11", i1, e1);
        ret += ie1.inscripcion();

        Date i2 = Date.valueOf("2010-02-25");
        InscripcionAEdicion ie2 = new InscripcionAEdicion("chechi", i2, e1);
        ret += ie2.inscripcion();

        Date i3 = Date.valueOf("2012-07-12");
        InscripcionAEdicion ie3 = new InscripcionAEdicion("costas", i3, e2);
        ret += ie3.inscripcion();

        Date i4 = Date.valueOf("2012-07-15");
        InscripcionAEdicion ie4 = new InscripcionAEdicion("roro", i4, e2);
        ret += ie4.inscripcion();

        Date i5 = Date.valueOf("2012-07-30");
        InscripcionAEdicion ie5 = new InscripcionAEdicion("weiss", i5, e2);
        ret += ie5.inscripcion();

        Date i6 = Date.valueOf("2018-03-10");
        InscripcionAEdicion ie6 = new InscripcionAEdicion("roro", i6, e3);
        ret += ie6.inscripcion();

        Date i7 = Date.valueOf("2018-03-15");
        InscripcionAEdicion ie7 = new InscripcionAEdicion("jeffw", i7, e3);
        ret += ie7.inscripcion();

        Date i8 = Date.valueOf("2017-07-25");
        InscripcionAEdicion ie8 = new InscripcionAEdicion("chechi", i8, e4);
        ret += ie8.inscripcion();

        Date i9 = Date.valueOf("2017-07-28");
        InscripcionAEdicion ie9 = new InscripcionAEdicion("eleven11", i9, e4);
        ret += ie9.inscripcion();

        Date i10 = Date.valueOf("2017-08-02");
        InscripcionAEdicion ie10 = new InscripcionAEdicion("roro", i10, e4);
        ret += ie10.inscripcion();

        Date i11 = Date.valueOf("2017-08-10");
        InscripcionAEdicion ie11 = new InscripcionAEdicion("costas", i11, e4);
        ret += ie11.inscripcion();

        Date i12 = Date.valueOf("2017-08-15");
        InscripcionAEdicion ie12 = new InscripcionAEdicion("jeffw", i12, e4);
        ret += ie12.inscripcion();

        Date i13 = Date.valueOf("2018-07-18");
        InscripcionAEdicion ie13 = new InscripcionAEdicion("costas", i13, e5);
        ret += ie13.inscripcion();

        Date i14 = Date.valueOf("2018-07-20");
        InscripcionAEdicion ie14 = new InscripcionAEdicion("chechi", i14, e5);
        ret += ie14.inscripcion();

        Date i15 = Date.valueOf("2018-07-29");
        InscripcionAEdicion ie15 = new InscripcionAEdicion("eleven11", i15, e5);
        ret += ie15.inscripcion();

        Date i16 = Date.valueOf("2018-08-05");
        InscripcionAEdicion ie16 = new InscripcionAEdicion("weiss", i16, e5);
        ret += ie16.inscripcion();

        Date i17 = Date.valueOf("2019-02-23");
        InscripcionAEdicion ie17 = new InscripcionAEdicion("roro", i17, e6);
        ret += ie17.inscripcion();

        Date i18 = Date.valueOf("2019-02-25");
        InscripcionAEdicion ie18 = new InscripcionAEdicion("weiss", i18, e6);
        ret += ie18.inscripcion();

        Date i19 = Date.valueOf("2019-02-28");
        InscripcionAEdicion ie19 = new InscripcionAEdicion("chechi", i19, e6);
        ret += ie19.inscripcion();

        Date i20 = Date.valueOf("2019-03-03");
        InscripcionAEdicion ie20 = new InscripcionAEdicion("eleven11", i20, e6);
        ret += ie20.inscripcion();

        Date i21 = Date.valueOf("2017-02-18");
        InscripcionAEdicion ie21 = new InscripcionAEdicion("weiss", i21, e7);
        ret += ie21.inscripcion();

        Date i22 = Date.valueOf("2017-02-20");
        InscripcionAEdicion ie22 = new InscripcionAEdicion("roro", i22, e7);
        ret += ie22.inscripcion();

        Date i23 = Date.valueOf("2017-03-03");
        InscripcionAEdicion ie23 = new InscripcionAEdicion("eleven11", i23, e7);
        ret += ie23.inscripcion();

        Date i24 = Date.valueOf("2017-03-05");
        InscripcionAEdicion ie24 = new InscripcionAEdicion("chechi", i24, e7);
        ret += ie24.inscripcion();

        Date i25 = Date.valueOf("2019-02-18");
        InscripcionAEdicion ie25 = new InscripcionAEdicion("jeffw", i25, e8);
        ret += ie25.inscripcion();

        Date i26 = Date.valueOf("2019-02-22");
        InscripcionAEdicion ie26 = new InscripcionAEdicion("costas", i26, e8);
        ret += ie26.inscripcion();

        Date i27 = Date.valueOf("2019-08-18");
        InscripcionAEdicion ie27 = new InscripcionAEdicion("weiss", i27, e9);
        ret += ie27.inscripcion();

        Date i28 = Date.valueOf("2019-08-22");
        InscripcionAEdicion ie28 = new InscripcionAEdicion("chechi", i28, e9);
        ret += ie28.inscripcion();

        Date i29 = Date.valueOf("2019-09-03");
        InscripcionAEdicion ie29 = new InscripcionAEdicion("roro", i29, e9);
        ret += ie29.inscripcion();

        Date i30 = Date.valueOf("2019-07-13");
        InscripcionAEdicion ie30 = new InscripcionAEdicion("chechi", i30, e10);
        ret += ie30.inscripcion();

        Date i31 = Date.valueOf("2019-07-20");
        InscripcionAEdicion ie31 = new InscripcionAEdicion("weiss", i31, e10);
        ret += ie31.inscripcion();

        Date i32 = Date.valueOf("2019-07-22");
        InscripcionAEdicion ie32 = new InscripcionAEdicion("roro", i32, e10);
        ret += ie32.inscripcion();

        Date i33 = Date.valueOf("2019-06-04");
        InscripcionAEdicion ie33 = new InscripcionAEdicion("weiss", i33, e11);
        ret += ie33.inscripcion();

        Date i34 = Date.valueOf("2019-07-18");
        InscripcionAEdicion ie34 = new InscripcionAEdicion("eleven11", i34, e11);
        ret += ie34.inscripcion();

        Date i35 = Date.valueOf("2019-08-20");
        InscripcionAEdicion ie35 = new InscripcionAEdicion("jeffw", i35, e11);
        ret += ie35.inscripcion();

        Date i36 = Date.valueOf("2019-07-12");
        InscripcionAEdicion ie36 = new InscripcionAEdicion("chechi", i36, e12);
        ret += ie36.inscripcion();

        Date i37 = Date.valueOf("2019-07-14");
        InscripcionAEdicion ie37 = new InscripcionAEdicion("roro", i37, e12);
        ret += ie37.inscripcion();

        Date i38 = Date.valueOf("2019-07-25");
        InscripcionAEdicion ie38 = new InscripcionAEdicion("eleven11", i38, e12);
        ret += ie38.inscripcion();

        Date i39 = Date.valueOf("2019-08-05");
        InscripcionAEdicion ie39 = new InscripcionAEdicion("jeffw", i39, e12);
        ret += ie39.inscripcion();

        Date i40 = Date.valueOf("2019-03-05");
        InscripcionAEdicion ie40 = new InscripcionAEdicion("costas", i40, e13);
        ret += ie40.inscripcion();

        Date i41 = Date.valueOf("2019-03-04");
        InscripcionAEdicion ie41 = new InscripcionAEdicion("weiss", i41, e13);
        ret += ie41.inscripcion();

        Date i42 = Date.valueOf("2019-03-07");
        InscripcionAEdicion ie42 = new InscripcionAEdicion("roro", i42, e13);
        ret += ie42.inscripcion();

        Date i43 = Date.valueOf("2019-07-15");
        InscripcionAEdicion ie43 = new InscripcionAEdicion("weiss", i43, e14);
        ret += ie43.inscripcion();

        Date i44 = Date.valueOf("2019-07-20");
        InscripcionAEdicion ie44 = new InscripcionAEdicion("costas", i44, e14);
        ret += ie44.inscripcion();

        Date i45 = Date.valueOf("2019-08-06");
        InscripcionAEdicion ie45 = new InscripcionAEdicion("roro", i45, e14);
        ret += ie45.inscripcion();

        Date i46 = Date.valueOf("2019-08-30");
        InscripcionAEdicion ie46 = new InscripcionAEdicion("chechi", i46, e14);
        ret += ie46.inscripcion();

        return ret;
    }
}
