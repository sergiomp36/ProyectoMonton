
public class Main {

	public static void main(String[] args) {
		/*
		 * Se crea el objeto menú para poder utilizar los métodos de esa clase
		*/
		Menu menu=new Menu();
		
		//si la opcion es "salir", sale.
		if (menu.menuInicial()==0) {
			return;
		}
		
		/* se crea el objeto partida con el número de jugadores determinado
		 * y se ejecuta el método jugar() de la clase partida.
		*/
		Partida partida1 = new Partida(menu.numeroJugadores());
		partida1.jugar();
	}

}
