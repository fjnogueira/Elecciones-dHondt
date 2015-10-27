package elecciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private Connection objConnection;
    
    public Conexion(){
        objConnection = null;
    }
    
    public void abrirConexion(String usuario, String contraseña) throws SQLException, Exception{
        if (objConnection==null){
            String BDSQL = "jdbc:sqlserver://;database=Dhont;user=" + usuario + ";password=" + contraseña;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            objConnection = DriverManager.getConnection(BDSQL);
            System.out.println("Conexión a la base de datos establecida.");}
        else System.out.println("La conexión con la base de datos ya ha sido establecida.");
    }
    
    public void cerrarConexion() throws SQLException, Exception{
        if (objConnection!=null){
            objConnection.close();
            System.out.println("La conexión con la base de datos ha sido cerrada.");
        }
        else System.out.println("La conexión con la base de datos ya estaba cerrada.");
    }

    public Connection getObjConnection() {
        return objConnection;
    }
}
