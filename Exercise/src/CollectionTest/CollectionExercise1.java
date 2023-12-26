package CollectionTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionExercise1
{
    //将学生姓名成绩录入到集合，按分数的高低显示前三名学生的名字
    @Test
    public  void test1()
    {
        TreeSet treeSet=new TreeSet(new Comparator()//为什么不先往集合里添加数据，然后再排序？
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if(o1 instanceof Student&& o2 instanceof Student)
                {
                    Student o11 = (Student) o1;
                    Student o12 = (Student) o2;
                    return -Integer.compare(o11.getScore(),o12.getScore());
                }
                throw new RuntimeException("输入数据有误");
            }
        });
        treeSet.add(new Student("li",88,01));//如果new的元素一样，会怎样？能不能都存在treeSet里面？
        treeSet.add(new Student("liu",77,05));
        treeSet.add(new Student("lin",66,04));
        treeSet.add(new Student("wang",90,07));
        treeSet.add(new Student("sun",73,03));
        treeSet.add(new Student("qi",80,06));
        treeSet.add(new Student("bi",70,10));
        int i=0;
        for(Object s:treeSet)
        {
            if(s instanceof  Student)
            {
                i++;
                Student s1 = (Student) s;
                System.out.println(s1.getName()+": "+s1.getScore());
                if(i>=3) break;
            }
        }
    }
}
