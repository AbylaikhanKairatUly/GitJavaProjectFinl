package sample;


import DataBaseClass.DBOrder;
import DataBaseClass.DataBaseHandler;
import DataBaseClass.DataBaseHandlerDriver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){

        try{
            DBOrder dbOrder = new DBOrder();
            dbOrder.getConnection();
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            dataBaseHandler.getConnection();
            DataBaseHandlerDriver dataBaseHandlerDriver = new DataBaseHandlerDriver();
            dataBaseHandlerDriver.getConnection();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData packageData = null;
            while ( (packageData=(PackageData)inputStream.readObject())!=null ){
                if(packageData.getOperationType().equals("SEND ORDER")){
                    Order sendOrder = packageData.getOrder();
                    dbOrder.getOrder(sendOrder);
                }
                else if(packageData.getOperationType().equals("RECEPTION")){
                    ArrayList<Driver> n=packageData.getDrivers();
                    int ind=packageData.getIdOrd();
                   dbOrder.SetOrd(ind,n);
                }
                else if(packageData.getOperationType().equals("CREAT USER ACCOUNT")){
                    User user=packageData.getUser();
                    dataBaseHandler.signUPUsers(user);
                }

                else if(packageData.getOperationType().equals("CREAT DRIVER ACCOUNT")){
                    Driver driver = packageData.getDriver();
                    dataBaseHandlerDriver.signUPDriver(driver);
                }

            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

