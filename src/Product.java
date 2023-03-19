public class Product
{
    private String descriptionString;
    private double priceDouble;

    public Product(String productDescription, double productPrice)
    {
        descriptionString = productDescription;
        priceDouble = productPrice;
    }

    public String getDescription(){return descriptionString;}

    public double getPrice(){return priceDouble;}
}
