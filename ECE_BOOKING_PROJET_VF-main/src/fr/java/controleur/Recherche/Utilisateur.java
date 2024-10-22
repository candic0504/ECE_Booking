package fr.java.controleur.Recherche;

import java.util.Scanner;
import java.lang.*;

public abstract class Utilisateur //classe abstraite
{
    /**ATTRIBUT**/
    private String nom;
    private String prenom;
    private String id;
    private String mdp;

    /** CONSTRUCTEUR */
    public Utilisateur(){}

    public Utilisateur(String nom, String prenom, String id, String mdp)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.mdp = mdp;
    }

    /**ACCESSEURS*/
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getMdp() {return mdp;}
    public void setMdp(String mdp) {this.mdp = mdp;}

    /**METHODE*/
    public void creationCompte(){ //création de comptes
        //RECUPERATION DES DONNEES POUR CREER UN COMPTE//
        System.out.println("SAISSISSEZ VOTRE NOM : \n");
        Scanner scan= new Scanner(System.in); //variable de scan
        this.nom=scan.nextLine();//récupération des caractères saisies

        System.out.println("SAISSISSEZ VOTRE PRENOM : \n");
        Scanner scan1= new Scanner(System.in); //variable de scan
        this.prenom=scan1.nextLine();//récupération des caractères saisies

        System.out.println("SAISSISSEZ VOTRE IDENTIFIANT : \n");
        Scanner scan2= new Scanner(System.in); //variable de scan
        this.id=scan2.nextLine();//récupération des caractères saisies

        System.out.println("SAISSISSEZ VOTRE MOT DE PASSE : \n");
        Scanner scan3= new Scanner(System.in); //variable de scan
        this.mdp=scan3.nextLine();//récupération des caractères saisies
    }
}
