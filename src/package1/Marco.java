package package1;

import javax.swing.JFrame;

public class Marco extends JFrame{
	
	PanelPrincipal lamina1;

	Marco(){
		setBounds(300,50,815,700); //Coordenadas y tamaño
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Esto es lo que hace al pulsar la X de la ventana (el botón de salir vaya)
		setTitle("RedCode");
		lamina1 = new PanelPrincipal();
		add(lamina1);
		setVisible(true);
	}
}
