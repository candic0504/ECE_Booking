package fr.java.modele.dao;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FenetreModification extends Fenetre{


    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonReporting =new JButton("REPORTING");
    private JButton boutonRetour =new JButton("RETOUR");
    private JButton boutonModifier =new JButton("MODIFIER");

    /**variables de stockage*/
    private String ModifVille = new String();
    private Hebergement herbergementModifie;

    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonReporting() {return boutonReporting;}
    public JButton getBoutonRetour() {return boutonRetour;}
    public JButton getBoutonModifier() {return boutonModifier;}

    /**variables de stockage*/
    public String getModifVille() {return ModifVille;}
    public void setModifVille(String modifVille) {ModifVille = modifVille;}
    public Hebergement getHerbergementModifie() {return herbergementModifie;}
    public void setHerbergementModifie(Hebergement herbergementModifie) {this.herbergementModifie = herbergementModifie;}


    /**CONSTRUCTEURS*/
    /** Construction du panneau **/
    public JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/modif.png";
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
        boutonReporting.setBounds(10,10,150,30);
        pan.add(boutonReporting);
        boutonRetour.setBounds(10,600,100,30);
        pan.add(boutonRetour);
        boutonModifier.setBounds(850,600,100,30);
        pan.add(boutonModifier);
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreModification (ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Modifier d'une offre par un employé"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /** METHODES */
    /** Permet la modification des attributs souhaités d'un logement, en proposant tout d'abord tous les attributs commun, avant d'appeler une méthodes abstraites de la class hebergement */
    public void ajoutComposant(){


        /**Récupération de L'URL*/
        JLabel titreURL = new JLabel("URL de l'image : ");
        titreURL.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreURL.setBounds(150, 600, 600, 30);
        panel.add(titreURL);
        JTextField URL = new JTextField();
        URL.setColumns(25);
        URL.setBounds(350,600,500,30);
        panel.add(URL);
        URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHerbergementModifie().setURL(URL.getText());
            }
        });


        /**Récupération du nom*/
        JLabel titreNomLogement = new JLabel("Nom du Logement :  ");
        titreNomLogement.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreNomLogement.setBounds(100, 200, 300, 30);
        panel.add(titreNomLogement);
        JTextField nomLogement = new JTextField();
        nomLogement.setColumns(25);
        nomLogement.setBounds(300,200,600,30);
        panel.add(nomLogement);
        nomLogement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHerbergementModifie().setNom(nomLogement.getText());
            }
        });

        /**Récupération de l'adresse*/
        JLabel titreAdresseLogement = new JLabel("Adresse du Logement :  ");
        titreAdresseLogement.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreAdresseLogement.setBounds(100, 250, 300, 30);
        panel.add(titreAdresseLogement);
        JTextField adresseLogement = new JTextField();
        adresseLogement.setColumns(25);
        adresseLogement.setBounds(300,250,600,30);
        panel.add(adresseLogement);
        adresseLogement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHerbergementModifie().setAdresse(adresseLogement.getText());
            }
        });

        /**Récupération de la capacite du logement*/
        JLabel titreCapaciteLogement = new JLabel("Capacité du Logement :  ");
        titreCapaciteLogement.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreCapaciteLogement.setBounds(100, 300, 300, 30);
        panel.add(titreCapaciteLogement);
        JTextField capaciteLogement = new JTextField();
        capaciteLogement.setColumns(25);
        capaciteLogement.setBounds(300,300,150,30);
        panel.add(capaciteLogement);
        capaciteLogement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String capaciteLogementText = capaciteLogement.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getHerbergementModifie().setCapacite(Integer.parseInt(capaciteLogementText));
                }catch(NumberFormatException except){
                    getHerbergementModifie().setCapacite(1);
                }
            }
        });

        /**Récupération du nombre de chambre*/
        JLabel titreNombreChambre = new JLabel("Nombre de chambres :  ");
        titreNombreChambre.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreNombreChambre.setBounds(100, 350, 300, 30);
        panel.add(titreNombreChambre);
        JTextField nombreChambre = new JTextField();
        nombreChambre.setColumns(25);
        nombreChambre.setBounds(300,350,150,30);
        panel.add(nombreChambre);
        nombreChambre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreChambreText= nombreChambre.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getHerbergementModifie().setNombreDeChambre(Integer.parseInt(nombreChambreText));
                }catch(NumberFormatException except){
                    getHerbergementModifie().setNombreDeChambre(1);
                }
            }
        });

        /**Récupération du tarif pour un adulte*/
        JLabel titreTarifAdulteNuit = new JLabel("Tarif pour un adulte :  ");
        titreTarifAdulteNuit.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreTarifAdulteNuit.setBounds(100, 400, 300, 30);
        panel.add(titreTarifAdulteNuit);
        JTextField tarifAdulteNuit = new JTextField();
        tarifAdulteNuit.setColumns(25);
        tarifAdulteNuit.setBounds(300,400,150,30);
        panel.add(tarifAdulteNuit);
        tarifAdulteNuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tarifAdulteNuitText = tarifAdulteNuit.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getHerbergementModifie().setTarifUnAdulteUneNuit(Integer.parseInt(tarifAdulteNuitText));
                }catch(NumberFormatException except){
                    getHerbergementModifie().setTarifUnAdulteUneNuit(1);
                }
            }
        });

        /**Récupération du tarif pour un enfant*/
        JLabel titreTarifEnfantNuit = new JLabel("Tarif pour un enfant :  ");
        titreTarifEnfantNuit.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreTarifEnfantNuit.setBounds(100, 450, 300, 30);
        panel.add(titreTarifEnfantNuit);
        JTextField tarifEnfantNuit = new JTextField();
        tarifEnfantNuit.setColumns(25);
        tarifEnfantNuit.setBounds(300,450,150,30);
        panel.add(tarifEnfantNuit);
        tarifEnfantNuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tarifEnfantNuitText = tarifEnfantNuit.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getHerbergementModifie().setTarifUnEnfantUneNuit(Integer.parseInt(tarifEnfantNuitText));
                }catch(NumberFormatException except){
                    getHerbergementModifie().setTarifUnEnfantUneNuit(1);
                }
            }
        });


        /** Recuperation de la promo */
        JLabel titrePromotion = new JLabel("Promotion :  ");
        titrePromotion.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titrePromotion.setBounds(100, 500, 300, 30);
        panel.add(titrePromotion);
        JTextField promotion = new JTextField();
        promotion.setColumns(25);
        promotion.setBounds(300,500,150,30);
        panel.add(promotion);
        promotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String promotionText = promotion.getText();//on récup la valeur dans le champ Promotion
                try{
                    getHerbergementModifie().setPromotion(Integer.parseInt(promotionText));
                }catch(NumberFormatException except){
                    getHerbergementModifie().setPromotion(0);
                }
            }
        });

        /**recuperation booleen wifi*/
        JCheckBox wifi = new JCheckBox("WIFI ");
        wifi.setBounds(500,300, 150, 30);
        panel.add(wifi);
        wifi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = wifi.isSelected();
                getHerbergementModifie().getOptionSupplementairesProposees().setWifi(state);
            }
        });

        /**recuperation booleen serviceMenage*/
        JCheckBox serviceMenage = new JCheckBox("SERVICE DE MENAGE ");
        serviceMenage.setBounds(500, 330, 150, 30);
        panel.add(serviceMenage);
        serviceMenage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = serviceMenage.isSelected();
                getHerbergementModifie().getOptionSupplementairesProposees().setServiceMenage(state);
            }
        });

        /**recuperation booleen climatisation*/
        JCheckBox climatisation = new JCheckBox("CLIMATISATION  ");
        climatisation.setBounds(500,360, 150, 30);
        panel.add(climatisation);
        climatisation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = climatisation.isSelected();
                getHerbergementModifie().getOptionSupplementairesProposees().setClimatisation(state);
            }
        });

        /**recuperation booleen fumeur*/
        JCheckBox fumeur = new JCheckBox("FUMEUR ");
        fumeur.setBounds(650,300, 150, 30);
        panel.add(fumeur);
        fumeur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = fumeur.isSelected();
                getHerbergementModifie().getOptionSupplementairesProposees().setFumeur(state);
            }
        });

        /**recuperation booleen coffreFort*/
        JCheckBox coffreFort = new JCheckBox("COFFRE FORT ");
        coffreFort.setBounds(650, 330, 150, 30);
        panel.add(coffreFort);
        coffreFort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = coffreFort.isSelected();
                getHerbergementModifie().getOptionSupplementairesProposees().setCoffreFort(state);
            }
        });

        /**recuperation booleen parkingPrivee*/
        JCheckBox parkingPrivee = new JCheckBox("PARKING PRIVE  ");
        parkingPrivee.setBounds(800,300, 150, 30);
        panel.add(parkingPrivee);
        parkingPrivee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = parkingPrivee.isSelected();
                getHerbergementModifie().getOptionSupplementairesProposees().setParkingPrivee(state);
            }
        });

        /**recuperation booleen bar*/
        JCheckBox bar = new JCheckBox("BAR  ");
        bar.setBounds(800,330, 150, 30);
        panel.add(bar);
        bar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = bar.isSelected();
                getHerbergementModifie().getOptionSupplementairesProposees().setBar(state);
            }
        });

        /**Récupération de la description de la vue*/
        JLabel titreDescriptionVue = new JLabel("Description de la vue :  ");
        titreDescriptionVue.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreDescriptionVue.setBounds(100, 550, 600, 30);
        panel.add(titreDescriptionVue);
        JTextField DescriptionVue = new JTextField();
        DescriptionVue.setColumns(25);
        DescriptionVue.setBounds(300,550,600,30);
        panel.add(DescriptionVue);
        DescriptionVue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHerbergementModifie().getOptionSupplementairesProposees().setDescriptionDeLaVue(DescriptionVue.getText());
            }
        });

        getHerbergementModifie().modifierHebergement(panel);
    }

}
