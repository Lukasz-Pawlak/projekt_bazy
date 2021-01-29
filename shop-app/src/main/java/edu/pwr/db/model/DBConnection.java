package edu.pwr.db.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DBConnection {
    private static java.sql.Connection conn;

    public static void connect(String userName, String password) {
        try {
            conn = DataSourceFactory.getMySQLDataSource(userName, password).getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

class DataSourceFactory {
    public static DataSource getMySQLDataSource(String userName, String password) {
        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL("mysql://localhost:3306/Shop");
        mysqlDS.setUser(userName);
        mysqlDS.setPassword(password);
        return mysqlDS;
    }
}
