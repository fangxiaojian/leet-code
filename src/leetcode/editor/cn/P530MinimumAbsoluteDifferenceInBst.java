//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 141 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉搜索树的最小绝对差
public class P530MinimumAbsoluteDifferenceInBst{    
    public static void main(String[] args) {      
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();       
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
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            min = Math.min(min, root.val - root.left.val);
            // 获取左节点的最后一个右节点
            int temp = getLeftInLastRight(root.left);
            min = Math.min(min, root.val - temp);
            getMinimumDifference(root.left);
        }
        if (root.right != null) {
            min = Math.min(min, root.right.val - root.val);
            // 获取右节点的最后一个左节点
            int temp = getRightInLastLeft(root.right);
            min = Math.min(min, temp - root.val);
            getMinimumDifference(root.right);
        }
        return min;
    }

    private int getRightInLastLeft(TreeNode right) {
        if (right.left != null) {
            TreeNode root = right;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }
        return right.val;
    }

    private int getLeftInLastRight(TreeNode left) {
        if (left.right != null) {
            TreeNode root = left;
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }
        return left.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了82.41% 的Java用户
 * 		内存消耗:38.3 MB,击败了94.43% 的Java用户
 */
}