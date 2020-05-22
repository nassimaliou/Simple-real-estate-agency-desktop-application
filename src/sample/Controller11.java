package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.PixelFormat;
import javafx.stage.Stage;
import kernel.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Controller11{

    public MenuButton prop;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button retour;

    @FXML
    private MenuButton type_bien;

    @FXML
    private RadioMenuItem t_maison;

    @FXML
    private RadioMenuItem t_terrain;

    @FXML
    private RadioMenuItem t_appart;

    @FXML
    private MenuButton nature;

    @FXML
    private RadioMenuItem vente;

    @FXML
    private RadioMenuItem location_;

    @FXML
    private RadioMenuItem echange;

    @FXML
    private MenuButton wilaya;

    @FXML
    private RadioMenuItem w1;

    @FXML
    private RadioMenuItem w2;

    @FXML
    private RadioMenuItem w3;

    @FXML
    private TextField superficie;

    @FXML
    private RadioMenuItem p1;

    @FXML
    private RadioMenuItem p2;

    @FXML
    private RadioMenuItem p3;

    @FXML
    private RadioMenuItem p4;

    @FXML
    private RadioMenuItem ajout_prop;

    @FXML
    private RadioButton meuble;

    @FXML
    private TextField nb_piece;

    @FXML
    private TextField etage;

    @FXML
    private MenuButton equipement;

    @FXML
    private RadioMenuItem garage;

    @FXML
    private RadioMenuItem piscine;

    @FXML
    private RadioMenuItem jardin;

    @FXML
    private TextField superficie_hab;

    @FXML
    private TextField nb_etage;

    @FXML
    private MenuButton statut_juridique;

    @FXML
    private RadioMenuItem papier_timbre;

    @FXML
    private RadioMenuItem autre;

    @FXML
    private TextField nb_facade;

    @FXML
    private TextField prix;

    @FXML
    private Button confirmer;

    @FXML
    private TextField adresse;

    @FXML
    private MenuButton wilaya_echange;

    @FXML
    private RadioMenuItem wil1_ech;

    @FXML
    private RadioMenuItem wil2_ech;

    @FXML
    private RadioMenuItem wil3_ech;

    @FXML
    private RadioButton ascenseur;

    @FXML
    private TextField type_appart;

    @FXML
    private RadioButton negociable1;

    @FXML
    void modif_bien(ActionEvent event) {
        Proprietaire prop = null;
        Date d=new Date();

        if (p1.isSelected()) { prop=Main.Prop1;}
        else
        {
            if (p2.isSelected()) {prop=Main.Prop2 ;}
            else
            {
                if(p3.isSelected()) { prop=Main.Prop3;}
            }
        }

        Wilaya wil_choisie = null;

        if (w1.isSelected()) { wil_choisie=Main.wilaya1;}
        else
        {
            if (w2.isSelected()) {wil_choisie=Main.wilaya2 ;}
            else
            {
                if(w3.isSelected()) { wil_choisie=Main.wilaya3;}
            }
        }

        Nature n=null;

        if (vente.isSelected()) { n=Nature.Vente;}
        else
        {
            if (location_.isSelected()) {n=Nature.Location ;}
            else
            {
                if(echange.isSelected()) { n=Nature.Echange;}
            }
        }

        Statut_juridique statut = null;

        if(papier_timbre.isSelected()){statut=Statut_juridique.Papier_timbré;}
        else
        if(autre.isSelected()){statut=Statut_juridique.autre;}

        if (t_maison.isSelected())
        {
            Boolean bool=true;
            Maison m=null;
            while (bool){
            try{ m=new Maison(Integer.parseInt(nb_etage.getText()),garage.isSelected(),jardin.isSelected(),piscine.isSelected(),Long.parseLong(superficie_hab.getText()),Integer.parseInt(nb_etage.getText()),meuble.isSelected(),adresse.getText(),Long.parseLong(superficie.getText()),Long.parseLong(prix.getText()),prop,d,wil_choisie,negociable1.isSelected(),n,Type_bien.Maison); bool=false;}
            catch (Exeption_superficie e)
            {
                Alert a=new Alert(Alert.AlertType.WARNING);
                a.setContentText("Surface ou surface habitable incorecte");
                a.show();
                initialize();
            }}

            if(m.getNature().equals(Nature.Echange))
            {
                if(wil1_ech.isSelected()) m.setWilaya_echange(Main.wilaya1);
                if(wil2_ech.isSelected()) m.setWilaya_echange(Main.wilaya2);
                if(wil3_ech.isSelected()) m.setWilaya_echange(Main.wilaya3);
            }
            Client.getListe_Bien().add(m);
        }
        else
        {
            if (t_appart.isSelected())
            {
                Appartement a=new Appartement(Integer.parseInt(etage.getText()),type_appart.getText(),ascenseur.isSelected(),Integer.parseInt(nb_piece.getText()),meuble.isSelected(),adresse.getText(),Long.parseLong(superficie.getText()),Long.parseLong(prix.getText()),prop,d,wil_choisie,negociable1.isSelected(),n,Type_bien.Appartement);
                if(a.getNature().equals(Nature.Echange))
                {
                    if(wil1_ech.isSelected()) a.setWilaya_echange(Main.wilaya1);
                    if(wil2_ech.isSelected()) a.setWilaya_echange(Main.wilaya2);
                    if(wil3_ech.isSelected()) a.setWilaya_echange(Main.wilaya3);
                }
                Client.getListe_Bien().add(a);
            }
            else
            {
                if(t_terrain.isSelected())
                {
                    Terrain t=new Terrain(statut,Integer.parseInt(nb_facade.getText()),adresse.getText(),Long.parseLong(superficie.getText()),Long.parseLong(prix.getText()),prop,d,wil_choisie,negociable1.isSelected(),n,Type_bien.Terrain);
                    if(t.getNature().equals(Nature.Echange))
                    {
                        if(wil1_ech.isSelected()) t.setWilaya_echange(Main.wilaya1);
                        if(wil2_ech.isSelected()) t.setWilaya_echange(Main.wilaya2);
                        if(wil3_ech.isSelected()) t.setWilaya_echange(Main.wilaya3);
                    }
                    Client.getListe_Bien().add(t);
                }
            }
        }
       
    }

    @FXML
    void etat_normal(MouseEvent event) {
        if (t_maison.isSelected())
        {
            t_terrain.setVisible(false);
            t_appart.setVisible(false);
            etage.setVisible(false);
            type_appart.setVisible(false);
            statut_juridique.setVisible(false);
            nb_facade.setVisible(false);
            ascenseur.setVisible(false);

        }
        else
        {
            t_terrain.setVisible(true);
            t_appart.setVisible(true);
            etage.setVisible(true);
            type_appart.setVisible(true);
            statut_juridique.setVisible(true);
            nb_facade.setVisible(true);
            ascenseur.setVisible(true);

            if (t_appart.isSelected())
            {
                t_terrain.setVisible(false);
                t_maison.setVisible(false);
                statut_juridique.setVisible(false);
                nb_facade.setVisible(false);
                equipement.setVisible(false);
                superficie_hab.setVisible(false);
                nb_etage.setVisible(false);
            }
            else
            {
                t_terrain.setVisible(true);
                t_maison.setVisible(true);
                statut_juridique.setVisible(true);
                nb_facade.setVisible(true);
                equipement.setVisible(true);
                superficie_hab.setVisible(true);
                nb_etage.setVisible(true);

                if(t_terrain.isSelected())
                {
                    t_appart.setVisible(false);
                    t_maison.setVisible(false);
                    etage.setVisible(false);
                    type_appart.setVisible(false);
                    equipement.setVisible(false);
                    superficie_hab.setVisible(false);
                    nb_etage.setVisible(false);
                    meuble.setVisible(false);
                    nb_piece.setVisible(false);
                    ascenseur.setVisible(false);
                }
                else
                {
                    t_appart.setVisible(true);
                    t_maison.setVisible(true);
                    etage.setVisible(true);
                    type_appart.setVisible(true);
                    equipement.setVisible(true);
                    superficie_hab.setVisible(true);
                    nb_etage.setVisible(true);
                    meuble.setVisible(true);
                    nb_piece.setVisible(true);
                    ascenseur.setVisible(true);
                }
            }
        }

        if(echange.isSelected())
            wilaya_echange.setVisible(true);
        else
            wilaya_echange.setVisible(false);

        if (p1.isSelected())
        {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
        }
        else
        {
            p2.setVisible(true);
            p3.setVisible(true);
            p4.setVisible(true);

            if (p2.isSelected())
            {
                p1.setVisible(false);
                p3.setVisible(false);
                p4.setVisible(false);
            }
            else
            {
                p1.setVisible(true);
                p3.setVisible(true);
                p4.setVisible(true);

                if(p3.isSelected())
                {
                    p1.setVisible(false);
                    p2.setVisible(false);
                    p4.setVisible(false);
                }
                else
                {
                    p1.setVisible(true);
                    p2.setVisible(true);
                    p4.setVisible(true);

                    if(p4.isSelected())
                    {
                        p1.setVisible(false);
                        p3.setVisible(false);
                        p2.setVisible(false);
                    }
                    else
                    {
                        p1.setVisible(true);
                        p3.setVisible(true);
                        p2.setVisible(true);
                    }
                }
            }
        }

        if (w1.isSelected())
        {
            w2.setVisible(false);
            w3.setVisible(false);
        }
        else
        {
            w2.setVisible(true);
            w3.setVisible(true);

            if (w2.isSelected())
            {
                w1.setVisible(false);
                w3.setVisible(false);
            }
            else
            {
                w1.setVisible(true);
                w3.setVisible(true);

                if(w3.isSelected())
                {
                    w1.setVisible(false);
                    w2.setVisible(false);
                }
                else
                {
                    w1.setVisible(true);
                    w2.setVisible(true);
                }
            }
        }

        if (vente.isSelected())
        {
            location_.setVisible(false);
            echange.setVisible(false);
        }
        else
        {
            location_.setVisible(true);
            echange.setVisible(true);

            if (location_.isSelected())
            {
                vente.setVisible(false);
                echange.setVisible(false);
            }
            else
            {
                vente.setVisible(true);
                echange.setVisible(true);

                if(echange.isSelected())
                {
                    vente.setVisible(false);
                    location_.setVisible(false);
                }
                else
                {
                    vente.setVisible(true);
                    location_.setVisible(true);
                }
            }
        }

        if (papier_timbre.isSelected())
        {
            autre.setVisible(false);
        }
        else
        {
            autre.setVisible(true);

            if (autre.isSelected())
            {
                papier_timbre.setVisible(false);
            }
            else
            {
                papier_timbre.setVisible(true);
            }
        }

    }

    @FXML
    void precedent(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("visualisation.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void initialize() {
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'modification.fxml'.";
        assert type_bien != null : "fx:id=\"type_bien\" was not injected: check your FXML file 'modification.fxml'.";
        assert t_maison != null : "fx:id=\"t_maison\" was not injected: check your FXML file 'modification.fxml'.";
        assert t_terrain != null : "fx:id=\"t_terrain\" was not injected: check your FXML file 'modification.fxml'.";
        assert t_appart != null : "fx:id=\"t_appart\" was not injected: check your FXML file 'modification.fxml'.";
        assert nature != null : "fx:id=\"nature\" was not injected: check your FXML file 'modification.fxml'.";
        assert vente != null : "fx:id=\"vente\" was not injected: check your FXML file 'modification.fxml'.";
        assert location_ != null : "fx:id=\"location_\" was not injected: check your FXML file 'modification.fxml'.";
        assert echange != null : "fx:id=\"echange\" was not injected: check your FXML file 'modification.fxml'.";
        assert wilaya != null : "fx:id=\"wilaya\" was not injected: check your FXML file 'modification.fxml'.";
        assert w1 != null : "fx:id=\"w1\" was not injected: check your FXML file 'modification.fxml'.";
        assert w2 != null : "fx:id=\"w2\" was not injected: check your FXML file 'modification.fxml'.";
        assert w3 != null : "fx:id=\"w3\" was not injected: check your FXML file 'modification.fxml'.";
        assert superficie != null : "fx:id=\"superficie\" was not injected: check your FXML file 'modification.fxml'.";
        assert p1 != null : "fx:id=\"p1\" was not injected: check your FXML file 'modification.fxml'.";
        assert p2 != null : "fx:id=\"p2\" was not injected: check your FXML file 'modification.fxml'.";
        assert p3 != null : "fx:id=\"p3\" was not injected: check your FXML file 'modification.fxml'.";
        assert p4 != null : "fx:id=\"p4\" was not injected: check your FXML file 'modification.fxml'.";
        assert ajout_prop != null : "fx:id=\"ajout_prop\" was not injected: check your FXML file 'modification.fxml'.";
        assert meuble != null : "fx:id=\"meuble\" was not injected: check your FXML file 'modification.fxml'.";
        assert nb_piece != null : "fx:id=\"nb_piece\" was not injected: check your FXML file 'modification.fxml'.";
        assert etage != null : "fx:id=\"etage\" was not injected: check your FXML file 'modification.fxml'.";
        assert equipement != null : "fx:id=\"equipement\" was not injected: check your FXML file 'modification.fxml'.";
        assert garage != null : "fx:id=\"garage\" was not injected: check your FXML file 'modification.fxml'.";
        assert piscine != null : "fx:id=\"piscine\" was not injected: check your FXML file 'modification.fxml'.";
        assert jardin != null : "fx:id=\"jardin\" was not injected: check your FXML file 'modification.fxml'.";
        assert superficie_hab != null : "fx:id=\"superficie_hab\" was not injected: check your FXML file 'modification.fxml'.";
        assert nb_etage != null : "fx:id=\"nb_etage\" was not injected: check your FXML file 'modification.fxml'.";
        assert statut_juridique != null : "fx:id=\"statut_juridique\" was not injected: check your FXML file 'modification.fxml'.";
        assert papier_timbre != null : "fx:id=\"papier_timbre\" was not injected: check your FXML file 'modification.fxml'.";
        assert autre != null : "fx:id=\"autre\" was not injected: check your FXML file 'modification.fxml'.";
        assert nb_facade != null : "fx:id=\"nb_facade\" was not injected: check your FXML file 'modification.fxml'.";
        assert prix != null : "fx:id=\"prix\" was not injected: check your FXML file 'modification.fxml'.";
        assert confirmer != null : "fx:id=\"confirmer\" was not injected: check your FXML file 'modification.fxml'.";
        assert adresse != null : "fx:id=\"adresse\" was not injected: check your FXML file 'modification.fxml'.";
        assert wilaya_echange != null : "fx:id=\"wilaya_echange\" was not injected: check your FXML file 'modification.fxml'.";
        assert wil1_ech != null : "fx:id=\"wil1_ech\" was not injected: check your FXML file 'modification.fxml'.";
        assert wil2_ech != null : "fx:id=\"wil2_ech\" was not injected: check your FXML file 'modification.fxml'.";
        assert wil3_ech != null : "fx:id=\"wil3_ech\" was not injected: check your FXML file 'modification.fxml'.";
        assert ascenseur != null : "fx:id=\"ascenseur\" was not injected: check your FXML file 'modification.fxml'.";
        assert type_appart != null : "fx:id=\"type_appart\" was not injected: check your FXML file 'modification.fxml'.";
        assert negociable1 != null : "fx:id=\"negociable1\" was not injected: check your FXML file 'modification.fxml'.";
        Iterator<Bien> it = Client.getListe_Bien().iterator();
        Bien b = null;
        while (it.hasNext())
        {
            b = it.next();
            if (b.show_bien().equals(Main.choix_modif))
                break;
        }
        assert b != null;
        if (b.getNature().equals(Nature.Vente)) vente.setSelected(true);
        if (b.getNature().equals(Nature.Location)) location_.setSelected(true);
        if ((b.getNature().equals(Nature.Echange)))
        {
            echange.setSelected(true);
            if (b.getWilaya_echange().getNum_wilaya() == 1) wil1_ech.setSelected(true);
            if (b.getWilaya_echange().getNum_wilaya() == 2) wil2_ech.setSelected(true);
            if (b.getWilaya_echange().getNum_wilaya() == 3) wil3_ech.setSelected(true);
        }

        nature.setText(b.getNature().toString());
        if (b.getType_bien().equals(Type_bien.Maison)) t_maison.setSelected(true);
        if (b.getType_bien().equals(Type_bien.Appartement)) t_appart.setSelected(true);
        if (b.getType_bien().equals(Type_bien.Terrain)) t_terrain.setSelected(true);

        if (b.getWilaya().getNum_wilaya() == 1) w1.setSelected(true);
        if (b.getWilaya().getNum_wilaya() == 2) w2.setSelected(true);
        if (b.getWilaya().getNum_wilaya() == 3) w3.setSelected(true);

        superficie.setText(Long.toString(b.getSuperficie()));

        if (b.getProprietaire().equals(Main.Prop1)) p1.setSelected(true);
        if (b.getProprietaire().equals(Main.Prop2) ) p2.setSelected(true);
        if (b.getProprietaire().equals(Main.Prop3) ) p3.setSelected(true);
        if (b.getProprietaire().equals(Main.Prop4) ) p4.setSelected(true);

        if (b.isNegociable())
            negociable1.setSelected(true);
        else
            negociable1.setSelected(false);
        prix.setText(Long.toString(b.getPrix()));

        adresse.setText(b.getAdresse());
        if (b.getType_bien().equals(Type_bien.Terrain))
            meuble.setVisible(false);
        else{
            if (b.getType_bien().equals(Type_bien.Maison))
                if (((Maison)b).isMeublees()) meuble.setSelected(true); else meuble.setSelected(false);
            if (b.getType_bien().equals(Type_bien.Appartement))
                if (((Appartement)b).isMeublees()) meuble.setSelected(true); else meuble.setSelected(false);
        }
        if (b.getType_bien().equals(Type_bien.Terrain))
            nb_piece.setVisible(false);
        else{
            if (b.getType_bien().equals(Type_bien.Maison))
                nb_piece.setText(Integer.toString(((Maison)b).getNb_pieces()));
            if (b.getType_bien().equals(Type_bien.Appartement))
                nb_piece.setText(Integer.toString(((Appartement)b).getNb_pieces()));
        }
        if (b.getType_bien().equals(Type_bien.Appartement))
            etage.setText(Integer.toString(((Appartement)b).getetage()));
        else etage.setVisible(false);
        if (b.getType_bien().equals(Type_bien.Appartement))
            if (((Appartement)b).getAscenseur()) ascenseur.setSelected(true); else ascenseur.setSelected(false);
        else ascenseur.setVisible(false);
        if (b.getType_bien().equals(Type_bien.Appartement))
            type_appart.setText(((Appartement)b).getType());
        else type_appart.setVisible(false);

        if (b.getType_bien().equals(Type_bien.Maison))
        {
            if (((Maison)b).isJardin()) jardin.setSelected(true); else jardin.setSelected(false);
            if (((Maison)b).isGarage()) garage.setSelected(true); else garage.setSelected(false);
            if (((Maison)b).isGarage()) piscine.setSelected(true); else piscine.setSelected(false);
        }else {
            equipement.setVisible(false);
        }
        if (b.getType_bien().equals(Type_bien.Maison))
        {
            superficie_hab.setText(Long.toString(((Maison)b).getSuperficie_habitable()));
        }else {
            superficie_hab.setVisible(false);
        }

        if (b.getType_bien().equals(Type_bien.Maison))
        {
            nb_etage.setText(Long.toString(((Maison)b).getNb_etages()));
        }else {
            nb_etage.setVisible(false);
        }

        if (b.getType_bien().equals(Type_bien.Terrain))
        {
            statut_juridique.setText(((Terrain)b).getStatu_juridique().toString());
        }else {
            nb_etage.setVisible(false);
        }
        if (b.getType_bien().equals(Type_bien.Terrain))
        {
            nb_facade.setText(Integer.toString(((Terrain)b).getNb_facades()));
        }else {
            nb_facade.setVisible(false);
        }
        if (b.getType_bien().equals(Type_bien.Terrain))
        {
            if (((Terrain)b).getStatu_juridique().equals(Statut_juridique.Papier_timbré)) papier_timbre.setSelected(true);
            if (((Terrain)b).getStatu_juridique().equals(Statut_juridique.autre)) autre.setSelected(true);
        }
    }
}
