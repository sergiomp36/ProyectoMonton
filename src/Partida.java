import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	Scanner input = new Scanner(System.in);
	
	//variables
	
	/*
	 * El ArrayList es un Array de objetos de tipo Equipo. Al ser una estructura dinámica
	 * se pueden ir añadiendo equipos según se van creando con participantes.add (linea 43).
	 * 
	 * 
	*/
	ArrayList <Equipo> participantes = new ArrayList<Equipo>();
	public int numJugadores;
	
	//CONSTRUCTOR
	
	/*
	 * El número de jugadores se le pasa al constructor. Si vas a la clase main,
	 * verás que el número de jugadores lo determina un menú de la clase menú para
	 * que introduzca el número el usuario.
	*/
	public Partida(int numJugadores) {
		this.numJugadores=numJugadores;
	}
	
	//metodos
	
	/*
	 * Este es el método principal que se ejecuta desde el método main
	 * y sirve principalmente para llamar a otros métodos de esta clase.
	*/
	public void jugar() {
		escogerNombreEquipo();
		escogerPais();
		repartirVidas();
		
		
	}
	/* 
	 * se le da un nombre al equipo (escogido por el usuario) que puede ser cualquier String.
	 * (en el print de la linea 31 pone (i+1) para que ponga bien el número y se salte el 0).
	*/
	public void escogerNombreEquipo() {
		for (int i = 0; i<numJugadores;i++) {
			System.out.print("Jugador "+(i+1)+", escoge un nombre: ");
			String nombre = input.next();
			participantes.add(new Equipo (nombre));
		}
	}
	
	
	/* 
	 * asigna un país en función de un número q introduce el usuario.
	 * ese número se le pasa al setter que está en la clase Equipo 
	 * y este coge ese elemento del array de países que está en esa clase también.
	*/
	public void escogerPais() {
		for (int i=0;i<numJugadores;i++) {
			System.out.print(participantes.get(i).getNombre()+", escoge un país \n(1) Alemania, (2)Francia, (3)Italia, (4)Eslovaquia\n(5)República Checa, (6)Polonia, (7)Hungría, (8)Austria: ");
			int pais = input.nextInt();
			while (pais<1 || pais>8) {
				System.out.print("ERROR: Introduzca un país correcto: ");
				pais = input.nextInt();
			}
			participantes.get(i).setPais(pais);
			System.out.println("Has escogido "+participantes.get(i).getPais());
		}
	}
	
	
	//reparte vidas en funcion del país: todos 200 menos Francia que tiene un 20% más
	public void repartirVidas() {
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
	
	
	
	
	
}
