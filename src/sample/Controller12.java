package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import kernel.*;

public class Controller12 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> liste_res;

    @FXML
    private Button retour;

    @FXML
    private Button selection;

    @FXML
    void precedent(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("visualisation.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void selectionner(ActionEvent actionEvent) throws IOException {
        Main.choix_modif = liste_res.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("modification.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void initialize() {
        assert liste_res != null : "fx:id=\"liste_res\" was not injected: check your FXML file 'liste_modif.fxml'.";
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'liste_modif.fxml'.";
        assert selection != null : "fx:id=\"selection\" was not injected: check your FXML file 'liste_modif.fxml'.";
        Iterator<Bien> iter = Client.getListe_Bien().iterator();
        while(iter.hasNext())
        {
            liste_res.getItems().add(iter.next().show_bien());
        }
    }
}
