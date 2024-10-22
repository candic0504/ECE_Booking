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
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;


public class FenetreOffre extends Fenetre {

    /**ATTRIBUT DE LA CLASSE FILLE**/
    private JSplitPane Spanel;
    private JPanel panelHotel;
    private JPanel panelVilla;
    private JPanel panelChalet;
    private JPanel panelMaison;
    private JPanel panelComplexeHotelier;
    private JPanel panelAppartement;
    private JButton boutonReporting =new JButton("REPORTING");
    private JButton boutonHistorique = new JButton("HISTORIQUE");
    private JButton boutonInscription = new JButton("S'INSCRIRE");
    private JButton boutonConnexion = new JButton("SE CONNECTER");
    private JButton boutonChangementPage = new JButton("DETAILS DE L'OFFRE");
    private JButton boutonValidationFiltres = new JButton(" VALIDER FILTRES ");
    JTable tableHotel = new JTable();
    JTable tableMaison = new JTable();
    JTable tableAppart = new JTable();
    JTable tableChalet = new JTable();
    JTable tableVilla = new JTable();
    JTable tableComplexe = new JTable();
    private ArrayList<Hebergement> logementCorrespondants;
    private Hebergement logementSelectionne;
    public RechercheReservation critereLogements;


    /**GETTER ET SETTER*/
    public JButton getBoutonReporting() {return boutonReporting;}

    public JButton getBoutonInscription() {
        return boutonInscription;
    }

    public JButton getBoutonChangementPage() {
        return boutonChangementPage;
    }

    public JButton getBoutonConnexion() {
        return boutonConnexion;
    }

    public JButton getBoutonHistorique() {
        return boutonHistorique;
    }

    public JButton getBoutonValidationFiltres() {
        return boutonValidationFiltres;
    }

    public RechercheReservation getCritereLogements() {
        return critereLogements;
    }

    public void setCritereLogements(RechercheReservation critereLogements) {
        this.critereLogements = critereLogements;
    }

    public void setTableAppart(JTable tableAppart) {
        this.tableAppart = tableAppart;
    }

    public void setTableChalet(JTable tableChalet) {
        this.tableChalet = tableChalet;
    }

    public void setTableComplexe(JTable tableComplexe) {
        this.tableComplexe = tableComplexe;
    }

    public void setTableHotel(JTable tableHotel) {
        this.tableHotel = tableHotel;
    }

    public void setTableMaison(JTable tableMaison) {
        this.tableMaison = tableMaison;
    }

    public void setTableVilla(JTable tableVilla) {
        this.tableVilla = tableVilla;
    }

    public ArrayList<Hebergement> getLogementCorrespondants() {
        return logementCorrespondants;
    }

    public void setLogementCorrespondants(ArrayList<Hebergement> logementCorrespondants) {
        this.logementCorrespondants = logementCorrespondants;
    }

    public Hebergement getLogementSelectionne() {
        return logementSelectionne;
    }

    public void setLogementSelectionne(Hebergement logementSelectionne) {
        this.logementSelectionne = logementSelectionne;
    }


    /** CONSTRUCTEUR */
    /** Construction du panneau **/
    private JSplitPane buildContentPane(){

        JPanel pan = new JPanel();
        pan.setLayout(null);
        JPanel panHotel = new JPanel();
        panHotel.setLayout(null);
        JPanel panAppart = new JPanel();
        panAppart.setLayout(null);
        JPanel panMaison = new JPanel();
        panMaison.setLayout(null);
        JPanel panComplexe = new JPanel();
        panComplexe.setLayout(null);
        JPanel panChalet = new JPanel();
        panChalet.setLayout(null);
        JPanel panVilla = new JPanel();
        panVilla.setLayout(null);

        /** Ajout composants du panneau pan du haut **/
        boutonReporting.setBounds(10,10,150,30);
        pan.add(boutonReporting);
        boutonHistorique.setBounds(830,10,150,30);
        pan.add(boutonHistorique);
        boutonConnexion.setBounds(300,10,150,30);
        pan.add(boutonConnexion);
        boutonInscription.setBounds(540,10,150,30);
        pan.add(boutonInscription);

        boutonChangementPage.setBounds(800,210,180,30);
        pan.add(boutonChangementPage);
        boutonValidationFiltres.setBounds(600,210,180,30);
        pan.add(boutonValidationFiltres);


        /** Ajout composants du panneau du bas **/
        panAppart.setBackground(new Color(217, 202, 182));
        panMaison.setBackground(new Color (168, 147, 120));
        panHotel.setBackground(new Color (217, 202, 182));
        panComplexe.setBackground(new Color (168, 147, 120));
        panVilla.setBackground(new Color (217, 202, 182));
        panChalet.setBackground(new Color (168, 147, 120));
        JTabbedPane onglets = new JTabbedPane();
        onglets.setBounds(30,100,800,300);
        onglets.add("Appartement",panAppart);
        onglets.add("Maison",panMaison);
        onglets.add("Hotel",panHotel);
        onglets.add("Complexe Hotelier",panComplexe);
        onglets.add("Villa", panVilla);
        onglets.add("Chalet",panChalet);


        /** séparation du panneau en deux à l'horizontal **/
        JSplitPane splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan, onglets);
        splitPanel.setDividerLocation(250);

        this.panel = pan;
        this.panelVilla = panVilla;
        this.panelMaison = panMaison;
        this.panelHotel = panHotel;
        this.panelComplexeHotelier = panComplexe;
        this.panelChalet = panChalet;
        this.panelAppartement = panAppart;
        this.Spanel=splitPanel;
        return Spanel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreOffre(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat, RechercheReservation critere){

        super(listeClient, listeEmploye, listeVille, historique);
        logementCorrespondants = new ArrayList<>();
        critereLogements = critere;
        setTitle("Résultats offres"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    @Override
    public void ajoutComposant() {

    }

    /**ajout des composants pour le panel du haut : les filtres */
    public void ajoutComposantFiltres(){

        /**FILTRES PRINCIPAUX*/
        /**AFFICHAGE DU TITRE*/
        JLabel titreFiltre = new JLabel("Filtres Principaux : ");
        titreFiltre.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        titreFiltre.setBounds(50, 50, 800, 20);
        panel.add(titreFiltre);


        /**Modification type de logement*/
        String[] options = { "Tous", "Appartement","Chalet","ComplexeHotelier","Hotel","Maison","Villa",};
        JComboBox<String> categorie = new JComboBox<>(options);
        categorie.setBounds(70,80,150,30);
        panel.add(categorie);
        categorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String categorieSelectionne = (String)categorie.getSelectedItem();
                RechercheReservation nouveauCriteres = getCritereLogements();
                nouveauCriteres.setCategorie(categorieSelectionne);
                setCritereLogements(nouveauCriteres);
                System.out.println("VILLE : " + getCritereLogements().getVille());
                System.out.println("CATEGORIE : " + getCritereLogements().getCategorie());
            }
        });

        /**Nombre de chambres*/
        JLabel titreNbr = new JLabel("NOMBRE DE CHAMBRES : ");
        titreNbr.setBounds(70, 110, 800, 20);
        JTextField nbrChambres = new JTextField();
        nbrChambres.setColumns(10);
        nbrChambres.setBounds(70,130,150,30);
        panel.add(titreNbr);
        panel.add(nbrChambres);
        nbrChambres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreChambres = nbrChambres.getText();//on récup la valeur dans le champ NB Personne
                try{
                    Integer nbChambre = Integer.parseInt(nombreChambres);
                    RechercheReservation nouveauCriteres = getCritereLogements();
                    nouveauCriteres.setNombreDeChambre(nbChambre);
                    setCritereLogements(nouveauCriteres);
                    System.out.println("TESSSSSSSST");
                }catch(NumberFormatException except){
                    System.out.println("pb de saisie : ");
                }
            }
        });

        /**Prix*/
        JLabel titrePrixMaximum = new JLabel("PRIX MAXIMUM : ");
        titrePrixMaximum.setBounds(100,170, 200, 20);
        panel.add(titrePrixMaximum);
        JTextField prixMaximum = new JTextField();
        prixMaximum.setColumns(10);
        prixMaximum.setBounds(70,190,150,30);
        panel.add(prixMaximum);
        prixMaximum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prixMax = prixMaximum.getText();//on récup la valeur dans le champ NB Personne
                try{
                    Integer prixMaxSaisie = Integer.parseInt(prixMax);
                    RechercheReservation nouveauCriteres = getCritereLogements();
                    nouveauCriteres.setPrixMaximum(prixMaxSaisie);
                    setCritereLogements(nouveauCriteres);
                    System.out.println("TESSSSSSSST");
                }catch(NumberFormatException except){
                    System.out.println("pb de saisie : ");
                }
            }
        });

        /**OPTION*/
        /**AFFICHAGE DU TITRE*/
        JLabel titreOption = new JLabel("Options possibles : ");
        titreOption.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        titreOption.setBounds(350, 50, 800, 20);
        panel.add(titreOption);
        /**OPTION POSSIBLE*/
        JCheckBox wifi = new JCheckBox("WIFI ");
        wifi.setBounds(380,80, 100, 30);
        panel.add(wifi);
        wifi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = wifi.isSelected();
                RechercheReservation nouveauCriteres = getCritereLogements();
                Option filtreSuppl = nouveauCriteres.getFiltreSupplementaire();
                filtreSuppl.setWifi(state);
                nouveauCriteres.setFiltreSupplementaire(filtreSuppl);
                setCritereLogements(nouveauCriteres);
                System.out.println("TESSSSSSSST");
            }
        });

        JCheckBox serviceMenage = new JCheckBox("SERVICE DE MENAGE ");
        serviceMenage.setBounds(380, 100, 200, 30);
        panel.add(serviceMenage);
        serviceMenage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = serviceMenage.isSelected();
                RechercheReservation nouveauCriteres = getCritereLogements();
                Option filtreSuppl = nouveauCriteres.getFiltreSupplementaire();
                filtreSuppl.setServiceMenage(state);
                nouveauCriteres.setFiltreSupplementaire(filtreSuppl);
                setCritereLogements(nouveauCriteres);
                System.out.println("TESSSSSSSST");
            }
        });

        JCheckBox climatisation = new JCheckBox("CLIMATISATION ");
        climatisation.setBounds(380,120, 200, 30);
        panel.add(climatisation);
        climatisation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = climatisation.isSelected();
                RechercheReservation nouveauCriteres = getCritereLogements();
                Option filtreSuppl = nouveauCriteres.getFiltreSupplementaire();
                filtreSuppl.setClimatisation(state);
                nouveauCriteres.setFiltreSupplementaire(filtreSuppl);
                setCritereLogements(nouveauCriteres);
                System.out.println("TESSSSSSSST");
            }
        });

        JCheckBox fumeur = new JCheckBox("FUMEUR ");
        fumeur.setBounds(380,140, 100, 30);
        panel.add(fumeur);
        fumeur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = fumeur.isSelected();
                RechercheReservation nouveauCriteres = getCritereLogements();
                Option filtreSuppl = nouveauCriteres.getFiltreSupplementaire();
                filtreSuppl.setFumeur(state);
                nouveauCriteres.setFiltreSupplementaire(filtreSuppl);
                setCritereLogements(nouveauCriteres);
                System.out.println("TESSSSSSSST");
            }
        });

        JCheckBox coffreFort = new JCheckBox("COFFRE FORT ");
        coffreFort.setBounds(380, 160, 200, 30);
        panel.add(coffreFort);
        coffreFort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = coffreFort.isSelected();
                RechercheReservation nouveauCriteres = getCritereLogements();
                Option filtreSuppl = nouveauCriteres.getFiltreSupplementaire();
                filtreSuppl.setCoffreFort(state);
                nouveauCriteres.setFiltreSupplementaire(filtreSuppl);
                setCritereLogements(nouveauCriteres);
                System.out.println("TESSSSSSSST");
            }
        });

        JCheckBox parkingPrivee = new JCheckBox("PARKING PRIVE ");
        parkingPrivee.setBounds(380,180, 200, 30);
        panel.add(parkingPrivee);
        parkingPrivee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = parkingPrivee.isSelected();
                RechercheReservation nouveauCriteres = getCritereLogements();
                Option filtreSuppl = nouveauCriteres.getFiltreSupplementaire();
                filtreSuppl.setParkingPrivee(state);
                nouveauCriteres.setFiltreSupplementaire(filtreSuppl);
                setCritereLogements(nouveauCriteres);
                System.out.println("TESSSSSSSST");
            }
        });

        JCheckBox bar = new JCheckBox("BAR ");
        bar.setBounds(380,200, 200, 30);
        panel.add(bar);
        bar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = bar.isSelected();
                RechercheReservation nouveauCriteres = getCritereLogements();
                Option filtreSuppl = nouveauCriteres.getFiltreSupplementaire();
                filtreSuppl.setBar(state);
                nouveauCriteres.setFiltreSupplementaire(filtreSuppl);
                setCritereLogements(nouveauCriteres);
                System.out.println("TESSSSSSSST");
            }
        });



        String typeLogement = getCritereLogements().getCategorie(); /**on recupert le type de logement*/
        System.out.println(typeLogement);
        JLabel titre = new JLabel("Filtres actuels : ");
        titre.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        titre.setBounds(620, 50, 800, 20);
        panel.add(titre);
        JLabel LieuEnregistre = new JLabel(getCritereLogements().getVille());
        LieuEnregistre.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        LieuEnregistre.setBounds(620, 100, 800, 20);
        panel.add(LieuEnregistre);
        JLabel nombreAdulte = new JLabel(Integer.toString(getCritereLogements().getNombreAdulte()) + " adulte(s)");
        nombreAdulte.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        nombreAdulte.setBounds(620, 120, 800, 20);
        panel.add(nombreAdulte);
        JLabel nombreEnfant = new JLabel(Integer.toString(getCritereLogements().getNombreEnfant()) + " enfant(s)");
        nombreEnfant.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        nombreEnfant.setBounds(620, 140, 800, 20);
        panel.add(nombreEnfant);
        JLabel dateArrivee = new JLabel("Arrivee : " + getCritereLogements().getDateArrivee().get(Calendar.DAY_OF_MONTH) + "/" + (getCritereLogements().getDateArrivee().get(Calendar.MONTH)+1) + "/" + getCritereLogements().getDateArrivee().get(Calendar.YEAR));
        dateArrivee.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        dateArrivee.setBounds(620, 160, 800, 20);
        panel.add(dateArrivee);
        JLabel dateDepart = new JLabel("Depart : " + getCritereLogements().getDateDepart().get(Calendar.DAY_OF_MONTH) + "/" + (getCritereLogements().getDateDepart().get(Calendar.MONTH)+1) + "/" + getCritereLogements().getDateDepart().get(Calendar.YEAR));
        dateDepart.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        dateDepart.setBounds(620, 180, 800, 20);
        panel.add(dateDepart);

    }

    /**ajout des composant pour le panel du bas : les offres */
    /** Affichage de toutes les offres correspondant à la recherche, séparé par oglet en fonction de leur catégorie */
    public void ajoutComposant2(RechercheReservation criteresDeResa, Client utilisateurDuSite){

        panelAppartement.removeAll();
        panelAppartement.revalidate();
        panelAppartement.repaint();
        panelChalet.removeAll();
        panelChalet.revalidate();
        panelChalet.repaint();
        panelMaison.removeAll();
        panelMaison.revalidate();
        panelMaison.repaint();
        panelHotel.removeAll();
        panelHotel.revalidate();
        panelHotel.repaint();
        panelVilla.removeAll();
        panelVilla.revalidate();
        panelVilla.repaint();
        panelComplexeHotelier.removeAll();
        panelComplexeHotelier.revalidate();
        panelComplexeHotelier.repaint();



        /** ARRAYLIST DE CHAQUE TYPE DE LOGEMENT */
        ArrayList<Hebergement> hotelRecup = new ArrayList<>();
        ArrayList<Hebergement> maisonRecup = new ArrayList<>();
        ArrayList<Hebergement> appartRecup = new ArrayList<>();
        ArrayList<Hebergement> villaRecup = new ArrayList<>();
        ArrayList<Hebergement> chaletRecup = new ArrayList<>();
        ArrayList<Hebergement> complexeRecup = new ArrayList<>();

        for(int i =0 ; i<getLogementCorrespondants().size() ; i++)
        {
            System.out.println("CATEGORIE : " + getLogementCorrespondants().get(i).getCategorie());
        }

        /** REMPLIR LES ARRAYLIST AVEC TOUS LES LOGEMENTS DE L'ARRAYLIST HEBERGEMENT */
        for(int i=0;i< getLogementCorrespondants().size();i++){
            if(getLogementCorrespondants().get(i).getCategorie()=="Hotel"){
                hotelRecup.add(getLogementCorrespondants().get(i));
            }else if (getLogementCorrespondants().get(i).getCategorie()=="Maison"){
                maisonRecup.add(getLogementCorrespondants().get(i));
            }else if (getLogementCorrespondants().get(i).getCategorie()=="Appartement"){
                appartRecup.add(getLogementCorrespondants().get(i));

            }else if (getLogementCorrespondants().get(i).getCategorie()=="Villa"){
                villaRecup.add(getLogementCorrespondants().get(i));

            }else if (getLogementCorrespondants().get(i).getCategorie()=="Complexe Hotelier"){
                complexeRecup.add(getLogementCorrespondants().get(i));
            }else if (getLogementCorrespondants().get(i).getCategorie()=="Chalet"){
                chaletRecup.add(getLogementCorrespondants().get(i));
            }else{}

        }

        /** REMPLIR LES DONNEES DES TABLES EN FONCTION DU TYPE DE LOGEMENT A PARTIR DES ARRAYLIST */
        Object [][] donneeHotel = new Object[hotelRecup.size()][5];
        Object [][] donneeVilla = new Object[villaRecup.size()][5];
        Object [][] donneeMaison = new Object[maisonRecup.size()][5];
        Object [][] donneeAppart = new Object[appartRecup.size()][5];
        Object [][] donneeComplexe = new Object[complexeRecup.size()][5];
        Object [][] donneeChalet = new Object[chaletRecup.size()][5];


        for(int i=0;i< hotelRecup.size();i++){
            try {
                URL imageUrl = new URL(hotelRecup.get(i).getURL());
                donneeHotel[i][0] = imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
            donneeHotel[i][1]=hotelRecup.get(i).getNom();
            donneeHotel[i][2]=hotelRecup.get(i).getAdresse();
            if(hotelRecup.get(i).moyenneNotesClients() != -1.0f)
            {
                donneeHotel[i][3]=hotelRecup.get(i).moyenneNotesClients();
            }
            else {
                donneeHotel[i][3]= "Pas de notes";
            }
            donneeHotel[i][4]=hotelRecup.get(i).calculPrixSejour(criteresDeResa.getNombreAdulte(), criteresDeResa.getNombreEnfant(), criteresDeResa.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $";
        }
        for(int i=0;i< maisonRecup.size();i++){
            try {
                URL imageUrl = new URL(maisonRecup.get(i).getURL());
                donneeMaison[i][0] = imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
            donneeMaison[i][1]=maisonRecup.get(i).getNom();
            donneeMaison[i][2]=maisonRecup.get(i).getAdresse();
            if(maisonRecup.get(i).moyenneNotesClients() != -1.0f)
            {
                donneeMaison[i][3]=maisonRecup.get(i).moyenneNotesClients();
            }
            else {
                donneeMaison[i][3]= "Pas de notes";
            }
            donneeMaison[i][4]=maisonRecup.get(i).calculPrixSejour(criteresDeResa.getNombreAdulte(), criteresDeResa.getNombreEnfant(), criteresDeResa.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $";
        }
        for(int i=0;i< appartRecup.size();i++){
            try {
                URL imageUrl = new URL(appartRecup.get(i).getURL());
                donneeAppart[i][0] = imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
            donneeAppart[i][1]=appartRecup.get(i).getNom();
            donneeAppart[i][2]=appartRecup.get(i).getAdresse();
            if(appartRecup.get(i).moyenneNotesClients() != -1.0f)
            {
                donneeAppart[i][3]=appartRecup.get(i).moyenneNotesClients();
            }
            else {
                donneeAppart[i][3]= "Pas de notes";
            }
            donneeAppart[i][4]=appartRecup.get(i).calculPrixSejour(criteresDeResa.getNombreAdulte(), criteresDeResa.getNombreEnfant(), criteresDeResa.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $";
        }
        for(int i=0;i< complexeRecup.size();i++){
            try {
                URL imageUrl = new URL(complexeRecup.get(i).getURL());
                donneeComplexe[i][0] = imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
            donneeComplexe[i][1]=complexeRecup.get(i).getNom();
            donneeComplexe[i][2]=complexeRecup.get(i).getAdresse();
            if(complexeRecup.get(i).moyenneNotesClients() != -1.0f)
            {
                donneeComplexe[i][3]=complexeRecup.get(i).moyenneNotesClients();
            }
            else {
                donneeComplexe[i][3]= "Pas de notes";
            }
            donneeComplexe[i][4]=complexeRecup.get(i).calculPrixSejour(criteresDeResa.getNombreAdulte(), criteresDeResa.getNombreEnfant(), criteresDeResa.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $";
        }

        for(int i=0;i<villaRecup.size();i++){
            try {
                URL imageUrl = new URL(villaRecup.get(i).getURL());
                donneeVilla[i][0] = imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
            donneeVilla[i][1]=villaRecup.get(i).getNom();
            donneeVilla[i][2]=villaRecup.get(i).getAdresse();
            if(villaRecup.get(i).moyenneNotesClients() != -1.0f)
            {
                donneeVilla[i][3]=villaRecup.get(i).moyenneNotesClients();
            }
            else {
                donneeVilla[i][3]= "Pas de notes";
            }
            donneeVilla[i][4]=villaRecup.get(i).calculPrixSejour(criteresDeResa.getNombreAdulte(), criteresDeResa.getNombreEnfant(), criteresDeResa.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $";
        }
        for(int i =0;i< chaletRecup.size();i++){
            try {
                URL imageUrl = new URL(chaletRecup.get(i).getURL());
                donneeChalet[i][0] = imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
            donneeChalet[i][1]=chaletRecup.get(i).getNom();
            donneeChalet[i][2]=chaletRecup.get(i).getAdresse();
            if(chaletRecup.get(i).moyenneNotesClients() != -1.0f)
            {
                donneeChalet[i][3]=chaletRecup.get(i).moyenneNotesClients();
            }
            else {
                donneeChalet[i][3]= "Pas de notes";
            }
            donneeChalet[i][4]=chaletRecup.get(i).calculPrixSejour(criteresDeResa.getNombreAdulte(), criteresDeResa.getNombreEnfant(), criteresDeResa.nombreDeJour(), utilisateurDuSite.getClientRegulier()) + " $";
        }


        /** CREATION DES MODELES DE DONNEES POUR LES TABLES */
        DefaultTableModel tabHotel = new DefaultTableModel(donneeHotel, new Object[]{"Photo","Nom","Adresse","Note","Prix"});
        DefaultTableModel tabMaison = new DefaultTableModel(donneeMaison, new Object[]{"Photo","Nom","Adresse","Note","Prix"});
        DefaultTableModel tabAppart = new DefaultTableModel(donneeAppart, new Object[]{"Photo","Nom","Adresse","Note","Prix"});
        DefaultTableModel tabChalet = new DefaultTableModel(donneeChalet, new Object[]{"Photo","Nom","Adresse","Note","Prix"});
        DefaultTableModel tabVilla = new DefaultTableModel(donneeVilla, new Object[]{"Photo","Nom","Adresse","Note","Prix"});
        DefaultTableModel tabComplexe = new DefaultTableModel(donneeComplexe, new Object[]{"Photo","Nom","Adresse","Note","Prix"});

        /** CREATION DE 6 TABLES COMPRENANT LES OFFRES POUR 6 TYPES DE LOGEMENT */
        setTableHotel(new JTable(tabHotel));
        setTableMaison(new JTable(tabMaison));
        setTableAppart(new JTable(tabAppart));
        setTableChalet(new JTable(tabChalet));
        setTableVilla(new JTable(tabVilla));
        setTableComplexe(new JTable(tabComplexe));

        /** PARAMETRES DES TABLES */
        tableHotel.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());
        tableHotel.setRowHeight(100);
        tableHotel.setShowGrid(true);
        for(int i=1;i<5;i++){
            tableHotel.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        tableHotel.setBackground(new Color(168, 147, 120));
        tableHotel.setBounds(20,20,600,300);
        /** -------- */
        tableMaison.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());
        tableMaison.setRowHeight(100);
        tableMaison.setShowGrid(true);
        for(int i=1;i<5;i++){
            tableMaison.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        tableMaison.setBackground(new Color(217, 202, 182));
        tableMaison.setBounds(20,20,600,300);
        /** -------- */
        tableAppart.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());
        tableAppart.setRowHeight(100);
        tableAppart.setShowGrid(true);
        for(int i=1;i<5;i++){
            tableAppart.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        tableAppart.setBackground(new Color(168, 147, 120));
        tableAppart.setBounds(20,20,600,100*appartRecup.size());
        /** -------- */
        tableVilla.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());
        tableVilla.setRowHeight(100);
        tableVilla.setShowGrid(true);
        for(int i=1;i<5;i++){
            tableVilla.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        tableVilla.setBackground(new Color(168, 147, 120));
        tableVilla.setBounds(20,20,600,300);
        /** -------- */
        tableComplexe.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());
        tableComplexe.setRowHeight(100);
        tableComplexe.setShowGrid(true);
        for(int i=1;i<5;i++){
            tableComplexe.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        tableComplexe.setBackground(new Color(217, 202, 182));
        tableComplexe.setBounds(20,20,600,300);
        /** -------- */
        tableChalet.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());
        tableChalet.setRowHeight(100);
        tableChalet.setShowGrid(true);
        for(int i=1;i<5;i++){
            tableChalet.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        tableChalet.setBackground(new Color(217, 202, 182));
        tableChalet.setBounds(20,20,600,300);

        /** AJOUT SCROLL BAR SUR CHAQUE TABLE */
        JScrollPane scrollHotel = new JScrollPane(tableHotel);
        scrollHotel.setBounds(100,10,700,300);
        panelHotel.add(scrollHotel);
        JScrollPane scrollMaison = new JScrollPane(tableMaison);
        scrollMaison.setBounds(100,10,700,300);
        panelMaison.add(scrollMaison);
        JScrollPane scrollAppart = new JScrollPane(tableAppart);
        scrollAppart.setBounds(100,10,700,300);
        panelAppartement.add(scrollAppart);
        JScrollPane scrollVilla = new JScrollPane(tableVilla);
        scrollVilla.setBounds(100,10,700,300);
        panelVilla.add(scrollVilla);
        JScrollPane scrollComplexe = new JScrollPane(tableComplexe);
        scrollComplexe.setBounds(100,10,700,300);
        panelComplexeHotelier.add(scrollComplexe);
        JScrollPane scrollChalet = new JScrollPane(tableChalet);
        scrollChalet.setBounds(100,10,700,300);
        panelChalet.add(scrollChalet);

       /** EVENEMENT SI CLIC SUR L'UNE DES OFFRES */
       tableHotel.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               if(e.getClickCount()==1)
               {
                   int ligne = tableHotel.getSelectedRow();
                   setLogementSelectionne(hotelRecup.get(ligne)); /** passage du logement selectionné en paramètre */
                    System.out.println("TESSSSSSSST");
               }
           }
       });
        tableAppart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1)
                {
                    int ligne = tableAppart.getSelectedRow();
                    setLogementSelectionne(appartRecup.get(ligne)); /** passage du logement selectionné en paramètre */
                    System.out.println("TESSSSSSSST");
                }
            }
        });
        tableComplexe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1)
                {
                    int ligne = tableComplexe.getSelectedRow();
                    setLogementSelectionne(complexeRecup.get(ligne)); /** passage du logement selectionné en paramètre */
                    System.out.println("TESSSSSSSST");
                }
            }
        });
        tableMaison.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1)
                {
                    int ligne = tableMaison.getSelectedRow();
                    setLogementSelectionne(maisonRecup.get(ligne)); /** passage du logement selectionné en paramètre */
                    System.out.println("TESSSSSSSST");
                }
            }
        });
        tableVilla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1)
                {
                    int ligne = tableVilla.getSelectedRow();
                    setLogementSelectionne(villaRecup.get(ligne)); /** passage du logement selectionné en paramètre */
                    System.out.println("TESSSSSSSST");
                }
            }
        });
        tableChalet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1)
                {
                    int ligne = tableChalet.getSelectedRow();
                    setLogementSelectionne(chaletRecup.get(ligne)); /** passage du logement selectionné en paramètre */
                    System.out.println("TESSSSSSSST");
                }
            }
        });

    }



    /** CLASSE PERMETTANT DE CHARGER UNE IMAGE DANS LE TABLEAU */
    static class ImageCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof URL) {
                try {
                    BufferedImage img = ImageIO.read((URL) value);
                    ImageIcon icon = new ImageIcon(scaleImage(img, 80, 80));
                    label.setIcon(icon);
                    label.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return label;
        }

        private Image scaleImage(BufferedImage img, int width, int height) {
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return scaledImage;
        }
    }
}

