package threadCommunication;

public class Clerk implements  Runnable
{
    private Product pro;

    public Clerk(Product pro)
    {
        this.pro = pro;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"当前数量： "+pro.getProduct());
    }
}
