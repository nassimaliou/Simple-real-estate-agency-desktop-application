package kernel;
public class Proprietaire
{
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String adresse;


    public Proprietaire(String nom, String prenom, String mail, String telephone, String adr) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adr;
    }

    public String getAdresse(){return adresse;}
    public String getMail(){return mail;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public String getTelephone(){return telephone;}
    public void setAdresse(String adresse){this.adresse = adresse;}
    public void setMail(String mail){this.mail = mail;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setTelephone(String telephone){this.telephone = telephone;}

    public void afficher_coord()
    {
        System.out.println("\t --> " +this.nom+".");
        System.out.println("\t --> " +this.prenom+".");
        System.out.println("\t --> " +this.telephone+".");
        System.out.println("\t --> " +this.adresse+".");
        System.out.println("\t --> " +this.mail+".");
    }
    public String show_prop()
    {
        return (this.nom+"   "+this.prenom+"   "+this.adresse+"   "+this.mail);
    }
}