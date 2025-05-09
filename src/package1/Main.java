package package1;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        AudioPlayer.ReproducirAudio();
        int x;

        do {
            x = menu.menuInicial();
            if (x == 0)
                System.exit(0);

            else if (x == 1) {
            	AudioPlayer.ReproducirAudio2();
                Partida partida = new Partida();
                partida.jugar(menu.menuNumJugadores());
            } else if (x == 4) {
            	AudioPlayer.ReproducirAudio2();
                Partida partida = new Partida();
                partida.cargarUltimaPartida();
                partida.jugar(partida.jugadoresVivos());
            }

        } while (x != 0);
    }
}
