package logica.controladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ControladorImagen {

    private static ControladorImagen controller = null;

    public static ControladorImagen getController() {
        if (controller == null) {
            controller = new ControladorImagen();
        }
        return controller;
    }

    private ControladorImagen() {
    }

    public void setImagen(String name, File imagen, String folder) throws IOException {
        File dir = new File("./imagenes/" + folder);
        if (dir.mkdir()) {
            System.out.println("Se creo el directorio: " + "'./imagenes_progapps_g01'");
        }
        Path ppp = Paths.get(imagen.getAbsolutePath());
        String extension = "";
        String fileName = imagen.toString();
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }
        Path copiedFile = Files.copy(ppp, Paths.get("./img/" + folder + "/" + name + "." + extension),
                StandardCopyOption.REPLACE_EXISTING);
    }

    public File getImagen(String name, String folder) {
        File dir = new File("./imagenes/" + folder);
        for (final File fileEntry : dir.listFiles()) {
            String currName = fileEntry.getName();
            String onlyName = "";

            int index = currName.lastIndexOf('.');
            if (index > 0) {
                onlyName = currName.substring(0, index);
            }
            if (name.equals(onlyName)) {
                return fileEntry;
            }
        }
        return null;
    }

}
