package fr.java.controleur.Recherche;


import fr.java.controleur.MiseAJour.Reservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;



public class Appartement extends Hebergement
{
    /**ATTRIBUTS*/
    private int etageDeLAppartement;
    private int numeroAppartement;
    private int nombreDeBalcon;

    /**CONSTRUCTEURS*/

    public Appartement(int id, String nomHebergement, String adresseHebergement, Option optionSupplementairesProposees, int capacitePersonne, int nombreDeChambre, HashMap<String, String> avisClients, TreeMap<String,Integer> notesClients, int tarifAdulte, int tarifEnfant, int etage, int numero, int nbBalcon, String URL,int promotion)
    {
        super(id,nomHebergement, adresseHebergement, optionSupplementairesProposees, capacitePersonne, nombreDeChambre, avisClients, notesClients, tarifAdulte, tarifEnfant, "Appartement", URL,promotion);
        this.etageDeLAppartement = etage;
        this.numeroAppartement = numero;
        this.nombreDeBalcon = nbBalcon;
    }

    public Appartement()
    {
        super("Appartement");
    }

    /**ACCESSEURS*/

    public int getEtageDeLAppartement() {
        return etageDeLAppartement;
    }

    public int getNumeroAppartement() {
        return numeroAppartement;
    }

    public int getNombreDeBalcon() {
        return nombreDeBalcon;
    }

    public void setEtageDeLAppartement(int etageDeLAppartement) {
        this.etageDeLAppartement = etageDeLAppartement;
    }

    public void setNombreDeBalcon(int nombreDeBalcon) {
        this.nombreDeBalcon = nombreDeBalcon;
    }

    public void setNumeroAppartement(int numeroAppartement) {
        this.numeroAppartement = numeroAppartement;
    }

    /**METHODES*/

    //Permet d'afficher l'image,le nom,l'adresse,la capcité,le nombre de chambre,le prix,la description et les options, les avis client sur la page
    @Override
    public JPanel afficherDetail(RechercheReservation criteresDemandes, Client utilisateurDuSite, String imageLogement) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/fondDetailLogement.png";
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
        panel.setLayout(null);
        panel.setBackground(new Color(218, 182, 182));

        //IMAGE

        JLabel imageLabel = new JLabel();
        try {
            URL recup = new URL(imageLogement);
            Image image = ImageIO.read(recup);
            ImageIcon imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageLabel.setBounds(34, 36, 272, 252);
        panel.add(imageLabel);

        //NOM
        JLabel nom = new JLabel("Nom : " + getNom());
        nom.setBounds(425,54,550,30);
        nom.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(nom);

        //ADRESSE
        JLabel adress = new JLabel ("Adresse : " + getAdresse());
        adress.setBounds(425,126,550,30);
        adress.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(adress);

        //CAPACITE
        JLabel capacite = new JLabel("Capacite : " + getCapacite() + " personne(s)");
        capacite.setBounds(425,162,400,30);
        capacite.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(capacite);

        //NOMBRE DE CHAMBRE
        JLabel nbChambre = new JLabel ("Nombre de chambre : " + getNombreDeChambre());
        nbChambre.setBounds(425,198,400,30);
        nbChambre.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(nbChambre);

        //PRIX
        JLabel prix = new JLabel ("Prix du séjour : " + calculPrixSejour(criteresDemandes.getNombreAdulte(), criteresDemandes.getNombreEnfant(), criteresDemandes.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $");
        prix.setBounds(425,234,400,30);
        prix.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(prix);

        // DESCRIPTION
        JLabel vue = new JLabel ("Description : " + getOptionSupplementairesProposees().getDescriptionDeLaVue());
        vue.setBounds(425,270,550,30);
        vue.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(vue);

        //AVIS CLIENTS
        JLabel avis = new JLabel ("AVIS CLIENT:");
        avis.setBounds(68,324,300,30);
        avis.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        if(getAvisClients().size() > 0)
        {
            Collection<String> tousLesAvis = getAvisClients().values();
            int decalageAffichage = 0;
            for (String str : tousLesAvis)
            {
                JLabel avisClient = new JLabel(str);
                avisClient.setBounds(51,360+decalageAffichage,300,30);
                avisClient.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 10));
                panel.add(avisClient);
                decalageAffichage += 36;
            }
        }
        panel.add(avis);


        // NOTE MOYENNE
        float moyenne = moyenneNotesClients();
        if(moyenne != -1.0f)
        {
            JLabel note = new JLabel ("Note moyenne : " + moyenneNotesClients());
            note.setBounds(306,324,200,30);
            note.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
            panel.add(note);
        }


        // BOOLEAN
        String nomChemin = "images/oui.png";
        File imageFile = new File(nomChemin);
        ImageIcon img = new ImageIcon();
        try {
            BufferedImage buffered = ImageIO.read(imageFile);
            img = new ImageIcon(buffered);
        }
        catch(java.io.IOException e){
            System.out.println("erreur image");
        }
        JLabel ouiWifi = new JLabel(img);
        JLabel ouiMenage = new JLabel(img);
        JLabel ouiClim = new JLabel(img);
        JLabel ouiFumeur = new JLabel(img);
        JLabel ouiCoffre = new JLabel(img);
        JLabel ouiParking = new JLabel(img);
        JLabel ouiBar = new JLabel(img);


        nomChemin = "images/non.png";
        imageFile = new File(nomChemin);
        img = new ImageIcon();
        try {
            BufferedImage buffered = ImageIO.read(imageFile);
            img = new ImageIcon(buffered);
        }
        catch(java.io.IOException e){
            System.out.println("erreur image");
        }
        JLabel nonWifi = new JLabel(img);
        JLabel nonMenage = new JLabel(img);
        JLabel nonClim = new JLabel(img);
        JLabel nonFumeur = new JLabel(img);
        JLabel nonCoffre = new JLabel(img);
        JLabel nonParking = new JLabel(img);
        JLabel nonBar = new JLabel(img);


        // WIFI
        JLabel wifi = new JLabel("WIFI : ");
        wifi.setBounds(578,378-54,100,30);
        wifi.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(wifi);
        ouiWifi.setBounds(697,378-54,40,40);
        nonWifi.setBounds(697,378-54,40,40);
        if(getOptionSupplementairesProposees().getWifi())
        {
            panel.add(ouiWifi);
        }
        else {
            panel.add(nonWifi);
        }

        //SERVICE MENAGE
        JLabel menage = new JLabel("SERVICE MENAGE : ");
        menage.setBounds(578,414-54,250,30);
        menage.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(menage);
        ouiMenage.setBounds(816,414-54,40,40);
        nonMenage.setBounds(816,414-54,40,40);
        if(getOptionSupplementairesProposees().getServiceMenage())
        {
            panel.add(ouiMenage);
        }
        else {
            panel.add(nonMenage);
        }

        //CLIM
        JLabel clim = new JLabel("CLIMATISATION : ");
        clim.setBounds(578,450-54,200,30);
        clim.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(clim);
        ouiClim.setBounds(765,450-54,40,40);
        nonClim.setBounds(765,450-54,40,40);
        if(getOptionSupplementairesProposees().getClimatisation())
        {
            panel.add(ouiClim);
        }
        else {
            panel.add(nonClim);
        }

        // FUMEUR
        JLabel fumeur = new JLabel("FUMEUR : ");
        fumeur.setBounds(578,486-54,200,30);
        fumeur.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(fumeur);
        ouiFumeur.setBounds(748,486-54,40,40);
        nonFumeur.setBounds(748,486-54,40,40);
        if(getOptionSupplementairesProposees().getFumeur())
        {
            panel.add(ouiFumeur);
        }
        else {
            panel.add(nonFumeur);
        }

        //COFFRE FORT
        JLabel coffre = new JLabel("COFFRE FORT : ");
        coffre.setBounds(578,522-54,200,30);
        coffre.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(coffre);
        ouiCoffre.setBounds(765,522-54,40,40);
        nonCoffre.setBounds(765,522-54,40,40);
        if(getOptionSupplementairesProposees().getCoffreFort())
        {
            panel.add(ouiCoffre);
        }
        else {
            panel.add(nonCoffre);
        }

        //PARKING PRIVE
        JLabel parking = new JLabel("PARKING PRIVE : ");
        parking.setBounds(578,558-54,200,30);
        parking.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(parking);
        ouiParking.setBounds(782,558-54,40,40);
        nonParking.setBounds(782,558-54,40,40);
        if(getOptionSupplementairesProposees().getParkingPrivee())
        {
            panel.add(ouiParking);
        }
        else {
            panel.add(nonParking);
        }

        // BAR
        JLabel bar = new JLabel("BAR : ");
        bar.setBounds(578,594-54,100,30);
        bar.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(bar);
        ouiBar.setBounds(680,594-54,40,40);
        nonBar.setBounds(680,594-54,40,40);
        if(getOptionSupplementairesProposees().getBar())
        {
            panel.add(ouiBar);
        }
        else {
            panel.add(nonBar);
        }


        // ETAGE APPART
        JLabel etage = new JLabel("Etage n°" + getEtageDeLAppartement());
        etage.setBounds(578,630-54,200,30);
        etage.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(etage);
        // NUMERO APPART
        JLabel numero = new JLabel("Appartement n°" + getNumeroAppartement());
        numero.setBounds(578,648-54,200,30);
        numero.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(numero);
        // NB BALCON
        JLabel balcon = new JLabel(getNombreDeBalcon()+ " balcons");
        balcon.setBounds(578,666-54,200,30);
        balcon.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(balcon);

        return panel;
    }

    /**Permet de modifier les attributs d'un hebergement*/
    @Override
    public void modifierHebergement(JPanel panel) {

        //etageDeLAppartement
        JLabel titreEtageAppartement = new JLabel("Etage : " + getEtageDeLAppartement() +" ");
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
                String etageAppartementText= etageAppartement.getText();//on récupère la valeur dans le champ NB Personne
                try{
                    setEtageDeLAppartement(Integer.parseInt(etageAppartementText));
                }catch(NumberFormatException except){
                    setEtageDeLAppartement(1);
                }
            }
        });

        //numeroAppartement
        JLabel titreNumeroAppartement = new JLabel("Numéro : " + getNumeroAppartement() +" ");
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
                String numeroAppartementText= numeroAppartement.getText();//on récupère la valeur dans le champ NB Personne
                try{
                    setNumeroAppartement(Integer.parseInt(numeroAppartementText));
                }catch(NumberFormatException except){
                    setNumeroAppartement(1);
                }
            }
        });

        //nombreDeBalcon
        JLabel titreNombreBalcon = new JLabel("Nombre de Balcon : "+ getNombreDeBalcon() +" ");
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
                String nombreBalconText= nombreBalcon.getText();//on récupère la valeur dans le champ NB Personne
                try{
                    setNombreDeBalcon(Integer.parseInt(nombreBalconText));
                }catch(NumberFormatException except){
                    setNombreDeBalcon(1);
                }
            }
        });

    }

    /**Permet de créer un logement*/
    @Override
    public void creerLogement() {
        super.creerLogement();

        Scanner recup = new Scanner(System.in);

        System.out.print("Saisissez l'étage de l'" + getCategorie() + " : ");
        setEtageDeLAppartement(recup.nextInt());
        System.out.print("Saisissez le numéro de l'" + getCategorie() + " : ");
        setNumeroAppartement(recup.nextInt());
        System.out.print("Saisissez le nombre de balcon de l'" + getCategorie() + " : ");
        setNombreDeBalcon(recup.nextInt());
    }

    /**Permet de connaitre la disponibilité d'une chambre*/
    @Override
    public boolean encoreDesChambresDispo(Calendar dateDebut, Calendar dateFin, ArrayList<Reservation> historiqueResaPasPassees, int nombreDeChambre) {
        return true;
    }


    /**Permet d'afficher un hebergement sur la console*/
    public void affichageHebergement()
    {
        System.out.println(" Appartement : "+super.getNom()+"\n");
        //getOptionSupplementairesProposees().affichageOption();
        try {
            for (Map.Entry<String, String> entry : this.getAvisClients().entrySet()) {
                System.out.println("Avis de " + entry.getKey() + " : " + entry.getValue() + "\n");
            }
        }catch (Exception e){
            System.out.println("Aucun avis");
        }
        try{
            for (Map.Entry<String,Integer> entry : this.getNotesClients().entrySet())
            {
                System.out.println("Note de " + entry.getValue() + " : " + entry.getKey() + " etoiles\n");
            }
        }catch (Exception e){
            System.out.println("Aucune note");
        }
    }

    /**Permet de retourner les elements spécifiques d'appartement a enregistrer dans la base de données*/
    public ArrayList<Object> enregistrement()
    {

        ArrayList<Object> enregistrement = new ArrayList<>();
        enregistrement.add(getEtageDeLAppartement());
        enregistrement.add(getNumeroAppartement());
        enregistrement.add(getNombreDeBalcon());
        return enregistrement;
    }

}
