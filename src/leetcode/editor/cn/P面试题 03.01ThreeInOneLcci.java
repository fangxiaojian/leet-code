//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
//     stackNum表示栈下标，value表示压入的值。
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 设计 
// 👍 19 👎 0


package leetcode.editor.cn;
//Java：三合一
class P面试题0301ThreeInOneLcci{
    public static void main(String[] args) {
        int stackSize = 0;
        TripleInOne solution = new P面试题0301ThreeInOneLcci().new TripleInOne(stackSize);
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class TripleInOne {

    int stackSize;
    int[][] stacks;
    int[] index;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        stacks = new int[3][stackSize];
        index = new int[3];
    }
    
    public void push(int stackNum, int value) {
        if (index[stackNum] < stackSize) {
            stacks[stackNum][index[stackNum]] = value;
            index[stackNum] += 1;
        }
    }
    
    public int pop(int stackNum) {
        if (index[stackNum] <= 0) {
            return -1;
        }
        index[stackNum] -= 1;
        return stacks[stackNum][index[stackNum]];
    }
    
    public int peek(int stackNum) {
        if (index[stackNum] <= 0) {
            return -1;
        }
        return stacks[stackNum][index[stackNum]-1];
    }
    
    public boolean isEmpty(int stackNum) {
        return index[stackNum] <= 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:12 ms,击败了95.62% 的Java用户
 * 		内存消耗:47.3 MB,击败了93.65% 的Java用户
 */
}