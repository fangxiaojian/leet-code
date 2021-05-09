//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
//
// 注意: 
//
// 
// 十六进制中所有字母(a-f)都必须是小写。 
// 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
// 给定的数确保在32位有符号整数范围内。 
// 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。 
// 
//
// 示例 1： 
//
// 
//输入:
//26
//
//输出:
//"1a"
// 
//
// 示例 2： 
//
// 
//输入:
//-1
//
//输出:
//"ffffffff"
// 
// Related Topics 位运算 
// 👍 97 👎 0


package leetcode.editor.cn;
//Java：数字转换为十六进制数
public class P405ConvertANumberToHexadecimal{    
    public static void main(String[] args) {      
        Solution solution = new P405ConvertANumberToHexadecimal().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        } else {
            return toHexString(num);
        }
    }

    private String toHexString(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            int temp = num & 0x0000000f;
            num = num >>> 4;
            if (temp < 10) {
                stringBuilder.append(temp);
            }else {
                switch (temp) {
                    case 10:
                        stringBuilder.append("a");
                        break;
                    case 11:
                        stringBuilder.append("b");
                        break;
                    case 12:
                        stringBuilder.append("c");
                        break;
                    case 13:
                        stringBuilder.append("d");
                        break;
                    case 14:
                        stringBuilder.append("e");
                        break;
                    default:
                        stringBuilder.append("f");
                        break;
                }
            }
        }
        return stringBuilder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.8 MB,击败了96.59% 的Java用户
 */
}