package edu.pwr.db.model;

// source: https://www.zentut.com/java-swing/simple-login-dialog/
// we will be doing it quite differently, it is just placeholder
// I assume this class will handle setting internal parameters of connection
public class Login {

    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("a") && password.equals("a")) {
            return true;
        }
        return false;
    }
}
