package API.datatypes;

import java.lang.String;
import logica.entidades.Categoria;

public class DTCategoria {
    public String nombreCategoria;

    public DTCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public DTCategoria(Categoria categoria) {
        super();
        nombreCategoria = categoria.getNombreCategoria();
    }

    @Override
    public String toString() {
        return "DTCategoria [nombreCategoria=" + nombreCategoria + "]";
    }
}