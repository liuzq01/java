import org.junit.Test;

public class Solution79 {
    /*
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
        同一个单元格内的字母不允许被重复使用。board 和 word 仅由大小写英文字母组成.
        (进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？)
        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        输出：true
        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
        输出：true
        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
        输出：false
    */
    @Test
    public void test(){
        char[][] board={
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'} };
        String word="ABCCED";
        //String word="SEE";
        //String word="ABCB";

        System.out.println(exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        boolean[] flag={false};
        int[] temp={1,0,0}; //  temp[0]==1, 第一步往右
        exist(board, word,0,0,0,flag,temp);
        return flag[0];
    }
    public void exist(char[][] board, String word,int i,int j,int n,boolean[] flag,int [] temp) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        if(flag[0]==true) return;
        if(board[i][j]==word.charAt(n)) {
            if(n==word.length()-1) {
                flag[0]=true;
                return;
            }
            if(n==0){
                 temp[1]=i;  temp[2]=j;     // 暂存首字母的位置
            }
            if(temp[0]==0 || temp[0]==2)  {     //  temp[0]==0, 代表上一步是往左，则可继续往左
                int t=temp[0];      //暂存
                temp[0]=0;                      //  这一步即将往左，记下来
                exist(board, word,i,j-1,n+1,flag,temp);   //    左
                temp[0]=t;          //回溯
            }
            if(temp[0]==1 || temp[0]==2)  {
                int t=temp[0];
                temp[0]=1;
                exist(board, word,i,j+1,n+1,flag,temp);   //  右
                temp[0]=t;
            }
            int t=temp[0];
            temp[0]=2;
            exist(board, word,i+1,j,n+1,flag,temp);   //  下
            temp[0]=t;
            n=0; i=temp[1];  j=temp[2];   //  3个方向都匹配不上，回溯，准备寻找下一个首字母的位置
        }
        if(flag[0]==true) return;
        if(n==0){   //  找word首字母的位置
            if(temp[0]==0 || temp[0]==2)  {
                int t=temp[0];
                temp[0]=0;
                exist(board, word,i,j-1,n,flag,temp);   //    左
                temp[0]=t;
            }
            if(temp[0]==1 || temp[0]==2)  {
                int t=temp[0];
                temp[0]=1;
                exist(board, word,i,j+1,n,flag,temp);   //  右
                temp[0]=t;
            }
            int t=temp[0];
            temp[0]=2;
            exist(board, word,i+1,j,n,flag,temp);   //  下
            temp[0]=t;
        }
    }
}
