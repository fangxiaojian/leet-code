//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 树 二叉搜索树 递归 
// 👍 44 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：BiNode
class P面试题1712BinodeLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题1712BinodeLcci().new Solution();
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
    TreeNode newRoot;
    TreeNode temp;
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrderTraversal(root);
        return newRoot;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        if (newRoot == null) {
            newRoot = root;
            temp = root;
            temp.left = null;
        } else {
            temp.right = root;
            temp = temp.right;
            temp.left = null;
        }
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 中序遍历
 * 解答成功:
 * 		执行耗时:1 ms,击败了58.86% 的Java用户
 * 		内存消耗:44.5 MB,击败了38.46% 的Java用户
 */
}