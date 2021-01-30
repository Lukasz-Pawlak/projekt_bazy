package edu.pwr.db.model;

// all db objects will extend Item
public abstract class Item {
    // for display & as a placeholder to determine type of query
    public static final Item ANY = new FakeItem(" < any >");
    public static final Item NOT_SELECTED = new FakeItem(" < not selected >");


    public abstract Object[] toRowArray();

    private static class FakeItem extends Item {
        private final String name;
        FakeItem(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }

        @Override
        public Object[] toRowArray() {
            return new Object[0];
        }
    }

    // for tests
    public Item() {}
}
