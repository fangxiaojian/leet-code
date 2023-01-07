//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 646 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：回文链表
public class P234PalindromeLinkedList{    
    public static void main(String[] args) {      
        Solution solution = new P234PalindromeLinkedList().new Solution();       
        // TO TEST
        ListNode listNode = new ListNode(new int[]{1, 2, 2, 1});
        solution.isPalindrome(listNode);
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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode newHead = null;
        ListNode temp;
        while (fast.next != null && fast.next.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            temp.next = newHead;
            newHead = temp;
        }
        if (fast.next != null) {
            temp = slow;
            slow = slow.next;
            temp.next = newHead;
            newHead = temp;
        }else if (slow.next != null) {
            slow = slow.next;
        }
        while (newHead != null && slow != null) {
            if (newHead.val != slow.val) {
                return false;
            }
            newHead = newHead.next;
            slow = slow.next;
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了99.84% 的Java用户
 * 		内存消耗:41.4 MB,击败了65.37% 的Java用户
 */
}