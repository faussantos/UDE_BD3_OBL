package practico4.ej4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PoolConexiones implements IPoolConexiones {

	private String driver, url, user, password;
	private int nivelTransaccionalidad;
	private Conexion[] conexiones;
	private int tamanio, creadas, tope;

	public PoolConexiones() {
		tope = 0;
		creadas = 0;
		Properties p = new Properties();
		String nomArch = "config/config.properties";

		try {
			p.load(new FileInputStream(nomArch));
			String driver = p.getProperty("driver");
			Class.forName(driver);

			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			tamanio = Integer.parseInt(p.getProperty("tamanio"));
			nivelTransaccionalidad = Integer.parseInt(p.getProperty("nivelTransaccionalidad"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public synchronized IConexion obtenerConexion(boolean modifica) {

		//validar Tope mayor a 0
		//Creadas menor que tamanio
		Connection con = DriverManager.getConnection(url, user, password);

		//Si no quedan conexiones disponibles y no puedo crear mas wait

		return null;
	}

	public synchronized void liberarConexion(IConexion con, boolean ok) {

	}

}
