/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackacc2;

/**
 *
 * @author Elazizbellah
 */
public class Withdrawl extends Transaction {

    public Withdrawl(Holder Sender, double Amount) {
        super(Sender, Amount);
    }

    @Override
    public boolean DoTransaction() {
        AccountInfo currentAccInfo = Sender.getAccountInfo();
        double currentBalance = currentAccInfo.getCurrentBalance();
        if (Amount <= 0 || Amount > currentBalance) {
            System.out.println("Invalid amount for withdrawl");
            return false;
        }

        System.out.printf("Amount of %.2f withdrawn from Account%n", Amount);
        currentBalance -= Amount;
        currentAccInfo.setCurrentBalance(currentBalance);
        
        System.out.printf("Current Balance is: %.2f%n", currentBalance);
        return true;
    }

}
