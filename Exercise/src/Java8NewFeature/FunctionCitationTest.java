package Java8NewFeature;

import CollectionTest.Person;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionCitationTest
{
    @Test
    public void test()
    {
        //对象：：非静态方法
         Consumer<String> consumer=s -> System.out.println(s);
         consumer.accept("hahah");
        System.out.println("******lambda写法*******");
        PrintStream ps = System.out;
        Consumer<String> consumer1=ps::println;
        consumer1.accept("hehe");
        System.out.println("******方法引用写法*******");

        Person person = new Person("li", 28);
        Supplier<String> supplier=()->person.getName();
        System.out.println(supplier.get());
        System.out.println("******lambda写法*******");
        Supplier<String> supplier1=person::getName;
        System.out.println(supplier1.get());
    }
    @Test
    public void test1()
    {
        //类：：静态方法
        Function<Double,Long> function=new Function<Double, Long>()
        {
            @Override
            public Long apply(Double aDouble)
            {
                return Math.round(aDouble);
            }
        };
        System.out.println(function.apply(3.6));
        System.out.println("*******原写法******");
        Function<Double,Long> function1=aDouble -> Math.round(aDouble);
        System.out.println(function.apply(3.6));
        System.out.println("*******lambda写法******");
        Function<Double,Long> function2=Math::round;
        System.out.println(function.apply(3.6));
    }
    @Test
    public void test2()
    {
        //类：：静态方法
        Comparator<Integer> comparator=(i,j)->Integer.compare(i,j);
        System.out.println(comparator.compare(22, 33));
        System.out.println("*******lambda写法******");
        Comparator<Integer> comparator1=Integer::compare;
        System.out.println(comparator.compare(44, 33));
    }

}
