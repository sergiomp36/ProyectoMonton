import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	Scanner input = new Scanner(System.in);
	
	//variables
	ArrayList <Equipo> participantes = new ArrayList<Equipo>();
	public int numJugadores;
	
	//CONSTRUCTOR
	
	public Partida(int numJugadores) {
		this.numJugadores=numJugadores;
	}
	
	//metodos
	
	public void jugar() {
		escogerNombreEquipo();
		escogerPais();
		
	}
	
	public void escogerNombreEquipo() {
		for (int i = 0; i<numJugadores;i++) {
			System.out.print("Jugador "+(i+1)+", escoge un nombre: ");
			String nombre = input.next();
			participantes.add(new Equipo (nombre));
		}
	}
	
	public void escogerPais() {
		for (int i=0;i<numJugadores;i++) {
			System.out.print(participantes.get(i).getNombre()+", escoge un país (A, F, I, E, RC, P, H, AU: ");
			String pais = input.nextLine();
			while (pais != "A" && pais != "F" && pais != "I" && pais != "E" && pais != "RC" && pais != "P" && pais != "H" && pais != "AU") {
				System.out.print("ERROR: Introduzca un país correcto: ");
				pais = input.next();
			}
			participantes.get(i).setPais(pais);
		}
	}
}
