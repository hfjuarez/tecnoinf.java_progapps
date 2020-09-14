package logica.instituto;

public class TesterInstituto {

    private void listDTs() {
        ListaInstitutos lu = new ListaInstitutos();
        System.out.println(lu.getDataTypeList());
        System.out.println("\n\n\n\n");

    }
    
    public void testAI() {
    	AltaInstituto ai=new AltaInstituto();
    	ai.create("FMED");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TesterInstituto ti = new TesterInstituto();
        ti.testAI();
        ti.listDTs();
    }
}
