import java.util.ArrayList;

import java.util.Scanner;


public class Partida {
	Scanner input = new Scanner(System.in);
	Menu menu = new Menu();
	Utilities util = new Utilities();
	
	//variables
	public ArrayList <Equipo> participantes = new ArrayList<Equipo>();
	private int numJugadores;
	public String [] paises = {"Alemania", "Francia", "Italia", "Eslovaquia", "República Checa","Polonia", "Hungría","Austria","Polonia","Dinamarca"};
	
	//CONSTRUCTOR
	
	
	public Partida(int numJugadores) {
		this.numJugadores=numJugadores;
	}
	
	
	//metodos
	public void jugar() {
		int numRonda=1;
		escogerNombreEquipo();
		escogerPais();
		repartirVidas();
		while (jugadoresVivos()>1) {
			ronda();
			numRonda++;
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
	
	
	private void repartirMisilesAtaque() {
		//igual que el de vidas, falta por pensar como se reparten.
	}
	
	private void ronda() {
		for (int i=0; i<numJugadores;i++) {
			if (!participantes.get(i).isMuerte()) {//comprueba si está muerto y si sigue vivo entra en el if
				int opcion = menu.menuRonda(participantes.get(i));
				
				if (opcion == 1) {//si elige ATACAR
					System.out.println("¿A quién quieres atacar?");
					for (int j = 0 ; j < numJugadores ; j++) {//bucle para mostrar los paises que siguen con vida y que no coinciden con el actual
						if (!participantes.get(i).isMuerte() && i!=j) {
							System.out.println("("+(util.indexOf(paises,participantes.get(j).getPais())+1)+") "+participantes.get(j).getPais());
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