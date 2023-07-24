/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackacc2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Elazizbellah
 */
public class AccountInfo {

    private String Id;
    private double CurrentBalance;
    private String CreditCardNumber;

    private ArrayList<String> holders;

    //2
    public AccountInfo() {
        holders = new ArrayList<>();
    }

    public String getId() {
        return Id;
    }

    public double getCurrentBalance() {
        return CurrentBalance;
    }

    public void setCurrentBalance(double CurrentBalance) {
        this.CurrentBalance = CurrentBalance;
    }

    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    public AccountInfo(double CurrentBalance, String CreditCardNumber) {
        this.Id = java.util.UUID.randomUUID().toString();

        this.CurrentBalance = CurrentBalance;
        this.CreditCardNumber = CreditCardNumber;
    }

}
