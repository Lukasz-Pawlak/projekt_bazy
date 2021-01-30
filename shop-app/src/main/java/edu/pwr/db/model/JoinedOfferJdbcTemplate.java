package edu.pwr.db.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JoinedOfferJdbcTemplate extends Item {
    private int id;
    private double pricePerUnit; // TODO: check if it is ok to use double when mapping from decimal
    private int unitsInStock;
    private String color, brand, type, coverageLevelName, product;
    private int coverageLevelNumericValue;
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Item> mapper;

    public JoinedOfferJdbcTemplate() {
        this.mapper = new JoinedOfferMapper();
    }

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Item> list(Item brand, Item color, Item coverageLevel, Item type) {
        String SQL =
                "select offer.unitsInStock as unitsInStock, " +
                        "offer.pricePerUnit as pricePerUnit, " +
                        "offer.id as offerId " +
                        "products.name as product, " +
                        "c2.name as color " +
                        "b2.name as brand " +
                        "c3.name as coverageLevelName " +
                        "c3.numericValue as coverageLevelNumericValue " +
                        "from offer " +
                        "inner join Products on offer.product = products.id " +
                        "inner join brands b2 on products.brand = b2.id " +
                        "inner join colors c2 on products.color = c2.id " +
                        "inner join coverageLevels c3 on products.coverageLevel = c3.id " +
                        "inner join types t2 on products.type = t2.id ";

        List<Object> args = new ArrayList<>();
        boolean argumentsBefore = false;
        if (brand instanceof SmallItem) {
            argumentsBefore = true;
            SQL += "WHERE ";
            SQL += "b2.id = ? ";
            args.add(((SmallItem) brand).getId());
        }
        if (coverageLevel instanceof CoverageLevelItem) {
            if (!argumentsBefore) {
                argumentsBefore = true;
                SQL += "WHERE ";
            }
            else {
                SQL += "AND ";
            }
            SQL += "c3.id = ? ";
            args.add(((CoverageLevelItem) coverageLevel).getId());
        }
        if (type instanceof SmallItem) {
            if (!argumentsBefore) {
                argumentsBefore = true;
                SQL += "WHERE ";
            }
            else {
                SQL += "AND ";
            }
            SQL += "t2.id = ? ";
            args.add(((SmallItem) type).getId());
        }
        if (color instanceof SmallItem) {
            if (!argumentsBefore) {
                //argumentsBefore = true;
                SQL += "WHERE ";
            }
            else {
                SQL += "AND ";
            }
            SQL += "c2.id = ? ";
            args.add(((SmallItem) color).id);
        }

        return jdbcTemplate.query(SQL, mapper, args.toArray());
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPricePerUnit() {
        return pricePerUnit;
    }
    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
    public int getUnitsInStock() {
        return unitsInStock;
    }
    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCoverageLevelName() {
        return coverageLevelName;
    }
    public void setCoverageLevelName(String coverageLevelName) {
        this.coverageLevelName = coverageLevelName;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public int getCoverageLevelNumericValue() {
        return coverageLevelNumericValue;
    }
    public void setCoverageLevelNumericValue(int coverageLevelNumericValue) {
        this.coverageLevelNumericValue = coverageLevelNumericValue;
    }
}
