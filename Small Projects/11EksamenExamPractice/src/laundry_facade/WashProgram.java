package laundry_facade;

/**
 *
 * @author erso
 */
public class WashProgram
{

    private String name;
    private double price;

    public WashProgram(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return name + ": " + price + "\n";
    }

}
