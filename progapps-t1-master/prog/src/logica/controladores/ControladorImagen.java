package logica.controladores;

import java.io.*;
import javax.imageio.*;
import java.awt.Image.*;

import java.awt.image.BufferedImage;

public class ControladorImagen {

    public void GuardarImagen(String nickname, String ext, File imagen) {
        File dir = new File("./imagenes_progapps_g01");
        if (dir.mkdir()) {
            System.out.println("Directorio creado");
        } else {
            System.out.println("Error al crear directorio");
        }
        File f1 = new File(dir.getName() + "/" + nickname);
        // boolean b1 = imagen.renameTo(f1);
    }
}
