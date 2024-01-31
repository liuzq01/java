
import java.util.Random;

import org.junit.Test;

public class ThreeAlgorithm {
    @Test
    public  void test1()
    {
        //冒泡排序
        int[] arr=new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(101); // 生成0到100之间的随机数
        }
        int temp=0; 
        for (int k = arr.length-2; k >=0; k--)
         {
            for(int i=0 ;i<=k;i++)
            {
                if (arr[i]>arr[i+1])
                {
                    temp= arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
        //System.out.println(arr.toString());
        for (int i=0;i<arr.length;i++) {
            System.out.printf("%d ",arr[i]);
            if ((i+1)%5==0 ) {
                System.out.println();
            }
        }
    }
    @Test
    public void test2()
    {
        //选择排序
        int[] arr=new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(101); // 生成0到100之间的随机数
        }
        int temp=arr[0];int n =0;                       //可以同时找最大、最小值
        for (int k = arr.length-1; k >=1; k--) {
            for (int i = 0; i <= k; i++) {
                if (arr[i]>temp) {
                    temp=arr[i];
                    n=i;
                }
                if (i==k) {   
                    arr[n]=arr[i];
                    arr[i]=temp;
                    temp=arr[0]; n=0;   //重置temp和n的值
                }
    
            }
      
        }
        for (int i=0;i<arr.length;i++) {
            System.out.printf("%d ",arr[i]);
            if ((i+1)%5==0 ) {
                System.out.println();
            }
        }
    }
    @Test
    public void test3()
    {
        //插入排序
        int[] arr=new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i]=random.nextInt(101); // 生成0到100之间的随机数
        }
        int i,  k, temp=0;
        for ( k = 1; k <= arr.length-1; k++) 
        {
            for ( i = k; i >=1; i--) 
            {
                if (arr[i]<arr[i-1]) 
                {
                    temp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                }
            }
        }
        for ( i=0;i<arr.length;i++)
        {
            System.out.printf("%d ",arr[i]);
            if ((i+1)%5==0 ) 
            {
                System.out.println();
            }
        }
    }
}
