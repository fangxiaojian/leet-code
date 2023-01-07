//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 215 👎 0


package leetcode.editor.cn;
//Java：最后一个单词的长度
public class P58LengthOfLastWord{    
    public static void main(String[] args) {      
        Solution solution = new P58LengthOfLastWord().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// 2. 从右往左
    class Solution {
        public int lengthOfLastWord(String s) {
            int count = 0;
            for (int i = s.length()-1; i >= 0; i--) {
                if (' ' == s.charAt(i)) {
                    if (count != 0) {
                        return count;
                    }
                } else {
                    count++;
                }
            }
            return count;
        }
    }
//1. 从左往右遍历
//class Solution {
//    public int lengthOfLastWord(String s) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (' ' == s.charAt(i)) {
//                if (++i < s.length() && s.charAt(i) != ' '){
//                    count = 1;
//                }else {
//                    i--;
//                }
//            } else {
//                count++;
//            }
//        }
//        return count;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 从左往右遍历: 遍历字符串统计不为空格' '的字符, 若为空格, 判断下一个字符是否为' ', 是的话继续遍历, 不是的话将数量置为1, 继续遍历
 *     结果:
 *     解答成功:
 * 			执行耗时:3 ms,击败了7.19% 的Java用户
 * 			内存消耗:37.7 MB,击败了6.38% 的Java用户
 * 2. 从右往左遍历: 遍历字符串, 遇到空格' ' 判断数量==0?, No:返回数量
 *     结果:
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:37.8 MB,击败了6.38% 的Java用户
 */
}