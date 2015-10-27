package elecciones;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Consulta {
    
    private Statement objStatement;
    private ResultSet resultado;
    
    public Consulta(){
        objStatement = null;
        resultado = null;
    }
    
    private void cerrarConsulta() throws SQLException {
        if (objStatement!=null) objStatement.close();
        if (resultado!=null) resultado.close();
    }
    
    public ArrayList extraerResultados(Connection objConnection) throws SQLException{
        ArrayList <Integer> ALVotosTotales = new ArrayList();
        String sentencia = "select sum(votos) from Votos group by partido order by partido asc;";
        objStatement = objConnection.createStatement();
        resultado = objStatement.executeQuery(sentencia);
        
        while (resultado.next()){
            ALVotosTotales.add(resultado.getInt(1));
        }
        
        cerrarConsulta();
        return ALVotosTotales;
    }

    public ArrayList extraerPartidos(Connection objConnection, int campo) throws SQLException{
	ArrayList <String> ALNombrePartidos = new ArrayList();
	String sentencia="";
	if (campo==1) sentencia = "select sigla from Partido order by sigla asc;";
	else if (campo==2) sentencia = "select nombre from Partido order by sigla asc;";
	objStatement = objConnection.createStatement();
	resultado = objStatement.executeQuery(sentencia);

	while (resultado.next()){
	    ALNombrePartidos.add(resultado.getString(1));
	}

	cerrarConsulta();
	return ALNombrePartidos;
    }
}
