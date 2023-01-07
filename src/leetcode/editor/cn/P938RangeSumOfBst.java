//给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。 
//
// 二叉搜索树保证具有唯一的值。 
//
// 
//
// 示例 1： 
//
// 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//输出：32
// 
//
// 示例 2： 
//
// 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数量最多为 10000 个。 
// 最终的答案保证小于 2^31。 
// 
// Related Topics 树 递归 
// 👍 139 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉搜索树的范围和
public class P938RangeSumOfBst{    
    public static void main(String[] args) {      
        Solution solution = new P938RangeSumOfBst().new Solution();       
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

    private int count = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        preorderTraversal(root, L, R);
        return count;
    }

    private void preorderTraversal(TreeNode root, int L, int R) {
        if (root != null) {
            if (root.val < L) {
                if (root.right != null) {
                    preorderTraversal(root.right, L, R);
                }
            } else if (root.val > R) {
                if (root.left != null) {
                    preorderTraversal(root.left, L, R);
                }
            } else {
                preorderTraversal(root.left, L, R);
                count += root.val;
                preorderTraversal(root.right, L, R);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:46.4 MB,击败了74.94% 的Java用户
 */
}