//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1238 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：反转链表
public class P206ReverseLinkedList{    
    public static void main(String[] args) {      
        Solution solution = new P206ReverseLinkedList().new Solution();       
        // TO TEST
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        solution.reverseList(head);
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next != null) {
            ListNode newHead = reverseList(head.next);
            ListNode p = newHead;
            head.next = null;
            while (p.next != null) {
                p = p.next;
            }
            p.next = head;
            return newHead;
        } else {
            return head;
        }
    }
}

//class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode newHead = null;
//        ListNode p = head;
//        while (p != null) {
//            head = head.next;
//            p.next = newHead;
//            newHead = p;
//            p = head;
//        }
//
//        return newHead;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 1. 迭代
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:39.2 MB,击败了5.25% 的Java用户
 *
 * 	2. 递归
 * 	解答成功:
 * 		执行耗时:22 ms,击败了100.00% 的Java用户
 * 	    内存消耗:39.4 MB,击败了5.25% 的Java用户
 */
}