import java.util.ArrayList;

public class Invoice
{
    private Address billingAddress;
    private ArrayList<LineItem> itemsArrayList;

    public Invoice(Address billingAddress)
    {
        itemsArrayList = new ArrayList<>();
        this.billingAddress = billingAddress;
    }

    public void addProduct(Product productProduct, int quantityInt)
    {
        LineItem liItem = new LineItem(productProduct, quantityInt);
        itemsArrayList.add(liItem);
    }

    public String formatInvoice()
    {
        String r = "                       I N V O I C E\n\n" + billingAddress.formatAddress() + "\n";
        for(int i = 0; i < 58; i++){r = r+"=";}
        r = r + String.format("\n\n%-30s%8s%7s%9s\n", "Description", "Price", "Qty", "Total");
        for(int i = 0; i < 58; i++){r = r+"-";}
        r = r+"\n";
        for(LineItem itemLI : itemsArrayList){r = r + itemLI.productLineFormat() + "\n";}
        for(int i = 0; i < 58; i++){r = r+"=";}
        r = r+"\n";
        r = r + String.format("\nAMOUNT DUE: $%8.2f", getAmountDue());
        return r;
    }

    private double getAmountDue()
    {
        double amountDue = 0;
        for (LineItem itemLI: itemsArrayList){amountDue = amountDue + itemLI.getTotalPrice();}
        return amountDue;
    }
}
