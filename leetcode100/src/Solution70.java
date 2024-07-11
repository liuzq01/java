import org.junit.Test;

public class Solution70 {
    /*      爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
        输入：n = 2
        输出：2
        解释：有两种方法可以爬到楼顶。
        1. 1 阶 + 1 阶
        2. 2 阶

        输入：n = 3
        输出：3
        解释：有三种方法可以爬到楼顶。
        1. 1 阶 + 1 阶 + 1 阶
        2. 1 阶 + 2 阶
        3. 2 阶 + 1 阶
     */
    @Test
    public void test(){
        System.out.println(climbStairs(3));
    }
    public int climbStairs(int n) {
        //  与换零钱（或组合总数）相似，搜索回溯，每找到一种方法，计数加1
        int[]count={0};
        climbStairs(n,count);
        return count[0];
    }
    public void climbStairs(int n,int[] count) {
        if(n<0) return;
        if(n==0) {
            count[0]++;
            return;
        }
        //每次选择爬 1 或 爬 2 个台阶，这两种选择的“地位”相等，因此是并列关系(但是实际执行代码时，有先后次序)
        climbStairs(n-2,count);
        
        climbStairs(n-1,count);
    }
}
