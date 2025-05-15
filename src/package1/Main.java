package package1;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Con esto se reciben las cosas desde la botonera
            PipedOutputStream salidaDesdeInterfaz = new PipedOutputStream();
            PipedInputStream entradaParaJuego = new PipedInputStream(salidaDesdeInterfaz);

            // Redirige los datos de la botonera a la consola
            System.setIn(entradaParaJuego);

            // Esto crea un hilo aparte
            new Thread(() -> new InterfazJuego(salidaDesdeInterfaz)).start();

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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

