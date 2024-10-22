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

public class FenetreConnexionEmploye extends Fenetre{

    /**ATTRIBUT**/
    private JButton boutonConnexion =new JButton("CONNEXION");

    private Employe travailleurActuel;

    /**GETTER ET SETTER*/
    public JButton getBoutonConnexion(){ return boutonConnexion;}

    public Employe getTravailleurActuel() {
        return travailleurActuel;
    }


    /**CONSTRUCTEURS*/
    /** Construction du panneau **/
    private JPanel buildContentPane(){
        /** Création JPanel avec une image pour fond **/
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/connexionEmploye.png";
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
        boutonConnexion.setBounds(830,620,120,30);
        pan.add(boutonConnexion);
        pan.setLayout(null);
        pan.setBackground(new Color(182, 217, 217));
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreConnexionEmploye(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){
        super(listeClient, listeEmploye, listeVille, historique);
        this.travailleurActuel = new Employe();
        setTitle("Connexion De L'Employé"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /**METHODE*/
    /** Saisie les informations de connexion du client */
    public void ajoutComposant(){

        /** champ de saisie login et password **/
        JTextField login = new JTextField();
        login.setColumns(25);
        login.setBounds(390,355,150,30);

        JPasswordField password = new JPasswordField();
        password.setColumns(25);
        password.setBounds(480,455,150,30);

        panel.add(login);
        panel.add(password);

        /** récuperation du login et password rentrés pour se connecter **/
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                getTravailleurActuel().setId(login.getText());
            }
        });
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] mdp = password.getPassword();
                String passwordString = String.valueOf(mdp);
                getTravailleurActuel().setMdp(passwordString);
            }
        });
    }
}
