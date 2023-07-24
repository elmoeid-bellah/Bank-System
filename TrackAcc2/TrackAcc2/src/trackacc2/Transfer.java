/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackacc2;

import java.util.Date;

/**
 *
 * @author Elazizbellah
 */
public class Transfer extends Transaction {

    public Transfer(Holder Sender, Holder Receiver, double Amount) {
        super(Sender, Receiver, Amount);
    }

    @Override
    public boolean DoTransaction() {
        AccountInfo currentAccInfo = Sender.getAccountInfo();
        double currentBalance = currentAccInfo.getCurrentBalance();
        if (Amount > currentBalance || Amount <= 0) {
            return false;
        }
        currentBalance -= Amount;
        currentAccInfo.setCurrentBalance(currentBalance);

        AccountInfo receiverAccInfo = Receiver.getAccountInfo();
        double receiverBalance = receiverAccInfo.getCurrentBalance();
        receiverBalance += Amount;
        receiverAccInfo.setCurrentBalance(receiverBalance);

        return true;
    }

}
