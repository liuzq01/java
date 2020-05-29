package exercise1;

import org.junit.Test;

public class Exercise1_11
{
    @Test
    public void test()
    {
        double sum=0;
        sum=(1.0/7-1.0/13+1.0/45)*5*365*24*3600+312032486;
        System.out.println(sum);
    }
}
