//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


package leetcode.editor.cn;
//Java：验证回文串
public class P125ValidPalindrome{    
    public static void main(String[] args) {      
        Solution solution = new P125ValidPalindrome().new Solution();       
        // TO TEST
        System.out.println(solution.isPalindrome("Marge, let's \\\"[went].\\\" I await {news} telegram."));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 0 || ("").equals(s)) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();
        while (right > left) {
            while (left < right && !(array[left] >= '0' && array[left] <= '9')
                    && !(array[left] >= 'a' && array[left] <= 'z')
                    && !(array[left] >= 'A' && array[left] <= 'Z')) {
                left++;
            }
            while (left < right && !(array[right] >= '0' && array[right] <= '9')
                    && !(array[right] >= 'a' && array[right] <= 'z')
                    && !(array[right] >= 'A' && array[right] <= 'Z')) {
                right--;
            }
            if (array[left] >= 'A' && array[left] <= 'Z') {
                array[left] = (char) (array[left] - 'A' + 'a');
            }
            if (array[right] >= 'A' && array[right] <= 'Z') {
                array[right] = (char) (array[right] - 'A' + 'a');
            }
            if (left == right) {
                break;
            }
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 双指针, 先找到 0~9,a~z,A~Z的数, 再将大写转换为小写, 比较两个元素是否相等, 不等返回 false
 *     以此类推
 *     解答成功:
 * 			执行耗时:2 ms,击败了99.86% 的Java用户
 * 			内存消耗:39.5 MB,击败了97.73% 的Java用户
 */
}