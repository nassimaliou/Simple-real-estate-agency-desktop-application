package kernel;
import sample.Exeption_superficie;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test
{
    public static void main(String args[]) throws Exeption_superficie {
        Proprietaire Prop1 = new Proprietaire("Aliousalah","MohamedNassim","im_aliousalah@esi.dz","0779487797","K55-Anasseur-Miliana");
        Proprietaire Prop2 = new Proprietaire("Bacha","Amine","ia_bacha@esi.dz","0796028213","Ighil-Ouazzoug");
        Proprietaire Prop3 = new Proprietaire("Tamazouzt","Messipsa","im_tamazouzt@esi.dz","0796081288","Quartier-Tibane");
        Proprietaire Prop4 = new Proprietaire("Metiji","Sid-Ahmed","is_metiji@esi.dz","0793098611","Quartier-Essalam-KhemissMiliana");

        Wilaya wilaya1 = new Wilaya(1);
        Wilaya wilaya2 = new Wilaya(2);
        Wilaya wilaya3 = new Wilaya(3);

        Date date1 = new Date(109,Calendar.APRIL,13);
        Appartement Bien1 = new Appartement(1,"simplexe",true,4,true,"Alger",120,4_000_000,Prop2,date1,wilaya2,true,Nature.Vente,Type_bien.Appartement);
        Date date2 = new Date(110, Calendar.FEBRUARY,6);
        Maison Bien2 = new Maison(1,false,true,false,190,5,true,"Draria",200,10_000_000,Prop1,date2,wilaya3,false,Nature.Vente,Type_bien.Maison);
        Date date3 = new Date(111,Calendar.AUGUST,19);
        Terrain Bien3 = new Terrain(Statut_juridique.Papier_timbré,3,"Miliana",500,20_000_000,Prop1,date3,wilaya1,true,Nature.Vente,Type_bien.Terrain);
        Date date4 = new Date(112,Calendar.DECEMBER,25);
        Appartement Bien4 = new Appartement(1,"duplexe",true,3,false,"DarElBidha",100,40_000,Prop2,date4,wilaya3,false,Nature.Location,Type_bien.Appartement);
        Date date5 = new Date(113,Calendar.MAY,7);
        Maison Bien5 = new Maison(2,false,false,true,120,6,false,"BirKhadem",160,150_000,Prop3,date5,wilaya2,true,Nature.Location,Type_bien.Maison);
        Date date6 = new Date(114,Calendar.JANUARY,15);
        Appartement Bien6 = new Appartement(6,"studio",false,3,true,"Rouiba",50,60_000,Prop2,date6,wilaya3,false,Nature.Location,Type_bien.Appartement);
        Date date7 = new Date(115,Calendar.NOVEMBER,21);
        Terrain Bien7 = new Terrain(Statut_juridique.autre,1,"Oued Smar",650,18_000_000,Prop1,date7,wilaya1,false,Nature.Echange,Type_bien.Terrain);
        Date date8 = new Date(116,Calendar.JUNE,2);
        Maison Bien8 = new Maison(3,true,false,false,200,6,true,"BirTouta",200,14_000_000,Prop2,date8,wilaya2,true,Nature.Echange,Type_bien.Maison);


        Scanner sc = new Scanner(System.in);
        int choix;
        String mdp="TP_POO_g7";
        String verif;
        boolean continuer = true;
        boolean bool=true;

        while (continuer)
        {
            while (true)
            {
                System.out.println("Voulez-vous vous conecter en tant qu'Administrateur ou en tant que client ?");
                System.out.println("1 ) Administrateur.");
                System.out.println("2 ) Client.");
                System.out.print("--- > ");
                choix = sc.nextInt();
                if((choix== 1)||(choix==2))
                {
                    break;
                }
                System.out.print("entez un choix valable !");
            }

            switch (choix)
            {
                 case 1:
                {
                    System.out.print("entrez le mot de passe : ");
                    while (true) {
                        verif = sc.next();
                        if (verif.equals(mdp)) {
                            Agent_administrateur admin = new Agent_administrateur();
                            System.out.println("Quelle sont les biens que vous vouler ajouter ?:\n1) -->Bien n°1\n2) -->Bien n°2\n3) -->Bien n°3\n4) -->Bien n°4\n5) -->Bien n°5\n6) -->Bien n°6\n7) -->Bien n°7\n8) -->Bien n°8\n\n 99--> Quitter.");
                            boucle : while (true){
                                bool=true;
                            while (bool) {
                                bool=false;
                                try {
                                    sc = new Scanner(System.in);
                                    bool = false;
                                    System.out.print("-->>  ");
                                    choix = sc.nextInt();
                                    switch (choix)
                                    {
                                    case 1: {if (Client.Liste_Bien.contains(Bien1)) System.out.println("Ce bien est déja dans la base de donnée"); else Client.getListe_Bien().add(Bien1);}break;
                                    case 2: {if (Client.Liste_Bien.contains(Bien2)) System.out.println("Ce bien est déja dans la base de donnée"); else  Client.getListe_Bien().add(Bien2);}break;
                                    case 3: {if (Client.Liste_Bien.contains(Bien3)) System.out.println("Ce bien est déja dans la base de donnée"); else  Client.getListe_Bien().add(Bien3);}break;
                                    case 4: {if (Client.Liste_Bien.contains(Bien4)) System.out.println("Ce bien est déja dans la base de donnée"); else  Client.getListe_Bien().add(Bien4);}break;
                                    case 5: {if (Client.Liste_Bien.contains(Bien5)) System.out.println("Ce bien est déja dans la base de donnée"); else  Client.getListe_Bien().add(Bien5);}break;
                                    case 6: {if (Client.Liste_Bien.contains(Bien6)) System.out.println("Ce bien est déja dans la base de donnée"); else  Client.getListe_Bien().add(Bien6);}break;
                                    case 7: {if (Client.Liste_Bien.contains(Bien7)) System.out.println("Ce bien est déja dans la base de donnée"); else  Client.getListe_Bien().add(Bien7);}break;
                                    case 8: {if (Client.Liste_Bien.contains(Bien8)) System.out.println("Ce bien est déja dans la base de donnée"); else  Client.getListe_Bien().add(Bien8);}break;
                                    case 99:{break boucle;}
                                    default:{System.out.println("Ce bien n'existe pas !!!!");}break;
                                    }
                                    }
                                catch (java.util.InputMismatchException e) {
                                    System.out.println("Entrez un choix valide !!");
                                    bool = true;
                                }
                            }
                            }
                            System.out.println("**************************************************");
                            while (continuer) {
                                System.out.println("\nChoisisez une option : \n-->1)visualiser la liste des biens \n-->2)visualiser les Biens d'un proprietaire donné \n-->3)archiver un Bien \n-->4)afficher les biens archivés \n-->5)Ajouter un Bien \n-->6)modifier un Bien \n-->7)supprimer un Bien \n-->8)Calcule prix final(Vente/Location) \n-->9)Calcule prix d'echange");
                                choix=sc.nextInt();
                                System.out.println("*****************************************");
                                switch (choix) {
                                    case 1:{admin.visualiser_liste_biens();}break;
                                    case 2:
                                        {
                                            while (true)
                                            {
                                                System.out.println("Les biens de quel proprietaire voulez-vous consulter ?");
                                                int pro = 0;
                                                Proprietaire buf = null;
                                                System.out.println("1) --> Prop1.");
                                                System.out.println("2) --> Prop2.");
                                                System.out.println("3) --> Prop3.");
                                                System.out.println("4) --> Prop4.");
                                                System.out.print(" -->> ");
                                                pro = sc.nextInt();
                                                switch (pro)
                                                {
                                                    case 1: { buf = Prop1; }break;
                                                    case 2: { buf = Prop2; }break;
                                                    case 3: { buf = Prop3; }break;
                                                    case 4: { buf = Prop4; }break;
                                                    default: { System.out.println("CHOIX INVALIDE !!!"); }break;
                                                }
                                                if (admin.visualiser_bien_proprio(buf)) break;
                                            }

                                    }break;
                                    case 3:
                                        {
                                            admin.archiver();
                                        }break;
                                    case 4:{admin.visualiser_archive();}break;
                                    case 5:{Agent_administrateur.ajout();}break;
                                    case 7:{Agent_administrateur.supprimer();}break;
                                    case 6:{Agent_administrateur.modification();}break;
                                    case 8:{admin.affichage_prix_final();}break;
                                    case 9:{admin.affiche_prix_echange();}break;
                                    default:{}break;
                                }
                                System.out.println("*****************************************");
                                System.out.println("Voulez vous retourner au menu du compte? : ");
                                continuer=sc.nextBoolean();
                                System.out.println("*****************************************");
                            }
                            break;
                        } else {
                            System.out.print("Mot de passe erroné\n entrez le mot de passe correct : ");
                        }
                    }
                }break;
            case 2:
                {
                    Client client = new Client();
                    while (continuer) {
                        System.out.println("Choisisez une option : \n1)visualiser la liste des biens \n2)recherche de Biens selon un/des criteres \n3)envoyer un message avec precision de Bien \n4)Calcule prix final(Vente/Location) \n5)Calcule prix d'echange");
                        choix=sc.nextInt();
                        System.out.println("*****************************************");
                        switch (choix) {
                            case 1:{client.visualiser_liste_biens();}break;
                            case 2:{client.recherche_Bien();}break;
                            case 3:{client.envoyer_msg();}break;
                            case 4:{client.affichage_prix_final();}break;
                            case 5:{client.affiche_prix_echange();}break;
                            default:{}break;
                        }
                        System.out.println("*****************************************");
                        System.out.println("Voulez vous retourner au menu du compte ? : ");
                        continuer=sc.nextBoolean();
                        System.out.println("*****************************************");
                    }
                }break;
             default:{}break;
            }
          System.out.print("Voulez vous changer de compte(true) ou deconneter definitivement(false)? : ");
          continuer=sc.nextBoolean();
        }
    }
}