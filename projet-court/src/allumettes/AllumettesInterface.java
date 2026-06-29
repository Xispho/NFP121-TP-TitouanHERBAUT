package allumettes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class AllumettesInterface extends JFrame {

    private final Object verrou = new Object();
    private int choix = 0;

    private JLabel nbAllumetteLabel;
    private JButton btnTricher;
    private JTextField nbTriche;
    private JButton btnPriseUn;
    private JButton btnPriseDeux;
    private JButton btnPriseTrois;

    public AllumettesInterface() {
        //Constantes
        int WIDTH = 300;
        int HEIGHT = 300;
        int GRID_COLUMNS = 3;
        int GRID_HGAP = 5;

        setTitle("[joueur] ?");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        btnTricher = new JButton("tricher");
        nbTriche = new JTextField("", 2);
        JPanel topPanel = new JPanel();
        topPanel.add(btnTricher);
        topPanel.add(nbTriche);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        nbAllumetteLabel = new JLabel("13", SwingConstants.CENTER);
        mainPanel.add(nbAllumetteLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, GRID_COLUMNS, GRID_HGAP, 0));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        btnPriseUn = new JButton("1");
        btnPriseDeux = new JButton("2");
        btnPriseTrois = new JButton("3");

        btnPriseUn.addActionListener(e -> handleButtonClick(1));
        btnPriseDeux.addActionListener(e -> handleButtonClick(2));
        btnPriseTrois.addActionListener(e -> handleButtonClick(3));

        buttonPanel.add(btnPriseUn);
        buttonPanel.add(btnPriseDeux);
        buttonPanel.add(btnPriseTrois);
    }

    public int getPrise(Jeu jeu, Joueur joueur) {
        btnTricher.addActionListener(e -> handleButtonTricher(jeu));
        setTitle(joueur.getNom());
        choix = 0;
        updateButtons(jeu);
        updateNbAllumette(jeu);
        setVisible(true);
        synchronized (verrou) {
            while (choix == 0) {
                try {
                    verrou.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        setVisible(false);
        return choix;
    }

    private void handleButtonTricher(Jeu jeu) {
        synchronized (verrou) {
            int nb = Integer.parseInt(nbTriche.getText());
            System.out.println("[Je triche... " + nb + " allumettes en moins]\n");
            for (int i = 0; i < nb; i++) {
                try {
                    jeu.retirer(1);
                } catch (CoupInvalideException e) {
                    break;
                }
            }
            updateButtons(jeu);
            updateNbAllumette(jeu);
        }
    }

    private void handleButtonClick(int nb) {
        synchronized (verrou) {
            choix = nb;
            verrou.notify();
        }
    }

    private void updateNbAllumette(Jeu jeu) {
        nbAllumetteLabel.setText(String.valueOf(jeu.getNombreAllumettes()));
    }

    private void updateButtons(Jeu jeu) {
        int n = jeu.getNombreAllumettes();
        btnPriseUn.setEnabled(n >= 1);
        btnPriseDeux.setEnabled(n >= 2);
        btnPriseTrois.setEnabled(n >= 3);
    }
}
