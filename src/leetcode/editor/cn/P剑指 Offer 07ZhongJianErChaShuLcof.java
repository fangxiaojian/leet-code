//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 255 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：重建二叉树
class P剑指Offer07ZhongJianErChaShuLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer07ZhongJianErChaShuLcof().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preorder, int startP, int[] inorder, int startI, int size) {
        if (startP > preorder.length || startI > inorder.length || startI < 0 || startP < 0 || size <= 0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[startP]);
        for (int i = startI; i < inorder.length; i++) {
            if (inorder[i] == head.val) {
                head.left = buildTree(preorder, startP + 1, inorder, startI, i - startI);
                head.right = buildTree(preorder, startP + i - startI + 1, inorder, i + 1, size - i - 1 + startI);
                break;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:4 ms,击败了47.23% 的Java用户
 * 		内存消耗:38.6 MB,击败了84.70% 的Java用户
 */
}