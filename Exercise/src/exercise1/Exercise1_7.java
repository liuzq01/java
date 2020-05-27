package exercise1;

import org.junit.Test;

public class Exercise7
{
    //借助泰勒公式估算PI的值
    @Test
    public void test()
    {
        double sum=0;
        for (int i = 1; i < 100; i++)
        {
            sum+=(Math.pow(-1,i-1))*4.0/(2.0*i-1);
        }
        System.out.println(sum);    //3.1516934060711166
        System.out.println(sum-Math.PI);//0.010100752481323472 大
    }
    @Test
    public void test2()
    {
        //从后往前算，误差稍小(抵消误差)
        double sum=0;
        for (int i = 99; i > 0; i--)
        {
            sum+=(Math.pow(-1,i-1))*4.0/(2.0*i-1);
        }
        System.out.println(sum);    //3.1516934060711157
        System.out.println(sum-Math.PI);//0.010100752481322584  小
    }
}
