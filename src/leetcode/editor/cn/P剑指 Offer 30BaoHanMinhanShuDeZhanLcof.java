//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 46 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：包含min函数的栈
//public class P剑指 Offer 30BaoHanMinhanShuDeZhanLcof{
class P剑指Offer30BaoHanMinhanShuDeZhanLcof{
    public static void main(String[] args) {
        MinStack solution = new P剑指Offer30BaoHanMinhanShuDeZhanLcof().new MinStack();
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

        public int min() {
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
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:20 ms,击败了44.88% 的Java用户
 * 		内存消耗:40.8 MB,击败了29.79% 的Java用户
 */
}