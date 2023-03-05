//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 517 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：将有序数组转换为二叉搜索树
public class P108ConvertSortedArrayToBinarySearchTree{    
    public static void main(String[] args) {      
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();       
        // TO TEST
        int[] nums = {-10,-3,0,5,9};
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
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[nums.length / 2]);
        head.left = createTreeByArray(nums, 0, nums.length / 2);
        head.right = createTreeByArray(nums, nums.length / 2 + 1, nums.length);
        return head;
    }

    private TreeNode createTreeByArray(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        TreeNode head = new TreeNode(nums[(end + start) / 2]);
        head.left = createTreeByArray(nums, start, (end + start) / 2);
        head.right = createTreeByArray(nums, (end + start) / 2 + 1, end);
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 递归: 计算数组的中间元素作为根节点
 *     以中间元素为中点, 将数组分为两部分
 *     前面部分为根节点的左节点
 *     后面部分为根节点的右节点
 *     递归循环, 创建树形结构
 *     结果:
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:39.6 MB,击败了8.70% 的Java用户
 */
}