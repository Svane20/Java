package loan;

/**
 *
 * @author erso  
 *  Udleveret til VOP exam F19 20190603
 */
public interface LoanInterface {

    static final String COMPANY = "Fuskes Finans Aps";
    static final int SHORT_TERM = 1;
    static final int MIDDLE_TERM = 3;
    static final int LONG_TERM = 5;
    static final double MAX_LOAN = 500000.00;
    static final double PRIVATE_INTEREST = 5.0; 
    static final double BUSINESS_INTEREST = 4.0;
    
    double getTotal();
    void setInterestRate();
    double getInterestRate();

}
