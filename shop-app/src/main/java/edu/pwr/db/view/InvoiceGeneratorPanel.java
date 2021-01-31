package edu.pwr.db.view;

import edu.pwr.db.model.ClientItem;
import edu.pwr.db.model.Item;
import edu.pwr.db.model.JoinedOfferItem;
import edu.pwr.db.model.JoinedOfferJdbcTemplate;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InvoiceGeneratorPanel extends JPanel {
    private final JButton newInvoice;
    private final JButton addOffer;
    private final JButton endCreation;
    private final JButton cancelCreation;
    private final JTextArea unitsCountInput;
    private final JTextArea alreadyCreatedView;
    private final JTextArea selectedOfferInfo;
    private final AppWindow appWindow;

    /**
     * -1 means that we do not have invoice selected (created)
     */
    private int invoiceID = -1;
    private JoinedOfferItem currentOffer;

    public InvoiceGeneratorPanel(AppWindow appWindow) {
        this.appWindow = appWindow;
        newInvoice = new JButton("create new");
        addOffer = new JButton("add entry");
        endCreation = new JButton("confirm");
        cancelCreation = new JButton("cancel");
        unitsCountInput = new JTextAreaWithPlaceholder("units");
        alreadyCreatedView = new JTextArea();
        selectedOfferInfo = new JTextArea();
        selectedOfferInfo.setEditable(false);
        alreadyCreatedView.setEditable(false);
        addOffer.setEnabled(false);
        endCreation.setEnabled(false);
        cancelCreation.setEnabled(false);


        newInvoice.addActionListener(e -> {
            newInvoice.setEnabled(false);
            addOffer.setEnabled(true);
            endCreation.setEnabled(true);
            cancelCreation.setEnabled(true);

            JOptionPane.showMessageDialog(appWindow, "choose client",
                    "info", JOptionPane.INFORMATION_MESSAGE);
            appWindow.startInvoice();
        });

        addOffer.addActionListener(e -> {
            appWindow.showSearchPanel();
        });

        endCreation.addActionListener(e -> {
            newInvoice.setEnabled(true);
            addOffer.setEnabled(false);
            endCreation.setEnabled(false);
            cancelCreation.setEnabled(false);
            // TODO: make sure that database does not need to know that we are done, or handle it
        });

        cancelCreation.addActionListener(e -> {
            newInvoice.setEnabled(true);
            addOffer.setEnabled(false);
            endCreation.setEnabled(false);
            cancelCreation.setEnabled(false);
            // TODO: SQL stuff -> erase entries related to started invoice
        });

        // display
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 10, 0, 0);
        gc.fill = GridBagConstraints.BOTH;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 4;
        gc.weighty = 8;
        gc.weightx = 0;
        panel.add(alreadyCreatedView, gc);

        gc.gridy++;
        gc.gridwidth = 3;
        gc.weighty = 0.5;
        panel.add(selectedOfferInfo, gc);

        gc.gridx += 3;
        gc.weightx = 1;
        panel.add(unitsCountInput, gc);

        gc.fill = GridBagConstraints.NONE;
        gc.gridwidth = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy++;
        panel.add(newInvoice, gc);

        gc.gridx++;
        panel.add(addOffer, gc);

        gc.gridx++;
        panel.add(cancelCreation, gc);

        gc.gridx++;
        panel.add(endCreation, gc);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 20, 20);
        setBorder(padding);
    }

    public void setOffer(JoinedOfferItem offer) {
        unitsCountInput.setText("");
        selectedOfferInfo.setText(offer.toString());
        currentOffer = offer;
    }

    public void setClient(ClientItem client) {
        // TODO: here insert into invoices new entry based on client got
        //  also set internal invoice id
        invoiceID = -1;
        appWindow.nextState(); // next state is INVOICE_LINE, where we will be getting offers
    }
}
