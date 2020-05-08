package syncronizedTest;

import java.util.concurrent.locks.ReentrantLock;

public class Deposit implements Runnable
{
    private double balance;
    ReentrantLock reentrantLock=new ReentrantLock(true);
    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            reentrantLock.lock();
            balance+=1000;  //两线程分别在何时拿到balance的值?取出、存入内存所花的时间多长?影响线程执行的结果?
            System.out.println(Thread.currentThread().getName()+"  余额： "+balance);
            reentrantLock.unlock();
        }
    }
}
