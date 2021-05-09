//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists{    
    public static void main(String[] args) {      
        Solution solution = new P21MergeTwoSortedLists().new Solution();       
        // TO TEST
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(solution.mergeTwoLists(l1, l2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        ListNode temp1 = null;
        ListNode temp2 = null;

        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return null;
        }

        // 优化
        if (l1.val <= l2.val) {
            head = l1;
            temp2 = l2;
        } else {
            head = l2;
            temp2 = l1;
        }
        temp = head;
        temp1 = head.next;

        // 循环查找最小值的节点进行拼接
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp1;
                temp1 = temp.next;
            } else {
                temp = temp1;
                temp1 = temp.next;
            }
        }

        // 拼接不为空的链表
        if (temp2 != null) {
            temp.next = temp2;
        }

        return head;
    }
}

//class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = null;
//        ListNode temp = null;
//
//        if (l1 == null && l2 != null) {
//            return l2;
//        } else if (l1 != null && l2 == null) {
//            return l1;
//        } else if (l1 == null && l2 == null) {
//            return null;
//        }
//
//        // 循环查找最小值的节点进行拼接
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                if (head == null) {
//                    head = l1;
//                    temp = head;
//                } else {
//                    temp.next = l1;
//                    temp = temp.next;
//                }
//                l1 = l1.next;
//            } else {
//                if (head == null) {
//                    head = l2;
//                    temp = head;
//                } else {
//                    temp.next = l2;
//                    temp = temp.next;
//                }
//                l2 = l2.next;
//            }
//        }
//
//        // 拼接不为空的链表
//        if (l1 != null) {
//            temp.next = l1;
//        } else if (l2 != null) {
//            temp.next = l2;
//        }
//
//        return head;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 比较两个链表,找出最小的节点,拼接到新节点后面
 *     解答成功:
 * 			执行耗时:1 ms,击败了62.84% 的Java用户
 * 			内存消耗:39 MB,击败了66.35% 的Java用户
 *
 * 2. 优化: 既然是将最小节点赋给新节点, 那么, 新节点的下一个节点是最小节点, 则不需要重新赋给新节点
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:39.8 MB,击败了40.19% 的Java用户
 */
}