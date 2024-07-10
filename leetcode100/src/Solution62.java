import org.junit.Test;

public class Solution62 {
    @Test
    public void test(){
        /*     不同路径
        * 输入：m = 3, n = 7
        输出：28

        输入：m = 3, n = 2
        输出：3
        解释：
        从左上角开始，总共有 3 条路径可以到达右下角。
        1. 向右 -> 向下 -> 向下
        2. 向下 -> 向下 -> 向右
        3. 向下 -> 向右 -> 向下

        输入：m = 7, n = 3
        输出：28

        输入：m = 3, n = 3
        输出：6
        */
        System.out.println(uniquePaths(3, 3));
    }
    public int uniquePaths(int m, int n) {
        //  设为f(m,n), 则f(m,n) = f(m,n-1) + f(m-1,n)
        //  f(m,n)=f(n,m);  f(1,1)=0;    f(1,n)=1; 
        if (m==1 && n==1) return 0;
        if (m==1 && n>1) return 1;
        if (m>n)    return uniquePaths(n,m);    //  f(m,n)=f(n,m)
        else return uniquePaths(m, n-1)+uniquePaths(m-1, n);
    }
}
