import org.junit.Test;

public class Solution64 {
    /*      最小路径和
        * 给定一个包含非负整数的 m * n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
        说明：每次只能向下或者向右移动一步。
        输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        输出：7
        解释：因为路径 1→3→1→1→1 的总和最小。

        输入：grid = [[1,2,3],[4,5,6]]
        输出：12     
    */
    @Test
    public void test(){
        int[][] grid= {{1,3,1},{1,5,1},{4,2,1}};
        //int[][] grid= {{1,2,3},{4,5,6}};
        int min=minPathSum(grid);
        System.out.println(min);
    }
    public int minPathSum(int[][] grid) {
        int[] min={0};  //  min[0]是最小路径和
        minPathSum(grid,min,0,0,0);   //  m:行 ， n:列 ，sum 是每次计算的路径和
        return min[0];
    }
    private void minPathSum(int[][] grid,int[] min,int m,int n,int sum) {
        if (m>grid.length-1 || n>grid[0].length-1) return;

        sum=sum+grid[m][n];

        if (m==grid.length-1 && n==grid[0].length-1) {
            if(sum<min[0]) min[0]=sum;
            if(min[0]==0)   min[0]=sum;  //min[0]的初始值必须是某个路径和，才能迭代、替换成最小路径和；如果是0，上一行代码无法起作用。
            return;
        }
        
        minPathSum(grid,min,m+1,n,sum);
        minPathSum(grid,min,m,n+1,sum);
    }
}
