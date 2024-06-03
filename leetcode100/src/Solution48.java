import org.junit.Test;

public class Solution48 {
    @Test
    public void test(){
/*  旋转图像
 *  给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *  直接修改输入的二维矩阵,不使用另外的矩阵来旋转图像。
    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        //第i行变成第k列，i+k=n-1; 第j列变成第j行。a[i][j] -> b[j][n-1-i] 。
        /*
         * 原位置的元素挪到新位置a，原a的元素挪到b，...，直到重新回到最初的位置。 ①
         * 按照 ① 依次处理第一行的元素，不包括a[0][n-1]。   ②
         * 按照 ② 依次处理第二行的元素，第三行的元素，...，到达几何中心的元素时结束。   ③
         */
        int n=matrix.length;
        if(n==1) return;
        
        for(int i=0;i<=n/2-1;i++){              // ③
            for (int j = i; j < n-1; j++) {     // ②
                int r=i, s=j;   //保存i、j

                int temp=matrix[i][j]; 
                int p=i, q=j;
                while (!(i==q && j==n-1-p) ){      //逆序处理 ① ，便于实现。a[i][j] <- a[n-1-j][i] 。
                    matrix[i][j]=matrix[n-1-j][i];
                    int t=i;
                    i=n-1-j;   j=t;   //此时i、j的值已经改了，影响到第35、36行
                }
                matrix[i][j]=temp;

                i=r; j=s;   //恢复i、j
            }
        }
    }
}
