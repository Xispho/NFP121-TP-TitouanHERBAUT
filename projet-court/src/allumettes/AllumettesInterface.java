package allumettes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllumettesInterface extends JFrame {

    private JTextField textField;
    private JLabel displayLabel;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private int selectedChoice = -1;
    private boolean choiceMade = false;

    public AllumettesInterface(Jeu jeu, Joueur joueur) {
        initUI(jeu, joueur);
        setVisible(true);
    }

    private void initUI(Jeu jeu, Joueur joueur) {
        setTitle(joueur.getNom() + " ?");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Champ texte en haut
        textField = new JTextField("tricher");
        JPanel topPanel = new JPanel();
        topPanel.add(textField);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Affichage central
        displayLabel = new JLabel(String.valueOf(jeu.getNombreAllumettes()), SwingConstants.CENTER);
        displayLabel.setFont(new Font("Arial", Font.BOLD, 36));
        mainPanel.add(displayLabel, BorderLayout.CENTER);

        // Boutons du bas
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 0));

        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");

        btn1.addActionListener(e -> handleButtonClick(1));
        btn2.addActionListener(e -> handleButtonClick(2));
        btn3.addActionListener(e -> handleButtonClick(3));

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void handleButtonClick(int choice) {
        selectedChoice = choice;
        choiceMade = true;
        dispose();
    }

    public int getSelectedChoice() {
        while (!choiceMade) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return selectedChoice;
    }
}