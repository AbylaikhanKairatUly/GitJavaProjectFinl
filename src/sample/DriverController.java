package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class DriverController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordText;

    @FXML
    private Button ForgotButton;

    @FXML
    private TextField NumberText;

    @FXML
    private Button singInButton;

    @FXML
    private Button singUpButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        singInButton.setOnAction(actionEvent -> {
            String loginText = NumberText.getText().trim();
            String loginPassword = PasswordText.getText().trim();
              getNum(loginText);
            if (!loginText.equals("") && !loginPassword.equals("")) {
                try {
                    loginDriver(loginText, loginPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            } else
                System.out.println("The field is empty!");

        });

        singUpButton.setOnAction(actionEvent -> {
            singUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FxmlFails/DriverRegister.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }



    private void loginDriver(String loginText, String loginPassword) throws SQLException {
        DataBaseHandlerDriver dataBaseHandler = new DataBaseHandlerDriver();

        Driver driver = new Driver();
        driver.setNumber(loginText);
        driver.setPassword(loginPassword);
        ResultSet resultSet = dataBaseHandler.getDriver(driver);
        try {
            if (resultSet.next()) {
                singUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FxmlFails/DriverWindow.fxml"));
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getNum(String num){
       DriverWindow driverWindow = new DriverWindow();
        driverWindow.setNumber(num);
    }

}