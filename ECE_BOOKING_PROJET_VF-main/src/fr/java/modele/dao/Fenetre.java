package fr.java.modele.dao;

import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.RechercheReservation;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Fenetre extends JFrame {

     /**ATTRIBUTS*/
     protected JPanel panel;
     private ArrayList<Client> listeClient;
     private ArrayList<Employe> listeEmploye;
     private ArrayList<Ville> listeVille;
     private HistoriqueReservation historique;


     /**CONSTRUCTEURS*/
     public Fenetre(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique)
     {
          this.listeClient = listeClient;
          this.listeEmploye = listeEmploye;
          this.listeVille = listeVille;
          this.historique = historique;
     }

     /**GETTER ET SETTER*/
     public JPanel getPanel() {return panel;}
     public ArrayList<Ville> getListeVille() {return listeVille;}
     public void setVille(ArrayList<Ville> ville) {this.listeVille = ville;}
     public HistoriqueReservation getHistorique() {return historique;}
     public void setHistorique(HistoriqueReservation historiqueToutesReservations) {this.historique = historiqueToutesReservations;}

     public ArrayList<Client> getListeClient() {
          return listeClient;
     }

     public ArrayList<Employe> getListeEmploye() {
          return listeEmploye;
     }

     public void setListeClient(ArrayList<Client> listeClient) {
          this.listeClient = listeClient;
     }

     public void setListeEmploye(ArrayList<Employe> listeEmploye) {
          this.listeEmploye = listeEmploye;
     }

     public void setListeVille(ArrayList<Ville> listeVille) {
          this.listeVille = listeVille;
     }

     /**METHODES*/
     public abstract void ajoutComposant();
}


