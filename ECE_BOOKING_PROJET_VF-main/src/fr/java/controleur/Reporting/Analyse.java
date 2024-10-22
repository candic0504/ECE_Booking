package fr.java.controleur.Reporting;
import fr.java.controleur.MiseAJour.Paiement;
import fr.java.controleur.MiseAJour.Reservation;
import fr.java.controleur.Recherche.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.TreeMap;
import java.util.EventListener;
import javax.swing.*;
import org.jfree.chart.renderer.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;

import org.jfree.chart.axis.ValueAxis;


 public class Analyse extends JFrame{
    /** ATTRIBUTS */

    /**CONSTRUCTEURS*/
    public Analyse() {

    }

    public ChartPanel camembergEtoile(Hebergement logementAnalyse) { /**METHODE QUI AFFICHE LA REPARTITION DES AVIS PAR HEBERGEMENT*/

        /**RECUPERATIONS DES DONNEES*/
        TreeMap<String,Integer> etoile = logementAnalyse.getNotesClients();
        Set totalDonnee = etoile.entrySet();
        Iterator it = totalDonnee.iterator();/**CREATION D'UN ITERATEUR POUR PARCOURIR TOUTES LES DONNEES*/
        /**CREATION DES COMPTEURS ET INITIALISATIONS A 0*/
        int zero = 0;
        int une = 0;
        int deux = 0;
        int trois = 0;
        int quatre = 0;
        int cinq = 0;
        /**INCREMENTATION DES COMPTEURS */
        while (it.hasNext()) {
            Map.Entry valeur = (Map.Entry)it.next();
            if (valeur.getValue().equals(0)) {
                zero++;
            }else if (valeur.getValue().equals(1)) {
                une++;
            } else if (valeur.getValue().equals(2)) {
                deux++;
            } else if (valeur.getValue().equals(3)) {
                trois++;
            } else if (valeur.getValue().equals(4)) {
                quatre++;
            } else if (valeur.getValue().equals(5)) {
                cinq++;
            } else{
                //on ne prend pas en compte -1
            }
        }
        /**RECUPERATION DES DONNEES POUR LE DIAGRAMME*/
        DefaultPieDataset nbrEtoileHebergement = new DefaultPieDataset(); /**creation de l'objet de la classe*/
        nbrEtoileHebergement.setValue("0 Etoile", zero);
        nbrEtoileHebergement.setValue("1 Etoile", une);
        nbrEtoileHebergement.setValue("2 Etoile", deux);
        nbrEtoileHebergement.setValue("3 Etoile", trois);
        nbrEtoileHebergement.setValue("4 Etoile", quatre);
        nbrEtoileHebergement.setValue("5 Etoile", cinq);
        /**CREATION DU DIAGRAMME*/
        JFreeChart camembergNbrEtoile = ChartFactory.createPieChart(
                "Nombre d'étoile pour le logement : " + logementAnalyse.getNom(),
                nbrEtoileHebergement,
                false,
                true,
                true);

        /**CUSTOMISATIONS*/
        PiePlot plot = (PiePlot) camembergNbrEtoile.getPlot(); /**variable de cutomisation*/
        plot.setIgnoreZeroValues(true); /**Si les valeurs sont nulles alors on ne l'affiche pas */
        plot.setSectionPaint("0 Etoile", new Color(0, 255, 234));
        plot.setSectionPaint("1 Etoile", new Color(0, 50, 255));
        plot.setSectionPaint("2 Etoile", new Color(50, 100, 255));
        plot.setSectionPaint("3 Etoile", new Color(100, 150, 255));
        plot.setSectionPaint("4 Etoile", new Color(150, 200, 255));
        plot.setSectionPaint("5 Etoile", new Color(200, 250, 255));
        plot.setSectionOutlinesVisible(false);
        plot.setLabelBackgroundPaint(Color.BLACK);
        plot.setLabelPaint(Color.white);
        plot.setBackgroundPaint(Color.white);
        /**RENVOIE DES DONNES DU DIAGRAMME POUR L'AFFICHAGE*/
        ChartPanel cPanel = new ChartPanel(camembergNbrEtoile);
        return cPanel;
    }
    public ChartPanel camembergLogementVille(Ville villeAnalyse, HistoriqueReservation recap, int anneeEnCours) { /**METHODE QUI AFFICHE LA REPARTITION DES AVIS PAR HEBERGEMENT PAR VILLE PAR ANNEE*/

        ArrayList<Integer> compteur = new ArrayList<>();
        ArrayList<Color> couleur = new ArrayList<>();
        /** INCREMENTATIONS DES COMPTEURS */
        for (int i = 0; i < villeAnalyse.getListeHebergement().size(); i++) { //parcours des logements par ville
            compteur.add(i, 0);
            for (int j = 0; j < recap.getToutesLesReservations().size(); j++) { //parcours des reservations
                if (villeAnalyse.getListeHebergement().get(i) == recap.getToutesLesReservations().get(j).getHebergementReserve()) {
                    if (recap.getToutesLesReservations().get(j).getDateDepart().get(Calendar.YEAR) == anneeEnCours) {
                        int cmpt = compteur.get(i);
                        compteur.set(i, cmpt + 1);
                    }
                }
            }
        }
        /**RECUPERATION DES DONNEES POUR LE DIAGRAMME*/
        DefaultPieDataset maxVenteHebergement = new DefaultPieDataset(); /**creation de l'objet de la classe*/
        for (int i = 0; i < villeAnalyse.getListeHebergement().size(); i++) { //parcours des logements par ville
            maxVenteHebergement.setValue(villeAnalyse.getListeHebergement().get(i).getNom(), compteur.get(i));
        }
        /**CREATION DU DIAGRAMME*/
        JFreeChart camembergMaxVente = ChartFactory.createPieChart(
                "Logement le plus loué dans la ville : " + villeAnalyse.getNomVille(),
                maxVenteHebergement,
                false,
                true,
                true);
        /**CUSTOMISATIONS*/
        PiePlot plot = (PiePlot) camembergMaxVente.getPlot(); /**variable de cutomisation*/
        plot.setIgnoreZeroValues(true); /**Si les valeurs sont nulles alors on ne l'affiche pas */

        couleur.add(new Color(22, 184, 78));
        couleur.add(new Color(84, 249, 141));
        couleur.add(new Color(20, 148, 20));
        couleur.add(new Color(0, 255, 0));
        couleur.add(new Color(34, 120, 15));
        couleur.add(new Color(176, 242, 182));
        couleur.add(new Color(1, 215, 88));
        couleur.add(new Color(0, 86, 27));
        couleur.add(new Color(31, 160, 85));
        couleur.add(new Color(151, 223, 198));
        couleur.add(new Color(190, 245, 116));
        couleur.add(new Color(0, 255, 127));
        couleur.add(new Color(104, 157, 113));
        couleur.add(new Color(165, 209, 82));
        couleur.add(new Color(64, 130, 109));
        for (int i = 0; i < villeAnalyse.getListeHebergement().size(); i++) {
            plot.setSectionPaint(villeAnalyse.getListeHebergement().get(i).getNom(), couleur.get(i));

        }
        plot.setSectionOutlinesVisible(false);
        plot.setLabelBackgroundPaint(Color.BLACK);
        plot.setLabelPaint(Color.white);
        plot.setBackgroundPaint(Color.white);
        /**RENVOIE DES DONNES DU DIAGRAMME POUR L'AFFICHAGE*/
        ChartPanel cPanel = new ChartPanel(camembergMaxVente);
        return cPanel;
    }
    public ChartPanel graphVentesTotales(HistoriqueReservation recap, int anneeEnCours) { /**METHODE QUI AFFICHE LA REPARTITION DES AVIS PAR HEBERGEMENT PAR VILLE PAR ANNEE*/

        String annee = Integer.toString(anneeEnCours);
        /**CREATION DES DIFFERENTS COMPTEURS*/
        ArrayList<Integer> compteur = new ArrayList<>();
        ArrayList<String> mois = new ArrayList<>();
        mois.add("janvier");
        mois.add("février");
        mois.add("mars");
        mois.add("avril");
        mois.add("mai");
        mois.add("juin");
        mois.add("juillet");
        mois.add("aout");
        mois.add("septembre");
        mois.add("octobre");
        mois.add("novembre");
        mois.add("décembre");
        /** INCREMENTATIONS DES COMPTEURS */
        for (int i = 0; i < 12; i++) { //parcours des mois
            compteur.add(i, 0);
            for (int j = 0; j < recap.getToutesLesReservations().size(); j++) { //parcours des reservations
                if (recap.getToutesLesReservations().get(j).getDateDepart().get(Calendar.YEAR) == anneeEnCours) {
                    if (recap.getToutesLesReservations().get(j).getDateDepart().get(Calendar.MONTH) == i) {
                        {
                            int cmpt = compteur.get(i);
                            compteur.set(i, cmpt + 1);
                        }
                    }
                }
            }
        }
        /**RECUPERATION DES DONNEES POUR LE DIAGRAMME*/
        DefaultCategoryDataset maxVenteHebergement = new DefaultCategoryDataset(); /**creation de l'objet de la classe*/
        for (int i = 0; i <12; i++) { //parcours des logements par ville
            maxVenteHebergement.addValue(compteur.get(i), annee, mois.get(i)); /**REMPLISSAGES DES DONNEES*/

        }
        /**CREATION DU DIAGRAMME*/
        JFreeChart diagrammeNbrVentes = ChartFactory.createBarChart(
                "Nombre totale de location par mois sur l'année " + annee,
                " MOIS",
                " NBR DE VENTE ",
                maxVenteHebergement, //donnee
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        /**CUSTOMISATIONS*/
        CategoryPlot plot = (CategoryPlot) diagrammeNbrVentes.getCategoryPlot(); //variable qu permet de modifier les couleurs de la grille
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(new Color(223, 58, 244));
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        for (int i = 0; i < 12; i++) { //parcours des logements par ville
            renderer.setSeriesPaint(i, new Color(223, 58, 244));
        }
        /**MODIFICATION DES GRADUTAIONS DE L'AXE DES ORDONNEES*/
        NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        TickUnitSource units = NumberAxis.createIntegerTickUnits();
        axis.setStandardTickUnits(units);
        /**RENVOIE DES DONNES DU DIAGRAMME POUR L'AFFICHAGE*/
        ChartPanel cPanel = new ChartPanel(diagrammeNbrVentes);
        return cPanel;
    }
    public ChartPanel graphVentesReductions(HistoriqueReservation recap, int anneeEnCours) { /**METHODE QUI AFFICHE LA REPARTITION DES AVIS PAR HEBERGEMENT PAR VILLE PAR ANNEE*/

        String annee = Integer.toString(anneeEnCours);
        /**CREATION DES DIFFERENTS COMPTEURS*/
        TreeMap<Integer, Integer> reduction = new TreeMap<>(); //stocke en clé la réduction et en valeur le compteur
        int i=0;
        while(i<=100){
            reduction.put(i,0);
            i=i+5;
        }
        /** INCREMENTATIONS DES COMPTEURS */
        //for (int i = 0; i < 80; i++) { //parcours des mois
       i=0;
        while(i<=100){
            for (int j = 0; j < recap.getToutesLesReservations().size(); j++) { //parcours des reservations
                if (recap.getToutesLesReservations().get(j).getDateDepart().get(Calendar.YEAR) == anneeEnCours) {
                    if (recap.getToutesLesReservations().get(j).getReductionUtilisee() == i) {
                        {
                            int cmpt = reduction.get(i);
                            reduction.put(i,cmpt+1);
                        }
                    }
                }
            }
            i=i+5;
        }

        /**RECUPERATION DES DONNEES POUR LE DIAGRAMME*/
        i=0;
        DefaultCategoryDataset maxVenteReductions = new DefaultCategoryDataset(); /**creation de l'objet de la classe*/
        while(i<=100){//for (int i = 0; i <80; i++) { //parcours des logements par ville
            Comparable<Integer> key= i;
            maxVenteReductions.addValue(reduction.get(i), annee, key); /**REMPLISSAGES DES DONNEES*/

            i=i+5;
        }
        /**CREATION DU DIAGRAMME*/
        JFreeChart diagrammeReductionsVentes = ChartFactory.createBarChart(
                "Nombre totale de location par réduction sur l'année " + annee,
                " REDUCTIONS",
                " NBR DE VENTE ",
                maxVenteReductions,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        /**CUSTOMISATIONS*/
        CategoryPlot plot = (CategoryPlot) diagrammeReductionsVentes.getCategoryPlot(); //variable qu permet de modifier les couleurs de la grille
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(new Color(150, 131, 236));
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        i=0;
        while(i<=100){//for (int i = 0; i < 80; i++) { //parcours des logements par ville
            renderer.setSeriesPaint(i, new Color(150, 131, 236));
            i=i+5;
        }
        /**MODIFICATION DES GRADUTAIONS DE L'AXE DES ORDONNEES*/
        NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        TickUnitSource units = NumberAxis.createIntegerTickUnits();
        axis.setStandardTickUnits(units);
        /**RENVOIE DES DONNES DU DIAGRAMME POUR L'AFFICHAGE*/
        ChartPanel cPanel = new ChartPanel(diagrammeReductionsVentes);
        return cPanel;
    }
    public ChartPanel graphAchatClient(Client client, HistoriqueReservation recap, int anneeEnCours) { /**METHODE QUI AFFICHE LA REPARTITION DES AVIS PAR HEBERGEMENT PAR VILLE PAR ANNEE*/

        String annee = Integer.toString(anneeEnCours);
        /**CREATION DES COMPTEURS*/
        ArrayList<Integer> compteur = new ArrayList<>();
        ArrayList<String> mois = new ArrayList<>();
        mois.add("janvier");
        mois.add("février");
        mois.add("mars");
        mois.add("avril");
        mois.add("mai");
        mois.add("juin");
        mois.add("juillet");
        mois.add("aout");
        mois.add("septembre");
        mois.add("octobre");
        mois.add("novembre");
        mois.add("décembre");
        /** INCREMENTATIONS DES COMPTEURS */
        for (int i = 0; i < 12; i++) { //parcours des mois
            compteur.add(i, 0);
            for (int j = 0; j < recap.getToutesLesReservations().size(); j++) { //parcours des reservations
                if(recap.getToutesLesReservations().get(j).getLocataire() == client){
                    if (recap.getToutesLesReservations().get(j).getDateDepart().get(Calendar.YEAR) == anneeEnCours) {
                        if (recap.getToutesLesReservations().get(j).getDateDepart().get(Calendar.MONTH) == i) {
                            {
                                int cmpt = compteur.get(i);
                                compteur.set(i, cmpt + 1);
                            }
                        }
                    }
                }
            }
        }
        /**RECUPERATION DES DONNEES POUR LE DIAGRAMME*/
        DefaultCategoryDataset achatClient = new DefaultCategoryDataset(); /**creation de l'objet de la classe*/
        for (int i = 0; i <12; i++) { /**parcours des logements par ville*/
            achatClient.addValue(compteur.get(i), annee, mois.get(i)); /**REMPLISSAGES DES DONNEES*/
        }
        /**CREATION DU DIAGRAMME*/
        JFreeChart diagrammeAchatCLient = ChartFactory.createBarChart(
                "Nombre de location par mois sur l'année " + annee + " par " + client.getNom() + " " + client.getPrenom(),
                " MOIS",
                " NBR DE VENTE ",
                achatClient, //donnee
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        /**CUSTOMISATIONS*/
        CategoryPlot plot = (CategoryPlot) diagrammeAchatCLient.getCategoryPlot(); //variable qu permet de modifier les couleurs de la grille
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(new Color(150, 131, 236));
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        for (int i = 0; i < 12; i++) { //parcours des logements par ville
            renderer.setSeriesPaint(i, new Color(150, 131, 236));
        }
        /**MODIFICATION DES GRADUTAIONS DE L'AXE DES ORDONNEES*/
        NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        TickUnitSource units = NumberAxis.createIntegerTickUnits();
        axis.setStandardTickUnits(units);
        /**RENVOIE DES DONNES DU DIAGRAMME POUR L'AFFICHAGE*/
        ChartPanel cPanel = new ChartPanel(diagrammeAchatCLient);
        return cPanel;
    }

    public void creationAnalyseClient(HistoriqueReservation historique, Client utilisateurDuSite, ArrayList<Ville> toutesLesVilles)
    {
         /**AFFICHAGE ANALYSE YSEE */
         System.out.println("AFFICHAGE DE L'ANALYSE DU CLIENT");
    }

    public void creationAnalyseEmploye(HistoriqueReservation historique, Employe travailleur, ArrayList<Ville> toutesLesVilles)
    {
         /**AFFICHAGE ANALYSE YSEE */
         System.out.println("AFFICHAGE DE L'ANALYSE DE L'EMPLOYE");
    }
}




