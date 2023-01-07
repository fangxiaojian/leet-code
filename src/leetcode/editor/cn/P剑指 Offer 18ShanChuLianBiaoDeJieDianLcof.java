//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 54 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：删除链表的节点
class P剑指Offer18ShanChuLianBiaoDeJieDianLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer18ShanChuLianBiaoDeJieDianLcof().new Solution();
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
    public ListNode deleteNode(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode p = head;
        ListNode q = head != null ? head.next : null;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = p.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.4 MB,击败了56.61% 的Java用户
 */
}