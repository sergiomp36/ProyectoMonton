package package1;

import java.util.Random;

public class Partida {
	
	Random r = new Random();
	Menu menu = new Menu();
	
	private String climaRonda;
	private String []climas = {"NIEBLA", "LLUVIA", "CALOR", "NIEVE", "TERREMOTO"};
	
	
	//CONSTRUCTOR
	
	
	//MÉTODO PRINCIPAL DE LA CLASE
	public void jugar(int numJugadores) {
		
		
		
	}
	
	//MÉTODOS AUXILIARES
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
	
	private void repartirMisilesAtaque(Equipo equipo, int ronda) {
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
	
	
	
	
}