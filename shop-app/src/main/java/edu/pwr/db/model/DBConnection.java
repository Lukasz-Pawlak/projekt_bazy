package edu.pwr.db.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBConnection {
    private java.sql.Connection conn;
    private DataSource dataSource;

    public List<String> getRole() {
        String SQL = "select current_role()";
        var template = new JdbcTemplate(dataSource);
        return template.query(SQL, (ds, i) -> {
            try {
                return ds.getString("current_role()");
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        });
    }

    public void connect(String userName, String password) throws SQLException {
        if (conn != null) {
            conn.close();
        }
        dataSource = DataSourceFactory.getMySQLDataSource(userName, password);
        conn = dataSource.getConnection();
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        conn = null;
    }

    public JoinedProductJdbcTemplate getJoinedProductTemplate() {
        var r = new JoinedProductJdbcTemplate();
        r.setDataSource(dataSource);
        return r;
    }

    public SmallItemJdbcTemplate getSmallItemTemplate(String tableName) throws SQLException {
        var r = new SmallItemJdbcTemplate(tableName);
        r.setDataSource(dataSource);
        return r;
    }

    public Connection getConn() {
        return conn;
    }

    public CoverageLevelJdbcTemplate getCoverageLevelTemplate() throws SQLException {
        var r = new CoverageLevelJdbcTemplate();
        r.setDataSource(dataSource);
        return r;
    }

    public JoinedOfferJdbcTemplate getJoinedOfferTemplate() {
        var r = new JoinedOfferJdbcTemplate();
        r.setDataSource(dataSource);
        return r;
    }

    public ClientJdbcTemplate getClientTemplate() throws SQLException {
        var r = new ClientJdbcTemplate();
        r.setDataSource(dataSource);
        return r;
    }
    public DataSource getDataSource(){
        return dataSource;
    }
    public JdbcTemplate getJDBCTemplate(){
        var r = new JdbcTemplate();
        r.setDataSource(dataSource);
        return r;
    }
}

class DataSourceFactory {
    public static DataSource getMySQLDataSource(String userName, String password) {
        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL("jdbc:mysql://localhost:3306/shop?sslMode=DISABLED");
        mysqlDS.setUser(userName);
        mysqlDS.setPassword(password);
        mysqlDS.setCharacterEncoding("utf-8");
        return mysqlDS;
    }
}
