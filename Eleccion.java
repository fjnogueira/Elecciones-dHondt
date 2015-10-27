package elecciones;
import java.util.ArrayList;
public class Eleccion {
    
    private ArrayList<Partido> ALPartidos;
    
    public Eleccion(){
        ALPartidos = new ArrayList();
    }
    
    public void añadirPartido(Partido objPartido){
        boolean bandera = false;
        if(ALPartidos.isEmpty()){
            ALPartidos.add(objPartido);
        }
        else {
            for (int i=0; i<ALPartidos.size()&&!bandera; i++){
                if (objPartido.getSiglas().compareTo(ALPartidos.get(i).getSiglas())==-1){
                    ALPartidos.add(i, objPartido);
                    bandera = true;
                }
            }
            if (!bandera) ALPartidos.add(objPartido);
        }
    }
    
    private void eliminarPartidos(){
        ALPartidos.clear();
    }

    
    public void insertarVotosTotales(ArrayList<Integer> ALVotosTotales){
        if (ALVotosTotales.size()!=ALPartidos.size()){
            System.out.println("No se ha podido insertar los votos totales debido a que el número de partido insertados no es el correcto.");
            System.out.println("Se eliminarán los partidos para que vuelva a insertarlos correctamente.");
            eliminarPartidos();
        }
        else {
            for (int i=0; i<ALPartidos.size(); i++){
                ALPartidos.get(i).añadirVotosTotales(ALVotosTotales.get(i));
            }
        }
    }


    public void insertarVotosEscaños(int numConsejeros){
	for (int i=0; i<ALPartidos.size(); i++){
	    ALPartidos.get(i).repartirVotos(numConsejeros);
	}
	
    }

    public void asignarEscaños(int numConsejeros){
	int partido = 0, posicion = 0, votoMayor;
	ALPartidos.get(0).añadirEscaño();
	numConsejeros--;
	do{
	    votoMayor = 0;
	    ALPartidos.get(partido).setVotos(posicion);
	    for(int i=0; i<ALPartidos.size(); i++){
		for (int j=0; j<ALPartidos.get(i).getSize(); j++){
                    if (votoMayor<ALPartidos.get(i).getVotos(j)){  
                        partido = i;
                        posicion = j;
                        votoMayor = ALPartidos.get(i).getVotos(j);
                    }
		}
	    } 
	    ALPartidos.get(partido).añadirEscaño();
            numConsejeros--;
	} while (numConsejeros!=0);
    }

    public void mostrarEscaños(){
	int totalEscaños = 0;
	System.out.println("\n\nAsignación de escaños para los consejeros por cada partido político: ");
	for (int i=0; i<ALPartidos.size(); i++){
	    totalEscaños += ALPartidos.get(i).getNumEscaños();
	    System.out.println("Partido " + ALPartidos.get(i).getSiglas() + ": " + ALPartidos.get(i).getNumEscaños() + " escaños.");
	}
	System.out.println("Total número de escaños asignados: " + totalEscaños + " escaños.");
    }
    
}
