import java.util.Stack;

import org.junit.Test;

public class Solution101a {
    @Test
    public void test(){
    /*  对称二叉树
        迭代
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
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty() || !(rootL==null && rootR==null)) {
            while (!(rootL==null && rootR==null)) {
                if ( (rootL!=null && rootR==null) || (rootL==null && rootR!=null)) {
                    b[0]=false;
                    return;
                }
                if(rootL.val!=rootR.val) {
                    b[0]=false;
                    return;
                }
                stack.push(rootL); stack.push(rootR);
                rootL=rootL.left;   rootR=rootR.right;
            }
                rootR=stack.pop();  rootL=stack.pop();
                rootL=rootL.right;   rootR=rootR.left;
        }
    }
}
