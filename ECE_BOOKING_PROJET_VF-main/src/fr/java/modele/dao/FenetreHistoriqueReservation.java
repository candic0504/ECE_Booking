package fr.java.modele.dao;

import fr.java.controleur.Recherche.Client;
import fr.java.controleur.Recherche.Employe;
import fr.java.controleur.Recherche.Ville;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

public class FenetreHistoriqueReservation extends Fenetre {

    /**ATTRIBUT DE LA CLASSE FILLE**/
    private JButton boutonRetour =new JButton("RETOUR RECHERCHE");
    private Client utilisateur = new Client();
    public Client getUtilisateur(){ return utilisateur ;}

    public void setUtilisateur(Client utilisateur) {
        this.utilisateur = utilisateur;
    }

    public JButton getBoutonRetour(){ return boutonRetour;}

    /** CONSTRUCTEURS */
    /** Construction du panneau **/
    private JPanel buildContentPane(){
        /** Création JPanel avec une image pour fond **/
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String nomChemin = "images/historique.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e){
                    System.out.println("erreur image");
                }

                /**Image image = new ImageIcon("C:\\historique.png").getImage();*/

                g.drawImage(image, 0, 0, this);
            }
        };
        boutonRetour.setBounds(700,620,200,30);
        pan.add(boutonRetour);
        pan.setLayout(null);
        pan.setBackground(new Color(182, 217, 217));
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreHistoriqueReservation(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Connexion"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /** METHODES */
    /** Affiche l'historique de reservation du client sur le site */
    @Override
    public void ajoutComposant() {

        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        setContentPane(buildContentPane());

        for(int i=0 ; i<getUtilisateur().getReservationEnCours().size() ; i++)
        {
            System.out.println(" TESTT : " + getUtilisateur().getReservationEnCours().get(i).getLocataire());
        }

        Object [][] donnee = new Object[getUtilisateur().getReservationEnCours().size()][5];
        for(int i=0;i<getUtilisateur().getReservationEnCours().size();i++){
            donnee[i][0] = getUtilisateur().getNom();
            donnee[i][1] = getUtilisateur().getReservationEnCours().get(i).getHebergementReserve().getNom();
            donnee[i][2] = getUtilisateur().getReservationEnCours().get(i).getDateArrivee().get(Calendar.DAY_OF_MONTH) + "/" + (getUtilisateur().getReservationEnCours().get(i).getDateArrivee().get(Calendar.MONTH)+1) + "/" + getUtilisateur().getReservationEnCours().get(i).getDateArrivee().get(Calendar.YEAR);
            donnee[i][3] = getUtilisateur().getReservationEnCours().get(i).getDateDepart().get(Calendar.DAY_OF_MONTH) + "/" + (getUtilisateur().getReservationEnCours().get(i).getDateDepart().get(Calendar.MONTH)+1) + "/" + getUtilisateur().getReservationEnCours().get(i).getDateDepart().get(Calendar.YEAR);
            donnee[i][4] = getUtilisateur().getReservationEnCours().get(i).getReductionUtilisee();
        }

        Calendar test = Calendar.getInstance();
        System.out.println(test);


        DefaultTableModel tab = new DefaultTableModel(donnee, new Object[]{"Nom","Nom du logement réservé","Date d'arrivée","Date de fin","Promotion"});
        JTable table = new JTable(tab);
        table.setRowHeight(100);
        table.setShowGrid(true);
        for(int i=1;i<5;i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        table.setBackground(new Color(168, 147, 120));
        table.setBounds(150,200,700,300);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(150,200,700,300);

        panel.add(scroll);
    }
}
