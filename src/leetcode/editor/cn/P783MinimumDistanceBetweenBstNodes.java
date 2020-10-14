//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 递归 
// 👍 89 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉搜索树节点最小距离
public class P783MinimumDistanceBetweenBstNodes{    
    public static void main(String[] args) {      
        Solution solution = new P783MinimumDistanceBetweenBstNodes().new Solution();       
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
    private int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            min = Math.min(min, root.val - root.left.val);
            // 获取左节点的最后一个右节点
            int temp = getLeftInLastRight(root.left);
            min = Math.min(min, root.val - temp);
            minDiffInBST(root.left);
        }
        if (root.right != null) {
            min = Math.min(min, root.right.val - root.val);
            // 获取右节点的最后一个左节点
            int temp = getRightInLastLeft(root.right);
            min = Math.min(min, temp - root.val);
            minDiffInBST(root.right);
        }
        return min;
    }

    private int getRightInLastLeft(TreeNode right) {
        if (right.left != null) {
            TreeNode root = right;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }
        return right.val;
    }

    private int getLeftInLastRight(TreeNode left) {
        if (left.right != null) {
            TreeNode root = left;
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }
        return left.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:36.2 MB,击败了92.18% 的Java用户
 */
}