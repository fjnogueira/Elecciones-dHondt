package elecciones;
import java.util.Scanner;

public class LecturaDatos {
    
    static int leerInt(int minimo, int maximo){
        Scanner leer = new Scanner(System.in);
        int valor;
        do{
            valor = leer.nextInt();
            if (valor<minimo||valor>maximo) System.out.print("No es un valor válido. Insértalo de nuevo: ");
        } while (valor<minimo||valor>maximo);
        leer.nextLine();
        return valor;
    }

    static int leerInt2(int minimo){
	Scanner leer = new Scanner(System.in);
	int valor;
	do{
	    valor = leer.nextInt();
	    if (valor<minimo) System.out.print("No es un valor válido. Insértalo de nuevo: ");
	} while (valor<minimo);
	return valor;
    }
    
    static String leerString (String texto){
        Scanner leer = new Scanner(System.in);
        String cadena;
        System.out.print(texto);
        cadena = leer.nextLine();
        return cadena;
    }
}
