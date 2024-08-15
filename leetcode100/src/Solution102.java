import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class Solution102 {
    @Test
    public void test(){
        /*  二叉树的层序遍历
         * 给你二叉树的根节点root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
        输入：root = [3,9,20,null,null,15,7]
        输出：[[3],[9,20],[15,7]]

        输入：root = [1]
        输出：[[1]]

        输入：root = []
        输出：[]
         */
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> aLists=new ArrayList<>();
        List<HashMap<Integer,Integer>> aListsB=new ArrayList<>();
        int[] maxLevel={0};     // maxLevel[0] 是最大层数
        levelOrder(root,aListsB,0,maxLevel);
        levelOrder(aLists,aListsB,maxLevel);
        return aLists;
    }
    private void levelOrder(TreeNode root,List<HashMap<Integer,Integer>> aListsB,int i,int[] maxLevel) {
        //先序遍历，把每一层的数标记上层级，结果存入List<HashMap<i,root.val>> ; 遍历此list，按层级分离数据。
        if(root==null) return;
        if(maxLevel[0]<i) maxLevel[0]=i;
        aListsB.add(new HashMap<>(i,root.val));
        levelOrder(root.left,aListsB,i+1,maxLevel);
        levelOrder(root.right,aListsB,i+1,maxLevel);
    }
    private void levelOrder(List<List<Integer>> aLists,List<HashMap<Integer,Integer>> aListsB,int[] maxLevel){
        for (int i = 0; i <= maxLevel[0]; i++) {
            aLists.add(new ArrayList<>());
        }
    }
}
