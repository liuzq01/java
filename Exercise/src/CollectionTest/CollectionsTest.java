package CollectionTest;

import org.junit.Test;

import java.util.*;

public class CollectionsTest
{
    @Test
    public void test()
    {
        //List: reverse,sort,swap,shuffle,copy,replaceAll
        //Collection: min,max,frequency
        //sort,min,max,需要元素都是同一个类的
        List list=new ArrayList();
        list.add("li");
        list.add("liu");
        list.add("meng");
        list.add("meng");
        list.add(2333);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("*******reverse*******");
//        Collections.sort(list);
//        System.out.println(list);
        Collections.swap(list,2,3);
        System.out.println(list);
        System.out.println("********swap******");
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println("*********shuffle*****");
        List list1= Arrays.asList("dingdong","haha");
//        List list1= Arrays.asList(new Object[list.size()]);
//        Collections.copy(list1,list);   //使得list1的元素个数与list相同，此处list1中都是null
        Collections.copy(list,list1);   //list前面的元素被list1覆盖了
        System.out.println(list);
        System.out.println("**********copy****");
        Collections.replaceAll(list,"meng",666);//replaceAll类似word中的查找与替换
        System.out.println(list);
//        System.out.println(Collections.min(list));
//        System.out.println(Collections.max(list));
        System.out.println("**********5****");
        System.out.println(Collections.frequency(list,666));

    }
}
