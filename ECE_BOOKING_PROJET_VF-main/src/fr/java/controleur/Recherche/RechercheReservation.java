package fr.java.controleur.Recherche;
import java.util.*;

public class RechercheReservation
{
    /**ATTRIBUTS*/
    private String categorie;
    private int prixMaximum;
    private String ville;
    private int nombreAdulte;
    private int nombreEnfant;
    private int nombreDeChambre;
    private Calendar dateArrivee;
    private Calendar dateDepart;
    private Option filtreSupplementaire;

    /**CONSTRUCTEURS*/
    public RechercheReservation() {
        this.categorie = "rien";
        this.prixMaximum = -1;
        this.nombreDeChambre = -1;
        this.filtreSupplementaire = new Option();
        this.dateArrivee = Calendar.getInstance();
        this.dateDepart = Calendar.getInstance();
    }

    /**ACCESSEURS*/
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String nouvelleCategorie) {
        this.categorie = nouvelleCategorie;
    }
    public int getPrixMaximum() {
        return prixMaximum;
    }
    public void setPrixMaximum(int prixMaximum) {
        this.prixMaximum = prixMaximum;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNombreAdulte() {
        return nombreAdulte;
    }

    public void setNombreAdulte(int nombreAdulte) {
        this.nombreAdulte = nombreAdulte;
    }

    public int getNombreEnfant() {
        return nombreEnfant;
    }

    public void setNombreEnfant(int nombreEnfant) {
        this.nombreEnfant = nombreEnfant;
    }

    public int getNombreDeChambre() {
        return nombreDeChambre;
    }
    public void setNombreDeChambre(int nombreDeChambre) {
        this.nombreDeChambre = nombreDeChambre;
    }
    public Calendar getDateArrivee() {return dateArrivee;}
    public void setDateArrivee(Calendar dateArrivee) {this.dateArrivee = dateArrivee;}
    public Calendar getDateDepart() {return dateDepart;}
    public void setDateDepart(Calendar dateDepart) {this.dateDepart = dateDepart;}

    public Option getFiltreSupplementaire() {
        return filtreSupplementaire;
    }

    public void setFiltreSupplementaire(Option filtreSupplementaire) {
        this.filtreSupplementaire = filtreSupplementaire;
    }

    /**METHODES*/

    public void selectionCritereDeLogementObligatoire()    /** A MODIFIER AVEC L'INTERFACE GRAPHIQUE*/
    {
        Scanner recup = new Scanner(System.in);

        System.out.println("SELECTIONNEZ LES CRITERES DU LOGEMENT QUI VOUS INTERESSE : ");
        System.out.print("Ville de destination : ");
        setVille(recup.nextLine());
        recup.nextLine();
        System.out.print("Nombre d'adulte (au dessus de 18 ans) : ");
        setNombreAdulte(recup.nextInt());
        System.out.print("Nombre d'enfant : ");
        setNombreEnfant(recup.nextInt());
        Calendar dateDebut = Calendar.getInstance();
        Calendar dateFin = Calendar.getInstance();
        System.out.println("La date d'arrivée : ");
        System.out.print("\t Jour : ");
        dateDebut.set(Calendar.DAY_OF_MONTH, recup.nextInt());
        System.out.print("\t Mois : ");
        dateDebut.set(Calendar.MONTH, recup.nextInt()-1);
        System.out.print("\t Annee : ");
        dateDebut.set(Calendar.YEAR, recup.nextInt());
        System.out.println("La date de départ : ");
        System.out.print("\t Jour : ");
        dateFin.set(Calendar.DAY_OF_MONTH, recup.nextInt());
        System.out.print("\t Mois : ");
        dateFin.set(Calendar.MONTH, recup.nextInt()-1);
        System.out.print("\t Annee : ");
        dateFin.set(Calendar.YEAR, recup.nextInt());
        setDateArrivee(dateDebut);
        setDateDepart(dateFin);
    }

    public long nombreDeJour()
    {
        long tempsEnMillis = getDateDepart().getTimeInMillis() - getDateArrivee().getTimeInMillis();
        long tempsEnJours = tempsEnMillis / (24*60*60*1000);
        /**System.out.println("Jour arrive : " + getDateArrivee().get(Calendar.DAY_OF_MONTH) + "/" + (getDateArrivee().get(Calendar.MONTH)+1) + "/" + getDateArrivee().get(Calendar.YEAR));
        System.out.println("Jour depart : " + getDateDepart().get(Calendar.DAY_OF_MONTH) + "/" + (getDateDepart().get(Calendar.MONTH)+1) + "/" + getDateDepart().get(Calendar.YEAR));*/
        System.out.println("IL Y A DONC " + tempsEnJours + " dans le sejour");
        return tempsEnJours;
    }

    public void afficherLogementCorrespondant(ArrayList<Hebergement> tousLesLogementsCorrespondants, HashMap<Hebergement, Integer> prixAssocies)
    {
        /** AFFICHAGE GRAPHIQUE CANDICE */
        System.out.println("AFFICHAGE DES LOGEMENTS CORRESPONDANTS");
        for(int i = 0 ; i<tousLesLogementsCorrespondants.size() ; i++)
        {
            System.out.println(tousLesLogementsCorrespondants.get(i).toString() + " Prix total du séjour : " + prixAssocies.get(tousLesLogementsCorrespondants.get(i)) + " euros");
        }
    }

    public void ajouterCritere()
    {
        Scanner recup = new Scanner(System.in);

        System.out.println("Quel critère voulez vous ajouter ?\n 1: Catégorie de logement\n 2: Prix maximum pour le séjour\n 3: Nombre de chambre\n 4: Wifi\n 5: Service de ménage\n 6: Climatisation\n 7: Fumeur\n 8: Coffre fort\n 9: Parking privé\n 10: Bar");

        switch (recup.nextInt())
        {
            case 1: System.out.print("Selectionnez la catégorie de logement souhaitée : ");
                    setCategorie(recup.nextLine());
                    recup.nextLine();
                break;
            case 2: System.out.print("Selectionnez le prix maximum pour le séjour : ");
                setPrixMaximum(recup.nextInt());
                break;
            case 3: System.out.print("Selectionnez le nombre de chambre souhaité : ");
                setNombreDeChambre(recup.nextInt());
                break;
            case 4: modificationOption("Wifi");
                System.out.println("WIFI AJOUTE");
                break;
            case 5: modificationOption("Service de ménage");
                System.out.println("SERVICE DE MENAGE AJOUTE");
                break;
            case 6: modificationOption("Climatisation");
                System.out.println("CLIMATISATION AJOUTE");
                break;
            case 7: modificationOption("Fumeur");
                System.out.println("FUMEUR AJOUTE");
                break;
            case 8: modificationOption("Coffre fort");
                System.out.println("COFFRE FORT AJOUTE");
                break;
            case 9: modificationOption("Parking privé");
                System.out.println("PARKING PRIVE AJOUTE");
                break;
            case 10:modificationOption("Bar");
                System.out.println("BAR AJOUTE");
                break;
        }
    }

    public void modificationOption(String typeOption)
    {
        Option nouvelle = getFiltreSupplementaire();

        switch(typeOption)
        {
            case "Wifi": nouvelle.setWifi(!nouvelle.getWifi());
                break;
            case "Service de ménage": nouvelle.setServiceMenage(!nouvelle.getServiceMenage());
                break;
            case "Climatisation": nouvelle.setClimatisation(!nouvelle.getClimatisation());
                break;
            case "Fumeur": nouvelle.setFumeur(!nouvelle.getFumeur());
                break;
            case "Coffre fort": nouvelle.setCoffreFort(!nouvelle.getCoffreFort());
                break;
            case "Parking privé": nouvelle.setParkingPrivee(!nouvelle.getParkingPrivee());
                break;
            case "Bar": nouvelle.setBar(!nouvelle.getBar());
                break;
        }

        setFiltreSupplementaire(nouvelle);
    }

    @Override
    public String toString() {
        return "RechercheReservation{" +
                "categorie='" + categorie + '\'' +
                ", prixMaximum=" + prixMaximum +
                ", ville='" + ville + '\'' +
                ", nombreDePersonne=" + nombreAdulte +
                ", nombreDeChambre=" + nombreDeChambre +
                ", dateArrivee=" + dateArrivee +
                ", dateDepart=" + dateDepart +
                '}';
    }

}
