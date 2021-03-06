//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：路径总和
public class P112PathSum{    
    public static void main(String[] args) {      
        Solution solution = new P112PathSum().new Solution();       
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
    int SUM = 0;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int temp = 0;
        SUM = sum;
        return findPathSum(root, temp);
    }

    private boolean findPathSum(TreeNode root, int temp) {
        if (root != null) {
            temp += root.val;
            if (root.left == null && root.right == null) {
                return temp == SUM;
            }
            return findPathSum(root.left, temp) || findPathSum(root.right, temp);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 递归: 用临时值记录到当前节点的路径和
 *     若当前节点为叶子节点, 判断是否是需要的路径和
 *     否则递归操作
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:40 MB,击败了7.02% 的Java用户
 */
}