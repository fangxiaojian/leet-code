//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 345 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList{    
    public static void main(String[] args) {      
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();       
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        int temp = head.val;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (temp == q.val) {
                p.next = q.next;
                q.next = null;
            } else {
                temp = q.val;
                p = p.next;
            }
            q = p.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 将链表中的数值存放起来, 遍历链表,
 *     若链表的值与之前的值相等, 删除链表
 *     不等, 则更新之前数值
 *     结果:
 *     解答成功:
 * 			执行耗时:1 ms,击败了72.38% 的Java用户
 * 			内存消耗:39.3 MB,击败了5.97% 的Java用户
 */
}