package exercise3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Chapter21
{
    //exercise 21.2
    @Test
    public void test1()
    {
        //二分法，泛型，数组
        Integer[] integers = {45, 32, 67, 88, 38, 97, 56, 46};
        System.out.println(Arrays.toString(integers));
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        int i = binarySearch(integers, 56);     //泛型方法调用时指定具体类型
        System.out.println(i);
        System.out.println("*******************");
        Double[] doubles = {4.5, 3.2, 6.7, 8.8, 3.8, 9.7, 5.6, 4.6};
        System.out.println(Arrays.toString(doubles));
        Arrays.sort(doubles);
        System.out.println(Arrays.toString(doubles));
        int j = binarySearch(doubles, 4.5);
        System.out.println(j);

    }
    public <E extends Comparable<E>> int binarySearch(E[] list, E x)
    {
        return binarySearch( list,0,list.length-1,x);
    }
    public <E extends Comparable<E>> int binarySearch(E[] list,int a,int b,E x)
    {
        //递归
        int k=(a+b)/2;
        if (a==k)
        {
            if (list[a].equals(x)) return a;
            else if (list[b].equals(x)) return b;
            else return -1;
        }
        else
        {
            if (x.compareTo(list[k])<0) return binarySearch(list,a,k,x);
            else if (x.compareTo(list[k])>0) return binarySearch(list,k,b,x);
            else return k;
        }
    }
    @Test
    public void test2()
    {
        //二分法，泛型，ArrayList（不能用?）
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(2.33);doubles.add(45.35);doubles.add(56.7);
//        binarySearch(doubles,1,2,2);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);arrayList.add(4);arrayList.add(5);
    }
    public  int binarySearch(ArrayList<? extends Number> arrayList, int a, int b, Number x)
    {
        return 0;
        //Number没有实现Comparable接口，无法做比较
    }
}
