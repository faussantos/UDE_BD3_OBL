package practico4.ej4.logicaPersistencia.poolConexiones;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
			driver = p.getProperty("driver");
			Class.forName(driver);

			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			tamanio = Integer.parseInt(p.getProperty("tamanio"));
			nivelTransaccionalidad = Integer.parseInt(p.getProperty("nivelTransaccionalidad"));
			conexiones = new Conexion[tamanio];

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public synchronized IConexion obtenerConexion(boolean modifica) {
		// validar Tope mayor a 0
		// Creadas menor que tamanio
		// Si no quedan conexiones disponibles y no puedo crear mas wait
		while (tope == 0 && creadas == tamanio) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Conexion con = null;
		if (tope > 0) {
			con = conexiones[tope - 1];
			tope--;
		} else if (creadas < tamanio) {
			try {
				Connection c = DriverManager.getConnection(url, user, password);
				con = new Conexion(c);
				creadas++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	@Override
	public synchronized void liberarConexion(IConexion con, boolean ok) {
		try {
			Connection c = ((Conexion) con).getConnection();
			if (ok) {
				c.commit();
			} else {
				c.rollback();
			}
			conexiones[tope] = (Conexion) con;
			tope = tope++;
			notifyAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
