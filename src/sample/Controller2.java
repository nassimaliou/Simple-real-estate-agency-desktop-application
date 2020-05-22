package sample;

import javafx.scene.control.TextArea;
import kernel.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kernel.Client;


import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Controller2
{
    public Button supprimer;
    public Button annuler;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    public ListView<String> liste;


    @FXML
    private Button aff_detail;

    @FXML
    private Button retour2;
    @FXML
    private Button archive_b;

    @FXML
    private Button modif_b;

    @FXML
    private Button supp_b;


    @FXML
    void initialize() {
        assert liste != null : "fx:id=\"liste\" was not injected: check your FXML file 'visualisation.fxml'.";
        assert aff_detail != null : "fx:id=\"aff_detail\" was not injected: check your FXML file 'visualisation.fxml'.";
        assert retour2 != null : "fx:id=\"retour2\" was not injected: check your FXML file 'visualisation.fxml'.";
        assert archive_b != null : "fx:id=\"archive_b\" was not injected: check your FXML file 'visualisation.fxml'.";
        assert modif_b != null : "fx:id=\"modif_b\" was not injected: check your FXML file 'visualisation.fxml'.";
        assert supp_b != null : "fx:id=\"supp_b\" was not injected: check your FXML file 'visualisation.fxml'.";
        Iterator<Bien> Iter = Client.getListe_Bien().iterator();
        while (Iter.hasNext())
        {
            Bien b = Iter.next();
            if (!b.isArchive())
            {
                liste.getItems().add(b.show_bien());
            }
        }
    }

    public void precedent2(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void aff_detail_mouse(MouseEvent event) { aff_detail.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");  Main.choix=liste.getSelectionModel().getSelectedItem(); }

    @FXML
    void aff_detail_mouse_b(MouseEvent event) {aff_detail.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");

    }

    @FXML
    void archive_b_mouse(MouseEvent event) { archive_b.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");

    }

    @FXML
    void archive_b_mouse_b(MouseEvent event) {archive_b.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");

    }

    @FXML
    void modif_b_mouse(MouseEvent event) {modif_b.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");

    }

    @FXML
    void modif_b_mouse_b(MouseEvent event) {modif_b.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");

    }


    @FXML
    void supp_b_mouse(MouseEvent event) {supp_b.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");

    }

    @FXML
    void supp_b_mouse_b(MouseEvent event) { supp_b.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");

    }

    public void affichage_detaillé(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("aff_detail.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void archiver(ActionEvent actionEvent) throws IndexOutOfBoundsException {
        Iterator<Bien> Iter = Client.getListe_Bien().iterator();
        while (Iter.hasNext())
        {
            Bien b = Iter.next();
            if (b.show_bien().equals(liste.getSelectionModel().getSelectedItem()))
            {
                b.archiver_bien();
                break;
            }
        }
        try{System.out.println(liste.getItems().remove(liste.getSelectionModel().getSelectedItem()));}
        catch (IndexOutOfBoundsException e)
        {
            liste.getItems().clear();
        }
    }

    public void supp_bien(ActionEvent actionEvent) throws IOException {
        Iterator<Bien> Iter = Client.getListe_Bien().iterator();
        while (Iter.hasNext())
        {
            Bien b = Iter.next();
            if (b.show_bien().equals(liste.getSelectionModel().getSelectedItem()))
            {
                Client.getListe_Bien().remove(b);
                break;
            }
        }
        try{System.out.println(liste.getItems().remove(liste.getSelectionModel().getSelectedItem()));}
        catch (IndexOutOfBoundsException e)
        {
            liste.getItems().clear();
        }
    }

    public void modifier_(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("liste_modif.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }



    /*public void conf_sup(ActionEvent actionEvent) throws IOException {
        Iterator<Bien> Iter = Client.getListe_Bien().iterator();
        while (Iter.hasNext())
        {
            Bien b = Iter.next();
            if (b.show_bien().equals(liste.getSelectionModel().getSelectedItem()))
            {
                Client.getListe_Bien().remove(b);
                break;
            }
        }
        try{System.out.println(liste.getItems().remove(liste.getSelectionModel().getSelectedItem()));}
        catch (IndexOutOfBoundsException e)
        {
            liste.getItems().clear();
        }
        Iterator<Bien> ii = Client.getListe_Bien().iterator();
        while (ii.hasNext())
        {
            System.out.println(ii.next().show_bien());
        }
        Parent root = FXMLLoader.load(getClass().getResource("visualisation.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }*/

    /*public void annu_sup(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("visualisation.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }*/
}
