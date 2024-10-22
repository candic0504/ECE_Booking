package fr.java.controleur.Recherche;

import fr.java.controleur.MiseAJour.Paiement;
import fr.java.controleur.MiseAJour.Reservation;
import fr.java.controleur.Reporting.HistoriqueReservation;
import java.util.ArrayList;
public class Client extends Utilisateur {

    /**ATTRIBUTS*/

    private ArrayList<Reservation> reservationEnCours;
    private boolean clientRegulier;
    private int nombreDeLocationFaites;


    /**CONSTRUCTEURS*/

    public Client(String nom, String prenom, String identifiant, String motDePasse, boolean regulier, int nombreDeLocationFaites, ArrayList<Reservation> enCours)  //Client déjà connu sur le site
    {
        super(nom, prenom, identifiant, motDePasse);
        this.clientRegulier = regulier;
        this.nombreDeLocationFaites = nombreDeLocationFaites;
        this.reservationEnCours = enCours;
    }
    public Client() //Nouveau client sur le site
    {
        super();
        clientRegulier = false;
        nombreDeLocationFaites = 0;
        reservationEnCours = new ArrayList<>();
    }

    /**ACCESSEURS*/
    @Override
    public String getId() {
        return super.getId();
    }

    public ArrayList<Reservation> getReservationEnCours() {
        return reservationEnCours;
    }

    public void setReservationEnCours(ArrayList<Reservation> enCours) {
        this.reservationEnCours = enCours;
    }

    public boolean getClientRegulier() {
        return clientRegulier;
    }

    public void setClientRegulier(boolean clientRegulier) {
        this.clientRegulier = clientRegulier;
    }

    public int getNombreDeLocationFaites() {
        return nombreDeLocationFaites;
    }

    public void setNombreDeLocationFaites(int nombreDeLocationFaites) {
        this.nombreDeLocationFaites = nombreDeLocationFaites;
    }


    /**METHODES*/


    //Permet de verifier si le client existe et de retourneer son indice
    public int clientExiste(String identifiant, String motDePasse, ArrayList<Client> tousLesClients) {
        int optimisation = 0;
        int parcours = tousLesClients.size() - 1;
        int indiceClientListe = -1;

        while (optimisation == 0 && parcours >= 0) {
            if (tousLesClients.get(parcours).getId().equals(identifiant)) {
                if (tousLesClients.get(parcours).getMdp().equals(motDePasse)) {
                    indiceClientListe = parcours;
                    optimisation = 1;
                }
            }
            parcours--;
        }

        return indiceClientListe;
    }



    /**Permet de creer un compte client*/
    public void creerCompte(String nom, String prenom, String id, String mdp)
    {
        setNom(nom);
        setPrenom(prenom);
        setId(id);
        setMdp(mdp);
        setClientRegulier(false);
        setNombreDeLocationFaites(0);
        setReservationEnCours(new ArrayList<>());
    }

    /**Permet d'ajouter une reservation*/
    public void ajouterReservation(Reservation nouvelle) {
        ArrayList<Reservation> recup = new ArrayList<>();

        recup = getReservationEnCours();

        recup.add(nouvelle);

        setReservationEnCours(recup);
    }

    /**Permet de reserver un logement*/
    public HistoriqueReservation reserverLogement(Hebergement logementSouhaite, int prix, RechercheReservation criteresDeReservation, HistoriqueReservation historique, Paiement paiementClient)
    {

        int promotion;

        if(getClientRegulier())
        {
            promotion = logementSouhaite.getPromotion();
        }
        else {
            promotion = 0;
        }

        Reservation nouvelleResa = new Reservation(this, logementSouhaite, paiementClient, false, criteresDeReservation.getDateArrivee(), criteresDeReservation.getDateDepart(), promotion);

        System.out.println("NOM : " + getNom());
        ajouterReservation(nouvelleResa);
        setNombreDeLocationFaites(getNombreDeLocationFaites()+1);

        if(getNombreDeLocationFaites() > 3)
        {
            setClientRegulier(true);
        }

        historique.ajouterReservation(nouvelleResa);
        historique.ajouterReservationPasPasse(nouvelleResa);

        return historique;
    }

    /**Permet de verifier si le client est connecté*/
    public boolean isConnected()
    {
        boolean connecte = false;

        if(getId() != null)
        {
            connecte = true;
        }

        return connecte;
    }

    /**Permet d'afficher le client*/
    public void affichageClient()
    {
        System.out.println("Nom : " + super.getNom() + "\nPrenom : " + super.getPrenom() + "\nID : " + super.getId() + "\nMdp : " + super.getMdp() + "\n");
        for(int i = 0; i < this.reservationEnCours.size(); i++)
        {
            this.reservationEnCours.get(i).affichageReservation();
        }
    }
    public String toString() {
        return "Nom : " + super.getNom() + "\nPrenom : " + super.getPrenom() + "\nID : " + super.getId() + "\nMdp : " + super.getMdp() + "\n";
    }

}
