package fr.java.modele.dao;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.HistoriqueReservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TreeMap;
import fr.java.controleur.MiseAJour.Paiement;
import fr.java.controleur.MiseAJour.Reservation;

public class BaseDeDonnees {
    private static Connection connexion;
    private static Statement declaration;
    private static ResultSet resultat;

    private static String nomBDD;

    public BaseDeDonnees() {
        connexion = null;
        declaration = null;
        resultat = null;
        nomBDD = "ece_booking";
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }

    public void setDeclaration(Statement declaration) {
        this.declaration = declaration;
    }

    public void setResultat(ResultSet resultat) {
        this.resultat = resultat;
    }


    public Connection getConnection() {
        return connexion;
    }

    public Statement getDeclaration() {
        return declaration;
    }

    public ResultSet getResultat() {
        return resultat;
    }


    /* Connexion à la base de données */
    public void connexionBaseDeDonnees() throws Exception, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Connexion à la base de données...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String urlDatabase = "jdbc:mysql://localhost:3306/" + nomBDD;
        connexion = DriverManager.getConnection(urlDatabase, "root", "");
        System.out.println("Connexion établie");
    }

    /* Ajout de données à la table clients */
    public void ajout_donnees(Connection connexion, Statement declaration) throws SQLException {
        declaration = connexion.createStatement();
        declaration.executeUpdate("INSERT INTO clients VALUES ('Nom','Prenom','Rue','75','Ville', '+3321456478','Mail')");
    }

    public void suppression_donnees(Connection connexion, Statement declaration) throws SQLException {
        declaration = connexion.createStatement();
        declaration.executeUpdate("DELETE FROM clients WHERE nom = 'Nom'");
    }

    public static void recuperationDonneesVille(ArrayList<Ville> ListeVille) throws Exception {
        declaration = connexion.createStatement();
        resultat = declaration.executeQuery("SELECT * FROM ville");
        while (resultat.next()) {
            /*Création de la ville*/
            ListeVille.add(new Ville(resultat.getInt("ID_VILLE"), resultat.getString("NOM"), resultat.getString("NOM_PAYS"), resultat.getString("DESCRIPTION")));
        }
        ;
    }

    public static TreeMap<Integer, String> recuperationMap() throws Exception {
        TreeMap<Integer, String> temp = new TreeMap<>();
        for (int i = 1; i < 11; i++) {
            temp.put(i, resultat.getString("ARRET" + i));
        }
        return temp;
    }

    public static void recuperationDonneesTransports(ArrayList<Ville> ListeVille) throws Exception {
        declaration = connexion.createStatement();
        /*Création des Transports*/
        for (int i = 0; i < ListeVille.size(); i++) {
            resultat = declaration.executeQuery("SELECT * FROM transport WHERE ID_VILLE = " + ListeVille.get(i).getIdVille());
            while (resultat.next()) {
                ListeVille.get(i).ajouterTransport(new Transport(resultat.getString("NOM"), resultat.getString("TYPE"), recuperationMap()));
            }
        }
    }

    public static void recuperationDonneesActivites(ArrayList<Ville> ListeVille) throws Exception {

        /*Création des Activités*/
        for (int i = 0; i < ListeVille.size(); i++) {
            resultat = declaration.executeQuery("SELECT * FROM activites WHERE ID_VILLE = " + ListeVille.get(i).getIdVille());
            while (resultat.next()) {
                ListeVille.get(i).ajouterActiviteAProximite(new Activite(resultat.getString("NOM"), resultat.getString("TYPE"), resultat.getString("PRESENTATION")));
            }
            ;
        }
    }

    public static void recuperationDonneesAeroports(ArrayList<Ville> ListeVille) throws Exception {
        /*Création des Aeroports*/
        for (int i = 0; i < ListeVille.size(); i++) {
            resultat = declaration.executeQuery("SELECT * FROM aeroport WHERE ID_VILLE = " + ListeVille.get(i).getIdVille());
            while (resultat.next()) {
                ListeVille.get(i).ajouterAeroportAProximite(new Aeroport(resultat.getInt("ID_AEROPORT"), resultat.getString("NOM"), resultat.getBoolean("INTERNATIONAL")));
            }
        }
    }


    public static Option ajoutOption() throws Exception {

        Option option = new Option(resultat.getBoolean("WIFI"), resultat.getBoolean("SERVICE_MENAGE"), resultat.getBoolean("CLIMATISATION"), resultat.getBoolean("FUMEUR"), resultat.getBoolean("COFFREFORT"), resultat.getString("DESCRIPTION_VUE"), resultat.getBoolean("PARKING"), resultat.getBoolean("BAR"));
        return option;
    }

    public static void recuperationHebergements(ArrayList<Ville> ListeVille) throws Exception {
        declaration = connexion.createStatement();
        for (int i = 0; i < ListeVille.size(); i++) {
            /**Ajout d'un hotel dans les hebergements**/
            resultat = declaration.executeQuery("SELECT * FROM hebergement WHERE ID_VILLE = " + ListeVille.get(i).getIdVille() + " AND CATEGORIE = 'Hotel'");
            while (resultat.next()) {
                ListeVille.get(i).ajouterHebergement(new Hotel(resultat.getInt("ID_HEBERGEMENT"), resultat.getString("NOM"), resultat.getString("ADRESSE"), ajoutOption(), resultat.getInt("CAPACITE"), resultat.getInt("NOMBRE_DE_CHAMBRE"), new HashMap<>(), new TreeMap<>(), resultat.getInt("TARIF_ADULTE"), resultat.getInt("TARIF_ENFANT"), resultat.getInt("NOMBRE_ETOILE"), resultat.getBoolean("PISCINE"),resultat.getString("URL"),resultat.getInt("PROMOTION")));
            }
            /**Ajout d'un appartement dans les hebergements**/
            resultat = declaration.executeQuery("SELECT * FROM hebergement WHERE ID_VILLE = " + ListeVille.get(i).getIdVille() + " AND CATEGORIE = 'Appartement'");
            while (resultat.next()) {
                ListeVille.get(i).ajouterHebergement(new Appartement(resultat.getInt("ID_HEBERGEMENT"), resultat.getString("NOM"), resultat.getString("ADRESSE"), ajoutOption(), resultat.getInt("CAPACITE"), resultat.getInt("NOMBRE_DE_CHAMBRE"), new HashMap<>(), new TreeMap<>(), resultat.getInt("TARIF_ADULTE"), resultat.getInt("TARIF_ENFANT"), resultat.getInt("ETAGES"), resultat.getInt("NUMERO_APPARTEMENT"), resultat.getInt("NOMBRE_BALCON"),resultat.getString("URL"),resultat.getInt("PROMOTION")));
            }
            /**Ajout d'un Chalet dans les hebergements**/
            resultat = declaration.executeQuery("SELECT * FROM hebergement WHERE ID_VILLE = " + ListeVille.get(i).getIdVille() + " AND CATEGORIE = 'Chalet'");
            while (resultat.next()) {
                ListeVille.get(i).ajouterHebergement(new Chalet(resultat.getInt("ID_HEBERGEMENT"), resultat.getString("NOM"), resultat.getString("ADRESSE"), ajoutOption(), resultat.getInt("CAPACITE"), resultat.getInt("NOMBRE_DE_CHAMBRE"), new HashMap<>(), new TreeMap<>(), resultat.getInt("TARIF_ADULTE"), resultat.getInt("TARIF_ENFANT"), resultat.getString("NOM_MONTAGNE"), resultat.getInt("ALTITUDE"),resultat.getString("URL"),resultat.getInt("PROMOTION")));
            }
            /**Ajout d'une Maison dans les hebergements**/
            resultat = declaration.executeQuery("SELECT * FROM hebergement WHERE ID_VILLE = " + ListeVille.get(i).getIdVille() + " AND CATEGORIE = 'Maison'");
            while (resultat.next()) {
                ListeVille.get(i).ajouterHebergement(new Maison(resultat.getInt("ID_HEBERGEMENT"), resultat.getString("NOM"), resultat.getString("ADRESSE"), ajoutOption(), resultat.getInt("CAPACITE"), resultat.getInt("NOMBRE_DE_CHAMBRE"), new HashMap<>(), new TreeMap<>(), resultat.getInt("TARIF_ADULTE"), resultat.getInt("TARIF_ENFANT"), resultat.getBoolean("JARDIN"), resultat.getBoolean("PISCINE"),resultat.getString("URL"),resultat.getInt("PROMOTION")));
            }
            /**Ajout d'une Villa dans les hebergements**/
            resultat = declaration.executeQuery("SELECT * FROM hebergement WHERE ID_VILLE = " + ListeVille.get(i).getIdVille() + " AND CATEGORIE = 'Villa'");
            while (resultat.next()) {
                /*Ajout d'un hotel dans les hebergements*/
                ListeVille.get(i).ajouterHebergement(new Villa(resultat.getInt("ID_HEBERGEMENT"), resultat.getString("NOM"), resultat.getString("ADRESSE"), ajoutOption(), resultat.getInt("CAPACITE"), resultat.getInt("NOMBRE_DE_CHAMBRE"), new HashMap<>(), new TreeMap<>(), resultat.getInt("TARIF_ADULTE"), resultat.getInt("TARIF_ENFANT"), resultat.getBoolean("PISCINE"), resultat.getBoolean("SAUNA"), resultat.getBoolean("SALLE_DE_CINEMA"), resultat.getBoolean("DISCOTHEQUE"),resultat.getString("URL"),resultat.getInt("PROMOTION")));
            }
            /**Ajout d'un complexe hotelier dans les hebergements**/
            resultat = declaration.executeQuery("SELECT * FROM hebergement WHERE ID_VILLE = " + ListeVille.get(i).getIdVille() + " AND CATEGORIE = 'Complexe hotelier'");
            while (resultat.next()) {
                /*Ajout d'un hotel dans les hebergements*/
                ListeVille.get(i).ajouterHebergement(new ComplexeHotelier(resultat.getInt("ID_HEBERGEMENT"), resultat.getString("NOM"), resultat.getString("ADRESSE"), ajoutOption(), resultat.getInt("CAPACITE"), resultat.getInt("NOMBRE_DE_CHAMBRE"), new HashMap<>(), new TreeMap<>(), resultat.getInt("TARIF_ADULTE"), resultat.getInt("TARIF_ENFANT"), resultat.getString("NOM_COMPAGNIE"), resultat.getInt("NOMBRE_ETOILE"), resultat.getBoolean("PISCINE"),resultat.getString("URL"),resultat.getInt("PROMOTION")));
            }
        }
    }

    public static void recuperationUtilisateurs
            (ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye) throws Exception {
        declaration = connexion.createStatement();
        resultat = declaration.executeQuery("SELECT * FROM utilisateur WHERE TYPE = 1");
        while (resultat.next()) {
            listeClient.add(new Client(resultat.getString("NOM"), resultat.getString("PRENOM"), resultat.getString("IDENTIFIANT"), resultat.getString("PASSWORD"), resultat.getBoolean("CLIENT REGULIER"), resultat.getInt("NOMBRE DE LOCATION"), new ArrayList<>()));
        }
        resultat = declaration.executeQuery("SELECT * FROM utilisateur WHERE TYPE = 0");
        while (resultat.next()) {
            listeEmploye.add(new Employe(resultat.getString("NOM"), resultat.getString("PRENOM"), resultat.getString("IDENTIFIANT"), resultat.getString("PASSWORD")));
        }

    }

    public static Client recuperationClient(ArrayList<Client> listeClient) throws Exception {
        for (int i = 0; i < listeClient.size(); i++) {
            if (listeClient.get(i).getId().equals(resultat.getString("ID_CLIENT"))) {
                return listeClient.get(i);
            }
        }
        System.out.println("Erreur lors de la recuperation du client");
        return null;
    }

    public static Hebergement recuperationHebergement(ArrayList<Ville> listeVille) throws Exception {
        for (int i = 0; i < listeVille.size(); i++) {
            for (int j = 0; j < listeVille.get(i).getListeHebergement().size(); j++) {
                if (listeVille.get(i).getListeHebergement().get(j).getId() == resultat.getInt("ID_HEBERGEMENT")) {
                    return listeVille.get(i).getListeHebergement().get(j);
                }
            }
        }
        System.out.println("Erreur lors de la recuperation de l'hebergement");
        return null;
    }

    public static Paiement recuperationPaiement(ArrayList<Client> listeClient) throws Exception {
        for (int i = 0; i < listeClient.size(); i++) {

            if (listeClient.get(i).getId().equals(resultat.getString("ID_CLIENT"))) {
                Paiement nouveau = new Paiement(resultat.getInt("MONTANT"), listeClient.get(i).getPrenom(), listeClient.get(i).getNom(), resultat.getLong("CARTE_BANCAIRE"), listeClient.get(i).getNom() + listeClient.get(i).getPrenom(), formatageDate(resultat.getString("DATE_EXPIRATION")), resultat.getInt("NUM_SECU")); /** A MODIFIER BDD*/
                return nouveau;
            }
        }
        System.out.println("Erreur lors de la recuperation du paiement");
        return null;
    }


    public static Calendar formatageDate(String dateString) {
        String[] parts = dateString.split("/");
        int jour = Integer.parseInt(parts[0]);
        int mois = Integer.parseInt(parts[1]);
        int annee = Integer.parseInt(parts[2]);
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, annee);
        date.set(Calendar.MONTH, mois - 1); /**  0 = JANVIER*/
        date.set(Calendar.DAY_OF_MONTH, jour);
        return date;
    }

    public static void recuperationDonneesReservations
            (ArrayList<Ville> listeVille, ArrayList<Client> listeClient, HistoriqueReservation historique) throws Exception {
        declaration = connexion.createStatement();
        resultat = declaration.executeQuery("SELECT * FROM reservation");
        while (resultat.next()) {
            historique.ajouterReservation(new Reservation(recuperationClient(listeClient), recuperationHebergement(listeVille), recuperationPaiement(listeClient), resultat.getBoolean("RESERVATION_PASSEE"), formatageDate(resultat.getString("DATE_DEBUT")), formatageDate(resultat.getString("DATE_FIN")), recuperationHebergement(listeVille).getPromotion()));
            for (int i = 0; i < listeVille.size(); i++) {
                for (int j = 0; j < listeVille.get(i).getListeHebergement().size(); j++) {
                    if (listeVille.get(i).getListeHebergement().get(j).getId() == resultat.getInt("ID_HEBERGEMENT")) {
                        listeVille.get(i).getListeHebergement().get(j).ajouterAvisClient(resultat.getString("ID_CLIENT"), resultat.getString("AVIS_CLIENT"));
                        listeVille.get(i).getListeHebergement().get(j).ajouterNoteClient(resultat.getString("ID_CLIENT"), resultat.getInt("NOTE_CLIENT"));
                    }
                }
            }

        }
    }

    public static void recuperationDonneesReservationsClients(ArrayList<Client> listeClient, HistoriqueReservation historique) {
        for (int i = 0; i < historique.getToutesLesReservations().size(); i++) {
            for (int j = 0; j < listeClient.size(); j++) {
                if (historique.getToutesLesReservations().get(i).isReservationPassee() == true && historique.getToutesLesReservations().get(i).getLocataire().getId().equals(listeClient.get(j).getId())) {
                    listeClient.get(j).ajouterReservation(historique.getToutesLesReservations().get(i));
                }
            }
        }
    }

    /*--------------------------------------------------------------------*/
    /*--------------------------------------------------------------------*/
    public static String deformatageDate(Calendar date) {
        int annee = date.get(Calendar.YEAR);
        int mois = date.get(Calendar.MONTH) + 1;
        int jour = date.get(Calendar.DAY_OF_MONTH);
        return String.format("%02d/%02d/%04d", jour, mois, annee);
    }

    public static void enregistrementDonnees(ArrayList<Ville> listeVille, ArrayList<Client> listeClient,ArrayList<Employe> employes,HistoriqueReservation historique) throws Exception {

        declaration = connexion.createStatement();
        declaration.executeUpdate("DELETE FROM reservation WHERE 1");
        declaration.executeUpdate("DELETE FROM hebergement WHERE 1");
        declaration.executeUpdate("DELETE FROM ville WHERE 1");
        declaration.executeUpdate("DELETE FROM transport WHERE 1");
        declaration.executeUpdate("DELETE FROM activites WHERE 1");
        declaration.executeUpdate("DELETE FROM aeroport WHERE 1");
        declaration.executeUpdate("DELETE FROM utilisateur WHERE 1");
        enregistrementVille(listeVille);
        enregistrementHebergement(listeVille);
        enregistrementUtilisateurs(listeClient,employes);
        enregistrementReservation(listeVille, listeClient, historique);
    }
    public static void enregistrementReservation(ArrayList<Ville> listeVille,ArrayList<Client> listeClient,HistoriqueReservation historique) throws Exception {
        declaration = connexion.createStatement();
        for (int i = 0; i < historique.getToutesLesReservations().size(); i++) {
            int idHebergement = historique.getToutesLesReservations().get(i).getHebergementReserve().getId();
            String idClient = historique.getToutesLesReservations().get(i).getLocataire().getId();
            boolean reservationPassee = historique.getToutesLesReservations().get(i).isReservationPassee();
            String dateDebut = deformatageDate(historique.getToutesLesReservations().get(i).getDateArrivee());
            String dateFin = deformatageDate(historique.getToutesLesReservations().get(i).getDateDepart());
            int montant = historique.getToutesLesReservations().get(i).getEffectue().getMontantDeLaTransaction();
            long CB = historique.getToutesLesReservations().get(i).getEffectue().getNumeroCarteBancaire();
            String avisClient = historique.getToutesLesReservations().get(i).getHebergementReserve().recupAvisClient(historique.getToutesLesReservations().get(i).getLocataire().getId());
            if(avisClient == null) avisClient = "NULL";
            int noteClient = historique.getToutesLesReservations().get(i).getHebergementReserve().recupNotesClients(historique.getToutesLesReservations().get(i).getLocataire().getId());
            String nomTitulaire = historique.getToutesLesReservations().get(i).getEffectue().getNomDuPayeur();
            String dateExpiration = deformatageDate(historique.getToutesLesReservations().get(i).getEffectue().getDateExpirationDeLaCarte());
            int numSecu = historique.getToutesLesReservations().get(i).getEffectue().getNumeroDeSecurite();
            declaration.executeUpdate("INSERT INTO `reservation`(`ID_RESERVATION`, `ID_HEBERGEMENT`, `ID_CLIENT`, `RESERVATION_PASSEE`, `DATE_DEBUT`, `DATE_FIN`, `MONTANT`, `CARTE_BANCAIRE`, `NOTE_CLIENT`, `AVIS_CLIENT`, `NOM_TITULAIRE`, `DATE_EXPIRATION`, `NUM_SECU`) VALUES ('"+i+"','"+idHebergement+"', '"+idClient+"',"+reservationPassee+",'"+dateDebut+"','"+dateFin+"','"+montant+"','"+CB+"','"+noteClient+"','"+avisClient+"','"+nomTitulaire+"','"+dateExpiration+"','"+numSecu+"')");
        }
    }

    public static void enregistrementUtilisateurs(ArrayList<Client> listeClient,ArrayList<Employe> listeEmploye) throws Exception {
        int compteur=1;
        declaration = connexion.createStatement();
        for (int i = 0; i < listeClient.size(); i++) {
            declaration.executeUpdate("INSERT INTO `utilisateur`(`ID UTILISATEUR`, `NOM`, `PRENOM`, `IDENTIFIANT`, `PASSWORD`, `Type`, `CLIENT REGULIER`, `NOMBRE DE LOCATION`) VALUES ('"+compteur+"','"+listeClient.get(i).getNom()+"','"+listeClient.get(i).getPrenom()+"','"+listeClient.get(i).getId()+"','"+listeClient.get(i).getMdp()+"','1',"+listeClient.get(i).getClientRegulier()+","+listeClient.get(i).getNombreDeLocationFaites()+")");
            compteur++;
        }
        for(int i=0;i< listeEmploye.size();i++)
        {
            declaration.executeUpdate("INSERT INTO `utilisateur`(`ID UTILISATEUR`, `NOM`, `PRENOM`, `IDENTIFIANT`, `PASSWORD`, `Type`, `CLIENT REGULIER`, `NOMBRE DE LOCATION`) VALUES ('"+compteur+"','"+listeClient.get(i).getNom()+"','"+listeClient.get(i).getPrenom()+"','"+listeClient.get(i).getId()+"','"+listeClient.get(i).getMdp()+"','0',"+false+","+false+")");
            compteur++;
        }
    }
    public static void enregistrementVille(ArrayList<Ville> listeVille) throws Exception {
        int compteur =0,compteur2=0;
        for (int i = 0; i < listeVille.size(); i++) {
            declaration = connexion.createStatement();
            int idVille = listeVille.get(i).getIdVille();
/**Enregistrement de la ville*/
            declaration.executeUpdate("INSERT INTO `ville`(`ID_VILLE`, `NOM`, `NOM_PAYS`, `DESCRIPTION`) VALUES ('" + listeVille.get(i).getIdVille() + "','" + listeVille.get(i).getNomVille() + "','" + listeVille.get(i).getNomPaysAppartenance() + "','" + listeVille.get(i).getDescription() + "')");
/**Enregistrement des transports*/
            for (int j = 0; j < listeVille.get(i).getTransportDansLaVille().size(); j++) {
                String nom = listeVille.get(i).getTransportDansLaVille().get(j).getNomTransport();
                String type = listeVille.get(i).getTransportDansLaVille().get(j).getTypeDeTransport();
                ArrayList<String> arrets = listeVille.get(i).getTransportDansLaVille().get(j).getArrets();
                declaration.executeUpdate("INSERT INTO `transport`(`ID_TRANSPORT`, `ID_VILLE`, `NOM`, `TYPE`, `ARRET1`, `ARRET2`, `ARRET3`, `ARRET4`, `ARRET5`, `ARRET6`, `ARRET7`, `ARRET8`, `ARRET9`, `ARRET10`) VALUES ('"+compteur+"','"+idVille+"','"+nom+"','"+type+"','"+arrets.get(0)+"','"+arrets.get(1)+"','"+arrets.get(2)+"','"+arrets.get(3)+"','"+arrets.get(4)+"','"+arrets.get(5)+"','"+arrets.get(6)+"','"+arrets.get(7)+"','"+arrets.get(8)+"','"+arrets.get(9)+"');");
                compteur++;
            }
/**Enregistrement des activites*/
            for (int j = 0; j < listeVille.get(i).getActivitesAProximite().size(); j++) {
                String nom = listeVille.get(i).getActivitesAProximite().get(j).getNomActivite();
                String type = listeVille.get(i).getActivitesAProximite().get(j).getTypeActivite();
                String presentation = listeVille.get(i).getActivitesAProximite().get(j).getPresentationActivite();
                declaration.executeUpdate("INSERT INTO `activites`(`ID_ACTIVITE`, `ID_VILLE`, `NOM`, `TYPE`, `PRESENTATION`) VALUES ('"+compteur2+"','"+idVille+"','"+nom+"','"+type+"','"+presentation+"');");
                compteur2++;
            }
/**Enregistrement des Aeroports*/
            for (int j = 0; j < listeVille.get(i).getAeroportAProximite().size(); j++) {
                int idAeroport = listeVille.get(i).getAeroportAProximite().get(j).getIdAeroport();
                String nom = listeVille.get(i).getAeroportAProximite().get(j).getNomAeroport();
                boolean international = listeVille.get(i).getAeroportAProximite().get(j).isEstInternational();
                declaration.executeUpdate("INSERT INTO `aeroport`(`ID_AEROPORT`, `ID_VILLE`, `NOM`, `INTERNATIONAL`) VALUES ('"+idAeroport+"','"+idVille+"','"+nom+"',"+international+");");
            }
        }

    }

    public static void enregistrementHebergement(ArrayList<Ville> listeVille) throws Exception {
        int compteur=0;
        for (int i = 0; i < listeVille.size(); i++) {
            for (int j = 0; j < listeVille.get(i).getListeHebergement().size(); j++) {
                declaration = connexion.createStatement();
                int id = listeVille.get(i).getListeHebergement().get(j).getId();
                int idVille = listeVille.get(i).getIdVille();
                String nom = listeVille.get(i).getListeHebergement().get(j).getNom();
                String adresse = listeVille.get(i).getListeHebergement().get(j).getAdresse();
                int capacite = listeVille.get(i).getListeHebergement().get(j).getCapacite();
                int nombreDeChambre = listeVille.get(i).getListeHebergement().get(j).getNombreDeChambre();
                int tarifAdulte = listeVille.get(i).getListeHebergement().get(j).getTarifUnAdulteUneNuit();
                int tarifEnfant = listeVille.get(i).getListeHebergement().get(j).getTarifUnEnfantUneNuit();
                boolean wifi = listeVille.get(i).getListeHebergement().get(j).getWifi();
                boolean serviceMenage = listeVille.get(i).getListeHebergement().get(j).getServiceMenage();
                boolean climatisation = listeVille.get(i).getListeHebergement().get(j).getClimatisation();
                boolean fumeur = listeVille.get(i).getListeHebergement().get(j).getFumeur();
                boolean coffreFort = listeVille.get(i).getListeHebergement().get(j).getCoffreFort();
                String descriptionVue = listeVille.get(i).getListeHebergement().get(j).getDescriptionVue();
                boolean parking = listeVille.get(i).getListeHebergement().get(j).getParking();
                boolean bar = listeVille.get(i).getListeHebergement().get(j).getBar();
                String url = listeVille.get(i).getListeHebergement().get(j).getURL();
                String categorie = listeVille.get(i).getListeHebergement().get(j).getCategorie();
                int promotion = listeVille.get(i).getListeHebergement().get(j).getPromotion();

                declaration.executeUpdate("INSERT INTO `hebergement` (`ID_HEBERGEMENT`, `ID_VILLE`, `NOM`, `ADRESSE`, `CAPACITE`, `NOMBRE_DE_CHAMBRE`, `TARIF_ADULTE`, `TARIF_ENFANT`, `CATEGORIE`, `ETAGES`, `NUMERO_APPARTEMENT`, `NOMBRE_BALCON`, `NOM_MONTAGNE`, `ALTITUDE`, `NOM_COMPAGNIE`, `NOMBRE_ETOILE`, `PISCINE`, `JARDIN`, `SAUNA`, `SALLE_DE_CINEMA`, `DISCOTHEQUE`, `WIFI`, `SERVICE_MENAGE`, `CLIMATISATION`, `FUMEUR`, `COFFREFORT`, `DESCRIPTION_VUE`, `PARKING`, `BAR`, `URL`, `PROMOTION`) VALUES ('"+compteur+"', '"+idVille+"', '"+nom+"', '"+adresse+"', '"+capacite+"', '"+nombreDeChambre+"', '"+tarifAdulte+"', '"+tarifEnfant+"', '"+categorie+"', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, "+wifi+", "+serviceMenage+", "+climatisation+", "+fumeur+", "+coffreFort+", '"+descriptionVue+"' , "+parking+", "+bar+", '"+url+"', '"+promotion+"');");
                ArrayList<Object> listeAjout= new ArrayList<Object>();
                switch(categorie)
                {
                    case "Appartement" :
//etages / numeroAppartement / nombreBalcon
                        listeAjout = listeVille.get(i).getListeHebergement().get(j).enregistrement();
                        declaration.executeUpdate("UPDATE `hebergement` SET `ETAGES`='"+listeAjout.get(0)+"',`NUMERO_APPARTEMENT`='"+listeAjout.get(1)+"',`NOMBRE_BALCON`='"+listeAjout.get(2)+"' WHERE `ID_HEBERGEMENT`='"+compteur+"'");
                        break;
                    case "Hotel" :
//nombreEtoile / piscine
                        listeAjout = listeVille.get(i).getListeHebergement().get(j).enregistrement();
                        declaration.executeUpdate("UPDATE `hebergement` SET `NOMBRE_ETOILE`='"+listeAjout.get(0)+"',`PISCINE`="+listeAjout.get(1)+" WHERE `ID_HEBERGEMENT`='"+compteur+"'");
                        break;
                    case "Chalet" :
//nomMontagne / altitude
                        listeAjout = listeVille.get(i).getListeHebergement().get(j).enregistrement();
                        declaration.executeUpdate("UPDATE `hebergement` SET `NOM_MONTAGNE`='"+listeAjout.get(0)+"',`ALTITUDE`='"+listeAjout.get(1)+"' WHERE `ID_HEBERGEMENT`='"+compteur+"'");
                        break;
                    case "Maison" :
//jardin / piscine
                        listeAjout = listeVille.get(i).getListeHebergement().get(j).enregistrement();
                        declaration.executeUpdate("UPDATE `hebergement` SET `JARDIN`="+listeAjout.get(0)+",`PISCINE`="+listeAjout.get(1)+" WHERE `ID_HEBERGEMENT`='"+compteur+"'");
                        break;
                    case "Complexe hotelier" :
//nomCompagnie / nombreEtoile / piscine
                        listeAjout = listeVille.get(i).getListeHebergement().get(j).enregistrement();
                        declaration.executeUpdate("UPDATE `hebergement` SET `NOM_COMPAGNIE`='"+listeAjout.get(0)+"',`NOMBRE_ETOILE`='"+listeAjout.get(1)+"',`PISCINE`="+listeAjout.get(2)+" WHERE `ID_HEBERGEMENT`='"+compteur+"'");
                        break;
                    case "Villa" :
//jardin / piscine / sauna / salleDeCinema / discotheque
                        listeAjout = listeVille.get(i).getListeHebergement().get(j).enregistrement();
                        declaration.executeUpdate("UPDATE `hebergement` SET `PISCINE`="+listeAjout.get(0)+",`SAUNA`="+listeAjout.get(1)+",`SALLE_DE_CINEMA`="+listeAjout.get(2)+",`DISCOTHEQUE`="+listeAjout.get(3)+" WHERE `ID_HEBERGEMENT`='"+compteur+"'");
                        break;
                }
                compteur++;
            }
        }
    }
    /*--------------------------------------------------------------------*/
    /*--------------------------------------------------------------------*/


}

