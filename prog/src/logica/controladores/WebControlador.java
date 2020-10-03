package logica.controladores;
import API.*;
import logica.usuarios.*;

public class WebControlador implements IWeb {
	
	private static WebControlador controller = null;

    public static WebControlador getController() {
            if (controller == null) {
                    controller = new WebControlador();
            }
            return controller;
    }

    private WebControlador() {
    }
    
    public boolean validateUser(String nick, String pass) {
    	if(new ExisteUsuario().existeNickname(nick)) {
    		if(new ObtenerUsuario().isEstudiante(nick)) {
    			if(new ObtenerUsuario().getDTEstudianteByNickname(nick).passw.equals(pass)) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    		else {
    			if(new ObtenerUsuario().getDTDocenteByNickname(nick).passw.equals(pass)) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    	}
    	else {
    		return false;
    	}
    }
}
