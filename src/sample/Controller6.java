package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kernel.*;

import java.io.IOException;
import java.util.Iterator;

public class Controller6 {

    @FXML
    private Button retour;

    @FXML
    private Button confirmer;

    @FXML
    private RadioButton b_maison;

    @FXML
    private RadioButton b_appart;

    @FXML
    private RadioButton b_terrain;

    @FXML
    private TextField prix_min;

    @FXML
    private TextField prix_max;

    @FXML
    private RadioButton w1_rech;

    @FXML
    private RadioButton w2_rech;

    @FXML
    private RadioButton w3_rech;

    @FXML
    private MenuButton nature_t;

    @FXML
    private RadioMenuItem vente1;

    @FXML
    private RadioMenuItem location_1;

    @FXML
    private RadioMenuItem echange1;

    @FXML
    private MenuButton wilaya_echange_rech;

    @FXML
    private RadioMenuItem wil1_ech1;

    @FXML
    private RadioMenuItem wil2_ech1;

    @FXML
    private RadioMenuItem wil3_ech1;

    @FXML
    private TextField superficie_min;

    @FXML
    private TextField nb_pièces_min;

    @FXML
    void initialize() {
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'recherche.fxml'.";
        assert confirmer != null : "fx:id=\"confirmer\" was not injected: check your FXML file 'recherche.fxml'.";
        assert b_maison != null : "fx:id=\"b_maison\" was not injected: check your FXML file 'recherche.fxml'.";
        assert b_appart != null : "fx:id=\"b_appart\" was not injected: check your FXML file 'recherche.fxml'.";
        assert b_terrain != null : "fx:id=\"b_terrain\" was not injected: check your FXML file 'recherche.fxml'.";
        assert prix_min != null : "fx:id=\"prix_min\" was not injected: check your FXML file 'recherche.fxml'.";
        assert prix_max != null : "fx:id=\"prix_max\" was not injected: check your FXML file 'recherche.fxml'.";
        assert w1_rech != null : "fx:id=\"w1_rech\" was not injected: check your FXML file 'recherche.fxml'.";
        assert w2_rech != null : "fx:id=\"w2_rech\" was not injected: check your FXML file 'recherche.fxml'.";
        assert w3_rech != null : "fx:id=\"w3_rech\" was not injected: check your FXML file 'recherche.fxml'.";
        assert nature_t != null : "fx:id=\"nature_t\" was not injected: check your FXML file 'recherche.fxml'.";
        assert vente1 != null : "fx:id=\"vente1\" was not injected: check your FXML file 'recherche.fxml'.";
        assert location_1 != null : "fx:id=\"location_1\" was not injected: check your FXML file 'recherche.fxml'.";
        assert echange1 != null : "fx:id=\"echange1\" was not injected: check your FXML file 'recherche.fxml'.";
        assert wilaya_echange_rech != null : "fx:id=\"wilaya_echange_rech\" was not injected: check your FXML file 'recherche.fxml'.";
        assert wil1_ech1 != null : "fx:id=\"wil1_ech1\" was not injected: check your FXML file 'recherche.fxml'.";
        assert wil2_ech1 != null : "fx:id=\"wil2_ech1\" was not injected: check your FXML file 'recherche.fxml'.";
        assert wil3_ech1 != null : "fx:id=\"wil3_ech1\" was not injected: check your FXML file 'recherche.fxml'.";
        assert superficie_min != null : "fx:id=\"superficie_min\" was not injected: check your FXML file 'recherche.fxml'.";
        assert nb_pièces_min != null : "fx:id=\"nb_pièces_min\" was not injected: check your FXML file 'recherche.fxml'.";

    }

    @FXML
    void etat_normal(MouseEvent event) {

        if(b_terrain.isSelected())
            nb_pièces_min.setVisible(false);
        else
            nb_pièces_min.setVisible(true);

        if (echange1.isSelected())
            wilaya_echange_rech.setVisible(true);
        else
            wilaya_echange_rech.setVisible(false);
    }

    @FXML
    void precedent(ActionEvent event) throws IOException {
        if(Main.compte)
        {
            Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
            Scene menu_admin = new Scene(root);
            Stage Menu_admin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Menu_admin.setScene(menu_admin);
            Menu_admin.show();
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("acceuil_client.fxml"));
            Scene menu_admin = new Scene(root);
            Stage Menu_admin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Menu_admin.setScene(menu_admin);
            Menu_admin.show();
        }
    }

    public void lancer_recherche(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("resultat_rech.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void recherche_filtre(MouseEvent mouseEvent) {
        int i=0;
        Bien b;
        Iterator<Bien> iter=Client.getListe_Bien().iterator();

        while (iter.hasNext()) {
            b = iter.next();

            if ((!b_maison.isSelected()) && (!b_terrain.isSelected()) && (!b_appart.isSelected())) {
                break;
            }
            if (b.getType_bien().equals(Type_bien.Maison)) {
                if (!b_maison.isSelected()) {

                    Main.tab_bien[i]=b;
                    i++;
                }
            }
            else {
                if (b.getType_bien().equals(Type_bien.Terrain)) {
                    if (!b_terrain.isSelected()) {

                        Main.tab_bien[i]=b;
                        i++;
                    }
                }
                else {
                    if (b.getType_bien().equals(Type_bien.Appartement)) {
                        if (!b_appart.isSelected()) {

                            Main.tab_bien[i]=b;
                            i++;
                        }
                    }
                }
            }

        }

        iter=Client.getListe_Bien().iterator();

        while (iter.hasNext()) {
            b = iter.next();

            if ((!vente1.isSelected()) && (!location_1.isSelected()) && (!echange1.isSelected())) {
                break;
            }
            if (b.getNature().equals(Nature.Vente)) {
                if (!vente1.isSelected()) {
                        Main.tab_bien[i] = b;
                        i++;
                }
            }
            else {
                if (b.getNature().equals(Nature.Location)) {
                    if (!location_1.isSelected()) {
                            Main.tab_bien[i]=b;
                            i++;
                    }
                }
                else {
                    if (b.getNature().equals(Nature.Echange)) {
                        if (!echange1.isSelected()) {
                                Main.tab_bien[i] = b;
                                i++;
                        }
                        else
                        {
                            if ((!wil1_ech1.isSelected()) && (!wil2_ech1.isSelected()) && (!wil3_ech1.isSelected())) {
                                break;
                            }
                            if (b.getWilaya_echange().getNum_wilaya()==1) {
                                if (!wil1_ech1.isSelected()) {
                                    Main.tab_bien[i] = b;
                                    i++;
                                }
                            }
                            else {
                                if (b.getWilaya_echange().getNum_wilaya()==2) {
                                    if (!wil2_ech1.isSelected()) {
                                        Main.tab_bien[i]=b;
                                        i++;
                                    }
                                }
                                else {
                                    if (b.getWilaya_echange().getNum_wilaya()==3) {
                                        if (!wil3_ech1.isSelected()) {
                                            Main.tab_bien[i] = b;
                                            i++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        iter=Client.getListe_Bien().iterator();

        while (iter.hasNext()) {
            b = iter.next();

            if ((!w1_rech.isSelected()) && (!w2_rech.isSelected()) && (!w3_rech.isSelected())) {
                break;
            }
            if (b.getWilaya().getNum_wilaya()==1) {
                if (!w1_rech.isSelected()) {
                        Main.tab_bien[i] = b;
                        i++;
                }
            }
            else {
                if (b.getWilaya().getNum_wilaya()==2) {
                    if (!w2_rech.isSelected()) {
                            Main.tab_bien[i]=b;
                            i++;
                    }
                }
                else {
                    if (b.getWilaya().getNum_wilaya()==3) {
                        if (!w3_rech.isSelected()) {
                                Main.tab_bien[i] = b;
                                i++;
                        }
                    }
                }
            }

        }

        iter=Client.getListe_Bien().iterator();

        while (iter.hasNext()) {
            b = iter.next();

            if ((prix_max.getText().equals("")) && (prix_min.getText().equals(""))) {
                break;
            }
            if (!prix_min.getText().equals("")) {
                if (b.getPrix()<Integer.parseInt(prix_min.getText())) {

                        Main.tab_bien[i] = b;
                        i++;
                }
            }
            if (!prix_max.getText().equals("")) {
                if (b.getPrix()>Integer.parseInt(prix_max.getText())) {
                        Main.tab_bien[i] = b;
                        i++;
                }
            }
        }

        iter=Client.getListe_Bien().iterator();

        while (iter.hasNext()) {
            b = iter.next();

            if (!superficie_min.getText().equals("")) {
                if (b.getSuperficie() < Integer.parseInt(superficie_min.getText())) {
                        Main.tab_bien[i] = b;
                        i++;
                }
            }
            else
                break;

        }

        iter=Client.getListe_Bien().iterator();

        if(b_maison.isSelected() || b_appart.isSelected()) {
            nb_pièces_min.setVisible(true);
            while (iter.hasNext()) {
                b = iter.next();

                if (!nb_pièces_min.getText().equals("")) {
                    if(b.getType_bien().equals(Type_bien.Maison)) {
                        if (((Maison) b).getNb_pieces() < Integer.parseInt(superficie_min.getText())) {
                                Main.tab_bien[i] = b;
                                i++;
                        }
                    }
                    else
                    {
                        if(b.getType_bien().equals(Type_bien.Appartement)) {
                            if (((Appartement) b).getNb_pieces() < Integer.parseInt(superficie_min.getText())) {
                                    Main.tab_bien[i] = b;
                                    i++;
                            }
                        }
                    }
                } else
                    break;

            }
        }

    }
}
