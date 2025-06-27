package io.sanctusfides.todojavafx.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static io.sanctusfides.todojavafx.Database.Configs.*;

public class DatabaseHandler {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException , SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser, dbPass);
        return dbConnection;
    }

    // Write
    public void signUpUser(String firstName, String lastName, String userName,
                           String password, String location, String gender) {
        String insert = "INSERT INTO "+Constants.USERS_TABLE + "(" + Constants.USERS_FIRSTNAME + "," +
                Constants.USERS_LASTNAME + "," + Constants.USERS_USERNAME + "," + Constants.USERS_PASSWORD + "," +
                Constants.USERS_LOCATION + "," + Constants.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, location);
            preparedStatement.setString(6, gender);

            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    // Read
}
