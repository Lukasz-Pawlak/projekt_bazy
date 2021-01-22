package edu.pwr.db.view;

import edu.pwr.db.model.Item;

import javax.swing.*;
import java.awt.*;

public class SearchInputPanel extends JPanel {
    protected final JComboBox<Item> brands, colors, coverageLevels, types;
    protected final JButton search;

    public SearchInputPanel() {
        JPanel master = new JPanel();
        master.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(20, 20, 20, 20);

        JLabel jlBrand = new JLabel("brand: ");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        master.add(jlBrand, gc);

        brands = new JComboBox<>();
        brands.setPrototypeDisplayValue(Item.ANY);
        gc.gridx = 1;
        master.add(brands, gc);

        JLabel jlColor = new JLabel("color: ");
        gc.gridx = 0;
        gc.gridy = 1;
        master.add(jlColor, gc);

        colors = new JComboBox<>();
        gc.gridx = 1;
        master.add(colors, gc);

        JLabel jlLevel = new JLabel("coverage level: ");
        gc.gridx = 0;
        gc.gridy = 2;
        master.add(jlLevel, gc);

        coverageLevels = new JComboBox<>();
        gc.gridx = 1;
        master.add(coverageLevels, gc);

        JLabel jlTypes = new JLabel("type: ");
        gc.gridx = 0;
        gc.gridy = 3;
        master.add(jlTypes, gc);

        types = new JComboBox<>();
        gc.gridx = 1;
        master.add(types, gc);

        search = new JButton("search");
        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 2;
        master.add(search, gc);

        setLayout(new BorderLayout());
        add(master, BorderLayout.CENTER);
        //master.setBackground(Color.BLACK);
    }
}
