package fr.java.controleur.MiseAJour;


import java.util.Calendar;

public class Paiement {
    /**ATTRIBUTS*/
    private int montantDeLaTransaction;
    private String prenomDuPayeur;
    private String nomDuPayeur;
    private long numeroCarteBancaire;
    private String titulaireDeLaCarte;
    private Calendar dateExpirationDeLaCarte;
    private int numeroDeSecurite;

    /**CONSTRUCTEURS*/
    public Paiement(int montant, String prenom, String nom, long numeroCB, String titulaire, Calendar expiration, int numSecu)
    {
        this.montantDeLaTransaction = montant;
        this.nomDuPayeur = nom;
        this.prenomDuPayeur = prenom;
        this.numeroCarteBancaire = numeroCB;
        this.titulaireDeLaCarte = titulaire;
        this.dateExpirationDeLaCarte = expiration;
        this.numeroDeSecurite = numSecu;
    }

    public Paiement()
    {
        this.dateExpirationDeLaCarte = Calendar.getInstance();
    }

    /**ACCESSEURS*/
    public int getMontantDeLaTransaction() {
        return montantDeLaTransaction;
    }

    public void setMontantDeLaTransaction(int montantDeLaTransaction) {this.montantDeLaTransaction = montantDeLaTransaction;}

    public long getNumeroCarteBancaire() {
        return numeroCarteBancaire;
    }

    public void setNumeroCarteBancaire(long numeroCarteBancaire) {
        this.numeroCarteBancaire = numeroCarteBancaire;
    }

    public String getNomDuPayeur() {
        return nomDuPayeur;
    }

    public void setNomDuPayeur(String nomDuPayeur) {
        this.nomDuPayeur = nomDuPayeur;
    }

    public String getPrenomDuPayeur() {
        return prenomDuPayeur;
    }

    public void setPrenomDuPayeur(String prenomDuPayeur) {
        this.prenomDuPayeur = prenomDuPayeur;
    }

    public Calendar getDateExpirationDeLaCarte() {
        return dateExpirationDeLaCarte;
    }

    public void setDateExpirationDeLaCarte(Calendar dateExpirationDeLaCarte) {this.dateExpirationDeLaCarte = dateExpirationDeLaCarte;}

    public int getNumeroDeSecurite() {
        return numeroDeSecurite;
    }

    public void setNumeroDeSecurite(int numeroDeSecurite) {
        this.numeroDeSecurite = numeroDeSecurite;
    }

    public void setTitulaireDeLaCarte(String titulaireDeLaCarte) {
        this.titulaireDeLaCarte = titulaireDeLaCarte;
    }

public String getTitulaireDeLaCarte() {
        return titulaireDeLaCarte;
    }
    /**METHODES*/
    @Override
    public String toString() {
        return "Paiement{" +
                "montantDeLaTransaction=" + montantDeLaTransaction +
                ", prenomDuPayeur='" + prenomDuPayeur + '\'' +
                ", nomDuPayeur='" + nomDuPayeur + '\'' +
                ", numeroCarteBancaire=" + numeroCarteBancaire +
                ", titulaireDeLaCarte='" + getTitulaireDeLaCarte() + '\'' +
                '}';
    }
}