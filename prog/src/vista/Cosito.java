package vista;

import API.BizcochoEnARG;
import API.IWeb;

public class Cosito {

	
	public void main(String[] arg)
	{
		IWeb webb = new BizcochoEnARG().getWebInterface();
		System.out.println(webb.listaInstitutos());
	}
}
