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

import javafx.collections.transformation.SortedList;
import leetcode.editor.cn.util.ListNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

//Java：合并K个排序链表
public class P23MergeKSortedLists{    
    public static void main(String[] args) {      
        Solution solution = new P23MergeKSortedLists().new Solution();       
        // TO TEST
        int[] value1 = {1, 4, 5};
        int[] value2 = {1, 3, 4};
        int[] value3 = {2, 6};
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(value1);
        listNodes[1] = new ListNode(value2);
        listNodes[2] = new ListNode(value3);
//        ListNode[] listNodes = new ListNode[2];
//        listNodes[0] = null;
//        listNodes[1] = new ListNode(1);
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
        ListNode head = null, h = null, temp = null;
        if (lists == null) {
            return null;
        }
        Map<Integer, List<ListNode>> map = new TreeMap<>();

        for (ListNode listNode : lists) {
            if (listNode != null) {
                if (map.containsKey(listNode.val)) {
                    List<ListNode> listNodes = map.get(listNode.val);
                    listNodes.add(listNode);
                } else {
                    List<ListNode> listNodes = new ArrayList<>();
                    listNodes.add(listNode);
                    map.put(listNode.val, listNodes);
                }
            }
        }

        while (map.size() > 0) {
            Iterator<Integer> iter = map.keySet().iterator();
            Integer i = iter.next();
            List<ListNode> listNodes = map.get(i);
            map.remove(i);
            for (ListNode listNode : listNodes) {
                if (head == null) {
                    head = new ListNode(listNode.val);
                    h = head;
                } else {
                    temp = new ListNode(listNode.val);
                    h.next = temp;
                    h = temp;
                }
                if (listNode.next != null) {
                    if (map.containsKey(listNode.next.val)) {
                        List<ListNode> xx = map.get(listNode.next.val);
                        xx.add(listNode.next);
                    } else {
                        List<ListNode> xx = new ArrayList<>();
                        xx.add(listNode.next);
                        map.put(listNode.next.val, xx);
                    }
                }
            }
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}