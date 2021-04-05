package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;

public class ListT21
{
    @Test
    public void aListT()
    {
        //add,addAll,remove,equals,size,get,set,indexOf,subList
        ArrayList arrayList = new ArrayList();
        arrayList.add("liu");
        arrayList.add(2333);
        arrayList.add(1,"ok");
        System.out.println(arrayList);
        System.out.println("*********************");
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(new Person("lin",22));
        arrayList1.add(345);
        arrayList1.addAll(arrayList);
        System.out.println(arrayList1);
        System.out.println("*********************");
        arrayList1.remove(0);
        System.out.println(arrayList1);
        System.out.println("*********************");
        System.out.println(arrayList.equals(arrayList1));
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));
        System.out.println("*********************");
        System.out.println(arrayList);
        arrayList.set(1,3222);
        System.out.println(arrayList);
        System.out.println(arrayList.indexOf("ok"));//-1意思是不存在
        System.out.println(arrayList.subList(1,2));//左闭右开
    }
}
