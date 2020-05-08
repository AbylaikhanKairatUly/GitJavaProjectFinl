package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MessageUser {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  TextArea UserText;

    @FXML
    private TextField textField;

    @FXML
    private Button sendButton;


    public static ArrayList<Order> s;
    public void ddd(ArrayList<Order> a){
        System.out.println( a);
        this.s=a;
    }


    @FXML
    void initialize() {
     UserText.appendText(String.valueOf(s));

    }
}



