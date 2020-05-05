package threadTest;

public class WindowTest1
{
    public static void main(String[] args)
    {
        Window1 win=new Window1();
        new Thread(win).start();
        new Thread(win).start();
        new Thread(win).start();
    }
}
//创建多线程的方法2：实现Runnable接口

class Window1 implements Runnable
{
    private int total=100;

    @Override
    public void run()
    {
        while (total>0)
        {
            System.out.println(Thread.currentThread().getName()+": "+total);
            total--;
        }
    }
}
