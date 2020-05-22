package kernel;
import java.util.*;

public class Client
{
    private static int nb_bien = 0;
    protected static TreeSet<Bien> Liste_Bien = new TreeSet<Bien>();
    public static void inc_nb_bien() {
        nb_bien++;
    }

    public static TreeSet<Bien> getListe_Bien(){return Liste_Bien;}
    public static void setListe_Bien(TreeSet<Bien> liste_Bien){Liste_Bien = liste_Bien;}
    public static int getNb_bien(){return nb_bien;}
    public static void setNb_bien(int nb_bien){Client.nb_bien = nb_bien;}


    public void visualiser_liste_biens()
    {
        Iterator<Bien> Iter = Liste_Bien.iterator();
        int i = 1;
        int choix;
        Scanner var = new Scanner(System.in);
        boolean b = true;
        Bien bien = null;

        while (b)
        {
            while (Iter.hasNext())
            {
                bien = Iter.next();
                if (!bien.isArchive())
                {
                    System.out.print(i + ")");
                    bien.visualisation();
                    i++;
                }
            }
            System.out.println("*****************************************");
            System.out.print("Quel Bien voulez vous visualiser en detail ?");
            choix = var.nextInt();
            i = 1;
            Iter = Liste_Bien.iterator();
            while (Iter.hasNext())
            {
                bien =Iter.next();
                if(!bien.isArchive())
                {
                    if (i == choix)
                    {
                        System.out.println("\nle Bien choisis :");
                        System.out.println("*****************************************");
                        bien.visualisation_detail();
                        System.out.println("\n*****************************************");
                        break;
                    }
                    i++;
                }
            }
            System.out.println("Voulez vous visualiser en detail un autre Bien");
            b = var.nextBoolean();
        }
    }

    public void recherche_Bien()
    {
        Iterator<Bien> Iter = Liste_Bien.iterator();
        Scanner var = new Scanner(System.in);
        Nature nature = null;
        int num_wilaya_echange;
        System.out.println("Que voulez vous chercher ? :");
        System.out.println("1) Maison.");
        System.out.println("2) Appartement.");
        System.out.println("3) Terrain.");
        System.out.println("\t --> ");
        int choix = var.nextInt();
        switch (choix)
        {
            case 2:
                {
                    Iter = Liste_Bien.iterator();
                    while (Iter.hasNext()) {
                        Bien bien_courant_a = Iter.next();
                        if ( !(bien_courant_a.getType_bien().equals(Type_bien.Appartement)) ) {
                            Iter.remove();
                        }
                    }

                    int Tab[] = {0, 0, 0, 0, 0, 0};
                    int ch;
                    String transaction;
                    int num_wilaya = 0;
                    long prix_min = 0;
                    long prix_max = 0;
                    long sup_min = 0;
                    long nb_pieces = 0;

                    boolean b = true;

                    while (b)
                    {
                        System.out.println("Les critères de recherche :");
                        System.out.println("    1) -- > Type de transaction.");
                        System.out.println("    2) -- > Numero wilaya.");
                        System.out.println("    3) -- > Prix maximum.");
                        System.out.println("    4) -- > Prix minimum.");
                        System.out.println("    5) -- > Superficie minimale.");
                        System.out.println("    6) -- > Nombre de pièces.");
                        System.out.println("    99) -- > Pour lancer le resultat de recherche.");
                        System.out.println("\nIntroduire le numero des critère voulus..");
                        System.out.print("\n-->> ");

                        ch = var.nextInt();
                        if (ch == 99)
                            break ;
                        Tab[ch - 1] = 1;
                        switch (ch) {
                            case 1: {
                                System.out.println("Quelle est la nature de transaction de cette maison :");
                                System.out.println("1 ) Vente.");
                                System.out.println("2 ) Location.");
                                System.out.println("3 ) Echange.");
                                System.out.print("---> ");
                                int choix_nature = var.nextInt();
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
                            }
                            break;
                            case 2: {
                                System.out.println("Entrer le numero de wilaya voulu :\n -->> ");
                                num_wilaya = var.nextInt();
                            }
                            break;
                            case 3: {
                                System.out.println("Entrer le prix maximum voulu :\n -->> ");
                                prix_max = var.nextLong();
                            }
                            break;
                            case 4: {
                                System.out.println("Entrer le prix minimum voulu :\n -->> ");
                                prix_min = var.nextLong();
                            }
                            break;
                            case 5: {
                                System.out.println("Entrer la superficie minimale voulu :\n -->> ");
                                sup_min = var.nextLong();
                            }
                            break;
                            case 6: {
                                System.out.println("Entrer le nombre de pieces voulu :\n -->> ");
                                nb_pieces = var.nextInt();
                            }
                            break;
                            default: {
                            }
                            break;
                        }
                        System.out.println("Voulez vous choisir un autre critere ? :");
                        b=var.nextBoolean();
                    }

                    for (int i = 0; i < 6; i++)
                    {
                        if (Tab[i] == 1) {
                            switch (i) {
                                case 0: {
                                    Iter = Liste_Bien.iterator();
                                    while (Iter.hasNext()) {
                                        Bien bien_courant = Iter.next();
                                        if (bien_courant.nature != nature) {
                                            Iter.remove();
                                        }
                                    }
                                }
                                break;
                                case 1: {
                                    Iter = Liste_Bien.iterator();
                                    while (Iter.hasNext()) {
                                        Bien bien_courant_2 = Iter.next();
                                        if (bien_courant_2.getWilaya().getNum_wilaya() != num_wilaya) {
                                            Iter.remove();
                                        }
                                    }
                                }
                                break;
                                case 2: {
                                    Iter = Liste_Bien.iterator();
                                    while (Iter.hasNext()) {
                                        Bien bien_courant_3 = Iter.next();
                                        switch (bien_courant_3.getNature()) {
                                            case Vente: {
                                                if (bien_courant_3.Calcule_prix_vente_finale() > prix_max)
                                                    Iter.remove();
                                            }
                                            break;
                                            case Location: {
                                                if (bien_courant_3.Calcule_prix_location_finale() > prix_max)
                                                    Iter.remove();
                                            }
                                            break;
                                            case Echange: {
                                                System.out.println("entrez le numero de la wilaya du bien a echanger");
                                                num_wilaya_echange=var.nextInt();
                                                if (bien_courant_3.Calcule_prix_echange_finale(num_wilaya_echange) > prix_max)
                                                    Iter.remove();
                                            }
                                            break;
                                            default: {
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case 3: {
                                    Iter = Liste_Bien.iterator();
                                    while (Iter.hasNext()) {
                                        Bien bien_courant_4 = Iter.next();
                                        switch (bien_courant_4.getNature()) {
                                            case Vente: {
                                                if (bien_courant_4.Calcule_prix_vente_finale() < prix_min)
                                                    Iter.remove();
                                            }
                                            break;
                                            case Location: {
                                                if (bien_courant_4.Calcule_prix_location_finale() < prix_min)
                                                    Iter.remove();
                                            }
                                            break;
                                            case Echange: {
                                                System.out.println("entrez le numero de la wilaya du bien a echanger");
                                                num_wilaya_echange=var.nextInt();
                                                if (bien_courant_4.Calcule_prix_echange_finale(num_wilaya_echange) < prix_min)
                                                    Iter.remove();
                                            }
                                            break;
                                            default: {
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case 4: {
                                    Iter = Liste_Bien.iterator();
                                    while (Iter.hasNext()) {
                                        Bien bien_courant_5 = Iter.next();
                                        if (bien_courant_5.getSuperficie() < sup_min)
                                            Iter.remove();
                                    }
                                }
                                break;
                                case 5: {
                                    Iter = Liste_Bien.iterator();
                                    while (Iter.hasNext()) {
                                        Bien bien_courant_6 = Iter.next();
                                            if ( ((Appartement)bien_courant_6).getNb_pieces() != nb_pieces)
                                                Iter.remove();
                                    }
                                }
                                break;
                                default: {
                                }
                                break;
                            }
                        }
                    }
                    System.out.println("**********************************");
                    Iter = Liste_Bien.iterator();
                    while (Iter.hasNext())
                    {
                        Iter.next().visualisation_detail();
                        System.out.println("**********************************");
                    }
                }break;
            case 3:
                {
                    Iter = Liste_Bien.iterator();
                    while (Iter.hasNext()) {
                        Bien bien_courant_t = Iter.next();
                        if(!(bien_courant_t.getType_bien().equals(Type_bien.Terrain)) ) {
                            Iter.remove();
                        }
                    }
                int Tab[] = {0, 0, 0, 0, 0, 0};
                int ch;
                String transaction;
                int num_wilaya = 0;
                long prix_min = 0;
                long prix_max = 0;
                long sup_min = 0;
                long nb_pieces = 0;

                boolean b = true;

                while (b)
                {
                    System.out.println("Les critères de recherche :");
                    System.out.println("    1) -- > Type de transaction.");
                    System.out.println("    2) -- > Numero wilaya.");
                    System.out.println("    3) -- > Prix maximum.");
                    System.out.println("    4) -- > Prix minimum.");
                    System.out.println("    5) -- > Superficie minimale.");
                    System.out.println("    99) -- > Pour lancer le resultat de recherche.");
                    System.out.println("\nIntroduire le numero des critère voulus..");
                    System.out.print("\n-->> ");

                    ch = var.nextInt();
                    if (ch == 99)
                        break ;
                    Tab[ch - 1] = 1;
                    switch (ch) {
                        case 1: {
                            System.out.println("Quelle est la nature de transaction de cette maison :");
                            System.out.println("1 ) Vente.");
                            System.out.println("2 ) Location.");
                            System.out.println("3 ) Echange.");
                            System.out.print("---> ");
                            int choix_nature = var.nextInt();
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
                        }
                        break;
                        case 2: {
                            System.out.println("Entrer le numero de wilaya voulu :\n -->> ");
                            num_wilaya = var.nextInt();
                        }
                        break;
                        case 3: {
                            System.out.println("Entrer le prix maximum voulu :\n -->> ");
                            prix_max = var.nextLong();
                        }
                        break;
                        case 4: {
                            System.out.println("Entrer le prix minimum voulu :\n -->> ");
                            prix_min = var.nextLong();
                        }
                        break;
                        case 5: {
                            System.out.println("Entrer la superficie minimale voulu :\n -->> ");
                            sup_min = var.nextLong();
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                    System.out.println("Voulez vous choisir un autre critere ? :");
                    b=var.nextBoolean();
                }

                for (int i = 0; i < 5; i++)
                {
                    if (Tab[i] == 1) {
                        switch (i) {
                            case 0: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant = Iter.next();
                                    if (bien_courant.nature != nature) {
                                        Iter.remove();
                                    }
                                }
                            }
                            break;
                            case 1: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_2 = Iter.next();
                                    if (bien_courant_2.getWilaya().getNum_wilaya() != num_wilaya) {
                                        Iter.remove();
                                    }
                                }
                            }
                            break;
                            case 2: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_3 = Iter.next();
                                    switch (bien_courant_3.getNature()) {
                                        case Vente: {
                                            if (bien_courant_3.Calcule_prix_vente_finale() > prix_max)
                                                Iter.remove();
                                        }
                                        break;
                                        case Location: {
                                            if (bien_courant_3.Calcule_prix_location_finale() > prix_max)
                                                Iter.remove();
                                        }
                                        break;
                                        case Echange: {
                                            System.out.println("entrez le numero de la wilaya du bien a echanger");
                                            num_wilaya_echange=var.nextInt();
                                            if (bien_courant_3.Calcule_prix_echange_finale(num_wilaya_echange) > prix_max)
                                                Iter.remove();
                                        }
                                        break;
                                        default: {
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                            case 3: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_4 = Iter.next();
                                    switch (bien_courant_4.getNature()) {
                                        case Vente: {
                                            if (bien_courant_4.Calcule_prix_vente_finale() < prix_min)
                                                Iter.remove();
                                        }
                                        break;
                                        case Location: {
                                            if (bien_courant_4.Calcule_prix_location_finale() < prix_min)
                                                Iter.remove();
                                        }
                                        break;
                                        case Echange: {
                                            System.out.println("entrez le numero de la wilaya du bien a echanger");
                                            num_wilaya_echange=var.nextInt();
                                            if (bien_courant_4.Calcule_prix_echange_finale(num_wilaya_echange) < prix_min)
                                                Iter.remove();
                                        }
                                        break;
                                        default: {
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                            case 4: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_5 = Iter.next();
                                    if (bien_courant_5.getSuperficie() < sup_min)
                                        Iter.remove();
                                }
                            }
                            break;
                            default: {
                            }
                            break;
                        }
                    }
                }
                System.out.println("**********************************");
                Iter = Liste_Bien.iterator();
                while (Iter.hasNext())
                {
                    Iter.next().visualisation_detail();
                    System.out.println("**********************************");
                }
            }
            break;

            case 1 : {

                Iter = Liste_Bien.iterator();
                while (Iter.hasNext()) {
                    Bien bien_courant_m = Iter.next();
                    if ( !(bien_courant_m.getType_bien().equals(Type_bien.Maison)) ) {
                        Iter.remove();
                    }
                }

                int Tab[] = {0, 0, 0, 0, 0, 0};
                int ch;
                String transaction;
                int num_wilaya = 0;
                long prix_min = 0;
                long prix_max = 0;
                long sup_min = 0;
                long nb_pieces = 0;

                boolean b = true;

                while (b)
                {
                    System.out.println("Les critères de recherche :");
                    System.out.println("    1) -- > Type de transaction.");
                    System.out.println("    2) -- > Numero wilaya.");
                    System.out.println("    3) -- > Prix maximum.");
                    System.out.println("    4) -- > Prix minimum.");
                    System.out.println("    5) -- > Superficie minimale.");
                    System.out.println("    6) -- > Nombre de pièces.");
                    System.out.println("    99) -- > Pour lancer le resultat de recherche.");
                    System.out.println("\nIntroduire le numero des critère voulus..");
                    System.out.print("\n-->> ");

                    ch = var.nextInt();
                    if (ch == 99)
                        break ;
                    Tab[ch - 1] = 1;
                    switch (ch) {
                        case 1: {
                            System.out.println("Quelle est la nature de transaction de cette maison :");
                            System.out.println("1 ) Vente.");
                            System.out.println("2 ) Location.");
                            System.out.println("3 ) Echange.");
                            System.out.print("---> ");
                            int choix_nature = var.nextInt();
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
                        }
                        break;
                        case 2: {
                            System.out.println("Entrer le numero de wilaya voulu :\n -->> ");
                            num_wilaya = var.nextInt();
                        }
                        break;
                        case 3: {
                            System.out.println("Entrer le prix maximum voulu :\n -->> ");
                            prix_max = var.nextLong();
                        }
                        break;
                        case 4: {
                            System.out.println("Entrer le prix minimum voulu :\n -->> ");
                            prix_min = var.nextLong();
                        }
                        break;
                        case 5: {
                            System.out.println("Entrer la superficie minimale voulu :\n -->> ");
                            sup_min = var.nextLong();
                        }
                        break;
                        case 6: {
                            System.out.println("Entrer le nombre de pieces voulu :\n -->> ");
                            nb_pieces = var.nextInt();
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                    System.out.println("Voulez vous choisir un autre critere ? :");
                    b=var.nextBoolean();
                }

                for (int i = 0; i < 6; i++)
                {
                    if (Tab[i] == 1) {
                        switch (i) {
                            case 0: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant = Iter.next();
                                    if (bien_courant.nature != nature) {
                                        Iter.remove();
                                    }
                                }
                            }
                            break;
                            case 1: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_2 = Iter.next();
                                    if (bien_courant_2.getWilaya().getNum_wilaya() != num_wilaya) {
                                        Iter.remove();
                                    }
                                }
                            }
                            break;
                            case 2: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_3 = Iter.next();
                                    switch (bien_courant_3.getNature()) {
                                        case Vente: {
                                            if (bien_courant_3.Calcule_prix_vente_finale() > prix_max)
                                                Iter.remove();
                                        }
                                        break;
                                        case Location: {
                                            if (bien_courant_3.Calcule_prix_location_finale() > prix_max)
                                                Iter.remove();
                                        }
                                        break;
                                        case Echange: {
                                            System.out.println("entrez le numero de la wilaya du bien a echanger");
                                            num_wilaya_echange=var.nextInt();
                                            if (bien_courant_3.Calcule_prix_echange_finale(num_wilaya_echange) > prix_max)
                                                Iter.remove();
                                        }
                                        break;
                                        default: {
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                            case 3: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_4 = Iter.next();
                                    switch (bien_courant_4.getNature()) {
                                        case Vente: {
                                            if (bien_courant_4.Calcule_prix_vente_finale() < prix_min)
                                                Iter.remove();
                                        }
                                        break;
                                        case Location: {
                                            if (bien_courant_4.Calcule_prix_location_finale() < prix_min)
                                                Iter.remove();
                                        }
                                        break;
                                        case Echange: {
                                            System.out.println("entrez le numero de la wilaya du bien a echanger");
                                            num_wilaya_echange=var.nextInt();
                                            if (bien_courant_4.Calcule_prix_echange_finale(num_wilaya_echange) < prix_min)
                                                Iter.remove();
                                        }
                                        break;
                                        default: {
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                            case 4: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_5 = Iter.next();
                                    if (bien_courant_5.getSuperficie() < sup_min)
                                        Iter.remove();
                                }
                            }
                            break;
                            case 5: {
                                Iter = Liste_Bien.iterator();
                                while (Iter.hasNext()) {
                                    Bien bien_courant_6 = Iter.next();
                                    if ( ((Maison)bien_courant_6).getNb_pieces() != nb_pieces)
                                        Iter.remove();
                                }
                            }
                            break;
                            default: {
                            }
                            break;
                        }
                    }
                }
                System.out.println("**********************************");
                Iter = Liste_Bien.iterator();
                while (Iter.hasNext())
                {
                    Iter.next().visualisation_detail();
                    System.out.println("**********************************");
                }
            }
            break;

            default:{}break;
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
            if (!bien.isArchive())
            {
                System.out.print(i + ")");
                if(bien.getNature().equals(Nature.Vente))
                    System.out.println("Le prix de vente : "+ bien.Calcule_prix_vente_finale());
                else if(bien.getNature().equals(Nature.Location))
                    System.out.println("Le prix de location : "+ bien.Calcule_prix_location_finale());
                i++;
                bien.visualisation();
            }
        }
    }

    public void affiche_prix_echange()
    {
        Scanner var = new Scanner(System.in);
        Iterator<Bien> Iter = Liste_Bien.iterator();
        Bien bien;
        int i=1;
        System.out.println("Entrez le numero de la wilaya ou se situe le bien a echanger");
        int num_wilaya_echange = var.nextInt();
        while (Iter.hasNext())
        {
            bien = Iter.next();
            if (!bien.isArchive())
            {
                System.out.print(i + ")");
                if(bien.getNature().equals(Nature.Echange))
                    System.out.println("Le prix de l'echange : "+ bien.Calcule_prix_echange_finale(num_wilaya_echange));
                bien.visualisation();
                i++;
            }
        }
    }

    public String[] envoyer_msg()
    {
        Scanner var =new Scanner(System.in);
        int choix=0;
        String tab[] = new String[4];
        System.out.println("Bonjour,pour envoyer un msg veuillez preciser le bien concerné :(nottez bien que le bien ptrécisé doit ettre inclus dans la liste des Biens a visualiser)");
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
            }
            catch (java.util.InputMismatchException e)
            {
                System.out.println("Entrez un choix valide !!");
                bool=true;
            }
        }
        switch (choix)
        {
            case 1:{tab[0] = "Maison";}break;
            case 2:{tab[0] = "Appartement";}break;
            case 3:{tab[0] = "Terrain";}break;
            default:{}break;
        }
        System.out.print("\nwilaya du bien");
        tab[1]=var.next();
        System.out.print("\nadresse du bien");
        tab[2]=var.next();

        System.out.print("\nEntrez votre mesage:");
        tab[3]=var.next();

        return tab;
    }
}