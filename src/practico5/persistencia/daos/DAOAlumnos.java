package practico5.persistencia.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import practico5.Alumno;
import practico5.logica.excepciones.PersistenciaException;
import practico5.logica.valueObjects.VOAlumno;
import practico5.logica.valueObjects.VOAlumnoProm;
import practico5.persistencia.consultas.Consultas;

public class DAOAlumnos {
	// atributos para acceso BD

	public DAOAlumnos() {

	}

	public boolean member(int cedA) {
		return false;
	}

	String url, usr, pwd;

	/*
	 * public void insert (Alumno alu) { try { Connection con =
	 * DriverManager.getConnection(url,usr,pwd); Consultas consultas = new Consultas
	 * (); String insert = consultas.insertAlumno (); PreparedStatement pstmt2 =
	 * con.prepareStatement (insert); pstmt2.setInt (1, emp.getCedula());
	 * pstmt2.setString (2, emp.getNombre()); pstmt2.setDouble (3, emp.getSueldo());
	 * pstmt2.executeUpdate (); pstmt2.close (); con.close (); } catch (SQLException
	 * e) throw new PersistenciaException(); }
	 */

	public void insert(Alumno alu) throws PersistenciaException {
		try {
			Connection con = DriverManager.getConnection(url, usr, pwd);
			Consultas consultas = new Consultas();

			String insert = consultas.insertAlumno();

			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, alu.getCedula());
			pstmt.setString(2, alu.getNombre());
			pstmt.setString(3, alu.getApellido());

			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			throw new PersistenciaException();
		}
	}

	public Alumno find(int cedA) {
		return null;
	}

	public boolean esVacio() {
		return false;
	}

	public List<VOAlumno> listarAlumnos() {
		return null;
	}

	public VOAlumnoProm alumnoMayorPromedio() {
		return null;
	}

	public int contarAlumnos(String act, int nota) {
		return 0;
	}

}
