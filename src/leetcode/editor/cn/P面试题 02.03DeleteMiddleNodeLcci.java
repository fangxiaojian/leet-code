//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。 
//
// 
//
// 示例： 
//
// 输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
// 
// Related Topics 链表 
// 👍 57 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：删除中间节点
class P面试题0203DeleteMiddleNodeLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题0203DeleteMiddleNodeLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.2 MB,击败了80.57% 的Java用户
 */
}