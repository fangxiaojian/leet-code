//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
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
// Related Topics 树 深度优先搜索 数组 
// 👍 760 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{    
    public static void main(String[] args) {      
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();       
        // TO TEST
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        solution.buildTree(preorder, inorder);
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
 * 		执行耗时:4 ms,击败了47.99% 的Java用户
 * 		内存消耗:38.5 MB,击败了89.63% 的Java用户
 */
}