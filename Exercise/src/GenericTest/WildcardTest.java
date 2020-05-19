package GenericTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class WildcardTest
{
    @Test
    public void test()
    {
        ArrayList<String> list1 =new ArrayList<>();
        ArrayList<Object> list2 =new ArrayList<>();
//        ArrayList<?> list =new ArrayList<>();
        list1.add("2333");list1.add("666");list2.add(22);list2.add(88);
//        list2=list1; 不可以
//        list=list1; //可以
//        list=list2; //可以
        WildcardTest.traverseList(list1);
        WildcardTest.traverseList(list2);
    }
//    list1、list2都可以调用的通用方法
    public static void traverseList(ArrayList<?> list)
    {
//        Iterator<?> iterator = list.iterator();
//            while (iterator.hasNext())
//            {
//                System.out.println(iterator.next());
//            }
        for (Object arr:list)
        {
            System.out.println(arr);
        }
    }
}
