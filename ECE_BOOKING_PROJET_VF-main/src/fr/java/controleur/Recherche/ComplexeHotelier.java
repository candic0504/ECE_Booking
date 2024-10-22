package fr.java.controleur.Recherche;

import fr.java.controleur.MiseAJour.Reservation;
import fr.java.controleur.Reporting.HistoriqueReservation;
import fr.java.modele.dao.FenetreModificationActivite;

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

public class ComplexeHotelier extends Hebergement {
    /**ATTRIBUTS*/
    private String compagnie;
    /**CLUB MED, CLUB MICKEY, ...*/
    private int nombreEtoile;
    private boolean aUnePiscine;
    private JButton boutonActivite =new JButton("AJOUTER ACTIVITE");
    private FenetreModificationActivite ecranModificationActivite;
    private ArrayList<Activite> activitesProposees;


    /**CONSTRUCTEURS*/
    public ComplexeHotelier(int id, String nomHebergement, String adresseHebergement, Option optionSupplementairesProposees, int capacitePersonne, int nombreDeChambre, HashMap<String, String> avisClients, TreeMap<String, Integer> notesClients, int tarifAdulte, int tarifEnfant, String compagnie, int etoile, boolean piscine, String URL, int promotion) {
        super(id, nomHebergement, adresseHebergement, optionSupplementairesProposees, capacitePersonne, nombreDeChambre, avisClients, notesClients, tarifAdulte, tarifEnfant, "Complexe Hotelier", URL, promotion);
        this.compagnie = compagnie;
        this.nombreEtoile = etoile;
        this.aUnePiscine = piscine;
        this.activitesProposees = new ArrayList<>();
        this.ecranModificationActivite = new FenetreModificationActivite(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HistoriqueReservation(), false);
    }

    public ComplexeHotelier() {
        super("Complexe Hotelier");
    }

    /**ACCESSEURS*/
    public String getCompagnie() {return compagnie;}

    public void setCompagnie(String compagnie) {this.compagnie = compagnie;}

    public int getNombreEtoile() {return nombreEtoile;}

    public void setNombreEtoile(int nombreEtoile) {this.nombreEtoile = nombreEtoile;}

    public boolean getaUnePiscine() {return aUnePiscine;}

    public void setaUnePiscine(boolean aUnePiscine) {this.aUnePiscine = aUnePiscine;}

    public ArrayList<Activite> getActivitesProposees() {return activitesProposees;}

    public void ajouterActiviteProposee(Activite nouvelle) {this.activitesProposees.add(nouvelle);}

    public void setActivitesProposees(ArrayList<Activite> activitesProposees) {this.activitesProposees = activitesProposees;}

    public JButton getBoutonActivite() {return boutonActivite;}

    public FenetreModificationActivite getEcranModificationActivite() {return ecranModificationActivite;}

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
                } catch (java.io.IOException e) {
                    System.out.println("erreur image");
                }

                g.drawImage(image, 0, 0, this);
            }
        };
        panel.setLayout(null);
        panel.setBackground(new Color(218, 182, 182));

        /** IMAGE */
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

        /** NOM */
        JLabel nom = new JLabel("Nom : " + getNom());
        nom.setBounds(425, 54, 550, 30);
        nom.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(nom);

        /** ADRESSE */
        JLabel adress = new JLabel("Adresse : " + getAdresse());
        adress.setBounds(425, 126, 550, 30);
        adress.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(adress);

        /** CAPACITE */
        JLabel capacite = new JLabel("Capacite : " + getCapacite() + " personne(s)");
        capacite.setBounds(425, 162, 400, 30);
        capacite.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(capacite);

        /** NOMBRE DE CHAMBRE */
        JLabel nbChambre = new JLabel("Nombre de chambre : " + getNombreDeChambre());
        nbChambre.setBounds(425, 198, 400, 30);
        nbChambre.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(nbChambre);

        /** PRIX */
        JLabel prix = new JLabel("Prix du séjour : " + calculPrixSejour(criteresDemandes.getNombreAdulte(), criteresDemandes.getNombreEnfant(), criteresDemandes.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $");
        prix.setBounds(425, 234, 400, 30);
        prix.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(prix);

        /** DESCRIPTION */
        JLabel vue = new JLabel("Description : " + getOptionSupplementairesProposees().getDescriptionDeLaVue());
        vue.setBounds(425, 270, 550, 30);
        vue.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(vue);

        /**AVIS CLIENTS*/
        JLabel avis = new JLabel("AVIS CLIENT:");
        avis.setBounds(68, 324, 300, 30);
        avis.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        if (getAvisClients().size() > 0) {
            Collection<String> tousLesAvis = getAvisClients().values();
            int decalageAffichage = 0;
            for (String str : tousLesAvis) {
                if (decalageAffichage < 80)  /** BLINDAGE POUR PAS DEPASSER SUR ACTIVITE PROPOSEES */ {
                    JLabel avisClient = new JLabel(str);
                    avisClient.setBounds(51, 360 + decalageAffichage, 3003, 30);
                    avisClient.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 10));
                    panel.add(avisClient);
                    decalageAffichage += 36;
                }
            }
        }
        panel.add(avis);


        /** NOTE MOYENNE */
        float moyenne = moyenneNotesClients();
        if (moyenne != -1.0f) {
            JLabel note = new JLabel("Note moyenne : " + moyenneNotesClients());
            note.setBounds(306, 324, 200, 30);
            note.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
            panel.add(note);
        }


        /** BOOLEAN */
        String nomChemin = "images/oui.png";
        File imageFile = new File(nomChemin);
        ImageIcon img = new ImageIcon();
        try {
            BufferedImage buffered = ImageIO.read(imageFile);
            img = new ImageIcon(buffered);
        } catch (java.io.IOException e) {
            System.out.println("erreur image");
        }
        JLabel ouiWifi = new JLabel(img);
        JLabel ouiMenage = new JLabel(img);
        JLabel ouiClim = new JLabel(img);
        JLabel ouiFumeur = new JLabel(img);
        JLabel ouiCoffre = new JLabel(img);
        JLabel ouiParking = new JLabel(img);
        JLabel ouiBar = new JLabel(img);

        JLabel ouiPiscine = new JLabel(img);

        nomChemin = "images/non.png";
        imageFile = new File(nomChemin);
        img = new ImageIcon();
        try {
            BufferedImage buffered = ImageIO.read(imageFile);
            img = new ImageIcon(buffered);
        } catch (java.io.IOException e) {
            System.out.println("erreur image");
        }
        JLabel nonWifi = new JLabel(img);
        JLabel nonMenage = new JLabel(img);
        JLabel nonClim = new JLabel(img);
        JLabel nonFumeur = new JLabel(img);
        JLabel nonCoffre = new JLabel(img);
        JLabel nonParking = new JLabel(img);
        JLabel nonBar = new JLabel(img);

        JLabel nonPiscine = new JLabel(img);

        /** WIFI */
        JLabel wifi = new JLabel("WIFI : ");
        wifi.setBounds(578, 378 - 54, 100, 30);
        wifi.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(wifi);
        ouiWifi.setBounds(697, 378 - 54, 40, 40);
        nonWifi.setBounds(697, 378 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getWifi()) {
            panel.add(ouiWifi);
        } else {
            panel.add(nonWifi);
        }

        /** SERVICE MENAGE */
        JLabel menage = new JLabel("SERVICE MENAGE : ");
        menage.setBounds(578, 414 - 54, 250, 30);
        menage.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(menage);
        ouiMenage.setBounds(816, 414 - 54, 40, 40);
        nonMenage.setBounds(816, 414 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getServiceMenage()) {
            panel.add(ouiMenage);
        } else {
            panel.add(nonMenage);
        }

        /** CLIM */
        JLabel clim = new JLabel("CLIMATISATION : ");
        clim.setBounds(578, 450 - 54, 200, 30);
        clim.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(clim);
        ouiClim.setBounds(765, 450 - 54, 40, 40);
        nonClim.setBounds(765, 450 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getClimatisation()) {
            panel.add(ouiClim);
        } else {
            panel.add(nonClim);
        }

        /** FUMEUR */
        JLabel fumeur = new JLabel("FUMEUR : ");
        fumeur.setBounds(578, 486 - 54, 200, 30);
        fumeur.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(fumeur);
        ouiFumeur.setBounds(748, 486 - 54, 40, 40);
        nonFumeur.setBounds(748, 486 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getFumeur()) {
            panel.add(ouiFumeur);
        } else {
            panel.add(nonFumeur);
        }

        /** COFFRE FORT */
        JLabel coffre = new JLabel("COFFRE FORT : ");
        coffre.setBounds(578, 522 - 54, 200, 30);
        coffre.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(coffre);
        ouiCoffre.setBounds(765, 522 - 54, 40, 40);
        nonCoffre.setBounds(765, 522 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getCoffreFort()) {
            panel.add(ouiCoffre);
        } else {
            panel.add(nonCoffre);
        }

        /** PARKING PRIVE */
        JLabel parking = new JLabel("PARKING PRIVE : ");
        parking.setBounds(578, 558 - 54, 200, 30);
        parking.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(parking);
        ouiParking.setBounds(782, 558 - 54, 40, 40);
        nonParking.setBounds(782, 558 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getParkingPrivee()) {
            panel.add(ouiParking);
        } else {
            panel.add(nonParking);
        }

        /** BAR */
        JLabel bar = new JLabel("BAR : ");
        bar.setBounds(578, 594 - 54, 100, 30);
        bar.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(bar);
        ouiBar.setBounds(680, 594 - 54, 40, 40);
        nonBar.setBounds(680, 594 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getBar()) {
            panel.add(ouiBar);
        } else {
            panel.add(nonBar);
        }


        /** COMPAGNIE */
        JLabel compagnie = new JLabel("COMPAGNIE : " + getCompagnie());
        compagnie.setBounds(578, 630 - 54, 200, 30);
        coffre.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(compagnie);
        /** NOMBRE D'ETOILE */
        JLabel nbEtoile = new JLabel("Complexe " + getNombreEtoile() + " étoile(s)");
        nbEtoile.setBounds(578, 648 - 54, 200, 30);
        nbEtoile.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(nbEtoile);
        /** PISCINE */
        JLabel piscine = new JLabel("PISCINE : ");
        piscine.setBounds(578, 666 - 54, 100, 30);
        piscine.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 20));
        panel.add(piscine);
        ouiPiscine.setBounds(680, 666 - 54, 40, 40);
        nonPiscine.setBounds(680, 666 - 54, 40, 40);
        if (getOptionSupplementairesProposees().getBar()) {
            panel.add(ouiPiscine);
        } else {
            panel.add(nonPiscine);
        }


        return panel;
    }

    /**Permet de modifier les attributs d'un hebergement*/
    @Override
    public void modifierHebergement(JPanel panel) {
        boutonActivite.setBounds(400,600,200,30);
        panel.add(boutonActivite);

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
                setCompagnie(compagnie.getText());
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
                    setNombreEtoile(Integer.parseInt(nombreEtoileText));
                }catch(NumberFormatException except){
                    setNombreEtoile(0);
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
                setaUnePiscine(state);
            }
        });

        boutonActivite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranModificationActivite.setVisible(true);
                ecranModificationActivite.ajoutComposant();
            }
        });

        getEcranModificationActivite().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!getEcranModificationActivite().getActiviteAjoute().getNomActivite().equals(null) && !getEcranModificationActivite().getActiviteAjoute().getTypeActivite().equals(null) && !getEcranModificationActivite().getActiviteAjoute().getPresentationActivite().equals(null))
                {
                    ecranModificationActivite.setVisible(false);
                    ajouterActiviteProposee(getEcranModificationActivite().getActiviteAjoute());
                }
            }
        });

        getEcranModificationActivite().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranModificationActivite.setVisible(false);
            }
        });
    }

    /**Permet de modifier les activitées*/
    public void modifierActivitees() {
        System.out.println("Voici toutes les activités du " + getCategorie() + " :");

        for (int i = 0; i < getActivitesProposees().size(); i++) {
            getActivitesProposees().get(i).affichage();
        }

        Scanner recup = new Scanner(System.in);

        System.out.println("Voulez vous :\n 1: Supprimer une activité\n 2: Ajouter une activité");

        switch (recup.nextInt()) {
            case 1:
                System.out.print("Quelle activité voulez vous supprimer ? (numero) : ");
                ArrayList<Activite> nouvelleListe = getActivitesProposees();
                nouvelleListe.remove(recup.nextInt());
                setActivitesProposees(nouvelleListe);
                break;
            case 2:
                Activite nouvelle = new Activite();
                nouvelle.creerNouvelleActivite();
                ajouterActiviteProposee(nouvelle);
                break;
        }
    }

    /**Permet de creer un logement*/
    @Override
    public void creerLogement() {
        super.creerLogement();

        Scanner recup = new Scanner(System.in);

        System.out.print("Saisissez le nom de la compagnie du " + getCategorie() + " : ");
        setCompagnie(recup.nextLine());
        recup.nextLine();

        System.out.print("Saisissez le nombre d'étoiles du " + getCategorie() + " : ");
        setNombreEtoile(recup.nextInt());

        System.out.print("Le " + getCategorie() + " a-t-il une piscine ? (1: OUI, 2: NON) : ");
        switch (recup.nextInt()) {
            case 1:
                setaUnePiscine(true);
                break;
            case 2:
                setaUnePiscine(false);
                break;
        }

        System.out.println("Ajoutez les activitées proposées par le " + getCategorie() + " : ");
        int choixAction = 1;
        Activite nouvelle = new Activite();
        while (choixAction == 1) {
            nouvelle.creerNouvelleActivite();
            ajouterActiviteProposee(nouvelle);

            System.out.println("Ajouter une nouvelle activitée (1: OUI, 2: NON) : ");
            choixAction = recup.nextInt();
        }
    }

    /**Permet de vérifier les chambres disponibles*/
    @Override
    public boolean encoreDesChambresDispo(Calendar dateDebut, Calendar dateFin, ArrayList<Reservation> historiqueResaPasPassees, int nombreDeChambre) {
        boolean verif = true;
        int compteurDeResa = 0;

        for (int i = 0; i < historiqueResaPasPassees.size(); i++) {
            if (historiqueResaPasPassees.get(i).getHebergementReserve().equals(this)) {
                if ((historiqueResaPasPassees.get(i).getDateArrivee().compareTo(dateDebut) < 0 && historiqueResaPasPassees.get(i).getDateDepart().compareTo(dateDebut) > 0) || (historiqueResaPasPassees.get(i).getDateArrivee().compareTo(dateFin) < 0 && historiqueResaPasPassees.get(i).getDateDepart().compareTo(dateFin) > 0)) {
                    compteurDeResa++;
                }
            }
        }

        if ((compteurDeResa + nombreDeChambre) > getNombreDeChambre()) {
            verif = false;
        }

        return verif;
    }

    /**Permet d'afficher l'hebergement*/
    public void affichageHebergement()
    {
        System.out.println("Complexe hotelier : " + super.getId() + "|" + super.getNom() + "|" + super.getAdresse() + "|" + super.getCapacite() + "|" + super.getNombreDeChambre() + "|" + super.getNotesClients() + "|" + super.getTarifUnAdulteUneNuit() + "|" + super.getTarifUnEnfantUneNuit() + "|" + this.compagnie + "|" + this.nombreEtoile + "|" + this.aUnePiscine + "\n");
        getOptionSupplementairesProposees().affichageOption();
        try {
            for (Map.Entry<String, String> entry : this.getAvisClients().entrySet()) {
                System.out.println("Avis de " + entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Aucun avis");
        }
        try {
            for (Map.Entry<String, Integer> entry : this.getNotesClients().entrySet()) {
                System.out.println("Note de " + entry.getValue() + " : " + entry.getKey() + " etoiles\n");
            }
        } catch (Exception e) {
            System.out.println("Aucune note");
        }

        /**Affichage des activités proposées**/
    }

    /**Permet de retourner les elements spécifiques de complexe hotelier a enregistrer dans la base de données*/
    public ArrayList<Object> enregistrement()
    {

        ArrayList<Object> enregistrement = new ArrayList<>();
        enregistrement.add(getCompagnie());
        enregistrement.add(getNombreEtoile());
        enregistrement.add(getaUnePiscine());
        return enregistrement;
    }

}
