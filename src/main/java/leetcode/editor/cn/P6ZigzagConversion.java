//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串


package leetcode.editor.cn;
//Java：Z 字形变换
public class P6ZigzagConversion{    
    public static void main(String[] args) {    
        Solution solution = new P6ZigzagConversion().new Solution();       
        // TO TEST
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public String convert(String s, int numRows) {
        if (s == null || ("").equals(s) || s.length() == 0 || numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int count = 0;
        char[] str = new char[s.length()];
        int index = 0;
        // 遍历字符串
        for (int i = 0, j = 0; i < s.length(); i++) {
            str[count++] = s.charAt(index);
            if (j == 0 || j == numRows - 1) {
                index += (numRows - 1) * 2;
            } else {
                index += (numRows - 1) * 2 - 2 * j;
                if (index < s.length()) {
                    str[count++] = s.charAt(index);
                    i++;
                }
                index += j * 2;
            }
            if (index >= s.length()) {
                j++;
                index = j;
            }
        }

        return new String(str);
    }
}
// 1.
//class Solution {
//    public String convert(String s, int numRows) {
//        if (s == null || ("").equals(s) || s.length() == 0 || numRows == 1 || s.length() <= numRows) {
//            return s;
//        }
//        int count = 0; // 二维数组下标
//        String[] strs = new String[numRows]; // 分割原字符串
//        String str = ""; // 最终结果
//        int flag = -1; // 与count相加,使数组上下波动
//        // 遍历字符串
//        for (int i = 0; i < s.length(); i++) {
//            // 若字符串不为null 直接拼接
//            if (strs[count] != null) {
//                strs[count] += s.charAt(i);
//            }else { // 字符串为空
//                strs[count] = s.substring(i, i + 1);
//            }
//            // 判断下标是否达到临界值
//            if (count == numRows-1 || count == 0) {
//                flag *= -1;
//            }
//            count += flag;
//        }
//        // 拼接最终结果
//        for (int i = 0; i < numRows && i < s.length(); i++) {
//            str += strs[i];
//        }
//        return str;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 寻找规律
 *     L E E T C O D E I S H I R I N G
 *     1           2           3
 *       1       2   3       4   5
 *         1   2       3   4       5
 *           1           2           3
 *     因此创建二维字符串,利用字符串拼接的技术将原字符串存放至二维数组中.
 *     解答成功:
 * 			执行耗时:18 ms,击败了23.83% 的Java用户
 * 			内存消耗:40.4 MB,击败了35.40% 的Java用户
 * 2. 通过计算得出每一行所对应的下标, 遍历存放至string中.
 *     所使用的字符串拼接的方式
 *     解答成功:
 * 			执行耗时:19 ms,击败了22.47% 的Java用户
 * 			内存消耗:40.7 MB,击败了8.85% 的Java用户
 * 	   改为数组存放方式
 * 	   解答成功:
 * 			执行耗时:3 ms,击败了99.25% 的Java用户
 * 			内存消耗:39.9 MB,击败了82.52% 的Java用户
 */
}