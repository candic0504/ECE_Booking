package fr.java.modele.dao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.HistoriqueReservation;

public class FenetreConnexion extends Fenetre{

    /**ATTRIBUT DE LA CLASSE FILLE**/
    private JButton boutonConnexion =new JButton("VALIDER");
    private JButton boutonRetour = new JButton("RETOUR");
    private String identifiantSaisie;
    private String motDePasseSaisie;
    private Client utilisateurDuSite;

    public JButton getBoutonConnexion(){ return boutonConnexion;}
    public JButton getBoutonRetour(){return boutonRetour;}

    public String getIdentifiantSaisie() {
        return identifiantSaisie;
    }

    public String getMotDePasseSaisie() {
        return motDePasseSaisie;
    }

    public void setIdentifiantSaisie(String identifiantSaisie) {
        this.identifiantSaisie = identifiantSaisie;
    }

    public void setMotDePasseSaisie(String motDePasseSaisie) {
        this.motDePasseSaisie = motDePasseSaisie;
    }

    public void setUtilisateurDuSite(Client utilisateurDuSite) {
        this.utilisateurDuSite = utilisateurDuSite;
    }

    public Client getUtilisateurDuSite() {
        return utilisateurDuSite;
    }

    /** Construction du panneau **/
    private JPanel buildContentPane(){
        /** Création JPanel avec une image pour fond **/
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String nomChemin = "images/connexion.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e){
                    System.out.println("erreur image");
                }

                g.drawImage(image, 0, 0, this);
            }
        };
        boutonConnexion.setBounds(830,620,120,30);
        pan.add(boutonConnexion);
        boutonRetour.setBounds(10,620,120,30);
        pan.add(boutonRetour);
        pan.setLayout(null);
        pan.setBackground(new Color(182, 217, 217));
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreConnexion(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);
        this.utilisateurDuSite = new Client();
        setTitle("Connexion"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /** METHODES */
    /** Saisie les informations de connexion du client */
    public void ajoutComposant(){

        /** champ de saisie login et password **/
        JTextField login = new JTextField();
        login.setColumns(25);
        login.setBounds(390,345,150,30);

        JPasswordField password = new JPasswordField();
        password.setColumns(25);
        password.setBounds(480,446,150,30);

        panel.add(login);
        panel.add(password);

        /** récuperation du login et password rentrés pour se connecter **/
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String test = login.getText();
             if(test.isEmpty())
             {
                 System.out.println("VIDE !");
             }
             else {
                 setIdentifiantSaisie(test);
                 System.out.println("AAAAAAAAA : " + test);
             }
            }
        });
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] mdp = password.getPassword();
                String passwordString = String.valueOf(mdp);
                setMotDePasseSaisie(passwordString);
            }
        });

    }
}
