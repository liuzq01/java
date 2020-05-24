package Java8NewFeature;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class lambdaTest
{
    @Test
    public void test()
    {
        //原来的语句
        Comparator<Integer> comparator = new Comparator<>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(13, 54));
        System.out.println("***********原来的语句***************");

        //用lambda简写的语句
        Comparator<Integer> comparator1 = (o1, o2) ->
        {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        System.out.println(comparator1.compare(33, 22));
        System.out.println("************lambda简写的语句**************");

        //只有一条执行语句
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println(comparator2.compare(33, 22));
        System.out.println("*************只有一条执行语句*************");

        //只有1个形参
        Consumer<String> consumer1 = s -> System.out.println(s);

        consumer1.accept("dun er ~");
        System.out.println("**************只有1个形参************");

        //原语句
        Consumer<String> consumer = new Consumer<>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        };
        consumer.accept("haha");
    }
}
