//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//                1
//             /  |  \
//            3   2   4
//          /  \
//         5    6
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 104 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.Node;

import java.util.ArrayList;
import java.util.List;

//Java：N叉树的后序遍历
public class P590NAryTreePostorderTraversal{    
    public static void main(String[] args) {      
        Solution solution = new P590NAryTreePostorderTraversal().new Solution();       
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
    public List<Integer> postorder(Node root) {
        if (root != null) {
            postorderTraversal(root);
        }
        return list;
    }
    private void postorderTraversal(Node root) {
        if (root.children != null) {
            for (Node node : root.children) {
                postorderTraversal(node);
            }
        }
        list.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了96.97% 的Java用户
 * 		内存消耗:39.4 MB,击败了90.24% 的Java用户
 */
}