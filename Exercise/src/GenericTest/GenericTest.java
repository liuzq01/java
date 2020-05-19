package GenericTest;

import org.junit.Test;

import java.util.List;

public class GenericTest
{
    @Test
    public void test()
    {
        //实例化时指定T的具体类型
        Student<String> stu= new Student<>("liu",28,"007");
        stu.setId("996");
        //...
        System.out.println(stu);
        Student<String> ss=new Student<String>();
        Integer[] array=new Integer[3];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        //泛型方法调用时，指明其具体类型(跟实例化没关系，所以泛型方法可以是静态的)
        List<Integer> integers = ss.copyArraytoList(array);
        System.out.println(integers);
    }
}
