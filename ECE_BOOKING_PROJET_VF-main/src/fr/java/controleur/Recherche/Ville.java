package fr.java.controleur.Recherche;

import java.util.*;

public class Ville
{
    /**ATTRIBUTS*/
    private int idVille;
    private String nomVille;
    private String nomPaysAppartenance;
    private ArrayList<Hebergement> listeHebergement;
    private String description; /**Ajouté. Peut etre pas mal d'avoir une petite phrase qui présente la ville*/
    private ArrayList<Aeroport> aeroportAProximite;
    private ArrayList<Transport> transportDansLaVille;
    private ArrayList<Activite> activitesAProximite;

    /**CONSTRUCTEURS*/
    public Ville(int idVille, String nom, String pays, String description)
    {
        this.idVille = idVille;
        this.nomVille = nom;
        this.nomPaysAppartenance = pays;
        this.description = description;
        this.aeroportAProximite = new ArrayList<>();    /**On ajoute un par un en recuperant les données de la BDD*/
        this.transportDansLaVille = new ArrayList<>();
        this.activitesAProximite = new ArrayList<>();
        this.listeHebergement = new ArrayList<>();
    }


    public Ville() {
        this.aeroportAProximite = new ArrayList<>();    /**On ajoute un par un en recuperant les données de la BDD*/
        this.transportDansLaVille = new ArrayList<>();
        this.activitesAProximite = new ArrayList<>();
        this.listeHebergement = new ArrayList<>();
    }


    /**ACCESSEURS*/

    public int getIdVille() {
        return idVille;
    }
    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getNomPaysAppartenance() {
        return nomPaysAppartenance;
    }

    public void setNomPaysAppartenance(String nomPaysAppartenance) {
        this.nomPaysAppartenance = nomPaysAppartenance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Aeroport> getAeroportAProximite() {
        return aeroportAProximite;
    }

    public void setAeroportAProximite(ArrayList<Aeroport> aeroportAProximite) {
        this.aeroportAProximite = aeroportAProximite;
    }

    public ArrayList<Activite> getActivitesAProximite() {
        return activitesAProximite;
    }

    public void setActivitesAProximite(ArrayList<Activite> activitesAProximite) {
        this.activitesAProximite = activitesAProximite;
    }

    public ArrayList<Transport> getTransportDansLaVille() {
        return transportDansLaVille;
    }

    public void setTransportDansLaVille(ArrayList<Transport> transportDansLaVille) {
        this.transportDansLaVille = transportDansLaVille;
    }
    public ArrayList<Hebergement> getListeHebergement() {
        return listeHebergement;
    }
    public void ajouterHebergement(Hebergement nouveau) {
        this.listeHebergement.add(nouveau);
    }

    public void setListeHebergement(ArrayList<Hebergement> listeHebergement) {
        this.listeHebergement = listeHebergement;
    }

    /**METHODES*/
    public void modifierOuSupprimerHebergement()
    {
        Scanner recup = new Scanner(System.in);

        System.out.println("Voici la liste de tous les hebergements de cette ville : ");

        /** A MODIFIER */
        for(int i=0 ; i<getListeHebergement().size() ; i++)
        {
            System.out.println(getListeHebergement().get(i).toString());
        }
        /** //////////////// */

        System.out.print("Selectionnez un logement dans cette liste (numero de placement) : ");
        int position = recup.nextInt();

        ArrayList<Hebergement> nouvelleListe = getListeHebergement();
        Hebergement aModifier = nouvelleListe.remove(position);

        System.out.println("Que voulez vous faire ?\n 1: Le supprimer\n Le modifier");

        switch(recup.nextInt())
        {
            case 1: setListeHebergement(nouvelleListe);
                break;
            case 2: //aModifier.modifierHebergement();
                nouvelleListe.add(aModifier);
                setListeHebergement(nouvelleListe);
                break;
        }
    }

    public void ajouterHebergement()
    {
        Scanner recup = new Scanner(System.in);

        System.out.println("Quel est la catégorie de l'hebergement souhaité :\n 1: Appartement\n 2: Chalet\n 3: Complexe Hotelier\n 4: Hotel\n 5: Maison\n 6: Villa");

        switch (recup.nextInt())
        {
            case 1: Appartement nouveauAppart = new Appartement();
                nouveauAppart.creerLogement();
                ajouterHebergement(nouveauAppart);
                break;
            case 2: Chalet nouveauChalet = new Chalet();
                nouveauChalet.creerLogement();
                ajouterHebergement(nouveauChalet);
                break;
            case 3: ComplexeHotelier nouveauCH = new ComplexeHotelier();
                nouveauCH.creerLogement();
                ajouterHebergement(nouveauCH);
                break;
            case 4: Hotel nouveauHotel = new Hotel();
                nouveauHotel.creerLogement();
                ajouterHebergement(nouveauHotel);
                break;
            case 5: Maison nouvelleMaison = new Maison();
                nouvelleMaison.creerLogement();
                ajouterHebergement(nouvelleMaison);
                break;
            case 6: Villa nouvelleVilla = new Villa();
                nouvelleVilla.creerLogement();
                ajouterHebergement(nouvelleVilla);
                break;
        }
    }

    public void modifierAeroportsAProximite()
    {
        Scanner recup = new Scanner(System.in);

        System.out.println("Voici les aeroports à proximités de cette ville : ");

        for(int i=0 ; i<getAeroportAProximite().size() ; i++)
        {
            System.out.println((i+1) + ": " + getAeroportAProximite().get(i).getNomAeroport());
        }

        System.out.print("Que voulez vous faire : \n 1: Modifier un aeroport\n 2: Ajouter un aeroport\n 3: Supprimer un aeroport\n");
        Aeroport traitement = new Aeroport();
        ArrayList<Aeroport> nouvelleListe = getAeroportAProximite();
        switch (recup.nextInt())
        {
            case 1: System.out.print("Quel aeroport voulez vous modifier ? (entrez son numero d'affichage) : ");
                    nouvelleListe.remove(recup.nextInt()-1);
                    traitement.modifierAeroport();
                    nouvelleListe.add(traitement);
                break;
            case 2: traitement.modifierAeroport();
                    nouvelleListe.add(traitement);
                break;
            case 3: System.out.print("Quel aeroport voulez vous supprimer ? (entrez son numero d'affichage) : ");
                    nouvelleListe.remove(recup.nextInt()-1);
                break;
        }
        setAeroportAProximite(nouvelleListe);
    }

    public void modifierTransports()
    {
        Scanner recup = new Scanner(System.in);

        System.out.println("Voici les transports de cette ville : ");

        for(int i=0 ; i<getTransportDansLaVille().size() ; i++)
        {
            System.out.println((i+1) + ": " + getTransportDansLaVille().get(i).getNomTransport() + " : ");
            for (int j=0 ; j<getTransportDansLaVille().get(i).getTrajetDuTransport().size() ; j++)
            {
                System.out.println("Station " + (j+1) + " : " + getTransportDansLaVille().get(i).getTrajetDuTransport().get(j));
            }
        }

        System.out.print("Que voulez vous faire : \n 1: Modifier un transport\n 2: Ajouter un transport\n 3: Supprimer un transport\n");
        Transport traitement = new Transport();
        ArrayList<Transport> nouvelleListe = getTransportDansLaVille();
        switch (recup.nextInt())
        {
            case 1: System.out.print("Quel transport voulez vous modifier ? (entrez son numero d'affichage) : ");
                nouvelleListe.remove(recup.nextInt()-1);
                traitement.modifierTransport();
                nouvelleListe.add(traitement);
                break;
            case 2: traitement.modifierTransport();
                nouvelleListe.add(traitement);
                break;
            case 3: System.out.print("Quel transport voulez vous supprimer ? (entrez son numero d'affichage) : ");
                nouvelleListe.remove(recup.nextInt()-1);
                break;
        }
        setTransportDansLaVille(nouvelleListe);
    }

    public void modifierActivitees()
    {
        Scanner recup = new Scanner(System.in);

        System.out.println("Voici les activitées à proximitées de cette ville : ");

        for(int i=0 ; i<getActivitesAProximite().size() ; i++)
        {
            System.out.println((i+1) + ": " + getActivitesAProximite().get(i).getNomActivite() + " : " + getActivitesAProximite().get(i).getPresentationActivite());
        }

        System.out.print("Que voulez vous faire : \n 1: Modifier une activité\n 2: Ajouter une activité\n 3: Supprimer une activité\n");
        Activite traitement = new Activite();
        ArrayList<Activite> nouvelleListe = getActivitesAProximite();
        switch (recup.nextInt())
        {
            case 1: System.out.print("Quel activité voulez vous modifier ? (entrez son numero d'affichage) : ");
                nouvelleListe.remove(recup.nextInt()-1);
                traitement.creerNouvelleActivite();
                nouvelleListe.add(traitement);
                break;
            case 2: traitement.creerNouvelleActivite();
                nouvelleListe.add(traitement);
                break;
            case 3: System.out.print("Quel aeroport voulez vous supprimer ? (entrez son numero d'affichage) : ");
                nouvelleListe.remove(recup.nextInt()-1);
                break;
        }
        setActivitesAProximite(nouvelleListe);
    }

    public void affichageVille()
    {
        System.out.println(toString());

        for(int i=0;i<aeroportAProximite.size();i++)
        {
            aeroportAProximite.get(i).affichageAeroport();
        }
        for(int i=0;i<transportDansLaVille.size();i++)
        {
            transportDansLaVille.get(i).affichageTransport();
        }
        System.out.println();
        for(int i=0;i<activitesAProximite.size();i++)
        {
            activitesAProximite.get(i).affichageActivites();
        }
        System.out.println();

        for(int i=0;i<listeHebergement.size();i++)
        {
            listeHebergement.get(i).affichageHebergement();
        }

        System.out.println("--------------------------------------------------");

    }

    public String toString()
    {
        return "Ville : " + this.idVille+ "|" +this.nomVille + "|" + this.nomVille + "|" + this.nomPaysAppartenance + "|" + this.description + "\n";
    }

    public void ajouterTransport(Transport nouveau) {
        this.transportDansLaVille.add(nouveau);
    }

    public void ajouterActiviteAProximite(Activite nouvelle) {
        this.activitesAProximite.add(nouvelle);
    }

    public void ajouterAeroportAProximite(Aeroport nouveau) {
        this.aeroportAProximite.add(nouveau);
    }

}
