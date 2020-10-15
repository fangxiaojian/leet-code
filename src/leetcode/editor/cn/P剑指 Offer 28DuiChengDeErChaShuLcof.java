//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//    1
//   / \
//  2   2
// / \ / \ 
// 3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//   1
//  / \
//  2  2
//  \   \
//   3   3
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 91 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：对称的二叉树
class P剑指Offer28DuiChengDeErChaShuLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer28DuiChengDeErChaShuLcof().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEquate(root.left, root.right);
    }

    private boolean isEquate(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        } else {
            return isEquate(root1.left, root2.right) && isEquate(root1.right, root2.left);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:36.5 MB,击败了99.70% 的Java用户
 */
}