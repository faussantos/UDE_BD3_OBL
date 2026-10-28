package practico4.ej2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
	public static void main(String args[]) {
		Properties p = new Properties();
		String nomArch = "config/config.properties";
		try {
			p.load(new FileInputStream(nomArch));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password );
			
			String createDB = "CREATE DATABASE Bedelia";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createDB);
			System.out.println("Base de datos creada");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			p.load(new FileInputStream(nomArch));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url") + "/Bedelia";
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			Class.forName(driver);
			
			Connection conDB = DriverManager.getConnection(url, user, password );
			
			Statement stmtDB = conDB.createStatement();
			String createAlumnos = "CREATE TABLE Alumnos (cedula INT Primary Key, nombre VARCHAR(45), apellido VARCHAR(45));";
			stmtDB.executeUpdate(createAlumnos);
			System.out.println("Tabla Alumnos creada");
			
			String createRegistros = "CREATE TABLE Registros(numero INT, cedAlu INT, actividad VARCHAR(45), nota INT, "
					+ "CONSTRAINT pk_registros PRIMARY KEY (numero, cedAlu),"
					+ " CONSTRAINT fk_alumnos_registros FOREIGN KEY (cedAlu) REFERENCES Alumnos (cedula));";
			stmtDB.executeUpdate(createRegistros);
			System.out.println("Tabla Registros creada");

			String insertAlumn = "INSERT INTO ALUMNOS (cedula, nombre, apellido) VALUES "
					+ "(12345678, 'Matilda', 'Wormwood'), "
					+ "(25554449, 'Charlie', 'Brown'), "
					+ "(39876542, 'Dora', 'Márquez'), "
					+ "(51112223, 'Daniel', 'Mitchell'), "
					+ "(66666666, 'Merlina', 'Addams');";

					try 
					{
						int cant = stmtDB.executeUpdate(insertAlumn);
						System.out.println("Cantidad de filas afectadas: " + cant);
					}
					catch(SQLException e) 
					{
						System.out.println(e.getMessage());
					}
			stmtDB.close();
			conDB.close();
			
			System.out.println("\nDatos de ejemplo ingresados.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
