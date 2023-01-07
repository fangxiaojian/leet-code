package leetcode.editor.cn.util;

/**
 * @author 小贱
 * @create 2020-11-13 下午2:23
 */
public class LinkNode {
    public int val;
    public LinkNode next;

    public LinkNode() {}

    public LinkNode(int val) {
        this.val = val;
    }

    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }
}
