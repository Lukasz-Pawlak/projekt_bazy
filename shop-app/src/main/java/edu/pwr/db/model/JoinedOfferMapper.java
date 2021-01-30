package edu.pwr.db.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JoinedOfferMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

}
/*
 "select offer.unitsInStock as unitsInStock, " +
         "offer.pricePerUnit as pricePerUnit, " +
         "offer.id as offerId " +
         "products.name as product, " +
         "c2.name as color " +
         "b2.name as brand " +
         "c3.name as coverageLevelName " +
         "c3.numericValue as coverageLevelNumericValue " +*/