package edu.pwr.db.model;

public class JoinedOfferItem extends Item {
    private int id;
    private double pricePerUnit; // TODO: check if it is ok to use double when mapping from decimal
    private int unitsInStock;
    private String color, brand, type, coverageLevelName, product;
    private int coverageLevelNumericValue;

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

    @Override
    public Object[] toRowArray() {
        var row = new Object[9];
        row[0] = id;
        row[1] = product;
        row[2] = pricePerUnit;
        row[3] = unitsInStock;
        row[4] = type;
        row[5] = color;
        row[6] = brand;
        row[7] = coverageLevelName;
        row[8] = coverageLevelNumericValue;
        return row;
    }
}
