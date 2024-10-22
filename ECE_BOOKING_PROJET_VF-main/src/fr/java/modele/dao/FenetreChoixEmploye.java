package fr.java.modele.dao;

import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class FenetreChoixEmploye  extends Fenetre{
    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonReporting =new JButton("REPORTING");
    private JButton boutonAjouter =new JButton("AJOUTER UN LOGEMENT");
    private JButton boutonSupprimer =new JButton("SUPPRIMER UN LOGEMENT");
    private JButton boutonModifier =new JButton("MODIFIER UN LOGEMENT");
    private JButton boutonTransport =new JButton("MODIFIER LES TRANSPORTS");
    private JButton boutonAeroport =new JButton("MODIFIER LES AEROPORTS");
    private JButton boutonActivite =new JButton("MODIFIER LES ACTIVITES");
    /**variable de stockage*/
    private String typeLogement = new String();
    private String villeModifie = new String();


    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonReporting() {return boutonReporting;}
    public JButton getBoutonAjouter() {return boutonAjouter;}
    public JButton getBoutonSupprimer() {return boutonSupprimer;}
    public JButton getBoutonModifier() {return boutonModifier;}
    public JButton getBoutonTransport() {return boutonTransport;}
    public JButton getBoutonAeroport() {return boutonAeroport;}
    public JButton getBoutonActivite() {return boutonActivite;}

    /**variable de stockage*/
    public String getTypeLogement() {return typeLogement;}
    public void setTypeLogement(String typeLogement) {this.typeLogement = typeLogement;}
    public String getVilleModifie() {return villeModifie;}
    public void setVilleModifie(String villeModifie) {this.villeModifie = villeModifie;}


    /**CONSTRUCTEURS*/
    /** Construction du panneau **/
    public JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/menu.png";
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
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreChoixEmploye(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){
        super(listeClient, listeEmploye, listeVille, historique);

        this.typeLogement = new String();
        this.villeModifie = new String();

        setTitle("Choix d'action de l'employé"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /**METHODES*/
    /** L'écran principal de l'employé, qui le dirige vers chaque action */
    public void ajoutComposant(){

        boutonReporting.setBounds(10,10,150,30);
        panel.add(boutonReporting);

        /**MENU DEROULANT CHOIX DE LA VILLE*/
        String[] choixVille = new String[getListeVille().size()];
        for(int i=0 ; i<choixVille.length ; i++)
        {
            choixVille[i] = getListeVille().get(i).getNomVille();
        }
        JComboBox<String> ville = new JComboBox<>(choixVille);
        ville.setBounds(250,300,150,30);
        JLabel titreVille = new JLabel("Choix de la ville :  ");
        titreVille.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreVille.setBounds(250, 270, 200, 20);
        panel.add(ville);
        panel.add(titreVille);
        ville.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVilleModifie((String)ville.getSelectedItem());//on récup la valeur dans le champ NB Personne
            }
        });

        /**MENU DEROULANT DU TYPE DE LOGEMENT*/
        String[] options = { "Tous","Appartement","Chalet","Complexe Hotelier","Hotel","Maison","Villa",};
        JComboBox<String> categorie = new JComboBox<>(options);
        categorie.setBounds(600,300,150,30);
        JLabel titreCategorie = new JLabel("Type de logement :  ");
        titreCategorie.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreCategorie.setBounds(600, 270, 200, 20);
        panel.add(categorie);
        panel.add(titreCategorie);

        categorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTypeLogement((String)categorie.getSelectedItem());//on récup la valeur dans le champ NB Personne
            }
        });

        /**AFFICHAGE DES CHOIX*/
        getBoutonModifier().setBounds(175,350,225,30);
        panel.add(getBoutonModifier());
        getBoutonAjouter().setBounds(400,350,225,30);
        panel.add(getBoutonAjouter());
        getBoutonSupprimer().setBounds(615,350,225,30);
        panel.add(getBoutonSupprimer());
        getBoutonAeroport().setBounds(175,400,225,30);
        panel.add(getBoutonAeroport());
        getBoutonTransport().setBounds(400,400,225,30);
        panel.add(getBoutonTransport());
        getBoutonActivite().setBounds(625,400,225,30);
        panel.add(getBoutonActivite());
    }
}
