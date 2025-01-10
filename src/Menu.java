import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	

	public int numeroJugadores() {
		int opcion;
		System.out.print("Introduzca el número de jugadores: ");
		opcion=input.nextInt();
		while (opcion<3||opcion>10) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		return opcion;
	}
	

	public int menuInicial() {
		int opcion;
		System.out.println("------ COLD WAR ------");
		System.out.println("(1) Jugar\n(2) Reglas\n(3) Información\n(4) Cargar partida\n(0) Salir");
		opcion=input.nextInt();
		while (opcion<0||opcion>4) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		if (opcion==2||opcion==3 || opcion==4) {
			Utilities util = new Utilities();
			util.mostrarReglasInformacion(opcion);
		}
		return opcion;
	}
	
	
	public int menuRonda(Equipo equipo) {
		int opcion;
		System.out.println(equipo.getNombre()+", ¿qué quieres hacer?");
		System.out.println("(1)Atacar\n(2)Defender\n(3)(Ayuda aliada)");//queda por mirar que hace la opcion de la ayuda
		opcion = input.nextInt();
		while (opcion<1||opcion>3) {
			System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
			opcion=input.nextInt();
		}
		return opcion;
	}
	
	
}
