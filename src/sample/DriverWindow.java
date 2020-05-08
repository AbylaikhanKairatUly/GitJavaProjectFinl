package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import DataBaseClass.DBOrder;
import DataBaseClass.DataBaseHandlerDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DriverWindow implements Initializable {


    @FXML
    private TableColumn<Order, String> quick;

    @FXML
    private TableColumn<Order, String> address;

    @FXML
    private TableColumn<Order, String> conditioner;

    @FXML
    private Button history;

    @FXML
    private Button message;

    @FXML
    private TableColumn<Order, String> type;

    @FXML
    private TableColumn<Order, Integer> offer;

    @FXML
    private Button WalletDriverButton;

    @FXML
    private TextField profileDriver;

    @FXML
    private TableColumn<Order, String> Number;

    @FXML
    private Button BackUser;

    @FXML
    private TableColumn<Order, String>location;

    @FXML
    private TableColumn<Order, Integer> ID;

    @FXML
    private Button reception;

    @FXML
    private Button Settings;

    @FXML
    private TableView<Order> table;

    @FXML
    private TableColumn<Order, String> child;

    public static String NumberText;

    public void setNumber(String a){
        this.NumberText=a;
    }



    ObservableList<Order> list = FXCollections.observableArrayList();
    ArrayList <Driver> drivers = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBOrder dataBaseOrder =new DBOrder();
        DataBaseHandlerDriver dataBaseHandlerDriver = new DataBaseHandlerDriver();
        String nnn="";
        String queryN="select * from drivers where number='"+ NumberText +"'";
        try {
            Statement statement=dataBaseHandlerDriver.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(queryN);
            while (resultSet.next()){
                nnn=resultSet.getString("Name");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        profileDriver.setText(nnn);

        String query="select * from orders";
        try {
            Statement statement=dataBaseOrder.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                list.addAll(new Order(resultSet.getInt("idorder"),resultSet.getString("Location"),resultSet.getString("Address"),resultSet.getString("Number"),resultSet.getString("Type")
                ,resultSet.getInt("offer"),resultSet.getString("Conditioner"),resultSet.getString("child_seat"),resultSet.getString("quick")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Number.setCellValueFactory(new PropertyValueFactory<>("number"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        offer.setCellValueFactory(new PropertyValueFactory<>("offer"));
        conditioner.setCellValueFactory(new PropertyValueFactory<>("conditioner"));
        child.setCellValueFactory(new PropertyValueFactory<>("child"));
        quick.setCellValueFactory(new PropertyValueFactory<>("quick"));

        table.setItems(list);


        reception.setOnAction(actionEvent ->{
            if(table.getSelectionModel().getSelectedItem() != null){
                Order selectedOrder=table.getSelectionModel().getSelectedItem();
               int IdOrder=selectedOrder.getId();
                DataBaseHandlerDriver dataBaseHandlerDriver1 = new DataBaseHandlerDriver();
                String queryD="select * from drivers where number='"+ NumberText +"'";
                try {
                    Statement statement=dataBaseHandlerDriver1.getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery(queryD);
                    while (resultSet.next()){
                        drivers.add(new Driver(resultSet.getString("Name"),resultSet.getString("Number"),resultSet.getString("CarModel"),
                                resultSet.getString("CarNumber")));
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println(IdOrder);
                PackageData packageData =new PackageData("RECEPTION",IdOrder,drivers);
                Main.connectServer(packageData);
            }
            table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
    });



            BackUser.setOnAction(actionEvent1 -> {
                openNewScene("/FxmlFails/DriverScene.fxml");
            });


    }
        public void openNewScene(String window){
            BackUser.getScene().getWindow().hide();
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
