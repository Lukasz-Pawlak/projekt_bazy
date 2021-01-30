package edu.pwr.db.model;

import java.sql.SQLException;

public class Login {
    private static DBConnection establishedConnection;

    public static DBConnection authenticate(String username, String password) {
        establishedConnection = new DBConnection();
        try {
            establishedConnection.connect(username, password);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            return null;
        }
        return establishedConnection;
    }
}
