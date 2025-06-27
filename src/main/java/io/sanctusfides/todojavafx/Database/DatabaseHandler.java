package io.sanctusfides.todojavafx.Database;

import io.sanctusfides.todojavafx.Model.User;

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
    public void signUpUser(User user) {
        String insert = "INSERT INTO "+Constants.USERS_TABLE + "(" + Constants.USERS_FIRSTNAME + "," +
                Constants.USERS_LASTNAME + "," + Constants.USERS_USERNAME + "," + Constants.USERS_PASSWORD + "," +
                Constants.USERS_LOCATION + "," + Constants.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getLocation());
            preparedStatement.setString(6, user.getGender());

            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    // Read
}
