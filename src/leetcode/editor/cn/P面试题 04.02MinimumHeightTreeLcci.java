//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
// 示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//       0
//      / \
//     -3  9
//     /   /
//    -10  5
// Related Topics 树 深度优先搜索
// 👍 57 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：最小高度树
class P面试题0402MinimumHeightTreeLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题0402MinimumHeightTreeLcci().new Solution();
        // TO TEST
        int[] nums = {-10, -3, 0, 5, 9};
        solution.sortedArrayToBST(nums);
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int first, int last) {
        if (first == last) {
            return new TreeNode(nums[first]);
        } else if (first > last) {
            return null;
        }
        TreeNode node = new TreeNode(nums[(last + first + 1) / 2]);
        node.left = sortedArrayToBST(nums, first, (last + first + 1) / 2 - 1);
        node.right = sortedArrayToBST(nums, (last + first + 1) / 2 + 1, last);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.1 MB,击败了99.77% 的Java用户
 */
}