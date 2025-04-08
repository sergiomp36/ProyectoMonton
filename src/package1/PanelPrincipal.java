package package1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class PanelPrincipal extends JPanel implements ActionListener, PanelNumJug.NumJugadoresListener {
    Menu menu = new Menu();
    private Image fondo;
    JButton botonJugar, botonReglas, botonInfo, botonCargar, botonSalir;
    JTextArea areaDeTexto;

    PanelPrincipal() {
        setLayout(new FlowLayout());

        fondo = new ImageIcon("fondo.jpg").getImage();

        this.botonJugar = new JButton("Jugar");
        this.botonReglas = new JButton("Reglas");
        this.botonInfo = new JButton("Información");
        this.botonCargar = new JButton("Cargar partida");
        this.botonSalir = new JButton("Salir");
        this.areaDeTexto = new JTextArea(20,50);

        botonJugar.addActionListener(this);
        botonReglas.addActionListener(this);
        botonInfo.addActionListener(this);
        botonCargar.addActionListener(this);
        botonSalir.addActionListener(this);

        add(botonJugar);
        add(botonReglas);
        add(botonInfo);
        add(botonCargar);
        add(botonSalir);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonJugar) {
            JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
            marco.remove(this);

            PanelNumJug panelNumJug = new PanelNumJug();
            panelNumJug.setListener(this); 
            marco.add(panelNumJug);
            marco.setVisible(true);
        }

        if (e.getSource() == botonReglas) {
            add(areaDeTexto);
            areaDeTexto.setText(""); 
            try {
                File archivo = new File("reglas.txt");
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    areaDeTexto.append(scanner.nextLine() + "\n");
                }
                scanner.close();
            } catch (FileNotFoundException e2) {
                areaDeTexto.setText("Error: Archivo no encontrado.");
                e2.printStackTrace();
            }
        }

        if (e.getSource() == botonInfo) {
            add(areaDeTexto);
            areaDeTexto.setText(""); 
            try {
                File archivo = new File("informacion.txt");
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    areaDeTexto.append(scanner.nextLine() + "\n");
                }
                scanner.close();
            } catch (FileNotFoundException e2) {
                areaDeTexto.setText("Error: Archivo no encontrado.");
                e2.printStackTrace();
            }
        }

        if (e.getSource() == botonSalir) {
            System.exit(0);
        }
    }

    @Override
    public void numeroSeleccionado(int numero) {
        System.out.println("Número de jugadores seleccionado: " + numero);
        
        PanelEquipos panelEquipos = new PanelEquipos(numero);
        
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.getContentPane().removeAll(); 
        marco.getContentPane().add(panelEquipos);
        marco.revalidate(); 
        marco.repaint();   
    }

}
