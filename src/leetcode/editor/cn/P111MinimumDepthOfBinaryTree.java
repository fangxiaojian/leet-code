//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree{    
    public static void main(String[] args) {      
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();       
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
    int minHeight = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return minHeight;
        }
        int temp = 0;
        findBalancedHeight(root, temp);
        return minHeight;
    }

    private void findBalancedHeight(TreeNode root, int temp) {
        if (minHeight != 0 && temp > minHeight) {
            return;
        }
        if (root == null) {
            if (minHeight == 0 || temp < minHeight) {
                minHeight = temp;
            }
        }
        temp++;
        findBalancedHeight(root.left, temp);
        findBalancedHeight(root.right, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}