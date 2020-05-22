package kernel;
import java.util.*;
public abstract class Bien implements Comparable
{
    protected String adresse;
    protected long superficie;
    protected long prix;
    protected Proprietaire proprietaire;
    protected Date date_ajout;
    protected Wilaya wilaya;
    protected boolean negociable;
    protected Nature nature;
    protected Type_bien type_bien;
    protected boolean archive = false;
    protected Wilaya wilaya_echange = null;

    public Bien (String adresse , long superficie ,long prix, Proprietaire proprietaire , Date date_ajout , Wilaya wilaya , boolean negociable , Nature nature , Type_bien type_bien)
    {
        this.adresse = adresse;
        this.superficie = superficie;
        this.prix = prix;
        this.proprietaire = proprietaire;
        this.date_ajout = date_ajout;
        this.wilaya = wilaya;
        this.negociable = negociable;
        this.nature = nature;
        this.type_bien = type_bien;
    }

    protected long Calcule_prix_vente ()
    {
        long prix = this.prix;
        if (prix < 5_000_000)
        {
            if (this.wilaya.getPrix_metre_carre() < 50_000)
                prix += this.prix * 0.03;
            else
                prix += this.prix * 0.035;
        }
        else
            {
            if (prix >= 5_000_000 && prix <= 15_000_000) {
                if (this.wilaya.getPrix_metre_carre() < 50_000)
                    prix += this.prix * 0.02;
                else
                    prix += this.prix * 0.025;
            } else if (prix > 15_000_000)
            {
                if (this.wilaya.getPrix_metre_carre() < 70_000)
                    prix += this.prix * 0.01;
                else
                    prix += this.prix * 0.02;
            }
        }
        return prix;
    }


    protected long Calcule_prix_location ()
    {
        long prix = this.prix;
        if (this.superficie < 60)
        {
            if(this.wilaya.getPrix_metre_carre() < 50_000)
            {
                prix += this.prix * 0.01;
            }
            else
            {
                prix += this.prix * 0.015;
            }
        }
        else {
            if (this.superficie >= 60 && this.superficie <= 150) {
                if (this.wilaya.getPrix_metre_carre() < 50_000) {
                    prix += this.prix * 0.02;
                } else {
                    prix += this.prix * 0.025;
                }
            } else if (this.superficie > 150) {
                if (this.wilaya.getPrix_metre_carre() < 50_000) {
                    prix += this.prix * 0.03;
                } else {
                    prix += this.prix * 0.035;
                }
            }
        }
        return prix;
    }

    public long Calcule_prix_echange_finale(int  num_bien_a_echanger)
    {
        long prix = Calcule_prix_vente_finale();
        if (num_bien_a_echanger != this.wilaya.getNum_wilaya())
        {
            prix += this.prix * 0.0025;
        }
        return prix;
    }

    abstract protected long Calcule_prix_vente_finale();
    abstract protected long Calcule_prix_location_finale();

    public void setAdresse(String adresse){this.adresse = adresse;}
    public String getAdresse(){return adresse;}
    public boolean isNegociable(){return negociable;}
    public long getSuperficie(){return superficie;}
    public long getPrix() {return prix;}
    public void setPrix(long prix){this.prix = prix;}
    public Nature getNature(){return nature;}
    public Proprietaire getProprietaire(){return proprietaire;}
    public Date getDate_ajout(){return date_ajout;}
    public Type_bien getType_bien(){return type_bien;}
    public void setDate_ajout(Date date_ajout){this.date_ajout = date_ajout;}
    public void setNature(Nature nature){this.nature = nature;}
    public void setNegociable(boolean negociable){this.negociable = negociable;}
    public void setProprietaire(Proprietaire proprietaire){this.proprietaire = proprietaire;}
    public void setSuperficie(long superficie){this.superficie = superficie;}
    public void setType_bien(Type_bien type_bien){this.type_bien = type_bien;}
    public void setWilaya(Wilaya wilaya){this.wilaya = wilaya;}
    public Wilaya getWilaya(){return wilaya;}
    public boolean isArchive(){return archive;}
    public void setArchive(boolean archive){this.archive = archive;}
    public void setWilaya_echange(Wilaya wilaya_echange) { this.wilaya_echange = wilaya_echange; }
    public Wilaya getWilaya_echange() { return wilaya_echange; }

    public boolean equals (Object o)
    {
        return ( (((Bien)o).type_bien.equals(this.type_bien)) && (((Bien)o).adresse.equals(this.adresse)) && (((Bien)o).wilaya.equals(this.wilaya)) );
    }

    public int compareTo (Object o)
    {
        return ( ((Bien)o).date_ajout.compareTo(this.date_ajout) );
    }

    public void visualisation()
    {
        System.out.print(this.type_bien+" , ");
        System.out.print(this.adresse+" , ");
        System.out.print("Wilaya numero "+this.wilaya.getNum_wilaya()+" , ");
        System.out.print(this.prix+" DA .\n");
        System.out.println("*****************************************");
        System.out.print("\n");
    }
    public abstract void visualisation_detail();
    public void archiver_bien()
    {
        this.archive = true;
    }


    public String show_bien ()
    {
        return (this.type_bien.toString()+"       "+this.adresse+"       "+"Wilaya numero : "+wilaya.getNum_wilaya()+"       "+this.Calcule_prix_vente_finale()+" DA");
    }
}