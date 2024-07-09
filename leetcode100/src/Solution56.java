import java.util.Arrays;
import org.junit.Test;

public class Solution56 {
    @Test
    public void test(){
        /*  合并区间
        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

        输入：intervals = [[1,4],[4,5]]
        输出：[[1,5]]
        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 */
        //int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals={{15,18},{8,10},{2,6},{1,3}};
        //int[][] intervals={{1,4},{4,5}};
        int[][] result=merge(intervals);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
    public int[][] merge(int[][] intervals) {
        //先按左端点升序排序，再从左往右合并。    
        //第一个元素的右端点a[0，1]与它右边元素的左端点逐个比较(a[1，0],a[2,0],a[3，0]...)，合并，合并后的元素存入新数组  
        //开始下一轮合并，循环重复
        if (intervals.length<=1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][]temp=new int[intervals.length][2];   //temp的长度有冗余
        int i=1,j=0,k=0;
        while (j<intervals.length && i<intervals.length) {
            //  逐个比较
            while (i<intervals.length && intervals[j][1]>=intervals[i][0]  ) {
                i++;
            }
            //  合并另存
            int rightPoint=Math.max(intervals[j][1], intervals[i-1][1]);
            temp[k][0]=intervals[j][0];
            temp[k][1]=rightPoint;
            //  下一轮合并
        j=i;    i=i+1;      k++;
            //  如果最后一个元素没被合并，复制保存     
            if(i==intervals.length){
                temp[k][0]=intervals[j][0];
                temp[k][1]=intervals[j][1];
            }   
        }
        //删除temp中多余的元素
        int[][] newIntervals;
        if(i==intervals.length) newIntervals=Arrays.copyOf(temp, k+1);
        else newIntervals=Arrays.copyOf(temp, k);
        return newIntervals;
    }
}
