package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kernel.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;


public class Main extends Application {

    static Boolean compte;
    static String[] Boite = new String[20];
    static int taille=0;
    static Bien[] tab_bien = new Bien[20];
    static Boolean exist(Bien b)
    {
        int i=0;
        for(i=0;i<tab_bien.length;i++)
        {
            if(tab_bien[i]==null)
                break;
            if(tab_bien[i].equals(b))
                return false;
        }
        return true;
    }

    static Proprietaire Prop1 = new Proprietaire("Aliousalah","MohamedNassim","im_aliousalah@esi.dz","0779487797","K55-Anasseur-Miliana");
    static Proprietaire Prop2 = new Proprietaire("Bacha","Amine","ia_bacha@esi.dz","0796028213","Ighil-Ouazzoug");
    static Proprietaire Prop3 = new Proprietaire("Tamazouzt","Messipsa","im_tamazouzt@esi.dz","0796081288","Quartier-Tibane");
    static Proprietaire Prop4 = new Proprietaire("Metiji","Sid-Ahmed","is_metiji@esi.dz","0793098611","Quartier-Essalam-KhemissMiliana");

    static Wilaya wilaya1 = new Wilaya(1);
    static Wilaya wilaya2 = new Wilaya(2);
    static Wilaya wilaya3 = new Wilaya(3);
    static String choix=null;
    static String choix_modif=null;
    static String chaine_prop=null;

    private static Date date1 = new Date(109, Calendar.APRIL,13);
    static Appartement Bien1 = new Appartement(1,"simplexe",true,4,true,"Alger",120,4_000_000,Prop2,date1,wilaya2,true,Nature.Vente,Type_bien.Appartement);
    private static Date date2 = new Date(110, Calendar.FEBRUARY,6);
    static Maison Bien2;

    static {
        try {
            Bien2 = new Maison(1,false,true,false,190,5,true,"Draria",200,10_000_000,Prop1,date2,wilaya3,false,Nature.Vente,Type_bien.Maison);
        } catch (Exeption_superficie exeption_superficie) {
            Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("Surface ou surface habitable incorecte");
        }
    }

    private static Date date3 = new Date(111,Calendar.AUGUST,19);
    static Terrain Bien3 = new Terrain(Statut_juridique.Papier_timbré,3,"Miliana",500,20_000_000,Prop1,date3,wilaya1,true,Nature.Vente,Type_bien.Terrain);
    private static Date date4 = new Date(112,Calendar.DECEMBER,25);
    static Appartement Bien4 = new Appartement(1,"duplexe",true,3,false,"DarElBidha",100,40_000,Prop2,date4,wilaya3,false,Nature.Location,Type_bien.Appartement);
    private static Date date5 = new Date(113,Calendar.MAY,7);
    static Maison Bien5;

    static {
        try {
            Bien5 = new Maison(2,false,false,true,120,6,false,"BirKhadem",160,150_000,Prop3,date5,wilaya2,true,Nature.Location,Type_bien.Maison);
        } catch (Exeption_superficie exeption_superficie) {
            Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("Surface ou surface habitable incorecte");
        }
    }

    private static Date date6 = new Date(114,Calendar.JANUARY,15);
    static Appartement Bien6 = new Appartement(6,"studio",false,3,true,"Rouiba",50,60_000,Prop2,date6,wilaya3,false,Nature.Location,Type_bien.Appartement);
    private static Date date7 = new Date(115,Calendar.NOVEMBER,21);
    static Terrain Bien7 = new Terrain(Statut_juridique.autre,1,"Oued Smar",650,18_000_000,Prop1,date7,wilaya1,false,Nature.Echange,Type_bien.Terrain);
    private static Date date8 = new Date(116,Calendar.JUNE,2);
    static Maison Bien8;

    static {
        try {
            Bien8 = new Maison(3,true,false,false,200,6,true,"BirTouta",200,14_000_000,Prop2,date8,wilaya2,true,Nature.Echange,Type_bien.Maison);
        } catch (Exeption_superficie exeption_superficie) {
            Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("Surface ou surface habitable incorecte");
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("admin_client.fxml"));
        primaryStage.setTitle("IMMO-ESI");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        Client.getListe_Bien().add(Bien1);
        Client.getListe_Bien().add(Bien2);
        Client.getListe_Bien().add(Bien3);
        Client.getListe_Bien().add(Bien4);
        Client.getListe_Bien().add(Bien5);
        Client.getListe_Bien().add(Bien6);
        Client.getListe_Bien().add(Bien7);
        Client.getListe_Bien().add(Bien8);
        Bien7.setWilaya_echange(wilaya3);
        Bien8.setWilaya_echange(wilaya2);
        launch(args);
    }
}