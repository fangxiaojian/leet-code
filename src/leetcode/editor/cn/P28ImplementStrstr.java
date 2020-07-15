//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 495 👎 0

package leetcode.editor.cn;
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            if (haystack.length() < needle.length()) {
                return -1;
            }
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int j = 1, k = i + 1;
                    for (; j < needle.length() && k < haystack.length(); j++, k++) {
                        if (haystack.charAt(k) != needle.charAt(j)) {
                            break;
                        }
                    }
                    if (j == needle.length()) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：
 * 1. 暴力破解: 直接遍历A字符串, 若与B第一个字符相同, AB同时遍历, 直到找到A中与B相同的位置为止
 *     结果: 耗时与内存都大,不可取
 *     解答成功:
 * 			执行耗时:4 ms,击败了27.53% 的Java用户
 * 			内存消耗:38.1 MB,击败了8.69% 的Java用户
 */

}