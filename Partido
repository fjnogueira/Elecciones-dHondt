package elecciones;
import java.util.ArrayList;
public class Partido {
    
    private String nombre, siglas;
    private int numEscaños;
    private ArrayList<Integer> ALVotos;
    
    public Partido(String siglas, String nombre){
        ALVotos = new ArrayList();
        this.siglas = siglas;
        this.nombre = nombre;
        numEscaños = 0;
    }

    public void añadirVotosTotales(int votosTotales){
        ALVotos.add(votosTotales);
    }
    
    public void repartirVotos(int numConsejeros){
	int votosTotales = ALVotos.get(0);
	for (int i=2; i<numConsejeros+1; i++){
	    ALVotos.add(votosTotales/i);
	}
    }
    
    public String getSiglas() {
        return siglas;
    }
    
    public void añadirEscaño(){
	numEscaños++;
    }

    public void setVotos(int posicion){
	ALVotos.set(posicion, -1);
    }

    public int getVotos(int posicion){
	return ALVotos.get(posicion);
    }

    public int getSize(){
	return ALVotos.size();
    }

    public int getNumEscaños(){
	return numEscaños;
    }
}
