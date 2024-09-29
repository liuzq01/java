import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class Solution207 {
    @Test
    public void test(){
        int[][] prerequisites={{0,1},{2,1},{2,0}};
        System.out.println(canFinish(3, prerequisites));
        int[][] prerequisites1={{1,2},{3,1},{4,1},{2,4},{0,3},{0,4}};
        System.out.println(canFinish(5, prerequisites1));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //按行遍历先修课程数组，逐一查找“环”，结果存入list。每次最多可能有n个分叉，n叉树。
        int l=prerequisites.length;
        ArrayList<Boolean> list=new ArrayList<>();
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i = 0; i < l; i++) {
            hashSet.add(i);
            canFinish(i,prerequisites,list,hashSet);
            hashSet.clear();
            if (list.size()!=0 && list.get(list.size()-1)==false) return false;   // 存在“环”
        }
        return true;
    }
    private void canFinish(int i,int[][] prerequisites,ArrayList<Boolean> list,HashSet<Integer> hashSet) {
        // 遍历先修课程数组，找后置课程，找到了，行号存入hashSet。hashSet中的行号再次出现，则存在“环”，list存入false。不存在“环”，list什么都不存。
        for (int j = 0; j < prerequisites.length; j++) {
            if (prerequisites[i][0]==prerequisites[j][1]) {
                if(hashSet.contains(j)) {   // 存在“环”
                    list.add(false);
                    return;
                }
                hashSet.add(j);
                canFinish(j, prerequisites, list, hashSet);
            }
        }
    }
}
/*     课程表
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses-1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
prerequisites[i] 中的所有课程对 互不相同
示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
