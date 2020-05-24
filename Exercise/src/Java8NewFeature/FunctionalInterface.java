package Java8NewFeature;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterface
{
    //Consumer接口
    @Test
    public void test0()
    {
        happy(400, new Consumer<Integer>()
        {
            @Override
            public void accept(Integer integer)
            {
                System.out.println("hah: " + integer);
            }
        });
    }

    public void happy(int money, Consumer<Integer> consumer)
    {
        consumer.accept(money);
    }

    //lambda表达式的写法
    public void test2()
    {
        System.out.println("**************");
        happy(200, integer -> System.out.println("haha: " + integer));
    }

    //Predicate接口
    @Test
    public void test3()
    {
        //原语句
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(22);
        integers.add(33);
        integers.add(44);
        integers.add(55);
        integers.add(66);
        FunctionalInterface functionalInterface = new FunctionalInterface();
        ArrayList arrayList = functionalInterface.addL( integers, new Predicate<>()
        {
            @Override
            public boolean test(Integer integer)
            {
                return integer > 40;
            }
        });
        System.out.println(arrayList);
        System.out.println("**************");
        //lambda写法
        ArrayList arrayList1 = functionalInterface.addL(integers, integer -> integer > 50);
        System.out.println(arrayList1);
    }
    public ArrayList addL(ArrayList<Integer> arrayList, Predicate<Integer> predicate)
    {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (Integer integer:arrayList)
        {
            if (predicate.test(integer))
            {
                arrayList1.add(integer);
            }
        }
        return arrayList1;
    }

}
