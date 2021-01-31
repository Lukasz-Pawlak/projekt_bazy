package edu.pwr.db.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AlterOfferPanel extends JPanel {
    private final JButton removeOffer, addOffer, updateOffer, select;
    private final JTextArea amount, price, productDescription;
    private final AppWindow appWindow;

    public AlterOfferPanel(AppWindow appWindow) {
        this.appWindow = appWindow;
        updateOffer = new JButton("update offer");
        select = new JButton("choose product");
        removeOffer = new JButton("remove offer");
        addOffer = new JButton("add offer");
        amount = new JTextAreaWithPlaceholder("in stock");
        price = new JTextAreaWithPlaceholder("price per unit");
        productDescription = new JTextArea();
        productDescription.setEditable(false);

        setLayout(new GridBagLayout());
        var gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(10, 10, 0, 0);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridheight = 1;
        gc.gridwidth = 3;
        gc.weighty = 5;
        gc.weightx = 1;
        add(productDescription, gc);

        gc.gridy++;
        gc.weighty = 1;
        var panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3, 10, 10));
        panel2.add(amount);
        panel2.add(price);
        JPanel holder1 = new JPanel();
        holder1.add(updateOffer);
        panel2.add(holder1);
        add(panel2, gc);

        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(select, gc);

        gc.gridx++;
        add(removeOffer, gc);

        gc.gridx++;
        add(addOffer, gc);

        setBorder(new EmptyBorder(20, 20, 30, 30));
    }
}
