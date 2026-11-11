package practico4.ej4.logicaPersistencia.poolConexiones;

import java.sql.Connection;

public class Conexion implements IConexion {
	private Connection con;
	
	public Conexion(Connection connection) {
		con = connection;
	}
	
	public Connection getConnection () {
		return con;
	}
}
