package elecciones;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    
    private Conexion objConexion;
    private Gestion objGestion;
    
    public Menu(){
        objConexion = new Conexion();
        objGestion = new Gestion();
    }
    
    private boolean verificarUsuario(){
        Scanner leer = new Scanner(System.in);
        String usuario, contraseña;
        int contador = 0;
        do{
            usuario = LecturaDatos.leerString("Inserta el usuario: ");
            contraseña = LecturaDatos.leerString("Inserta la contraseña: ");
            try{
                objConexion.abrirConexion(usuario, contraseña);
                return true;
            }
            catch (SQLException e){
                System.out.println("Fallo a la hora de conectar. " + e.getMessage());
                contador++;
            }
            catch (Exception e2){
                System.out.println("Fallo a la hora de conectar. " + e2.getMessage());
                contador++;
            }
        } while (contador!=3);
        System.out.println("\n\nNo se ha podido establecer conexión con la base de datos.");
        return false;
    }
    
    public void iniciar(){
	System.out.println("Conectando con la base de datos...");
	if (verificarUsuario()){
	    int opcion=-1;	    
	    do{
		try{
		    mostrarMenu();
		    opcion = LecturaDatos.leerInt(0,1);
		    elegirMenu(opcion);
		}
		catch (SQLException e3){
		    System.out.println("Excepción encontrada: " + e3.getMessage());
		}
		catch (Exception e4){
		    System.out.println("Excepción encontrada: " + e4.getMessage());
		}

	    } while (opcion!=0);
	}
	else System.out.println("Saliendo.");
    }    

    private void mostrarMenu(){
	System.out.println("\n---------------------------MENU-----------------------------");
	System.out.println("1. Realizar elecciones de consejeros.");
	System.out.println("0. Salir.");
	System.out.print("\nOpción nº: ");
    }

    private void elegirMenu(int opcion)throws SQLException {
	switch (opcion){
	    case 1: objGestion.insertarPartidos(objConexion.getObjConnection());
		    objGestion.extraerVotosTotales(objConexion.getObjConnection());
		    objGestion.realizarElecciones();
		    break;
	    case 0: System.out.println("\nSaliendo.");
		    break;
	}
    }
}
