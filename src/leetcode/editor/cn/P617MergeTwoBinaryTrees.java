//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 544 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：合并二叉树
public class P617MergeTwoBinaryTrees{    
    public static void main(String[] args) {      
        Solution solution = new P617MergeTwoBinaryTrees().new Solution();       
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 == null || t1 == null) {
            return t1 == null ? t2 : t1;
        }
        if (t2 != null && t1 != null) {
            t1.val += t2.val;
        }
        if (t1.left != null && t2.left != null) {
            mergeTrees(t1.left, t2.left);
        } else if (t1.left == null) {
            t1.left = t2.left;
        }
        if (t1.right != null && t2.right != null) {
            mergeTrees(t1.right, t2.right);
        } else if (t1.right == null) {
            t1.right = t2.right;
        }
        return t1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.5 MB,击败了99.72% 的Java用户
 */
}