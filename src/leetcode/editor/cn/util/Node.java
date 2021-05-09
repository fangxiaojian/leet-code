package leetcode.editor.cn.util;

import java.util.List;

/**
 * @author 小贱
 * @create 2020-10-13 下午4:04
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
