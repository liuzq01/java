import java.util.ArrayDeque;
import org.junit.Test;

public class Solution102a {
    @Test
    public void test(){
        /*  二叉树的层序遍历
        *   真正的按层遍历二叉树，从上到下，从左往右
        */
        //  
    }
    public void levelOrder1(TreeNode root) {
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        TreeNode treeNode=new TreeNode();
        //List<List<Integer>> lists=new ArrayList<>();
        while (!queue.isEmpty() || treeNode!=null) {
            treeNode=queue.poll();
            if (treeNode.left!=null) queue.add(treeNode.left);
            if (treeNode.right!=null) queue.add(treeNode.right);
        }
    }
}
