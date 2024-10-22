package fr.java.modele.dao;

import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


/** Fenetre de fin de réservation d'un client */
public class FenetreQuitter extends Fenetre {

    private JButton boutonContinuer =new JButton("Retour à la page recherche");

    public JButton getBoutonContinuer() {
        return boutonContinuer;
    }


    /** Construction du panneau **/
    private JPanel buildContentPane( ){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String nomChemin = "images/validationReservation.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e){
                    System.out.println("erreur image");
                }

                g.drawImage(image, 0, 0, this);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(218, 182, 182));
        boutonContinuer.setBounds(400,50,200,30);
        pan.add(boutonContinuer);
        this.panel=pan;
        return panel;
    }
    /** ouverture et parametres de la fenetre**/
    public FenetreQuitter(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Détail de l'offre"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }
    @Override
    public void ajoutComposant() {

    }
}
