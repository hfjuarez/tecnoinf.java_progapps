package logica.formacion;

import java.sql.Date;
import java.util.*;

public class CargarFormacion {
    public String cargarFormacion() {
        String ret = "";
        Calendar c = Calendar.getInstance();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));
        Date fecha = Date.valueOf(annio + "-" + mes + "-" + dia);

        Date fInicio1 = Date.valueOf("2019-05-01");
        Date fFin1 = Date.valueOf("2019-10-31");
        AltaFormacion f1 = new AltaFormacion("EFI Ingenieria Mecanica", "Programa mecanica", fInicio1, fFin1, fecha);
        ret += f1.createFormacion();

        AgregarCursoAFormacion af1 = new AgregarCursoAFormacion("EFI Ingenieria Mecanica");
        List<String> lf1 = new ArrayList();
        lf1.add("Dalavuelta");
        lf1.add("Extensionismo Industrial");
        lf1.add("Inclusion Energetica");
        ret += af1.agregarCursosAFor(lf1);

        Date fInicio2 = Date.valueOf("2019-07-15");
        Date fFin2 = Date.valueOf("2020-01-01");
        AltaFormacion f2 = new AltaFormacion("Formacion integral", "Programa varios institutos", fInicio2, fFin2,
                fecha);
        ret += f2.createFormacion();

        AgregarCursoAFormacion af2 = new AgregarCursoAFormacion("Formacion integral");
        List<String> lf2 = new ArrayList();
        lf2.add("Seminarios de Resolucion de Problemas");
        lf2.add("Extensionismo Industrial");
        lf2.add("Flor del Ceibo");
        lf2.add("Participacion en investigacion sobre el empleo del juego Komikan como recurso didactico en la Escuela");
        ret += af2.agregarCursosAFor(lf2);

        Date fInicio3 = Date.valueOf("2019-09-03");
        Date fFin3 = Date.valueOf("2019-11-18");
        AltaFormacion f3 = new AltaFormacion("EFI Robotica", "Programa robotica", fInicio3, fFin3, fecha);
        ret += f3.createFormacion();

        AgregarCursoAFormacion af3 = new AgregarCursoAFormacion("EFI Robotica");
        List<String> lf3 = new ArrayList();
        lf3.add("Taller de robótica educativa");
        lf3.add("MicroBit");
        ret += af3.agregarCursosAFor(lf3);

        return ret;
    }

}