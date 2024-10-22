package fr.java.controleur.MiseAJour;

import java.util.Calendar;
import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Hebergement;

public class Reservation {
    /**ATTRIBUTS*/
    private Client locataire;
    private Hebergement hebergementReserve;
    private int reductionUtilisee;
    private Paiement effectue;
    private boolean reservationPassee;
    private Calendar dateArrivee;
    private Calendar dateDepart;

    /**CONSTRUCTEURS*/
    public Reservation(Client locataire, Hebergement hebergementReserve, Paiement effectue, boolean resaFinie, Calendar debut, Calendar fin, int reduction) {

        this.locataire = locataire;
        this.hebergementReserve = hebergementReserve;
        this.reductionUtilisee = reduction;
        this.effectue = effectue;
        this.reservationPassee = resaFinie;
        this.dateArrivee = debut;
        this.dateDepart = fin;
    }

    /**ACCESSEURS*/
    public Client getLocataire() {
        return locataire;
    }

    public Hebergement getHebergementReserve() {
        return hebergementReserve;
    }

    public int getReductionUtilisee() {return reductionUtilisee;}

    public Paiement getEffectue() {
        return effectue;
    }

    public boolean isReservationPassee() {
        return reservationPassee;
    }

    public Calendar getDateArrivee() {
        return dateArrivee;
    }

    public Calendar getDateDepart() {
        return dateDepart;
    }

    /**METHODES*/

    //Affichage de la reservation
    public void affichageReservation()
    {
        System.out.println("Reservation de " + this.locataire.getPrenom() + " " + this.locataire.getNom() + " pour l'hebergement " + this.hebergementReserve.getNom() + " du " + this.dateArrivee.getTime() + " au " + this.dateDepart.getTime());
    }

}