import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends JFrame
{
    JPanel wholePanel;
    JPanel addressPanel, addressPanelOne, addressPanelTwo, itemPanelOne, itemButtonPanel, addressButtonPanel, invoicePanelOne, buttonsTwoPanel, invoicePanel, productPanel;

    JTextField nameTF, streetTF, cityTF, stateTF, zipCodeTF, descriptionTF, quantityTF, priceTF;

    JLabel nameL, streetL, cityL, stateL, zipCodeL, descriptionL, quantityL, priceL;

    JButton addProductButton, clearButton, quitButton, setAddressButton;

    JTextArea invoiceTA;
    JScrollPane scrollPaneVariable;

    Font fontM = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    Address invoiceAddress;
    Invoice newInvoice;

    int invalidA = 1;

    public InvoiceFrame()
    {
        wholePanel = new JPanel();
        createAddressPanel();
        wholePanel.add(addressPanel);
        createProductPanel();
        wholePanel.add(productPanel);
        createInvoicePanel();
        wholePanel.add(invoicePanel);
        add(wholePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700,700);
    }

    public void createAddressPanel()
    {
        addressPanel = new JPanel();
        addressPanel.setLayout(new GridLayout(3,1));
        createAddressOne();
        addressPanel.add(addressPanelOne);
        createAddressTwo();
        addressPanel.add(addressPanelTwo);
        createAddressButton();
        addressPanel.add(addressButtonPanel);
    }
    public void createAddressOne()
    {
        addressPanelOne = new JPanel();
        nameL = new JLabel("Name: ", JLabel.RIGHT);
        nameTF = new JTextField(33);
        streetL = new JLabel("    Street: ", JLabel.RIGHT);
        streetTF = new JTextField(30);

        nameL.setFont(fontM);
        nameTF.setFont(fontM);
        streetL.setFont(fontM);
        streetTF.setFont(fontM);

        addressPanelOne.add(nameL);
        addressPanelOne.add(nameTF);
        addressPanelOne.add(streetL);
        addressPanelOne.add(streetTF);
    }
    public void createAddressTwo()
    {
        addressPanelTwo = new JPanel();
        cityL = new JLabel("City: ", JLabel.RIGHT);
        cityTF = new JTextField(25);
        stateL = new JLabel("     State: ", JLabel.RIGHT);
        stateTF = new JTextField(15);
        zipCodeL = new JLabel("     Zip Code: ", JLabel.RIGHT);
        zipCodeTF = new JTextField(6);

        cityL.setFont(fontM);
        cityTF.setFont(fontM);
        stateL.setFont(fontM);
        stateTF.setFont(fontM);
        zipCodeL.setFont(fontM);
        zipCodeTF.setFont(fontM);

        addressPanelTwo.add(cityL);
        addressPanelTwo.add(cityTF);
        addressPanelTwo.add(stateL);
        addressPanelTwo.add(stateTF);
        addressPanelTwo.add(zipCodeL);
        addressPanelTwo.add(zipCodeTF);
    }
    public void createAddressButton()
    {
        addressButtonPanel = new JPanel();
        setAddressButton = new JButton("Set Address");
        setAddressButton.addActionListener((ActionEvent ae) ->
        {
            if(nameTF.getText().equals("") || streetTF.getText().equals("") || cityTF.getText().equals("") || stateTF.getText().equals("") || zipCodeTF.getText().equals("")){JOptionPane.showMessageDialog(null, "Invalid Address"); invalidA = 1;}
            else
            {
                invoiceAddress = new Address(nameTF.getText(), streetTF.getText(), cityTF.getText(), stateTF.getText(), zipCodeTF.getText());
                newInvoice = new Invoice(invoiceAddress);
                invalidA = 0;
                addProductButton.setEnabled(true);
            }
        });
        addressButtonPanel.add(setAddressButton);
    }

    public void createProductPanel()
    {
        productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(2,1));
        createItemOne();
        productPanel.add(itemPanelOne);
        createItemButtonPanel();
        productPanel.add(itemButtonPanel);
    }
    public void createItemOne()
    {
        itemPanelOne = new JPanel();
        descriptionL = new JLabel("Product Description:", JLabel.RIGHT);
        descriptionTF = new JTextField(26);
        quantityL = new JLabel("  Quantity:", JLabel.RIGHT);
        quantityTF = new JTextField(4);
        priceL = new JLabel("  Price: $", JLabel.RIGHT);
        priceTF = new JTextField(8);

        descriptionL.setFont(fontM);
        descriptionTF.setFont(fontM);
        quantityL.setFont(fontM);
        quantityTF.setFont(fontM);
        priceL.setFont(fontM);
        priceTF.setFont(fontM);

        itemPanelOne.add(descriptionL);
        itemPanelOne.add(descriptionTF);
        itemPanelOne.add(quantityL);
        itemPanelOne.add(quantityTF);
        itemPanelOne.add(priceL);
        itemPanelOne.add(priceTF);
    }
    public void createItemButtonPanel()
    {
        itemButtonPanel = new JPanel();
        addProductButton = new JButton("Add Product");
        addProductButton.setEnabled(false);

        addProductButton.addActionListener((ActionEvent ae) ->
        {
            if(invalidA == 1){JOptionPane.showMessageDialog(null, "Must enter an address.");}
            else if(descriptionTF.getText().equals("") || priceTF.getText().equals("") || quantityTF.getText().equals("")){JOptionPane.showMessageDialog(null, "Invalid Product.");}
            else
            {
                newInvoice.addProduct(new Product(descriptionTF.getText(), Double.parseDouble(priceTF.getText())), Integer.parseInt(quantityTF.getText()));
                descriptionTF.setText("");
                quantityTF.setText("");
                priceTF.setText("");
                invoiceTA.setText(newInvoice.formatInvoice());
            }
        });
        itemButtonPanel.add(addProductButton);
    }

    public void createInvoiceOne()
    {
        invoicePanelOne = new JPanel();
        invoiceTA = new JTextArea(20, 60);
        invoiceTA.setFont(fontM);
        invoiceTA.setEditable(false);
        scrollPaneVariable = new JScrollPane(invoiceTA);
        invoicePanelOne.add(scrollPaneVariable);
    }
    public void createInvoiceButtonsPanel()
    {
        buttonsTwoPanel = new JPanel();
        clearButton = new JButton("Clear");
        quitButton = new JButton("Quit");
        clearButton.addActionListener((ActionEvent ae) ->
        {
            nameTF.setText("");
            streetTF.setText("");
            cityTF.setText("");
            stateTF.setText("");
            zipCodeTF.setText("");
            descriptionTF.setText("");
            quantityTF.setText("");
            priceTF.setText("");
            invoiceTA.setText("");
        });
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));
        buttonsTwoPanel.add(clearButton);
        buttonsTwoPanel.add(quitButton);
    }
    public void createInvoicePanel()
    {
        invoicePanel = new JPanel();
        invoicePanel.setLayout(new BorderLayout());
        createInvoiceOne();
        invoicePanel.add(invoicePanelOne, BorderLayout.CENTER);
        createInvoiceButtonsPanel();
        invoicePanel.add(buttonsTwoPanel, BorderLayout.SOUTH);
    }
}
