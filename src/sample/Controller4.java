package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kernel.*;

public class Controller4 {

    public TextField adresse;
    public MenuButton wilaya_echange;
    public RadioMenuItem vente;
    public RadioMenuItem echange;
    public RadioMenuItem location_;
    public RadioMenuItem w1;
    public RadioMenuItem w2;
    public RadioMenuItem w3;
    public RadioMenuItem p1;
    public RadioMenuItem p2;
    public RadioMenuItem p3;
    public RadioMenuItem p4;
    public RadioMenuItem ajout_prop;
    public RadioButton ascenseur;
    public RadioMenuItem autre;
    public RadioMenuItem papier_timbre;
    public RadioMenuItem wil3_ech;
    public RadioMenuItem wil2_ech;
    public RadioMenuItem wil1_ech;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button op1;

    @FXML
    private Button op3;

    @FXML
    private Button op4;

    @FXML
    private Button op5;

    @FXML
    private Button op6;

    @FXML
    private Button op7;

    @FXML
    private Button op8;

    @FXML
    private Button op2;

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
    private MenuButton wilaya;

    @FXML
    private TextField superficie;

    @FXML
    private RadioButton negociable;

    @FXML
    private RadioButton meuble;

    @FXML
    private TextField nb_piece;

    @FXML
    private TextField etage;

    @FXML
    private TextField type_appart;

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
    private TextField nb_facade;

    @FXML
    private TextField prix;

    @FXML
    private Button confirmer;


    @FXML
    void op1_mouse(MouseEvent event) {

    }

    @FXML
    void op1_mouse_b(MouseEvent event) {

    }

    @FXML
    void op2_mouse(MouseEvent event) {

    }

    @FXML
    void op2_mouse_b(MouseEvent event) {

    }

    @FXML
    void op3_mouse(MouseEvent event) {

    }

    @FXML
    void op3_mouse_b(MouseEvent event) {

    }

    @FXML
    void op4_mouse(MouseEvent event) {

    }

    @FXML
    void op4_mouse_b(MouseEvent event) {

    }

    @FXML
    void op5_mouse(MouseEvent event) {

    }

    @FXML
    void op5_mouse_b(MouseEvent event) {

    }

    @FXML
    void op6_mouse(MouseEvent event) {

    }

    @FXML
    void op6_mouse_b(MouseEvent event) {

    }

    @FXML
    void op7_mouse(MouseEvent event) {

    }

    @FXML
    void op7_mouse_b(MouseEvent event) {

    }

    @FXML
    void op8_mouse(MouseEvent event) {

    }

    @FXML
    void op8_mouse_b(MouseEvent event) {

    }


    @FXML
    void initialize() {
        assert op1 != null : "fx:id=\"op1\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert op3 != null : "fx:id=\"op3\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert op4 != null : "fx:id=\"op4\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert op5 != null : "fx:id=\"op5\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert op6 != null : "fx:id=\"op6\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert op7 != null : "fx:id=\"op7\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert op8 != null : "fx:id=\"op8\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert op2 != null : "fx:id=\"op2\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert type_bien != null : "fx:id=\"type_bien\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert t_maison != null : "fx:id=\"t_maison\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert t_terrain != null : "fx:id=\"t_terrain\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert t_appart != null : "fx:id=\"t_appart\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert nature != null : "fx:id=\"nature\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert wilaya != null : "fx:id=\"wilaya\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert superficie != null : "fx:id=\"superficie\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert negociable != null : "fx:id=\"negociable\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert meuble != null : "fx:id=\"meuble\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert nb_piece != null : "fx:id=\"nb_piece\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert etage != null : "fx:id=\"etage\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert type_appart != null : "fx:id=\"type_appart\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert equipement != null : "fx:id=\"equipement\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert garage != null : "fx:id=\"garage\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert piscine != null : "fx:id=\"piscine\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert jardin != null : "fx:id=\"jardin\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert superficie_hab != null : "fx:id=\"superficie_hab\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert nb_etage != null : "fx:id=\"nb_etage\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert statut_juridique != null : "fx:id=\"statut_juridique\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert nb_facade != null : "fx:id=\"nb_facade\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert prix != null : "fx:id=\"prix\" was not injected: check your FXML file 'ajout_bien.fxml'.";
        assert confirmer != null : "fx:id=\"confirmer\" was not injected: check your FXML file 'ajout_bien.fxml'.";

        wilaya_echange.setVisible(false);
    }

    public void etat_normal(MouseEvent mouseEvent)
    {
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
    void precedent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    public void ajout_de_bien(ActionEvent actionEvent) {
        int i = 0;
        methode : while (i == 0) {
            Proprietaire prop = null;
            Date d = new Date();

            if (p1.isSelected()) {
                prop = Main.Prop1;
            } else {
                if (p2.isSelected()) {
                    prop = Main.Prop2;
                } else {
                    if (p3.isSelected()) {
                        prop = Main.Prop3;
                    }
                }
            }

            Wilaya wil_choisie = null;

            if (w1.isSelected()) {
                wil_choisie = Main.wilaya1;
            } else {
                if (w2.isSelected()) {
                    wil_choisie = Main.wilaya2;
                } else {
                    if (w3.isSelected()) {
                        wil_choisie = Main.wilaya3;
                    }
                }
            }

            Nature n = null;

            if (vente.isSelected()) {
                n = Nature.Vente;
            } else {
                if (location_.isSelected()) {
                    n = Nature.Location;
                } else {
                    if (echange.isSelected()) {
                        n = Nature.Echange;
                    }
                }
            }

            Statut_juridique statut = null;

            if (papier_timbre.isSelected()) {
                statut = Statut_juridique.Papier_timbré;
            } else if (autre.isSelected()) {
                statut = Statut_juridique.autre;
            }

            if (t_maison.isSelected()) {
                Boolean bool = true;
                Maison m = null;
                while (bool) {
                    try {
                        m = new Maison(Integer.parseInt(nb_etage.getText()), garage.isSelected(), jardin.isSelected(), piscine.isSelected(), Long.parseLong(superficie_hab.getText()), Integer.parseInt(nb_etage.getText()), meuble.isSelected(), adresse.getText(), Long.parseLong(superficie.getText()), Long.parseLong(prix.getText()), prop, d, wil_choisie, negociable.isSelected(), n, Type_bien.Maison);
                        bool = false;
                    } catch (Exeption_superficie e) {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setContentText("Surface ou surface habitable incorecte");
                        a.show();
                        superficie_hab.setText(superficie.getText());
                        break methode;
                    }
                }
                if (m.getNature().equals(Nature.Echange)) {
                    if (wil1_ech.isSelected()) m.setWilaya_echange(Main.wilaya1);
                    if (wil2_ech.isSelected()) m.setWilaya_echange(Main.wilaya2);
                    if (wil3_ech.isSelected()) m.setWilaya_echange(Main.wilaya3);
                }
                Client.getListe_Bien().add(m);
            } else {
                if (t_appart.isSelected()) {
                    Appartement a = new Appartement(Integer.parseInt(etage.getText()), type_appart.getText(), ascenseur.isSelected(), Integer.parseInt(nb_piece.getText()), meuble.isSelected(), adresse.getText(), Long.parseLong(superficie.getText()), Long.parseLong(prix.getText()), prop, d, wil_choisie, negociable.isSelected(), n, Type_bien.Appartement);
                    if (a.getNature().equals(Nature.Echange)) {
                        if (wil1_ech.isSelected()) a.setWilaya_echange(Main.wilaya1);
                        if (wil2_ech.isSelected()) a.setWilaya_echange(Main.wilaya2);
                        if (wil3_ech.isSelected()) a.setWilaya_echange(Main.wilaya3);
                    }
                    Client.getListe_Bien().add(a);
                } else {
                    if (t_terrain.isSelected()) {
                        Terrain t = new Terrain(statut, Integer.parseInt(nb_facade.getText()), adresse.getText(), Long.parseLong(superficie.getText()), Long.parseLong(prix.getText()), prop, d, wil_choisie, negociable.isSelected(), n, Type_bien.Terrain);
                        if (t.getNature().equals(Nature.Echange)) {
                            if (wil1_ech.isSelected()) t.setWilaya_echange(Main.wilaya1);
                            if (wil2_ech.isSelected()) t.setWilaya_echange(Main.wilaya2);
                            if (wil3_ech.isSelected()) t.setWilaya_echange(Main.wilaya3);
                        }
                        Client.getListe_Bien().add(t);
                    }
                }
            }
            i++;
        }
    }
}
