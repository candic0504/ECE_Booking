package fr.java.controleur.Recherche;

import java.util.ArrayList;
import java.util.Scanner;

public class Employe extends Utilisateur {

    /** CONSTRUCTEURS */
    public Employe(String nom, String prenom, String id, String mdp){
        super(nom, prenom, id, mdp);
    }

    public Employe()
    {
        super();
    }

    /**METHODES*/

    //Permet à l'employé de se connecter
    public boolean seConnecter(ArrayList<Employe> listeDeTousLesEmployes)
    {
        boolean trouve = false;

        int positionListeTrouvee = existe(listeDeTousLesEmployes, getId(), getMdp());

        if(positionListeTrouvee != -1)
        {
            setPrenom(listeDeTousLesEmployes.get(positionListeTrouvee).getPrenom());
            setNom(listeDeTousLesEmployes.get(positionListeTrouvee).getNom());
            trouve = true;
        }
        else {
            System.out.println("Cet employé n'existe pas.");
        }

        return trouve;
    }
    //Permet de vérifier si l'employé existe
    public int existe(ArrayList<Employe> listeEmploye, String id, String mdp)
    {
        int positionTrouve = -1;
        int parcours = 0;

        while(positionTrouve == -1 && parcours < listeEmploye.size())
        {
            if(listeEmploye.get(parcours).getId().equals(id) && listeEmploye.get(parcours).getMdp().equals(mdp))
            {
                positionTrouve = parcours;
            }
            else
            {
                parcours++;
            }
        }

        return positionTrouve;
    }

}
