package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataBaseClass.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class SignUpController implements Initializable {

    @FXML
    private Button cancel;

    @FXML
    private Button CreatButton;

    @FXML
    private TextField UserName;

    @FXML
    private TextField UserSurname;

    @FXML
    private PasswordField UserPassword;

    @FXML
    private TextField UserEmail;

    @FXML
    private TextField UserNumber;

    @FXML
    private PasswordField UserRPassword;
    @FXML
    void initialize() {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cancel.setOnAction(actionEvent -> {
            openLoginScene("/FxmlFails/Login.fxml");
        });
        CreatButton.setOnAction(actionEvent -> {
            String pas=UserPassword.getText().trim();
            String Rpass=UserRPassword.getText().trim();
            if(pas.equals(Rpass)) {
                signUpNewUser();
                JOptionPane.showMessageDialog(null,"Your account has been created successfully");
            }
            else
                JOptionPane.showMessageDialog(null,"The passwords you entered don't match");

        });
    }
    public void openLoginScene(String window) {
        cancel.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }

    private void signUpNewUser() {

        DataBaseHandler dataBaseHandler= new DataBaseHandler();
        String Name = UserName.getText();
        String Surname = UserSurname.getText();
        String Email = UserEmail.getText();
        String Number = UserNumber.getText();
        String Password = UserPassword.getText();

        User user=new User(Name,Surname,Email,Number,Password);
        PackageData packageData = new PackageData("CREAT USER ACCOUNT",user);

        Main.connectServer(packageData);
    }
}