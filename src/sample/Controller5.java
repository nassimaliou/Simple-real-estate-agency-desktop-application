package sample;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import kernel.*;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller5 {

    public Label wilaya_ech_label;
    public Button retour;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text wilaya_echage_det;

    @FXML
    private Text prenom_prop;

    @FXML
    private Text mail_prop;

    @FXML
    private Text telephone_prop;

    @FXML
    private Text adresse_prop;

    @FXML
    private Text nom_prop;

    @FXML
    private Button afficher_prix_finale;

    @FXML
    private Text type_det;

    @FXML
    private Text nature_det;

    @FXML
    private Text prop_det;

    @FXML
    private Text wilaya_det;

    @FXML
    private Text superficie_det;

    @FXML
    private Text negociable_det;

    @FXML
    private Text adresse_det;

    @FXML
    private Text meuble_det;

    @FXML
    private Text nb_piece_det;

    @FXML
    private Text etage_det;

    @FXML
    private Text asenceur_det;

    @FXML
    private Text type_appart_det;

    @FXML
    private Text equipe_det;

    @FXML
    private Text sup_habitable_det;

    @FXML
    private Text nb_etage_det;

    @FXML
    private Text nb_facade_det;

    @FXML
    private Text statu_det;

    @FXML
    private Text prix_finale_det;

    @FXML
    void afficher_prix_finale(ActionEvent event) {
        Iterator<Bien> Iter = Client.getListe_Bien().iterator();
        Bien b = null;
        while (Iter.hasNext())
        {
            b = Iter.next();
            if (b.show_bien().equals(Main.choix))
                break;
        }
        assert b != null;
        switch (b.getNature())
        {
            case Vente:{
                switch (b.getType_bien())
                {
                    case Maison:{
                        prix_finale_det.setText(Long.toString(((Maison)b).Calcule_prix_vente_finale()));
                    }break;
                    case Appartement:{
                        prix_finale_det.setText(Long.toString(((Appartement)b).Calcule_prix_vente_finale()));
                    }break;
                    case Terrain:{
                        prix_finale_det.setText(Long.toString(((Terrain)b).Calcule_prix_vente_finale()));
                    }break;
                }
            }break;
            case Location:{
                switch (b.getType_bien())
                {
                    case Maison:{
                        prix_finale_det.setText(Long.toString(((Maison)b).Calcule_prix_location_finale()));
                    }break;
                    case Appartement:{
                        prix_finale_det.setText(Long.toString(((Appartement)b).Calcule_prix_location_finale()));
                    }break;
                    case Terrain:{
                        prix_finale_det.setText(Long.toString(((Terrain)b).Calcule_prix_location_finale()));
                    }break;
                }
            }break;
            case Echange:{
                prix_finale_det.setText(Long.toString(b.Calcule_prix_echange_finale(b.getWilaya_echange().getNum_wilaya())));
            }break;
        }
    }

    @FXML
    void initialize() {
        assert afficher_prix_finale != null : "fx:id=\"afficher_prix_finale\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert type_det != null : "fx:id=\"type_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert nature_det != null : "fx:id=\"nature_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert nom_prop != null : "fx:id=\"nom_prop\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert wilaya_det != null : "fx:id=\"wilaya_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert superficie_det != null : "fx:id=\"superficie_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert negociable_det != null : "fx:id=\"negociable_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert adresse_det != null : "fx:id=\"adresse_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert meuble_det != null : "fx:id=\"meuble_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert nb_piece_det != null : "fx:id=\"nb_piece_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert etage_det != null : "fx:id=\"etage_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert asenceur_det != null : "fx:id=\"asenceur_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert type_appart_det != null : "fx:id=\"type_appart_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert equipe_det != null : "fx:id=\"equipe_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert sup_habitable_det != null : "fx:id=\"sup_habitable_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert nb_etage_det != null : "fx:id=\"nb_etage_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert nb_facade_det != null : "fx:id=\"nb_facade_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert statu_det != null : "fx:id=\"statu_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert prix_finale_det != null : "fx:id=\"prix_finale_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert prenom_prop != null : "fx:id=\"prenom_prop\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert mail_prop != null : "fx:id=\"mail_prop\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert telephone_prop != null : "fx:id=\"telephone_prop\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert adresse_prop != null : "fx:id=\"adresse_prop\" was not injected: check your FXML file 'aff_detail.fxml'.";
        assert wilaya_echage_det != null : "fx:id=\"wilaya_echage_det\" was not injected: check your FXML file 'aff_detail.fxml'.";
        Iterator<Bien> Iter = Client.getListe_Bien().iterator();
        Bien b = null;
        while (Iter.hasNext())
        {
            b = Iter.next();
            if (b.show_bien().equals(Main.choix))
                break;
        }
        assert b != null;
        type_det.setText(b.getType_bien().toString());
        nature_det.setText(b.getNature().toString());
        nom_prop.setText(b.getProprietaire().getNom());
        wilaya_det.setText(Integer.toString(b.getWilaya().getNum_wilaya()));
        superficie_det.setText(Long.toString(b.getSuperficie()));
        if (b.isNegociable()) negociable_det.setText("Oui");
        else negociable_det.setText("Non");
        adresse_det.setText(b.getAdresse());
        if (b.getType_bien().equals(Type_bien.Maison) || b.getType_bien().equals(Type_bien.Appartement))
        {
            if (b.getType_bien().equals(Type_bien.Maison))
            {
                if (((Maison)b).isMeublees()) meuble_det.setText("Oui");
                else meuble_det.setText("Non");
            }
            if (b.getType_bien().equals(Type_bien.Appartement))
            {
                if (((Appartement)b).isMeublees()) meuble_det.setText("Oui");
                else meuble_det.setText("Non");
            }
        }else {
            meuble_det.setVisible(false);
        }
        if (b.getType_bien().equals(Type_bien.Terrain)){
            nb_piece_det.setVisible(false);
        }
        else {
            if (b.getType_bien().equals(Type_bien.Maison))
            {
                nb_piece_det.setText(Integer.toString(((Maison)b).getNb_pieces()));
            }
            if (b.getType_bien().equals(Type_bien.Appartement))
            {
                nb_piece_det.setText(Integer.toString(((Appartement)b).getNb_pieces()));
            }
        }
        if (b.getType_bien().equals(Type_bien.Terrain) || b.getType_bien().equals(Type_bien.Maison))
            etage_det.setVisible(false);
        else {
            etage_det.setText(Integer.toString(((Appartement)b).getetage()));
        }
        if (b.getType_bien().equals(Type_bien.Appartement))
        {
            if (((Appartement)b).getAscenseur()) asenceur_det.setText("Oui");
            else asenceur_det.setText("Non");
        }
        else {
            asenceur_det.setVisible(false);
        }
        if (b.getType_bien().equals(Type_bien.Appartement))
        {
            type_appart_det.setText(((Appartement)b).getType());
        }
        else {
            type_appart_det.setVisible(false);
        }
        if (b.getType_bien().equals(Type_bien.Appartement) || b.getType_bien().equals(Type_bien.Terrain)){
            equipe_det.setVisible(false);
        }
        else
        {
            String equipement = "";
            if (((Maison)b).isGarage()) equipement += "Garage ,";
            if (((Maison)b).isJardin()) equipement += "Jardin ,";
            if (((Maison)b).isPicine()) equipement += "Picine ,";
            if (!((Maison)b).isPicine() && !((Maison)b).isGarage() && !((Maison)b).isJardin()) equipement = "Rien";
            equipe_det.setText(equipement);
        }
        if (b.getType_bien().equals(Type_bien.Terrain) ||b.getType_bien().equals(Type_bien.Appartement))
            sup_habitable_det.setVisible(false);
        else {
            sup_habitable_det.setText(Long.toString(((Maison)b).getSuperficie_habitable()));
        }
        if (b.getType_bien().equals(Type_bien.Maison)) {
            nb_etage_det.setText(Integer.toString(((Maison)b).getNb_etages()));
        }
        else {
            nb_etage_det.setVisible(false);
        }
        if (b.getType_bien().equals(Type_bien.Terrain))
        {
            nb_facade_det.setText(Integer.toString(((Terrain)b).getNb_facades()));
            statu_det.setText(((Terrain)b).getStatu_juridique().toString());
        }
        else {
            nb_facade_det.setVisible(false);
            statu_det.setVisible(false);
        }
        prenom_prop.setText(b.getProprietaire().getPrenom());
        mail_prop.setText(b.getProprietaire().getMail());
        telephone_prop.setText(b.getProprietaire().getTelephone());
        adresse_prop.setText(b.getProprietaire().getAdresse());

        if (!b.getNature().equals(Nature.Echange))
        {
            wilaya_ech_label.setVisible(false);
            wilaya_echage_det.setVisible(false);
        }
    }

    public void precedent(ActionEvent actionEvent) throws IOException {
        if(Main.compte){
            Parent root = FXMLLoader.load(getClass().getResource("visualisation.fxml"));
            Scene menu_admin = new Scene(root);
            Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Menu_admin.setScene(menu_admin);
            Menu_admin.show();
        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getResource("visual_client.fxml"));
            Scene menu_admin = new Scene(root);
            Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Menu_admin.setScene(menu_admin);
            Menu_admin.show();
        }
    }
}