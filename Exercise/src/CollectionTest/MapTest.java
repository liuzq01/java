package CollectionTest;

import org.junit.Test;

import java.util.*;

public class MapTest
{
    @Test
    public void hashMaptest()
    {   //无序的没有插入的方法
        //put,size
        HashMap hashMap=new HashMap();
        hashMap.put("li",22);
        hashMap.put("liu",22);
        hashMap.put(24,"lin");
        hashMap.put(new Person("l",21),18);
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        hashMap.put(24,"li");   //修改
        System.out.println(hashMap);

        System.out.println("********************");

        //putAll
        HashMap hashMap1 = new HashMap();
        hashMap1.put("s",28);
        hashMap1.put("dd",30);
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);
        System.out.println("********************");

        //remove,clear,isEmpty
        hashMap1.remove("s");
        System.out.println(hashMap1);
        hashMap1.clear();
        System.out.println(hashMap1);
        System.out.println(hashMap1.size());    //不会报空指针异常，与hashMap1=null不同,hashMap1={}
        System.out.println(hashMap1.isEmpty());
        System.out.println("********************");

        //get,containsKey,containsValue
        Object liu = hashMap.get("liu");
        System.out.println(liu);
        System.out.println(hashMap.containsKey("dd"));
        System.out.println(hashMap.containsValue(18));
        System.out.println("********************");

        //equals
        HashMap hashMap2 = new HashMap();
        hashMap2.put("s",28);
        hashMap2.put("dd",30);
        System.out.println(hashMap1.equals(hashMap2));
        System.out.println("********************");

        //keSet,values,entrySet
        Set set = hashMap.keySet();
        System.out.println(set);
        Collection values = hashMap.values();
        System.out.println(values);
        Set set1 = hashMap.entrySet();
        System.out.println(set1);
        System.out.println("********************");

        //遍历
        Iterator iterator = set1.iterator();
        while (iterator.hasNext())
        {
            Object o = iterator.next();
            Map.Entry entry = (Map.Entry) o; // Entry是Map的内部类
            System.out.println(entry);
        }

    }
}
