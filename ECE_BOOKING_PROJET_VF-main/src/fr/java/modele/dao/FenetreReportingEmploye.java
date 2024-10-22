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
import java.util.ArrayList;

public class FenetreReportingEmploye extends Fenetre {
    /**ATTRIBUT DE LA CLASSE FILLE**/
    /**bouton*/
    private JButton boutonHome =new JButton("HOME");
    /**variable de stockage*/
    private Hebergement logement;
    private Ville villeEtudiee = new Ville();
    private int anneeEtudiee;
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
    public FenetreReportingEmploye(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Statistiques des données de Booking.ece"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }
    public void ajoutComposant(){
        Analyse etudeEmploye = new Analyse();
        /**APPELLATION DES METHODES*/
        ChartPanel etoileLogementPanel = etudeEmploye.camembergEtoile(getLogement());
        ChartPanel logementVillePanel = etudeEmploye.camembergLogementVille(getVilleEtudiee(), getHistorique(), getAnneeEtudiee());
        ChartPanel graphPanel = etudeEmploye.graphVentesTotales(getHistorique(), getAnneeEtudiee());
        ChartPanel reductionsPanel = etudeEmploye.graphVentesReductions(getHistorique(), getAnneeEtudiee());
        /**STOCKAGE DES DIAGRAMMES DANS LE PANEL*/
        etoileLogementPanel.setPreferredSize(new java.awt.Dimension(500,150));
        etoileLogementPanel.setBounds(500,250,495,150);
        panel.add(etoileLogementPanel);


        logementVillePanel.setPreferredSize(new java.awt.Dimension(500,150));
        logementVillePanel.setBounds(0,250,500,150);
        panel.add(logementVillePanel);


        graphPanel.setPreferredSize(new java.awt.Dimension(1000,200));
        graphPanel.setBounds(0,50,1000,200);
        panel.add(graphPanel);


        reductionsPanel.setPreferredSize(new java.awt.Dimension(1000,200));
        reductionsPanel.setBounds(0,400,1000,200);
        panel.add(reductionsPanel);

    }
}
