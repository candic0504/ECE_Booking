package fr.java.modele.dao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.HistoriqueReservation;

public class FenetreRecherche extends Fenetre{

    /**ATTRIBUT DE LA CLASSE FILLE**/
    private JButton boutonReporting =new JButton("REPORTING");
    private JButton boutonAccesPage=new JButton("RECHERCHER");
    private JButton boutonHistoriqueClient =new JButton("HISTORIQUE");
    private JButton boutonConnexion = new JButton("SE CONNECTER");
    private JButton boutonInscription = new JButton("S'INSCRIRE");

    /**attributs qui permettent de récpérer les informations de la recherche*/
    private RechercheReservation critereDuLogement;



    public JButton getBoutonReporting() {return boutonReporting;}
    public JButton getBoutonAccesPage(){return boutonAccesPage;}
    public JButton getBoutonHistoriqueClient(){return boutonHistoriqueClient;}

    public JButton getBoutonConnexion() {
        return boutonConnexion;
    }

    public JButton getBoutonInscription() {
        return boutonInscription;
    }

    public RechercheReservation getCritereDuLogement() {
        return critereDuLogement;
    }

    public void setCritereDuLogement(RechercheReservation critereDuLogement) {
        this.critereDuLogement = critereDuLogement;
    }


    /** Construction du panneau **/
    private JPanel buildContentPane(){
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String nomChemin = "images/fond.png";
                File imageFile = new File(nomChemin);
                Image image = new ImageIcon().getImage();
                try {
                    BufferedImage buffered = ImageIO.read(imageFile);
                    image = buffered.getScaledInstance(buffered.getWidth(), buffered.getHeight(), Image.SCALE_SMOOTH);
                }
                catch(java.io.IOException e){
                    System.out.println("erreur image");
                }

                /**Image image = new ImageIcon("C:\\fond.png").getImage();*/
                g.drawImage(image, 0, 0, this);
            }
        };
        pan.setLayout(null);
        pan.setBackground(new Color(190, 136, 136));
        boutonReporting.setBounds(10,10,150,30);
        pan.add(boutonReporting);
        boutonAccesPage.setBounds(850,620,130,30);
        pan.add(boutonAccesPage);
        boutonHistoriqueClient.setBounds(830,10,150,30);
        pan.add(boutonHistoriqueClient);
        boutonConnexion.setBounds(300,10,150,30);
        pan.add(boutonConnexion);
        boutonInscription.setBounds(540,10,150,30);
        pan.add(boutonInscription);
        this.panel=pan;
        return panel;
    }

    /** ouverture et parametres de la fenetre**/
    public FenetreRecherche(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat){

        super(listeClient, listeEmploye, listeVille, historique);
        this.critereDuLogement = new RechercheReservation();
        setTitle("Recherche d'un logement"); //On donne un titre à l'application
        setSize(1000,700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /**METHODES*/
    /** Saisie des filtres pour la recherche de logement*/
    public void ajoutComposant(){

        /** AJOUT des filtres de recherche de réservation **/

        /** DESTINATION */
        String[] ville = new String[getListeVille().size()];
        for(int i=0 ; i<ville.length ; i++)
        {
            ville[i] = getListeVille().get(i).getNomVille();
        }
        JComboBox<String> destination = new JComboBox<>(ville);
        destination.setBounds(163,325,150,30);
        JLabel titreDestination = new JLabel("Destination : ");
        titreDestination.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreDestination.setBounds(162, 305, 800, 20);
        panel.add(titreDestination);
        panel.add(destination);
        destination.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                nouvel.setVille((String)destination.getSelectedItem());
                setCritereDuLogement(nouvel);
                System.out.println("Destination saisie : " + nouvel.getVille());
            }
        });

        /** CATEGORIE LOGEMENT */
        String[] options = { "Tous", "Appartement","Maison","Hotel", "Villa", "Chalet", "Complexe Hoitelier"};
        JComboBox<String> categorie = new JComboBox<>(options);
        categorie.setBounds(164,400,150,30);
        JLabel titreCategorie = new JLabel("Type de logement :  ");
        titreCategorie.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreCategorie.setBounds(163, 380, 800, 20);
        panel.add(categorie);
        panel.add(titreCategorie);
        categorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                String categorieRecup = (String)categorie.getSelectedItem();
                if(!categorieRecup.equals("Tous"))
                {
                    nouvel.setCategorie((String)categorie.getSelectedItem());
                    setCritereDuLogement(nouvel);
                    System.out.println("Categorie saisie : " + nouvel.getCategorie());
                }
            }
        });

        /** NOMBRE D'ADULTE' */
        JTextField nbAdulte = new JTextField();
        nbAdulte.setColumns(10);
        nbAdulte.setBounds(300,470,150,30);
        JLabel titreAdulte = new JLabel("Nombre d'adulte :  ");
        titreAdulte.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreAdulte.setBounds(300, 450, 800, 20);
        panel.add(nbAdulte);
        panel.add(titreAdulte);
        nbAdulte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();

                try{
                    nouvel.setNombreAdulte(Integer.parseInt(nbAdulte.getText()));
                }catch(NumberFormatException recup){
                    nouvel.setNombreAdulte(0);
                }

                setCritereDuLogement(nouvel);
                System.out.println("Nombre d'adulte saisie : " + nouvel.getNombreAdulte());
            }
        });


        /** NOMBRE D'ENFANT */
        JTextField nbEnfant = new JTextField();
        nbEnfant.setColumns(10);
        nbEnfant.setBounds(500,470,150,30);
        JLabel titreEnfant = new JLabel("Nombre d'enfant :  ");
        titreEnfant.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreEnfant.setBounds(500, 450, 800, 20);
        panel.add(nbEnfant);
        panel.add(titreEnfant);
        nbEnfant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();

                try{
                    nouvel.setNombreEnfant(Integer.parseInt(nbEnfant.getText()));
                }catch(NumberFormatException recup){
                    nouvel.setNombreEnfant(0);
                }

                setCritereDuLogement(nouvel);
                System.out.println("Nombre d'enfant saisie : " + nouvel.getNombreEnfant());
            }
        });


        /** DATE ARRIVEE */

        JLabel dateArrivee = new JLabel("Date d'arrivée :");
        dateArrivee.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        dateArrivee.setBounds(570, 305, 800, 20);

        Integer[] jours = new Integer[31];
        for(int i=0;i< jours.length;i++){
            jours[i]=i+1;
        }
        Integer[] mois = new Integer[12];
        for(int i =0;i< mois.length;i++){
            mois[i]=i+1;
        }
        Integer[] annee = new Integer[10];
        for(int i=0 ; i<annee.length ; i++)
        {
            annee[i]=2023+i;
        }
        JComboBox<Integer> joursArrivee = new JComboBox<>(jours);
        JComboBox<Integer> moisArrivee = new JComboBox<>(mois);
        JComboBox<Integer> anneeArrivee = new JComboBox<>(annee);
        joursArrivee.setBounds(570, 325, 50, 30);
        moisArrivee.setBounds(625, 325, 50, 30);
        anneeArrivee.setBounds(680, 325, 80, 30);
        panel.add(dateArrivee);
        panel.add(joursArrivee);
        panel.add(moisArrivee);
        panel.add(anneeArrivee);

        /**RECUPERATION DATE ARRIVEE */
        joursArrivee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                Calendar dateArrive = nouvel.getDateArrivee();
                String joursA = joursArrivee.getSelectedItem().toString();
                dateArrive.set(Calendar.DAY_OF_MONTH, Integer.parseInt(joursA));
                nouvel.setDateArrivee(dateArrive);
                setCritereDuLogement(nouvel);
                System.out.println("Date d'arrive saisie : " + nouvel.getDateArrivee().get(Calendar.DAY_OF_MONTH) + "/" + (nouvel.getDateArrivee().get(Calendar.MONTH)+1) + "/" + nouvel.getDateArrivee().get(Calendar.YEAR));
            }
        });

        moisArrivee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                Calendar dateArrive = nouvel.getDateArrivee();
                String moisA = moisArrivee.getSelectedItem().toString();
                dateArrive.set(Calendar.MONTH, Integer.parseInt(moisA)-1);
                nouvel.setDateArrivee(dateArrive);
                setCritereDuLogement(nouvel);
                System.out.println("Date d'arrive saisie : " + nouvel.getDateArrivee().get(Calendar.DAY_OF_MONTH) + "/" + (nouvel.getDateArrivee().get(Calendar.MONTH)+1) + "/" + nouvel.getDateArrivee().get(Calendar.YEAR));
            }
        });

        anneeArrivee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                Calendar dateArrive = nouvel.getDateArrivee();
                String anneA= anneeArrivee.getSelectedItem().toString();
                dateArrive.set(Calendar.YEAR, Integer.parseInt(anneA));
                nouvel.setDateArrivee(dateArrive);
                setCritereDuLogement(nouvel);
                System.out.println("Date d'arrive saisie : " + nouvel.getDateArrivee().get(Calendar.DAY_OF_MONTH) + "/" + (nouvel.getDateArrivee().get(Calendar.MONTH)+1) + "/" + nouvel.getDateArrivee().get(Calendar.YEAR));
            }
        });

        /** DATE DE DEPART */
        JLabel dateDepart = new JLabel("Date de départ :");
        dateDepart.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        dateDepart.setBounds(570, 380, 800, 20);

        JComboBox<Integer> joursDepart = new JComboBox<>(jours);
        JComboBox<Integer> moisDepart = new JComboBox<>(mois);
        JComboBox<Integer> anneeDepart = new JComboBox<>(annee);
        joursDepart.setBounds(570,400,50,30);
        moisDepart.setBounds(625,400,50,30);
        anneeDepart.setBounds(680,400,80,30);
        panel.add(dateDepart);
        panel.add(joursDepart);
        panel.add(moisDepart);
        panel.add(anneeDepart);

        /**RECUPERATION DATE DEPART */
        joursDepart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                Calendar dateDepart = nouvel.getDateDepart();
                String joursA = joursDepart.getSelectedItem().toString();
                dateDepart.set(Calendar.DAY_OF_MONTH, Integer.parseInt(joursA));
                nouvel.setDateDepart(dateDepart);
                setCritereDuLogement(nouvel);
                System.out.println("Date de depart saisie : " + nouvel.getDateDepart().get(Calendar.DAY_OF_MONTH) + "/" + (nouvel.getDateDepart().get(Calendar.MONTH)+1) + "/" + nouvel.getDateDepart().get(Calendar.YEAR));
            }
        });

        moisDepart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                Calendar dateDepart = nouvel.getDateDepart();
                String moisA = moisDepart.getSelectedItem().toString();
                dateDepart.set(Calendar.MONTH, Integer.parseInt(moisA)-1);
                nouvel.setDateDepart(dateDepart);
                setCritereDuLogement(nouvel);
                System.out.println("Date de depart saisie : " + nouvel.getDateDepart().get(Calendar.DAY_OF_MONTH) + "/" + (nouvel.getDateDepart().get(Calendar.MONTH)+1) + "/" + nouvel.getDateDepart().get(Calendar.YEAR));
            }
        });

        anneeDepart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercheReservation nouvel = getCritereDuLogement();
                Calendar dateDepart = nouvel.getDateDepart();
                String anneA=anneeDepart.getSelectedItem().toString();
                dateDepart.set(Calendar.YEAR, Integer.parseInt(anneA));
                nouvel.setDateDepart(dateDepart);
                setCritereDuLogement(nouvel);
                System.out.println("Date de depart saisie : " + nouvel.getDateDepart().get(Calendar.DAY_OF_MONTH) + "/" + (nouvel.getDateDepart().get(Calendar.MONTH)+1) + "/" + nouvel.getDateDepart().get(Calendar.YEAR));
            }
        });

    }
}

