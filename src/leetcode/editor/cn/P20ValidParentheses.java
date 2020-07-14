//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package leetcode.editor.cn;

import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses{    
    public static void main(String[] args) {      
        Solution solution = new P20ValidParentheses().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length() < 0 || s.length() % 2 != 0 || s == null) {
            return false;
        }
        if (("").equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                } else if (s.charAt(i) == ')' && stack.pop() !='(') {
                    return false;
                } else if (s.charAt(i) == ']' && stack.pop() !='[') {
                    return false;
                } else if (s.charAt(i) == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }

        return stack.empty() ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 使用栈来解答
 *    解答成功:
 * 			执行耗时:2 ms,击败了82.35% 的Java用户
 * 			内存消耗:37.6 MB,击败了5.48% 的Java用户
 */
}