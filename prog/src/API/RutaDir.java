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
    	 dir= new File("C:\\Users\\Admin\\eclipse-workspace\\progAppsWeb\\WebContent");
     }

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}
	
	
}
