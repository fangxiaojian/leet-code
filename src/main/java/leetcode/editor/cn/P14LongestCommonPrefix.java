//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package leetcode.editor.cn;
//Java：最长公共前缀
public class P14LongestCommonPrefix{    
    public static void main(String[] args) {      
        Solution solution = new P14LongestCommonPrefix().new Solution();       
        // TO TEST
        String[] strs = {"a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution{
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return ans;
            }
        }
        return ans;
    }
}


//class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        int minLength = 0;
//        for (int i = 0; i < strs.length; i++) {
//            if (i == 0 || minLength > strs[i].length()) {
//                minLength = strs[i].length();
//            }
//        }
//
//        char c;
//        String comm = "";
//        for (int i = 0; i < minLength; i++) {
//            c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (c != strs[j].charAt(i)) {
//                    return comm;
//                }
//            }
//            comm += c;
//        }
//        return comm;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 暴力破解: 从头开始循环比较 --  用时,内存都比较大
 *     解答成功:
 * 			执行耗时:13 ms,击败了5.14% 的Java用户
 * 			内存消耗:38.5 MB,击败了5.00% 的Java用户
 *
 *
 * 	2. 将第一个字符串作为初始值, 与接下来的字符串进行比较, 获取相同前缀作为初始值, 以此类推
 * 	    解答成功:
 * 			执行耗时:1 ms,击败了78.40% 的Java用户
 * 			内存消耗:37.9 MB,击败了15.84% 的Java用户
 */
}