package exercise2;

import org.junit.Test;

public class Chapter11
{
    //exercise 11.8
    @Test
    public void test()
    {
        subAccount liu = new subAccount("liu", 1122, 1000);
        subAccount.setInterestRate(0.015);
        liu.deposit(30);
        liu.deposit(40);
        liu.deposit(50);
        liu.withDraw(5);
        liu.withDraw(4);
        liu.withDraw(2);
        System.out.println( "账户："+ liu.getName()+" "+subAccount.getInterestRate()+" "+liu.getBalance());
        System.out.println("交易记录："+'\n'+ liu.getTransactions());
    }
}
