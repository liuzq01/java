import org.junit.Test;

public class Solution98 {
    @Test
    public void test(){
    /*      验证二叉搜索树
    * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    有效 二叉搜索树定义如下：
    节点的左
    子树
    只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树
    输入：root = [2,1,3]
    输出：true
    输入：root = [5,1,4,null,null,3,6]
    输出：false
    解释：根节点的值是 5 ，但是右子节点的值是 4 。
    提示：-2^31 <= Node.val <= 2^31 - 1
    */
        //  中序遍历二叉树，结果升序 <==> 二叉搜索树
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(1);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.left=treeNode2;   treeNode1.right=treeNode3;

        TreeNode treeNode4=new TreeNode(5);
        TreeNode treeNode5=new TreeNode(1);
        TreeNode treeNode6=new TreeNode(4);
        TreeNode treeNode7=new TreeNode(3);
        TreeNode treeNode8=new TreeNode(6);
        treeNode4.left=treeNode5;   treeNode4.right=treeNode6;
        treeNode6.left=treeNode7;   treeNode6.right=treeNode8;
        System.out.println(isValidBST(treeNode1));
        System.out.println(isValidBST(treeNode4));
    }
    public boolean isValidBST(TreeNode root) {
        boolean[] b={true};
        int[] a={(int) -Math.pow(2, 31)};
        innerOrder(root,a, b);
        return b[0];
    }
    private void innerOrder(TreeNode root ,int[] a, boolean[] b){
        if(root==null) return;
        innerOrder(root.left, a,b);
        // 中序遍历，上一次遍历的值存入a[0]，与当前的遍历值比大小
        if(root.val >= a[0] || a[0]==-(int) -Math.pow(2, 31)) a[0]=root.val;
        else {
            b[0]=false;
            return;
        }
        innerOrder(root.right, a,b);
    }
}