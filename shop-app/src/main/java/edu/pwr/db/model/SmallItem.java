package edu.pwr.db.model;

// type / brand / color
public class SmallItem extends Item {
    protected String name;
    protected int id;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Object[] toRowArray() {
        var row = new Object[2];
        row[0] = id;
        row[1] = name;
        return row;
    }
}
