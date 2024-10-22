package fr.java.modele.dao;

import fr.java.controleur.MiseAJour.Paiement;
import fr.java.controleur.MiseAJour.Reservation;
import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.Analyse;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GestionApplication extends JFrame
{
    /**ATTRIBUTS*/
    private static ArrayList<Client> listeClient;
    private static ArrayList<Employe> listeEmploye;
    private static ArrayList<Ville> listeVille;
    private static HistoriqueReservation historique;


    private static FenetreAccueil ecranAccueil ;
    private static FenetreOffre ecranOffre;
    private static FenetreRecherche ecranRecherche;
    private static FenetreConnexion ecranConnexion;
    private static FenetreInscription ecranInscription;
    private static FenetreHistoriqueReservation ecranHistorique ;
    private static FenetreLogementSelectionne ecranLogementEnDetail;
    private static FenetrePayement ecranPayement;
    private static FenetreQuitter ecranQuitter;

    /**reporting*/
    private static FenetreReporting ecranReporting;
    private static FenetreReportingChoixClient ecranReportingChoixClient;
    private static FenetreReportingEmploye ecranReportingEmploye;
    private static FenetreReportingChoixEmploye ecranReportingChoixEmploye;

    /**EMPLOYE*/
    /**compte*/
    private static FenetreConnexionEmploye ecranConnexionEmploye;
    /**choix*/
    private static FenetreChoixEmploye ecranChoixEmploye;
    /**ajouter offre*/
    private static FenetreAjouterOffre ecranAjouterOffre;
    private static FenetreActivite ecranActivite;
    /**modifier offre*/
    private static FenetreModifierOffre ecranModifierOffre;
    private static FenetreModification ecranModification;
    /**supprimer offre*/
    private static FenetreSupprimerOffre ecranSupprimerOffre;
    /**aeroport*/
    private static FenetreAeroport ecranAeroport;
    private static FenetreAjouterAeroport ecranAjouterAeroport;
    private static FenetreChoisirAeroport ecranChoisirAeroport;
    /**transports*/
    private static FenetreTransport ecranTransport;
    private static FenetreAjouterTransport ecranAjouterTransport;
    private static FenetreChoisirTransport ecranChoisirTransport;
    /**activite dans la ville*/
    private static FenetreActiviteVille ecranActiviteVille;
    private static FenetreAjouterActiviteVille ecranAjouterActiviteVille;
    private static FenetreChoisirActiviteVille ecranChoisirActiviteVille;

    private static JTable tableSuppression;
    private static JTable tableSupprimerAeroport;
    private static JTable tableSupprimerTransport;
    private static JTable tableSupprimerActiviteVille;
    private static JTable tableModification;

    private static BaseDeDonnees baseDeDonnees;


    /**CONSTRUCTEURS*/
    public GestionApplication()
    {
        listeClient = new ArrayList<>();
        listeEmploye = new ArrayList<>();
        listeVille = new ArrayList<>();
        historique = new HistoriqueReservation();
        baseDeDonnees = new BaseDeDonnees();
        tableModification = new JTable();
        tableSuppression = new JTable();
        tableSupprimerActiviteVille = new JTable();
        tableSupprimerAeroport = new JTable();
        tableSupprimerTransport = new JTable();
    }

    /**ACCESSEURS*/
    public static ArrayList<Client> getListeClient() {
        return listeClient;
    }

    public static void setListeClient(ArrayList<Client> listeClient) {
        GestionApplication.listeClient = listeClient;
    }

    public static ArrayList<Employe> getListeEmploye() {
        return listeEmploye;
    }

    public static void setListeEmploye(ArrayList<Employe> listeEmploye) {
        GestionApplication.listeEmploye = listeEmploye;
    }

    public static ArrayList<Ville> getListeVille() {
        return listeVille;
    }

    public static void setListeVille(ArrayList<Ville> listeVille) {
        GestionApplication.listeVille = listeVille;
    }

    public static HistoriqueReservation getHistorique() {
        return historique;
    }

    public static void setHistorique(HistoriqueReservation historique) {
        GestionApplication.historique = historique;
    }

    public static JTable getTableModification() {
        return tableModification;
    }

    public static JTable getTableSuppression() {
        return tableSuppression;
    }

    public static JTable getTableSupprimerActiviteVille() {
        return tableSupprimerActiviteVille;
    }

    public static JTable getTableSupprimerAeroport() {
        return tableSupprimerAeroport;
    }

    public static JTable getTableSupprimerTransport() {
        return tableSupprimerTransport;
    }

    public static void setTableSuppression(JTable tableSuppression) {
        GestionApplication.tableSuppression = tableSuppression;
    }

    public static void setTableSupprimerAeroport(JTable tableSupprimerAeroport) {
        GestionApplication.tableSupprimerAeroport = tableSupprimerAeroport;
    }

    public static void setTableSupprimerTransport(JTable tableSupprimerTransport) {
        GestionApplication.tableSupprimerTransport = tableSupprimerTransport;
    }

    public static void setTableSupprimerActiviteVille(JTable tableSupprimerActiviteVille) {
        GestionApplication.tableSupprimerActiviteVille = tableSupprimerActiviteVille;
    }

    public static void setTableModification(JTable tableModification) {
        GestionApplication.tableModification = tableModification;
    }

    public static FenetrePayement getEcranPayement() {
        return ecranPayement;
    }

    public static FenetreAccueil getEcranAccueil() {
        return ecranAccueil;
    }

    public static FenetreConnexion getEcranConnexion() {
        return ecranConnexion;
    }

    public static FenetreHistoriqueReservation getEcranHistorique() {
        return ecranHistorique;
    }

    public static FenetreInscription getEcranInscription() {
        return ecranInscription;
    }

    public static FenetreOffre getEcranOffre() {
        return ecranOffre;
    }

    public static FenetreRecherche getEcranRecherche() {
        return ecranRecherche;
    }

    public static FenetreReporting getEcranReporting() {
        return ecranReporting;
    }

    public static FenetreLogementSelectionne getEcranLogementEnDetail() {
        return ecranLogementEnDetail;
    }

    public static FenetreQuitter getEcranQuitter() {
        return ecranQuitter;
    }

    public static FenetreActivite getEcranActivite() {
        return ecranActivite;
    }

    public static FenetreAjouterOffre getEcranAjouterOffre() {
        return ecranAjouterOffre;
    }

    public static FenetreAeroport getEcranAeroport() {
        return ecranAeroport;
    }

    public static FenetreActiviteVille getEcranActiviteVille() {
        return ecranActiviteVille;
    }

    public static FenetreAjouterActiviteVille getEcranAjouterActiviteVille() {
        return ecranAjouterActiviteVille;
    }

    public static FenetreAjouterAeroport getEcranAjouterAeroport() {
        return ecranAjouterAeroport;
    }

    public static FenetreAjouterTransport getEcranAjouterTransport() {
        return ecranAjouterTransport;
    }

    public static FenetreChoisirAeroport getEcranChoisirAeroport() {
        return ecranChoisirAeroport;
    }


    public static FenetreChoisirActiviteVille getEcranChoisirActiviteVille() {
        return ecranChoisirActiviteVille;
    }

    public static FenetreChoisirTransport getEcranChoisirTransport() {
        return ecranChoisirTransport;
    }

    public static FenetreChoixEmploye getEcranChoixEmploye() {
        return ecranChoixEmploye;
    }

    public static FenetreConnexionEmploye getEcranConnexionEmploye() {
        return ecranConnexionEmploye;
    }


    public static FenetreModification getEcranModification() {
        return ecranModification;
    }

    public static FenetreModifierOffre getEcranModifierOffre() {
        return ecranModifierOffre;
    }

    public static FenetreReportingChoixClient getEcranReportingChoixClient() {
        return ecranReportingChoixClient;
    }



    public static FenetreSupprimerOffre getEcranSupprimerOffre() {
        return ecranSupprimerOffre;
    }

    public static FenetreTransport getEcranTransport() {
        return ecranTransport;
    }


    /**METHODES*/
    public static void recupererDonnees() /**RECUPERER TOUTES LES DONNES DE LA BDD*/
    {

        /** Connexion à la base de données **/
        try {
                baseDeDonnees.connexionBaseDeDonnees();
        } catch (Exception e) {
            System.out.println("Connexion échouée");
        }

        /** Récupère les données de la table ville **/
        try {
            baseDeDonnees.recuperationDonneesVille(listeVille);
            baseDeDonnees.recuperationDonneesTransports(listeVille);
            baseDeDonnees.recuperationDonneesActivites(listeVille);
            baseDeDonnees.recuperationDonneesAeroports(listeVille);
            baseDeDonnees.recuperationHebergements(listeVille);
            /*remplir les notes des clients et avis VIA les réservations*/

            /*Remplir les clients / employés*/
            baseDeDonnees.recuperationUtilisateurs(listeClient,listeEmploye);
            /*Remplir l'hisorique des réservations*/
            baseDeDonnees.recuperationDonneesReservations(listeVille,listeClient,historique);
            /*Remplir les liste de reservation des clients*/
            baseDeDonnees.recuperationDonneesReservationsClients(listeClient,historique);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* AFFICHAGE TEST */
        for(int i=0;i<listeVille.size();i++)
        {
            System.out.println("-------------------------------Affichage ville-------------------------------\n");
            listeVille.get(i).affichageVille();
        }
        System.out.println("-------------------------------Affichage reservation-------------------------------\n");
        historique.affichageHistorique();
        System.out.println("-------------------------------Affichage des clients-------------------------------\n");
        for(int i=0;i<listeClient.size();i++)
        {
            listeClient.get(i).affichageClient();
        }

    }

    public void creationDesFenetres()
    {
        ecranAccueil= new FenetreAccueil(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), true);
        ecranAccueil.ajoutComposant();
        ecranAccueil.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement(); }});
        ecranInscription=new FenetreInscription(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranInscription.ajoutComposant();
        ecranInscription.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranConnexion = new FenetreConnexion(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranConnexion.ajoutComposant();
        ecranConnexion.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranRecherche = new FenetreRecherche(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranRecherche.ajoutComposant();
        ecranRecherche.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranOffre = new FenetreOffre(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false, null);
        ecranOffre.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranHistorique = new FenetreHistoriqueReservation(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranHistorique.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranLogementEnDetail = new FenetreLogementSelectionne(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranLogementEnDetail.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranPayement = new FenetrePayement(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranPayement.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranQuitter = new FenetreQuitter(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranQuitter.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**ECRAN DES EMPLOYE*/
        /**compte*/
        ecranConnexionEmploye = new FenetreConnexionEmploye(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranConnexionEmploye.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**choix*/
        ecranChoixEmploye = new FenetreChoixEmploye(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranChoixEmploye.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**ajouter offre*/
        ecranAjouterOffre = new FenetreAjouterOffre(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranAjouterOffre.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranActivite = new FenetreActivite(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranActivite.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**modifier offre*/
        ecranModifierOffre = new FenetreModifierOffre(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranModifierOffre.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranModification = new FenetreModification(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranModification.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});

        /**supprimer offre*/
        ecranSupprimerOffre = new FenetreSupprimerOffre(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranSupprimerOffre.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**aeroport*/
        ecranAeroport = new FenetreAeroport(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranAeroport.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranAjouterAeroport = new FenetreAjouterAeroport(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranAjouterAeroport.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranChoisirAeroport = new FenetreChoisirAeroport(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranChoisirAeroport.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**transport*/
        ecranTransport = new FenetreTransport(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranTransport.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranAjouterTransport = new FenetreAjouterTransport(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranAjouterTransport.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranChoisirTransport = new FenetreChoisirTransport(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranChoisirTransport.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**Activite ville*/
        ecranActiviteVille = new FenetreActiviteVille(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranActiviteVille.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranAjouterActiviteVille = new FenetreAjouterActiviteVille(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranAjouterActiviteVille.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranChoisirActiviteVille = new FenetreChoisirActiviteVille(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranChoisirActiviteVille.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        /**ECRAN REPORTING*/
        ecranReporting = new FenetreReporting(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranReporting.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranReportingChoixClient = new FenetreReportingChoixClient(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranReportingChoixClient.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranReportingEmploye = new FenetreReportingEmploye(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranReportingEmploye.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
        ecranReportingChoixEmploye = new FenetreReportingChoixEmploye(getListeClient(), getListeEmploye(), getListeVille(), getHistorique(), false);
        ecranReportingChoixEmploye.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {enregistrement();}});
    }

    public void baseTraitement()
    {

        recupererDonnees();
        creationDesFenetres();

        getEcranAccueil().getBoutonAccesPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(getEcranAccueil().isClient() && !getEcranAccueil().isEmploye()) {/** si l'utilisateur est client */

                    ecranAccueil.setVisible(false);
                    ecranRecherche.setVisible(true);
                    System.out.println("LANCEMENT TRAITEMENT POUR CLIENT");
                    mainClient();
                }
                else if (!getEcranAccueil().isClient() && getEcranAccueil().isEmploye()){ /** si l'utilisateur est employé */
                    ecranAccueil.setVisible(false);
                    ecranConnexionEmploye.setVisible(true);
                    ecranConnexionEmploye.ajoutComposant();
                    System.out.println("LANCEMENT TRAITEMENT POUR EMPLOYE");
                    mainEmploye();
                }
                else {//BLINDAGE
                    //ne rien faire, l'utilisateur ne peut pas etre client ET employe
                }
            }
        });



    }

    public static void mainClient()
    {
        /** OUVERTURE FENETRE HISTORIQUE DE CLIENT */

        getEcranRecherche().getBoutonHistoriqueClient().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ecranRecherche.setVisible(false);

                if(getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    getEcranHistorique().setVisible(true);
                    ecranHistorique.setUtilisateur(getEcranConnexion().getUtilisateurDuSite());
                    ecranHistorique.ajoutComposant();
                }
                else {
                    getEcranConnexion().setVisible(true);
                }
            }
        });

        getEcranRecherche().getBoutonInscription().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    ecranRecherche.setVisible(false);
                    ecranInscription.setVisible(true);
                }

            }
        });

        getEcranRecherche().getBoutonConnexion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    ecranRecherche.setVisible(false);
                    ecranConnexion.setVisible(true);
                }
            }
        });

        getEcranConnexion().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranConnexion.setVisible(false);
                ecranRecherche.setVisible(true);
            }
        });

        getEcranInscription().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranInscription.setVisible(false);
                ecranRecherche.setVisible(true);
            }
        });

        getEcranConnexion().getBoutonConnexion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int positionClientBDD = getEcranConnexion().getUtilisateurDuSite().clientExiste(getEcranConnexion().getIdentifiantSaisie(), getEcranConnexion().getMotDePasseSaisie(), getListeClient());
                System.out.println("POSITION : " + positionClientBDD + " Identifiant : " + getEcranConnexion().getIdentifiantSaisie() + " MOT DE PASSE : " + getEcranConnexion().getMotDePasseSaisie());
                if(positionClientBDD != -1)
                {
                    ecranConnexion.setVisible(false);
                    ecranConnexion.setUtilisateurDuSite(getListeClient().get(positionClientBDD));
                    ecranRecherche.setVisible(true);
                }
                else {
                    /** AFFICHER MESSAGES ERREURS */
                    System.out.println("CLIENT N'EXISTE PAS");
                }
            }
        });

        getEcranInscription().getBoutonAccesPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!idDejaUtilise(getEcranInscription().getIdentifiantSaisie(),getListeClient()))
                {
                    Client recup = new Client();
                    recup.creerCompte(getEcranInscription().getNomSaisie(), getEcranInscription().getPrenomSaisie(), getEcranInscription().getIdentifiantSaisie(), getEcranInscription().getMotDePasseSaisie());

                    ecranInscription.setVisible(false);
                    ecranConnexion.setUtilisateurDuSite(recup);
                    ArrayList<Client> nouvelleListe = getListeClient();
                    nouvelleListe.add(recup);
                    setListeClient(nouvelleListe);
                    ecranRecherche.setVisible(true);
                }
                else {
                    /** AFFICHER COMME QUOI ID DEJA UTILISE */
                    System.out.println("ID DEJA UTILISE");
                }
            }
        });

        getEcranOffre().getBoutonHistorique().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranOffre.setVisible(false);

                if(getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    getEcranHistorique().setVisible(true);
                    ecranHistorique.setUtilisateur(getEcranConnexion().getUtilisateurDuSite());
                    ecranHistorique.ajoutComposant();
                }
                else {
                    getEcranConnexion().setVisible(true);
                }
            }
        });



        getEcranOffre().getBoutonConnexion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    ecranOffre.setVisible(false);
                    ecranConnexion.setVisible(true);
                }
            }
        });

        getEcranOffre().getBoutonInscription().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    ecranRecherche.setVisible(false);
                    ecranInscription.setVisible(true);
                }
            }
        });


        /** VALIDATION CRITERES, OUVERTURE RESULTATS : AJOUTER BLINDAGE */
        getEcranRecherche().getBoutonAccesPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(getEcranRecherche().getCritereDuLogement().getVille() != "" && getEcranRecherche().getCritereDuLogement().nombreDeJour() >= 1)
                {
                    ecranRecherche.setVisible(false);
                    ecranOffre.setVisible(true);

                    ecranOffre.setCritereLogements(getEcranRecherche().getCritereDuLogement());

                    ecranOffre.setLogementCorrespondants(rechercheLogementCorrespondant(getEcranRecherche().getCritereDuLogement(), getEcranConnexion().getUtilisateurDuSite()));

                    ecranOffre.ajoutComposant2(getEcranRecherche().getCritereDuLogement(), getEcranConnexion().getUtilisateurDuSite());

                    ecranOffre.ajoutComposant();

                    ecranOffre.ajoutComposantFiltres();
                }
            }
        });


        getEcranOffre().getBoutonValidationFiltres().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranOffre.setVisible(false);
                ecranRecherche.setCritereDuLogement(ecranOffre.getCritereLogements());
                ecranOffre.setLogementCorrespondants(rechercheLogementCorrespondant(getEcranRecherche().getCritereDuLogement(), getEcranConnexion().getUtilisateurDuSite()));
                ecranOffre.ajoutComposant2(getEcranRecherche().getCritereDuLogement(), getEcranConnexion().getUtilisateurDuSite());
                ecranOffre.ajoutComposant();
                ecranOffre.ajoutComposantFiltres();
                ecranOffre.setVisible(true);
            }
        });

        getEcranOffre().getBoutonChangementPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getEcranOffre().getLogementSelectionne() != null)
                {
                    ecranLogementEnDetail.setLogementSelectionne(getEcranOffre().getLogementSelectionne());
                    ecranLogementEnDetail.setUtilisateurDuSite(getEcranConnexion().getUtilisateurDuSite());
                    ecranLogementEnDetail.setCriteresDemandes(getEcranRecherche().getCritereDuLogement());
                    ecranLogementEnDetail.updateContentPane();
                    ecranLogementEnDetail.setVisible(true);
                }
            }
        });

        getEcranLogementEnDetail().getBoutonReserver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    ecranLogementEnDetail.setVisible(false);
                    Paiement recup = ecranPayement.getPayementLogement();
                    recup.setNomDuPayeur(getEcranConnexion().getUtilisateurDuSite().getNom());
                    recup.setPrenomDuPayeur(getEcranConnexion().getUtilisateurDuSite().getPrenom());
                    recup.setTitulaireDeLaCarte(recup.getNomDuPayeur() + " " + recup.getPrenomDuPayeur());
                    recup.setMontantDeLaTransaction(getEcranLogementEnDetail().getLogementSelectionne().calculPrixSejour(getEcranOffre().getCritereLogements().getNombreAdulte(), getEcranOffre().getCritereLogements().getNombreEnfant(), getEcranOffre().getCritereLogements().nombreDeJour(), getEcranConnexion().getUtilisateurDuSite().getClientRegulier()));
                    ecranPayement.setPayementLogement(recup);
                    ecranPayement.setVisible(true);
                    ecranPayement.ajoutComposant();
                }
                else {
                    ecranLogementEnDetail.setVisible(false);
                    ecranInscription.setVisible(true);
                }
            }
        });

        getEcranPayement().getBoutonReserver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getEcranPayement().getPayementLogement() != null)
                {
                    Calendar test = Calendar.getInstance();

                    if(getEcranPayement().getPayementLogement().getDateExpirationDeLaCarte().compareTo(test) > 0)
                    {
                        ecranPayement.setVisible(false);
                        ecranOffre.setVisible(false);
                        Client utilisateurDuSite = getEcranConnexion().getUtilisateurDuSite();
                        setHistorique(utilisateurDuSite.reserverLogement(getEcranLogementEnDetail().getLogementSelectionne(), getEcranPayement().getPayementLogement().getMontantDeLaTransaction(), getEcranOffre().getCritereLogements(), getHistorique(), getEcranPayement().getPayementLogement()));
                        ecranConnexion.setUtilisateurDuSite(utilisateurDuSite);
                        ecranQuitter.setVisible(true);
                    }
                }
            }
        });

        getEcranQuitter().getBoutonContinuer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranQuitter.setVisible(false);
                ecranRecherche.setVisible(true);
            }
        });

        getEcranHistorique().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranHistorique.setVisible(false);
                ecranRecherche.setVisible(true);
            }
        });

        /**retour à la fenêtre de recherche si clique sur bouton HOME **/
        getEcranReporting().getBoutonHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranReporting.setVisible(false);
                ecranRecherche.setVisible(true);
            }
        });

        /** si clique sur le bouton REPORTING */
        getEcranRecherche().getBoutonReporting().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ecranRecherche.setVisible(false);
                if(getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    ecranReportingChoixClient.setContentPane(ecranReportingChoixClient.buildContentPane());
                    ecranReportingChoixClient.setUtilisateurDuSite(ecranReportingChoixClient.getUtilisateurDuSite());
                    ecranReportingChoixClient.ajoutComposant();
                    ecranReportingChoixClient.setVisible(true);
                }
                else {
                    ecranConnexion.setVisible(true);
                }
            }
        });

        getEcranOffre().getBoutonReporting().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranOffre.setVisible(false);
                if(getEcranConnexion().getUtilisateurDuSite().isConnected())
                {
                    ecranReportingChoixClient.setContentPane(ecranReportingChoixClient.buildContentPane());
                    ecranReportingChoixClient.setUtilisateurDuSite(ecranConnexion.getUtilisateurDuSite());
                    ecranReportingChoixClient.ajoutComposant();
                    ecranReportingChoixClient.setVisible(true);
                }
                else {
                    ecranConnexion.setVisible(true);
                }
            }
        });

        getEcranReportingChoixClient().getBoutonAnalyse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranReportingChoixClient.setVisible(false);
                ecranReporting.setUtilisateurDuSite(ecranConnexion.getUtilisateurDuSite());
                ecranReporting.setLogement(ecranReportingChoixClient.getLogement());
                ecranReporting.setAnneeEtudiee(ecranReportingChoixClient.getAnneeEtudiee());
                ecranReporting.setVilleEtudiee(ecranReportingChoixClient.getVilleEtudiee());
                ecranReporting.setContentPane(ecranReporting.buildContentPane());
                ecranReporting.ajoutComposant();
                ecranReporting.setVisible(true);
            }
        });
    }

    public static boolean idDejaUtilise(String idSaisie, ArrayList<Client> listeClient)
    {
        boolean test = false;
        int optimisation = 0;
        int parcours = 0;

        while(optimisation == 0 && parcours < listeClient.size())
        {
            if(listeClient.get(parcours).getId().equals(idSaisie))
            {
                test = true;
                optimisation = 1;
            }
            parcours++;
        }

        return test;
    }

    public static ArrayList<Hebergement> rechercheLogementCorrespondant(RechercheReservation criteres, Client utilisateur)
    {
        boolean villeTrouve = false;
        int parcours = 0;


        while(!villeTrouve)
        {
            if(getListeVille().get(parcours).getNomVille().equals(criteres.getVille()))
            {
                villeTrouve = true;
            }
            else {
                parcours++;
            }
        }

        ArrayList<Hebergement> resultat = new ArrayList<>(getListeVille().get(parcours).getListeHebergement());


        int i = 0;

        while(i!=resultat.size())
        {
            if(resultat.get(i).getCapacite() < criteres.getNombreAdulte()+criteres.getNombreEnfant())
            {
                resultat.remove(i);
            }
            else {
                if((!resultat.get(i).getCategorie().equals(criteres.getCategorie())) && (!criteres.getCategorie().equals("rien")))
                {
                    resultat.remove(i);
                }
                else {
                    if((resultat.get(i).calculPrixSejour(criteres.getNombreAdulte(), criteres.getNombreEnfant(), criteres.nombreDeJour(), utilisateur.getClientRegulier()) > criteres.getPrixMaximum()) && (criteres.getPrixMaximum() != -1))
                    {
                        resultat.remove(i);
                    }
                    else {
                        if((resultat.get(i).getNombreDeChambre() < criteres.getNombreDeChambre()) && (criteres.getNombreDeChambre() != -1))
                        {
                            resultat.remove(i);
                        }
                        else {
                            if(!resultat.get(i).disponibleACetteDate(criteres.getDateArrivee(), criteres.getDateDepart(), getHistorique().getLesReservationsPasPassee()))
                            {
                                resultat.remove(i);
                            }
                            else {
                                if(!filtreSupplementaireCorrespond(criteres, resultat.get(i)))
                                {
                                    resultat.remove(i);
                                }
                                else {
                                    if(resultat.get(i).getCategorie().equals("Hotel") || resultat.get(i).equals("Complexe Hotelier"))
                                    {
                                        if(resultat.get(i).encoreDesChambresDispo(criteres.getDateArrivee(), criteres.getDateDepart(), getHistorique().getLesReservationsPasPassee(), criteres.getNombreDeChambre()))   /** TROUVER SOLUTION POUR QUAND PAS RENSEIGNE LE NOMBRE DE CHAMBRE*/
                                        {
                                            i++;
                                        }
                                        else {
                                            resultat.remove(i);
                                        }
                                    }
                                    else {
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        return resultat;
    }


    public static boolean filtreSupplementaireCorrespond(RechercheReservation critere, Hebergement logementObserve)
    {
        boolean correspond = true;

        if(critere.getFiltreSupplementaire().getWifi())
        {
            if(!logementObserve.getOptionSupplementairesProposees().getWifi())
            {
                correspond = false;
            }
        }

        if(critere.getFiltreSupplementaire().getServiceMenage())
        {
            if(!logementObserve.getOptionSupplementairesProposees().getServiceMenage())
            {
                correspond = false;
            }
        }

        if(critere.getFiltreSupplementaire().getClimatisation())
        {
            if(!logementObserve.getOptionSupplementairesProposees().getClimatisation())
            {
                correspond = false;
            }
        }

        if(critere.getFiltreSupplementaire().getFumeur())
        {
            if(!logementObserve.getOptionSupplementairesProposees().getFumeur())
            {
                correspond = false;
            }
        }

        if(critere.getFiltreSupplementaire().getCoffreFort())
        {
            if(!logementObserve.getOptionSupplementairesProposees().getCoffreFort())
            {
                correspond = false;
            }
        }

        if(critere.getFiltreSupplementaire().getParkingPrivee())
        {
            if(!logementObserve.getOptionSupplementairesProposees().getParkingPrivee())
            {
                correspond = false;
            }
        }

        if(critere.getFiltreSupplementaire().getBar())
        {
            if(!logementObserve.getOptionSupplementairesProposees().getBar())
            {
                correspond = false;
            }
        }

        return correspond;

    }

    public static void mainEmploye()
    {
        getEcranConnexionEmploye().getBoutonConnexion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ID : " + getEcranConnexionEmploye().getTravailleurActuel().getId());
                if(getEcranConnexionEmploye().getTravailleurActuel().seConnecter(getListeEmploye())){
                    ecranConnexionEmploye.setVisible(false);
                    ecranChoixEmploye.ajoutComposant();
                    ecranChoixEmploye.setVisible(true);
                }else {
                    /** Ne rien faire, le login ET le password doivent être saisie */
                }
            }
        });

        getEcranChoixEmploye().getBoutonActivite().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoixEmploye.setVisible(false);
                ecranActiviteVille.setContentPane(ecranActiviteVille.buildContentPane());
                ecranActiviteVille.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                ecranActiviteVille.ajoutComposant();
                ecranActiviteVille.setVisible(true);
            }
        });

        getEcranActiviteVille().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranActiviteVille.setVisible(false);
                ecranAjouterActiviteVille.setContentPane(ecranAjouterActiviteVille.buildContentPane());
                ecranAjouterActiviteVille.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                ecranAjouterActiviteVille.ajoutComposant();
                ecranAjouterActiviteVille.setVisible(true);
            }
        });

        getEcranAjouterActiviteVille().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterActiviteVille.setVisible(false);
                /**ajouter l'aeroport : ecranAjouterAeroport.getAeroportAjoute()*/

                int placeVille = 0;
                boolean trouve = false;

                while(!trouve)
                {
                    if(getListeVille().get(placeVille).getNomVille().equals(getEcranChoixEmploye().getVilleModifie()))
                    {
                        trouve = true;
                        getListeVille().get(placeVille).ajouterActiviteAProximite(getEcranAjouterActiviteVille().getActiviteAjoute());
                    }
                    else {
                        placeVille++;
                    }
                }

                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranAjouterActiviteVille().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterActiviteVille.setVisible(false);
                ecranActiviteVille.setContentPane(ecranActiviteVille.buildContentPane());
                ecranActiviteVille.ajoutComposant();
                ecranActiviteVille.setVisible(true);
            }
        });

        getEcranActiviteVille().getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranActiviteVille.setVisible(false);
                ecranChoisirActiviteVille.setContentPane(ecranChoisirActiviteVille.buildContentPane());
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        ecranChoisirActiviteVille.setvilleEtudiee(getListeVille().get(i));
                    }
                }
                setTableSupprimerActiviteVille(ecranChoisirActiviteVille.ajoutComposant2());
                ecranChoisirActiviteVille.setVisible(true);
                getTableSupprimerActiviteVille().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = tableSupprimerActiviteVille.getSelectedRow();
                            Activite supp = ecranChoisirActiviteVille.getvilleEtudiee().getActivitesAProximite().get(ligne); /** recuperation du logement à supprimer */
                            ecranChoisirActiviteVille.setVisible(false);

                            boolean trouve = false;
                            int i = 0;

                            while(!trouve)
                            {
                                if(getEcranChoisirActiviteVille().getvilleEtudiee().getActivitesAProximite().get(i).equals(supp))
                                {
                                    getEcranChoisirActiviteVille().getvilleEtudiee().getActivitesAProximite().remove(i);
                                    trouve = true;
                                }
                                else {
                                    i++;
                                }
                            }

                            ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                            ecranChoixEmploye.ajoutComposant();
                            ecranChoixEmploye.setVisible(true);
                        }
                    }
                });

            }
        });

        /**modifier une activité*/
        getEcranActiviteVille().getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranActiviteVille.setVisible(false);
                ecranChoisirActiviteVille.setContentPane(ecranChoisirActiviteVille.buildContentPane());
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        ecranChoisirActiviteVille.setvilleEtudiee(getListeVille().get(i));
                    }
                }
                setTableSupprimerActiviteVille(ecranChoisirActiviteVille.ajoutComposant2());
                ecranChoisirActiviteVille.setVisible(true);
                getTableSupprimerActiviteVille().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = tableSupprimerActiviteVille.getSelectedRow();
                            Activite supp = ecranChoisirActiviteVille.getvilleEtudiee().getActivitesAProximite().get(ligne); /** recuperation du logement à supprimer */
                            ecranChoisirActiviteVille.setVisible(false);

                            boolean trouve = false;
                            int i = 0;

                            while(!trouve)
                            {
                                if(getEcranChoisirActiviteVille().getvilleEtudiee().getActivitesAProximite().get(i).equals(supp))
                                {
                                    getEcranChoisirActiviteVille().getvilleEtudiee().getActivitesAProximite().remove(i);
                                    trouve = true;
                                }
                                else {
                                    i++;
                                }
                            }

                            ecranAjouterActiviteVille.setContentPane(ecranAjouterActiviteVille.buildContentPane());
                            ecranAjouterActiviteVille.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                            ecranAjouterActiviteVille.ajoutComposant();
                            ecranAjouterActiviteVille.setVisible(true);
                        }
                    }
                });
            }
        });

        getEcranChoisirActiviteVille().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoisirActiviteVille.setVisible(false);
                ecranActiviteVille.setContentPane(ecranActiviteVille.buildContentPane());
                ecranActiviteVille.ajoutComposant();
                ecranActiviteVille.setVisible(true);
            }
        });

        /**BOUTON RETOUR*/
        getEcranActiviteVille().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranActiviteVille.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranChoixEmploye().getBoutonAeroport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoixEmploye.setVisible(false);
                ecranAeroport.setContentPane(ecranAeroport.buildContentPane());
                ecranAeroport.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                ecranAeroport.ajoutComposant();
                ecranAeroport.setVisible(true);
            }
        });

        getEcranAeroport().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAeroport.setVisible(false);
                ecranAjouterAeroport.setContentPane(ecranAjouterAeroport.buildContentPane());
                ecranAjouterAeroport.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                ecranAjouterAeroport.ajoutComposant();
                ecranAjouterAeroport.setVisible(true);
            }
        });

        getEcranAjouterAeroport().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterAeroport.setVisible(false);
                /**ajouter l'aeroport : ecranAjouterAeroport.getAeroportAjoute()*/

                int placeVille = 0;
                boolean trouve = false;

                while(!trouve)
                {
                    if(getListeVille().get(placeVille).getNomVille().equals(getEcranChoixEmploye().getVilleModifie()))
                    {
                        trouve = true;
                        getListeVille().get(placeVille).getAeroportAProximite().add(getEcranAjouterAeroport().getAeroportAjoute());
                    }
                    else {
                        placeVille++;
                    }
                }

                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranAjouterAeroport().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterAeroport.setVisible(false);
                ecranAeroport.setContentPane(ecranAeroport.buildContentPane());
                ecranAeroport.ajoutComposant();
                ecranAeroport.setVisible(true);
            }
        });

        /**supprimer un aeroport*/
        getEcranAeroport().getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAeroport.setVisible(false);
                ecranChoisirAeroport.setContentPane(ecranChoisirAeroport.buildContentPane());
                System.out.println("ok");
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        ecranChoisirAeroport.setvilleEtudiee(getListeVille().get(i));
                    }
                }
                setTableSupprimerAeroport(ecranChoisirAeroport.ajoutComposant2());
                ecranChoisirAeroport.setVisible(true);
                getTableSupprimerAeroport().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = tableSupprimerAeroport.getSelectedRow();
                            Aeroport supp = ecranChoisirAeroport.getvilleEtudiee().getAeroportAProximite().get(ligne); /** recuperation du logement à supprimer */
                            ecranChoisirAeroport.setVisible(false);

                            boolean trouve = false;
                            int i = 0;

                            while(!trouve)
                            {
                                if(getEcranChoisirAeroport().getvilleEtudiee().getAeroportAProximite().get(i).equals(supp))
                                {
                                    getEcranChoisirAeroport().getvilleEtudiee().getAeroportAProximite().remove(i);
                                    trouve = true;
                                }
                                else {
                                    i++;
                                }
                            }

                            ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                            ecranChoixEmploye.ajoutComposant();
                            ecranChoixEmploye.setVisible(true);
                        }
                    }
                });
            }
        });

        /**modifier un aeroport*/
        ecranAeroport.getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAeroport.setVisible(false);
                ecranChoisirAeroport.setContentPane(ecranChoisirAeroport.buildContentPane());
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        ecranChoisirAeroport.setvilleEtudiee(getListeVille().get(i));
                    }
                }
                setTableSupprimerAeroport(ecranChoisirAeroport.ajoutComposant2());
                ecranChoisirAeroport.setVisible(true);
                getTableSupprimerAeroport().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = tableSupprimerAeroport.getSelectedRow();
                            Aeroport supp = ecranChoisirAeroport.getvilleEtudiee().getAeroportAProximite().get(ligne); /** recuperation du logement à supprimer */
                            ecranChoisirAeroport.setVisible(false);

                            boolean trouve = false;
                            int i = 0;

                            while(!trouve)
                            {
                                if(getEcranChoisirAeroport().getvilleEtudiee().getAeroportAProximite().get(i).equals(supp))
                                {
                                    getEcranChoisirAeroport().getvilleEtudiee().getAeroportAProximite().remove(i);
                                    trouve = true;
                                }
                                else {
                                    i++;
                                }
                            }

                            ecranAjouterAeroport.setContentPane(ecranAjouterAeroport.buildContentPane());
                            ecranAjouterAeroport.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                            ecranAjouterAeroport.ajoutComposant();
                            ecranAjouterAeroport.setVisible(true);
                        }
                    }
                });

            }
        });

        getEcranChoisirAeroport().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoisirAeroport.setVisible(false);
                ecranAeroport.setContentPane(ecranAeroport.buildContentPane());
                ecranAeroport.ajoutComposant();
                ecranAeroport.setVisible(true);
            }
        });

        /**BOUTON RETOUR*/
        ecranAeroport.getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAeroport.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranChoixEmploye().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoixEmploye.setVisible(false);
                ecranAjouterOffre.setContentPane(ecranAjouterOffre.buildContentPane());
                ecranAjouterOffre.setAjoutVille(ecranChoixEmploye.getVilleModifie());
                if(ecranChoixEmploye.getTypeLogement().equals("Appartement")==true){
                    ecranAjouterOffre.composantAppartement();
                }else if(ecranChoixEmploye.getTypeLogement().equals("Chalet")==true){
                    ecranAjouterOffre.composantChalet();
                }else if(ecranChoixEmploye.getTypeLogement().equals("Complexe Hotelier")==true){
                    ecranAjouterOffre.composantComplexeHotelier();
                }else if(ecranChoixEmploye.getTypeLogement().equals("Hotel")==true){
                    ecranAjouterOffre.composantHotel();
                }else if(ecranChoixEmploye.getTypeLogement().equals("Maison")==true){
                    ecranAjouterOffre.composantMaison();
                }else if(ecranChoixEmploye.getTypeLogement().equals("Villa")==true){
                    ecranAjouterOffre.composantVilla();
                }
                ecranAjouterOffre.setVisible(true);
            }
        });

        getEcranAjouterOffre().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterOffre.setVisible(false);

                int placeVille = 0;
                boolean trouve = false;

                while(!trouve)
                {
                    if(getListeVille().get(placeVille).getNomVille().equals(getEcranChoixEmploye().getVilleModifie()))
                    {
                        trouve = true;
                    }
                    else {
                        placeVille++;
                    }
                }

                if(ecranChoixEmploye.getTypeLogement().equals("Appartement")==true){
                    getListeVille().get(placeVille).ajouterHebergement(getEcranAjouterOffre().getAppartementAjoute());
                }else if(ecranChoixEmploye.getTypeLogement().equals("Chalet")==true){
                    getListeVille().get(placeVille).ajouterHebergement(getEcranAjouterOffre().getChaletAjoute());
                }else if(ecranChoixEmploye.getTypeLogement().equals("Complexe Hotelier")==true){
                    getListeVille().get(placeVille).ajouterHebergement(getEcranAjouterOffre().getComplexeHotelierAjoute());
                }else if(ecranChoixEmploye.getTypeLogement().equals("Hotel")==true){
                    getListeVille().get(placeVille).ajouterHebergement(getEcranAjouterOffre().getHotelAjoute());
                }else if(ecranChoixEmploye.getTypeLogement().equals("Maison")==true){
                    getListeVille().get(placeVille).ajouterHebergement(getEcranAjouterOffre().getMaisonAjoutee());
                }else if(ecranChoixEmploye.getTypeLogement().equals("Villa")==true){
                    getListeVille().get(placeVille).ajouterHebergement(getEcranAjouterOffre().getVillaAjoutee());
                }
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        /**ajouter les activites d'un complexe hotelier*/
        getEcranAjouterOffre().getBoutonActivite().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterOffre.setVisible(false);
                ecranActivite.setComplexeHotelierAjoute(ecranAjouterOffre.getComplexeHotelierAjoute());
                ecranActivite.ajoutComposant();
                ecranActivite.getComplexeHotelierAjoute().setActivitesProposees(ecranActivite.getActiviteEnregistree());
                ecranActivite.setVisible(true);
            }
        });

        getEcranActivite().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranActivite.setVisible(false);
                /**AJOUTER LE COMPLEXE HOTELIER EN FONCTION DE SON TYPE DE LOGEMENT*/
                /**AJOUTER ecranActivite.getComplexeHotelierAjoute()*/

                int placeVille = 0;
                boolean trouve = false;

                while(!trouve)
                {
                    if(getListeVille().get(placeVille).getNomVille().equals(getEcranChoixEmploye().getVilleModifie()))
                    {
                        trouve = true;
                        getListeVille().get(placeVille).getListeHebergement().add(getEcranActivite().getComplexeHotelierAjoute());
                    }
                    else {
                        placeVille++;
                    }
                }

                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        /**BOUTON RETOUR*/
        ecranAjouterOffre.getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterOffre.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });


        getEcranChoixEmploye().getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoixEmploye.setVisible(false);
                ecranModifierOffre.setContentPane(ecranModifierOffre.buildContentPane());
                ecranModifierOffre.setListeLogement(new ArrayList<>());
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        for(int j=0;j<getListeVille().get(i).getListeHebergement().size();j++){
                            if(getListeVille().get(i).getListeHebergement().get(j).getCategorie().equals(ecranChoixEmploye.getTypeLogement())){
                                ecranModifierOffre.ajouterListeLogement(getListeVille().get(i).getListeHebergement().get(j));
                            }
                        }
                    }
                }
                setTableModification(ecranModifierOffre.ajoutComposant2());
                /** EVENEMENT SI CLIC SUR L'UNE DES OFFRES*/
                getTableModification().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = getTableModification().getSelectedRow();
                            ecranModifierOffre.setVisible(false);
                            ecranModification.setContentPane(ecranModification.buildContentPane());
                            ecranModification.setHerbergementModifie(ecranModifierOffre.getListeLogement().get(ligne));
                            ecranModification.setVisible(true);
                            ecranModification.ajoutComposant();
                        }
                    }
                });
                ecranModifierOffre.setVisible(true);
            }
        });


        getEcranModification().getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranModification.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        /**BOUTON RETOUR*/
        getEcranModifierOffre().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranModifierOffre.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranModification().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranModification.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranChoixEmploye().getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int placeVille = 0;
                ecranChoixEmploye.setVisible(false);
                ecranSupprimerOffre.setContentPane(ecranSupprimerOffre.buildContentPane());
                ecranSupprimerOffre.setListeLogement(new ArrayList<>());
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        for(int j=0;j<getListeVille().get(i).getListeHebergement().size();j++){
                            if(getListeVille().get(i).getListeHebergement().get(j).getCategorie().equals(ecranChoixEmploye.getTypeLogement())){
                                ecranSupprimerOffre.ajouterListeLogement(getListeVille().get(i).getListeHebergement().get(j));
                            }
                        }
                        placeVille = i;
                    }
                }
                final Ville recup = getListeVille().get(placeVille);
                setTableSuppression(ecranSupprimerOffre.ajoutComposant2());
                getTableSuppression().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = tableSuppression.getSelectedRow();
                            Hebergement supp = ecranSupprimerOffre.getListeLogement().get(ligne); /** recuperation du logement à supprimer */

                            boolean trouve = false;
                            int placeLogement = 0;

                            while(!trouve)
                            {
                                if(recup.getListeHebergement().get(placeLogement).equals(supp))
                                {
                                    trouve = true;
                                    recup.getListeHebergement().remove(placeLogement);
                                }
                                else {
                                    placeLogement++;
                                }
                            }

                            ecranSupprimerOffre.setVisible(false);
                            ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                            ecranChoixEmploye.ajoutComposant();
                            ecranChoixEmploye.setVisible(true);

                        }
                    }
                });
                ecranSupprimerOffre.setVisible(true);
            }
        });

        getEcranSupprimerOffre().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranSupprimerOffre.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranChoixEmploye().getBoutonTransport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoixEmploye.setVisible(false);
                ecranTransport.setContentPane(ecranTransport.buildContentPane());
                ecranTransport.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                ecranTransport.ajoutComposant();
                ecranTransport.setVisible(true);
            }
        });

        /**ajouter un transport*/
        getEcranTransport().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranTransport.setVisible(false);
                ecranAjouterTransport.setContentPane(ecranAjouterTransport.buildContentPane());
                ecranAjouterTransport.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                ecranAjouterTransport.ajoutComposant();
                ecranAjouterTransport.setVisible(true);
            }
        });

        getEcranAjouterTransport().getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterTransport.setVisible(false);
                /**ajouter le transport : ecranAjouterTransport.getTransportAjoute()*/

                int placeVille = 0;
                boolean trouve = false;

                while(!trouve)
                {
                    if(getListeVille().get(placeVille).getNomVille().equals(getEcranChoixEmploye().getVilleModifie()))
                    {
                        trouve = true;
                        getListeVille().get(placeVille).ajouterTransport(getEcranAjouterTransport().getTransportAjoute());
                    }
                    else {
                        placeVille++;
                    }
                }
                ecranAjouterTransport.setIndiceStation(0);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });

        getEcranAjouterTransport().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranAjouterTransport.setVisible(false);
                ecranTransport.setContentPane(ecranTransport.buildContentPane());
                ecranTransport.ajoutComposant();
                ecranTransport.setVisible(true);
            }
        });

        /**supprimer un transport*/
        getEcranTransport().getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranTransport.setVisible(false);
                ecranChoisirTransport.setContentPane(ecranChoisirTransport.buildContentPane());
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        ecranChoisirTransport.setvilleEtudiee(getListeVille().get(i));
                    }
                }
                setTableSupprimerTransport(ecranChoisirTransport.ajoutComposant2());
                ecranChoisirTransport.setVisible(true);
                getTableSupprimerTransport().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = tableSupprimerTransport.getSelectedRow();
                            Transport supp = ecranChoisirTransport.getvilleEtudiee().getTransportDansLaVille().get(ligne); /** recuperation du logement à supprimer */
                            ecranChoisirTransport.setVisible(false);

                            boolean trouve = false;
                            int i = 0;

                            while(!trouve)
                            {
                                if(getEcranChoisirTransport().getvilleEtudiee().getTransportDansLaVille().get(i).equals(supp))
                                {
                                    getEcranChoisirTransport().getvilleEtudiee().getTransportDansLaVille().remove(i);
                                    trouve = true;
                                }
                                else {
                                    i++;
                                }
                            }

                            ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                            ecranChoixEmploye.ajoutComposant();
                            ecranChoixEmploye.setVisible(true);
                        }
                    }
                });

            }
        });
        /**modifier un transport*/
        ecranTransport.getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranTransport.setVisible(false);
                ecranChoisirTransport.setContentPane(ecranChoisirTransport.buildContentPane());
                for(int i=0; i<getListeVille().size();i++){
                    if(getListeVille().get(i).getNomVille().equals(ecranChoixEmploye.getVilleModifie())){
                        ecranChoisirTransport.setvilleEtudiee(getListeVille().get(i));
                    }
                }
                setTableSupprimerTransport(ecranChoisirTransport.ajoutComposant2());
                ecranChoisirTransport.setVisible(true);
                getTableSupprimerTransport().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1)
                        {
                            int ligne = tableSupprimerTransport.getSelectedRow();
                            Transport supp = ecranChoisirTransport.getvilleEtudiee().getTransportDansLaVille().get(ligne); /** recuperation du logement à supprimer */
                            ecranChoisirTransport.setVisible(false);
                            ecranAjouterTransport.setContentPane(ecranAjouterTransport.buildContentPane());

                            boolean trouve = false;
                            int i = 0;

                            while(!trouve)
                            {
                                if(getEcranChoisirTransport().getvilleEtudiee().getTransportDansLaVille().get(i).equals(supp))
                                {
                                    getEcranChoisirTransport().getvilleEtudiee().getTransportDansLaVille().remove(i);
                                    trouve = true;
                                }
                                else {
                                    i++;
                                }
                            }

                            ecranAjouterTransport.setVilleModifie(ecranChoixEmploye.getVilleModifie());
                            ecranAjouterTransport.ajoutComposant();
                            ecranAjouterTransport.setVisible(true);
                        }
                    }
                });

            }
        });

        getEcranChoisirTransport().getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoisirTransport.setVisible(false);
                ecranTransport.setContentPane(ecranTransport.buildContentPane());
                ecranTransport.ajoutComposant();
                ecranTransport.setVisible(true);
            }
        });

        /**BOUTON RETOUR*/
        ecranTransport.getBoutonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranTransport.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();
                ecranChoixEmploye.setVisible(true);
            }
        });
        ecranReportingEmploye.getBoutonHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranReportingEmploye.setVisible(false);
                ecranChoixEmploye.setContentPane(ecranChoixEmploye.buildContentPane());
                ecranChoixEmploye.ajoutComposant();;
                ecranChoixEmploye.setVisible(true);
            }
        });
        ecranChoixEmploye.getBoutonReporting().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranChoixEmploye.setVisible(false);
                ecranReportingChoixEmploye.setContentPane(ecranReportingChoixEmploye.buildContentPane());
                ecranReportingChoixEmploye.ajoutComposant();
                ecranReportingChoixEmploye.setVisible(true);
            }
        });
        ecranReportingChoixEmploye.getBoutonAnalyse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecranReportingChoixEmploye.setVisible(false);
                ecranReportingEmploye.setContentPane(ecranReportingEmploye.buildContentPane());
                ecranReportingEmploye.setLogement(ecranReportingChoixEmploye.getLogement());
                ecranReportingEmploye.setAnneeEtudiee(ecranReportingChoixEmploye.getAnneeEtudiee());
                ecranReportingEmploye.setVilleEtudiee(ecranReportingChoixEmploye.getVilleEtudiee());
                ecranReportingEmploye.ajoutComposant();
                ecranReportingEmploye.setVisible(true);
            }
        });
    }

    public static void enregistrement()
    {
        /*--------------------------------------------------------------------*/
        /*--------------------------------------------------------------------*/
        try{
            baseDeDonnees.enregistrementDonnees(listeVille,listeClient,listeEmploye,historique);
            System.out.println("SUCCES");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        /*--------------------------------------------------------------------*/
        /*--------------------------------------------------------------------*/
    }
}

