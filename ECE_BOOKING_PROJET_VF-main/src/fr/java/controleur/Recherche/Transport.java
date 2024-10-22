package fr.java.controleur.Recherche;

import java.util.*;

public class Transport
{
    /**ATTRIBUTS*/
    private String nomTransport; /**RER A, Ligne 3...*/
    private String typeDeTransport; /**Metro, RER, Tramway, BUS*/
    private TreeMap<Integer, String> trajetDuTransport; /**(ordre de la station, nom de la station)*/

    /**CONSTRUCTEURS*/
    public Transport(String nom, String type, TreeMap<Integer, String> trajet)
    {
        this.nomTransport = nom;
        this.typeDeTransport = type;
        this.trajetDuTransport = trajet;
    }

    public Transport(){
        trajetDuTransport = new TreeMap<>();
    }

    /**ACCESSEURS*/
    public String getNomTransport() {
        return nomTransport;
    }

    public void setNomTransport(String nomTransport) {
        this.nomTransport = nomTransport;
    }

    public String getTypeDeTransport() {
        return typeDeTransport;
    }

    public void setTypeDeTransport(String typeDeTransport) {
        this.typeDeTransport = typeDeTransport;
    }

    public TreeMap<Integer, String> getTrajetDuTransport() {
        return trajetDuTransport;
    }

    public void setTrajetDuTransport(TreeMap<Integer, String> nouveauTrajetDuTransport) {
        this.trajetDuTransport = nouveauTrajetDuTransport;
    }

    public void affichageTransport()
    {
        System.out.println("Transport : " + this.nomTransport + "|" + this.typeDeTransport + "|");
        for (Map.Entry<Integer, String> entry : this.trajetDuTransport.entrySet())
        {
            System.out.println("Station " + entry.getKey() + " : " + entry.getValue());
        }
    }
    public String toString()
    {
        String res = "Transport : " + this.nomTransport + " (" + this.typeDeTransport + ") \n";
        for (Map.Entry<Integer, String> entry : this.trajetDuTransport.entrySet())
        {
            res += "Station " + entry.getKey() + " : " + entry.getValue() + "\n";
        }
        return res;
    }

    /*--------------------------------------------------------------------*/
    /*--------------------------------------------------------------------*/
    public ArrayList<String> getArrets()
    {
        ArrayList<String> arrets = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : this.trajetDuTransport.entrySet())
        {
            arrets.add(entry.getValue());
        }
        return arrets;
    }
    /*--------------------------------------------------------------------*/
    /*--------------------------------------------------------------------*/

    /**METHODES*/
    public void modifierTransport()
    {
        Scanner recup = new Scanner(System.in);

        System.out.print("Saisissez le nom du transport : ");
        setNomTransport(recup.nextLine());
        recup.nextLine();

        System.out.println("Quel est le type du transport : \n 1: Metro\n 2: RER\n 3: Tramway\n 4: Bus");
        switch (recup.nextInt())
        {
            case 1: setTypeDeTransport("Metro");
                break;
            case 2: setTypeDeTransport("RER");
                break;
            case 3: setTypeDeTransport("Tramway");
                break;
            case 4: setTypeDeTransport("Bus");
                break;
        }

        System.out.println("Saisissez les sations desservient par le " + getTypeDeTransport() + " (Saisissez STOP pour arreter) : ");
        String stationRecup = new String();
        int numeroStation = 1;
        TreeMap<Integer, String> nouveauTrajet = new TreeMap<>();
        while (!stationRecup.equals("STOP"))
        {
            stationRecup = recup.nextLine();
            recup.nextLine();

            if(!stationRecup.equals("STOP"))
            {
                nouveauTrajet.put(numeroStation, stationRecup);
                numeroStation++;
            }
        }
        setTrajetDuTransport(nouveauTrajet);
    }
}
