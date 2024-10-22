package fr.java.modele.dao;

import fr.java.controleur.MiseAJour.Paiement;
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
import java.util.Calendar;

public class FenetrePayement extends Fenetre{
    private JButton boutonReserver =new JButton("PAYER");
    private Paiement payementLogement;


    public Paiement getPayementLogement() {
        return payementLogement;
    }

    public void setPayementLogement(Paiement payementLogement) {
        this.payementLogement = payementLogement;
    }

    public JButton getBoutonReserver() {
        return boutonReserver;
    }



    /** Construction du panneau **/
    private JPanel buildContentPane( ){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String nomChemin = "images/paiement.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e){
                    System.out.println("erreur image");
                }

                /**Image image = new ImageIcon("C:\\paiement.png").getImage();*/
                g.drawImage(image, 0, 0, this);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(218, 182, 182));
        boutonReserver.setBounds(830,620,120,30);
        pan.add(boutonReserver);
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetrePayement(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);
        this.payementLogement = new Paiement();
        setTitle("Détail de l'offre"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /** Saisie des informations pour un payement */
    @Override
    public void ajoutComposant() {
      JTextField numeroBancaire = new JTextField();
      numeroBancaire.setBounds(445,230,200,30);
      panel.add(numeroBancaire);

      JPasswordField cvv = new JPasswordField();
      cvv.setBounds(237,450,30,30);
      panel.add(cvv);


        /** récuperation des informations de payement **/
        numeroBancaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paiement nouveau = getPayementLogement();
                String test = numeroBancaire.getText();
                if(test.isEmpty())
                {
                    System.out.println("VIDE !");
                }
                else {
                    nouveau.setNumeroCarteBancaire(Long.parseLong(test));
                    setPayementLogement(nouveau);
                    System.out.println("AAAAAAAAA : " + getPayementLogement().getNumeroCarteBancaire());
                }
            }
        });

        cvv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paiement nouveau = getPayementLogement();
                char[] mdp = cvv.getPassword();
                String passwordString = String.valueOf(mdp);
                nouveau.setNumeroDeSecurite(Integer.parseInt(passwordString));
                setPayementLogement(nouveau);
                System.out.println("AAAAAAAAA : " + getPayementLogement().getNumeroDeSecurite());
            }
        });

        /** DATE EXPIRATION */
        Integer[] mois = new Integer[12];
        for(int i =0;i< mois.length;i++){
            mois[i]=i+1;
        }
        Integer[] annee = new Integer[10];
        for(int i=0 ; i<annee.length ; i++)
        {
            annee[i]=2023+i;
        }
        JComboBox<Integer> moisExpiration = new JComboBox<>(mois);
        JComboBox<Integer> anneeExpiration = new JComboBox<>(annee);
        moisExpiration.setBounds(525, 341, 50, 30);
        anneeExpiration.setBounds(580, 341, 80, 30);
        panel.add(moisExpiration);
        panel.add(anneeExpiration);

        /**RECUPERATION DATE EXPIRATION */
        moisExpiration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paiement nouveau = getPayementLogement();
                Calendar dateExpiration = nouveau.getDateExpirationDeLaCarte();
                String moisA = moisExpiration.getSelectedItem().toString();
                dateExpiration.set(Calendar.MONTH, Integer.parseInt(moisA)-1);
                nouveau.setDateExpirationDeLaCarte(dateExpiration);
                setPayementLogement(nouveau);
                System.out.println("Date d'arrive saisie : " + (getPayementLogement().getDateExpirationDeLaCarte().get(Calendar.MONTH)+1) + "/" + getPayementLogement().getDateExpirationDeLaCarte().get(Calendar.YEAR));
            }
        });

        anneeExpiration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paiement nouveau = getPayementLogement();
                Calendar dateExpiration = nouveau.getDateExpirationDeLaCarte();
                String anneeA = anneeExpiration.getSelectedItem().toString();
                dateExpiration.set(Calendar.YEAR, Integer.parseInt(anneeA));
                nouveau.setDateExpirationDeLaCarte(dateExpiration);
                setPayementLogement(nouveau);
                System.out.println("Date d'arrive saisie : " + (getPayementLogement().getDateExpirationDeLaCarte().get(Calendar.MONTH)+1) + "/" + getPayementLogement().getDateExpirationDeLaCarte().get(Calendar.YEAR));            }
        });
    }
}
