package package1;

import javax.swing.*;

public class Marco extends JFrame {
    public Marco() {
        setTitle("Cold War");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Creamos el panel principal y le pasamos el JFrame (este mismo marco)
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        setContentPane(panelPrincipal);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Marco());
    }
}
