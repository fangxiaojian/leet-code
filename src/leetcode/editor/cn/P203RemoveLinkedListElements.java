//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 446 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：移除链表元素
public class P203RemoveLinkedListElements{    
    public static void main(String[] args) {      
        Solution solution = new P203RemoveLinkedListElements().new Solution();       
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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode p = head;
        ListNode q = head != null ? head.next : null;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
                q = p.next;
            } else {
                p = p.next;
                q = p.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了99.56% 的Java用户
 * 		内存消耗:40.3 MB,击败了6.58% 的Java用户
 */
}