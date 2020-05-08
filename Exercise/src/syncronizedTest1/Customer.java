package syncronizedTest1;

import java.util.concurrent.locks.ReentrantLock;

public class Customer implements Runnable
{
    private Account account;
    private static ReentrantLock lock=new ReentrantLock(true);
    public Customer(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            lock.lock();
            account.deposit(1000);
            lock.unlock();
        }

    }
}
