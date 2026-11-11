package practico5.persistencia.consultas;

public class Consultas {

	public String insertAlumno() {
		return """
				insert into alumnos (cedula, nombre, apellido)
				values (?, ?, ?)
				""";
	}

	public String existeAlumno() {
		return """
				select 1
				from alumnos
				where cedula = ?
				""";
	}

	// falta revisar como obtener ultimo numero de registros para el alumno
	public String registrarNota() {
		return """
				insert into registros (numero, cedAlu, actividad, nota)
				values (?, ?, ?, ?)
				""";
	}

	public String listarAlumnos() {
		return """
				select cedula, nombre, apellido
				from alumnos
				order by cedula
				""";
	}

	public String obtenerRegistro() {
		return """
				select numero, cedAlu, actividad, nota 
				from registros 
				where cedAlu = ? 
				and numero = ?
				""";
	}

	public String listarRegistros() {
		return """
				select numero, cedAlu, actividad, nota 
				from registros 
				where cedAlu = ? 
				order by numero
				""";
	}

//ver si hace falta una consulta especifica
	public String promedioNotas() {
		return """
				select avg(nota) as promedio 
				from registros
				where cedAlu = ?
				""";
	}

//ver si hace falta una consulta especifica
	public String alumnoMayorPromedio() {
		return """
				select a.cedula, a.nombre, a.apellido, avg(r.nota) as promedio
				from alumnos a
				join registros r on a.cedula = r.cedalu
				group by a.cedula, a.nombre, a.apellido
				order by promedio desc
				limit 1
				""";
	}

	public String contarAlumnos() {
		return """
				select count(*) from alumssnos alu
				inner join registros reg
					on alu.cedula = reg.cedAlu
				where reg.actividad = ?
				and reg.nota = ?
				group by alu.cedula
				""";
	}

	public String actividadMasCursada() {
		return """
				select r.actividad, count(*) as cantidad
				from registros r
				where r.cedAlu = ?
				group by r.actividad
				order by cantidad desc
				limit 1
				""";
	}
}
