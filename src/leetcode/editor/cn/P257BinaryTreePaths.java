//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 379 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的所有路径
public class P257BinaryTreePaths{    
    public static void main(String[] args) {      
        Solution solution = new P257BinaryTreePaths().new Solution();       
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
    private List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        String s = ""+root.val;
        if (root.left == null && root.right == null) {
            list.add(s);
        } else {
            if (root.left != null) {
                binaryTreePathsToString(root.left, s);
            }
            if (root.right != null) {
                binaryTreePathsToString(root.right, s);
            }
        }
        return list;
    }

    private void binaryTreePathsToString(TreeNode root, String s) {
        s = s + "->" + root.val;
        if (root.left == null && root.right == null) {
            list.add(s);
        } else {
            if (root.left != null) {
                binaryTreePathsToString(root.left, s);
            }
            if (root.right != null) {
                binaryTreePathsToString(root.right, s);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:15 ms,击败了7.05% 的Java用户
 * 		内存消耗:39.3 MB,击败了9.20% 的Java用户
 */
}