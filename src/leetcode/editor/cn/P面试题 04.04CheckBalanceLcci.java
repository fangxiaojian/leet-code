//实现一个函数，检查二叉树是否平衡。
// 在这个问题中，平衡树的定义如下：
// 任意一个节点，其两棵子树的高度差不超过 1。
// 示例 1: 给定二叉树 [3,9,20,null,null,15,7]
//        3
//       / \
//      9  20
//        /  \
//       15   7
// 返回 true 。示例 2: 给定二叉树 [1,2,2,3,3,null,null,4,4]
//          1
//         / \
//        2   2
//       / \
//      3   3
//     / \
//    4   4
// 返回 false 。
// Related Topics 树 深度优先搜索
// 👍 32 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：检查平衡性
class P面试题0404CheckBalanceLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题0404CheckBalanceLcci().new Solution();
        // TO TEST  
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
        return leftHeight != -1 && rightHeight != -1 && Math.abs(leftHeight - rightHeight) <= 1;
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
 * 解答成功:
 * 		执行耗时:1 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.5 MB,击败了96.94% 的Java用户
 */
}