package fr.java.controleur.Reporting;
import fr.java.controleur.MiseAJour.Reservation;
import java.util.ArrayList;

public class HistoriqueReservation
{
    /**ATTRIBUTS*/
    private ArrayList<Reservation> toutesLesReservations;
    private ArrayList<Reservation> lesReservationsPasPassee;

    /**CONSTRUCTEURS*/
    public HistoriqueReservation()
    {
        this.toutesLesReservations = new ArrayList<>();
        this.lesReservationsPasPassee = new ArrayList<>();
    }

    /**ACCESSEURS*/
    public ArrayList<Reservation> getToutesLesReservations() {
        return toutesLesReservations;
    }

    public void ajouterReservation(Reservation nouvelle) {
        this.toutesLesReservations.add(nouvelle);
    }

    public ArrayList<Reservation> getLesReservationsPasPassee() {
        return lesReservationsPasPassee;
    }
    public void ajouterReservationPasPasse(Reservation nouvelle)
    {
        this.lesReservationsPasPassee.add(nouvelle);
    }
    /**METHODES*/

    @Override
    public String toString() {
        return "HistoriqueReservation{" +
                "toutesLesReservations=" + toutesLesReservations +
                '}';
    }

    public void affichageHistorique()
    {
        for (Reservation r : this.toutesLesReservations)
        {
            r.affichageReservation();
        }
    }
}
