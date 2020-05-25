package CollectionTest;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest
{
    @Test
    public void test1()
    {
        Collection collection = new ArrayList();
        //add()
        collection.add("aa");
        collection.add(123);
        collection.add(LocalDateTime.now());
        System.out.println(collection.size());
        System.out.println(collection);
        System.out.println("**********");

        //addAll()
        Collection collection1 = new ArrayList();
        collection1.add("bb");
        collection1.addAll(collection);
        System.out.println(collection1.size());
        System.out.println(collection1);
        System.out.println("**********");

        //clear()
        collection1.clear();

        //isEmpty()
        System.out.println(collection1.isEmpty());
        System.out.println("**********");
    }

    @Test
    public void test2()
    {
        Collection coll = new ArrayList();
        coll.add(new String("li"));
        coll.add(666);
        coll.add(444);
        coll.add(false);
        Person p = new Person("liu", 100);
        coll.add(p);
        coll.add(new Person("liu", 100));

        //contains()    通常自定义的类需要重写equals()方法
        System.out.println(coll.contains("li"));   //true
        System.out.println(coll.contains(new Person("liu", 100)));   //false (Person没重写equals()方法)
        System.out.println(coll.contains(p));       //true

        // remove()
        System.out.println(coll.remove(new Person("liu", 100))); //true
        System.out.println(coll.remove(777));   //false
        System.out.println("********");

        //removeAll() 差集
        Collection collection3 = Arrays.asList(444, 666);
        System.out.println(collection3);
        System.out.println(coll);

        coll.removeAll(collection3);    //差集 coll - collection3,再赋值给coll。赋值后coll{x∣x∈coll,且x∉collection3}
        System.out.println(coll);
    }

    @Test
    public void test3()
    {
        //retainsAll() 交集

        Collection A = new ArrayList();
        A.add(new String("li"));
        A.add(666);
        A.add(444);
        A.add(new Person("liu", 100));

        Collection B = Arrays.asList(444, 666,555);
        A.retainAll(B);     //交集，并赋值给A。A=A∩B。赋值后的新集合A :{x∣x∈A,且x∈B}
        System.out.println(A);
    }
    @Test
    public void test4()
    {
        //equals()
        Collection coll = new ArrayList();
        coll.add(new String("li"));
        coll.add(666);
        coll.add(444);
        coll.add(new Person("liu", 100));
        Collection coll2 = Arrays.asList("li",666,444,new Person("liu", 100));

        Collection coll3 = Arrays.asList("li",444,666,new Person("liu", 100));

        System.out.println(coll.equals(coll2));     //true
        System.out.println(coll.equals(coll3));     //false  比较两个集合是否相同，比较的是元素。
                                                    // list是有序的，元素相同，顺序不同，返回false。
        //iterator()
        Iterator iterator = coll.iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }
        //remove()
        while (iterator.hasNext())
        {
            Object next = iterator.next();
            if(next.equals(666))
            {
                iterator.remove();
            }
        }
        System.out.println("*******");
        System.out.println(coll);
    }
}
