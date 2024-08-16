import org.junit.Test;

public class Solution104 {
    @Test
    public void test(){
    /*  二叉树的最大深度
     * 给定一个二叉树 root ，返回其最大深度。
    二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
    输入：root = [3,9,20,null,null,15,7]
    输出：3

    输入：root = [1,null,2]
    输出：2
     */
    TreeNode treeNode1=new TreeNode(1);
    TreeNode treeNode2=new TreeNode(2);                                             TreeNode treeNode3=new TreeNode(2);
    TreeNode treeNode4=new TreeNode(3); TreeNode treeNode5=new TreeNode(4);     TreeNode treeNode6=new TreeNode(4); TreeNode treeNode7=new TreeNode(3);
    treeNode1.left=treeNode2; treeNode1.right=treeNode3;
    treeNode2.left=treeNode4; treeNode2.right=treeNode5;    treeNode3.left=treeNode6; treeNode3.right=treeNode7;
    /** ** ** * */
    TreeNode treeNode8=new TreeNode(1);
    TreeNode treeNode9=new TreeNode(2); TreeNode treeNode10=new TreeNode(2);
    TreeNode treeNode11=new TreeNode(3); TreeNode treeNode12=new TreeNode(3);
    treeNode8.left=treeNode9; treeNode8.right=treeNode10;
    treeNode9.right=treeNode11; treeNode10.right=treeNode12;
    /** ** ** * */
    TreeNode treeNode13=new TreeNode(1);
        System.out.println(maxDepth(treeNode1));
        System.out.println(maxDepth(treeNode8));
        System.out.println(maxDepth(treeNode13));
        System.out.println(maxDepth(null));
    }
    public int maxDepth(TreeNode root) {
        int[] a={0};
        maxDepth(root,1,a);
        return a[0];
    }
    public void maxDepth(TreeNode root,int i,int[] a) {
        if(root==null) return;
        if(a[0]<i) a[0]=i;
        maxDepth(root.left,i+1,a);
        maxDepth(root.right,i+1,a);
    }
}
