package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PipedOutputStream;
import java.io.IOException;

public class InterfazJuego extends JFrame {
    private JPanel panelPrincipal;
    private PipedOutputStream out;
    private Image fondoActual;
    Menu menu = new Menu();
    int x;
    public InterfazJuego(PipedOutputStream out) {
        this.out = out;
        this.fondoActual = new ImageIcon("fondo.png").getImage(); // fondo inicial
        iniciarInterfaz();
    }

    private void iniciarInterfaz() {
        setTitle("Red Code");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoActual, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelPrincipal.setLayout(null);

        mostrarMenuInicial();

        add(panelPrincipal);
        setVisible(true);
    }

    private void enviarEntrada(String texto) {
        try {
            out.write((texto + "\n").getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limpiarPanel() {
        panelPrincipal.removeAll();
        panelPrincipal.repaint();
    }

    private JButton crearBoton(String texto, int x, int y, ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, 200, 40);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(40, 40, 40));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.addActionListener(listener);
        panelPrincipal.add(boton);
        return boton;
    }

    private void mostrarMenuInicial() {
        fondoActual = new ImageIcon("fondo.png").getImage(); // restaurar fondo
        limpiarPanel();

        crearBoton("Jugar", 300, 100, e -> {
            enviarEntrada("1");
            mostrarSeleccionJugadores();
        });

        crearBoton("Reglas", 300, 160, e -> enviarEntrada("2"));
        crearBoton("Información", 300, 220, e -> enviarEntrada("3"));

        crearBoton("Cargar Partida", 300, 280, e -> {
            enviarEntrada("4");
            mostrarAccionesJuego();
        });

        crearBoton("Salir", 300, 340, e -> enviarEntrada("0"));

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private void mostrarSeleccionJugadores() {
        fondoActual = new ImageIcon("fondo.png").getImage(); // usar fondo normal
        limpiarPanel();

        JLabel label = new JLabel("Número de jugadores:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(290, 50, 300, 30);
        panelPrincipal.add(label);

        int x = 100;
        int y = 120;
        for (int i = 3; i <= 10; i++) {
            int numero = i;
            crearBoton(String.valueOf(i), x, y, e -> {
                enviarEntrada(String.valueOf(numero));
                mostrarIngresoNombre();
            });

            x += 220; 
            if ((i - 2) % 3 == 0) {
                x = 100;
                y += 70;
            }
        }

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private void mostrarIngresoNombre() {
        fondoActual = new ImageIcon("fondo.png").getImage(); // usar fondo normal
        limpiarPanel();

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(250, 150, 300, 30);
        panelPrincipal.add(campoTexto);

        crearBoton("Enviar", 300, 200, e -> {
            String texto = campoTexto.getText().trim();
            if (!texto.isEmpty()) {
                enviarEntrada(texto);
                campoTexto.setText("");
            }
        });

        crearBoton("Jugar", 300, 250, e -> {
            mostrarAccionesJuego();
        });

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private void mostrarAccionesJuego() {
        fondoActual = new ImageIcon("espera.gif").getImage(); // fondo de espera
        limpiarPanel();

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(250, 200, 300, 30);
        panelPrincipal.add(campoTexto);

        crearBoton("Atacar", 190, 150, e -> {
            enviarEntrada("1");
            mostrarFondoTemporal("ataque.gif", 7000); // 7 segundos
            AudioPlayer.ReproducirAudio3();
        });

        crearBoton("Defender", 410, 150, e -> {
            enviarEntrada("2");
        });
        
        crearBoton("Ayuda Aliada", 300, 100, e -> {
            enviarEntrada("3");
        });

        crearBoton("Enviar", 300, 250, e -> {
            String texto = campoTexto.getText().trim();
            if (!texto.isEmpty()) {
                enviarEntrada(texto);
                campoTexto.setText("");
            }
        });

        crearBoton("Volver", 600, 500, e -> {
            mostrarMenuInicial();
            enviarEntrada("999");
        });

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private void mostrarFondoTemporal(String rutaImagen, int duracionMs) {
        fondoActual = new ImageIcon(rutaImagen).getImage();
        panelPrincipal.repaint();

        new javax.swing.Timer(duracionMs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondoActual = new ImageIcon("espera.gif").getImage();
                panelPrincipal.repaint();
                ((Timer) e.getSource()).stop();
            }
        }).start();
    }
}

