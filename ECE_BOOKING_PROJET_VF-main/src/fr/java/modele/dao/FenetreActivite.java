package fr.java.modele.dao;

import fr.java.controleur.Recherche.*;
import fr.java.controleur.Reporting.HistoriqueReservation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class FenetreActivite extends Fenetre {

    /**ATTRIBUTS*/
    /**bouton*/
    private JButton boutonReporting = new JButton("REPORTING");
    private JButton boutonAjouter = new JButton("AJOUTER");

    /**variables de stockage des informations*/
    private Activite activiteAjoute = new Activite();
    private ComplexeHotelier complexeHotelierAjoute = new ComplexeHotelier();
    private ArrayList<Activite> activiteEnregistree = new ArrayList<>();


    /**GETTER ET SETTER*/
    /**bouton*/
    public JButton getBoutonAjouter() {return boutonAjouter;}

    /**variables de stockage des informations*/
    public Activite getActiviteAjoute() {return activiteAjoute;}
    public ComplexeHotelier getComplexeHotelierAjoute() {return complexeHotelierAjoute;}
    public void setComplexeHotelierAjoute(ComplexeHotelier complexeHotelierAjoute) {this.complexeHotelierAjoute = complexeHotelierAjoute;}
    public ArrayList<Activite> getActiviteEnregistree() {return activiteEnregistree;}


    /**CONSTRUCTEUR*/
    /**Construction du panneau*/
    private JPanel buildContentPane() {
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                String nomChemin = "images/activites.png";
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
        boutonAjouter.setBounds(850,600,100,30);
        pan.add(boutonAjouter);
        this.panel = pan;
        return panel;
    }

    /**ouverture et parametres de la fenetre*/
    public FenetreActivite(ArrayList<Client> listeClient, ArrayList<Employe> listeEmploye, ArrayList<Ville> listeVille, HistoriqueReservation historique, Boolean etat) {
        super(listeClient, listeEmploye, listeVille, historique);

        setTitle("Plateforme ajout des activités pour le complexe hotelier"); //On donne un titre à l'application
        setSize(1000, 700); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setVisible(etat);
        setContentPane(buildContentPane());
    }


    /**METHODES*/

    /** Donne la possibilité à l'employer de créer jusqu'à 8 activités qui pourront etre reliées à un Complexe Hotelier */
    public void ajoutComposant() {

        JLabel titreActivite1 = new JLabel("Activité 1 > nom ");
        titreActivite1.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite1.setBounds(50, 200, 130, 30);
        panel.add(titreActivite1);
        JTextField activite1nom = new JTextField();
        activite1nom.setColumns(25);
        activite1nom.setBounds(180, 200, 165, 30);
        panel.add(activite1nom);
        activite1nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite1nom.getText());
            }
        });

        JLabel titreActivite1Type = new JLabel("type ");
        titreActivite1Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite1Type.setBounds(350, 200, 40, 30);
        panel.add(titreActivite1Type);
        JTextField activite1Type = new JTextField();
        activite1Type.setColumns(25);
        activite1Type.setBounds(390, 200, 145, 30);
        panel.add(activite1Type);
        activite1Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite1Type.getText());
            }
        });

        JLabel titreActivite1pres = new JLabel("présentation ");
        titreActivite1pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite1pres.setBounds(540, 200, 110, 30);
        panel.add(titreActivite1pres);
        JTextField activite1pres = new JTextField();
        activite1pres.setColumns(25);
        activite1pres.setBounds(650, 200, 300, 30);
        panel.add(activite1pres);
        activite1pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite1pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });


        JLabel titreActivite2 = new JLabel("Activité 2 > nom ");
        titreActivite2.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite2.setBounds(50, 250, 130, 30);
        panel.add(titreActivite2);
        JTextField activite2nom = new JTextField();
        activite2nom.setColumns(25);
        activite2nom.setBounds(180, 250, 165, 30);
        panel.add(activite2nom);
        activite2nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite2nom.getText());
            }
        });

        JLabel titreActivite2Type = new JLabel("type ");
        titreActivite2Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite2Type.setBounds(350, 250, 40, 30);
        panel.add(titreActivite2Type);
        JTextField activite2Type = new JTextField();
        activite2Type.setColumns(25);
        activite2Type.setBounds(390, 250, 145, 30);
        panel.add(activite2Type);
        activite2Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite2Type.getText());
            }
        });

        JLabel titreActivite2pres = new JLabel("présentation ");
        titreActivite2pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite2pres.setBounds(540, 250, 110, 30);
        panel.add(titreActivite2pres);
        JTextField activite2pres = new JTextField();
        activite2pres.setColumns(25);
        activite2pres.setBounds(650, 250, 300, 30);
        panel.add(activite2pres);
        activite2pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite2pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });


        JLabel titreActivite3 = new JLabel("Activité 3 > nom ");
        titreActivite3.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite3.setBounds(50, 300, 130, 30);
        panel.add(titreActivite3);
        JTextField activite3nom = new JTextField();
        activite3nom.setColumns(25);
        activite3nom.setBounds(180, 300, 165, 30);
        panel.add(activite3nom);
        activite3nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite3nom.getText());
            }
        });

        JLabel titreActivite3Type = new JLabel("type ");
        titreActivite3Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite3Type.setBounds(350, 300, 40, 30);
        panel.add(titreActivite3Type);
        JTextField activite3Type = new JTextField();
        activite3Type.setColumns(25);
        activite3Type.setBounds(390, 300, 145, 30);
        panel.add(activite3Type);
        activite3Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite3Type.getText());
            }
        });

        JLabel titreActivite3pres = new JLabel("présentation ");
        titreActivite3pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite3pres.setBounds(540, 300, 110, 30);
        panel.add(titreActivite3pres);
        JTextField activite3pres = new JTextField();
        activite3pres.setColumns(25);
        activite3pres.setBounds(650, 300, 300, 30);
        panel.add(activite3pres);
        activite3pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite3pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });


        JLabel titreActivite4 = new JLabel("Activité 4 > nom ");
        titreActivite4.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite4.setBounds(50, 350, 130, 30);
        panel.add(titreActivite4);
        JTextField activite4nom = new JTextField();
        activite4nom.setColumns(25);
        activite4nom.setBounds(180, 350, 165, 30);
        panel.add(activite4nom);
        activite4nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite4nom.getText());
            }
        });

        JLabel titreActivite4Type = new JLabel("type ");
        titreActivite4Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite4Type.setBounds(350, 350, 40, 30);
        panel.add(titreActivite4Type);
        JTextField activite4Type = new JTextField();
        activite4Type.setColumns(25);
        activite4Type.setBounds(390, 350, 145, 30);
        panel.add(activite4Type);
        activite4Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite4Type.getText());
            }
        });

        JLabel titreActivite4pres = new JLabel("présentation ");
        titreActivite4pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite4pres.setBounds(540, 350, 110, 30);
        panel.add(titreActivite4pres);
        JTextField activite4pres = new JTextField();
        activite4pres.setColumns(25);
        activite4pres.setBounds(650, 350, 300, 30);
        panel.add(activite4pres);
        activite4pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite4pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });


        JLabel titreActivite5 = new JLabel("Activité 5 > nom ");
        titreActivite5.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite5.setBounds(50, 400, 130, 30);
        panel.add(titreActivite5);
        JTextField activite5nom = new JTextField();
        activite5nom.setColumns(25);
        activite5nom.setBounds(180, 400, 165, 30);
        panel.add(activite5nom);
        activite5nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite5nom.getText());
            }
        });

        JLabel titreActivite5Type = new JLabel("type ");
        titreActivite5Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite5Type.setBounds(350, 400, 40, 30);
        panel.add(titreActivite5Type);
        JTextField activite5Type = new JTextField();
        activite5Type.setColumns(25);
        activite5Type.setBounds(390, 400, 145, 30);
        panel.add(activite5Type);
        activite5Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite5Type.getText());
            }
        });

        JLabel titreActivite5pres = new JLabel("présentation ");
        titreActivite5pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite5pres.setBounds(540, 400, 110, 30);
        panel.add(titreActivite5pres);
        JTextField activite5pres = new JTextField();
        activite5pres.setColumns(25);
        activite5pres.setBounds(650, 400, 300, 30);
        panel.add(activite5pres);
        activite5pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite5pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });


        JLabel titreActivite6 = new JLabel("Activité 6 > nom ");
        titreActivite6.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite6.setBounds(50, 450, 130, 30);
        panel.add(titreActivite6);
        JTextField activite6nom = new JTextField();
        activite6nom.setColumns(25);
        activite6nom.setBounds(180, 450, 165, 30);
        panel.add(activite6nom);
        activite6nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite6nom.getText());
            }
        });

        JLabel titreActivite6Type = new JLabel("type ");
        titreActivite6Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite6Type.setBounds(350, 450, 40, 30);
        panel.add(titreActivite6Type);
        JTextField activite6Type = new JTextField();
        activite6Type.setColumns(25);
        activite6Type.setBounds(390, 450, 145, 30);
        panel.add(activite6Type);
        activite6Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite6Type.getText());
            }
        });

        JLabel titreActivite6pres = new JLabel("présentation ");
        titreActivite6pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite6pres.setBounds(540, 450, 110, 30);
        panel.add(titreActivite6pres);
        JTextField activite6pres = new JTextField();
        activite6pres.setColumns(25);
        activite6pres.setBounds(650, 450, 300, 30);
        panel.add(activite6pres);
        activite6pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite6pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });


        JLabel titreActivite7 = new JLabel("Activité 7 > nom ");
        titreActivite7.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite7.setBounds(50, 500, 130, 30);
        panel.add(titreActivite7);
        JTextField activite7nom = new JTextField();
        activite7nom.setColumns(25);
        activite7nom.setBounds(180, 500, 165, 30);
        panel.add(activite7nom);
        activite7nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite7nom.getText());
            }
        });

        JLabel titreActivite7Type = new JLabel("type ");
        titreActivite7Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite7Type.setBounds(350, 500, 40, 30);
        panel.add(titreActivite7Type);
        JTextField activite7Type = new JTextField();
        activite7Type.setColumns(25);
        activite7Type.setBounds(390, 500, 145, 30);
        panel.add(activite7Type);
        activite7Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite7Type.getText());
            }
        });

        JLabel titreActivite7pres = new JLabel("présentation ");
        titreActivite7pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite7pres.setBounds(540, 500, 110, 30);
        panel.add(titreActivite7pres);
        JTextField activite7pres = new JTextField();
        activite7pres.setColumns(25);
        activite7pres.setBounds(650, 500, 300, 30);
        panel.add(activite7pres);
        activite7pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite7pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });


        JLabel titreActivite8 = new JLabel("Activité 8 > nom ");
        titreActivite8.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite8.setBounds(50, 550, 130, 30);
        panel.add(titreActivite8);
        JTextField activite8nom = new JTextField();
        activite8nom.setColumns(25);
        activite8nom.setBounds(180, 550, 165, 30);
        panel.add(activite8nom);
        activite8nom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setNomActivite(activite8nom.getText());
            }
        });

        JLabel titreActivite8Type = new JLabel("type ");
        titreActivite8Type.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite8Type.setBounds(350, 550, 40, 30);
        panel.add(titreActivite8Type);
        JTextField activite8Type = new JTextField();
        activite8Type.setColumns(25);
        activite8Type.setBounds(390, 550, 145, 30);
        panel.add(activite8Type);
        activite8Type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setTypeActivite(activite8Type.getText());
            }
        });

        JLabel titreActivite8pres = new JLabel("présentation ");
        titreActivite8pres.setFont(new Font("Cooper Black", Font.TRUETYPE_FONT, 15));
        titreActivite8pres.setBounds(540, 550, 110, 30);
        panel.add(titreActivite8pres);
        JTextField activite8pres = new JTextField();
        activite8pres.setColumns(25);
        activite8pres.setBounds(650, 550, 300, 30);
        panel.add(activite8pres);
        activite1pres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActiviteAjoute().setPresentationActivite(activite8pres.getText());
                Activite activite1 = new Activite();
                activite1=getActiviteAjoute();
                activiteEnregistree.add(activite1);
            }
        });
    }
}
