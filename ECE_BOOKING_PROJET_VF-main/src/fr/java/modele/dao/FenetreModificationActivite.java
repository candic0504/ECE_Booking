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

public class FenetreModificationActivite  extends Fenetre {

    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonRetour = new JButton("RETOUR");
    private JButton boutonAjouter = new JButton("AJOUTER");
    /**variables de stockage des informations*/
    private Activite activiteAjoute = new Activite();


    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonRetour() {return boutonRetour;}
    public JButton getBoutonAjouter() {return boutonAjouter;}
    /**variables de stockage des informations*/
    public Activite getActiviteAjoute() {return activiteAjoute;}


    /**CONSTRUCTEUR*/
    /**Construction du panneau*/
    private JPanel buildContentPane() {
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/activites.png";
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
        boutonAjouter.setBounds(850,600,100,30);
        pan.add(boutonAjouter);
        boutonRetour.setBounds(10,600,100,30);
        pan.add(boutonRetour);
        this.panel = pan;
        return panel;
    }

    /**ouverture et parametres de la fenetre*/
    public FenetreModificationActivite(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat) {
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Plateforme ajout des activités pour le complexe hotelier"); //On donne un titre à l'application
        setSize(1000, 700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }



    /**METHODE*/
    /** Permet de modifier une activité */
    public void ajoutComposant() {

        JLabel titreActiviteNom = new JLabel("Nom de l'activité : ");
        titreActiviteNom.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActiviteNom.setBounds(100, 250, 250, 30);
        panel.add(titreActiviteNom);
        JTextField activiteNom = new JTextField();
        activiteNom.setColumns(25);
        activiteNom.setBounds(250, 250, 250, 30);
        panel.add(activiteNom);
        activiteNom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activiteNom.getText());
            }
        });

        JLabel titreActiviteType = new JLabel("Type : ");
        titreActiviteType.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActiviteType.setBounds(100, 300, 250, 30);
        panel.add(titreActiviteType);
        JTextField activiteType = new JTextField();
        activiteType.setColumns(25);
        activiteType.setBounds(250, 300, 250, 30);
        panel.add(activiteType);
        activiteType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activiteType.getText());
            }
        });

        JLabel titreActivitePres = new JLabel("Presentation : ");
        titreActivitePres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivitePres.setBounds(100, 350, 110, 30);
        panel.add(titreActivitePres);
        JTextField activitePres = new JTextField();
        activitePres.setColumns(25);
        activitePres.setBounds(250, 350, 600, 30);
        panel.add(activitePres);
        activitePres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activitePres.getText());
            }
        });

    }
}
