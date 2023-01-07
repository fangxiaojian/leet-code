//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 372 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：最长同值路径
public class P687LongestUnivaluePath{    
    public static void main(String[] args) {      
        Solution solution = new P687LongestUnivaluePath().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int count = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            preorderTraversal(root);
        }
        return count;
    }

    private void preorderTraversal(TreeNode root) {
        int temp = 0;
        if (root.left != null && root.left.val == root.val) {
            temp += isSameMoreNode(root.left);
        }
        if (root.right != null && root.right.val == root.val) {
            temp += isSameMoreNode(root.right);
        }
        count = Math.max(temp, count);

        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
    }

    private int isSameMoreNode(TreeNode node) {
        int tempLeft = 1;
        int tempRight = 1;
        if (node.left != null && node.left.val == node.val) {
            tempLeft += isSameMoreNode(node.left);
        }
        if (node.right != null && node.right.val == node.val) {
            tempRight += isSameMoreNode(node.right);
        }
        return Math.max(tempLeft, tempRight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:7 ms,击败了8.12% 的Java用户
 * 		内存消耗:41.4 MB,击败了90.88% 的Java用户
 */
}