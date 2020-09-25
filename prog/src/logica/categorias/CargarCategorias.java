package logica.categorias;

public class CargarCategorias {
	
	public String cargarCat() {
		AltaCategoria ac = new AltaCategoria();
		
		String ret="";
		ret+=ac.create("Social");
		ret+=ac.create("Industrial");
		ret+=ac.create("Educativo");
		ret+=ac.create("Interdisciplinario");
		return ret;
	}



}
