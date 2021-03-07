package laundry_facade;

/**
 *
 * @author erso
 */
public class TumbleDryer implements LaundryMachine
{

    private String model;
    
    private double pricePerMinute;
    

    public TumbleDryer(String model)
    {
        this.model = model;
  
    }

    @Override
    public String getModel()
    {
        return model;
    }

  
    public void setPrice(double pricePerMinute)
    {
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public double getPrice(int minutes)
    {
        return pricePerMinute * minutes;
    }

    @Override
    public String toString()
    {
        return model + " Minutpris: " + pricePerMinute + "\n";
    }

    @Override
    public String getProgName(int prog)
    {
        return "Tørring i "+ prog + " minutter";
    }

}
