/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import java.util.ArrayList;

/**
 * Udleveret til VOP exam F19 20190603
 * @author erso
 */
public class LoanDriver {

    public static void main(String[] args) {
       // Fjern udkommenteringerne, når klasserne er implementeret.
        ArrayList<LoanInterface> list = new ArrayList<>();
        list.add(new PersonalLoan(1, "Person 1", 200000, 3));
        list.add(new BusinessLoan(2, "Business 1", 500000, 5));
        System.out.println(list);
    }
    
}
