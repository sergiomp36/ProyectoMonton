import javax.swing.*;
import java.awt.*;
import java.io.*;

public class PanelJuego extends JPanel {
    private JTextArea areaTexto;
    private JScrollPane scrollPane;
    private ByteArrayOutputStream bufferSalida;
    private PrintStream printStreamOriginal;

    public PanelJuego() {
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        // Redirigir System.out a JTextArea
        redirigirSalida();

        // Iniciar partida en un hilo aparte para no bloquear la interfaz
        new Thread(this::iniciarPartida).start();
    }

    private void redirigirSalida() {
        bufferSalida = new ByteArrayOutputStream();
        printStreamOriginal = System.out;

        PrintStream printStream = new PrintStream(bufferSalida, true);
        System.setOut(printStream);

        Timer timer = new Timer(100, e -> {
            String textoNuevo = bufferSalida.toString();
            if (!textoNuevo.isEmpty()) {
                areaTexto.append(textoNuevo);
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
                bufferSalida.reset();
            }
        });
        timer.start();
    }

    private void iniciarPartida() {
        // Aquí llamamos a la clase Partida
        Partida partida = new Partida();
        partida.jugar();  // Cambiado de iniciar() a jugar() según el método existente

        // Restaurar System.out si se desea al final
        System.setOut(printStreamOriginal);
    }
}
