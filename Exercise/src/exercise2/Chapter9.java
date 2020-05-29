package exercise2;

import org.junit.Test;

import java.util.Random;

public class Chapter9
{
    //exercise 9.4
    @Test
    public void test()
    {
        Random random = new Random(1000);
        int k=0;
        for (int i = 0; i < 50; i++)
        {
            k = random.nextInt(100);
            System.out.println(k);
        }
    }
}
