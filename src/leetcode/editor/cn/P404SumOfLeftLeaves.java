//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 242 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：左叶子之和
public class P404SumOfLeftLeaves{    
    public static void main(String[] args) {      
        Solution solution = new P404SumOfLeftLeaves().new Solution();       
        // TO TEST
        TreeNode root = new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        solution.sumOfLeftLeaves(root);
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
    public int sumOfLeftLeaves(TreeNode root) {
        int leftCount = 0;
        if (root == null) {
            return leftCount;
        }
        if (root.left != null) {
            leftCount += sumOfLeftLeavesAndIsLeft(root.left, true);
        }
        if (root.right != null) {
            leftCount += sumOfLeftLeavesAndIsLeft(root.right, false);
        }
        return leftCount;
    }

    private int sumOfLeftLeavesAndIsLeft(TreeNode root, boolean isLeft) {
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        }
        int count = 0;
        if (root.left != null) {
            count += sumOfLeftLeavesAndIsLeft(root.left, true);
        }
        if (root.right != null) {
            count += sumOfLeftLeavesAndIsLeft(root.right, false);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 深度优先遍历, 递归遍历
 *       用 isLeft 标记这个节点是左节点, 若这个是左节点又是叶子节点,则返回节点值
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:36.9 MB,击败了46.23% 的Java用户
 */
}