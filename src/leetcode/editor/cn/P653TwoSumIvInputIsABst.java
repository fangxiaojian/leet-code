//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树 
// 👍 181 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：两数之和 IV - 输入 BST
public class P653TwoSumIvInputIsABst{    
    public static void main(String[] args) {      
        Solution solution = new P653TwoSumIvInputIsABst().new Solution();       
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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return inOrderTraversal(root, root, k);
    }

    private boolean inOrderTraversal(TreeNode root, TreeNode child, int k) {
        boolean isLeft = false, isRight = false, isTrue = false;
        if (child.left != null) {
            isLeft = inOrderTraversal(root, child.left, k);
        }
        if (child.val * 2 != k) {
            isTrue = findTargetInTree(root, k - child.val);
        }
        if (isTrue) {
            return true;
        }
        if (child.right != null) {
            isRight = inOrderTraversal(root, child.right, k);
        }
        return isLeft || isRight;
    }

    private boolean findTargetInTree(TreeNode root, int i) {
        if (root.val == i) {
            return true;
        } else if (root.val < i) {
            if (root.right == null) {
                return false;
            }
            return findTargetInTree(root.right, i);
        } else {
            if (root.left == null) {
                return false;
            }
            return findTargetInTree(root.left, i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 前序遍历二叉树, 但是未考虑目标元素为负数的情况, 所以只要遍历二叉树即可
 *      然后 (目标元素 - 当前元素) 之后在二叉树中查询是否存在即可
 * 解答成功:
 * 		执行耗时:2 ms,击败了97.94% 的Java用户
 * 		内存消耗:40.2 MB,击败了6.42% 的Java用户
 */
}