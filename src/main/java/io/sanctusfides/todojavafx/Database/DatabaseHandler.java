package io.sanctusfides.todojavafx.Database;

import io.sanctusfides.todojavafx.Model.User;

import java.sql.*;

import static io.sanctusfides.todojavafx.Database.Configs.*;

public class DatabaseHandler {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException , SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser, dbPass);
        return dbConnection;
    }

    public ResultSet getUser(User user) {
        // ResultSet is the returned row from a SQL look up
        ResultSet resultSet = null;
        if (!user.getUserName().isEmpty() || !user.getPassword().isEmpty()) {
            // Select all users where username and password match the entered values
            // TODO add encryption to handle hashing password values
            String query = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE " + Constants.USERS_USERNAME +
                    "=?" + "AND " + Constants.USERS_PASSWORD + "=?";

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                // Each of the number values in the setString funct correlate to the ?s in the Query statement above
                preparedStatement.setString(1,user.getUserName());
                preparedStatement.setString(2,user.getPassword());

                resultSet = preparedStatement.executeQuery();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // TODO  turn this into a proper error label on the Login View
            System.out.println("Please Enter Credentials");
        }
        return resultSet;
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
