//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 905 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

//Java：对称二叉树
public class P101SymmetricTree{

    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();       
        // TO TEST
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(3);
        solution.isSymmetric(t1);
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
// 2. 迭代
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        TreeNode root1;
        TreeNode root2;
        if (root.left != null && root.right != null) {
            queue.offer(root.left);
            queue.offer(root.right);
        } else if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
        while (!queue.isEmpty()) {
            root1 = queue.poll();
            root2 = queue.poll();
            if (root1.val == root2.val){
                if (root1.left != null && root2.right != null) {
                    queue.offer(root1.left);
                    queue.offer(root2.right);
                } else if (root1.left == null && root2.right == null) {

                }else {
                    return false;
                }
                if (root1.right != null && root2.left != null) {
                    queue.offer(root1.right);
                    queue.offer(root2.left);
                } else if (root1.right == null && root2.left == null) {

                }else {
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
//// 1. 递归
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return isEquate(root.left, root.right);
//    }
//
//    private boolean isEquate(TreeNode root1, TreeNode root2){
//        if (root1 == null && root2 == null) {
//            return true;
//        } else if (root1 == null || root2 == null) {
//            return false;
//        }
//        if (root1.val != root2.val) {
//            return false;
//        } else {
//            return isEquate(root1.left, root2.right) && isEquate(root1.right, root2.left);
//        }
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 递归: 先比较根节点的左右节点, 相同则比较
 *      左节点的左节点 与 右节点的右节点
 *      左节点的右节点 与 右节点的左节点
 *      结果:
 *      解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:38.1 MB,击败了18.75% 的Java用户
 *
 * 2. 迭代: 利用队列进行操作
 *      P.S: LinkedBlockingDeque队列不能存放为null的元素
 *      结果:
 *      解答成功:
 * 			执行耗时:5 ms,击败了8.35% 的Java用户
 * 			内存消耗:39.3 MB,击败了5.00% 的Java用户
 */
}