import org.junit.Test;

public class Solution279 {
    @Test
    public void test(){
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
    public int numSquares(int n) {
        int[] arr={n};
        int k=(int) Math.pow(n, 0.5);
        numSquares(n,k,0,arr);
        return arr[0];
    }
    private void numSquares(int n, int k, int i, int[] arr) {
        if(n<0) return;
        if(n==0) {
            if(i<arr[0]) arr[0]=i;
            return;
        }
        for (int j = 1; j <= k; j++) {
            numSquares(n-j*j,k,i+1,arr);
        }
    }
}
/*   完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

输入：n = 12
输出：3 
解释：12 = 4 + 4 + 4

输入：n = 13
输出：2
解释：13 = 4 + 9
 */
