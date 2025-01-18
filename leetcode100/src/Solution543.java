import org.junit.Test;

public class Solution543 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // 任取一个节点，遍历左子树，到叶子节点的最大长度为m；遍历右子树，到叶子节点的最大长度为n，得m+n。遍历所有节点，求m+n的最大值。
        int[] count=new int[]{0};
        int[] max=new int[]{0};
        diameterOfBinaryTree(root,count,max);
        return count[0];
    }
    private void nodeToLeaf(TreeNode node,int l,int[] max){    //节点node到叶子节点的最大长度
        if (node==null) {
            if (max[0]<l-1) {
                max[0]=l-1;
            }
            return;
        }
        nodeToLeaf(node.left, l+1, max);
        nodeToLeaf(node.right, l+1, max);
    }
    private void diameterOfSubTree(TreeNode node,int[] max){ //以node为根节点的子树的直径
        nodeToLeaf( node.left, 0, max);
        int m=max[0]+1;
        max[0]=0;
        nodeToLeaf( node.right, 0, max);
        int n=max[0]+1;
        max[0]=m+n;
    }
    private void diameterOfBinaryTree(TreeNode root, int[] count,int[] max) {     //遍历所有节点，取所有直径的最大值
        if (root==null) {
            return;
        }
        max[0]=0;
        diameterOfSubTree(root, max);
        if (max[0]>count[0]) {
            count[0]=max[0];
        }
        diameterOfBinaryTree(root.left, count, max);
        diameterOfBinaryTree(root.right, count, max);
    }
}
/*
 * 543. 二叉树的直径
给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。

输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
      1
     / \
    2   3
   / \
  4   5

示例 2：

输入：root = [1,2]
输出：1

 */

