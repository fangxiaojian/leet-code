//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 42 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：返回倒数第 k 个节点
class P面试题0202KthNodeFromEndOfListLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题0202KthNodeFromEndOfListLcci().new Solution();
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
    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return -1;
        }
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p == null) {
                return -1;
            }
            p = p.next;
        }
        while (p != null) {
            head = head.next;
            p = p.next;
        }
        return head.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了16.87% 的Java用户
 * 		内存消耗:36.8 MB,击败了15.77% 的Java用户
 */
}