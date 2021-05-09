package leetcode.editor.cn.util;

/**
 * @author 小贱
 * @create 2020-06-08 15:23
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(int[] value1) {
        this.val = value1[0];
        ListNode p1 = this;
        for (int i = 1; i < value1.length; i++) {
            ListNode node = new ListNode(value1[i]);
            p1.next = node;
            p1 = p1.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
