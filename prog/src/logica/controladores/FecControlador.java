package logica.controladores;

import java.util.Calendar;
import java.sql.Date;

public class FecControlador {
    private static FecControlador controller = null;

    public static FecControlador getController() {
        if (controller == null) {
            controller = new FecControlador();
        }
        return controller;
    }

    // true si la fecha es valida
    public boolean fecVal(String dia, String mes, String anio) {
        Boolean ret = false;
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DATE);
        int mont = c.get(Calendar.MONTH);
        int yiar = c.get(Calendar.YEAR);
        int Ddado = Integer.parseInt(dia);
        int Mdado = Integer.parseInt(mes);
        int Adado = Integer.parseInt(anio);
        if ((Adado == yiar) && (Mdado <= mont) && (Ddado <= day)) {
            return true;
        }
        if ((Adado < yiar) && (Mdado <= 12) && (Ddado <= 31)) {
            return true;
        }
        return ret;
    }

    public Date freeronaldinho(String dia, String mes, String anio) {
        if (fecVal(dia, mes, anio)) {
            String datinho = anio + "-" + mes + "-" + dia;
            Date retorninho = Date.valueOf(datinho);
            return retorninho;
        }
    }

}
