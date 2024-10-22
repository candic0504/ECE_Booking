package fr.java.modele.dao;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class FenetreActiviteVille extends Fenetre{

    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonAjouter =new JButton("AJOUTER UNE ACTIVITE");
    private JButton boutonRetour = new JButton("RETOUR");
    private JButton boutonSupprimer =new JButton("SUPPRIMER UNE ACTIVITE");
    private JButton boutonModifier =new JButton("MODIFIER UNE ACTIVITE");
    /**variable de stockage*/
    private String villeModifie = new String();
    private Activite activiteSupp = new Activite();
    private Activite activiteAjoute = new Activite();

    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonAjouter() {return boutonAjouter;}
    public JButton getBoutonRetour() {return boutonRetour;}
    public JButton getBoutonSupprimer() {return boutonSupprimer;}
    public JButton getBoutonModifier() {return boutonModifier;}

    /**variable de stockage*/
    public String getVilleModifie() {return villeModifie;}
    public void setVilleModifie(String villeModifie) {this.villeModifie = villeModifie;}


    /**CONSTRUCTEURS*/
    /** Construction du panneau **/
    public JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/Villeactivites.png";
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
        getBoutonRetour().setBounds(10,600,100,30);
        pan.add(getBoutonRetour());
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreActiviteVille(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Choix d'action de l'employé"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /**METHODES*/
    /** donne le choix à l'employé de Modifier, Supprimer, ou Ajouter une activite à une ville */
    public void ajoutComposant(){

        JLabel nomVille = new JLabel(getVilleModifie());
        nomVille.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 30));
        nomVille.setBounds(200, 300, 600, 30);
        panel.add(nomVille);

        /**AFFICHAGE DES CHOIX*/
        getBoutonModifier().setBounds(175,400,200,30);
        panel.add(getBoutonModifier());
        getBoutonAjouter().setBounds(400,400,200,30);
        panel.add(getBoutonAjouter());
        getBoutonSupprimer().setBounds(615,400,200,30);
        panel.add(getBoutonSupprimer());
    }
}


