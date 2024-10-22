package fr.java.modele.dao;

import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.Hebergement;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.Analyse;
import fr.java.controleur.Reporting.HistoriqueReservation;
import fr.java.modele.dao.Fenetre;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FenetreReporting extends Fenetre {
    /**ATTRIBUT DE LA CLASSE FILLE**/
    /**bouton*/
    private JButton boutonHome =new JButton("HOME");
    /**variable de stockage*/
    private Hebergement logement;
    private Ville villeEtudiee = new Ville();
    private int anneeEtudiee;
    private Client utilisateurDuSite;


    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonHome() {return boutonHome;}
    /**variable de stockage*/
    public Hebergement getLogement() {return logement;}
    public void setLogement(Hebergement logement) {this.logement = logement;}
    public Ville getVilleEtudiee() {return villeEtudiee;}
    public void setVilleEtudiee(Ville villeEtudiee) {this.villeEtudiee = villeEtudiee;}
    public int getAnneeEtudiee() {return anneeEtudiee;}
    public void setAnneeEtudiee(int anneeEtudiee) {this.anneeEtudiee = anneeEtudiee;}

    public Client getUtilisateurDuSite() {
        return utilisateurDuSite;
    }

    public void setUtilisateurDuSite(Client utilisateurDuSite) {
        this.utilisateurDuSite = utilisateurDuSite;
    }

    /** Construction du panneau **/
    public JPanel buildContentPane(){
        JPanel pan = new JPanel();
        pan.setLayout(null);
        getBoutonHome().setBounds(10,10,100,30);
        pan.add(getBoutonHome());
        this.panel=pan;
        return panel;
    }


    /** ouverture et parametres de la fenetre**/
    public FenetreReporting(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);
        this.utilisateurDuSite = new Client();
        setTitle("Statistiques des données de Booking.ece"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    public void ajoutComposant(){
        Analyse etudeClient = new Analyse();

        /**APPELLATION DES METHODES*/
        ChartPanel etoileLogementPanel = etudeClient.camembergEtoile(getLogement());
        ChartPanel logementVillePanel = etudeClient.camembergLogementVille(getVilleEtudiee(), getHistorique(), getAnneeEtudiee());
        ChartPanel graphPanel = etudeClient.graphAchatClient(getUtilisateurDuSite(), getHistorique(), getAnneeEtudiee());
        /**STOCKAGE ET POSITIONNEMENT DES DIAGRAMMES DANS LE PANEL*/
        etoileLogementPanel.setPreferredSize(new java.awt.Dimension(500,250));
        etoileLogementPanel.setBounds(500,50,500,250);
        panel.add(etoileLogementPanel);

        logementVillePanel.setPreferredSize(new java.awt.Dimension(500,250));
        logementVillePanel.setBounds(0,50,500,250);
        panel.add(logementVillePanel);

        graphPanel.setPreferredSize(new java.awt.Dimension(1000,350));
        graphPanel.setBounds(0,300,1000,350);
        panel.add(graphPanel);
    }
}
