package fr.java.modele.dao;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Recherche.Maison;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class FenetreAjouterOffre extends Fenetre{

    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonReporting =new JButton("REPORTING");
    private JButton boutonRetour =new JButton("RETOUR");
    private JButton boutonAjouter =new JButton("AJOUTER");
    private JButton boutonActivite =new JButton("AJOUTER ACTIVITE");

    /**variables de stockage*/
    private String typeLogementAjoute = new String();
    private String ajoutVille = new String();
    private Appartement appartementAjoute = new Appartement();
    private Chalet chaletAjoute = new Chalet();
    private ComplexeHotelier ComplexeHotelierAjoute = new ComplexeHotelier();
    private Hotel hotelAjoute = new Hotel();
    private Maison maisonAjoutee = new Maison();
    private Villa villaAjoutee = new Villa();
    private ArrayList<Activite> activite = new ArrayList<>();

    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonRetour() {return boutonRetour;}
    public JButton getBoutonAjouter() {return boutonAjouter;}
    public JButton getBoutonActivite() {return boutonActivite;}

    /**variables de stockage*/
    public void setAjoutVille(String ajoutVille) {this.ajoutVille = ajoutVille;}
    public String getAjoutVille() {return ajoutVille;}
    public Appartement getAppartementAjoute() {return appartementAjoute;}
    public Chalet getChaletAjoute() {return chaletAjoute;}
    public ComplexeHotelier getComplexeHotelierAjoute() {return ComplexeHotelierAjoute;}
    public Hotel getHotelAjoute() {return hotelAjoute;}
    public Maison getMaisonAjoutee() {return maisonAjoutee;}
    public Villa getVillaAjoutee() {return villaAjoutee;}
    public ArrayList<Activite> getActivite() {return activite;}
    public void setActivite(ArrayList<Activite> activite) {this.activite = activite;}

    /** CONSTRUCTEURS*/
    /** Construction du panneau **/
    public JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/ajout.png";
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
        boutonReporting.setBounds(10,10,150,30);
        pan.add(boutonReporting);
        boutonRetour.setBounds(10,600,100,30);
        panel.add(boutonRetour);

        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreAjouterOffre (ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Ajout d'une offre par un employé"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /**METHODES*/
    /** Permet de saisir les inforamtions d'un nouveau logement, et cela en fonction de la catégorie du logement voulu*/
    public void ajoutComposant(){

        /**Recuperation de l'url de l'image*/
        JLabel titreURL = new JLabel("URL de l'image : ");
        titreURL.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreURL.setBounds(150, 600, 600, 30);
        panel.add(titreURL);
        JTextField URL = new JTextField();
        URL.setColumns(25);
        URL.setBounds(350,600,400,30);
        panel.add(URL);
        URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAppartementAjoute().setURL(URL.getText());
                getChaletAjoute().setURL(URL.getText());
                getComplexeHotelierAjoute().setURL(URL.getText());
                getHotelAjoute().setURL(URL.getText());
                getMaisonAjoutee().setURL(URL.getText());
                getVillaAjoutee().setURL(URL.getText());
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
                getAppartementAjoute().setNom(nomLogement.getText());
                getChaletAjoute().setNom(nomLogement.getText());
                getComplexeHotelierAjoute().setNom(nomLogement.getText());
                getHotelAjoute().setNom(nomLogement.getText());
                getMaisonAjoutee().setNom(nomLogement.getText());
                getVillaAjoutee().setNom(nomLogement.getText());
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
                getAppartementAjoute().setAdresse(adresseLogement.getText());
                getChaletAjoute().setAdresse(adresseLogement.getText());
                getComplexeHotelierAjoute().setAdresse(adresseLogement.getText());
                getHotelAjoute().setAdresse(adresseLogement.getText());
                getMaisonAjoutee().setAdresse(adresseLogement.getText());
                getVillaAjoutee().setAdresse(adresseLogement.getText());

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
                    getAppartementAjoute().setCapacite(Integer.parseInt(capaciteLogementText));
                    getChaletAjoute().setCapacite(Integer.parseInt(capaciteLogementText));
                    getComplexeHotelierAjoute().setCapacite(Integer.parseInt(capaciteLogementText));
                    getHotelAjoute().setCapacite(Integer.parseInt(capaciteLogementText));
                    getMaisonAjoutee().setCapacite(Integer.parseInt(capaciteLogementText));
                    getVillaAjoutee().setCapacite(Integer.parseInt(capaciteLogementText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setCapacite(1);
                    getChaletAjoute().setCapacite(1);
                    getComplexeHotelierAjoute().setCapacite(1);
                    getHotelAjoute().setCapacite(1);
                    getMaisonAjoutee().setCapacite(1);
                    getVillaAjoutee().setCapacite(1);
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
                    getAppartementAjoute().setNombreDeChambre(Integer.parseInt(nombreChambreText));
                    getChaletAjoute().setNombreDeChambre(Integer.parseInt(nombreChambreText));
                    getComplexeHotelierAjoute().setNombreDeChambre(Integer.parseInt(nombreChambreText));
                    getHotelAjoute().setNombreDeChambre(Integer.parseInt(nombreChambreText));
                    getMaisonAjoutee().setNombreDeChambre(Integer.parseInt(nombreChambreText));
                    getVillaAjoutee().setNombreDeChambre(Integer.parseInt(nombreChambreText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setNombreDeChambre(1);
                    getChaletAjoute().setNombreDeChambre(1);
                    getComplexeHotelierAjoute().setNombreDeChambre(1);
                    getHotelAjoute().setNombreDeChambre(1);
                    getMaisonAjoutee().setNombreDeChambre(1);
                    getVillaAjoutee().setNombreDeChambre(1);
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
                    getAppartementAjoute().setTarifUnAdulteUneNuit(Integer.parseInt(tarifAdulteNuitText));
                    getChaletAjoute().setTarifUnAdulteUneNuit(Integer.parseInt(tarifAdulteNuitText));
                    getComplexeHotelierAjoute().setTarifUnAdulteUneNuit(Integer.parseInt(tarifAdulteNuitText));
                    getHotelAjoute().setTarifUnAdulteUneNuit(Integer.parseInt(tarifAdulteNuitText));
                    getMaisonAjoutee().setTarifUnAdulteUneNuit(Integer.parseInt(tarifAdulteNuitText));
                    getVillaAjoutee().setTarifUnAdulteUneNuit(Integer.parseInt(tarifAdulteNuitText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setTarifUnAdulteUneNuit(1);
                    getChaletAjoute().setTarifUnAdulteUneNuit(1);
                    getComplexeHotelierAjoute().setTarifUnAdulteUneNuit(1);
                    getHotelAjoute().setTarifUnAdulteUneNuit(1);
                    getMaisonAjoutee().setTarifUnAdulteUneNuit(1);
                    getVillaAjoutee().setTarifUnAdulteUneNuit(1);
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
                    getAppartementAjoute().setTarifUnEnfantUneNuit(Integer.parseInt(tarifEnfantNuitText));
                    getChaletAjoute().setTarifUnEnfantUneNuit(Integer.parseInt(tarifEnfantNuitText));
                    getComplexeHotelierAjoute().setTarifUnEnfantUneNuit(Integer.parseInt(tarifEnfantNuitText));
                    getHotelAjoute().setTarifUnEnfantUneNuit(Integer.parseInt(tarifEnfantNuitText));
                    getMaisonAjoutee().setTarifUnEnfantUneNuit(Integer.parseInt(tarifEnfantNuitText));
                    getVillaAjoutee().setTarifUnEnfantUneNuit(Integer.parseInt(tarifEnfantNuitText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setTarifUnEnfantUneNuit(1);
                    getChaletAjoute().setTarifUnEnfantUneNuit(1);
                    getComplexeHotelierAjoute().setTarifUnEnfantUneNuit(1);
                    getHotelAjoute().setTarifUnEnfantUneNuit(1);
                    getMaisonAjoutee().setTarifUnEnfantUneNuit(1);
                    getVillaAjoutee().setTarifUnEnfantUneNuit(1);
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
                    getAppartementAjoute().setPromotion(Integer.parseInt(promotionText));
                    getChaletAjoute().setPromotion(Integer.parseInt(promotionText));
                    getComplexeHotelierAjoute().setPromotion(Integer.parseInt(promotionText));
                    getHotelAjoute().setPromotion(Integer.parseInt(promotionText));
                    getMaisonAjoutee().setPromotion(Integer.parseInt(promotionText));
                    getVillaAjoutee().setPromotion(Integer.parseInt(promotionText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setPromotion(1);
                    getChaletAjoute().setPromotion(1);
                    getComplexeHotelierAjoute().setPromotion(1);
                    getHotelAjoute().setPromotion(1);
                    getMaisonAjoutee().setPromotion(1);
                    getVillaAjoutee().setPromotion(1);
                }
            }
        });

        /** Recupération des options supplémentaires*/
        /**recuperation booleen wifi*/
        JCheckBox wifi = new JCheckBox("WIFI ");
        wifi.setBounds(500,300, 150, 30);
        panel.add(wifi);
        wifi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = wifi.isSelected();
                if(state){
                    getAppartementAjoute().getOptionSupplementairesProposees().setWifi(true);
                    getChaletAjoute().getOptionSupplementairesProposees().setWifi(true);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setWifi(true);
                    getHotelAjoute().getOptionSupplementairesProposees().setWifi(true);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setWifi(true);
                    getVillaAjoutee().getOptionSupplementairesProposees().setWifi(true);
                } else {
                    getAppartementAjoute().getOptionSupplementairesProposees().setWifi(false);
                    getChaletAjoute().getOptionSupplementairesProposees().setWifi(false);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setWifi(false);
                    getHotelAjoute().getOptionSupplementairesProposees().setWifi(false);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setWifi(false);
                    getVillaAjoutee().getOptionSupplementairesProposees().setWifi(false);
                }
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
                if(state){
                    getAppartementAjoute().getOptionSupplementairesProposees().setServiceMenage(true);
                    getChaletAjoute().getOptionSupplementairesProposees().setServiceMenage(true);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setServiceMenage(true);
                    getHotelAjoute().getOptionSupplementairesProposees().setServiceMenage(true);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setServiceMenage(true);
                    getVillaAjoutee().getOptionSupplementairesProposees().setServiceMenage(true);
                } else {
                    getAppartementAjoute().getOptionSupplementairesProposees().setServiceMenage(false);
                    getChaletAjoute().getOptionSupplementairesProposees().setServiceMenage(false);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setServiceMenage(false);
                    getHotelAjoute().getOptionSupplementairesProposees().setServiceMenage(false);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setServiceMenage(false);
                    getVillaAjoutee().getOptionSupplementairesProposees().setServiceMenage(false);
                }
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
                if(state){
                    getAppartementAjoute().getOptionSupplementairesProposees().setClimatisation(true);
                    getChaletAjoute().getOptionSupplementairesProposees().setClimatisation(true);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setClimatisation(true);
                    getHotelAjoute().getOptionSupplementairesProposees().setClimatisation(true);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setClimatisation(true);
                    getVillaAjoutee().getOptionSupplementairesProposees().setClimatisation(true);
                } else {
                    getAppartementAjoute().getOptionSupplementairesProposees().setClimatisation(false);
                    getChaletAjoute().getOptionSupplementairesProposees().setClimatisation(false);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setClimatisation(false);
                    getHotelAjoute().getOptionSupplementairesProposees().setClimatisation(false);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setClimatisation(false);
                    getVillaAjoutee().getOptionSupplementairesProposees().setClimatisation(false);
                }
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
                if(state){
                    getAppartementAjoute().getOptionSupplementairesProposees().setFumeur(true);
                    getChaletAjoute().getOptionSupplementairesProposees().setFumeur(true);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setFumeur(true);
                    getHotelAjoute().getOptionSupplementairesProposees().setFumeur(true);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setFumeur(true);
                    getVillaAjoutee().getOptionSupplementairesProposees().setFumeur(true);
                } else {
                    getAppartementAjoute().getOptionSupplementairesProposees().setFumeur(false);
                    getChaletAjoute().getOptionSupplementairesProposees().setFumeur(false);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setFumeur(false);
                    getHotelAjoute().getOptionSupplementairesProposees().setFumeur(false);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setFumeur(false);
                    getVillaAjoutee().getOptionSupplementairesProposees().setFumeur(false);
                }
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
                if(state){
                    getAppartementAjoute().getOptionSupplementairesProposees().setCoffreFort(true);
                    getChaletAjoute().getOptionSupplementairesProposees().setCoffreFort(true);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setCoffreFort(true);
                    getHotelAjoute().getOptionSupplementairesProposees().setCoffreFort(true);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setCoffreFort(true);
                    getVillaAjoutee().getOptionSupplementairesProposees().setCoffreFort(true);
                } else {
                    getAppartementAjoute().getOptionSupplementairesProposees().setCoffreFort(false);
                    getChaletAjoute().getOptionSupplementairesProposees().setCoffreFort(false);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setCoffreFort(false);
                    getHotelAjoute().getOptionSupplementairesProposees().setCoffreFort(false);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setCoffreFort(false);
                    getVillaAjoutee().getOptionSupplementairesProposees().setCoffreFort(false);
                }
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
                if(state){
                    getAppartementAjoute().getOptionSupplementairesProposees().setParkingPrivee(true);
                    getChaletAjoute().getOptionSupplementairesProposees().setParkingPrivee(true);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setParkingPrivee(true);
                    getHotelAjoute().getOptionSupplementairesProposees().setParkingPrivee(true);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setParkingPrivee(true);
                    getVillaAjoutee().getOptionSupplementairesProposees().setParkingPrivee(true);
                } else {
                    getAppartementAjoute().getOptionSupplementairesProposees().setParkingPrivee(false);
                    getChaletAjoute().getOptionSupplementairesProposees().setParkingPrivee(false);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setParkingPrivee(false);
                    getHotelAjoute().getOptionSupplementairesProposees().setParkingPrivee(false);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setParkingPrivee(false);
                    getVillaAjoutee().getOptionSupplementairesProposees().setParkingPrivee(false);
                }
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
                if(state){
                    getAppartementAjoute().getOptionSupplementairesProposees().setBar(true);
                    getChaletAjoute().getOptionSupplementairesProposees().setBar(true);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setBar(true);
                    getHotelAjoute().getOptionSupplementairesProposees().setBar(true);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setBar(true);
                    getVillaAjoutee().getOptionSupplementairesProposees().setBar(true);
                } else {
                    getAppartementAjoute().getOptionSupplementairesProposees().setBar(false);
                    getChaletAjoute().getOptionSupplementairesProposees().setBar(false);
                    getComplexeHotelierAjoute().getOptionSupplementairesProposees().setBar(false);
                    getHotelAjoute().getOptionSupplementairesProposees().setBar(false);
                    getMaisonAjoutee().getOptionSupplementairesProposees().setBar(false);
                    getVillaAjoutee().getOptionSupplementairesProposees().setBar(false);
                }
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
                getAppartementAjoute().getOptionSupplementairesProposees().setDescriptionDeLaVue(DescriptionVue.getText());//on récup la valeur dans le champ NB Personne
                getChaletAjoute().getOptionSupplementairesProposees().setDescriptionDeLaVue(DescriptionVue.getText());//on récup la valeur dans le champ NB Personne
                getComplexeHotelierAjoute().getOptionSupplementairesProposees().setDescriptionDeLaVue(DescriptionVue.getText());//on récup la valeur dans le champ NB Personne
                getHotelAjoute().getOptionSupplementairesProposees().setDescriptionDeLaVue(DescriptionVue.getText());//on récup la valeur dans le champ NB Personne
                getMaisonAjoutee().getOptionSupplementairesProposees().setDescriptionDeLaVue(DescriptionVue.getText());//on récup la valeur dans le champ NB Personne
                getVillaAjoutee().getOptionSupplementairesProposees().setDescriptionDeLaVue(DescriptionVue.getText());//on récup la valeur dans le champ NB Personne
            }
        });
    }

    /**méthodes en fonction du type de logement*/
    public void composantAppartement(){

        boutonAjouter.setBounds(850,600,100,30);
        panel.add(boutonAjouter);

        JLabel titreCate = new JLabel("UN APPARTEMENT A " + getAjoutVille());
        titreCate.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 30));
        titreCate.setBounds(150, 150, 750, 30);
        panel.add(titreCate);
        ajoutComposant();

        /**etageDeLAppartement*/
        JLabel titreEtageAppartement = new JLabel("Etage de l'Appartement :  ");
        titreEtageAppartement.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreEtageAppartement.setBounds(500, 400, 300, 30);
        panel.add(titreEtageAppartement);
        JTextField etageAppartement = new JTextField();
        etageAppartement.setColumns(25);
        etageAppartement.setBounds(700,400,150,30);
        panel.add(etageAppartement);
        etageAppartement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String etageAppartementText= etageAppartement.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getAppartementAjoute().setEtageDeLAppartement(Integer.parseInt(etageAppartementText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setEtageDeLAppartement(1);
                }
            }
        });

        /**numeroAppartement*/
        JLabel titreNumeroAppartement = new JLabel("Numéro d'appartement:  ");
        titreNumeroAppartement.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreNumeroAppartement.setBounds(500, 450, 300, 30);
        panel.add(titreNumeroAppartement);
        JTextField numeroAppartement = new JTextField();
        numeroAppartement.setColumns(25);
        numeroAppartement.setBounds(700,450,150,30);
        panel.add(numeroAppartement);
        numeroAppartement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroAppartementText= numeroAppartement.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getAppartementAjoute().setNumeroAppartement(Integer.parseInt(numeroAppartementText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setNumeroAppartement(1);
                }
            }
        });

        /**nombreDeBalcon*/
        JLabel titreNombreBalcon = new JLabel("Nombre de Balcon :  ");
        titreNombreBalcon.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreNombreBalcon.setBounds(500, 500, 300, 30);
        panel.add(titreNombreBalcon);
        JTextField nombreBalcon = new JTextField();
        nombreBalcon.setColumns(25);
        nombreBalcon.setBounds(700,500,150,30);
        panel.add(nombreBalcon);
        nombreBalcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreBalconText= nombreBalcon.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getAppartementAjoute().setNombreDeBalcon(Integer.parseInt(nombreBalconText));
                }catch(NumberFormatException except){
                    getAppartementAjoute().setNombreDeBalcon(1);
                }
            }
        });
        setVisible(true);
    }

    public void composantChalet(){
        boutonAjouter.setBounds(850,600,100,30);
        panel.add(boutonAjouter);

        JLabel titreChalet = new JLabel("UN CHALET A " + getAjoutVille());
        titreChalet.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 30));
        titreChalet.setBounds(150, 150, 750, 30);
        panel.add(titreChalet);

        /**Récupération du nom de la Montagne*/
        JLabel titreNomMontagne = new JLabel("Nom de la Montagne :  ");
        titreNomMontagne.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreNomMontagne.setBounds(500, 400, 300, 30);
        panel.add(titreNomMontagne);
        JTextField nomMontagne = new JTextField();
        nomMontagne.setColumns(25);
        nomMontagne.setBounds(700,400,150,30);
        panel.add(nomMontagne);
        nomMontagne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getChaletAjoute().setNomMontagne((String)nomMontagne.getText());
            }
        });

        /**Récupération de l'altitude*/
        JLabel titreAltitude = new JLabel("Altitude :  ");
        titreAltitude.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreAltitude.setBounds(500, 450, 300, 30);
        panel.add(titreAltitude);
        JTextField altitude = new JTextField();
        altitude.setColumns(25);
        altitude.setBounds(700, 450, 150, 30);
        panel.add(altitude);
        altitude.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String altitudeText= altitude.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getChaletAjoute().setAltitude(Integer.parseInt(altitudeText));
                }catch(NumberFormatException except){
                    getChaletAjoute().setAltitude(0);
                }
            }
        });
        ajoutComposant();
        setVisible(true);
    }

    public void composantComplexeHotelier(){
        boutonActivite.setBounds(840,600,150,30);
        panel.add(boutonActivite);

        JLabel titreComplexeHotelier = new JLabel("UN COMPLEXE HOTELIER A " + getAjoutVille());
        titreComplexeHotelier.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 30));
        titreComplexeHotelier.setBounds(50, 150, 850, 30);
        panel.add(titreComplexeHotelier);
        /**Récupération de la compagnie */
        JLabel titreCompagnie = new JLabel("Compagnie :  ");
        titreCompagnie.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreCompagnie.setBounds(500, 450, 150, 30);
        panel.add(titreCompagnie);
        JTextField compagnie = new JTextField();
        compagnie.setColumns(25);
        compagnie.setBounds(700,450,150,30);
        panel.add(compagnie);
        compagnie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getComplexeHotelierAjoute().setCompagnie(compagnie.getText());
            }
        });

        /**Récupération du nombre d'étoile*/
        JLabel titreNombreEtoile = new JLabel("Nombre d'étoile :  ");
        titreNombreEtoile.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreNombreEtoile.setBounds(500, 400, 150, 30);
        panel.add(titreNombreEtoile);
        JTextField nombreEtoile = new JTextField();
        nombreEtoile.setColumns(25);
        nombreEtoile.setBounds(700,400,150,30);
        panel.add(nombreEtoile);
        nombreEtoile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEtoileText= nombreEtoile.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getComplexeHotelierAjoute().setNombreEtoile(Integer.parseInt(nombreEtoileText));
                }catch(NumberFormatException except){
                    getComplexeHotelierAjoute().setNombreEtoile(0);
                }
            }
        });

        /**recuperation booleen aUnePiscine*/
        JCheckBox piscine = new JCheckBox("PISCINE  ");
        piscine.setBounds(650,360, 150, 30);
        panel.add(piscine);
        piscine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = piscine.isSelected();
                if(state){
                    getComplexeHotelierAjoute().setaUnePiscine(true);
                } else {
                    getComplexeHotelierAjoute().setaUnePiscine(false);
                }
            }
        });

        ajoutComposant();
        setVisible(true);
    }

    public void composantHotel(){
        boutonAjouter.setBounds(850,600,100,30);
        panel.add(boutonAjouter);

        JLabel titreHotel = new JLabel("UN HOTEL A " + getAjoutVille());
        titreHotel.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 30));
        titreHotel.setBounds(150, 150, 750, 30);
        panel.add(titreHotel);
        ajoutComposant();

        /**recuperation booleen aUnePiscine*/
        JCheckBox piscine = new JCheckBox("PISCINE  ");
        piscine.setBounds(650,360, 150, 30);
        panel.add(piscine);
        piscine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = piscine.isSelected();
                if(state){
                    getHotelAjoute().setaUnePiscine(true);
                } else {
                    getHotelAjoute().setaUnePiscine(false);
                }
            }
        });

        /**Récupération du nombre d'étoile*/
        JLabel titreNombreEtoile = new JLabel("Nombre d'étoile :  ");
        titreNombreEtoile.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreNombreEtoile.setBounds(500, 400, 150, 30);
        panel.add(titreNombreEtoile);
        JTextField nombreEtoile = new JTextField();
        nombreEtoile.setColumns(25);
        nombreEtoile.setBounds(700,400,150,30);
        panel.add(nombreEtoile);
        nombreEtoile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEtoileText= nombreEtoile.getText();//on récup la valeur dans le champ NB Personne
                try{
                    getHotelAjoute().setNombreEtoile(Integer.parseInt(nombreEtoileText));
                }catch(NumberFormatException except){
                    getHotelAjoute().setNombreEtoile(0);
                }
            }
        });
        setVisible(true);
    }

    public void composantMaison(){
        boutonAjouter.setBounds(850,600,100,30);
        panel.add(boutonAjouter);

        JLabel titreCate = new JLabel("UNE MAISON A " + getAjoutVille());
        titreCate.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 30));
        titreCate.setBounds(150, 150, 750, 30);
        panel.add(titreCate);
        ajoutComposant();
        /**recuperation booleen aUnJardin*/
        JCheckBox jardin = new JCheckBox("JARDIN  ");
        jardin.setBounds(650,360, 150, 30);
        panel.add(jardin);
        jardin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = jardin.isSelected();
                if(state){
                    getMaisonAjoutee().setaUnJardin(true);
                } else {
                    getMaisonAjoutee().setaUnJardin(false);
                }
            }
        });

        /**recuperation booleen aUnePiscine*/
        JCheckBox piscine = new JCheckBox("PISCINE  ");
        piscine.setBounds(800,360, 150, 30);
        panel.add(piscine);
        piscine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = piscine.isSelected();
                if(state){
                    getMaisonAjoutee().setaUnePiscine(true);
                } else {
                    getMaisonAjoutee().setaUnePiscine(false);
                }
            }
        });
        setVisible(true);
    }

    public void composantVilla(){
        boutonAjouter.setBounds(850,600,100,30);
        panel.add(boutonAjouter);

        JLabel titreVilla = new JLabel("UNE VILLA A " + getAjoutVille());
        titreVilla.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 30));
        titreVilla.setBounds(150, 150, 750, 30);
        panel.add(titreVilla);
        ajoutComposant();

        /**recuperation booleen aUnePiscine*/
        JCheckBox piscine = new JCheckBox("PISCINE  ");
        piscine.setBounds(650,360, 150, 30);
        panel.add(piscine);
        piscine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = piscine.isSelected();
                if(state){
                    getVillaAjoutee().setaUnePiscine(true);
                } else {
                    getVillaAjoutee().setaUnePiscine(false);
                }
            }
        });

        /**recuperation booleen aUnSauna*/
        JCheckBox sauna = new JCheckBox("SAUNA  ");
        sauna.setBounds(800,360, 150, 30);
        panel.add(sauna);
        sauna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = sauna.isSelected();
                if(state){
                    getVillaAjoutee().setaUnSauna(true);
                } else {
                    getVillaAjoutee().setaUnSauna(false);
                }
            }
        });

        /**recuperation booleen aUneSalleDeCinema*/
        JCheckBox cinema = new JCheckBox("SALLE DE CINEMA  ");
        cinema.setBounds(500,390, 150, 30);
        panel.add(cinema);
        cinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = cinema.isSelected();
                if(state){
                    getVillaAjoutee().setaUneSalleDeCinema(true);
                } else {
                    getVillaAjoutee().setaUneSalleDeCinema(false);
                }
            }
        });

        /**recuperation booleen aUneDiscotheque*/
        JCheckBox disco = new JCheckBox("DISCOTHEQUE  ");
        disco.setBounds(650,390, 150, 30);
        panel.add(disco);
        disco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = disco.isSelected();
                if(state){
                    getVillaAjoutee().setaUneDiscotheque(true);
                } else {
                    getVillaAjoutee().setaUneDiscotheque(false);
                }
            }
        });
        setVisible(true);
    }
}