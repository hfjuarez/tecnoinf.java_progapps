package logica.formaciones;

import API.datatypes.*;
import java.util.*;
import logica.edicioncursos.*;
import logica.entidades.Inscripcion_Edicion;
import logica.inscripciones.InscripcionAEdicion;
import logica.inscripciones.ListaInscripciones;

public class obtenerCertificado {

    public boolean aproboCurso(String nombreCurso, String nickname) {
        boolean ret = false;
        List<DTEdicionCurso> listita = new ListaEdicionCurso().getDataTypeListByCurso(nombreCurso);
        for (DTEdicionCurso dtEdicionCurso : listita) {
            List<DTInscripcion_Edicion> inscriptos = new ListaInscripciones()
                    .getDTlistPorEdicion(dtEdicionCurso.nombreEdicion);
            for (DTInscripcion_Edicion ins : inscriptos) {
                if (ins.edicionCurso.cerrado) {
                    if (ins.estudiante.nickname.equals(nickname) && ins.nota >= 6) {
                        ret = true;
                        return ret;
                    }
                }
            }
        }
        return ret;
    }

    public boolean aproboFormacion(String nFormacion, String nickname) {

        ObtenerFormacion obt = new ObtenerFormacion();
        DTFormacion form = obt.getDTFormacion(nFormacion);
        List<DTCurso> Cursos = form.cursos;
        for (DTCurso cursito : Cursos) {
            if (!aproboCurso(cursito.nombreCurso, nickname)) {
                return false;
            }
        }
        return true;
    }

}
