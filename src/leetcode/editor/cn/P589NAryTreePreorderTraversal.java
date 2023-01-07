//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//                1
//             /  |  \
//            3   2   4
//          /  \
//         5    6
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 108 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.Node;

import java.util.ArrayList;
import java.util.List;

//Java：N叉树的前序遍历
public class P589NAryTreePreorderTraversal{    
    public static void main(String[] args) {      
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root != null) {
            preorderTraversal(root);
        }
        return list;
    }
    private void preorderTraversal(Node root) {
        list.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorderTraversal(node);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了96.55% 的Java用户
 * 		内存消耗:39.5 MB,击败了73.02% 的Java用户
 */
}