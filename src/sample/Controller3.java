package sample;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Controller3  {

    public TextArea detaille;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize()
    {
        assert detaille != null : "fx:id=\"detaille\" was not injected: check your FXML file 'visualisation.fxml'.";
        detaille.setText(Main.choix);

    }
}
