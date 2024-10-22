package fr.java.controleur.Recherche;

import java.util.*;

public class Option
{
    /**ATTRIBUTS*/
    private boolean wifi;
    private boolean serviceMenage;
    private boolean climatisation;
    private boolean fumeur;
    private boolean coffreFort;
    private String descriptionDeLaVue;
    private boolean parkingPrivee;
    private boolean bar;

    /**CONSTRUCTEURS*/
    public Option() {
        this.wifi = false;
        this.bar = false;
        this.climatisation = false;
        this.coffreFort = false;
        this.fumeur = false;
        this.parkingPrivee = false;
        this.serviceMenage = false;
    }

    public Option(boolean  wifi, boolean serviceMenage, boolean climatisation, boolean fumeur, boolean coffreFort, String descriptionDeLaVue, boolean parkingPrivee, boolean bar){
        this.wifi = wifi;
        this.serviceMenage = serviceMenage;
        this.climatisation = climatisation;
        this.fumeur = fumeur;
        this.coffreFort = coffreFort;
        this.descriptionDeLaVue = descriptionDeLaVue;
        this.parkingPrivee = parkingPrivee;
        this.bar = bar;
    }

    /**ACCESSEURS*/
    public boolean getWifi() {
        return wifi;
    }

    public boolean getServiceMenage() {
        return serviceMenage;
    }

    public boolean getClimatisation() {
        return climatisation;
    }

    public boolean getFumeur() {
        return fumeur;
    }

    public boolean getCoffreFort() {
        return coffreFort;
    }

    public boolean getParkingPrivee() {
        return parkingPrivee;
    }

    public boolean getBar() {
        return bar;
    }

    public String getDescriptionDeLaVue() {
        return descriptionDeLaVue;
    }

    public void setWifi(boolean etat) {
        this.wifi = etat;
    }

    public void setServiceMenage(boolean etat) {
        this.serviceMenage = etat;
    }

    public void setClimatisation(boolean etat) {
        this.climatisation = etat;
    }

    public void setBar(boolean etat) {
        this.bar = etat;
    }

    public void setCoffreFort(boolean etat) {
        this.coffreFort = etat;
    }

    public void setDescriptionDeLaVue(String description) {
        this.descriptionDeLaVue = description;
    }

    public void setFumeur(boolean etat) {
        this.fumeur = etat;
    }

    public void setParkingPrivee(boolean etat) {
        this.parkingPrivee = etat;
    }

    public void affichageOption()
    {
        System.out.println("options : "+this.wifi + "|"+ this.serviceMenage + "|"+ this.climatisation + "|"+ this.fumeur + "|"+ this.coffreFort + "|"+ this.descriptionDeLaVue + "|"+ this.parkingPrivee + "|"+ this.bar+"\n");
    }
    /**METHODES*/
    public void modifierOptionsSupplementaires()
    {
        Scanner recup = new Scanner(System.in);

        boolean finModif = false;

        while(!finModif)
        {
            System.out.println("Que voulez vous modifier ? \n 1: Wifi\n 2: Service ménage\n 3: Climatisation\n 4: Coffre fort\n 5: Fumeur\n 6: Description du logement\n 7: Parking privé\n 8: Bar\n 9: Quitter les modifications des options supplémentaires");

            switch (recup.nextInt())
            {
                case 1: setWifi(!getWifi());
                    break;
                case 2: setServiceMenage(!getServiceMenage());
                    break;
                case 3: setClimatisation(!getClimatisation());
                    break;
                case 4: setCoffreFort(!getCoffreFort());
                    break;
                case 5: setFumeur(!getFumeur());
                    break;
                case 6: System.out.print("Saisissez la nouvelle description de la vue du logement : ");
                    setDescriptionDeLaVue(recup.nextLine());
                    recup.nextLine();
                    break;
                case 7: setParkingPrivee(!getParkingPrivee());
                    break;
                case 8: setBar(!getBar());
                    break;
                case 9: finModif = true;
                    break;
            }
        }
    }

    public void creerOption()
    {
        Scanner recup = new Scanner(System.in);

        boolean finModif = false;

        while(!finModif)
        {
            System.out.println("Que voulez vous ajouter comme option dans le logement ? \n 1: Wifi\n 2: Service ménage\n 3: Climatisation\n 4: Coffre fort\n 5: Fumeur\n 6: Description du logement\n 7: Parking privé\n 8: Bar\n 9: Finir l'ajout d'options");

            switch (recup.nextInt())
            {
                case 1: setWifi(!getWifi());
                    break;
                case 2: setServiceMenage(!getServiceMenage());
                    break;
                case 3: setClimatisation(!getClimatisation());
                    break;
                case 4: setCoffreFort(!getCoffreFort());
                    break;
                case 5: setFumeur(!getFumeur());
                    break;
                case 6: System.out.print("Saisissez la nouvelle description de la vue du logement : ");
                    setDescriptionDeLaVue(recup.nextLine());
                    recup.nextLine();
                    break;
                case 7: setParkingPrivee(!getParkingPrivee());
                    break;
                case 8: setBar(!getBar());
                    break;
                case 9: finModif = true;
                    break;
            }
        }
    }

}
