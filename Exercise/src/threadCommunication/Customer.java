package threadCommunication;

import static threadCommunication.Productor.STR;

public class Customer implements Runnable
{
    private Product pro;
    private int num; //消费数量

    public Customer(Product pro)
    {
        this.pro = pro;
    }

    public int getCusNum()
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
                if (pro.getProduct() <= 0)
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
                    int ran = (int)(Math.random() * 5);
                    int tem =pro.getProduct();
                    num= Math.min(ran,tem);
                    pro.reducePro(num);
                    try
                    {
                        Thread.sleep(300);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"  消费：" + num);
                    System.out.println(Thread.currentThread().getName()+"  当前数量："+pro.getProduct());
                    STR.notify();
                }
        }
        }
    }
}
