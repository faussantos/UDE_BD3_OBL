package practico5.persistencia.consultas;

public class Consultas {
	public String insertAlumno() {
		return "insert into alumnos (cedula, nombre, apellido) values (?, ?, ?)";
	}
	
	
}
