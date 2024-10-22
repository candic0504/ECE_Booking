package fr.java.modele.dao;

import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.Hebergement;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.HistoriqueReservation;
import fr.java.modele.dao.Fenetre;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class FenetreReportingChoixEmploye extends Fenetre {
    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonAnalyse =new JButton("ANALYSE");

    /**variable de stockage*/
    private Hebergement logement;
    private Ville villeEtudiee = new Ville();
    private int anneeEtudiee;

    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonAnalyse() {return boutonAnalyse;}
    /**variable de stockage*/
    public Hebergement getLogement() {return logement;}
    public void setLogement(Hebergement logement) {this.logement = logement;}
    public Ville getVilleEtudiee() {return villeEtudiee;}
    public void setVilleEtudiee(Ville villeEtudiee) {this.villeEtudiee = villeEtudiee;}
    public int getAnneeEtudiee() {return anneeEtudiee;}
    public void setAnneeEtudiee(int anneeEtudiee) {this.anneeEtudiee = anneeEtudiee;}
    /**CONSTRUCTEURS*/
    /** Construction du panneau **/
    public JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/choixReporting.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try{
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e) {
                    System.out.println("erreur image");
                }
                g.drawImage(image, 0, 0, this);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(199, 182, 217));
        getBoutonAnalyse().setBounds(850,600,100,30);
        pan.add(getBoutonAnalyse());
        this.panel=pan;
        return panel;
    }
    /** ouverture et parametres de la fenetre**/
    public FenetreReportingChoixEmploye(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Choisir les analysees" ); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }
    /**METHODES*/
    public void ajoutComposant(){
        JLabel titreAnnee = new JLabel("Année analysée");
        titreAnnee.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        titreAnnee.setBounds(320, 180, 170, 30);
        panel.add(titreAnnee);
        JTextField annee = new JTextField();
        annee.setColumns(25);
        annee.setBounds(510,180,150,30);
        panel.add(annee);
        annee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String anneeText = annee.getText();//on récup la valeur dans le champ NB Personne
                try{
                    setAnneeEtudiee(Integer.parseInt(anneeText));
                }catch(NumberFormatException except){
                    System.out.println("probleme de saisie");
                }
            }
        });

        /** CHOIX DE LA VILLE*/
        JComboBox<String> choixVille = new JComboBox<>();
        choixVille.addItem(" ");
        for (int i = 0; i < getListeVille().size(); i++) {
            choixVille.addItem(getListeVille().get(i).getNomVille());
        }
        choixVille.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String villeselectionne = choixVille.getSelectedItem().toString();
                System.out.println(villeselectionne);
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(villeselectionne)){
                        setVilleEtudiee(getListeVille().get(i));
                    }
                }

                /** CHOIX LOGEMENT EN FONCTION DE LA VILLE SELECTIONNEE*/
                final int[] logement = {0};
                JComboBox<String> choixLogement = (JComboBox<String>)e.getSource();
                choixLogement.removeAllItems();
                choixLogement.addItem(" ");
                for (int i = 0; i < getVilleEtudiee().getListeHebergement().size(); i++) {
                    choixLogement.addItem(getVilleEtudiee().getListeHebergement().get(i).getNom());
                }

                choixLogement.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        logement[0] = choixLogement.getSelectedIndex();
                        setLogement(getVilleEtudiee().getListeHebergement().get(logement[0]));
                    }
                });
                choixLogement.setBounds(475,250,150,30);
                panel.add(choixLogement);
            }
        });
        choixVille.setBounds(325,250,150,30);
        panel.add(choixVille);

    }
}