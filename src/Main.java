
public class Main {

	public static void main(String[] args) {
		Menu menu=new Menu();
		
		if (menu.menuInicial()==0) {
			return;
		}
		

		Partida partida1 = new Partida(menu.numeroJugadores());
		partida1.jugar();
	}

}
