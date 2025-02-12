package package1;

import java.util.ArrayList;
import java.util.Random;

public class Partida {
	
	Random r = new Random();
	Menu menu = new Menu();
	
	private int numRonda=1;
	private String climaRonda;
	private String []climas = {"NIEBLA", "LLUVIA", "CALOR", "NIEVE", "TERREMOTO"};
	private ArrayList<Equipo> participantes = new ArrayList<>(); 
	
	
	
	//CONSTRUCTOR
	
	
	//MÉTODO PRINCIPAL DE LA CLASE
	public void jugar(int numJugadores) {
		iniciarPartida(numJugadores);
		while(jugadoresVivos()>1) {
			climaRonda=establecerClimaRonda();
			ronda();
			numRonda++;
		}
		Utilities.mostrarGanador();
	}
	
	//MÉTODO RONDA
	
	private void ronda() {
		System.out.println("RONDA "+numRonda);
		imprimirClima();
		for (int i = 0; i < jugadoresVivos() ; i++) {
			int opc = menu.menuAtacarDefender(participantes.get(i), numRonda);
			if(opc==1) {
				
			}
			else if(opc==2) {
				
			}
			else {
				
			}
		}
		
	}
	
	
	
	
	
	//MÉTODOS AUXILIARES
	private void iniciarPartida(int numJugadores) {
		for (int i = 0 ; i < numJugadores ; i++) {
			Equipo equipo = new Equipo(menu.escogerNombreEquipo(i));
			Pais pais = new Pais (menu.escogerPais(equipo));
			equipo.setPais(pais);
			participantes.add(equipo);
			repartirVidasIniciales(equipo);
		}
	}
	
	private void repartirVidasIniciales(Equipo equipo) {
    	if (equipo.getPais().getNombrePais().equals("FRANCIA")) {
    		equipo.getPais().setVidasIniciales(260);
    	}else if (equipo.getPais().getNombrePais().equals("DINAMARCA")) {
    		equipo.getPais().setVidasIniciales(400);
    	}else if(equipo.getPais().getNombrePais().equals("SUIZA")) {
    		equipo.getPais().setVidasIniciales(100);
    	}else {
    		equipo.getPais().setVidasIniciales(200);
    	}
    }	
	
	
	private void repartirMisilesMaxAtaque(Equipo equipo, int ronda) {
		if (equipo.getPais().getNombrePais().equals("ALEMANIA")) {
    		if (climaRonda.equals("LLUVIA")) 
    			equipo.getPais().setMisilesAtaque(70);
    		else 
    			equipo.getPais().setMisilesAtaque(60);
    	}
		else if (equipo.getPais().getNombrePais().equals("DINAMARCA") && ronda<=5) {
			equipo.getPais().setMisilesAtaque(10*ronda);
		}
		else {
			equipo.getPais().setMisilesAtaque(50);
		}
	}
	
	
	
	private String establecerClimaRonda() {
		int aux = r.nextInt(8);
		if (aux<climas.length) {
			return climas[aux];
		}
		else {
			return null;
		}
	}
	private void imprimirClima() {
		if(climaRonda!=null) {
			System.out.println("El clima especial en la ronda"+numRonda+" es: "+climaRonda);
		}
		else {
			System.out.println("No hay clima especial en la ronda "+numRonda);
		}
	}
	
	private int jugadoresVivos() {
		int aux=0;
		for (int i=0; i<participantes.size();i++) {
			if (!participantes.get(i).isMuerte()) {
				aux++;
			}
		}
		return aux;
	}
	
	
	
	
}