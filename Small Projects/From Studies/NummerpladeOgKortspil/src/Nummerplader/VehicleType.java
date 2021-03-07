package Nummerplader;

public class VehicleType {
    private String type;
    private int min;
    private int max;

    public VehicleType(String type, int min, int max) {
        this.type = type;
        this.min = min;
        this.max = max;
    }
    
    public boolean isA(int number){
        return number >= min && number <= max;
    }
    
    public String getVehicleType(){
        return type;
    }

}
