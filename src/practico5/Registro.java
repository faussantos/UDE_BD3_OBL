package practico5;

public class Registro {
	private int numero;
	private int nota;
	private String actividad;

	public Registro(int num, int not, String act) {
		this.numero = num;
		this.nota = not;
		this.actividad = act;
	}

	public int getNumero() {
		return numero;
	}

	public int getNota() {
		return nota;
	}

	public String getActividad() {
		return actividad;
	}
}
