public class LineItem
{
    private int quantityInt;
    private Product productProduct;

    public LineItem(Product productProduct, int productQuantity)
    {
        this.productProduct = productProduct;
        quantityInt = productQuantity;
    }

    public double getTotalPrice(){return (productProduct.getPrice() * quantityInt);}

    public String productLineFormat()
    {
        return String.format("%-32s$%6.2f%6d%4s%8.2f", productProduct.getDescription(), productProduct.getPrice(), quantityInt, "$", getTotalPrice());
    }
}