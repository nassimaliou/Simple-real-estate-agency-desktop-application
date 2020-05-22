package kernel;
import sample.Exeption_superficie;

import java.util.Date;
public class Maison extends Habitable {
    private int nb_etages;
    private boolean garage;
    private boolean jardin;
    private boolean picine;
    private long superficie_habitable;

    public Maison(int nb_etages, boolean garage, boolean jardin, boolean picine, long superficie_habitable, int nb_pieces, boolean meublees, String adresse, long superficie,long prix, Proprietaire proprietaire, Date date_ajout, Wilaya wilaya, boolean negociable, Nature nature, Type_bien type_bien) throws Exeption_superficie {
        super(nb_pieces, meublees, adresse, superficie,prix, proprietaire, date_ajout, wilaya, negociable, nature, type_bien);
        this.nb_etages = nb_etages;
        this.garage = garage;
        this.jardin = jardin;
        this.picine = picine;
        this.superficie_habitable = superficie_habitable;
        if(superficie_habitable>superficie) throw new Exeption_superficie();
    }

    public long Calcule_prix_vente_finale() {
        long prix = Calcule_prix_vente();
        if (garage || jardin || picine) {
            prix += this.prix * 0.005;
        }
        return prix;
    }

    public long Calcule_prix_location_finale() {
        long prix = Calcule_prix_location();
        if (picine) {
            prix += 50_000;
        }
        return prix;
    }

    public int getNb_etages() {
        return nb_etages;
    }

    public void setNb_etages(int nb_etages) {
        this.nb_etages = nb_etages;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isJardin() {return jardin;}

    public boolean isPicine() {
        return picine;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public void setPicine(boolean picine) {
        this.picine = picine;
    }

    public void setSuperficie_habitable(long surface_habitable) {
        this.superficie_habitable = surface_habitable;
    }

    public long getSuperficie_habitable() {
        return superficie_habitable;
    }

    public void visualisation_detail()
    {
        System.out.println("*****************************************");
        System.out.println("Type de bien : "+this.type_bien+", ");
        System.out.println("Adresse : "+this.adresse+", ");
        System.out.println("Wilaya numero : "+this.wilaya.getNum_wilaya()+", ");
        System.out.println("Date : "+this.date_ajout+", ");
        System.out.println("Negociable : "+this.negociable+", ");
        System.out.println("Superficie : "+this.superficie+" m², ");
        System.out.println("Nature de transaction : "+this.nature+", ");
        System.out.println("Proprietaire : ");
        this.proprietaire.afficher_coord();
        System.out.println("Garage : "+this.garage+", ");
        System.out.println("Jardin : "+this.jardin+", ");
        System.out.println("Nombre d'etages : "+this.nb_etages+", ");
        System.out.println("Picine : "+this.picine+", ");
        System.out.println("Superficie habitable : "+this.superficie_habitable+" m². ");
        System.out.println("*****************************************");
    }
}