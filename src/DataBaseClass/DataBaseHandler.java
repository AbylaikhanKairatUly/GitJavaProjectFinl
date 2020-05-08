package DataBaseClass;

import DataBaseClass.Configs;
import DataBaseClass.Const;
import sample.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DataBaseHandler extends Configs {
    Connection connection;

    public  Connection getConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return connection;

    }

    public ResultSet getUser(User user) {
        ResultSet resultSet = null;

        String select = "SELECT * from Users Where number=? AND passwordUser=?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            preparedStatement.setString(1,user.getNumber());
            preparedStatement.setString(2,user.getPassword());

            resultSet =  preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void signUPUsers(User user) {
        String insert = "INSERT INTO  " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_SURNAME + "," + Const.USER_EMAIL + "," + Const.USER_NUMBER + "," + Const.USER_PASSWORD + ")" + "VALUES(?,?,?,?,?)";


        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getNumber());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
