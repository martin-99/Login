package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public  LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }
        else {
            isConnected.setText("Not connected");
        }

    }
    @FXML
    public void Login(ActionEvent event) {
        try {
            if (loginModel.isLogin(username.getText(), password.getText())) {


                isConnected.setText("Username and password is correct");
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("User.fxml").openStream());
                UserController userController = (UserController) loader.getController();
                primaryStage.setTitle("Hello World");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();

            } else {
                isConnected.setText("Username and password is not correct");

            }
        }catch (SQLException e){
            isConnected.setText("Username and password is not correct");
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void Loggin(){
        System.out.println("d");
    }
}
