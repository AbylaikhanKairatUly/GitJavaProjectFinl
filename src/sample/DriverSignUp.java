package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DataBaseClass.DataBaseHandlerDriver;
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

public class DriverSignUp implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private PasswordField DriverPassword;

    @FXML
    private TextField PIN;

    @FXML
    private Button DriverCreatAcc;

    @FXML
    private TextField DriverName;

    @FXML
    private Button DriverCancelButton;

    @FXML
    private TextField DriverNumber;

    @FXML
    private TextField DriversCarModel;

    @FXML
    private TextField DriverSurname;

    @FXML
    private TextField CarsNumber;

    @FXML
    private PasswordField DriverRPassword;
    @FXML
    void initialize() {

    }
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
       DriverCancelButton.setOnAction(actionEvent -> {
            openSingInScene("/FxmlFails/DriverScene.fxml");
        });

        DriverCreatAcc.setOnAction(actionEvent -> {
            String pas=DriverPassword.getText().trim();
            String Rpass=DriverRPassword.getText().trim();
            if(pas.equals(Rpass)) {
                signUpNewDriver();
                JOptionPane.showMessageDialog(null,"Your account has been created successfully");
            }
            else
                JOptionPane.showMessageDialog(null,"The passwords you entered don't match");


        });

    }
    public void openSingInScene(String window) {
        DriverCancelButton.getScene().getWindow().hide();
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
    private void signUpNewDriver() {
        DataBaseHandlerDriver dataBaseHandler= new DataBaseHandlerDriver();
        String Name = DriverName.getText();
        String Surname = DriverSurname.getText();
        String IIN=PIN.getText();
        String CarModel=DriversCarModel.getText();
        String CarNumber=CarsNumber.getText();
        String Number = DriverNumber.getText();
        String Password = DriverPassword.getText();

        Driver driver=new Driver(Name,Surname,IIN,CarModel,CarNumber,Number,Password);
        PackageData packageData = new PackageData("CREAT DRIVER ACCOUNT",driver);
        Main.connectServer(packageData);
    }
}
