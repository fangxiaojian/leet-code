//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList{    
    public static void main(String[] args) {      
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();       
        // TO TEST
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        solution.removeNthFromEnd(head, 2);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null) {
            return head;
        }
        ListNode p1=head, p2=head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2 == null && p1==head) {
            return head.next;
        } else {
            p1.next = p1.next.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 双指针:                       1 -> 2 -> 3 -> 4 -> 5       删除倒数第2个数
 *    现将p2指针向前移动2位数,                  p2
 *    p1指针指在头节点1,             p1        p2
 *    遍历链表至末尾,此时                       p1        p2
 *    p1 的下一个节点就是要删除的节点
 *    解答成功:
 * 			执行耗时:1 ms,击败了22.35% 的Java用户
 * 			内存消耗:38 MB,击败了38.60% 的Java用户
 */
}