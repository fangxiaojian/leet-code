//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 73 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

//Java：二叉搜索树的第k大节点
class P剑指Offer54ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer54ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
    private int[] rootVal;
    private int index;
    public int kthLargest(TreeNode root, int k) {
        rootVal = new int[k];
        index = k-1;
        kthLargestToArrays(root);
        return rootVal[0];
    }

    public void kthLargestToArrays(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            kthLargestToArrays(root.right);
        }
        if (index >= 0) {
            rootVal[index--] = root.val;
        }else {
            return;
        }
        if (root.left != null) {
            kthLargestToArrays(root.left);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 右中左的遍历方式,得到的是降序排序的
 *
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.1 MB,击败了99.70% 的Java用户
 */
}