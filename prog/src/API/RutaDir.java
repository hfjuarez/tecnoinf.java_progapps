package API;

import java.io.File;


public class RutaDir {
	private File dir;
	
	 private static RutaDir controller = null;

     public static RutaDir getController() {
             if (controller == null) {
                     controller = new RutaDir();
             }
             return controller;
     }

     private RutaDir() {
    	 dir= new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\progAppsWeb");
     }

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}
	
	
}
