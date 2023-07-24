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
public class Holder {

    private String Id;
    private String Name;
    private char Gender;
    private String NationalId;
    private AccountInfo AccountInfo;

    public Holder(String Name, char Gender, String NationalId, AccountInfo AccountInfo) {
        this.Id = java.util.UUID.randomUUID().toString();
        this.Name = Name;
        this.Gender = Gender;
        this.NationalId = NationalId;
        this.AccountInfo = AccountInfo;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public String getNationalId() {
        return NationalId;
    }

    public void setNationalId(String NationalId) {
        this.NationalId = NationalId;
    }

    public AccountInfo getAccountInfo() {
        return AccountInfo;
    }

    public void setAccountInfo(AccountInfo AccountInfo) {
        this.AccountInfo = AccountInfo;
    }

}
