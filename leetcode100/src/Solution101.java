import org.junit.Test;

public class Solution101 {
    @Test
    public void test(){
    /*  对称二叉树
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
    输入：root = [1,2,2,3,4,4,3]
    输出：true
    输入：root = [1,2,2,null,3,null,3]
    输出：false
    提示：-100 <= Node.val <= 100
    进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     */
    TreeNode treeNode1=new TreeNode(1);
    TreeNode treeNode2=new TreeNode(2);                                             TreeNode treeNode3=new TreeNode(2);
    TreeNode treeNode4=new TreeNode(3); TreeNode treeNode5=new TreeNode(4);     TreeNode treeNode6=new TreeNode(4); TreeNode treeNode7=new TreeNode(3);
    treeNode1.left=treeNode2; treeNode1.right=treeNode3;
    treeNode2.left=treeNode4; treeNode2.right=treeNode5;    treeNode3.left=treeNode6; treeNode3.right=treeNode7;

    TreeNode treeNode8=new TreeNode(1);
    TreeNode treeNode9=new TreeNode(2); TreeNode treeNode10=new TreeNode(2);
    TreeNode treeNode11=new TreeNode(3); TreeNode treeNode12=new TreeNode(3);
    treeNode8.left=treeNode9; treeNode8.right=treeNode10;
    treeNode9.right=treeNode11; treeNode10.right=treeNode12;
    System.out.println(isSymmetric(treeNode1));
    System.out.println(isSymmetric(treeNode8));
}
    public boolean isSymmetric(TreeNode root) {
        boolean[] b={true};
        isSymmetric(root,root,b);
        return b[0];
    }
    private void isSymmetric(TreeNode rootL,TreeNode rootR,boolean[] b) {
        if (rootL==null && rootR==null) return;
        if ( (rootL!=null && rootR==null) || (rootL==null && rootR!=null)) {
            b[0]=false;
            return;
        }
        if(rootL.val!=rootR.val) {
            b[0]=false;
            return;
        }
        isSymmetric(rootL.left,rootR.right,b);
        isSymmetric(rootL.right,rootR.left,b);
    }
}
