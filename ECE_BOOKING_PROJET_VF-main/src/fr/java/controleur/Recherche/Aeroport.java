package fr.java.controleur.Recherche;

import java.util.*;

public class Aeroport
{
    /**ATTRIBUTS*/
    private int idAeroport;
    private String nomAeroport;
    private boolean EstInternational;


    /**CONSTRUCTEURS*/
    public Aeroport(int idAeroport,String nom, boolean etat)
    {
        this.idAeroport = idAeroport;
        this.nomAeroport = nom;
        this.EstInternational = etat;
    }

    public Aeroport(){}

    /**ACCESSEURS*/

    public int getIdAeroport() {
        return idAeroport;
    }
    public String getNomAeroport() {
        return nomAeroport;
    }

    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport = nomAeroport;
    }

    public boolean isEstInternational() {
        return EstInternational;
    }

    public void setEstInternational(boolean estInternational) {
        EstInternational = estInternational;
    }

    /**METHODES*/

    //Methode toString retourne le nom et le booleen international
    public String toString()
    {
        return "Aeroport : " + this.idAeroport +"|" +this.nomAeroport+"|"+ this.EstInternational + "\n";
    }

    /**Affiche cet Aeroport*/
    public void affichageAeroport(){System.out.println("Aeroport : " + this.idAeroport +"|" +this.nomAeroport+"|"+ this.EstInternational + "\n");}

    /**Modifie le booleen international de l'Aeroport selectionné*/
    public void modifierAeroport()
    {
        Scanner recup = new Scanner(System.in);
        System.out.print("Saisissez le nom de l'aéroport : ");
        setNomAeroport(recup.nextLine());
        recup.nextLine();
        System.out.print("Est-il international (1: OUI, 2: NON) : ");
        switch (recup.nextInt()) {
            case 1 -> setEstInternational(true);
            case 2 -> setEstInternational(false);
        }
    }

}
