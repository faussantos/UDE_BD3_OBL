package practico4.ej4.logicaPersistencia.poolConexiones;

public interface IPoolConexiones {
	public IConexion obtenerConexion (boolean modifica);
	
	public void liberarConexion (IConexion con, boolean ok);
}
