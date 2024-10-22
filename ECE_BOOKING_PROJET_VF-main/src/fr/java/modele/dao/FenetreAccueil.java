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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FenetreAccueil extends Fenetre{

    /**ATTRIBUT DE LA CLASSE FILLE**/
    private JButton boutonAccesPage=new JButton("VALIDER");
    private boolean employe;
    private boolean client;


    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public boolean isEmploye() {
        return employe;
    }

    public void setEmploye(boolean employe) {
        this.employe = employe;
    }

    public JButton getBoutonAccesPage() {
        return boutonAccesPage;
    }


    /** CONSTRUCTEUR */
    /** Construction du panneau **/
    private JPanel buildContentPane(){

        /** Création JPanel avec une image pour fond **/
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String nomChemin = "images/accueil.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e){
                    System.out.println("erreur image");
                }

                g.drawImage(image, -20, -30, this);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(253, 238, 223));
        boutonAccesPage.setBounds(833,612,130,30);

        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreAccueil(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);

        this.employe=false;
        this.client=false;
        setTitle("Bienvenue sur Booking.ece");              /**On donne un titre à l'application*/
        setSize(1000,700);                      /**On donne une taille à notre fenêtre*/
        setLocationRelativeTo(null);                        /**On centre la fenêtre sur l'écran*/
        setResizable(true);                                 /**On interdit la redimensionnement de la fenêtre*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     /**On dit à l'application de se fermer lors du clic sur la croix*/

        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /** Affiche le premier choix du site, à savoir si l'utilisateur est un client ou un employe */
    public void ajoutComposant(){

        JLabel titre = new JLabel("Vous êtes ? ");
        titre.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        titre.setBounds(600, 300, 800, 20);


        JCheckBox Jclient = new JCheckBox("CLIENT ");
        Jclient.setBounds(760,295, 100, 30);
        JCheckBox Jemploye = new JCheckBox("EMPLOYE ");
        Jemploye.setBounds(760, 325, 100, 30);


        panel.add(titre);
        panel.add(Jclient);
        panel.add(Jemploye);
        panel.add(boutonAccesPage);


        /** lire la checkbox client */
        Jclient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Jclient.isSelected())
                {
                    Jclient.setSelected(true);
                    Jemploye.setSelected(false);
                    setClient(true);
                    setEmploye(false);
                }
            }
        });

        /** lire la checkbox employe */
        Jemploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Jemploye.isSelected())
                {
                    Jclient.setSelected(false);
                    Jemploye.setSelected(true);
                    setClient(false);
                    setEmploye(true);
                }
            }
        });
    }
}
