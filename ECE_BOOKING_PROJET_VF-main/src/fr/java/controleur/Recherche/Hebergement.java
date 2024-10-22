package fr.java.controleur.Recherche;
import fr.java.controleur.MiseAJour.Reservation;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.swing.*;
import java.util.*;
import java.net.URL;

public abstract class Hebergement        /**a mettre en abstraite. Voir Pb avec class Reservation quand met en abstraite*/
{
    /**ATTRIBUTS*/
    private int id;
    private String nom;
    private String categorie;
    private String adresse;
    private HashMap<String, String> avisClients; /**Map avec le nom du client en cle et son commentaire en contenu*/
    private TreeMap<String, Integer> notesClients; /**Map ordonné avec l'identifiant du client en cle et sa note en contenu*/
    private Option optionSupplementairesProposees;
    private int capacite;
    private int nombreDeChambre;
    private int tarifUnAdulteUneNuit;
    private int tarifUnEnfantUneNuit;
    private int promotion;
    private String URL;


    /**CONSTRUCTEURS*/

    public Hebergement(int id,String nomHebergement, String adresseHebergement, Option optionSupplementairesProposees, int capacitePersonne, int nombreDeChambre, HashMap<String, String> avisClients, TreeMap<String, Integer> notesClients, int tarifAdulte, int tarifEnfant, String categorie,String URL,int promotion)
    {
        this.id = id;
        this.nom = nomHebergement;
        this.adresse = adresseHebergement;
        this.optionSupplementairesProposees = optionSupplementairesProposees;
        this.capacite = capacitePersonne;
        this.nombreDeChambre = nombreDeChambre;
        this.avisClients = avisClients;
        this.notesClients = notesClients;
        this.tarifUnAdulteUneNuit = tarifAdulte;
        this.tarifUnEnfantUneNuit = tarifEnfant;
        this.categorie = categorie;
        this.URL = URL;
        this.promotion = promotion;
    }

    public Hebergement(String categorie){
        this.categorie = categorie;
        this.avisClients = new HashMap<>();
        this.notesClients = new TreeMap<>();
        this.optionSupplementairesProposees = new Option();
    }


    /**ACCESSEURS*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public HashMap<String, String> getAvisClients() {
        return avisClients;
    }
    public void ajouterAvisClient(String nomClient, String avis) {
        this.avisClients.put(nomClient, avis);
    }

    public TreeMap<String, Integer> getNotesClients() {
        return notesClients;
    }
    public void ajouterNoteClient(String nomClient,int note) {
        this.notesClients.put(nomClient,note);
    }

    public Option getOptionSupplementairesProposees() {
        return optionSupplementairesProposees;
    }

    public void setOptionSupplementairesProposees(Option optionSupplementairesProposees) {this.optionSupplementairesProposees = optionSupplementairesProposees;}

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getNombreDeChambre() {
        return nombreDeChambre;
    }

    public void setNombreDeChambre(int nombreDeChambre) {
        this.nombreDeChambre = nombreDeChambre;
    }


    public int getTarifUnAdulteUneNuit() {
        return tarifUnAdulteUneNuit;
    }

    public void setTarifUnAdulteUneNuit(int tarifUnAdulteUneNuit) {
        this.tarifUnAdulteUneNuit = tarifUnAdulteUneNuit;
    }

    public int getTarifUnEnfantUneNuit() {
        return tarifUnEnfantUneNuit;
    }

    public void setTarifUnEnfantUneNuit(int tarifUnEnfantUneNuit) {
        this.tarifUnEnfantUneNuit = tarifUnEnfantUneNuit;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public abstract void affichageHebergement();


    public boolean getWifi() {
        return optionSupplementairesProposees.getWifi();
    }

    public boolean getServiceMenage() {
        return optionSupplementairesProposees.getServiceMenage();
    }

    public boolean getClimatisation() {
        return optionSupplementairesProposees.getClimatisation();
    }

    public boolean getFumeur() {
        return optionSupplementairesProposees.getFumeur();
    }
    public String getDescriptionVue() {
        return optionSupplementairesProposees.getDescriptionDeLaVue();
    }

    public boolean getCoffreFort() {
        return optionSupplementairesProposees.getCoffreFort();
    }


    public boolean getParking() {
        return optionSupplementairesProposees.getParkingPrivee();
    }

    public boolean getBar() {
        return optionSupplementairesProposees.getBar();
    }



    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


/**METHODES*/


    /**Permet d'afficher les détails*/
    public abstract JPanel afficherDetail(RechercheReservation criteresDemandes, Client utilisateurDuSite, String imageLogement);
    /**Permet de modifier les hebergements*/
    public abstract void modifierHebergement(JPanel panel);
    /**Permet de verifier lea disponibilité des logements hebergements*/
    public abstract boolean encoreDesChambresDispo(Calendar dateDebut, Calendar dateFin, ArrayList<Reservation> historiqueResaPasPassees, int nombreDeChambre);
    public void creerLogement()
    {
        Scanner recup = new Scanner(System.in);

        System.out.print("Saisissez le nom du logement : ");
        setNom(recup.nextLine());
        recup.nextLine();
        System.out.print("Saisissez l'adresse du logement : ");
        setAdresse(recup.nextLine());
        recup.nextLine();
        System.out.print("Saisissez la capacite du logement : ");
        setCapacite(recup.nextInt());
        System.out.print("Saisissez le nombre de chambre du logement : ");
        setNombreDeChambre(recup.nextInt());
        System.out.print("Saisissez le tarif une nuit pour un adulte du logement : ");
        setTarifUnAdulteUneNuit(recup.nextInt());
        System.out.print("Saisissez le tarif une nuit pour un enfant du logement : ");
        setTarifUnEnfantUneNuit(recup.nextInt());
        System.out.print("Saisissez la promotion applicable par un client regulier pour le logement : ");
        setPromotion(recup.nextInt());
        Option creationOptions = new Option();
        creationOptions.creerOption();
        setOptionSupplementairesProposees(creationOptions);

    }

    @Override
    public String toString() {
        return ("Categorie : " + getCategorie() + ", Nom : " + getNom() + ", Capacite : " + getCapacite());
    }

    public boolean disponibleACetteDate(Calendar dateDebut, Calendar dateFin, ArrayList<Reservation> historiqueResaPasPassees)
    {
        boolean dispo = true;
        int parcours = 0;

        while(parcours < historiqueResaPasPassees.size() && dispo)
        {
            if(historiqueResaPasPassees.get(parcours).getHebergementReserve() == this)
            {
                if((historiqueResaPasPassees.get(parcours).getDateArrivee().compareTo(dateDebut) < 0 && historiqueResaPasPassees.get(parcours).getDateDepart().compareTo(dateDebut) > 0) || (historiqueResaPasPassees.get(parcours).getDateArrivee().compareTo(dateFin) < 0 && historiqueResaPasPassees.get(parcours).getDateDepart().compareTo(dateFin) > 0))
                {
                    dispo = false;
                }
            }
        }

        return dispo;
    }

    public float moyenneNotesClients()
    {
        float resultat;

        if(getNotesClients().size() > 0)
        {
            Collection<Integer> toutesLesValeurs = getNotesClients().values();

            int sommeNotes = 0;
            for(int element : toutesLesValeurs)
            {
                if(element >= 0)
                {
                    sommeNotes += element;
                }
            }
            resultat = (float)(sommeNotes/toutesLesValeurs.size());
        }
        else {
            resultat = -1.0f;
        }


        return resultat;
    }

    public int calculPrixSejour(int nombreAdulte, int nombreEnfant, long dureeSejour, boolean clientRegulier)
    {
        int prix = (int)(((nombreAdulte*getTarifUnAdulteUneNuit())+(nombreEnfant*getTarifUnEnfantUneNuit()))*dureeSejour);

        /** Application d'une potentielle promotion si le client est un membre régulier */
        if(clientRegulier)
        {
            prix -= prix * (getPromotion()/100);
        }

        return prix;
    }
    /*--------------------------------------------------------------------*/
    /*--------------------------------------------------------------------*/
    public abstract ArrayList<Object> enregistrement();

    public String recupAvisClient(String cle) {
        HashMap<String, String> avisClients = getAvisClients(); // Appel de la méthode getAvisClients() pour récupérer la HashMap
        String avisClient = avisClients.get(cle); // Utilisation de la méthode get pour récupérer la valeur correspondante à la clé spécifiée
        return avisClient;
    }

    public Integer recupNotesClients(String cle) {
        TreeMap<String, Integer> notesClients = getNotesClients(); // Appel de la méthode getNotesClients() pour récupérer la TreeMap
        Integer noteClient = notesClients.get(cle); // Utilisation de la méthode get pour récupérer la valeur correspondante à la clé spécifiée
        if(noteClient == null){
            return -1;
        }
        return noteClient;
    }
    /*--------------------------------------------------------------------*/
    /*--------------------------------------------------------------------*/
}
