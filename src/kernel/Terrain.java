package kernel;
import java.util.Date;
public class Terrain extends Bien
{
    private Statut_juridique statut_juridique;
    private int nb_facades;

    public Terrain (Statut_juridique statut_juridique , int nb_facades , String adresse , long superficie ,long prix, Proprietaire proprietaire , Date date_ajout , Wilaya wilaya , boolean negociable , Nature nature , Type_bien type_bien)
    {
        super(adresse,superficie,prix,proprietaire,date_ajout,wilaya,negociable,nature,type_bien);
        this.statut_juridique = statut_juridique;
        this.nb_facades = nb_facades;
    }

    public long Calcule_prix_location_finale()
    {
        return Calcule_prix_location();
    }
    public int getNb_facades(){return nb_facades;}
    public void setNb_facades(int nb_facades){this.nb_facades = nb_facades;}
    public Statut_juridique getStatu_juridique(){return statut_juridique;}
    public void setStatu_juridique(Statut_juridique statut_juridique){this.statut_juridique = statut_juridique;}
    public long Calcule_prix_vente_finale()
    {
        long prix = Calcule_prix_vente();
        if (nb_facades > 1)
        {
            prix += this.prix * 0.005 * nb_facades;
        }
        return prix;
    }
    public void visualisation_detail()
    {
        System.out.println("*****************************************");
        System.out.println("Type de bien : "+this.type_bien+", ");
        System.out.println("Adresse : "+this.adresse+", ");
        System.out.println("Wilaya numero : "+this.wilaya.getNum_wilaya()+", ");
        System.out.println("Date : "+this.date_ajout+", ");
        System.out.println("Negociable : "+this.negociable+", ");
        System.out.println("Superficie : "+this.superficie+"m², ");
        System.out.println("Nature de transaction : "+this.nature+" ,");
        System.out.println("Proprietaire : ");
        this.proprietaire.afficher_coord();
        System.out.println("Nombre de facades : "+this.nb_facades+" ,");
        System.out.println("Statut juridique : "+this.statut_juridique+".");
        System.out.println("*****************************************");
    }
}