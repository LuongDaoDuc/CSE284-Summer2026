package buoi3;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetGUI gui = new PetGUI();
            gui.setVisible(true);
        });
    }
}