/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackacc2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Elazizbellah
 */
public abstract class Transaction {
// private and public getter and setter

    Holder Sender;
    Holder Receiver;
    private Date TransactionDate;
    private String Id;
    double Amount;

    public Holder getSender() {
        return Sender;
    }

    public void setSender(Holder Sender) {
        this.Sender = Sender;
    }

    public Holder getReceiver() {
        return Receiver;
    }

    public void setReceiver(Holder Receiver) {
        this.Receiver = Receiver;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public Transaction(Holder Sender, double Amount) {
        SetTransactionInfo(Sender, Amount);
    }

    public Transaction(Holder Sender, Holder Receiver, double Amount) {
        SetTransactionInfo(Sender, Amount);
        this.Receiver = Receiver;

    }

    private void SetTransactionInfo(Holder Sender1, double Amount1) {
        this.Sender = Sender1;
        this.Id = java.util.UUID.randomUUID().toString();

        this.TransactionDate = new Date();
        this.Amount = Amount1;
    }
    
    @Override
    public String toString(){
        String date = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(TransactionDate);
        return "Transaction on: " + date 
                + ", type: " + this.getClass().getSimpleName() 
                + ", from: " + Sender.getName() 
                + ", amount: " + Amount;
    }

    public abstract boolean DoTransaction();

}
