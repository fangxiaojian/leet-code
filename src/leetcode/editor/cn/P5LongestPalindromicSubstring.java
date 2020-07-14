//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{    
    public static void main(String[] args) {      
        Solution solution = new P5LongestPalindromicSubstring().new Solution();       
        // TO TEST
        String s = "abdadba";
        System.out.println(solution.longestPalindrome(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        boolean isPalindrome = false;
        int[] sums = new int[128];
        int countMax = 0; // 最大不重复数
        int start=0, end=1;
        int left, right;
        int tempIndex = 0;  // 临时不重复数
        for (int i = 0; i < s.length(); i++) {
            if (sums[s.charAt(i)] != 0) {
                left = sums[s.charAt(i)] - 1;
                right = i;
                for (int j = 0; j < (left + right) / 2; j++) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        right--;
                    } else {
                        sums[s.charAt(i)] = i + 1;
                        isPalindrome = true;
                        break;
                    }
                }
                if (!isPalindrome) {
                    isPalindrome = false;
                    tempIndex = i - (sums[s.charAt(i)] - 1) + 1;
                    if (countMax < tempIndex) {// 判断最大重复数
                        countMax = tempIndex;
                        start = sums[s.charAt(i)] - 1;
                        end = i + 1;
                    }
                }
            }else {
                sums[s.charAt(i)] = i + 1; // 数组值为 索引+1
            }
        }
        return s.substring(start, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}