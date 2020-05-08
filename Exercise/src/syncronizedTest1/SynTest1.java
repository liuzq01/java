package syncronizedTest1;

public class SynTest1
{
    public static void main(String[] args)
    {
        Account account=new Account(0);
        Customer customer=new Customer(account);
        Customer customer1=new Customer(account);
        new Thread(customer).start();
        new Thread(customer1).start();
    }
}
