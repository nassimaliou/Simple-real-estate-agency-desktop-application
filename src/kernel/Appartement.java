package kernel;
import java.util.Date;

public class Appartement extends Habitable
{
    private int etage;
    private String type;
    private boolean ascenseur;


    public Appartement (int etage , String type , boolean ascenseur , int nb_pieces , boolean meublees , String adresse , long superficie,long prix , Proprietaire proprietaire , Date date_ajout , Wilaya wilaya , boolean negociable , Nature nature , Type_bien type_bien)
    {
        super(nb_pieces,meublees,adresse,superficie,prix,proprietaire,date_ajout,wilaya,negociable,nature,type_bien);
        this.etage = etage;
        this.type = type;
        this.ascenseur = ascenseur;
    }
    public long Calcule_prix_vente_finale()
    {
        long prix = Calcule_prix_vente();
        if (this.etage >= 0 && this.etage <= 2)
        {
            prix += 50_000;
        }
        return prix;
    }
    public long Calcule_prix_location_finale()
    {
        long prix = Calcule_prix_location();
        if (etage >= 0 && etage <= 2)
        {
            prix += 5_000;
        }
        if (!this.getAscenseur() && etage >= 6)
        {
            prix -= this.getSuperficie() * 500;
        }
        return prix;
    }
    public int getetage(){return etage;}
    public String getType(){return type;}
    public void setetage(int etage){this.etage = etage;}
    public void setType(String type){this.type = type;}
    public void setAscenseur(boolean ascenseur) {this.ascenseur = ascenseur; }
    public boolean getAscenseur(){return this.ascenseur;}

    public void visualisation_detail()
    {
        System.out.println("*****************************************");
        System.out.println("Type du bien : "+this.type_bien+", ");
        System.out.println("Adresse du bien : "+this.adresse+", ");
        System.out.println("Wilaya : "+this.wilaya.getNum_wilaya()+", ");
        System.out.println("Date : "+this.date_ajout+", ");
        System.out.println("Negociable : "+this.negociable+", ");
        System.out.println("Superficie : "+this.superficie+"m², ");
        System.out.println("Nature de transaction : "+this.nature+", ");
        System.out.println("Proprietaire : ");
        this.proprietaire.afficher_coord();
        System.out.println("Ascenseur : "+this.ascenseur+", ");
        System.out.println("Etage : "+this.etage+", ");
        System.out.println("Type d'appartement : "+this.type+" . ");
        System.out.println("*****************************************");
    }
}