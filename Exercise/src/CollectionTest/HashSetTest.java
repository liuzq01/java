package CollectionTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetTest
{
    @Test
    public void test()
    {
        HashSet hashSet=new HashSet();
        Person p1=new Person("li",22);
        Person p2=new Person("liu",23);
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);    //[Person{name='liu', age=23}, Person{name='li', age=22}]
        p1.setName("gao");
        hashSet.remove(p1);     // 按照内存中的地址值查找元素: NO; 按照hashCode()和equals()查找元素: YES.
        System.out.println(hashSet);    //[Person{name='liu', age=23}, Person{name='gao', age=22}]
        Person p3=new Person("gao",22);
        hashSet.add(p3);
        System.out.println(hashSet);    //[Person{name='liu', age=23}, Person{name='gao', age=22}, Person{name='gao', age=22}]
                                        // 有意思的点：即使Person重写了equals()和hashCode()，hashSet仍然可以有俩 相同 的元素
        Person p4=new Person("li",22);
        hashSet.add(p4);
        System.out.println(hashSet);
    }
}
