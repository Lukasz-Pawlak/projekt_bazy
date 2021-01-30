package edu.pwr.db.view;

import edu.pwr.db.model.DBConnection;
import edu.pwr.db.model.Item;

import javax.swing.*;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.awt.*;
import java.util.List;

// let's make this class controller also
public class AppWindow extends JFrame {
    public static void main(String[] args){
        new AppWindow().start();
    }

    private final SearchResultPanel searchResultPanel;
    private final SearchInputPanel searchInputPanel;
    private final InvoiceGeneratorPanel invoiceGeneratorPanel;
    private final CustomerAddPanel customerAddPanel;
    private final ProductAddPanel productAddPanel;
    private final AlterOfferPanel alterOfferPanel;
    private DBConnection dbConnection;

    private final JTabbedPane tabbedPane;

    public AppWindow() {
        super("shop-app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int halfInitialWidth = 360, halfInitialHeight = 280;

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (d.getWidth() / 2), y = (int) (d.getHeight() / 2);
        setBounds(x - halfInitialWidth, y - halfInitialHeight,
                2 * halfInitialWidth, 2 * halfInitialHeight);
        setResizable(true);

        tabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setUI(new MetalTabbedPaneUI() {
            @Override
            protected int calculateTabHeight(int a, int b, int c) {
                return 40; // this is pixel height of the tab
            }
        });

        searchResultPanel = new SearchResultPanel();
        searchInputPanel = new SearchInputPanel(this);
        invoiceGeneratorPanel = new InvoiceGeneratorPanel();
        customerAddPanel = new CustomerAddPanel();
        productAddPanel = new ProductAddPanel();
        alterOfferPanel = new AlterOfferPanel();

        // tmp, for display check
        //Item[] list = {new Item(), new Item(), new Item(), new Item()};
        //searchResultPanel.setItems(list);

        tabbedPane.add(searchInputPanel, "Search products");
        tabbedPane.add(searchResultPanel, "Search results");
        tabbedPane.add(invoiceGeneratorPanel, "Create invoice");
        tabbedPane.add(customerAddPanel, "Add customer");
        tabbedPane.add(productAddPanel, "Add product");
        tabbedPane.add(alterOfferPanel, "Change offer");

        add(tabbedPane);
    }

    public void start() {
        new LoginDialog(this);
        searchInputPanel.refreshContents(); // this is first load of contents
        setVisible(true);
    }

    public void setDbConnection(DBConnection connection) {
        this.dbConnection = connection;
    }
    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void showSelection(List<Item> list) {

    }
}