package Java8NewFeature;

import employeeTest.Employee;
import employeeTest.MyDate;
import employeeTest.SalariedEmployee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPItest1
{
    //中间操作
    @Test
    public void test()
    {
    //map,flatMap
        //exercise:筛选名字长度大于三的员工
        List<SalariedEmployee>  list=new ArrayList<>();
        SalariedEmployee se1 = new SalariedEmployee("马化腾", 1, new MyDate(1980,2,2),4565);
        SalariedEmployee se2 = new SalariedEmployee("扎克伯格", 2, new MyDate(1970,1,2),7664);
        SalariedEmployee se3 = new SalariedEmployee("马云", 3, new MyDate(1990,3,2),2150);
        SalariedEmployee se4 = new SalariedEmployee("比尔盖茨", 4, new MyDate(1975,6,3),8510);
        list.add(se1);
        list.add(se2);
        list.add(se3);
        list.add(se4);
        Stream<SalariedEmployee> stream = list.stream();
        Stream<String> nameStream = stream.map(salariedEmployee -> salariedEmployee.getName()); //不需要New salariedEmployee
        nameStream.filter(s -> s.length()>3).forEach(System.out::println);
        System.out.println("*********************");
    //sorted,sorted(Comparator c)
        //exercise1: 按salary倒序排序
        Stream<SalariedEmployee> stream1 = list.stream();
        stream1.sorted((s1,s2)->-Double.compare(s1.getMonthlySalary(),s2.getMonthlySalary())).forEach(System.out::println);
    //filter,limit,skip,distinct
        System.out.println("*********************");
        Stream<SalariedEmployee> stream2 = list.stream();
        stream2.filter(s->s.getNumber()>2).forEach(System.out::println);
        System.out.println("*********************");
        Stream<SalariedEmployee> stream3 = list.stream();
        stream3.limit(2).forEach(System.out::println);
        System.out.println("*********************");
        Stream<SalariedEmployee> stream4 = list.stream();
        stream4.skip(2).forEach(System.out::println);
        System.out.println("*********************");
        SalariedEmployee se5 = new SalariedEmployee("比尔盖茨1", 4, new MyDate(1975,6,3),8510);
        list.add(se4);
        list.add(se5);
        Stream<SalariedEmployee> stream5 = list.stream();
        stream5.distinct().forEach(System.out::println);

    }
}
