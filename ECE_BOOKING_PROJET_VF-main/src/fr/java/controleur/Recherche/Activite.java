package fr.java.controleur.Recherche;

import java.util.Scanner;

public class Activite
{
    /**ATTRIBUTS*/
    private String nomActivite;
    private String typeActivite; /**Lieux dit, attractions, sport, ...*/
    private String presentationActivite;

    /**CONSTRUCTEURS*/
    public Activite(String nom, String type, String presentation)
    {
        this.nomActivite = nom;
        this.typeActivite = type;
        this.presentationActivite = presentation;
    }

    public Activite(){}

    /**ACCESSEURS*/
    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public String getPresentationActivite() {
        return presentationActivite;
    }

    public void setPresentationActivite(String presentationActivite) {this.presentationActivite = presentationActivite;}

    public void affichageActivites()
    {
        System.out.println("Activite : " + this.nomActivite);
    }

    public String toString()
    {
        return ("Activite : " + this.nomActivite);
    }


    /**METHODES*/

    //Affichage des attributs de la classe
    public void affichage(){System.out.println("Nom : " + getNomActivite() + ", Type : " + getTypeActivite() + ", Description : " + getPresentationActivite());}

    /**Creation d'une nouvelle activité*/
    public void creerNouvelleActivite()
    {
        Scanner recup = new Scanner(System.in);

        System.out.print("Saisissez le nom de l'activité : ");
        setNomActivite(recup.nextLine());
        recup.nextLine();
        System.out.print("Saisissez le type de l'activité : ");
        setTypeActivite(recup.nextLine());
        recup.nextLine();
        System.out.print("Saisissez la description de l'activité : ");
        setPresentationActivite(recup.nextLine());
        recup.nextLine();
    }

}
