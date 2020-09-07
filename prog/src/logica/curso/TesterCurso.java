package logica.curso;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class TesterCurso {

    public void testAC1() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("curso1", "esta es la descripcion del curso", 2, 24, 10,
                "https://hoooasldfaslkjdfkjaskdl.com", nacDate);
        List<String> l = new ArrayList();
        String es = ac.createCurso("Fing", l);
        System.out.println(es);
    }

    public void testACerror() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("curso1", "esta es la descripcion del curso", 2, 24, 10,
                "https://hoooasldfaslkjdfkjaskdl.com", nacDate);
        List<String> l = new ArrayList();
        String es = ac.createCurso("Fing", l);
        System.out.println(es);
    }

    public void testAC2() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("curso2", "esta es el curso", 222, 23444, 234, "https://d.com", nacDate);
        List<String> l = new ArrayList();
        l.add("curso1");
        String es = ac.createCurso("Fing", l);
        System.out.println(es);
    }

    public void testAC3() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("curso1w", "esta es la descripcion del curso", 6, 220, 452,
                "https://hoooasldfaslkjdfkjaskdl.com", nacDate);
        List<String> l = new ArrayList();
        l.add("curso2");
        l.add("curso1");

        String es = ac.createCurso("Fing", l);
        System.out.println(es);
    }

    private void listDTs() {
        ListaCursos lu = new ListaCursos();
        System.out.println(lu.getDataTypeList());
        System.out.println("\n\n\n\n");

    }

    public static void main(String[] args) {
        TesterCurso tc = new TesterCurso();
        // tc.testAC1();
        // tc.testACerror();
        // tc.testAC2();
        // tc.testAC3();
        tc.listDTs();
    }
}
