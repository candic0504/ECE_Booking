package fr.java.modele.dao;

import fr.java.controleur.Recherche.Aeroport;
import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class FenetreChoisirTransport extends Fenetre {
    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonAjouter = new JButton("AJOUTER UN AEROPORT");
    private JButton boutonRetour = new JButton("RETOUR");
    /**variable de stockage*/
    private Ville villeEtudiee = new Ville();

    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonAjouter() {return boutonAjouter;}
    public JButton getBoutonRetour() {return boutonRetour;}
    /**variable de stockage*/
    public Ville getvilleEtudiee() {return villeEtudiee;}
    public void setvilleEtudiee(Ville villeModifie) {this.villeEtudiee = villeModifie;}


    /**CONSTRUCTEURS*/
    /**Construction du panneau*/
    public JPanel buildContentPane() {
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/selection.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                } catch (java.io.IOException e) {
                    System.out.println("erreur image");
                }
                g.drawImage(image, 0, 0, this);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(199, 182, 217));
        getBoutonRetour().setBounds(10,600,100,30);
        pan.add(getBoutonRetour());
        this.panel=pan;
        return panel;
    }

    /**ouverture et parametres de la fenetre*/
    public FenetreChoisirTransport(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat) {
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Choisir un transport"); //On donne un titre à l'application
        setSize(1000, 700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /**METHODES*/
    public void ajoutComposant() {
    }

    /** permet de visualiser tous les transports d'une ville*/
    public JTable ajoutComposant2() {

        /** REMPLIR LES DONNEES GRACE A L'ARRAYLISTE REMPLIT EN FONCTION DE LA VILLE ET DU TYPE DE LOGEMENT*/
        Object [][] donnee = new Object[getvilleEtudiee().getTransportDansLaVille().size()][12];

        for(int i=0;i<getvilleEtudiee().getTransportDansLaVille().size();i++){
            donnee[i][0]=getvilleEtudiee().getTransportDansLaVille().get(i).getTypeDeTransport();
            donnee[i][1]=getvilleEtudiee().getTransportDansLaVille().get(i).getNomTransport();
            for(int j = 1 ; j<getvilleEtudiee().getTransportDansLaVille().get(i).getTrajetDuTransport().size()+1 ; j++)
            {
                donnee[i][j+1]=getvilleEtudiee().getTransportDansLaVille().get(i).getTrajetDuTransport().get(j);
            }
        }
        /** CREATION DU MODELE DE DONNEES POUR LA TABLE */
        DefaultTableModel tab = new DefaultTableModel(donnee, new Object[]{"Nom","Type","Station 1","Station 2","Station 3","Station 4","Station 5","Station 6","Station 7","Station 8","Station 9","Station 10"});
        /** CREATION DE LA TABLE COMPRENANT LES OFFRES */
        JTable table = new JTable(tab);
        /** PARAMETRE DE LA TABLE */
        table.setRowHeight(50);
        table.setShowGrid(true);
        table.setBackground(new Color(199, 182, 217));
        table.setBounds(50,200,900,300); /**taille de la table*/

        /** AJOUT SCROLL BAR SUR CHAQUE TABLE */
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50,200,900,300);/**taille du composant*/
        panel.add(scroll);/**ajout du composant au panel*/

        return table;
    }
}
