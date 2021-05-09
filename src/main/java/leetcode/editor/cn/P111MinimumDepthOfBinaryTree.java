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
        Integer[] value = {1, 2};
        System.out.println(solution.minDepth(new TreeNode(value)));
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
        temp++;
        if (root.left == null && root.right == null) {
            if (minHeight == 0 || temp < minHeight) {
                minHeight = temp;
            }
        } else {
            if (root.left != null) {
                findBalancedHeight(root.left, temp);
            }
            if (root.right != null) {
                findBalancedHeight(root.right, temp);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 递归,
 *     先判断该节点是不是叶子节点
 *     是: 计算是否是最小深度
 *     否: 判断左右节点是否为空, 不为空递归调用
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:39.7 MB,击败了74.78% 的Java用户
 */
}