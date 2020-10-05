package logica.controladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    
    public void setImagen(String name, File imagen, String folder, File dir) throws IOException {
        
        Path ppp = Paths.get(imagen.getAbsolutePath());
        String extension = "";
        String fileName = imagen.toString();
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }
        Path copiedFile = Files.copy(ppp, Paths.get(dir.getAbsolutePath()  +"\\imgs\\" + folder + "\\" + name + "." + extension),
                StandardCopyOption.REPLACE_EXISTING);
    }

    public File getImagen(String name, String folder, File dirr)  {
        File dir = new File(dirr.getAbsolutePath() +"\\imgs\\" + folder);
        System.out.println(dir.getAbsolutePath());
        dir.mkdir();
        if(dir.isDirectory()) {
        	for (File fileEntry : dir.listFiles()) {
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
        }
        else {
        	System.out.println("no es dirrrrr");
        }
        
        return null;
    }

}
