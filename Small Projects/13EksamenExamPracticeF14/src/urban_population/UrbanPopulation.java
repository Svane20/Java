package urban_population;

/**
 *
 * @author erso
 */
public class UrbanPopulation implements Comparable<UrbanPopulation>{

    private String country;
    private int pop1980;
    private int pop2008;

    public UrbanPopulation(String country, int pop1980, int pop2008) {
        this.country = country;
        this.pop1980 = pop1980;
        this.pop2008 = pop2008;
    }

    
    
    public int getDiff(){
        return pop2008 - pop1980;
    }

    @Override
    public int compareTo(UrbanPopulation o) {
        int i = this.getDiff() - o.getDiff();
        if(i == 0){
            i = this.country.compareTo(o.country);
        }
        return i;
        
    }

    @Override
    public String toString() {
        return country + " 1980: " + pop1980 + " 2008: " + pop2008 + " Dif: " + getDiff() + '\n';
    }
    
 }
