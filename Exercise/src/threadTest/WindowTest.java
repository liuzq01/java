package threadTest;

public class WindowTest
{
    public static void main(String[] args)
    {
        Window window=new Window();
        window.start();
        Window window1=new Window();
        window1.start();
        Window window2=new Window();
        window2.start();

    }
}
//创建多线程的方法1：继承Thread类
class Window extends Thread
{
    private static int Total=100;   //总票数为100张

    @Override
    public void run()
    {
        while (Total>0)
        {
            System.out.println(Thread.currentThread().getName()+": "+ Total);
            Total=Total-1;
        }
    }
}
