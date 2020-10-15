//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 59 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉树的深度
class P剑指Offer55IErChaShuDeShenDuLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer55IErChaShuDeShenDuLcof().new Solution();
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
    private int maxCount = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        DepthTree(root, 1);

        return maxCount;
    }

    private void DepthTree(TreeNode root, int count) {
        if (root.left != null) {
            DepthTree(root.left, count+1);
        }
        if (root.right != null) {
            DepthTree(root.right, count+1);
        }
        if (root.left == null && root.right == null) {
            maxCount = maxCount >= count ? maxCount : count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.5 MB,击败了90.74% 的Java用户
 */
}