package elecciones;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Gestion {
    
    private Consulta objConsulta;
    private Eleccion objEleccion;
    
    public Gestion(){
        objConsulta = new Consulta();
        objEleccion = new Eleccion();
    }
    
    public void insertarPartidos(Connection objConnection) throws SQLException{
        Partido objPartido;
	ArrayList<String> ALNombre = new ArrayList();
	ArrayList<String> ALSigla = new ArrayList();
	ALSigla = objConsulta.extraerPartidos(objConnection, 1);
	ALNombre = objConsulta.extraerPartidos(objConnection, 2);	
	for (int i=0; i<ALSigla.size(); i++){
	    objPartido = new Partido(ALSigla.get(i), ALNombre.get(i));
            objEleccion.añadirPartido(objPartido);
	}
    }
    
    public void extraerVotosTotales(Connection objConnection) throws SQLException{
        ArrayList<Integer> AL = new ArrayList();
        AL = objConsulta.extraerResultados(objConnection);
	objEleccion.insertarVotosTotales(AL);
    }

    public void realizarElecciones(){
	System.out.print("Inserta el número de escaños de consejeros que se van a elegir: ");
	int numConsejeros = LecturaDatos.leerInt2(1);
	objEleccion.insertarVotosEscaños(numConsejeros);
	mostrarResultados(numConsejeros);
    }

    private void mostrarResultados(int numConsejeros){
	objEleccion.asignarEscaños(numConsejeros);
	objEleccion.mostrarEscaños();
    }
    
}
