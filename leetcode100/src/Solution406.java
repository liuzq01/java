import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Solution406 {
    @Test
    public void test(){
        int[][] people= {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
        int[][] people1 = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        System.out.println(Arrays.deepToString(reconstructQueue(people1)));
    }
    public int[][] reconstructQueue(int[][] people) {
        // 较小元素无论是否存在，对较大元素的计数都无影响。因此，可以先从最小的元素开始处理，一旦它的位置确定，就可从剩余元素中找最小元素并处理，可迭代。
        // 对于people中的最小元素hi：ki=i （i是queue中空闲位置的相对值）；
        // 在people中找hi的最小值，根据ki得到i（相对值）。遍历queue，计算i（相对值）和此时的kj（绝对值）。把这些最小值复制给queue，然后在people中删除它们。
        int[][] queue=new int[people.length][2];
        ArrayList<int[]> aList=new ArrayList<>();
        ArrayList<Integer> delList=new ArrayList<>();
        int relativeJ=0, absoluteJ=0;
        for (int i = 0; i < people.length; i++) {
            aList.add(people[i]);
        }
        while (!aList.isEmpty()) {
            int min=aList.get(0)[0];
            for (int i = 0; i < aList.size(); i++) {    // 找hi的最小值
                if (aList.get(i)[0]<min) {
                    min=aList.get(i)[0];
                }
            }
            for (int i = 0; i < aList.size(); i++) {    // 给queue赋值
                if (aList.get(i)[0]==min) {
                    delList.add(i);
                    for (int j = absoluteJ; j < queue.length; j++) {
                        if (queue[j][0]==0) {
                            if (relativeJ==aList.get(i)[1]) {
                                queue[j]=aList.get(i);
                                absoluteJ=j+1;
                                relativeJ++;
                                break;
                            }
                            relativeJ++;
                        }
                    }            
                }
            }
            relativeJ=0; absoluteJ=0;
            for (int i = delList.size()-1; i >= 0; i--) {   // 删除已赋值的最小值
                aList.remove(aList.get(delList.get(i)));
            }
            delList.clear();
        }
        return queue;
    }
}
/*
 * 406. 根据身高重建队列
假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

示例 1：

输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
解释：
编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。

示例 2：
输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
提示：

1 <= people.length <= 2000
0 <= hi <= 106
0 <= ki < people.length
题目数据确保队列可以被重建
 */
/*  找规律：
    ① hj+kj 近似升序，即：(hi-hj)(ki-kj)<=0 近似成立
    ② 若kj相同，则hj是升序的；若hj相同，则kj是升序的
    ③ kj <= j （第一个位置: kj=0）
*/
