package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Controller15 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button retour9;

    @FXML
    private TextArea messaaaag;

    @FXML
    void precedent59(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void initialize() {
        assert retour9 != null : "fx:id=\"retour9\" was not injected: check your FXML file 'aff_message_admin.fxml'.";
        assert messaaaag != null : "fx:id=\"messaaaag\" was not injected: check your FXML file 'aff_message_admin.fxml'.";
        for (int i=0 ; i<Main.Boite.length ; i++) {
            if(Main.Boite[i]==null)
                break;
            messaaaag.setText(Main.Boite[i]);
        }
    }
}