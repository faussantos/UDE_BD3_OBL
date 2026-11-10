package practico5;

import java.util.List;

import practico5.logica.valueObjects.VOActividad;
import practico5.logica.valueObjects.VORegistro;
import practico5.logica.valueObjects.VORegistroListado;
import practico5.persistencia.daos.DAORegistros;

public class Alumno {

	private int cedula;
	private String nombre;
	private String apellido;
	private DAORegistros secuencia;

	public Alumno(int ced, String nom, String ape) {
		this.cedula = ced;
		this.nombre = nom;
		this.apellido = ape;
	}

	public int getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int cantidadRegistros() {
		return 0;
	}

	public void agregarRegistro(Registro reg) {

	}

	public VORegistro obtenerRegistro(int numR) {
		return null;
	}

	public List<VORegistroListado> listarRegistros() {
		return null;
	}

	public double promedioNotas() {
		return 0;
	}

	public VOActividad actividadMasCursada() {
		return null;
	}
}
