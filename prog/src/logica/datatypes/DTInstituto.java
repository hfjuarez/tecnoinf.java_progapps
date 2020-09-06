package logica.datatypes;

import java.lang.String;
import logica.entidades.Instituto;

public class DTInstituto {
	public String nombreInstituto;

	public DTInstituto(Instituto instituto) {
		super();
		nombreInstituto = instituto.getNombreInstituto();
	}

	@Override
	public String toString() {
		return "DTInstituto [nombreInstituto=" + nombreInstituto + "]";
	}
}
