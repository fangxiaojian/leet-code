//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 377 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.Stack;

//Java：平衡二叉树
public class P110BalancedBinaryTree{    
    public static void main(String[] args) {      
        Solution solution = new P110BalancedBinaryTree().new Solution();       
        // TO TEST

        Integer[] values = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5};
        TreeNode root = new TreeNode(values);
        System.out.println(solution.isBalanced(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1) {
            return false;
        }

        return true;
    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1) {
            return -1;
        }

        return leftHeight >= rightHeight ? leftHeight+1 : rightHeight+1;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 递归, 若各个二叉树的左右节点高度差不超过1,则该二叉树为平衡二叉树
 *     利用递归从最底层开始计算二叉树的高度,判断是否为平衡二叉树,不是返回-1,是返回左右子树的最大高度+1.
 *     解答成功:
 * 			执行耗时:1 ms,击败了99.76% 的Java用户
 * 			内存消耗:39.7 MB,击败了85.83% 的Java用户
 */
}