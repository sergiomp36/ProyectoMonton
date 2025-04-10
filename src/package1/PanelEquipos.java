package package1;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelEquipos extends JPanel implements ActionListener {
    private int numJugadores;
    private Image fondo;
    private JTextField campoNombre;
    private JComboBox<String> comboPaises;
    private JButton botonConfirmar;
    private JButton botonContinuar;

    private ArrayList<String> paisesDisponibles;
    private String[] paises = { "ALEMANIA", "FRANCIA", "AUSTRIA", "YUGOSLAVIA", "HUNGRIA", 
                                "ITALIA", "POLONIA", "BELGICA", "DINAMARCA", "SUIZA" };

    private ArrayList<String> nombresEquipos;
    private ArrayList<String> paisesSeleccionados;
    private int jugadorActual;

    public PanelEquipos(int numJugadores) {
    	setLayout(new FlowLayout());
        this.numJugadores = numJugadores;
        this.jugadorActual = 0;
        this.nombresEquipos = new ArrayList<>();
        this.paisesSeleccionados = new ArrayList<>();
        this.paisesDisponibles = new ArrayList<>();
        
        for (String pais : paises) {
            paisesDisponibles.add(pais);
        }

        setLayout(new GridLayout(4, 1)); // 

        fondo = new ImageIcon("fondo.jpg").getImage();

        JLabel labelTitulo = new JLabel("Jugador " + (jugadorActual + 1) + ", ingresa tu nombre:");
        add(labelTitulo);

        campoNombre = new JTextField(15);
        add(campoNombre);

        comboPaises = new JComboBox<>(paisesDisponibles.toArray(new String[0]));
        add(comboPaises);

        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.addActionListener(this);
        add(botonConfirmar);

        botonContinuar = new JButton("Continuar");
        botonContinuar.addActionListener(this);
        botonContinuar.setVisible(false);
        add(botonContinuar);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 if (e.getSource() == botonConfirmar) {
    	        String nombreEquipo = campoNombre.getText().trim();
    	        String paisSeleccionado = (String) comboPaises.getSelectedItem();

    	        if (nombreEquipo.isEmpty() || paisSeleccionado == null) {
    	            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre y seleccionar un país.");
    	            return;
    	        }

    	        nombresEquipos.add(nombreEquipo);
    	        paisesSeleccionados.add(paisSeleccionado);
    	        paisesDisponibles.remove(paisSeleccionado);

    	        jugadorActual++;

    	        if (jugadorActual < numJugadores) {
    	            campoNombre.setText("");
    	            campoNombre.requestFocus();
    	            comboPaises.removeAllItems();
    	            for (String pais : paisesDisponibles) {
    	                comboPaises.addItem(pais);
    	            }

    	            JOptionPane.showMessageDialog(this, "Turno del Jugador " + (jugadorActual + 1));
    	        } else {
    	            botonConfirmar.setVisible(false);
    	            botonContinuar.setVisible(true);
    	        }
    	    }

    	    if (e.getSource() == botonContinuar) {
    	        System.out.println("Equipos registrados:");
    	        for (int i = 0; i < nombresEquipos.size(); i++) {
    	            System.out.println("Equipo " + (i + 1) + ": " + nombresEquipos.get(i) + " - " + paisesSeleccionados.get(i));
    	        }
        }
    	    
    	    
    }
}