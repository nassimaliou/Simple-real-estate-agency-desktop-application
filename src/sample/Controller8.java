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

import javax.swing.text.html.HTMLDocument;

public class Controller8 {

    public Button retour;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> liste_res;

    @FXML
    void initialize() {
        assert liste_res != null : "fx:id=\"liste_res\" was not injected: check your FXML file 'resultat_rech.fxml'.";
        Iterator<Bien> iter=Client.getListe_Bien().iterator();
        Bien b;
        Boolean bool;

        while(iter.hasNext()) {
            int i=0;
            bool=true;
            b=iter.next();
            while(i < Main.tab_bien.length)
            {
                if(Main.tab_bien[i]==null)
                    break;
                if(Main.tab_bien[i].equals(b))
                {
                    bool=false;
                    break;
                }
                i++;
            }

            if(bool)
                liste_res.getItems().add(b.show_bien());
        }

    }

    public void precedent(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("recherche.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }
}