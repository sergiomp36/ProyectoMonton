import java.util.ArrayList;
import java.util.Scanner;


public class Partida {
	Scanner input = new Scanner(System.in);
	Menu menu = new Menu();
	
	//variables
	ArrayList <Equipo> participantes = new ArrayList<Equipo>();
	private int numJugadores;
	
	//CONSTRUCTOR
	
	
	public Partida(int numJugadores) {
		this.numJugadores=numJugadores;
	}
	
	
	//metodos
	public void jugar() {
		escogerNombreEquipo();
		escogerPais();
		repartirVidas();
		for(int i = 0; i < jugadoresVivos(); i++) {
			ronda();
		}
	}
	
	
	private void escogerNombreEquipo() {
		for (int i = 0; i<numJugadores;i++) {
			System.out.print("Jugador "+(i+1)+", escoge un nombre: ");
			String nombre = input.next();
			participantes.add(new Equipo (nombre));
		}
	}
	
	
	private void escogerPais() {
		Utilities util = new Utilities();
		int[] paisesEscogidos = new int[numJugadores];
		for (int i=0;i<numJugadores;i++) {
			System.out.println(participantes.get(i).getNombre()+", escoge un país \n(1) Alemania, (2)Francia, (3)Italia, (4)Eslovaquia\n(5)República Checa, (6)Polonia, (7)Hungría, (8)Austria\n(9)Polonia, (10)Dinamarca: ");
			int pais = input.nextInt();
			while (pais<1 || pais>10) {
				System.out.print("ERROR: Introduzca un país correcto: ");
				pais = input.nextInt();
			}
			while (util.contiene(paisesEscogidos, pais)) {
				System.out.print("ERROR: "+ participantes.get(i).paises[pais-1]+" ya está escogido. Escoge otro: ");
				pais = input.nextInt();
			}
			paisesEscogidos[i]=pais;
			participantes.get(i).setPais(pais);
		}
	}
	
	
	private void repartirVidas() {
		for (int i=0;i<numJugadores;i++) {
			switch (participantes.get(i).getPais()) {
			case "Francia":
				participantes.get(i).setVidas(240);
				break;
			default:
				participantes.get(i).setVidas(200);
				break;
			}
		}
	}
	
	
	
	private void ronda() {
		for (int i=0; i<numJugadores;i++) {
			if (!participantes.get(i).isMuerte()) {//comprueba si está muerto y si sigue vivo entra en el if
				int opcion = menu.menuRonda(participantes.get(i));
				if (opcion == 1) {
					System.out.println("¿A quién quieres atacar?");
					for (int j = 0 ; j < numJugadores ; j++) {//bucle para mostrar los paises que siguen con vida
						if (!participantes.get(i).isMuerte()) {
							System.out.println(participantes.get(j).getPais());
						}
					}
					
				}
			}
		}
		
	}
	
	
	private int jugadoresVivos () {
		int jugadores=0;
		for (int i = 0; i < numJugadores ; i++) {
			if (!participantes.get(i).isMuerte()) {
				jugadores++;
			}
		}
		return jugadores;
	}
	
	
	
}