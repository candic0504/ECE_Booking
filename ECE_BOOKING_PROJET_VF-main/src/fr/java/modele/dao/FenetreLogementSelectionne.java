package fr.java.modele.dao;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.net.URL;

public class FenetreLogementSelectionne extends Fenetre{

    /** ATTRIBUTS */
    private JButton boutonReserver =new JButton("RESERVER");
    private Hebergement logementSelectionne;
    private RechercheReservation criteresDemandes;
    private Client utilisateurDuSite;


    /** ACCESSEURS */
    public JButton getBoutonReserver(){ return boutonReserver;}

    public Hebergement getLogementSelectionne() {
        return logementSelectionne;
    }

    public void setLogementSelectionne(Hebergement logementSelectionne) {
        this.logementSelectionne = logementSelectionne;
    }

    public Client getUtilisateurDuSite() {
        return utilisateurDuSite;
    }

    public void setUtilisateurDuSite(Client utilisateurDuSite) {
        this.utilisateurDuSite = utilisateurDuSite;
    }

    public RechercheReservation getCriteresDemandes() {
        return criteresDemandes;
    }

    public void setCriteresDemandes(RechercheReservation criteresDemandes) {
        this.criteresDemandes = criteresDemandes;
    }

    /** CONSTRUCTEURS */
    /** Construction du panneau **/
    private JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(218, 182, 182));
        boutonReserver.setBounds(830,620,120,30);
        pan.add(boutonReserver);
        this.panel=pan;
        return panel;
    }
    /** ouverture et parametres de la fenetre**/
    public FenetreLogementSelectionne(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Détail de l'offre"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        this.logementSelectionne = null;
        this.utilisateurDuSite = new Client();
        this.criteresDemandes = new RechercheReservation();
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /** METHODES */
    /** Affiche le logement selectionné en détails en appelant une méthodes abstraites de la class Hebergement */
    @Override
    public void ajoutComposant() {
        JPanel pan = getLogementSelectionne().afficherDetail(getCriteresDemandes(), getUtilisateurDuSite(), getLogementSelectionne().getURL());
        boutonReserver.setBounds(833,612-36,120,30);
        pan.add(boutonReserver);

        boolean trouve = false;
        int parcours = 0;

        while(!trouve)
        {
            for(int j=0 ; j<getListeVille().get(parcours).getListeHebergement().size() ; j++)
            {
                if(getListeVille().get(parcours).getListeHebergement().get(j).equals(getLogementSelectionne()))
                {
                    trouve = true;
                }
            }

            if(!trouve)
            {
                parcours++;
            }
        }


        /** ACTIVITE */
        JLabel activite = new JLabel("ACTIVITES PROPOSEES :");
        activite.setBounds(68, 486, 300, 30);
        activite.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        if (getListeVille().get(parcours).getActivitesAProximite().size() > 0) {
            int decalageAffichage = 0;
            for (int i = 0; i < getListeVille().get(parcours).getActivitesAProximite().size(); i++) {
                JLabel activiteRecup = new JLabel(getListeVille().get(parcours).getActivitesAProximite().get(i).toString());
                activiteRecup.setBounds(51, 522 + decalageAffichage, 400, 30);
                activiteRecup.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 10));
                pan.add(activiteRecup);
                decalageAffichage += 36;
            }
        }
        pan.add(activite);

        panel = pan;
        setContentPane(panel);
    }

    public void updateContentPane()
    {
        setContentPane(buildContentPane());
        ajoutComposant();
        validate();
        repaint();
    }
}