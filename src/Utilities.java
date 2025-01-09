
public class Utilities {
	//variables / objetos
	
	
	
	
	//métodos
	
	public void mostrarReglasInformacion(int opcion) {
		if (opcion == 2) {
			System.out.println("------ REGLAS ------");
			System.out.println("Hay entre 3 y 8 equipos");
			System.out.println("El objetivo es ser el último equipo vivo");
			System.out.println("Los misiles pueden dividirse para atacar a varios equipos a la vez");
			System.out.println("La defensa cuesta el doble de misiles que atacar");
			System.out.println("Puedes elegir entre varios países");
			System.out.println("Cada país tiene una habilidad pasiva diferente");
			System.out.println("POR DEFINIR PASIVAS POR PAIS");
			System.out.println("POR DEFINIR LOS POWERUPS");
			System.out.println("Los climas afectan a la partida de diferentes formas");
			System.out.println("POR DEFINIR CLIMAS");
		}
		
		else if (opcion == 3) {
			System.out.println("INFORMACIÓN");
			System.out.println("Versión: ");
			System.out.println("Autores: Sergio Montoya Prado / David Antón Gil");
			System.out.println("Contacto: sergiomp36@educastur.es / RFM16975@educastur.es");
		}
		
		else {
			//CÓDIGO PARA CARGAR LA PARTIDA
		}
	}
	
	public boolean contiene(int[] array, int valor) {
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == valor) {
	            return true;
	        }
	    }
	    return false; 
	}
	
	
}
