package edu.pwr.db.view;

import edu.pwr.db.Logger;
import edu.pwr.db.model.Item;

import javax.swing.*;
import java.awt.*;

public class SearchResultPanel extends JPanel {
    private final JList<Item> items;
    private JTable table; // I think I've seen this object is good at handling SQL query results, maybe it is worth giving a shot
    private final JButton selectButton;
    public SearchResultPanel() {
        items = new JList<>();
        selectButton = new JButton("select");
        setLayout(new BorderLayout());
        add(items, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
        //table = new JTable();

        selectButton.addActionListener(e -> {
            Item result = items.getSelectedValue();
            // TODO: do something with selected value
            Logger.debug(result.toString());
        });
    }

    public void setItems(Item[] items) {
        this.items.setListData(items);
        //this.items.setPreferredSize(getPreferredSize());
        repaint();
    }


}
