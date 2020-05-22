package kernel;
import java.util.Date;
abstract class Habitable extends Bien
{
    protected int nb_pieces;
    protected boolean meublees;

    public Habitable (int nb_pieces , boolean meublees , String adresse , long superficie,long prix , Proprietaire proprietaire , Date date_ajout , Wilaya wilaya , boolean negociable , Nature nature , Type_bien type_bien)
    {
        super(adresse,superficie,prix,proprietaire,date_ajout,wilaya,negociable,nature,type_bien);
        this.nb_pieces = nb_pieces;
        this.meublees = meublees;
    }
    public int getNb_pieces(){return nb_pieces;}
    public boolean isMeublees(){return meublees;}
    public void setMeublees(boolean meublees){this.meublees = meublees;}
    public void setNb_pieces(int nb_pieces){this.nb_pieces = nb_pieces;}
}