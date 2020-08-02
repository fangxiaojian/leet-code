//请你来实现一个 atoi 函数，使其能将字符串转换成整数。 
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下： 
//
// 
// 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。 
// 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。 
// 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。 
// 
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。 
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0 。 
//
// 提示： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31, 2^31 − 1]。如果数值超过这个范围，请返回 INT_MAX (2^31
// − 1) 或 INT_MIN (−2^31) 。
// 
//
// 
//
// 示例 1: 
//
// 输入: "42"
//输出: 42
// 
//
// 示例 2: 
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
// 
//
// 示例 3: 
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
// 
//
// 示例 4: 
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。 
//
// 示例 5: 
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
//     因此返回 INT_MIN (−2^31) 。
// 
// Related Topics 数学 字符串


package leetcode.editor.cn;
//Java：字符串转换整数 (atoi)
public class P8StringToIntegerAtoi{    
    public static void main(String[] args) {      
        Solution solution = new P8StringToIntegerAtoi().new Solution();       
        // TO TEST
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(solution.myAtoi("2147483648"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int myAtoi(String str) {
        int flag = 1; // 表示正负数
        if (str == null || ("").equals(str) || str.length() == 0) {
            return 0;
        }
        int count = 0;
        int digits = 0;
        int result = 0;
        char[] cStr = str.toCharArray();
        while (count < cStr.length && cStr[count] == ' ') {
            count++;
        }
        if (count < cStr.length && cStr[count] == '-') {
            flag = -1;
            count++;
        } else if (count < cStr.length && cStr[count] == '+') {
            count++;
        }
        while (count < cStr.length && cStr[count] >= '0' && cStr[count] <= '9') {
            if (digits > 8) {
                if (flag == 1) {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < cStr[count] - '0')) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (Integer.MAX_VALUE % 10 + 1) < cStr[count] - '0')) {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            result = result * 10 + cStr[count] - '0';
            count++;
            digits++;
        }
        return flag * result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. Integer.MAX_VALUE = 2147483647, 共10位数
 *     所以当返回值 result 在9位数内, 不需要考虑移除问题
 *     当 result 超过9位数使, 判断 result 是否比 Integer.MAX_VALUE/10 大?
 *     或者 result == Integer.MAX_VALUE/10 就判断新数值是否比 Integer.MAX_VALUE%10 大?
 *     <0 亦同上
 *     解答成功:
 * 			执行耗时:2 ms,击败了99.69% 的Java用户
 * 			内存消耗:39.7 MB,击败了70.95% 的Java用户
 */
}