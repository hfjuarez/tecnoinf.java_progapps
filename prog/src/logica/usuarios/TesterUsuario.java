package logica.usuarios;

import java.sql.Date;

public class TesterUsuario {
    private void testAUE() {
        String fecha = "2015-04-23";
        Date nacDate = Date.valueOf(fecha);
        // AltaUsuario au1 = new AltaUsuario("nick1", "nombre", "apellido", "mail",
        // nacDate);
        AltaUsuario aue = new AltaUsuario("herfj", "hernan", "fabrica", "mail@mail.com", nacDate);

        String es = aue.createEstudiante();

        System.out.println(es);
    }

    private void testAUD() {
        String fecha = "2015-04-23";
        Date nacDate = Date.valueOf(fecha);
        // AltaUsuario au1 = new AltaUsuario("nick1", "nombre", "apellido", "mail",
        // nacDate);
        AltaUsuario aud = new AltaUsuario("cralo", "carlos", "calito", "arlomail4@mail.com", nacDate);

        String es = aud.createDocente("FMED");
        System.out.println(es);
    }

    private void testAUDerror() {
        String fecha = "2015-04-23";
        Date nacDate = Date.valueOf(fecha);
        // AltaUsuario au1 = new AltaUsuario("nick1", "nombre", "apellido", "mail",
        // nacDate);
        AltaUsuario aud = new AltaUsuario("herfj", "hernan", "fabrica", "mail@mail.com", nacDate);

        String es = aud.createDocente("Fing");
        System.out.println(es);
    }

    private void testMUE() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        // AltaUsuario au1 = new AltaUsuario("nick1", "nombre", "apellido", "mail",
        // nacDate);
        ModificarUsuario aud = new ModificarUsuario("herfj", "tomi cambisda asd fe", "fabricaasd fsad f cambio",
                nacDate);
        String es = aud.modificarEstudiante();

        System.out.println(es);
    }

    private void testMUD() {
        String fecha = "2019-04-23";
        Date nacDate = Date.valueOf(fecha);
        // AltaUsuario au1 = new AltaUsuario("nick1", "nombre", "apellido", "mail",
        // nacDate);
        ModificarUsuario aud = new ModificarUsuario("herfj4", "jacocomoomo", "fabrica jacmomomo", nacDate);
        String es = aud.modificarDocente();

        System.out.println(es);
    }

    private void listDTs() {
        ListaUsuarios lu = new ListaUsuarios();
        System.out.println(lu.getDataTypeListDocente());
        System.out.println("\n\n\n\n");
        System.out.println(lu.getDataTypeListEstudiante());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TesterUsuario tu = new TesterUsuario();
        // tu.testAUE();
        // tu.testAUDerror();
         tu.testAUD();
        // tu.testMUE();
        // tu.testMUD();
        tu.listDTs();

    }

}