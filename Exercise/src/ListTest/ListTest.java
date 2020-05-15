package ListTest;

import org.junit.Test;
import CollectionTest.Person;
import java.util.ArrayList;
import java.util.List;

public class ListTest
{
    //ArrayList 测试
    @Test
    public void test()
    {
        //add
        ArrayList list = new ArrayList();
        list.add(234);
        list.add("abc");
        list.add(2,"abc");
        list.add(new Person("liu",22));
        System.out.println(list);
        System.out.println("***********");
        //addAll
        ArrayList list1=new ArrayList();
        list1.add(333);
        list1.add("dd");
        System.out.println(list1);
        list.addAll(list1);
        System.out.println(list);
        System.out.println("***********");
        //remove
        list.remove("abc");
        System.out.println(list);
        System.out.println("***********");
        //set
        list.set(4,"ff");
        System.out.println(list);
        System.out.println("***********");
        //get,indexOf
        System.out.println(list.get(1));
        System.out.println(list.indexOf(333));
        System.out.println("***********");
        //subList
        List list2 = list.subList(1, 3);
        System.out.println(list2);
    }
}
