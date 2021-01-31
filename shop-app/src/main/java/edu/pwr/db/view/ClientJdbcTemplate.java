package edu.pwr.db.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class ClientJdbcTemplate extends SmallItemJdbcTemplate {
    protected RowMapper<Item> mapper;
    private JdbcTemplate jdbcTemplate;

    public ClientJdbcTemplate(String tableName) throws SQLException {
        super(tableName);
    }

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public List<Item> list() {
        String SQL = "SELECT * FROM clients";
        return jdbcTemplate.query(SQL, mapper);
    }

}