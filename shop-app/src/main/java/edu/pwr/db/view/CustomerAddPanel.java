package edu.pwr.db.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class CustomerAddPanel extends JPanel {
    protected final JButton add;
    public CustomerAddPanel() {
        JPanel panel = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 10, 0, 0);
        gc.anchor = GridBagConstraints.NORTHWEST;

        JLabel jlName = new JLabel("Name:");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth=1;
        gc.weighty = 0;
        gc.weightx = 0;
        panel.add(jlName, gc);

        JTextArea inputName = new JTextAreaWithPlaceholder("Enter name");
        gc.gridx = 1;
        gc.weightx = 5;
        panel.add(inputName,gc);

        JLabel jlSurname = new JLabel("Surname:");
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        panel.add(jlSurname, gc);

        JTextArea inputSurname = new JTextAreaWithPlaceholder("Enter surname");
        gc.gridx=1;
        panel.add(inputSurname,gc);

        JLabel jlAddress = new JLabel("Address:");
        gc.gridx=0;
        gc.gridy=2;
        panel.add(jlAddress,gc);

        JTextArea inputAddress = new JTextAreaWithPlaceholder("Enter address");
        gc.gridx=1;
        gc.fill = GridBagConstraints.BOTH;
        gc.weighty = 10;
        panel.add(inputAddress,gc);

        add = new JButton("Add");
        gc.gridx = 0;
        gc.gridy=3;
        gc.gridwidth = 2;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        panel.add(add, gc);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 20, 20);
        setBorder(padding);
        add.addActionListener(e -> {
            //TODO 'add' button functionality
        });

    }

    private static class JTextAreaWithPlaceholder extends JTextArea {
        private final String placeholder;
        private boolean focused;

        JTextAreaWithPlaceholder(String placeholder) {
            this.placeholder = placeholder;
            focused = false;
            this.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    focused = false;
                    repaint();
                }

                @Override
                public void focusGained(FocusEvent e) {
                    super.focusGained(e);
                    focused = true;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            if(getText().isEmpty() && !focused) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setBackground(Color.gray);
                //g2.setFont(getFont().deriveFont(Font.ITALIC));
                g2.drawString(placeholder, 5, 10);
                g2.dispose();
            }
        }
    }
}
