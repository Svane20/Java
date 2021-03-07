package laundry_facade;

/**
 *
 * @author erso
 */
public interface LaundryMachine
{

    String getModel();

    //void setPrice(int prog, double price);

    double getPrice(int prog);

    String getProgName(int prog);
}
