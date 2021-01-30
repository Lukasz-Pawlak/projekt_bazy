package edu.pwr.db.view;

import edu.pwr.db.Logger;
import edu.pwr.db.model.Item;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SearchResultPanel extends JPanel {
    private final JList<Item> items;
    private JTable table; // I think I've seen this object is good at handling SQL query results, maybe it is worth giving a shot
    private final JButton selectButton;
    private static Object[] columnNames = {"awsd", "Aasda", "ASDasd a"};
    public SearchResultPanel() {
        items = new JList<>();
        selectButton = new JButton("select");
        setLayout(new BorderLayout());
        add(items, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
        /*
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(table, BorderLayout.CENTER);
         */

        /*selectButton.addActionListener(e -> {
            Item result = items.getSelectedValue();
            if (result != null) // dont forget about this line <--
            // TODO: do something with selected value
            Logger.debug(result.toString());
        });*/

        setBorder(new EmptyBorder(40, 40, 40, 40)); // padding
    }

    public void setItems(Item[] items) {
        //this.items.add
        //this.items.setListData(items);
        /*String[] columnNames = {"Title", "Season", "Episode", "", "", "", "", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (var item : items) {
            tableModel.addRow(item.toRowArray());
        }
        table.setModel(tableModel);*/
        repaint();
    }


}
