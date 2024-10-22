package fr.java.modele.dao;

import fr.java.controleur.Recherche.Aeroport;
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

public class FenetreAjouterAeroport extends Fenetre{

    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonAjouter =new JButton("AJOUTER");
    private JButton boutonRetour =new JButton("RETOUR");

    /**variable de stockage*/
    private String villeModifie = new String();
    private Aeroport aeroportAjoute = new Aeroport();


    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonAjouter() {return boutonAjouter;}
    public JButton getBoutonRetour() {return boutonRetour;}

    /**variable de stockage*/
    public void setVilleModifie(String villeModifie) {this.villeModifie = villeModifie;}
    public Aeroport getAeroportAjoute() {return aeroportAjoute;}


    /**CONSTRUCTEURS*/
    /** Construction du panneau **/
    public JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/ajouterAeroport.png";
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
        getBoutonAjouter().setBounds(850,600,100,30);
        pan.add(getBoutonAjouter());
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreAjouterAeroport(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Ajout d'un aeroport"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /**METHODES*/
    /** permet la création d'un nouvel aeroport dans une ville */
    public void ajoutComposant(){

        JLabel titreNom = new JLabel("Nom Aeroport");
        titreNom.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        titreNom.setBounds(325, 166, 150, 30);
        panel.add(titreNom);
        JTextField Nom = new JTextField();
        Nom.setColumns(25);
        Nom.setBounds(510,166,150,30);
        panel.add(Nom);
        Nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAeroportAjoute().setNomAeroport(Nom.getText());
            }
        });

        JCheckBox international = new JCheckBox("INTERNATIONAL ");
        international.setBounds(480,220, 150, 30);
        panel.add(international);
        international.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = international.isSelected();
                if (state) {
                    getAeroportAjoute().setEstInternational(true);
                } else {
                    getAeroportAjoute().setEstInternational(false);
                }
            }
        });
    }
}