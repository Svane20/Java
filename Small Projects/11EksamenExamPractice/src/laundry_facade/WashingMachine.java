
package laundry_facade;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author erso
 */
public class WashingMachine implements LaundryMachine{
    
    private String model;
    private Map<Integer, WashProgram> progMap;
    
    public WashingMachine(String model)
    {
        this.model = model;
        progMap = new TreeMap<>();
    }
    
    public void addProgram(int code, String name, double  price){
        progMap.put(code, new WashProgram(name, price));
    }

    @Override
    public String getModel()
    {
        return model;
    }

 
     @Override
    public double getPrice(int prog)
    {
        return progMap.get(prog).getPrice();
    }

    @Override
    public String getProgName(int prog)
    {
        return progMap.get(prog).getName();
    }

    @Override
    public String toString()
    {
        return model + "\n" + progMap +"\n";
    }
    
//    private class WashProgram{
//        private String name;
//        private double price;
//
//        public WashProgram(String name, double price)
//        {
//            this.name = name;
//            this.price = price;
//        }
//
//        public String getName()
//        {
//            return name;
//        }
//
//        public double getPrice()
//        {
//            return price;
//        }
//
//        @Override
//        public String toString()
//        {
//            return name + ": " + price +"\n";
//        }
//        
//        
//        
//    }

    
}
