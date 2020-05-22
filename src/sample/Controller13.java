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

public class Controller13{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button retour7;

    @FXML
    private ListView<String> liste_prop;

    @FXML
    private ListView<String> liste_bien_prop;

    @FXML
    private Button consulter;

    @FXML
    void consultation(ActionEvent event) {
        Boolean bool=false;
        Main.chaine_prop = liste_prop.getSelectionModel().getSelectedItem();
        liste_bien_prop.getItems().clear();
        Iterator<Bien> iter = Client.getListe_Bien().iterator();
        Bien b = null;
        while(iter.hasNext())
        {
            b = iter.next();
            if (b.getProprietaire().show_prop().equals(Main.chaine_prop))
            {
                bool=true;
                break;
            }
        }
        assert b != null;
        if(bool){
            Proprietaire p = b.getProprietaire();
            iter = Client.getListe_Bien().iterator();
            while(iter.hasNext())
            {
                Bien bb = iter.next();
                if (bb.getProprietaire().equals(p))
                {
                    liste_bien_prop.getItems().add(bb.show_bien());
                }
            }
        }
    }

    @FXML
    void precedent7(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void initialize() {
        assert retour7 != null : "fx:id=\"retour7\" was not injected: check your FXML file 'visu_prop.fxml'.";
        assert liste_prop != null : "fx:id=\"liste_prop\" was not injected: check your FXML file 'visu_prop.fxml'.";
        assert liste_bien_prop != null : "fx:id=\"liste_bien_prop\" was not injected: check your FXML file 'visu_prop.fxml'.";
        assert consulter != null : "fx:id=\"consulter\" was not injected: check your FXML file 'visu_prop.fxml'.";
        liste_prop.getItems().add(Main.Prop1.show_prop());
        liste_prop.getItems().add(Main.Prop2.show_prop());
        liste_prop.getItems().add(Main.Prop3.show_prop());
        liste_prop.getItems().add(Main.Prop4.show_prop());
    }
}
