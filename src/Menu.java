import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	
	/*
	 * menú para escoger el número de jugadores 
	 * 
	 * solo acepta entre 3 y 8, y es el parámetro que se le pasa
	 * como argumento al constructor de la clase Partida
	*/
	public int numeroJugadores() {
		int opcion;
		System.out.print("Introduzca el número de jugadores: ");
		opcion=input.nextInt();
		while (opcion<3||opcion>8) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		return opcion;
	}
	
	/*
	 * Este es el menú que se muestra nada más empezar.
	 * Para mostrar las reglas y la información, que solo es mostrar texto,
	 * y es bastante, creé la clase Utilities.
	 * Esa clase es para meter los metodos más coñazo y que no emborronen el resto
	 * de clases.
	 * Las reglas y la información están sin escribir, pero para cuando se escriban se hará
	 * en la clase Utilities (por esto está el segundo if)
	*/
	public int menuInicial() {
		int opcion;
		System.out.println("------ COLD WAR ------");
		System.out.println("(1) Jugar\n(2) Reglas\n(3) Información\n(0) Salir");
		opcion=input.nextInt();
		while (opcion<0||opcion>3) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		if (opcion==2||opcion==3) {
			Utilities util = new Utilities();
			util.mostrarReglasInformacion(opcion);
		}
		return opcion;
	}
}
