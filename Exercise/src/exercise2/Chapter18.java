package exercise2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Chapter18
{
    //选择排序：用循环来实现
    @Test
    public void test1()
    {
        ArrayList<Integer> arrayList = randomArray(20, 100);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.addAll(arrayList);
        System.out.println(arrayList1);
        System.out.println("*****************");

        sort1(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList1);
        System.out.println(arrayList1);
    }

    public ArrayList<Integer> randomArray(int n, int range)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i1 = 0;
        for (int i = 0; i < n; i++)
        {
            i1 = (int) (Math.random() * range);
            arrayList.add(i1);
        }
        return arrayList;
    }

    public void sort1(ArrayList<Integer> arrayList)
    {
        for (int k = 0; k < arrayList.size(); k++)
        {
            int temp = arrayList.get(k);
            int index = k;
            for (int i = k; i < arrayList.size(); i++)
            {
                if (arrayList.get(i) < temp)
                {
                    temp = arrayList.get(i);
                    index = i;
                }
            }
            arrayList.set(index, arrayList.get(k));
            arrayList.set(k, temp);
        }
    }

    //选择排序：递归实现
    @Test
    public void test2()
    {
        ArrayList<Integer> arrayList = randomArray(20, 100);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.addAll(arrayList);
        System.out.println(arrayList1);
        System.out.println("*****************");

        sort2(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList1);
        System.out.println(arrayList1);
    }

    public void sort2(ArrayList<Integer> arrayList)
    {
        sortHelper(arrayList, 0);
    }

    public void sortHelper(ArrayList<Integer> arrayList, int k)
    {
        if (k < arrayList.size())
        {
            int temp = arrayList.get(k);
            int index = k;
            for (int i = k; i < arrayList.size(); i++)
            {
                if (arrayList.get(i) < temp)
                {
                    temp = arrayList.get(i);
                    index = i;
                }
            }
            arrayList.set(index, arrayList.get(k));
            arrayList.set(k, temp);

            sortHelper(arrayList, k + 1);
        }
    }

    //二分法查找
    @Test
    public void test3()
    {
        ArrayList<Integer> arrayList = randomArray(50, 40);
        sort2(arrayList);
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(" ' "+ i +" ': "+arrayList.get(i));
        }
        int i = indexOf(arrayList, 20);
        System.out.println(i);
    }

    public int indexOf(ArrayList arrayList, int x)
    {
        return indexOf(arrayList, 0, arrayList.size() - 1, x);
    }

    public int indexOf(ArrayList<Integer> arrayList, int a, int b, int x)
    {
        int k = (a + b) / 2;  //整数除法--"/"，会自动截断，结果为整数

        if (k==a)
        {
            if (x==arrayList.get(k)) return k;
            if (x==arrayList.get(b)) return b;
            return -1;
        }

        if (a < k && k < b)
        {
            if (x < arrayList.get(k)) return indexOf(arrayList, a, k, x);   // return 不可丢
            else if (x > arrayList.get(k)) return indexOf(arrayList, k, b, x);
            else return k;
        }
        else return -1;
    }

}
