package logica.usuarios;

import java.sql.Date;

public class CargarUsuarios {

    public String cargarUsuarios() {
        // Estudiantes
        String ret = "";
        Date datee1 = Date.valueOf("1971-12-31");
        Date datee2 = Date.valueOf("1983-11-15");
        Date datee3 = Date.valueOf("1975-08-02");
        Date datee4 = Date.valueOf("1987-09-12");
        Date datee5 = Date.valueOf("1964-11-27");
        Date datee6 = Date.valueOf("1978-12-23");
        AltaUsuario aue1 = new AltaUsuario("eleven11", "Eleven", "", "eleven11@gmail.com", datee1);
        ret += aue1.createEstudiante();
        AltaUsuario aue2 = new AltaUsuario("costas", "Gerardo", "Costas", "gcostas@gmail.com", datee2);
        ret += aue2.createEstudiante();
        AltaUsuario aue3 = new AltaUsuario("roro", "Rodrigo", "Cotelo", "rcotelo@yahoo.com", datee3);
        ret += aue3.createEstudiante();
        AltaUsuario aue4 = new AltaUsuario("chechi", "Cecilia", "Garrido", "cgarrido@hotmail.com", datee4);
        ret += aue4.createEstudiante();
        AltaUsuario aue5 = new AltaUsuario("jeffw", "Jeff", "Williams", "jwilliams@gmail.com", datee5);
        ret += aue5.createEstudiante();
        AltaUsuario aue6 = new AltaUsuario("weiss", "Adrian", "Weiss", "aweiss@hotmail.com", datee6);
        ret += aue6.createEstudiante();

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
        AltaUsuario aud1 = new AltaUsuario("heisenberg", "Walter", "White", "heisenberg@gmail.com", date1);
        ret += aud1.createDocente("INCO");
        AltaUsuario aud2 = new AltaUsuario("benkenobi", "Obi-Wan", "Kenobi", "benKenobi@gmail.com", date2);
        ret += aud2.createDocente("INCO");
        AltaUsuario aud3 = new AltaUsuario("waston", "Emma", "Watson", "e.waton@gmail.com", date3);
        ret += aud3.createDocente("INCO");
        AltaUsuario aud4 = new AltaUsuario("house", "Gregory", "House", "greghouse@gmail.com", date4);
        ret += aud4.createDocente("Electrica");
        AltaUsuario aud5 = new AltaUsuario("timmy ", "Tim", "Cook", "tim.cook@apple.com", date5);
        ret += aud5.createDocente("IMERL");
        AltaUsuario aud6 = new AltaUsuario("danny", "Daniel", "Riccio", "dan.riccio@gmail.com", date6);
        ret += aud6.createDocente("IMERL");
        AltaUsuario aud7 = new AltaUsuario("phils", "Philip", "Schiller", "schiller@gmail.com", date7);
        ret += aud7.createDocente("IMPII");
        AltaUsuario aud8 = new AltaUsuario("bruces", "Bruce", "Sewell", "sewell@gmail.com", date8);
        ret += aud8.createDocente("DISI");
        AltaUsuario aud9 = new AltaUsuario("adri", "Adriana", "Garcia", "agarcia@gmail.com", date9);
        ret += aud9.createDocente("DISI");
        return ret;
    }
}
