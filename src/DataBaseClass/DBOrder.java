package DataBaseClass;

import sample.Driver;
import sample.Order;

import java.sql.*;
import java.util.ArrayList;


public class DBOrder extends Configs {

        Connection connection;

        public Connection getConnection()
                throws ClassNotFoundException, SQLException {
            String connectionString = "jdbc:mysql://" + dbHost + ":"
                    + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
            return connection;

        }

        public void getOrder(Order order) {
            String insert = "INSERT INTO  " + ConstOrder.ORDER_TABLE + "(" + ConstOrder.ORDER_LOCATION + "," + ConstOrder.ORDER_ADDRESS +
                    ","+ ConstOrder.ORDER_NUMBER +","+ ConstOrder.ORDER_TYPE +"," + ConstOrder.ORDER_OFFER +
                    "," + ConstOrder.ORDER_CONDITIONER +","+ConstOrder.ORDER_CHILD +","+ConstOrder.ORDER_QUICK + ")" + "VALUES(?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
                preparedStatement.setString(1,order.getLocation());
                preparedStatement.setString(2,order.getAddress());
                preparedStatement.setString(3,order.getNumber());
                preparedStatement.setString(4,order.getType());
                preparedStatement.setInt(5,order.getOffer());
                preparedStatement.setString(6,order.getConditioner());
                preparedStatement.setString(7,order.getChild());
                preparedStatement.setString(8,order.getQuick());
                preparedStatement.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    public void SetOrd(int index, ArrayList<Driver> D) throws SQLException, ClassNotFoundException {
            String queryD="update  orders set Accepted=? where idorder ="+index;
      PreparedStatement preparedStatement = getConnection().prepareStatement(queryD);
      preparedStatement.setString(1, String.valueOf(D));
      preparedStatement.executeUpdate();
        System.out.println("Updated successful");
    }


    }

