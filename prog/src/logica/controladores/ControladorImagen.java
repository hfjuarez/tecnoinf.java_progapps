package logica.controladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class ControladorImagen {

    public void GuardarImagen(String nickname, File imagen) throws IOException {
    	File dir = new File("./imagenes_progapps_g01");
    	if(dir.mkdir()) {
    		System.out.println("Se creo el directorio: "+ "'./imagenes_progapps_g01'");
    	}
        Path ppp = Paths.get(imagen.getAbsolutePath());
        String extension = "";
        String fileName = imagen.toString();
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }
        Path copiedFile = Files.copy(ppp, Paths.get("./imagenes_progapps_g01/" + nickname + "." + extension),
                StandardCopyOption.REPLACE_EXISTING);
    }

}
