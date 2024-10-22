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

public class FenetreInscription extends Fenetre{

    /** ATTRIBUTS */
    private JButton boutonAccesPage = new JButton("VALIDER");
    private JButton boutonRetour = new JButton("RETOUR");
    private String nomSaisie;
    private String motDePasseSaisie;
    private String identifiantSaisie;
    private String prenomSaisie;


    /** ACCESSEURS */
    public void setMotDePasseSaisie(String motDePasseSaisie) {
        this.motDePasseSaisie = motDePasseSaisie;
    }

    public void setIdentifiantSaisie(String identifiantSaisie) {
        this.identifiantSaisie = identifiantSaisie;
    }

    public String getMotDePasseSaisie() {
        return motDePasseSaisie;
    }

    public String getIdentifiantSaisie() {
        return identifiantSaisie;
    }

    public String getNomSaisie() {
        return nomSaisie;
    }

    public String getPrenomSaisie() {
        return prenomSaisie;
    }

    public void setNomSaisie(String nomSaisie) {
        this.nomSaisie = nomSaisie;
    }

    public void setPrenomSaisie(String prenomSaisie) {
        this.prenomSaisie = prenomSaisie;
    }

    public JButton getBoutonAccesPage() {return boutonAccesPage;}
    public JButton getBoutonRetour(){return boutonRetour;}



    /** CONSTRUCTEURS */
    /** Construction du panneau **/
    private JPanel buildContentPane(){

        /** Création JPanel avec une image pour fond **/
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String nomChemin = "images/inscription.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e){
                    System.out.println("erreur image");
                }

                /**Image image = new ImageIcon("C:\\inscription.png").getImage();*/

                g.drawImage(image, -20, -30, this);
            }
        };

        boutonAccesPage.setBounds(830,620,100,30);
        pan.add(boutonAccesPage);
        boutonRetour.setBounds(10,620,120,30);
        pan.add(boutonRetour);
        pan.setLayout(null);
        pan.setBackground(new Color(253, 238, 223));
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreInscription(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("INSCRIPTION"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /** METHODES */
    /** Saisie des informations necessaires pour l'inscription d'un nouveau client */
    @Override
    public void ajoutComposant() {
       JTextField nom = new JTextField();
       JTextField prenom = new JTextField();
       JTextField id = new JTextField();
       JPasswordField mdp = new JPasswordField();

       nom.setColumns(25);
       nom.setBounds(385,170,100,30);
       prenom.setColumns(25);
       prenom.setBounds(436,270,100,30);
       id.setColumns(25);
       id.setBounds(436,365,100,30);
       mdp.setColumns(25);
       mdp.setBounds(460,465,100,30);

       panel.add(nom);
       panel.add(prenom);
       panel.add(id);
       panel.add(mdp);

       /** RECUPERATION DU NOM, PRENOM, ID et MDP RENTRES PAR L'UTILISATEUR */
       nom.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String name = nom.getText();
               setNomSaisie(name);
               System.out.println("Nom saisie : " + name);
           }
       });

        prenom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = prenom.getText();
                setPrenomSaisie(name);
                System.out.println("Prenom saisie : " + name);
            }
        });

        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = id.getText();
                setIdentifiantSaisie(name);
                System.out.println("Identifiant saisie : " + name);
            }
        });

        mdp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = mdp.getPassword();
                String passwordString = String.valueOf(password);
                setMotDePasseSaisie(passwordString);
                System.out.println("MDP saisie : " + passwordString);
            }
        });
    }
}
