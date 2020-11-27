import API.BizcochoEnARG;
import API.IWebArrays;
import API.datatypes.DTInstituto;

public class TestArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IWebArrays w = new BizcochoEnARG().getWebArraysInterface();
		String[] i = w.listaNicknames();
		for (String is : i) {
			System.out.println(is);
		}
		
	}

}
