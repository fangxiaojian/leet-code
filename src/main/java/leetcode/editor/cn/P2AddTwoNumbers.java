//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：两数相加
public class P2AddTwoNumbers{    
    public static void main(String[] args) {      
        Solution solution = new P2AddTwoNumbers().new Solution();       
        // TO TEST
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        System.out.println(solution.addTwoNumbers(l1, l2).toString());
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode p = null;
        int addVal = 0; // 计算进位的值
        // 遍历两个链表 并计算他们的和
        while (l1 != null && l2 != null) {
            addVal = l1.val + l2.val + addVal;
            // 取和的余数 创建新的节点
            ListNode node = new ListNode(addVal%10);
            // 计算进位数
            addVal /= 10;
            if (head == null) {
                head = node;
                p = head;
            } else {
                p.next = node;
                p = p.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        // 判断是否有链表不为空 及 进位数是否为空
        if (l1 != null) {
            p.next = addRemainder(l1, addVal);
        } else if (l2 != null) {
            p.next = addRemainder(l2, addVal);
        } else if (addVal != 0){
            p.next = new ListNode(addVal);
        }
        return head;
    }

    // 将不为空的链表添加进新的链表中
    private ListNode addRemainder(ListNode listNode, int addVal){
        ListNode head = null;
        ListNode p = null;
        while (listNode != null) {
            // 进位数不为空,需计算
            if (addVal != 0) {
                addVal = listNode.val + addVal;
                ListNode node = new ListNode(addVal % 10);
                addVal /= 10;
                if (head == null) {
                    head = node;
                    p = head;
                } else {
                    p.next = node;
                    p = p.next;
                }
                listNode = listNode.next;
            } else { // 进位数为空, 直接将链表添加到新链表的后面
                if (head == null) {
                    head = listNode;
                } else {
                    p.next = listNode;
                }
                break;
            }
        }
        // 进位数不为空, 链表为空, 需将进位数添加进链表中
        if (addVal != 0) {
            while (p.next != null) {
                p = p.next;
            }
            p.next = new ListNode(addVal);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路
 * 遍历两个链表,计算他们的数值,取10的余数新建一个新的节点
 * 计算数值时要将 之前计算的数值 除10 加入
 * 当有一个链表为空时,要判断是否还有链表不为空 以及 之前计算的数值 除10 之后是否为空
 *
 *      解答成功:
 * 			执行耗时:2 ms,击败了99.91% 的Java用户
 * 			内存消耗:39.6 MB,击败了94.74% 的Java用户
  */

}