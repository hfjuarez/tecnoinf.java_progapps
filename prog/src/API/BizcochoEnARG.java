package API;

import logica.controladores.LControlador;

public class BizcochoEnARG {

    public ILogica getInterface() {
        LControlador c = LControlador.getController();
        return c;
    }
}
