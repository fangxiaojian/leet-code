//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 119 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：用两个栈实现队列
//public class P剑指 Offer 09YongLiangGeZhanShiXianDuiLieLcof{
public class P剑指Offer09YongLiangGeZhanShiXianDuiLieLcof{
    public static void main(String[] args) {
        CQueue solution = new P剑指Offer09YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.empty()) {
            return stack2.pop();
        }else {
            return -1;
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:59 ms,击败了47.40% 的Java用户
 * 		内存消耗:46.9 MB,击败了40.38% 的Java用户
 */
}