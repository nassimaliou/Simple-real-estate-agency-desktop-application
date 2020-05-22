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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kernel.Bien;
import kernel.Client;
import kernel.Type_bien;

public class Controller14 {

    public Button retour10;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField msg_envoie;

    @FXML
    private Button envoi;

    @FXML
    private TextField msg_adr;

    @FXML
    private RadioMenuItem msg_maison;

    @FXML
    private RadioMenuItem msg_appart;

    @FXML
    private RadioMenuItem msg_terrain;

    @FXML
    private RadioMenuItem msg_w1;

    @FXML
    private RadioMenuItem msg_w2;

    @FXML
    private RadioMenuItem msg_w3;

    @FXML
    void envoi_msg(ActionEvent event) {

        int W=0;
        if(msg_w1.isSelected()){W=1; msg_w2.setVisible(false); msg_w3.setVisible(false);}
        if(msg_w2.isSelected()){W=2; msg_w1.setVisible(false); msg_w3.setVisible(false);}
        if(msg_w3.isSelected()){W=3; msg_w2.setVisible(false); msg_w1.setVisible(false);}

        Type_bien T=null;
        if(msg_maison.isSelected()){T=Type_bien.Maison; msg_appart.setVisible(false); msg_terrain.setVisible(false);}
        if(msg_appart.isSelected()){T=Type_bien.Appartement; msg_maison.setVisible(false); msg_terrain.setVisible(false);}
        if(msg_terrain.isSelected()){T=Type_bien.Terrain; msg_appart.setVisible(false); msg_maison.setVisible(false);}

        boolean bool=false;

        Iterator<Bien> iter =Client.getListe_Bien().iterator();
        int i=Main.taille;
        Bien b=null;
            while (iter.hasNext()) {
                b = iter.next();
                if (b.getWilaya().getNum_wilaya() == W && b.getType_bien().equals(T) && b.getAdresse().equals(msg_adr.getText())) {
                    bool = true;
                    break;
                }
            }

            if (bool) {
                Main.Boite[i] = String.join("|", msg_envoie.getText(), b.show_bien(), "\n");
                System.out.println(Main.Boite[i]);
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Ce Bien n'existe pas inserez un bien valable");
                a.show();
            }
        Main.taille++;
    }

    @FXML
    void initialize() {
        assert msg_envoie != null : "fx:id=\"msg_envoie\" was not injected: check your FXML file 'message.fxml'.";
        assert envoi != null : "fx:id=\"envoi\" was not injected: check your FXML file 'message.fxml'.";
        assert msg_adr != null : "fx:id=\"msg_adr\" was not injected: check your FXML file 'message.fxml'.";
        assert msg_maison != null : "fx:id=\"msg_maison\" was not injected: check your FXML file 'message.fxml'.";
        assert msg_appart != null : "fx:id=\"msg_appart\" was not injected: check your FXML file 'message.fxml'.";
        assert msg_terrain != null : "fx:id=\"msg_terrain\" was not injected: check your FXML file 'message.fxml'.";
        assert msg_w1 != null : "fx:id=\"msg_w1\" was not injected: check your FXML file 'message.fxml'.";
        assert msg_w2 != null : "fx:id=\"msg_w2\" was not injected: check your FXML file 'message.fxml'.";
        assert msg_w3 != null : "fx:id=\"msg_w3\" was not injected: check your FXML file 'message.fxml'.";

    }

    public void precedent10(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil_client.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    public void suppr_mouse(MouseEvent mouseEvent) {
        envoi.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    public void suppr_mouse_b(MouseEvent mouseEvent) {
        envoi.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    public void etat_nrml(MouseEvent mouseEvent) {
        if(msg_w1.isSelected()){msg_w2.setVisible(false); msg_w3.setVisible(false);}
        else {msg_w2.setVisible(true); msg_w3.setVisible(true); if(msg_w2.isSelected()){msg_w1.setVisible(false); msg_w3.setVisible(false);}
        else { msg_w1.setVisible(true); msg_w3.setVisible(true); if(msg_w3.isSelected()){msg_w2.setVisible(false); msg_w1.setVisible(false);}
        else{msg_w2.setVisible(true); msg_w1.setVisible(true);}}}

        if(msg_maison.isSelected()){msg_appart.setVisible(false); msg_terrain.setVisible(false);}
        else {msg_appart.setVisible(true); msg_terrain.setVisible(true); if(msg_appart.isSelected()){msg_maison.setVisible(false); msg_terrain.setVisible(false);}
        else { msg_maison.setVisible(true); msg_terrain.setVisible(true); if(msg_terrain.isSelected()){msg_appart.setVisible(false); msg_maison.setVisible(false);}
        else{msg_appart.setVisible(true); msg_maison.setVisible(true);}}}

    }
}
