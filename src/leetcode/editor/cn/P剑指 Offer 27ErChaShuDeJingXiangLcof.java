//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
//    4
//  /   \
//  2   7
// / \ / \ 
// 1 3 6 9
//镜像输出： 
//
//    4
//  /   \
//  7   2
// / \ / \ 
// 9 6 3 1
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 75 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉树的镜像
class P剑指Offer27ErChaShuDeJingXiangLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer27ErChaShuDeJingXiangLcof().new Solution();
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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = null;
        if (root.right != null) {
            temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
        } else if (root.left != null) {
            root.right = mirrorTree(root.left);
            root.left = null;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.5 MB,击败了100.00% 的Java用户
 */
}