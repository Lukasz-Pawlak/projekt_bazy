package edu.pwr.db.view;

import javax.swing.*;

// let's make this class controller also
public class AppWindow extends JFrame {
    public static void main(String[] args){
        new AppWindow();
    }

    public AppWindow() {
        super("shop-app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("test"));
        pack();
        setVisible(true);
    }
}