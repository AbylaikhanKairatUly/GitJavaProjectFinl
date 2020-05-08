package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DataBaseClass.DBOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserWindow {

    ObservableList<String> list = FXCollections.observableArrayList("Economy", "Comfort", "Business", "Delivery");

    @FXML
    private CheckBox Quick;

    @FXML
    private CheckBox Conditioner;

    @FXML
    private CheckBox ChildSeat;

    @FXML
    private TextField profile;

    @FXML
    private Button history;

    @FXML
    private Button message;

    @FXML
    private ComboBox<String> type;

    @FXML
    private TextField LocationUser;

    @FXML
    private TextField addressUser;

    @FXML
    private Button BackUser;

    @FXML
    private TextField OfferUser;

    @FXML
    private Button Settings;

    @FXML
    private Button NextUser;

    public static   String s;

    public void ddd(String a){
        this.s=a;
    }
    public static   String name;

    @FXML
    public void initialize() {
        type.setItems(list);

        DBOrder dbOrders=new DBOrder();
        String nnn="";
        String queryN="select * from users where number='"+ s +"'";
        try {
            Statement statement=dbOrders.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(queryN);
            while (resultSet.next()){
               nnn=resultSet.getString("nameUser");
                }
            } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
       profile.setText(nnn);

        NextUser.setOnAction(actionEvent -> {
            String location=LocationUser.getText().trim();
            String address=addressUser.getText().trim();
            String Number = s;
            int offer= Integer.parseInt(OfferUser.getText().trim());
            String Type = type.getValue();
            String conditioner="";
            String childSeat="";
            String quick="";

            if(ChildSeat.isSelected())
                childSeat="yes";
            else
                childSeat="no";
            if(Quick.isSelected())
                quick="yes";
            else
                quick="no";
            if(Conditioner.isSelected())
                conditioner="yes";
            else
                conditioner="no";

            Order order =new Order(location,address,Number,Type,offer,conditioner,childSeat,quick);
            PackageData packageData =new PackageData("SEND ORDER",order);
            Main.connectServer(packageData);

              packageData = new PackageData("MESSAGE FOR USER",s);
            Main.connectServer(packageData);
        });
        message.setOnAction(actionEvent -> {

            ArrayList<Order> message=new ArrayList<>();
            DBOrder dbOrder =new DBOrder();
            String queryD="select * from orders where number='"+ s +"'";
            try {
                Statement statement=dbOrder.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(queryD);
                while (resultSet.next()){
                    if(resultSet.getString("accepted")!=null) {
                        message.add(new Order("Your order has been accepted!!!"+"\n"+resultSet.getString("accepted") +"\n"+"\n"));
                    }

                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            MessageUser messageUser = new MessageUser();
            messageUser.ddd(message);

            openNewScene("/FxmlFails/MessageU.fxml");

        });

    }


    public void openNewScene(String window) {
        NextUser.getScene().getWindow().hide();
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


}



        



