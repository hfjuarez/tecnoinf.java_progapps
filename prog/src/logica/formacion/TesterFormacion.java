package logica.formacion;

import java.sql.Date;

public class TesterFormacion {

    public void testAF() {
        String fecha = "2019-04-23";
        Date date = Date.valueOf(fecha);
        fecha = "2020-09-08";
        Date date1 = Date.valueOf(fecha);
        fecha = "2020-09-08";
        Date date2 = Date.valueOf(fecha);
        AltaFormacion a = new AltaFormacion("formacion 1", "desc formacion 1", date, date1, date2);
        String ret = a.createFormacion();
        System.out.println(ret);
    }

    public void testAFerror() {
        String fecha = "2019-04-23";
        Date date = Date.valueOf(fecha);
        fecha = "2020-09-08";
        Date date1 = Date.valueOf(fecha);
        fecha = "2020-09-08";
        Date date2 = Date.valueOf(fecha);
        AltaFormacion a = new AltaFormacion("formacion 1", "desc formacion 1", date, date1, date2);
        String ret = a.createFormacion();
        System.out.println(ret);
    }

    public void testAF2() {
        String fecha = "2019-04-23";
        Date date = Date.valueOf(fecha);
        fecha = "2020-09-08";
        Date date1 = Date.valueOf(fecha);
        fecha = "2020-09-08";
        Date date2 = Date.valueOf(fecha);
        AltaFormacion a = new AltaFormacion("formacion 2", "desc formacion 2", date, date1, date2);
        String ret = a.createFormacion();
        System.out.println(ret);
    }

    public void list() {
        ListaFormacion lu = new ListaFormacion();
        System.out.println(lu.getDataTypeList());
        System.out.println("\n\n\n\n");
    }

    public static void main(String[] args) {
        TesterFormacion t = new TesterFormacion();
        t.testAF();
        t.testAF2();
        t.testAFerror();
    }
}
