//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串


package leetcode.editor.cn;
//Java：罗马数字转整数
public class P13RomanToInteger{    
    public static void main(String[] args) {      
        Solution solution = new P13RomanToInteger().new Solution();       
        // TO TEST
        String s = "III";
        System.out.println(solution.romanToInt(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
        int count = 0;
        int lastSum=0, newSum=0;
        if (s.length() > 0) {
            lastSum = getRealeSum(s.charAt(0));
            count += lastSum;
        }
        for (int i = 1; i < s.length(); i++) {
            newSum = getRealeSum(s.charAt(i));
            if (lastSum < newSum){
                count = count + newSum - lastSum - lastSum;
            } else {
                count += newSum;
            }
            lastSum = newSum;
        }
        return count;
    }

    private int getRealeSum(char c) {
        switch (c - 'A') {
            case 8:
                return 1;
            case 21:
                return 5;
            case 23:
                return 10;
            case 11:
                return 50;
            case 2:
                return 100;
            case 3:
                return 500;
            case 12:
                return 1000;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. switch : 通过计算 字符-'A' 的大小 计算它代表的数字
 *     判断字符与上一个字符的大小, 若大于, 则加上新字符 减去旧字符*2
 *     解答成功:
 * 			执行耗时:4 ms,击败了99.98% 的Java用户
 * 			内存消耗:40 MB,击败了5.56% 的Java用户
 */
}