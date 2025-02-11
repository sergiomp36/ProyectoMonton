package package1;
import java.util.Scanner;

public class Menu {
	
	Scanner input = new Scanner(System.in);
	
	int opcion;
	//MÉTODOS
	public int menuInicial() {
		System.out.println("------ COLD WAR ------");
		System.out.println("(1) Jugar\n(2) Reglas\n(3) Información\n(4) Cargar partida\n(0) Salir");
		opcion=input.nextInt();
		while (opcion<0||opcion>4) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		if (opcion==2||opcion==3 || opcion==4) {
			Utilities.mostrarReglasInformacion(opcion);
		}
		return opcion;
	}
	
	public int menuNumJugadores() {
		System.out.print("\nIntroduzca el número de jugadores: ");
		opcion = input.nextInt();
		while (opcion<3||opcion>10) {
			System.out.println("Número de jugadores incorrecto.\nIntroduzca un número entre 3 y 10.");
			System.out.print("> ");
			opcion = input.nextInt();
		}
		return opcion;
	}
	
	
}
