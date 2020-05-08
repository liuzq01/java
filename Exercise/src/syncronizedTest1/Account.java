package syncronizedTest1;

public class Account
{
    private double balance;

    public Account(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }
    public  void  deposit(double balance)
    {
        this.balance+=balance;
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 余额： "+this.balance);
    }
}
