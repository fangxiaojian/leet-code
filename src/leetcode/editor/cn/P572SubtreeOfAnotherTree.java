//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 370 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：另一个树的子树
public class P572SubtreeOfAnotherTree{    
    public static void main(String[] args) {      
        Solution solution = new P572SubtreeOfAnotherTree().new Solution();       
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        boolean isLeft = false, isRight = false;
        if (s.left != null) {
            isLeft = isSubtree(s.left, t);
        }
        if (s.right != null) {
            isRight = isSubtree(s.right, t);
        }
        if (isLeft || isRight) {
            return true;
        }
        if (s.val == t.val) {
            return isSame(s, t);
        }
        return false;
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        } else if (t == null || s == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:4 ms,击败了98.77% 的Java用户
 * 		内存消耗:39 MB,击败了42.86% 的Java用户
 */
}