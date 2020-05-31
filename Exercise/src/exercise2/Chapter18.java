package exercise2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            System.out.println(" ' " + i + " ': " + arrayList.get(i));
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

        if (k == a)
        {
            if (x == arrayList.get(k)) return k;
            if (x == arrayList.get(b)) return b;
            return -1;
        }

        if (a < k && k < b)
        {
            if (x < arrayList.get(k)) return indexOf(arrayList, a, k, x);   // return 不可丢
            else if (x > arrayList.get(k)) return indexOf(arrayList, k, b, x);
            else return k;
        } else return -1;
    }

    /*汉诺塔*/
    //只能描述移动的过程，涉及具体位置盘子的增删细节就不行了
    @Test
    public void test5()
    {
        move('A', 'B', 'C', 3);
    }

    private static int k = 0;

    public void move(char a, char b, char c, int n)
    {
        if (n == 1)
        {
            System.out.println("盘子" + n +": "+ a + "-->" + b);
            System.out.println("*****" + (++k) + "*****");
        } else
        {
            move(a, c, b, n - 1);
            System.out.println("盘子" + n +": "+ a + "-->" + b);
            System.out.println("*****" + (++k) + "*****");
            move(c, b, a, n - 1);
        }
    }
    //尾递归
    @Test
    public void test6()
    {
        long factorial = factorial(4);
        System.out.println(factorial);
    }
    private  long factorial (int n )
    {
        return factorial(n,1);
    }
    private  long factorial (int n , int result)
    {
        if (n ==0)
        return result;
         else
        return factorial(n- 1, n * result); // Recursive call
    }
//    @Test
//    public void test4()
//    {
//        ArrayList<Integer> a=new ArrayList<>();
//        a.add(3);a.add(2);a.add(1);
//        ArrayList<Integer> b=new ArrayList<>(a.size());
//        ArrayList<Integer> c=new ArrayList<>(a.size());
//        move(a,b,c,3);
//    }
//        private static int k=0;
//        private static boolean flag=false;
//    public void move(ArrayList<Integer> a, ArrayList<Integer> b,ArrayList<Integer> c,int n)
//    {
//        if(n==1)
//        {
//            b.add(a.get(0));
//            a.remove(0);
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(c);
//            System.out.println("*********"+(++k));
//        }
//        if (a.size()==0&&c.size()==0) System.out.println("已完成");
//        else
//         {
//             //无具体实现的方法，只是抽象的概念方法，自己骗自己？
////             ArrayList<Integer> temp=new ArrayList<>();
////             temp.addAll(a);
////             temp.remove(0);
////             move(temp,b,c,n-1);
////             b.add(a.get(0));
////             a.remove(0);
////             System.out.println("*********"+(++k));
////             move(c,b,a,n-1);
//         }
//    }
}
//n-1个盘子直接一起搬过去，与要求不符
//        else
//                {
//                c.addAll(a.subList(1,a.size()));
//                int temp= a.get(0);
//                a.clear();
//                a.add(temp);
//                if (flag)
//                {
//                System.out.println(c);
//                System.out.println(b);
//                System.out.println(a);
//                }
//                if (!flag)
//                {
//                System.out.println(a);
//                System.out.println(b);
//                System.out.println(c);
//                }
//                System.out.println("*********"+(++k));
//                b.add(a.get(0));
//                a.remove(0);
//                if (flag)
//                {
//                System.out.println(c);
//                System.out.println(b);
//                System.out.println(a);
//                }
//                if (!flag)
//                {
//                System.out.println(a);
//                System.out.println(b);
//                System.out.println(c);
//                }
//                System.out.println("*********"+(++k));
//                flag=true;
//                move(c,b,a,n-1);
//                }

