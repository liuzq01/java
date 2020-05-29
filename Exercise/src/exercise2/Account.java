package exercise2;

import java.util.Date;

public class Account
{
    private int id=0;
    private double balance=0;
    private static double interestRate=0;
    private Date dateCreated;
    public Account()
    {

    }
    public Account(int id ,double balance)
    {
        this.id=id;
        this.balance=balance;
    }
    public int getID()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id=id;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public static double getInterestRate()
    {
        return interestRate;
    }

    public static void setInterestRate(double interestRate)
    {
        Account.interestRate = interestRate;
    }

    public Date getDateCreated()
    {
        dateCreated= new Date();    //在方法中初始化
        return dateCreated;
    }
    public double getMonthlyInterestRate()
    {
        return interestRate/12;
    }
    public void withDraw(double money)
    {
        balance-=money;
    }
    public void deposit(double money)
    {
        balance+=money;
    }
}

