package API;

import logica.controladores.LControlador;
import logica.controladores.WebControlador;

public class BizcochoEnARG {

    public ILogica getInterface() {
        LControlador c = LControlador.getController();
        return c;
    }
    
    public IWeb getWebInterface() {
        WebControlador c = WebControlador.getController();
        return c;
    }
}
