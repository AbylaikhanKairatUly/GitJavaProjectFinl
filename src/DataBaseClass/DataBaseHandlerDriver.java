package DataBaseClass;

import DataBaseClass.Configs;
import DataBaseClass.ConstDriver;
import sample.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBaseHandlerDriver extends Configs {

    Connection connection;

    public Connection getConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return connection;

    }
    public ResultSet getDriver(Driver driver) {
        ResultSet resultSet = null;

        String select = "SELECT * from drivers Where Number=? AND Password=?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(select);
            preparedStatement.setString(1,driver.getNumber());
            preparedStatement.setString(2,driver.getPassword());

            resultSet =  preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void signUPDriver(Driver driver) {
        String insert = "INSERT INTO  " + ConstDriver.DRIVER_TABLE + "(" + ConstDriver.DRIVER_NAME + "," + ConstDriver.DRIVER_SURNAME + ","
                + ConstDriver.DRIVER_IIN+ "," + ConstDriver.DRIVER_CarModel+ "," +ConstDriver.DRIVER_CarNumber + ","+ ConstDriver.DRIVER_NUMBER+ ","+
        ConstDriver.DRIVER_PASSWORD+")" + "VALUES(?,?,?,?,?,?,?)";


        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1,driver.getName());
            preparedStatement.setString(2,driver.getSurname());
            preparedStatement.setString(3,driver.getIin());
            preparedStatement.setString(4,driver.getCarModel());
            preparedStatement.setString(5,driver.getCarNumber());
            preparedStatement.setString(6,driver.getNumber());
            preparedStatement.setString(7,driver.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
