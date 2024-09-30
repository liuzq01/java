import org.junit.Test;

public class Solution221 {
    @Test
    public void test(){
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix) {
        // 遍历矩阵，寻找每一个位置的最大正方形，最后再取最大值。
        // 任一元素，逐步向右、下、左延伸，找最大正方形。
        int[] a={0}; int max=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                maximalSquare(matrix,i,j,0,a);
                if(max<a[0]) max=a[0];
            }
        }
        return max;
    }
    private void maximalSquare(char[][] matrix, int i, int j, int n, int[] a) {
        if(matrix.length<=i+n || matrix[0].length<=j+n) return;
        if(matrix[i][j+n]=='0') return;
        for (int k = 0; k <=n; k++) {
            if(matrix[i+k][j+n]=='0') return;
        }
        for (int k = 0; k <=n; k++) {
            if(matrix[i+n][j+n-k]=='0') return;
        }
        a[0]=(n+1)*(n+1);
        maximalSquare(matrix, i, j, n+1, a);
    }
}
/*      最大正方形
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：4
输入：matrix = [["0","1"],["1","0"]]
输出：1
输入：matrix = [["0"]]
输出：0

 */
