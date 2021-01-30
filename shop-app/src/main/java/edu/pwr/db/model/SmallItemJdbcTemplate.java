package edu.pwr.db.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class SmallItemJdbcTemplate extends Item {
    protected String tableName;
    protected RowMapper<Item> mapper;
    private JdbcTemplate jdbcTemplate;

    public SmallItemJdbcTemplate(String tableName) {
        this.tableName = tableName;
        this.mapper = new SmallItemMapper();
    }

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Item> list() {
        String SQL = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(SQL, mapper);
    }
}
