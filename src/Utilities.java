
public class Utilities {
	//variables
	
	
	//métodos
	
	public void mostrarReglasInformacion(int opcion) {
		if (opcion == 2) {
			System.out.println("------ REGLAS ------");
			System.out.println("Hay entre 3 y 10 equipos. El objetivo es ser el último equipo vivo \n");
			System.out.println("Los misiles pueden dividirse para atacar a varios equipos a la vez");
			System.out.println("La defensa cuesta el doble de misiles que atacar");
			System.out.println("Los misiles pueden dividirse entre ataque y defensa.");
			System.out.println("Los jugadores pueden elegir la opción 'Solicitar ayuda aliada' en lugar de atacar o defender. Esto causará uno de los siguientes efectos:");
			System.out.println("   1.	Conseguir 25 misiles para atacar extra, 25%.");
			System.out.println("   2.	Conseguir 30 misiles para defender extra, 25%.");
			System.out.println("   3.	Conseguir un 20% de evasión, 25%.");
			System.out.println("   4.	Invulnerabilidad durante ese turno, 10%.");
			System.out.println("   5.	¡Traición aliada! Recibir 10 puntos de daño, 15%. \n");
			System.out.println("Puedes elegir entre varios países, cada país tiene una habilidad pasiva diferente:");
			System.out.println("   •    Alemania: 10 más de misiles al atacar, 10 extra en niebla.");
			System.out.println("   •    Austria: 10 más al defender. 10 extra en lluvia.");
			System.out.println("   •	Francia: 60 más de vida máxima, 5% posibilidades de fallar el ataque.");
			System.out.println("   •	República Checa: 20% más de daño realizado y 10% de daño recibido en climas especiales.");
			System.out.println("   •	Italia: Cada 2 rondas genera automáticamente 5 de escudo.");	
			System.out.println("   •	Hungría: Si usa todos los recursos para defender se vuelve invulnerable, pero pierde el siguiente turno (no podrá atacar o defender).");		
			System.out.println("   •	Polonia: Consigue una ronda extra al llegar a 0 de vida.");	
			System.out.println("   •	Eslovaquia: Consigue una habilidad aleatoria entre 4.");
			System.out.println("   •	Dinamarca: Doble de vida, pero empieza con 10 misiles (que se van incrementado en 10 en cada ronda hasta el numero normal de misiles).");
			System.out.println("   •	Croacia: Mitad de vida, 40% de evasión. \n");
			System.out.println("Los climas afectan a la partida de diferentes formas:");
			System.out.println("   •	Niebla: 20% de posibilidad de fallar ataque.s");
			System.out.println("   •	Lluvia: Baja la defensa en 10.");
			System.out.println("   •	Alto calor: Aumenta el daño en 10.");
			System.out.println("   •	Nieve: Impide pedir ayuda a aliados.");
			System.out.println("   •	Terremoto (muy raro): Hace 5 de daño al jugador por cada turno activo. \n");
			System.out.println("La partida podrá ser guardada para poder continuarla en otra ocasión.");
		}
		else {
			System.out.println("INFORMACIÓN");
			System.out.println("Versión: ");
			System.out.println("Autores: Sergio Montoya Prado / David Antón Gil");
			System.out.println("Contacto: sergiomp36@educastur.es / RFM16975@educastur.es");
		}
	}
}
