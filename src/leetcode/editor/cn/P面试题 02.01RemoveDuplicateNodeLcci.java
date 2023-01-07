//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 67 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：移除重复节点
class P面试题0201RemoveDuplicateNodeLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题0201RemoveDuplicateNodeLcci().new Solution();
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
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode p = head.next;
        ListNode beforeP = head;
        while (p != null) {
            temp = head;
            while (temp != p) {
                if (temp.val == p.val) {
                    beforeP.next = p.next;
                    p = beforeP;
                    break;
                }
                temp = temp.next;
            }
            beforeP = p;
            p = p.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:395 ms,击败了10.33% 的Java用户
 * 		内存消耗:39.9 MB,击败了67.12% 的Java用户
 */
}