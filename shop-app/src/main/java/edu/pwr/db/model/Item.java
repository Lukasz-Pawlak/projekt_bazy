package edu.pwr.db.model;

// all db objects will extend Item
public class Item {
    // for display & as a placeholder to determine type of query
    public static final Item ANY = new FakeItem("   -- < any > --                                          ");
    private static class FakeItem extends Item {
        private final String name;
        FakeItem(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    // for tests
    public Item() {}
}
