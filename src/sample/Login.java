package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Login  implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignUPUser;

    @FXML
    private Button ForgotUser;

    @FXML
    private Button LogInUser;

    @FXML
    private PasswordField UserPassword;



    @FXML
    public TextField UserNumber;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LogInUser.setOnAction(actionEvent -> {
            String loginText = UserNumber.getText().trim();
            String loginPassword = UserPassword.getText().trim();
            getNum(loginText);
            if (!loginText.equals("") && !loginPassword.equals("")) {
                try {
                    loginUser(loginText, loginPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            } else
                System.out.println("The field is empty!");

        });

        SignUPUser.setOnAction(actionEvent -> {
            SignUPUser.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FxmlFails/SignUpScene.fxml"));
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




    private void loginUser(String loginText, String loginPassword) throws SQLException {
        DataBaseHandler dbHandler = new DataBaseHandler();

        User user = new User();
        user.setNumber(loginText);
        user.setPassword(loginPassword);
        ResultSet resultSet = dbHandler.getUser(user);
            try {
                if (resultSet.next()) {
                    SignUPUser.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/FxmlFails/UserWindow.fxml"));
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
      UserWindow userWindow = new UserWindow();
      userWindow.ddd(num);
    }


}















