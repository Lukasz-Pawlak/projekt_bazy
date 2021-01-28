package edu.pwr.db.view;

import edu.pwr.db.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductAddPanel extends JPanel {
    protected final JComboBox<Item> brands, colors, coverageLevels,types;
    protected JTextField inputName;
    protected final JButton add;
    public ProductAddPanel() {
        JPanel panel = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(20, 20, 20, 20);

        JLabel jlBrand = new JLabel("brand: ");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.weighty = 1;
        gc.weightx = 1;
        panel.add(jlBrand, gc);

        brands = new JComboBox<Item>();
        brands.setPrototypeDisplayValue(Item.ANY);
        gc.gridx = 1;
        panel.add(brands, gc);

        JLabel jlColor = new JLabel("color: ");
        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(jlColor, gc);

        colors = new JComboBox<>();
        gc.gridx = 1;
        panel.add(colors, gc);

        JLabel jlLevel = new JLabel("coverage level: ");
        gc.gridx = 0;
        gc.gridy = 2;
        panel.add(jlLevel, gc);

        coverageLevels = new JComboBox<>();
        gc.gridx = 1;
        panel.add(coverageLevels, gc);

        JLabel jlTypes = new JLabel("type: ");
        gc.gridx = 0;
        gc.gridy = 3;
        panel.add(jlTypes, gc);

        types = new JComboBox<>();
        gc.gridx = 1;
        panel.add(types, gc);

        JLabel jlName = new JLabel("name: ");
        gc.gridx = 0;
        gc.gridy = 4;
        panel.add(jlName,gc);

        JTextField inputName=new JTextField("Enter product name");
        inputName.setFont(new Font("X", Font.ITALIC, 15));
        gc.gridx=1;
        panel.add(inputName,gc);

        add = new JButton("Add");
        gc.gridx = 0;
        gc.gridy = 5;

        gc.gridwidth = 2;
        panel.add(add, gc);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // pobieramy dane i dodajemy produkt
            }
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        inputName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                inputName.setText("");
            }
        });


    }
}
