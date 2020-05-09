package executorsTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsTest
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10); //多态，ExecutorService是接口，实现类是ThreadPoolExecutor
        executorService.execute(new Even());
        executorService.execute(new Even());
        executorService.execute(new OddNumber());
//        ThreadPoolExecutor executorService1 = (ThreadPoolExecutor) executorService;   //转换为ThreadPoolExecutor类型后，可设置、管理线程池
//        executorService1.setCorePoolSize(15);
        executorService.shutdown();
    }

}
class Even implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            if (i%2==0)
            {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
class OddNumber implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            if (i%2 != 0)
            {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
