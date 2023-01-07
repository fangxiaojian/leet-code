//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 200 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层平均值
public class P637AverageOfLevelsInBinaryTree{    
    public static void main(String[] args) {      
        Solution solution = new P637AverageOfLevelsInBinaryTree().new Solution();       
        // TO TEST
        TreeNode root = new TreeNode(new Integer[]{3, 9, 20, 15, 7});
        solution.averageOfLevels(root);
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double d = 0f;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                d += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(d / size);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 层次遍历 用队列实现
 * 解答成功:
 * 		执行耗时:3 ms,击败了71.11% 的Java用户
 * 		内存消耗:40.8 MB,击败了15.51% 的Java用户
 */
}