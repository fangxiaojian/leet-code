//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 示例 1: 
//
// 输入: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//输出: 5
//说明: 最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2: 
//
// 输入: 
//    2
//   / \
//  2   2
//
//输出: -1
//说明: 最小的值是 2, 但是不存在第二小的值。
// 
// Related Topics 树 
// 👍 115 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

//Java：二叉树中第二小的节点
public class P671SecondMinimumNodeInABinaryTree{    
    public static void main(String[] args) {      
        Solution solution = new P671SecondMinimumNodeInABinaryTree().new Solution();       
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
    public int findSecondMinimumValue(TreeNode root) {
        int firstMin = 0;
        int secondMin = -1;
        if (root == null) {
            return secondMin;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        firstMin = root.val;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.val == firstMin) {
                    queue.add(node.left);
                }else {
                    if (secondMin == -1) {
                        secondMin = node.left.val;
                    } else {
                        secondMin = Math.min(secondMin, node.left.val);
                    }
                }
            }
            if (node.right != null) {
                if (node.right.val == firstMin) {
                    queue.add(node.right);
                }else {
                    if (secondMin == -1) {
                        secondMin = node.right.val;
                    } else {
                        secondMin = Math.min(secondMin, node.right.val);
                    }
                }
            }
        }
        return secondMin;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.5 MB,击败了100.00% 的Java用户
 */
}