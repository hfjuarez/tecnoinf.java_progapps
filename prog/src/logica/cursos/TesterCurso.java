package logica.cursos;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class TesterCurso {

    public void testAC1() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("curso133", "esta es la descripcion del curso", 2, 24, 10,
                "https://hoooasldfaslkjdfkjaskdl.com", nacDate);
        List<String> l = new ArrayList();
        String es = ac.createCurso("Fing", l);
        System.out.println(es);
    }

    public void testACerror() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("curso3331", "esta es la descripcion del curso", 2, 24, 10,
                "https://hoooasldfaslkjdfkjaskdl.com", nacDate);
        List<String> l = new ArrayList();
        String es = ac.createCurso("fiiiiinf", l);
        System.out.println(es);
    }

    public void testAC2() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("csdfurso2", "esta es el curso", 222, 23444, 234, "https://d.com", nacDate);
        List<String> l = new ArrayList();
        l.add("curso1");
        String es = ac.createCurso("FMED", l);
        System.out.println(es);
    }

    public void testAC3() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        AltaCurso ac = new AltaCurso("curso123w", "esta es la descripcion del curso", 6, 220, 452,
                "https://hoooasldfaslkjdfkjaskdl.com", nacDate);
        List<String> l = new ArrayList();
        l.add("curso2");
        l.add("curso1");

        String es = ac.createCurso("FMED", l);
        System.out.println(es);
    }

    private void listDTs() {
        ListaCursos lu = new ListaCursos();
        System.out.println(lu.getDataTypeList());
        System.out.println("\n\n\n\n");
        System.out.println(lu.getDataTypeListConInstituto("FMED"));

    }

    public static void main(String[] args) {
        TesterCurso tc = new TesterCurso();
        tc.testAC1();
        // tc.testACerror();
        tc.testAC2();
        tc.testAC3();
        // tc.listDTs();

    }
}
