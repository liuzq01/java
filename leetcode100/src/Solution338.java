import java.util.Arrays;

import org.junit.Test;

public class Solution338 {
    @Test
    public void test(){
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits(13)));
        System.out.println(Arrays.toString(countBits(27)));
    }
    public int[] countBits(int n) {
        if(n==0) return new int[]{0};
        if(n==1) return new int[]{0,1};
        int[] arr=new int[n+1];
        arr[0]=0; arr[1]=1;
        countBits(n,2,2,arr);
        return arr;
    }
    private void countBits(int n, int i, int k, int[] arr) { 
        // 2^(i-1)<= n <= 2^i-1 , 0<= k <= n
        if(k>n) return;
        int p=(int) Math.pow(2, i-1);  
        int q=(int) Math.pow(2, i);
        if(p<= k && k<= (p+q-1)/2) {
            arr[k]=arr[p-1]-arr[2*p-1-k]+1;   // 两对称之数的和：arr[p-1]，角标和：2p-1
            countBits(n, i, k+1, arr);
        }
        if ((p+q-1)/2<k && k<=2*p-1) {
            arr[k]=arr[k-p]+1;
            countBits(n, i, k+1, arr);
        }
        if(k>2*p-1)  countBits(n,i+1,k,arr);
    }
}
/*
 * 338. 比特位计数
给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。

示例 1：

输入：n = 2
输出：[0,1,1]
解释：
0 --> 0
1 --> 1
2 --> 10
示例 2：

输入：n = 5
输出：[0,1,1,2,1,2]
解释：
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

进阶：

很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 */
/*  
2^(n-1) ~ 2^n-1，有2^(n-1)个数，是前一轮的2倍，由两部分组成：
① 前一轮数的反转+最高位添"1" （关于下面的分割线****而对称）
② 前一轮数+最高位添"1"
综上，F(n)=F'(n-1)+1 + F(n-1)+1;    F'(n-1)与F(n-1)对称，而且和为定数。
--------------
0  -->     0
*************
1  -->     1
*************
2  -->    10
3  -->    11
*************
4  -->   100
5  -->   101
· · · · · · ·
6  -->   110
7  -->   111
*************
8  -->  1000
9  -->  1001
10 -->  1010
11 -->  1011
· · · · · · ·
12 -->  1100
13 -->  1101
14 -->  1110
15 -->  1111
*************
16 --> 10000
17 --> 10001
18 --> 10010
19 --> 10011
20 --> 10100
21 --> 10101
22 --> 10110
23 --> 10111
· · · · · · ·
24 --> 11000
25 --> 11001
26 --> 11010
27 --> 11011
28 --> 11100
29 --> 11101
30 --> 11110
31 --> 11111
*************
 */

