import org.junit.Test;

public class Solution461 {
    @Test
    public void test(){
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(1, 3));
    }
    public int hammingDistance(int x, int y) {
        //对x 和 y 作异或运算，结果是z，再从z中找为'1'的位，计数
        //z与'1'作与运算，只有最低位参与有效运算，高位被屏蔽；不断把z右移一位，重复这个过程即可
        int z=x^y;
        int count=0;
        while (z!=0) {
            if ((z&1)==1) {
                count++;
            }
            z=z>>1;                
        }
        return count;
    }
}
/*
 * 461. 汉明距离
两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。

给你两个整数 x 和 y，计算并返回它们之间的汉明距离。

示例 1：

输入：x = 1, y = 4
输出：2
解释：
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
上面的箭头指出了对应二进制位不同的位置。
示例 2：

输入：x = 3, y = 1
输出：1
 */

