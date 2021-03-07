package loan;

import java.util.Date;

public abstract class Loan implements LoanInterface {
   private int loanID;
   private static double primeInterest = 0.05;
   private String customer;
   protected double loanAmount;
   private Date startDate;
   protected int term;
   protected double interestRate;

    public Loan(int loanID, String customer, double loanAmount, int term) {
        if(loanAmount > 500000){
            this.loanAmount = 500000;
            System.out.println("Loan too high, the highest number is: 50000\n" );
        }
        if(term<1 || term > 5){
            this.term =SHORT_TERM;
            System.out.println("Invalid term, the standard term is now set to 1 year");
        }

        Date startdate = new Date();
        this.startDate = new Date();
        this.loanID = loanID;
        this.customer = customer;
        this.loanAmount = loanAmount;
        this.term = term;
    }

    @Override
    public double getTotal() {
        return loanAmount * Math.pow((1+getInterestRate()), term);

    }

    @Override
    public void setInterestRate() {
        this.interestRate = interestRate;

    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
    @Override
    public String toString(){
        return "\nFuskes Finans \n" + "Customer  =\t" + customer + "\ndate: \t" + startDate + "\nTerms:\t  "
                +term + "\nLoan amount: \t" + loanAmount + "\ntotal: \t " +getTotal();

    }

   }
