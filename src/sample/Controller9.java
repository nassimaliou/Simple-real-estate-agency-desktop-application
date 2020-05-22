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
import kernel.Bien;
import kernel.Client;

public class Controller9 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button retour2;

    @FXML
    private ListView<String> liste;

    @FXML
    void precedent2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();

    }

    @FXML
    void initialize() {
        assert retour2 != null : "fx:id=\"retour2\" was not injected: check your FXML file 'aff_archv.fxml'.";
        assert liste != null : "fx:id=\"liste\" was not injected: check your FXML file 'aff_archv.fxml'.";
        Iterator<Bien> Iter = Client.getListe_Bien().iterator();
        while (Iter.hasNext())
        {
            Bien b = Iter.next();
            if (b.isArchive())
            {
                liste.getItems().add(b.show_bien());
            }
        }
    }
}
