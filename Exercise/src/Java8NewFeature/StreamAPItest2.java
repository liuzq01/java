package Java8NewFeature;

import employeeTest.MyDate;
import employeeTest.SalariedEmployee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPItest2
{
 //终止操作
    @Test
        public void test()
        {
            // allMatch,anyMatch, noneMatch,findFirst,findAny,count,max,min,forEach
            List<SalariedEmployee> list=new ArrayList<>();
            SalariedEmployee se1 = new SalariedEmployee("马化腾", 1, new MyDate(1980,2,2),4565);
            SalariedEmployee se2 = new SalariedEmployee("扎克伯格", 2, new MyDate(1970,1,2),7664);
            SalariedEmployee se3 = new SalariedEmployee("马云", 3, new MyDate(1990,3,2),2150);
            SalariedEmployee se4 = new SalariedEmployee("比尔盖茨", 4, new MyDate(1975,6,3),8510);
            list.add(se1);
            list.add(se2);
            list.add(se3);
            list.add(se4);
            Stream<SalariedEmployee> stream = list.stream();
            boolean b = stream.allMatch(s -> s.getMonthlySalary() > 2000);
            System.out.println(b);
            System.out.println("*******allMatch************");
            boolean b1 = list.stream().anyMatch(s -> s.getName().startsWith("马"));
            System.out.println(b1);
            System.out.println("********anyMatch***********");
            boolean b2 = list.stream().noneMatch(salariedEmployee -> salariedEmployee.getName().contains("李"));
            System.out.println(b2);
            System.out.println("*********noneMatch**********");
            Optional<SalariedEmployee> first = list.stream().findFirst();
            System.out.println(first);
            System.out.println("*********findFirst**********");
            Optional<SalariedEmployee> any = list.parallelStream().findAny();
            System.out.println(any);
            System.out.println("*******findAny********");
            long count = list.stream().count();
            System.out.println(count);
            System.out.println("**********count*******");
            Optional<SalariedEmployee> min = list.stream().min((s, s1) -> Double.compare(s.getMonthlySalary(), s1.getMonthlySalary()));
            System.out.println(min);
            System.out.println("********min***********");
     //归约-reduce
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < 101; i++)
            {
                integers.add(i);
            }
            Integer sum = integers.stream().reduce(0, Integer::sum);
            System.out.println(sum);
            System.out.println("*******求和*******");
            //exercise:求员工工资的总和
//            Optional<SalariedEmployee> reduce = list.stream().reduce((s, s1) -> s.getMonthlySalary() + s1.getMonthlySalary());    //返回的是员工，不能做求和计算
            Stream<Double> salaryStream = list.stream().map(s -> s.getMonthlySalary());
            Optional<Double> sum1 = salaryStream.reduce((s, s1) -> s + s1);
            System.out.println(sum1);
            System.out.println("*****************");
     //收集-collect
            //exercise：查找工资>5000的员工，结果用list存起来
            List<SalariedEmployee> collectList = list.stream().filter(s -> s.getMonthlySalary() > 5000).collect(Collectors.toList());
            collectList.forEach(System.out::println);
        }
}
