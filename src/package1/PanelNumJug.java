package package1;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class PanelNumJug extends JPanel implements ActionListener {
    private int opcion;
    private Image fondo;
    private JTextArea areaDeTexto1;
    private JButton boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton10;
    private NumJugadoresListener listener;

    public interface NumJugadoresListener {
        void numeroSeleccionado(int numero);
    }

    public void setListener(NumJugadoresListener listener) {
        this.listener = listener;
    }

    public PanelNumJug() {
        setLayout(new FlowLayout());
        fondo = new ImageIcon("fondo.jpg").getImage();

        areaDeTexto1 = new JTextArea(1, 1);
        boton3 = new JButton("3");
        boton4 = new JButton("4");
        boton5 = new JButton("5");
        boton6 = new JButton("6");
        boton7 = new JButton("7");
        boton8 = new JButton("8");
        boton9 = new JButton("9");
        boton10 = new JButton("10");

        add(areaDeTexto1);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);
        add(boton7);
        add(boton8);
        add(boton9);
        add(boton10);

        areaDeTexto1.setText("Elige el número de jugadores");

        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
        boton6.addActionListener(this);
        boton7.addActionListener(this);
        boton8.addActionListener(this);
        boton9.addActionListener(this);
        boton10.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton3) opcion = 3;
        if (e.getSource() == boton4) opcion = 4;
        if (e.getSource() == boton5) opcion = 5;
        if (e.getSource() == boton6) opcion = 6;
        if (e.getSource() == boton7) opcion = 7;
        if (e.getSource() == boton8) opcion = 8;
        if (e.getSource() == boton9) opcion = 9;
        if (e.getSource() == boton10) opcion = 10;

        if (listener != null) {
            listener.numeroSeleccionado(opcion);
        }
    }
}


