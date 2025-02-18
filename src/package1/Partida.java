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
	
	
	//MÉTODO PRINCIPAL DE LA CLASE
	public void jugar(int numJugadores) {
		iniciarPartida(numJugadores);
		while(jugadoresVivos()>1) {
			climaRonda=establecerClimaRonda();
			ronda();
			numRonda++;
		}
		System.out.println("EL GANADOR ES: "+participantes.get(0).getNombre());
	}
	
	//MÉTODO RONDA
	private void ronda() {
		System.out.println("\nRONDA "+numRonda);
		Utilities.imprimirValoresInicioRonda(participantes);
		imprimirClima();
		resetAtacadosRonda();
		actualizarVidasAux();
		for (int i = 0; i < jugadoresVivos() ; i++) {
			repartirMisilesMAXAtaque(participantes.get(i));
			int opc = menu.menuAtacarDefender(participantes.get(i), numRonda);
			if(opc==1) {
				atacar(participantes.get(i));
			}
			else if(opc==2) {
				misilesDefensa(participantes.get(i));
			}
			else {
				//AYUDA ALIADA
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
	
	
	private void repartirMisilesMAXAtaque(Equipo equipo) {
		if (equipo.getPais().getNombrePais().equals("ALEMANIA")) {
    		if (climaRonda.equals("LLUVIA")) 
    			equipo.getPais().setMisilesMaxAtaque(70);
    		else 
    			equipo.getPais().setMisilesMaxAtaque(60);
    	}
		else if (equipo.getPais().getNombrePais().equals("DINAMARCA") && numRonda<=5) {
			equipo.getPais().setMisilesMaxAtaque(10*numRonda);
		}
		else {
			equipo.getPais().setMisilesMaxAtaque(50);
		}
	}
	
	
	
	private void atacar(Equipo equipo){
		repartirMisilesAtaque(equipo);
		while (equipo.getPais().getMisilesAtaque()>0) {
			Utilities.imprimirValoresEntreAtaques(equipo);
			Equipo objetivo = menu.escogerEquipoAtacar(participantes,equipo);
			objetivo.setAtacadoEnRonda(true);
			evaluarAtaque(objetivo, menu.cuantosMisilesAtacar(equipo), equipo);
			evaluarDefensa(objetivo);
		}
	}
	
	private void repartirMisilesAtaque(Equipo equipo) {
		int aux = menu.numeroMisilesAtaque(equipo);
		equipo.getPais().setMisilesAtaque(aux);
		equipo.getPais().setMisilesDefensa((equipo.getPais().getMisilesAtaque()-aux)/2);
	}
	
	
	private void misilesDefensa(Equipo equipo){
		equipo.getPais().setMisilesDefensa(equipo.getPais().getMisilesMaxAtaque()/2);
	}
	
	
	private void evaluarAtaque(Equipo objetivo, int misiles, Equipo atacante) {
		objetivo.getPais().setVidasActuales(objetivo.getPais().getVidasActuales()-misiles);
		atacante.getPais().setMisilesAtaque(atacante.getPais().getMisilesAtaque()-misiles);
	}
	
	private void evaluarDefensa(Equipo equipo) {
		if ((equipo.getPais().getVidasActuales()+equipo.getPais().getMisilesDefensa())>equipo.getVidasInicioRonda()) {
			equipo.getPais().setVidasActuales(equipo.getVidasInicioRonda());
			equipo.getPais().setMisilesDefensa(equipo.getPais().getVidasActuales()+equipo.getPais().getMisilesDefensa()-equipo.getVidasInicioRonda());
		}else {
			equipo.getPais().setVidasActuales(equipo.getPais().getVidasActuales()+equipo.getPais().getMisilesDefensa());
			equipo.getPais().setMisilesDefensa(0);
		}
	}
	
	private String establecerClimaRonda() {
		int aux = r.nextInt(8);
		if (aux<climas.length) {
			return climas[aux];
		}
		else {
			return "";
		}
	}
	private void imprimirClima() {
		if(climaRonda!="") {
			System.out.println("El clima especial en la ronda "+numRonda+" es: "+climaRonda);
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
			}else {
				participantes.remove(i);
			}
		}
		return aux;
	}
	
	private void resetAtacadosRonda() {
		for (int i = 0 ; i < jugadoresVivos() ; i++) {
			participantes.get(i).setAtacadoEnRonda(false);
		}
	}
	
	private void actualizarVidasAux() {
		for (int i = 0 ; i < jugadoresVivos() ; i++) {
			participantes.get(i).setVidasInicioRonda(participantes.get(i).getPais().getVidasActuales());
		}
	}
	
	
	
}