package edu.pwr.db.view;

import edu.pwr.db.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerAddPanel extends JPanel {
    protected final JButton add;
    public CustomerAddPanel(){
        JPanel panel = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(20, 20, 20, 20);

        JLabel jlName = new JLabel("Name: ");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth=1;
        panel.add(jlName, gc);

        JTextField inputName = new JTextField("Enter name              ");
        gc.gridx = 1;
        panel.add(inputName,gc);

        JLabel jlSurname = new JLabel("Surname: ");
        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(jlSurname, gc);

        JTextField inputSurname = new JTextField("Enter surname                ");
        gc.gridx=1;
        panel.add(inputSurname,gc);

        JLabel jlAddress = new JLabel("Addres");
        gc.gridx=0;
        gc.gridy=2;
        panel.add(jlAddress,gc);

        JTextField inputAddress = new JTextField("Enter addres           ");
        gc.gridx=1;
        panel.add(inputAddress,gc);

        add = new JButton("Add");
        gc.gridy=3;
        gc.gridwidth = 4;
        panel.add(add, gc);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        inputName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                inputName.setText("");
            }
        });
        inputSurname.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                inputSurname.setText("");

            }
        });
        inputAddress.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                inputAddress.setText("");
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
