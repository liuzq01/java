import java.util.ArrayDeque;
import org.junit.Test;

public class Solution236 {
    @Test
    public void test(){        
        // 创建节点
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        // 连接节点
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        System.out.println(lowestCommonAncestor(root, node5, node4).val);
        System.out.println(lowestCommonAncestor(root, node6, node4).val);
        System.out.println(lowestCommonAncestor(root, node6, node8).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //「层序遍历」给定的二叉树，对于任一节点x，遍历挂在它下面的所有元素，如果包含p、q，则x是p、q的公共祖先
        //遍历完二叉树，最后一个公共祖先即为所求
        ArrayDeque<TreeNode> arrayDeque=new ArrayDeque<>();
        arrayDeque.add(root);
        boolean[] temp={false,false};
        TreeNode node=root;
        while (!arrayDeque.isEmpty()) { //层序遍历
            root=arrayDeque.poll();
            preOrder(root,p,q,temp);
            if(temp[0]==true && temp[1]==true) node=root;
            temp[0]=false; temp[1]=false;
            if (root!=null) {
                if (root.left!=null) arrayDeque.add(root.left);
                if (root.right!=null) arrayDeque.add(root.right);
            }
        }
        return node;
    }
    private void preOrder(TreeNode root, TreeNode p, TreeNode q, boolean[] temp) {
        //  先序遍历
        if(root==null) return;
        if (root==p) temp[0]=true;
        if (root==q) temp[1]=true;
        preOrder(root.left, p, q, temp);
        preOrder(root.right, p, q, temp);
    }
}
/*
     *   二叉树的最近公共祖先
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    输出：5
    解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 6, q = 4
    输出：5
    解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 6, q = 8
    输出：3
    所有 Node.val 互不相同 。
    p != q
    p 和 q 均存在于给定的二叉树中。
        3
      /   \
     5     1
    / \   / \
   6   2 0   8
      / \
     7   4
*/
