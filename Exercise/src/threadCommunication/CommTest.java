package threadCommunication;

import java.util.concurrent.Callable;

public class CommTest
{
    public static void main(String[] args)
    {
        Product pro=new Product(10);
        Productor productor = new Productor(pro);
        Customer customer = new Customer(pro);
        Thread thread1 = new Thread(productor);
        Thread thread2 = new Thread(customer);
        Thread thread3 = new Thread(customer);
        thread1.setName("生产者");
        thread2.setName("消费者1");
        thread3.setName("消费者2");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
