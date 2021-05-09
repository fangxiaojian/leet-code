//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1223 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses{    
    public static void main(String[] args) {      
        Solution solution = new P22GenerateParentheses().new Solution();       
        // TO TEST
        solution.generateParenthesis(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private List<String> list = new ArrayList<>();
    char[] parenthesis;
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return list;
        }
        parenthesis = new char[n * 2];
        parenthesis(n, 0, 0);
        return list;
    }

    private void parenthesis(int n, int m, int count) {
        while (m < n && count < parenthesis.length) {
            parenthesis[count++] = '(';
            parenthesis(n, ++m, count);
            // 回退一格
            m--;
            count--;
            // 置为 ')'
            if (count < m * 2) {
                parenthesis[count++] = ')';
            } else { // 关闭递归
                return;
            }
        }
        // 补全 括号
        while (count < parenthesis.length) {
            parenthesis[count++] = ')';
        }
        list.add(new String(parenthesis));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 递归: 特别需要注意的是, 递归在哪里需要停止
 *    解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		存消耗:39.7 MB,击败了81.08% 的Java用户
 */
}