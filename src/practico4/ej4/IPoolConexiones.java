package practico4.ej4;

public interface IPoolConexiones {
	public IConexion obtenerConexion (boolean modifica);
	
	public void liberarConexion (IConexion con, boolean ok);
}
