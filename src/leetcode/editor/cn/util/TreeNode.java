package leetcode.editor.cn.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public TreeNode(Integer[] values) {
        if (values[0] != null) {
            val = values[0];
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(this);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode root = queue.poll();
            if (values[i] != null) {
                root.left = new TreeNode(values[i]);
                queue.offer(root.left);
            }
            i++;
            if (i< values.length && values[i] != null) {
                root.right = new TreeNode(values[i]);
                queue.offer(root.right);
            }
            i++;
        }
    }
}
