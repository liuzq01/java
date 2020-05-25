package Java9to11;

import org.junit.Test;

import java.util.ArrayList;

public class Java10Test
{
    //局部变量类型推断
    @Test
    public void test()
    {
//      int i=10;
        var j=22;

//      ArrayList<Integer> integers = new ArrayList<>();
        var integers1 = new ArrayList<Integer>();
        integers1.add(j);
        for (var k:integers1)
        {
            System.out.println(k);
        }
    }
}
