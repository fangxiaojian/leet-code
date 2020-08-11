//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 836 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

//Java：合并K个排序链表
public class P23MergeKSortedLists{    
    public static void main(String[] args) {      
        Solution solution = new P23MergeKSortedLists().new Solution();       
        // TO TEST
//        int[] value1 = {1, 4, 5};
//        int[] value2 = {1, 3, 4};
//        int[] value3 = {2, 6};
//        ListNode[] listNodes = new ListNode[3];
//        listNodes[0] = new ListNode(value1);
//        listNodes[1] = new ListNode(value2);
//        listNodes[2] = new ListNode(value3);
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = null;
        listNodes[1] = new ListNode(1);
        solution.mergeKLists(listNodes);
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int count = 0;
        ListNode head = lists[0];
        int i = 0;
        for (; i < lists.length; i++) {
            if (lists[i] != null) {
                head = lists[i];
                break;
            }
        }
        Queue<ListNode> queue = new LinkedBlockingQueue<>();
        for (i++; i < lists.length; i++) {
            if (lists[i] != null) {
                if (head.val > lists[i].val) {
                    queue.offer(head);
                    count++;
                    head = lists[i];
                } else {
                    queue.offer(lists[i]);
                    count++;
                }
            }
        }
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode temp = head.next;
        ListNode p2;
        while (!queue.isEmpty()) {
            if (temp == null) {
                p1.next = queue.poll();
                temp = p1.next;
                count--;
            }
            for (int j = 0; j < count; j++) {
                p2 = queue.poll();
                if (temp.val <= p2.val) {
                    queue.offer(p2);
                } else {
                    p1.next = p2;
                    queue.offer(temp);
                    temp = p1.next;
                }
            }
            p1 = p1.next;
            temp = p1.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}