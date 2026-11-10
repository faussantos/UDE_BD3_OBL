package practico5.persistencia.daos;

import java.util.List;

import practico5.Registro;
import practico5.logica.valueObjects.VOActividad;
import practico5.logica.valueObjects.VORegistroListado;

public class DAORegistros {

	// atributos para acceso BD
	private int cedAlumno;

	public DAORegistros(int cedA) {
		this.cedAlumno = cedA;
	}

	public int largo() {

		return 0;
	}

	public void insback(Registro reg) {

	}

	public Registro kEsimo(int numR) {
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
