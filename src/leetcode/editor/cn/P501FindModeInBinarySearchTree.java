//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 224 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Java：二叉搜索树中的众数
public class P501FindModeInBinarySearchTree{    
    public static void main(String[] args) {      
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();       
        // TO TEST
        TreeNode root = new TreeNode(new Integer[]{3,3,4,2,4,null,5,1,null,null,null,5,null,1});
        solution.findMode(root);
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

    private List<Integer> list = new ArrayList<>();
    int countMax = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        findModeSame(root, 0);
        int[] a = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            a[i++] = integer;
        }
        return a;
    }

    private int findModeSame(TreeNode root, int i) {
        int temp = i + 1;
        if (root.left != null && root.left.val == root.val) {
            temp = findModeSame(root.left, temp);
        }
        if (root.right != null && root.right.val == root.val) {
            temp = findModeSame(root.right, temp);
        }
        if (temp > i + 1) {
            return temp;
        }
        if (temp == countMax) {
            list.add(root.val);
        } else if (temp > countMax) {
            list.clear();
            countMax = temp;
            list.add(root.val);
        }
        if (root.left != null) {
            findModeSame(root.left, 0);
        }
        if (root.right != null) {
            findModeSame(root.right, 0);
        }
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}