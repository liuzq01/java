package CollectionTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapT21
{
    //size,equals,put,putAll
    // remove,get,containsKey,containsValue
    //keySet,values,entrySet
    @Test
    public void test()
    {
        HashMap hashMap = new HashMap();
        hashMap.put("liu",29);
        hashMap.put("zhi",22);
        HashMap hashMap1 = new HashMap();
        hashMap1.put("zhi",33);
        hashMap1.put("qiang",44);
        //size,equals,put,putAll
        System.out.println(hashMap.size());
        System.out.println(hashMap.equals(hashMap1));
        System.out.println(hashMap1);
        hashMap1.putAll(hashMap);//{liu=29, zhi=22, qiang=44},具有相同key的元素会被修改
        System.out.println(hashMap1);
        // remove,get,containsKey,containsValue
        System.out.println("********************************");
//        hashMap1.remove("qiang");
        System.out.println(hashMap1);
        System.out.println(hashMap1.get("zhi"));
        System.out.println(hashMap1.containsKey("zhi"));
        System.out.println(hashMap1.containsValue(44));
        //keySet,values,entrySet
        System.out.println("********************************");
        System.out.println(hashMap1.keySet());
        System.out.println(hashMap1.values());
        System.out.println(hashMap1.entrySet());
        System.out.println("********************************");
        //遍历
        Set set = hashMap1.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
