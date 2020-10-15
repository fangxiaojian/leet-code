//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 73 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉搜索树的第k大节点
class P剑指Offer54ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer54ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (root.right != null) {
            kthLargest(root.right, k);
        }
        if (k == 0) {
            return root.val;
        } else {
            k--;
        }
        if (root.left != null) {
            kthLargest(root.right, k);
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}