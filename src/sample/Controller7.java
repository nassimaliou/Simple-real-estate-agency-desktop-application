package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller7 {

    public Button rech_critere;
    public Button message;
    public Button visual_liste_b;

    @FXML
    void op1_mouse(MouseEvent event) {
    visual_liste_b.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op1_mouse_b(MouseEvent event) {
    visual_liste_b.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    @FXML
    void op2_mouse(MouseEvent event) {
        rech_critere.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op2_mouse_b(MouseEvent event) {
        rech_critere.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    @FXML
    void op3_mouse(MouseEvent event) {
        message.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op3_mouse_b(MouseEvent event) {
        message.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }
    
    public void visualisation_liste_bien(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("visual_client.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    public void recherche(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("recherche.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void precedent(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin_client.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    public void envoyer_msg(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("message.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }
}
