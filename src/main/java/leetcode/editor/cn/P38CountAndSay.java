//给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。 
//
// 注意：整数序列中的每一项将表示为一个字符串。 
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 第一项是数字 1 
//
// 描述前一项，这个数是 1 即 “一个 1 ”，记作 11 
//
// 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21 
//
// 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211 
//
// 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
//解释：这是一个基本样例。 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
//解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 
//"1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。 
// Related Topics 字符串 
// 👍 497 👎 0


package leetcode.editor.cn;
//Java：外观数列
public class P38CountAndSay{    
    public static void main(String[] args) {      
        Solution solution = new P38CountAndSay().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            String result = "1";
            for (int i = 1; i < n; i++) {
                StringBuilder newResult = new StringBuilder();
                for (int j = 0; j < result.length();) {
                    int count = 1;
                    char c = result.charAt(j);
                    while (++j < result.length() && c == result.charAt(j)) {
                        count++;
                    }
                    newResult.append(count).append(c);
                }
                result = newResult.toString();
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：
 * 1. 暴力解答: 初始化字符串为"1", 循环n遍, 遍历字符串, 记录相同字符数, append(数目).append(字符),
 *     将新字符串赋值给老字符, 继续循环
 *     结果:
 *     解答成功:
 * 			执行耗时:3 ms,击败了51.89% 的Java用户
 * 			内存消耗:36.8 MB,击败了5.41% 的Java用户
 */
}