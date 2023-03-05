//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 266 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

//Java：二叉树的层次遍历 II
public class P107BinaryTreeLevelOrderTraversalIi{    
    public static void main(String[] args) {      
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();       
        // TO TEST
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        solution.levelOrderBottom(t1);
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        List<Integer> list = new ArrayList<>();
        Stack<List<Integer>> listStack = new Stack<>();
        Queue<TreeNode> stack1 = new LinkedBlockingQueue<>();
        Queue<TreeNode> stack2 = new LinkedBlockingQueue<>();
        Queue<TreeNode> temp;
        TreeNode t;
        stack1.offer(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                t = stack1.poll();
                list.add(t.val);
                if (t.left != null) {
                    stack2.offer(t.left);
                }
                if (t.right != null) {
                    stack2.offer(t.right);
                }
            }
            listStack.add(list);
            list = new ArrayList<>();
            temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        while (!listStack.empty()) {
            listList.add(listStack.pop());
        }
        return listList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 迭代:
 *     结果:
 *     解答成功:
 * 			执行耗时:7 ms,击败了22.53% 的Java用户
 * 			内存消耗:40 MB,击败了7.41% 的Java用户
 */
}