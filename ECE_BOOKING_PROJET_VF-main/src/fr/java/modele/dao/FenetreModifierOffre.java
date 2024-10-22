package fr.java.modele.dao;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FenetreModifierOffre extends Fenetre {

    /**ATTRIBUTS*/
    /**
     * bouton
     */
    private JButton boutonReporting = new JButton("REPORTING");
    private JButton boutonRetour = new JButton("RETOUR");
    private JButton boutonAjouter = new JButton("AJOUTER");

    /**variables de stockage*/
    ArrayList<Hebergement> listeLogement = new ArrayList<>();


    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonRetour() {
        return boutonRetour;
    }

    public JButton getBoutonAjouter() {
        return boutonAjouter;
    }


    /**variables de stockage*/
    public ArrayList<Hebergement> getListeLogement() {
        return listeLogement;
    }

    public void setListeLogement(ArrayList<Hebergement> listeLogement) {
        this.listeLogement = listeLogement;
    }

    public void ajouterListeLogement(Hebergement h) {
        this.listeLogement.add(h);
    }


    /**Construction du panneau*/
    public JPanel buildContentPane() {
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/modif.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try{
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e) {
                    System.out.println("erreur image");
                }
                g.drawImage(image, 0, 0, this);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(199, 182, 217));

        this.panel = pan;

        return panel;
    }

    /**ouverture et parametres de la fenetre*/
    public FenetreModifierOffre(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat) {
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Modifier une offre"); //On donne un titre à l'application
        setSize(1000, 700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }

    /** METHODES */
    public void ajoutComposant() {
    }

    /** Affiche toutes les offres correspondantes, pour ensuite en choisir une et la modifier*/
    public JTable ajoutComposant2() {

        panel.removeAll();
        panel.revalidate();
        panel.repaint();

        System.out.println("TAILLE LISTE : " + getListeLogement().size());
        boutonReporting.setBounds(10,10,100,30);
        panel.add(boutonReporting);
        boutonRetour.setBounds(10,600,100,30);
        panel.add(boutonRetour);

        /** REMPLIR LES DONNEES GRACE A L'ARRAYLISTE REMPLIT EN FONCTION DE LA VILLE ET DU TYPE DE LOGEMENT*/
        Object [][] donnee = new Object[getListeLogement().size()][5];

        for(int i=0;i< getListeLogement().size();i++){
            try {
                URL imageUrl = new URL(getListeLogement().get(i).getURL());
                donnee[i][0] = imageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
            donnee[i][1]=getListeLogement().get(i).getNom();
            donnee[i][2]=getListeLogement().get(i).getAdresse();
            donnee[i][3]=getListeLogement().get(i).getTarifUnAdulteUneNuit()+getListeLogement().get(i).getTarifUnEnfantUneNuit();
            donnee[i][4]=getListeLogement().get(i).getCapacite();
        }
        for(int i=0;i< getListeLogement().size();i++) {
            System.out.println(donnee[i][1]);
        }

        /** CREATION DU MODELE DE DONNEES POUR LA TABLE */
        DefaultTableModel tab = new DefaultTableModel(donnee, new Object[]{"Photo","Nom","Adresse","Tarif","Capacite"});

        /** CREATION DE LA TABLE COMPRENANT LES OFFRES */
        JTable table = new JTable(tab);

        /** PARAMETRE DE LA TABLE */
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());/**affichage de l'image*/
        table.setRowHeight(100);
        table.setShowGrid(true);
        for(int i=1;i<5;i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        table.setBackground(new Color(199, 182, 217));
        table.setBounds(120,150,750,450); /**taille de la table*/

        /** AJOUT SCROLL BAR SUR CHAQUE TABLE */
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(120,150,750,450);/**taille du composant*/
        panel.add(scroll);/**ajout du composant au panel*/

        return table;
    }


    /** CLASSE PERMETTANT DE CHARGER UNE IMAGE DANS LE TABLEAU */
    static class ImageCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof URL) {
                try {
                    BufferedImage img = ImageIO.read((URL) value);
                    ImageIcon icon = new ImageIcon(scaleImage(img, 80, 80));
                    label.setIcon(icon);
                    label.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return label;
        }

        private Image scaleImage(BufferedImage img, int width, int height) {
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return scaledImage;
        }
    }
}