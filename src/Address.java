public class Address
{
    private String nameString;
    private String streetString;
    private String cityString;
    private String stateString;
    private String zipCodeString;

    public Address(String addressName, String addressStreet, String addressCity, String addressState, String addressZipCode)
    {
        nameString = addressName;
        streetString = addressStreet;
        cityString = addressCity;
        stateString = addressState;
        zipCodeString = addressZipCode;
    }

    public String formatAddress()
    {
        return nameString + "\n" + streetString + "\n" + cityString + ", " + stateString + " " + zipCodeString;
    }
}
