package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    private Label userLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void greeting(String user){
        userLbl.setText("Hello , "+user);
    }
}
