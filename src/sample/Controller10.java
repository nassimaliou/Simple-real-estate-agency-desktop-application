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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kernel.Bien;
import kernel.Client;

public class Controller10 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aff_detail;

    @FXML
    private Button retour2;

    @FXML
    private ListView<String> liste;

    @FXML
    void aff_detail_mouse(MouseEvent event) {
        aff_detail.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void aff_detail_mouse_b(MouseEvent event) {
        aff_detail.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    @FXML
    void affichage_detaillé(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("aff_detail.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();

    }

    @FXML
    void precedent2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil_client.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void initialize() {
        assert aff_detail != null : "fx:id=\"aff_detail\" was not injected: check your FXML file 'visual_client.fxml'.";
        assert retour2 != null : "fx:id=\"retour2\" was not injected: check your FXML file 'visual_client.fxml'.";
        assert liste != null : "fx:id=\"liste\" was not injected: check your FXML file 'visual_client.fxml'.";
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
}
