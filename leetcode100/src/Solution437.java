import org.junit.Test;

public class Solution437 {
    @Test
    public void test(){
        // 创建节点
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);

        // 连接节点
        root.left = node1;        // 10 -> 5
        root.right = node2;       // 10 -> -3

        node1.left = node3;       // 5 -> 3
        node1.right = node4;      // 5 -> 2
        node2.right = node5;      // -3 -> 11

        node3.left = node6;       // 3 -> 3
        node3.right = node7;      // 3 -> -2
        node4.right = node8;      // 2 -> 1
        System.out.println(pathSum(root, 8));
        /**********************************************/
        // 创建节点
        TreeNode root1 = new TreeNode(5);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(13);
        TreeNode node13 = new TreeNode(4);
        TreeNode node14 = new TreeNode(7);
        TreeNode node15 = new TreeNode(2);
        TreeNode node16 = new TreeNode(5);
        TreeNode node17 = new TreeNode(1);

        // 连接节点
        root1.left = node9;        // root1 -> node9 (5 -> 4)
        root1.right = node10;      // root1 -> node10 (5 -> 8)

        node9.left = node11;       // node9 -> node11 (4 -> 11)

        node10.left = node12;      // node10 -> node12 (8 -> 13)
        node10.right = node13;     // node10 -> node13 (8 -> 4)

        node11.left = node14;      // node11 -> node14 (11 -> 7)
        node11.right = node15;     // node11 -> node15 (11 -> 2)

        node13.left = node16;      // node13 -> node16 (4 -> 5)
        node13.right = node17;     // node13 -> node17 (4 -> 1)
        System.out.println(pathSum(root1, 22));
    }
    public int pathSum(TreeNode root, int targetSum) {
        int[] arr={0};
        allPath(root, targetSum, arr);
        return arr[0];
    }
    private void pathSum(TreeNode root, int targetSum, int[] arr) { // 遍历从根节点的所有路径
        if (root==null) {
            return;
        }
        if (targetSum==0) {
            arr[0]++;
        }
        targetSum=targetSum-root.val;
        pathSum(root.left, targetSum,arr);
        pathSum(root.right, targetSum, arr);
    }
    private void allPath(TreeNode root, int targetSum, int[] arr) { // 所有节点的路径
        if (root==null) {
            return;
        }
        pathSum(root.left, targetSum,arr);
        pathSum(root.right, targetSum, arr);
    }
}
/*
 * 437. 路径总和 III
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

示例 1：

输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条。
            10
           /  \
         5    -3
       /  \      \
      3    2      11
     / \     \
    3  -2     1

示例 2：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3
                5
              /   \
            4       8
           /       /   \
         11      13     4
        /  \          /   \
       7    2        5     1
 
 */

