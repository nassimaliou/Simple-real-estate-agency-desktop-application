package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    public Button retour3;
    public Button retour4;
    public Button retour7;
    public Button msg;
    @FXML
    private ResourceBundle resources;

    @FXML
    private Button client;

    @FXML
    private Button admin;

    @FXML
    private URL location;

    @FXML
    private PasswordField mot_de_passe = null;

    @FXML
    private Button connexion;

    @FXML
    private Button quitter;

    @FXML
    private TextField pseudo;

    @FXML
    private Button retour;

    @FXML
    private Button op1;

    @FXML
    private Button op2;

    @FXML
    private Button op3;

    @FXML
    private Button op4;

    @FXML
    private Button op5;

    @FXML
    private Button op6;

    @FXML
    private Button op8;

    @FXML
    private Button op7;

    @FXML
    void open_admin(ActionEvent actionEvent) throws IOException {

        if (verif_mdps(mot_de_passe.getText(),pseudo.getText())) {
            Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
            Scene menu_admin = new Scene(root);
            Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Menu_admin.setScene(menu_admin);
            Menu_admin.show();
        }
        else
        {
            Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("Mot de passe ou/et psuedo erroné");
            a.show();
        }
    }

    @FXML
    void initialize() {
        assert mot_de_passe != null : "fx:id=\"mot_de_passe\" was not injected: check your FXML file 'two.fxml'.";
        assert connexion != null : "fx:id=\"connexion\" was not injected: check your FXML file 'two.fxml'.";
        assert quitter != null : "fx:id=\"quitter\" was not injected: check your FXML file 'two.fxml'.";
        assert pseudo != null : "fx:id=\"pseudo\" was not injected: check your FXML file 'two.fxml'.";
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'acceuil.fxml'.";
        assert op1 != null : "fx:id=\"op1\" was not injected: check your FXML file 'acceuil.fxml'.";
        assert op2 != null : "fx:id=\"op2\" was not injected: check your FXML file 'acceuil.fxml'.";
        assert op3 != null : "fx:id=\"op3\" was not injected: check your FXML file 'acceuil.fxml'.";
    }

    private boolean verif_mdps(String mdps,String psd)
    {
        boolean etat = false;
        if (mdps.equals("admin") && psd.equals("admin"))
            etat = true;
        return etat;
    }

    public void mot_passe(ActionEvent actionEvent) {
        mot_de_passe.getText();
        System.out.println(mot_de_passe.getText());
    }

    public void hover(MouseEvent mouseEvent) {
            if (connexion.hoverProperty().get()) {
                connexion.setStyle(" -fx-cursor: hand; -fx-background-color: #7aa1d0; -fx-background-radius: 1; -fx-text-fill: #ffffff;");
            }
    }

    public void mouse_b(MouseEvent mouseEvent) {
        connexion.setStyle("-fx-cursor: hand; -fx-background-color: #0000; -fx-border-color: #000000; -fx-background-radius: 1;");
    }

    public void quitter(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    void admin(ActionEvent actionEvent) throws IOException {
        Main.compte=true;
        Parent root = FXMLLoader.load(getClass().getResource("admin_login.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    @FXML
    void client(ActionEvent actionEvent) throws IOException {
        Main.compte=false;
        Parent root = FXMLLoader.load(getClass().getResource("client_login.fxml"));
        Scene menu_client = new Scene(root);
        Stage Menu_client = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_client.setScene(menu_client);
        Menu_client.show();
    }

    public void op3_mouse(MouseEvent mouseEvent) {
        op3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    public void op3_mouse_b(MouseEvent mouseEvent) {
        op3.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }
    public void op1_mouse(MouseEvent mouseEvent) {
        op1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    public void op1_mouse_b(MouseEvent mouseEvent) {
        op1.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }
    public void op2_mouse(MouseEvent mouseEvent) {
        op2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    public void op2_mouse_b(MouseEvent mouseEvent) {
        op2.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }
    @FXML
    void op4_mouse(MouseEvent event) {
        op4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op4_mouse_b(MouseEvent event) {
        op4.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    @FXML
    void op5_mouse(MouseEvent event) {
        op5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op5_mouse_b(MouseEvent event) {
        op5.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    @FXML
    void op6_mouse(MouseEvent event) {
        op6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op6_mouse_b(MouseEvent event) {
        op6.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    @FXML
    void op7_mouse(MouseEvent event) {
        op7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op7_mouse_b(MouseEvent event) {
        op7.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    @FXML
    void op8_mouse(MouseEvent event) {
        op8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    @FXML
    void op8_mouse_b(MouseEvent event) {
        op8.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }

    public void precedent(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin_login.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    public void visualisation_liste_bien(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("visualisation.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void ajout_bien(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("ajout_bien.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void open_client(ActionEvent actionEvent) throws IOException {
        if(pseudo.getText().equals("client") || pseudo.getText().equals("Client")) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("acceuil_client.fxml"));
            Parent root = (Parent) loader.load();
            Scene visualisation = new Scene(root);
            Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Visualisation.setScene(visualisation);
            Visualisation.show();
        }
        else
        {
            Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("Entrez un pseudo correcte");
            a.show();
        }
    }

    public void aff_archive(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("aff_archv.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void precedent3(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin_client.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    public void precedent4(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin_client.fxml"));
        Scene menu_admin = new Scene(root);
        Stage Menu_admin = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Menu_admin.setScene(menu_admin);
        Menu_admin.show();
    }

    public void visu_prop(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("visu_prop.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void rech_admin(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("recherche.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void aff_boite(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("aff_message_admin.fxml"));
        Parent root = (Parent)loader.load();
        Scene visualisation = new Scene(root);
        Stage Visualisation = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Visualisation.setScene(visualisation);
        Visualisation.show();
    }

    public void opmsg_mouse(MouseEvent mouseEvent) {
        msg.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 1; -fx-text-fill: #000000; ");
    }

    public void opmsg_mouse_b(MouseEvent mouseEvent) {
        msg.setStyle("-fx-background-color: #131965; textFill: #ffffff; ");
    }
}

