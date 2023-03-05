//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 603 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.Stack;

//Java：二叉树的最大深度
public class P104MaximumDepthOfBinaryTree{    
    public static void main(String[] args) {      
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();       
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
    private int maxCount = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        DepthTree(root, 1);

        return maxCount;
    }

    private void DepthTree(TreeNode root, int count) {
        if (root.left != null) {
            DepthTree(root.left, count+1);
        }
        if (root.right != null) {
            DepthTree(root.right, count+1);
        }
        if (root.left == null && root.right == null) {
            maxCount = maxCount >= count ? maxCount : count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 递归: 利用全局变量maxCount记录最长的深度
 *     结果:
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:39.8 MB,击败了5.75% 的Java用户
 */
}