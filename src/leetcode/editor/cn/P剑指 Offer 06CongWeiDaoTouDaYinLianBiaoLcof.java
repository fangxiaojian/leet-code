//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 60 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

//Java：从尾到头打印链表
class P剑指Offer06CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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

    private int[] nums;
    private int count = 0;
    private int index = 0;
    public int[] reversePrint(ListNode head) {
        recursionLinks(head);
        return nums;
    }

    private void recursionLinks(ListNode head) {
        if (head == null) {
            nums = new int[count];
        }else {
            count++;
            recursionLinks(head.next);
            nums[index++] = head.val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:40.7 MB,击败了5.02% 的Java用户
 */
}