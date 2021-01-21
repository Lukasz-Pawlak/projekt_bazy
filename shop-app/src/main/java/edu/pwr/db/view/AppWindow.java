package edu.pwr.db.view;

import edu.pwr.db.model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// let's make this class controller also
public class AppWindow extends JFrame {
    public static void main(String[] args){
        new AppWindow().start();
    }

    private final SearchResultPanel searchResultPanel;

    public AppWindow() {
        super("shop-app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int halfInitialWidth = 360, halfInitialHeight = 280;

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (d.getWidth() / 2), y = (int) (d.getHeight() / 2);
        setBounds(x - halfInitialWidth, y - halfInitialHeight,
                2 * halfInitialWidth, 2 * halfInitialHeight);
        setResizable(true);
        searchResultPanel = new SearchResultPanel();

        // tmp, for display check
        Item[] list = {new Item(), new Item(), new Item(), new Item()};
        searchResultPanel.setItems(list);

        add(searchResultPanel, BorderLayout.CENTER);
    }

    public void start() {
        new LoginDialog(this);
        setVisible(true);
    }

    public void showSelection(List<Item> list) {

    }
}