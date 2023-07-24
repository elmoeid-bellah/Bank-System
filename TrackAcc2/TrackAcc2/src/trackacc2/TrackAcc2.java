/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackacc2;

import java.util.ArrayList;
import java.util.Scanner;


public class TrackAcc2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Holder> holders = new ArrayList<>();

        ArrayList<Transaction> transactions = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int select;

        do {
            select = mainMenu(in);
            if (select == 1) {
                int selectAccount;
                do {
                    System.out.println("enter 1 to add user or 2 to go back");
                    selectAccount = in.nextInt();

                    if (selectAccount != 1) {
                        break;
                    }

                    Holder holder = createNewAccount(in);
                    if (holder != null) {
                        holders.add(holder);
                    }
                } while (selectAccount == 1);
            } else if (select == 2) {
                Holder currentHolder = userMenu(in, holders);
                int selectTransaction;
                do {
                    selectTransaction = transactionMenu(in);

                    if (selectTransaction == 4) {
                        break;
                    }
                    Transaction transaction = getTransaction(in, selectTransaction, currentHolder, holders);
                    if (transaction != null) {
                        transactions.add(transaction);
                    }
                } while (selectTransaction != 4);
            } else if (select == 3) {
                if (transactions.isEmpty()) {
                    System.out.println("No transactions found");
                }
                int viewTransactionType = viewTransactionMenu(in);
                if (viewTransactionType == 1) {
                    for (Transaction t : transactions) {
                        System.out.println(t.toString());
                    }
                } else if (viewTransactionType == 2) {
                    Transaction maxTransaction = transactions.get(0);
                    for (Transaction t : transactions) {
                        if (t.getAmount() > maxTransaction.getAmount()) {
                            maxTransaction = t;
                        }
                    }
                    System.out.println(maxTransaction.toString());
                }
            }

        } while (select != 4);

        System.out.println("Thanks for banking with us");
    }

    private static int mainMenu(Scanner in) {
        int select;
        do {
            System.out.println("1.create account");
            System.out.println("2.Make a transaction");
            System.out.println("3.View Transactions");
            System.out.println("4.exit");

            select = in.nextInt();
        } while (select < 1 || select > 4);

        return select;
    }

    private static Holder createNewAccount(Scanner in) {
        String creditCardNum1 = java.util.UUID.randomUUID().toString();
        System.out.println("enter your name and gender(m or f)");
        double balance1 = 0;
        AccountInfo account1 = new AccountInfo(balance1, creditCardNum1);
        String name1 = in.next();
        char gender1 = in.next().charAt(0);
        String nationalId1 = java.util.UUID.randomUUID().toString();
        Holder holder1 = new Holder(name1, gender1, nationalId1, account1);
        return holder1;
    }

    private static Holder userMenu(Scanner in, ArrayList<Holder> holders) {
        Holder currentHolder = null;
        do {
            System.out.println("Select your user from the users");
            for (int i = 0; i < holders.size(); ++i) {
                currentHolder = holders.get(i);
                System.out.println((i + 1) + ". " + currentHolder.getName());
            }
            int selectedUser = in.nextInt();
            if (selectedUser <= 0 || selectedUser > holders.size()) {
                System.out.println("Invalid user entered");
            }
            currentHolder = holders.get(selectedUser - 1);
        } while (currentHolder == null);

        return currentHolder;
    }

    private static Transaction getTransaction(Scanner in, int type, Holder currentHolder, ArrayList<Holder> holders) {
        Transaction transaction = null;
        System.out.println("Enter the amount");
        double amount = in.nextDouble();

        if (type == 1) {
            transaction = new Deposit(currentHolder, amount);
        } else if (type == 2) {
            transaction = new Withdrawl(currentHolder, amount);
        } else if (type == 3) {
            Holder receiver = userMenu(in, holders);
            transaction = new Transfer(currentHolder, receiver, amount);
        }

        if (transaction != null) {
            boolean transactionSuccess = transaction.DoTransaction();
            if (transactionSuccess) {
                System.out.println("transaction success. Check the text file for transaction details");
            } else {
                System.out.println("transaction failed. Check the text file for transaction details");
            }
        }

        return transaction;
    }

    private static int transactionMenu(Scanner in) {
        int transactionChoice;

        do {
            System.out.println("Enter 1 for deposit, 2 for withdrawl, 3 for transfer, 4 to go back");
            transactionChoice = in.nextInt();
        } while (transactionChoice < 1 || transactionChoice > 4);

        return transactionChoice;
    }

    private static int viewTransactionMenu(Scanner in) {
        int viewTransactionChoice;
        do {    
            System.out.println("Enter 1 to view all transactions or 2 to view the maximum transaction");
            viewTransactionChoice = in.nextInt();
        }while(viewTransactionChoice < 1 || viewTransactionChoice > 2);
        
        return viewTransactionChoice;
    }

}
