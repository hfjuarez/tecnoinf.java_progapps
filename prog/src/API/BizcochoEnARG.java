package API;

public class BizcochoEnARG {

    public ILogica getInterface() {
        LControlador c = LControlador.getController();
        return c;
    }
}
