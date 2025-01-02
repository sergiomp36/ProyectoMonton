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
	
	//COMENTADO HASTA TENER CLARO COMO FUNCIONA LO DE LOS PAISES
	public void escogerPais() {
		for (int i=0;i<numJugadores;i++) {
			System.out.print(participantes.get(i).getNombre()+", escoge un país \n(1) Alemania, (2)Francia, (3)Italia, (4)Eslovaquia, (5)República Checa, (6)Polonia, (7)Hungría, (8)Austria: ");
			int pais = input.nextInt();
			while (pais<1 || pais>8) {
				System.out.print("ERROR: Introduzca un país correcto: ");
				pais = input.nextInt();
			}
			participantes.get(i).setPais(pais);
		}
	}
	
	
	
	
	
}
