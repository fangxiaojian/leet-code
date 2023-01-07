//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 
// 👍 464 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉搜索树的最近公共祖先
public class P235LowestCommonAncestorOfABinarySearchTree{    
    public static void main(String[] args) {      
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();       
        // TO TEST
        TreeNode root = new TreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        solution.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode tempLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode tempRighr = lowestCommonAncestor(root.right, p, q);
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 公共节点
        if (tempLeft != null && tempRighr != null) {
            return root;
        }else{
            // 不为空的节点就是公共节点
            return tempLeft != null ? tempLeft : tempRighr;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 递归调用, 后序遍历
 *       若有节点与 p q 相同的,则返回节点,
 *       若左右遍历后都有节点, 则此节点为公共节点,返回此节点
 * 解答成功:
 * 		执行耗时:7 ms,击败了39.79% 的Java用户
 * 		内存消耗:39.5 MB,击败了86.01% 的Java用户
 */
}