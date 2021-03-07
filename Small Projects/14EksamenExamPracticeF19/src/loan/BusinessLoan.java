package loan;

public class BusinessLoan extends Loan {
    public BusinessLoan(int loanID, String customer, double loanAmount, int term) {
        super(loanID, customer, loanAmount, term);
        this.interestRate = 4;
    }


    @Override
    public double getTotal() {
        double t = loanAmount;
        for (int i = 0; i < term; i++) {
            t += t * interestRate / 100;
        }

        return t;
    }
}
