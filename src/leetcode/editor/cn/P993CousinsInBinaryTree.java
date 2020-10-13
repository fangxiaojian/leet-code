//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 100 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

//Java：二叉树的堂兄弟节点
public class P993CousinsInBinaryTree{    
    public static void main(String[] args) {      
        Solution solution = new P993CousinsInBinaryTree().new Solution();       
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> temp = new ArrayDeque<>();
        queue.add(root);
        // 广度优先遍历
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && (node.left.val == x || node.left.val == y)) {
                    return isCousinsInQueue(queue, node.left.val == x ? y : x);
                } else if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null && (node.right.val == x || node.right.val == y)) {
                    return isCousinsInQueue(queue, node.right.val == x ? y : x);
                }else if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            temp = new ArrayDeque<>();
        }
        return false;
    }

    private boolean isCousinsInQueue(Queue<TreeNode> queue, int n) {
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.left.val == n) {
                return true;
            }
            if (node.right != null && node.right.val == n) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了64.96% 的Java用户
 * 		内存消耗:36.4 MB,击败了97.60% 的Java用户
 */
}