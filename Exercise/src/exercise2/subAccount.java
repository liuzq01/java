package exercise2;

import java.util.ArrayList;
import java.util.Date;

public class subAccount extends Account
{
    private String name;
    private ArrayList<Transaction> transactions=new ArrayList<>();
    private static double interestRate=0;

    public static double getInterestRate()
    {
        return interestRate;
    }

    public static void setInterestRate(double interestRate)
    {
        subAccount.interestRate = interestRate;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }

    public subAccount(String name, int id, double balance)
    {
        this.name = name;
        this.setId(id);
        this.setBalance(balance);
    }

    public void withDraw(double money)
    {
        super.withDraw(money);
        Transaction w = new Transaction('W', money, this.getBalance(), new Date().toString());
        transactions.add(w);
    }

    public void deposit(double money)
    {
        super.deposit(money);
        Transaction d = new Transaction('D', money, this.getBalance(), new Date().toString());
        transactions.add(d);
    }
}
