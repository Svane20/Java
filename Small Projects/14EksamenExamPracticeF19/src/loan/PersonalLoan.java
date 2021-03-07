package loan;

public class PersonalLoan extends Loan {

    private int personalFee = 1000;
    public PersonalLoan(int loanID, String customer, double loanAmount, int term) {
        super(loanID, customer, loanAmount, term);
        this.interestRate = 5;
    }

    @Override
    public double getTotal(){
      double t = loanAmount + personalFee;
        for(int i = 0; i <term; i++){
            t += t * interestRate / 100;
        }

        return  t;

       // return personalFee+ loanAmount * Math.pow((1+getInterestRate()), term);
    }
}
