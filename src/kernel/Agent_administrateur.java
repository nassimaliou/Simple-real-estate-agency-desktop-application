package kernel;
import sample.Exeption_superficie;

import java.util.*;

public class Agent_administrateur extends Client
{
    public static void ajout ()
    {
        Scanner var = new Scanner(System.in);
        String adresse;
        long superficie;
        long prix;
        Proprietaire proprietaire;
            String nom;
            String prenom;
            String mail;
            String telephone;
            String adr;
        Date date_ajout;
        Wilaya wilaya;
            int num_wilaya;
        boolean negociable;
        Nature nature = null;
        int choix_nature;
        Type_bien type_bien;
        int nb_pieces;
        boolean meublees;
        Statut_juridique statut_juridique = null;
        int nb_facades;
        int nb_etages;
        boolean garage;
        boolean jardin;
        boolean picine;
        long superficie_habitable;
        int etage;
        String type = null;
        boolean ascenseur;
        int choix = 0;
        boolean bool=true;

        while (bool)
        {
            try
            {
                bool=false;
                var = new Scanner(System.in);
                System.out.println("Quel type de bien voulez vous inserer : ");
                System.out.println("1 ) Maison ");
                System.out.println("2 ) Appartement ");
                System.out.println("3 ) Terrain ");
                System.out.print("\n --- > ");
                choix = var.nextInt();
            switch (choix)
            {
                case 1 :
                    {
                        System.out.println("Combien d'étages a la maison a : ");
                        nb_etages=var.nextInt();
                        System.out.println("Est-ce que la maison a un garage ? : ");
                        garage=var.nextBoolean();
                        System.out.println("Est-ce que la maison a un jardin ? : ");
                        jardin=var.nextBoolean();
                        System.out.println("Est-ce que la maison a une piscine ? : ");
                        picine=var.nextBoolean();
                        System.out.println("Quelle est la superficie de la maison: ");
                        superficie = var.nextLong();
                        while (true)
                        {
                            System.out.println("Quelle est la superficie habitable de la maison : ");
                            superficie_habitable = var.nextLong();
                            if (superficie_habitable > superficie)
                                System.out.println("La superficie habitable de la maison est superieure a la superficie de cette derniere, valeure incorrecte !!!");
                            else
                                break;
                        }
                        System.out.println("Quelle est la nature de transaction de cette maison :");
                        System.out.println("1 ) Vente.");
                        System.out.println("2 ) Location.");
                        System.out.println("3 ) Echange.");
                        System.out.print("---> ");
                        choix_nature = var.nextInt();
                        switch (choix_nature)
                        {
                            case 1:{nature = Nature.Vente;}break;
                            case 2:{nature = Nature.Location;}break;
                            case 3:{nature = Nature.Echange;}break;
                            default:{}break;
                        }
                        System.out.println("Quel est le prix de la maison : ");
                        prix=var.nextLong();
                        System.out.println("Quel est le nombre de pieces de la maison");
                        nb_pieces=var.nextInt();
                        System.out.println("Est-ce que la maison est meublée ? : ");
                        meublees=var.nextBoolean();
                        System.out.println("Quelle est l'adresse de la maison");
                        adresse=var.next();
                        System.out.println("Inserez les coordonnes du proprietaire de la maison: ");
                            System.out.print("\t Inserez le nom\n");
                            nom=var.next();
                            System.out.print("\t Inserez le prenom\n");
                            prenom=var.next();
                            System.out.print("\t Inserez le mail\n");
                            mail=var.next();
                            System.out.print("\t Inserez le numero de telephone\n");
                            telephone=var.next();
                            System.out.print("\t Inserez l'adresse\n");
                            adr=var.next();
                        proprietaire=new Proprietaire(nom,prenom,mail,telephone,adr);
                        date_ajout = new Date();
                        while (true) {
                            System.out.println("Inserez la wilaya ou se situe la maison :");
                            num_wilaya = var.nextInt();
                            if (num_wilaya > Wilaya.getTab().length)
                                System.out.println("Ce numero de wilaya n'existe pas !!");
                            else {
                                wilaya = new Wilaya(num_wilaya);
                                break;
                            }
                        }
                        System.out.println("Est ce que le prix de la maison est negociable :");
                        negociable=var.nextBoolean();
                        Maison maison = new Maison(nb_etages,garage,jardin,picine,superficie_habitable,nb_pieces,meublees,adresse,superficie,prix,proprietaire,date_ajout,wilaya,negociable,nature,Type_bien.Maison);
                        boolean aj = false;
                        Iterator<Bien> It = Liste_Bien.iterator();
                        while(It.hasNext())
                        {
                            if (It.next().getWilaya().getNum_wilaya() == maison.getWilaya().getNum_wilaya() || It.next().getAdresse().equals(maison.adresse) || It.next().getType_bien().equals(maison.type_bien))
                            {
                                aj = true;
                                break;
                            }
                        }
                        if (!aj)
                        {
                            Client.Liste_Bien.add(maison);
                            Client.inc_nb_bien();
                        }
                        else
                            System.out.println("Ce bien est déja dans la base de donnée");

                    }
                    break;
                case 2 :
                    {
                        System.out.println("A quelle etage est l'appartement : ");
                        etage=var.nextInt();
                        System.out.println("Quel est le nombre de pieces de l'appartement");
                        nb_pieces=var.nextInt();
                        while (true)
                        {
                            System.out.println("Quel est le type de votre appartement ? ");
                            System.out.println("1) Simplexe.");
                            System.out.println("2) Duplexe.");
                            System.out.println("3) Studio.");
                            int choice;
                            choice = var.nextInt();
                            switch (choice)
                            {
                                case 1: { type = "simplexe";}break;
                                case 2: { type = "duplexe";}break;
                                case 3: { type = "studio"; }break;
                                default: {}break;
                            }
                            if ((nb_pieces == 0 && type.equals("studio")) || (nb_pieces == 1 && type.equals("simplexe")) || (nb_pieces > 1 && ( type.equals("simplexe") || type.equals("duplexe"))))
                                break;
                            else
                                System.out.println("Le nombre de pieces :"+ nb_pieces+", est non-coherant avec le type :"+type+" !!!!");
                        }
                        System.out.println("Est-ce que l'apprtement a un ascenseur : ");
                        ascenseur=var.nextBoolean();
                        System.out.println("Est-ce que l'appartement est meublée ? : ");
                        meublees=var.nextBoolean();
                        System.out.println("Quelle est l'adresse de l'appartement :");
                        adresse=var.next();
                        System.out.println("Quelle est la superficie de l'appartement :");
                        superficie=var.nextLong();
                        System.out.println("Quelle est la nature de transaction de cette maison :");
                        System.out.println("1 ) Vente.");
                        System.out.println("2 ) Location.");
                        System.out.println("3 ) Echange.");
                        System.out.print("---> ");
                        choix_nature = var.nextInt();
                        switch (choix_nature)
                        {
                            case 1:{nature = Nature.Vente;}break;
                            case 2:{nature = Nature.Location;}break;
                            case 3:{nature = Nature.Echange;}break;
                            default:{}break;
                        }
                        System.out.println("Quel est le prix de l'appartement : ");
                        prix=var.nextLong();
                        System.out.println("Inserez les coordonnes du proprietaire de la maison: ");
                            System.out.print("\t Inserez le nom\n");
                            nom=var.next();
                            System.out.print("\t Inserez le prenom\n");
                            prenom=var.next();
                            System.out.print("\t Inserez le mail\n");
                            mail=var.next();
                            System.out.print("\t Inserez le numero de telephone\n");
                            telephone=var.next();
                            System.out.print("\t Inserez l'adresse\n");
                            adr=var.next();
                        proprietaire=new Proprietaire(nom,prenom,mail,telephone,adr);
                        date_ajout = new Date();
                        System.out.println("Inserez la wilaya ou se situe l'appartement :");
                            num_wilaya=var.nextInt();
                        wilaya=new Wilaya(num_wilaya);
                        System.out.println("Est ce que le prix de l'appartement est negociable :");
                        negociable=var.nextBoolean();
                        Appartement appartement = new Appartement(etage,type,ascenseur,nb_pieces,meublees,adresse,superficie,prix,proprietaire,date_ajout,wilaya,negociable,nature,Type_bien.Appartement);
                        boolean aj = false;
                        Iterator<Bien> It = Liste_Bien.iterator();
                        while(It.hasNext())
                        {
                            if (It.next().getWilaya().getNum_wilaya() == appartement.getWilaya().getNum_wilaya() || It.next().getAdresse().equals(appartement.adresse) || It.next().getType_bien().equals(appartement.type_bien))
                            {
                                aj = true;
                                break;
                            }
                        }
                        if (!aj)
                        {
                            Client.Liste_Bien.add(appartement);
                            Client.inc_nb_bien();
                        }
                        else
                            System.out.println("Ce bien est déja dans la base de donnée");
                    }
                    break;
                case 3 :
                    {
                        System.out.println("Quel est le statut juridique du terrain :");
                        System.out.println("1 ) Papier timbré.");
                        System.out.println("2 ) Autre.");
                        System.out.print("---> ");
                        int choix_statut = var.nextInt();
                        if(choix_statut == 1)
                            statut_juridique = Statut_juridique.Papier_timbré;
                        else
                        {
                            if (choix_statut == 2)
                                statut_juridique = Statut_juridique.autre;
                        }
                        System.out.println("Quel est le nombre de facades du terrain ? :");
                        nb_facades = var.nextInt();
                        System.out.println("Quelle est l'adresse du terrain :");
                        adresse=var.next();
                        System.out.println("Quelle est la superficie du terrain :");
                        superficie=var.nextLong();
                        System.out.println("Quelle est la nature de transaction de ce terrain :");
                        System.out.println("1 ) Vente.");
                        System.out.println("2 ) Location.");
                        System.out.println("3 ) Echange.");
                        System.out.print("---> ");
                        choix_nature = var.nextInt();
                        switch (choix_nature)
                        {
                            case 1:{nature = Nature.Vente;}break;
                            case 2:{nature = Nature.Location;}break;
                            case 3:{nature = Nature.Echange;}break;
                            default:{}break;
                        }
                        System.out.println("Quel est le prix de la terrain : ");
                        prix=var.nextLong();
                        System.out.println("Inserez les coordonnes du proprietaire du terrain ");
                            System.out.print("\t Inserez le nom\n");
                            nom=var.next();
                            System.out.print("\t Inserez le prenom\n");
                            prenom=var.next();
                            System.out.print("\t Inserez le mail\n");
                            mail=var.next();
                            System.out.print("\t Inserez le numero de telephone\n");
                            telephone=var.next();
                            System.out.print("\t Inserez l'adresse\n");
                            adr=var.next();
                        proprietaire=new Proprietaire(nom,prenom,mail,telephone,adr);
                        System.out.println("Inserez la date :");
                        date_ajout = new Date();
                        System.out.println("Inserez la wilaya ou se situe le terrain :");
                            num_wilaya=var.nextInt();
                        wilaya=new Wilaya(num_wilaya);
                        System.out.println("Est ce que le prix du terrain est negociable :");
                        negociable=var.nextBoolean();
                        Terrain terrain = new Terrain(statut_juridique,nb_facades,adresse,superficie,prix,proprietaire,date_ajout,wilaya,negociable,nature,Type_bien.Terrain);
                        boolean aj = false;
                        Iterator<Bien> It = Liste_Bien.iterator();
                        while(It.hasNext())
                        {
                            if (It.next().getWilaya().getNum_wilaya() == terrain.getWilaya().getNum_wilaya() || It.next().getAdresse().equals(terrain.adresse) || It.next().getType_bien().equals(terrain.type_bien))
                            {
                                aj = true;
                                break;
                            }
                        }
                        if (!aj)
                        {
                            Client.Liste_Bien.add(terrain);
                            Client.inc_nb_bien();
                        }
                        else
                            System.out.println("Ce bien est déja dans la base de donnée");

                    }
                break;
                default:
                    {
                        System.out.println("Choix invalide !!!!");
                        bool =true;
                    }
                    break;
            }
        }
        catch (InputMismatchException | Exeption_superficie e)
        {
            System.out.println("Entrez un choix valide !!");
            bool=true;
        }
        }
    }
    public static void supprimer()
    {
        int n_wilaya = 0;
        String adr = null;
        Scanner var = new Scanner(System.in);
        System.out.println("Quel Bien voulez vous supprimer ?");
        System.out.println("Entrez le type de Bien :");
        Type_bien t_Bien = null;
        int type=0;
        boolean bool=true;
        while (bool)
        {
            try
            {
                bool=false;
                var = new Scanner(System.in);
                System.out.println("Quel type de bien voulez vous supprimer : ");
                System.out.println("1 ) Maison ");
                System.out.println("2 ) Appartement ");
                System.out.println("3 ) Terrain ");
                System.out.print("\n --- > ");
                type = var.nextInt();
                switch (type)
                {
                    case 1:{t_Bien = Type_bien.Maison;}break;
                    case 2:{t_Bien = Type_bien.Appartement;}break;
                    case 3:{t_Bien = Type_bien.Terrain;}break;
                    default:{System.out.println("Entrez un choix valide !!");}break;
                }
        System.out.println("Entrez l'adresse du Bien");
        adr = var.next();
        System.out.println("Entrez la wilaya ou se situe le Bien :");
        n_wilaya = var.nextInt();
        }
            catch (java.util.InputMismatchException e)
        {
            System.out.println("Entrez un choix valide !!");
            bool=true;
        }
        }

        Iterator<Bien> Iter = Liste_Bien.iterator();
        while(Iter.hasNext())
        {
            Bien b = Iter.next();

            if((b.getType_bien() == t_Bien) && (b.getAdresse().equals(adr)) && (b.getWilaya().getNum_wilaya() == n_wilaya))
            {
                Liste_Bien.remove(b);
                break;
            }
        }
    }

    public static void modification()
    {
        Scanner var = new Scanner(System.in);
        String adresse;
        long superficie;
        long prix;
        Proprietaire proprietaire;
        String nom;
        String prenom;
        String mail;
        String telephone;
        String adr;
        String date_ajout;
        Wilaya wilaya;
        int num_wilaya;
        boolean negociable;
        Nature nature = null;
        int choix_nature;
        Type_bien type_bien;
        int nb_pieces ;
        boolean meublees;
        Statut_juridique statut_juridique = null;
        int nb_facades;
        int nb_etages;
        boolean garage;
        boolean jardin;
        boolean picine;
        long superficie_habitable;
        int etage;
        String type;
        boolean ascenseur;

        System.out.println("Quel Bien voulez vous modifier ?");
        System.out.println("Entrez la type de Bien :");
        Type_bien t_Bien = null;
        boolean bool=true;
        boolean boool=true;
        int type_b = 0;
        while (bool) {
            try {
                bool=false;
                var = new Scanner(System.in);
                System.out.println("Quel type de bien voulez vous modifier : ");
                System.out.println("1 ) Maison ");
                System.out.println("2 ) Appartement ");
                System.out.println("3 ) Terrain ");
                System.out.print("\n --- > ");
                type_b = var.nextInt();

                while (boool){
                boool=false;
                switch (type_b) {
                    case 1: {
                        t_Bien = Type_bien.Maison;
                    }
                    break;
                    case 2: {
                        t_Bien = Type_bien.Appartement;
                    }
                    break;
                    case 3: {
                        t_Bien = Type_bien.Terrain;
                    }
                    break;
                    default: {
                        System.out.println("Entrez un choix valide !!");
                        bool = true;
                    }
                    break;
                }}
                System.out.println("Entrez l'adresse du Bien");
                adr = var.next();
                System.out.println("Entrez la wilaya ou se situe le Bien :");
                int n_wilaya = var.nextInt();

                Iterator<Bien> Iter = Liste_Bien.iterator();
                Boolean continuer = true;
                int choice;
                while (Iter.hasNext()) {
                    Bien b = Iter.next();
                    if ((b.getType_bien().equals(t_Bien)) && (b.getAdresse().equals(adr)) && (b.getWilaya().getNum_wilaya() == n_wilaya)) {
                        switch (type_b) {
                            case 1: {
                                Maison m = (Maison) b;
                                Liste_Bien.remove(b);
                                while (continuer) {
                                    System.out.println("Quelle partie voulez vous modifier ?");
                                    System.out.println("1)adresse \n2)superficie \n3)proprietaire \n4)wilaya \n5)negociabilitée \n6)nature de la transaction  \n7)nombre de pieces \n8)meublé \n9)nombre d'etages \n10)garage \n11)jardin \n12)piscine \n13)superficie_habitable \n14)prix");
                                    choice = var.nextInt();
                                    switch (choice) {
                                        case 1: {
                                            System.out.println("Quelle est l'adresse de la maison");
                                            adresse = var.next();
                                            m.setAdresse(adresse);
                                        }
                                        break;
                                        case 2: {
                                            System.out.println("Quelle est la superficie de la maison: ");
                                            superficie = var.nextLong();
                                            m.setSuperficie(superficie);
                                        }
                                        break;
                                        case 3: {
                                            System.out.println("Inserez les coordonnes du proprietaire de la maison: ");
                                            System.out.print("\t Inserez le nom\n");
                                            nom = var.next();
                                            System.out.print("\t Inserez le prenom\n");
                                            prenom = var.next();
                                            System.out.print("\t Inserez le mail\n");
                                            mail = var.next();
                                            System.out.print("\t Inserez le numero de telephone\n");
                                            telephone = var.next();
                                            System.out.print("\t Inserez l'adresse\n");
                                            adr = var.next();
                                            proprietaire = new Proprietaire(nom, prenom, mail, telephone, adr);
                                            m.setProprietaire(proprietaire);
                                        }
                                        break;
                                        case 4: {
                                            System.out.println("Inserez la wilaya ou se situe la maison :");
                                            num_wilaya = var.nextInt();
                                            wilaya = new Wilaya(num_wilaya);
                                            m.setWilaya(wilaya);
                                        }
                                        break;
                                        case 5: {
                                            System.out.println("Est ce que le prix de la maison est negociable :");
                                            negociable = var.nextBoolean();
                                            m.setNegociable(negociable);
                                        }
                                        break;
                                        case 6: {
                                            System.out.println("Quelle est la nature de transaction de cette maison :");
                                            System.out.println("1 ) Vente.");
                                            System.out.println("2 ) Location.");
                                            System.out.println("3 ) Echange.");
                                            System.out.print("---> ");
                                            choix_nature = var.nextInt();
                                            switch (choix_nature) {
                                                case 1: {
                                                    nature = Nature.Vente;
                                                }
                                                break;
                                                case 2: {
                                                    nature = Nature.Location;
                                                }
                                                break;
                                                case 3: {
                                                    nature = Nature.Echange;
                                                }
                                                break;
                                                default: {
                                                }
                                                break;
                                            }
                                            m.setNature(nature);
                                        }
                                        break;
                                        case 7: {
                                            System.out.println("Quel est le nombre de pieces de la maison");
                                            nb_pieces = var.nextInt();
                                            m.setNb_pieces(nb_pieces);

                                        }
                                        break;
                                        case 8: {
                                            System.out.println("Est-ce que la maison est meublée ? : ");
                                            meublees = var.nextBoolean();
                                            m.setMeublees(meublees);
                                        }
                                        break;
                                        case 9: {
                                            System.out.println("Combien d'étages a la maison a : ");
                                            nb_etages = var.nextInt();
                                            m.setNb_etages(nb_etages);
                                        }
                                        break;
                                        case 10: {
                                            System.out.println("Est-ce que la maison a un garage ? : ");
                                            garage = var.nextBoolean();
                                            m.setGarage(garage);
                                        }
                                        break;
                                        case 11: {
                                            System.out.println("Est-ce que la maison a un jardin ? : ");
                                            jardin = var.nextBoolean();
                                            m.setJardin(jardin);
                                        }
                                        break;
                                        case 12: {
                                            System.out.println("Est-ce que la maison a une piscine ? : ");
                                            picine = var.nextBoolean();
                                            m.setPicine(picine);
                                        }
                                        break;
                                        case 13: {
                                            while (true) {
                                                System.out.println("Quelle est la superficie habitable de la maison : ");
                                                superficie_habitable = var.nextLong();
                                                if (superficie_habitable > m.getSuperficie())
                                                    System.out.println("La superficie habitable de la maison est superieure a la superficie de cette derniere, valeure incorrecte !!!");
                                                else
                                                    break;
                                            }
                                            m.setSuperficie_habitable(superficie_habitable);
                                        }
                                        break;
                                        case 14: {
                                            System.out.println("Quel est le prix de la maison : ");
                                            prix = var.nextLong();
                                            m.setPrix(prix);
                                        }
                                        break;
                                    }
                                    Client.Liste_Bien.add(m);
                                    System.out.print("voulez vous continuer ? :");
                                    continuer = var.nextBoolean();
                                }
                            }
                            break;
                            case 2: {
                                Appartement a = (Appartement) b;
                                Liste_Bien.remove(b);
                                while (continuer) {
                                    System.out.println("Quelle partie voulez vous modifier ?");
                                    System.out.println("1)adresse \n2)superficie \n3)proprietaire \n4)wilaya \n5)negociabilitée \n6)nature de la transaction  \n7)nombre de pieces \n8)meublé \n9)nombre d'etages \n10)garage \n11)jardin \n12)piscine \n13)superficie_habitable \n14)prix");
                                    choice = var.nextInt();
                                    switch (choice) {
                                        case 1: {
                                            System.out.println("Quelle est l'adresse de l'appartement");
                                            adresse = var.next();
                                            a.setAdresse(adresse);
                                        }
                                        break;
                                        case 2: {
                                            System.out.println("Quelle est la superficie de l'appartement: ");
                                            superficie = var.nextLong();
                                            a.setSuperficie(superficie);
                                        }
                                        break;
                                        case 3: {
                                            System.out.println("Inserez les coordonnes du proprietaire de l'appartement: ");
                                            System.out.print("\t Inserez le nom\n");
                                            nom = var.next();
                                            System.out.print("\t Inserez le prenom\n");
                                            prenom = var.next();
                                            System.out.print("\t Inserez le mail\n");
                                            mail = var.next();
                                            System.out.print("\t Inserez le numero de telephone\n");
                                            telephone = var.next();
                                            System.out.print("\t Inserez l'adresse\n");
                                            adr = var.next();
                                            proprietaire = new Proprietaire(nom, prenom, mail, telephone, adr);
                                            a.setProprietaire(proprietaire);
                                        }
                                        break;
                                        case 4: {
                                            System.out.println("Inserez la wilaya ou se situe l'appartement :");
                                            num_wilaya = var.nextInt();
                                            wilaya = new Wilaya(num_wilaya);
                                            a.setWilaya(wilaya);
                                        }
                                        break;
                                        case 5: {
                                            System.out.println("Est ce que le prix de l'appartement est negociable :");
                                            negociable = var.nextBoolean();
                                            a.setNegociable(negociable);
                                        }
                                        break;
                                        case 6: {
                                            System.out.println("Quelle est la nature de transaction de cette appartement :");
                                            System.out.println("1 ) Vente.");
                                            System.out.println("2 ) Location.");
                                            System.out.println("3 ) Echange.");
                                            System.out.print("---> ");
                                            choix_nature = var.nextInt();
                                            switch (choix_nature) {
                                                case 1: {
                                                    nature = Nature.Vente;
                                                }
                                                break;
                                                case 2: {
                                                    nature = Nature.Location;
                                                }
                                                break;
                                                case 3: {
                                                    nature = Nature.Echange;
                                                }
                                                break;
                                                default: {
                                                }
                                                break;
                                            }
                                            a.setNature(nature);
                                        }
                                        break;
                                        case 7: {
                                            System.out.println("Quel est le nombre de pieces de l'appartement");
                                            nb_pieces = var.nextInt();

                                        }
                                        break;
                                        case 8: {
                                            System.out.println("Est-ce que l'appartement est meublée ? : ");
                                            meublees = var.nextBoolean();
                                            a.setMeublees(meublees);
                                        }
                                        break;
                                        case 9: {
                                            System.out.println("A quelle etage est l'appartement : ");
                                            etage = var.nextInt();
                                            a.setetage(etage);
                                        }
                                        break;
                                        case 10: {
                                            System.out.println("Est-ce sue votre appartement est un Simplex ou un Duplex ? ");
                                            type = var.next();
                                            a.setType(type);
                                        }
                                        break;
                                        case 11: {
                                            System.out.println("Est-ce que l'apprtement a un ascenseur : ");
                                            ascenseur = var.nextBoolean();
                                            a.setAscenseur(ascenseur);
                                        }
                                        break;

                                        case 12: {
                                            System.out.println("Quel est le prix de la maison : ");
                                            prix = var.nextLong();
                                            a.setPrix(prix);
                                        }break;
                                        default:{

                                        }break;
                                    }
                                    Client.Liste_Bien.add(a);
                                    System.out.print("voulez vous continuer ? :");
                                    continuer = var.nextBoolean();
                                }
                            }
                            break;
                            case 3: {
                                Terrain t = (Terrain) b;
                                Liste_Bien.remove(b);
                                while (continuer) {
                                    System.out.println("Quelle partie voulez vous modifier ?");
                                    System.out.println("1)adresse \n2)superficie \n3)proprietaire \n4)wilaya \n5)negociabilitée \n6)nature de la transaction  \n7)nombre de pieces \n8)meublé \n9)nombre d'etages \n10)garage \n11)jardin \n12)piscine \n13)superficie_habitable \n14)prix");
                                    choice = var.nextInt();
                                    switch (choice) {
                                        case 1: {
                                            System.out.println("Quelle est l'adresse du terrain");
                                            adresse = var.next();
                                            t.setAdresse(adresse);
                                        }
                                        break;
                                        case 2: {
                                            System.out.println("Quelle est la superficie du terrain: ");
                                            superficie = var.nextLong();
                                            t.setSuperficie(superficie);
                                        }
                                        break;
                                        case 3: {
                                            System.out.println("Inserez les coordonnes du proprietaire du terrain: ");
                                            System.out.print("\t Inserez le nom\n");
                                            nom = var.next();
                                            System.out.print("\t Inserez le prenom\n");
                                            prenom = var.next();
                                            System.out.print("\t Inserez le mail\n");
                                            mail = var.next();
                                            System.out.print("\t Inserez le numero de telephone\n");
                                            telephone = var.next();
                                            System.out.print("\t Inserez l'adresse\n");
                                            adr = var.next();
                                            proprietaire = new Proprietaire(nom, prenom, mail, telephone, adr);
                                            t.setProprietaire(proprietaire);
                                        }
                                        break;
                                        case 4: {
                                            System.out.println("Inserez la wilaya ou se situe le terrain :");
                                            num_wilaya = var.nextInt();
                                            wilaya = new Wilaya(num_wilaya);
                                            t.setWilaya(wilaya);
                                        }
                                        break;
                                        case 5: {
                                            System.out.println("Est ce que le prix du terrain est negociable :");
                                            negociable = var.nextBoolean();
                                            t.setNegociable(negociable);
                                        }
                                        break;
                                        case 6: {
                                            System.out.println("Quelle est la nature de transaction de ce terrain :");
                                            System.out.println("1 ) Vente.");
                                            System.out.println("2 ) Location.");
                                            System.out.println("3 ) Echange.");
                                            System.out.print("---> ");
                                            choix_nature = var.nextInt();
                                            switch (choix_nature) {
                                                case 1: {
                                                    nature = Nature.Vente;
                                                }
                                                break;
                                                case 2: {
                                                    nature = Nature.Location;
                                                }
                                                break;
                                                case 3: {
                                                    nature = Nature.Echange;
                                                }
                                                break;
                                                default: {
                                                }
                                                break;
                                            }
                                            t.setNature(nature);
                                        }
                                        break;
                                        case 7: {
                                            System.out.println("Quel est le statut juridique du terrain :");
                                            System.out.println("1 ) Papier timbré.");
                                            System.out.println("2 ) Autre.");
                                            System.out.print("---> ");
                                            int choix_statut = var.nextInt();
                                            if (choix_statut == 1)
                                                statut_juridique = Statut_juridique.Papier_timbré;
                                            else {
                                                if (choix_statut == 2)
                                                    statut_juridique = Statut_juridique.autre;
                                            }
                                            t.setStatu_juridique(statut_juridique);

                                        }
                                        break;
                                        case 8: {
                                            System.out.println("Quel est le nombre de facades du terrain ? :");
                                            nb_facades = var.nextInt();
                                            t.setNb_facades(nb_facades);
                                        }
                                        break;

                                        case 9: {
                                            System.out.println("Quel est le prix de la maison : ");
                                            prix = var.nextLong();
                                            t.setPrix(prix);
                                        }
                                        break;
                                        default: {
                                        }break;
                                    }
                                    Client.Liste_Bien.add(t);
                                    System.out.print("voulez vous continuer ? :");
                                    continuer = var.nextBoolean();
                                }
                            }
                        }
                        break;
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrez un choix valide !!");
                bool = true;
            }
        }
    }
    public void visualiser_liste_biens()
    {
        Iterator<Bien> Iter = Liste_Bien.iterator();
        int i = 1;
        int choix;
        Scanner var = new Scanner(System.in);
        while (Iter.hasNext())
        {
                System.out.print(i + ") ");
                Iter.next().visualisation();
                i++;
        }
        System.out.print("Quel Bien voulez vous visualiser ?\n--> ");
        choix = var.nextInt();
        i = 1;
        Iter = Liste_Bien.iterator();
        while (Iter.hasNext()) {
            if (i == choix) {
                System.out.println("le Bien choisis :");
                Iter.next().visualisation_detail();
                break;
            }
            Iter.next();
            i++;
        }
    }

    public boolean visualiser_bien_proprio(Proprietaire proprietaire)
    {
        boolean has = false;
        Iterator<Bien> Iter = Liste_Bien.iterator();
        while (Iter.hasNext())
        {
            Bien b = Iter.next();
            if (b.getProprietaire().equals(proprietaire))
            {
                has = true;
                b.visualisation();
            }
        }
        if (!has) System.out.println("Le propietaire que vous avez choisi n'a aucun bien !!");
        return has;
    }

    public void archiver()
    {
        {
            Iterator<Bien> Iter = Liste_Bien.iterator();
            int i = 1;
            int choix;
            Scanner var = new Scanner(System.in);
            while (Iter.hasNext())
            {
                System.out.print(i + ") ");
                Iter.next().visualisation();
                i++;
            }
            System.out.print("Quel Bien voulez vous archiver ?\n--> ");
            choix = var.nextInt();
            i = 1;
            Iter = Liste_Bien.iterator();
            while (Iter.hasNext()) {
                if (i == choix) {
                    Iter.next().archiver_bien();
                    break;
                }
                Iter.next();
                i++;
            }
        }
    }

    public void visualiser_archive()
    {
        Iterator<Bien> Iter = Liste_Bien.iterator();
        while (Iter.hasNext())
        {
            Bien b = Iter.next();
            if(b.isArchive())
            {
                b.visualisation();
            }
        }
    }

    public void affichage_prix_final()
    {
        Iterator<Bien> Iter = Liste_Bien.iterator();
        Bien bien;
        int i=1;
        while (Iter.hasNext())
        {
            bien = Iter.next();
            if(bien.getNature().equals(Nature.Vente))
            {
                System.out.print(i + ")");
                System.out.println("Le prix de vente : " + bien.Calcule_prix_vente_finale() + " DA");
                bien.visualisation();
                i++;
            }
            else if(bien.getNature().equals(Nature.Location))
            {
                System.out.print(i + ")");
                System.out.println("Le prix de location : "+bien.Calcule_prix_location_finale()+ " DA");
                bien.visualisation();
                i++;
            }
        }
    }

    public void affiche_prix_echange()
    {
        Scanner var = new Scanner(System.in);
        Iterator<Bien> Iter = Liste_Bien.iterator();
        Bien bien;
        int i=1;
        while (Iter.hasNext())
        {
            bien = Iter.next();
            if(bien.getNature().equals(Nature.Echange))
            {
                System.out.print(i + ")");
                bien.visualisation();
                System.out.println("Entrez le numero de la wilaya ou se situe le bien a echanger");
                int num_wilaya_echange = var.nextInt();
                System.out.println("Le prix de l'echange : " + bien.Calcule_prix_echange_finale(num_wilaya_echange) + " DA");
                i++;
            }
        }
    }
}