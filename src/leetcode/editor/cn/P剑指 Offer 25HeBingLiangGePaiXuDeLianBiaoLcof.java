//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 63 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：合并两个排序的链表
class P剑指Offer25HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer25HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        ListNode temp1 = null;
        ListNode temp2 = null;

        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null) {
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
        while (temp1 != null) {
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
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了98.87% 的Java用户
 * 		内存消耗:38.7 MB,击败了77.20% 的Java用户
 */
}