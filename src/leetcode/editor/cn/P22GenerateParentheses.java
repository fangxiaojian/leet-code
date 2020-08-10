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
    int count = 0;
    int left = 0;
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return list;
        }
        parenthesis = new char[n * 2];
        parenthesis(n);
        return list;
    }

    private void parenthesis(int n) {
        for (int i = 0; i < n; i++) {
            parenthesis[count++] = '(';
            parenthesis(n - i - 1);
            count = parenthesis.length / 2 - i - 1;
            parenthesis[count++] = ')';
        }
        for (int i = count; i< parenthesis.length; i++) {
            parenthesis[i] = ')';
        }
        list.add(new String(parenthesis));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}