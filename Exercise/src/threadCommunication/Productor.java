package threadCommunication;

public class Productor implements Runnable
{
    public static final String STR = "he"; //公共锁
    private Product pro;
    private int num; //生产数量
    private final int SUM=20; //最大值
    public Productor(Product pro)
    {
        this.pro = pro;
    }

    public int getProNum()
    {
        return num;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (STR)
            {
                if (pro.getProduct() >= SUM)
                {
                    try
                    {
                        STR.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                } else
                {
                    int ran = (int) (Math.random() * 5);
                    int tem = SUM - pro.getProduct();
                    num = Math.min(ran, tem);
                    pro.increasePro(num);
                    try
                    {
                        Thread.sleep(300);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "  生产：" + num);
                    System.out.println(Thread.currentThread().getName() + "  当前数量：" + pro.getProduct());
                    STR.notify();
                }
            }
        }
    }
}
