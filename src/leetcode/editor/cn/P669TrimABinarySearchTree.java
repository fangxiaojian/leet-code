//给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以
//结果应当返回修剪好的二叉搜索树的新的根节点。 
//
// 示例 1: 
//
// 
//输入: 
//    1
//   / \
//  0   2
//
//  L = 1
//  R = 2
//
//输出: 
//    1
//      \
//       2
// 
//
// 示例 2: 
//
// 
//输入: 
//    3
//   / \
//  0   4
//   \
//    2
//   /
//  1
//
//  L = 1
//  R = 3
//
//输出: 
//      3
//     / 
//   2   
//  /
// 1
// 
// Related Topics 树 
// 👍 285 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：修剪二叉搜索树
public class P669TrimABinarySearchTree{    
    public static void main(String[] args) {      
        Solution solution = new P669TrimABinarySearchTree().new Solution();       
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 判断 root 是否在范围内
        if (root.val < low) {
            // 小于, 则判断其 右节点是否符合
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            // 大于, 则判断其 左节点是否符合
            return trimBST(root.left, low, high);
        }
        // 判断 左节点
        root.left = trimBST(root.left, low, high);
        // 判断 右节点
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 使用递归, 前序遍历的方式
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.1 MB,击败了99.57% 的Java用户
 */
}