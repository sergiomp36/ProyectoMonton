
public class Main {

	public static void main(String[] args) {
		Menu menu=new Menu();
		
		int opcionInicial=menu.menuInicial();
		if (opcionInicial==0) {
			System.exit(0);;
		}
		

		Partida partida1 = new Partida(menu.numeroJugadores());
		partida1.jugar();
	}

}
