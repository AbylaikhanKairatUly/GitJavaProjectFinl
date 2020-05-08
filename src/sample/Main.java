package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends Application {

    public static String s="";

    public static void connectServer(PackageData pd){

        try{
            Socket socket = new Socket("127.0.0.1", 8888);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("SEND ORDER")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("RECEPTION")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("CREAT USER ACCOUNT")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("CREAT DRIVER ACCOUNT")){
                outputStream.writeObject(pd);
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

            }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../FxmlFails/DriverScene.fxml"));
        primaryStage.setTitle("Taxi");
        primaryStage.setScene(new Scene(root, 679, 474));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

