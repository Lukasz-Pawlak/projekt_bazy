package edu.pwr.db.view;

import edu.pwr.db.model.*;

import javax.swing.*;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

// let's make this class controller also
public class AppWindow extends JFrame {
    private State state = State.NONE;

    void resetState() {
        state = State.NONE;
    }
    State getCurrentState() {
        return state;
    }
    void nextState() {
        state = state.next();
    }

    void startInvoice() {
        state = State.INVOICE_CLIENT;
        try {
            var template = dbConnection.getClientTemplate();
            var list = template.list();
            searchResultPanel.setItems(list);
            tabbedPane.setSelectedComponent(searchResultPanel);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            // TODO: error message for user
        }
    }

    void showSearchPanel() {
        tabbedPane.setSelectedComponent(searchInputPanel);
    }

    void setInvoiceClient(ClientItem client) {
        invoiceGeneratorPanel.setClient(client);
        state = state.next();
        JOptionPane.showMessageDialog(this, "select offers",
                "info", JOptionPane.INFORMATION_MESSAGE);
        tabbedPane.setSelectedComponent(searchInputPanel);
    }

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

        searchResultPanel = new SearchResultPanel(this);
        searchInputPanel = new SearchInputPanel(this);
        invoiceGeneratorPanel = new InvoiceGeneratorPanel(this);
        customerAddPanel = new CustomerAddPanel(this);
        productAddPanel = new ProductAddPanel(this);
        alterOfferPanel = new AlterOfferPanel(this);

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
        productAddPanel.refreshContents();
        setVisible(true);
    }

    public void setDbConnection(DBConnection connection) {
        this.dbConnection = connection;
    }
    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void searchBy(Item brand, Item color, Item coverageLevel, Item type) {
        var template = dbConnection.getJoinedOfferTemplate();
        var list = template.list(brand, color, coverageLevel, type);
        var arr = new Item[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        searchResultPanel.setItems(list);
        tabbedPane.setSelectedComponent(searchResultPanel);
    }

    public void setInvoiceOffer(JoinedOfferItem result) {
        invoiceGeneratorPanel.setOffer(result);
        tabbedPane.setSelectedComponent(invoiceGeneratorPanel);
    }
}

enum State {
    NONE,
    INVOICE_CLIENT,
    INVOICE_LINE,
    OFFER_PRODUCT;

    public State next() {
        switch (this) {
            case NONE: return NONE;
            case INVOICE_LINE: return NONE;
            case OFFER_PRODUCT: return NONE;
            case INVOICE_CLIENT: return INVOICE_LINE;
            default: return null;
        }
    }
}