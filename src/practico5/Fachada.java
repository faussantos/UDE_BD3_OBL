package practico5;

import java.sql.Connection;
import java.util.List;

import practico5.logica.valueObjects.VOActividad;
import practico5.logica.valueObjects.VOAlumno;
import practico5.logica.valueObjects.VOAlumnoProm;
import practico5.logica.valueObjects.VORegistro;
import practico5.logica.valueObjects.VORegistroListado;

public class Fachada {
    private Connection conexion;

    public Fachada() {

    }

    public void nuevoAlumno(VOAlumno voA) {

    }

    public void registrarNota(int cedA, VORegistro voR) {

    }

    public List<VOAlumno> listarAlumnos() {
        return null;
    }

    public VORegistro obtenerRegistro(int cedA, int numR) {
        return null;
    }

    public List<VORegistroListado> listarRegistros(int cedA) {
        return null;
    }

    public double promedioNotas(int cedA) {
        return 0;
    }

    public VOAlumnoProm alumnoMayorPromedio() {
        return null;
    }

    public int contarAlumnos(String act, int nota) {
        return 0;
    }

    public VOActividad actividadMasCursada(int cedA) {
        return null;
    }
}
