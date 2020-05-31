package exercise2;

import org.junit.Test;

import java.util.ArrayList;

public class Chapter18_review
{
    @Test
    public void test()
    {
        //阶乘
        System.out.println(factorial(5));
    }
    public long factorial(int n)
    {
        if (n==1)
        {
            return 1;
        }
        else
        return n*factorial(n-1);
    }
    @Test
    public void test2()
    {
        //斐波那契数
        System.out.println(phe(11));
    }
    public int phe(int n)
    {
        if (n==1) return 1;
        else if (n==2) return 1;
        else return phe(n-1)+phe(n-2);
    }
    @Test
    public void test3()
    {
        //选择排序
        ArrayList<Double> doubles = new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
           doubles.add(Math.random()*100) ;
        }
        System.out.println(doubles);
//        sort1(doubles);
        sort2(doubles,0);
        System.out.println(doubles);
    }
    public void sort1(ArrayList< Double> arrayList)
    {
        //迭代法
        for (int j = 0; j < arrayList.size(); j++)
        {
            int index=j;
            Double aDouble = arrayList.get(j);
            for (int i = j; i < arrayList.size(); i++)
            {
                if (arrayList.get(i)<aDouble)
                {
                    aDouble= arrayList.get(i);
                    index=i;
                }
            }
            arrayList.set(index,arrayList.get(j));
            arrayList.set(j,aDouble );
        }
    }
    public void sort2(ArrayList<Double> arrayList,int start)
    {
        //递归法
        if(start<arrayList.size())
        {
            int index=start;
            Double aDouble = arrayList.get(start);
            for (int i = start; i < arrayList.size(); i++)
            {
                if (arrayList.get(i)<aDouble)
                {
                    aDouble=arrayList.get(i);
                    index=i;
                }
            }
            arrayList.set(index,arrayList.get(start));
            arrayList.set(start,aDouble);
            sort2(arrayList,start+1);
        }
    }
    @Test
    public void test4()
    {
        //二分法,前提：已排好序
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(2.33);doubles.add(45.35);doubles.add(56.7);
        doubles.add(87.35);doubles.add(97.45);doubles.add(47.87);
        System.out.println(doubles);
        sort2(doubles,0);
        System.out.println(doubles);
        int i = binarySearch(doubles, 0, doubles.size(), 56.7);
        System.out.println(i);
    }
    public int binarySearch(ArrayList<Double> arrayList,int a,int b,double x)
    {
       int index=(a+b)/2;
       if (index==a)
       {
           if (Math.abs(arrayList.get(a)-x)<1e-6) return a;
           if (Math.abs(arrayList.get(b)-x)<1e-6) return b;
           else return -1;
       }
       else
       {
           if (arrayList.get(index)<x) return binarySearch(arrayList,index,b,x);
           else if (arrayList.get(index)>x) return binarySearch(arrayList,a,index,x);
           else return index;
       }
    }
    @Test
    public void test5()
    {
        //尾递归
        long l = factorial2(5, 1);
        System.out.println(l);
    }
    public long factorial2(int n,long result)
    {
        if (n==1) return result;
        else
        {
            return factorial2(n-1,n*result);
        }
    }
    @Test
    public void test6()
    {
        //汉诺塔
        han('A','B','C',4);
    }
    private static int k=0;
    public void han(char a,char b,char c,int n)
    {
        if (n==1)
        {
            System.out.println("盘子"+ n+": "+a+"-->"+b);
            System.out.println("*****step:"+(++k)+"*********");
        }
        else
        {
            han(a,c,b,n-1);
            System.out.println("盘子"+ n+": "+a+"-->"+b);
            System.out.println("*****step:"+(++k)+"*********");
            han(c,b,a,n-1);
        }
    }


}
