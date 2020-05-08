package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class DriverHistory {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea wallet;

    @FXML
    private TextArea history;

    public static ArrayList<Order> h;
    public void hh (ArrayList<Order> a){
        this.h=a;
    }
    public static int w;
    public void ww (int a){
        this.w=a;
    }

    @FXML
    void initialize() {
        history.appendText(String.valueOf(h)+"\n");
        wallet.setText(String.valueOf(w));
    }
}