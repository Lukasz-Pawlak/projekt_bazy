package edu.pwr.db.view;

import edu.pwr.db.model.Item;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProductAddPanel extends JPanel {
    protected final JComboBox<Item> brands, colors, coverageLevels, types;
    protected final JTextArea inputName;
    protected final JButton add;
    public ProductAddPanel() {
        JPanel panel = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(10, 10, 0, 0);

        JLabel jlBrand = new JLabel("brand:");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.weighty = 1;
        gc.weightx = 1;
        panel.add(jlBrand, gc);

        brands = new JComboBox<>();
        brands.addItem(Item.NOT_SELECTED);
        gc.gridx++;
        gc.weightx = 5;
        panel.add(brands, gc);

        JLabel jlColor = new JLabel("color:");
        gc.gridx = 0;
        gc.weightx = 1;
        gc.gridy++;
        panel.add(jlColor, gc);

        colors = new JComboBox<>();
        colors.addItem(Item.NOT_SELECTED);
        gc.gridx++;
        panel.add(colors, gc);

        JLabel jlLevel = new JLabel("coverage level: ");
        gc.gridx = 0;
        gc.gridy++;
        panel.add(jlLevel, gc);

        coverageLevels = new JComboBox<>();
        coverageLevels.addItem(Item.NOT_SELECTED);
        gc.gridx++;
        panel.add(coverageLevels, gc);

        JLabel jlTypes = new JLabel("type:");
        gc.gridx = 0;
        gc.gridy++;
        panel.add(jlTypes, gc);

        types = new JComboBox<>();
        types.addItem(Item.NOT_SELECTED);
        gc.gridx++;
        panel.add(types, gc);

        JLabel jlName = new JLabel("name:");
        gc.gridx = 0;
        gc.gridy++;
        panel.add(jlName,gc);

        inputName = new JTextAreaWithPlaceholder("Enter product name");
        gc.gridx++;
        gc.weighty = 2;
        gc.fill = GridBagConstraints.BOTH;
        panel.add(inputName,gc);

        add = new JButton("Add");
        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.7;

        gc.gridwidth = 2;
        panel.add(add, gc);

        add.addActionListener(e -> {
            // pobieramy dane i dodajemy produkt
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setBorder(new EmptyBorder(20, 20, 30, 30));
    }
}
