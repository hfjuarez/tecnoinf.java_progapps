package logica.instituto;

public class CargarInstituto {

    public String cargarInstitutos() {
        AltaInstituto ai = new AltaInstituto();
        String ret = "";

        ret += ai.create("INCO");

        ret += ai.create("IMERL");

        ret += ai.create("Fisica");

        ret += ai.create("IMPII");

        ret += ai.create("Electrica");

        ret += ai.create("DISI");

        return ret;

    }

}
