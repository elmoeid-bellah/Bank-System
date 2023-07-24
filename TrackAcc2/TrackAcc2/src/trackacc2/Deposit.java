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
public class Deposit extends Transaction {

    public Deposit(Holder Sender, double Amount) {
        super(Sender, Amount);
    }

    @Override
    public boolean DoTransaction() {
        FileWriterHelper.writeToFile("transaction", "Started :: " + toString());
        if (Amount <= 0) {
            FileWriterHelper.writeToFile("transaction", "\tA negative amount cannot be deposited");
            return false;
        }

        AccountInfo currentAccInfo = Sender.getAccountInfo();
        double currentBalance = currentAccInfo.getCurrentBalance();
        currentBalance += Amount;
        currentAccInfo.setCurrentBalance(currentBalance);
        FileWriterHelper.writeToFile("transaction", "\tSuccessfully deposited");
        return true;
    }

}
