//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 397 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.Stack;

//Java：相同的树
public class P100SameTree{    
    public static void main(String[] args) {      
        Solution solution = new P100SameTree().new Solution();       
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        Stack<TreeNode> stackP = new Stack();
        Stack<TreeNode> stackQ = new Stack();
        TreeNode temp1, temp2;
        if (p == null) {
            return false;
        }
        stackP.push(p);
        if (q == null) {
            return false;
        }
        stackQ.push(q);
        while (!stackP.empty() && !stackQ.empty()) {
            temp1 = stackP.pop();
            temp2 = stackQ.pop();
            if (temp1.val != temp2.val) {
                return false;
            }
            if (temp1.left != null) {
                if (temp2.left != null) {
                    stackP.push(temp1.left);
                    stackQ.push(temp2.left);
                } else {
                    return false;
                }
            }else {
                if (temp2.left != null) {
                    return false;
                }
            }
            if (temp1.right != null) {
                if (temp2.right != null) {
                    stackP.push(temp1.right);
                    stackQ.push(temp2.right);
                } else {
                    return false;
                }
            } else {
                if (temp2.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 利用栈存放树形元素, 深度优先遍历树, 比较返回结果
 *     结果:
 *     解答成功:
 * 			执行耗时:1 ms,击败了100.00% 的Java用户
 * 			内存消耗:37.6 MB,击败了5.55% 的Java用户
 * 		P.S: 代码较乱, 但题目没有太大意义, 所有就不优化了
 */
}