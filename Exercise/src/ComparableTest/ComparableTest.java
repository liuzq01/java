package ComparableTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest
{
    @Test
    public void test1()
    {
        String[] array = new String[]{"dd", "aa", "mm", "cc", "ee"};
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2()
    {   //Goods需实现Comparable,并重写compareTo(),才能进行排序
        Goods[] array=new Goods[4];
        array[0]    =new Goods("lei",100);
        array[1]=new Goods("lian",200);
        array[2]=new Goods("bei",150);
        array[3]=new Goods("jing",120);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

    }
    @Test
    public void test3()
    {
        //实现Comparator，重写compare(Object o1,Object o2)
        Goods[] array=new Goods[4];
        array[0]    =new Goods("lei",100);
        array[1]=new Goods("lian",200);
        array[2]=new Goods("bei",150);
        array[3]=new Goods("jing",120);
        Arrays.sort(array, new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if (o1 instanceof Goods && o2 instanceof Goods)
                {
                    Goods s1 = (Goods) o1;
                    Goods s2 = (Goods) o2;
                    return -s1.getName().compareTo(s2.getName());   //按照name倒序排列
                }
                throw new RuntimeException("输入数据类型不一致");

            }
        });
        System.out.println(Arrays.toString(array));

    }

    }
