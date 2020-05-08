package syncronizedTest;

public class SynTest
{
    public static void main(String[] args)
    {
        Deposit deposit=new Deposit();
        Thread thread = new Thread(deposit);
        Thread thread1 = new Thread(deposit);
        thread.start();
        thread1.start();
    }
}
