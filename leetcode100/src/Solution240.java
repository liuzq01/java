import org.junit.Test;

public class Solution240 {
    @Test
    public void test(){
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 20));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        // 矩形方块数据，左上角最小，右下角最大（对半查找）
        int m=matrix.length, n=matrix[0].length;
        boolean[] b={false};
        if (m<=n) { // 行<=列
            int[] arr={0, m, 0, n};
            binarySearch(matrix, 0, m, 0, n, target, b, arr);
        }
        if (m>n) { // 转置
            int[] arr={0, n, 0, m};
            binarySearch(matrix, 0, n, 0, m, target, b, arr);
        }
     return b[0];   
    }
    private void binarySearch(int[][] matrix,int mL, int m, int nL, int n, int target,boolean[] b, int[] arr){  // 行<=列
        int mt=(mL+m)/2, nt=(nL+n)/2;
        if(m>matrix.length || n>matrix[0].length) return;
        if (nL==nt) {
            if(target==matrix[mt][nt]) {    //
                b[0]=true;
            }
            return;
        }
        if (mL==mt) {
            if (target==matrix[mt][nt])  {   
                b[0]=true;
                return;
            }
            int temp0= arr[0], temp1= arr[1], temp2= arr[2],temp3= arr[3];
            arr[1]=mt+1; arr[2]=nt+1;
            binarySearch(matrix, arr[0], arr[1], arr[2], arr[3], target, b, arr);   //
            arr[0]=mt+1; arr[1]= temp1; arr[2]= temp2; arr[3]=nt;
            binarySearch(matrix, arr[0], arr[1], arr[2], arr[3], target, b, arr);
            arr[0]=temp0; arr[1]= temp1; arr[2]= temp2; arr[3]=temp3;
        }
        if (target==matrix[mt][nt])  {
            b[0]=true;
            return;
        }
        if (target<matrix[mt][nt])   binarySearch(matrix, mL,mt,nL, n, target, b, arr);
        if (target>matrix[mt][nt])   binarySearch(matrix, mt,m,nL, n, target, b, arr);

    }
/*  搜索二维矩阵
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false
 */
}
