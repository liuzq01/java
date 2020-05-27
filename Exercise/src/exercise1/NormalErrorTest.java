package exercise1;

import org.junit.Test;

public class NormalErrorTest
{
    @Test
    public void test()
    {
        int i=1;
        int j=2;
        double a=(i+j)/2;
        double b=(i+j)/2.0;
        System.out.println(a);//1.0
        System.out.println(b);//1.5
    }

}
