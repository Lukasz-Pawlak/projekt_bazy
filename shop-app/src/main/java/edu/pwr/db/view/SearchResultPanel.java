package edu.pwr.db.view;

import edu.pwr.db.model.Item;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.util.Collection;

public class SearchResultPanel extends JPanel {
    private final DefaultListModel<Item> model;
    private final JButton selectButton;
    public SearchResultPanel() {
        model = new DefaultListModel<>();
        JList<Item> items = new JList<>(model);
        selectButton = new JButton("select");
        setLayout(new BorderLayout());
        add(items, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);

        /*selectButton.addActionListener(e -> {
            Item result = items.getSelectedValue();
            if (result != null) // dont forget about this line <--
            // TODO: do something with selected value
            Logger.debug(result.toString());
        });*/

        setBorder(new EmptyBorder(40, 40, 40, 40)); // padding
    }

    public void setItems(Collection<Item> itemCollection) {
        model.clear();
        //model.addAll(itemCollection);
        for (Item i : itemCollection) {
            model.addElement(i);
        }
        if (model.isEmpty()) {
            model.addElement(Item.NO_RESULTS);
        }
        repaint();
    }


}
