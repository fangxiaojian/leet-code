//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 28 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：栈的最小值
class P面试题0302MinStackLcci{
    public static void main(String[] args) {
        MinStack solution = new P面试题0302MinStackLcci().new MinStack();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (!stack.empty()) {
            if (!minStack.empty() && stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!minStack.empty()) {
            return minStack.peek();
        }else {
            Stack<Integer> temp = new Stack<>();
            while (!stack.empty()) {
                temp.push(stack.pop());
            }
            while (!temp.empty()) {
                if (minStack.empty() || minStack.peek() > temp.peek()) {
                    minStack.push(temp.peek());
                }
                stack.push(temp.pop());
            }
            return minStack.peek();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:21 ms,击败了28.93% 的Java用户
 * 		内存消耗:40.5 MB,击败了66.33% 的Java用户
 */
}