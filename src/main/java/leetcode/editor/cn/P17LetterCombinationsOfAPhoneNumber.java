//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{    
    public static void main(String[] args) {      
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();       
        // TO TEST
        List<String> list = solution.letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    char[] temp;
    List<String> list = new ArrayList<>();
    char[][] str = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    final char MAKE_UP = '2';
    public List<String> letterCombinations(String digits) {
        if (digits == null || ("").equals(digits) || digits.length() == 0) {
            return list;
        }
        temp = new char[digits.length()];
        backtracking(0, digits);
        return list;
    }

    private void backtracking(int index, String digits) {
        if (index == digits.length() - 1) {
            for (int i = 0; i < str[digits.charAt(index) - MAKE_UP].length; i++) {
                temp[index] = str[digits.charAt(index) - MAKE_UP][i];
                list.add(new String(temp));
            }
        } else {
            for (int i = 0; i < str[digits.charAt(index) - MAKE_UP].length; i++) {
                temp[index] = str[digits.charAt(index) - MAKE_UP][i];
                backtracking(index + 1, digits);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 回溯算法
 *     先准备电话号码对应的字符
 *     创建char数组用于存放字母组合
 *     用递归实现回溯算法
 *
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:38.7 MB,击败了53.38% 的Java用户
 */


}

