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
        String s = "cccabcccc";
        System.out.println(solution.longestPalindrome(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//3
class Solution {
    public String longestPalindrome(String s) {
        if ("".equals(s) || s == null) {
            return "";
        }
        int begin = 0, size = 1;
        int left, right;
        // i为中点
        for (int i = 0; i < s.length() && (s.length() - i) * 2 > size; i++) {
            left = i;
            // 将相同的数归为中点
            while (i + 1 < s.length() && s.charAt(left) == s.charAt(i + 1)) {
                i++;
            }
            // 此时 i 指向的是相同数最大的下标
            right = i;
            // 从左右两边开始查找回文数
            while (left > 0 && right < s.length() - 1) {
                if (s.charAt(left - 1) == s.charAt(right + 1)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            // 判断新回文数是否比旧的大，大则更新，小则不变
            if (right - left + 1 > size) {
                begin = left;
                size = right - left + 1;
            }

        }


        return s.substring(begin, begin + size); // 返回最大回文子串
    }
}

// 2. 暴力双循环
//class Solution {
//    public String longestPalindrome(String s) {
//        if ("".equals(s) || s == null) {
//            return "";
//        }
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            lab : for (int j = s.length() - 1; j > i; j--) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    for (int k = j - 1, l = i + 1; k > l; k--, l++) {
//                        if (s.charAt(k) != s.charAt(l)) {
//                            continue lab;
//                        }
//                    }
//                    if ((end - start) == 0 || (end - start) < (j - i)) {
//                        start = i;
//                        end = j;
//                    }
//                }
//            }
//        }
//
//        return s.substring(start, end+1); // 返回最大回文子串
//    }
//}

// 1.
//class Solution {
//    public String longestPalindrome(String s) {
//        // 判断字符串是否为null
//        if ("".equals(s) || s == null) {
//            return "";
//        }
//        int[][] sums = new int[s.length()][128];
//        int start=0, end=0;
//        int left, right;
//        for (int i = 0; i < s.length(); i++) {
//            if (sums[0][s.charAt(i)] != 0) {
//                int count = 1; // 记录数组中有多少位相同字符
//                while (sums[count][s.charAt(i)] != 0) {
//                    count ++;
//                }
//                sums[count][s.charAt(i)] = i + 1; // 数组值为 索引+1
//                int ignore = 0; // 忽略前几位数
//                lab : while (count - ignore > 0) {
//                    if ((count - ignore) % 2 == 0) { // 奇数个相同
//                        // 有多余相同的数，并且个数为奇数，则判断中间的数是否是前后相同数的中点
//                        if ((sums[ignore][s.charAt(i)] + i + 1) % 2 != 0 && sums[(count - ignore) / 2][s.charAt(i)] != (sums[ignore][s.charAt(i)] + i + 1) / 2) {
//                            ignore++;
//                            continue;
//                        }
//                    } else { // 偶数个相同
//                        if ((count - ignore) > 1) {
//                            // 判断相同节点的下标是否对应
//                            for (int j = ignore+1, k = count - 1; j <= (count - ignore) / 2; j++, k--) {
//                                if ((sums[j][s.charAt(i)] - sums[ignore][s.charAt(i)]) != (i + 1 - sums[k][s.charAt(i)])) {
//                                    ignore++;
//                                    continue lab;
//                                }
//                            }
//                        }
//                    }
//                    // 标记左右下标
//                    left = sums[ignore][s.charAt(i)] - 1;
//                    right = i;
//                    // 遍历判断是否为回文子串
//                    for (int j = 0; j <= (left + right) / 2 && left < right; j++) {
//                        if (s.charAt(left) == s.charAt(right)) {
//                            left++;
//                            right--;
//                        } else { // 不是回文子串
//                            ignore++;
//                            continue lab;
//                        }
//                    }
//                    // 判断是否是最大回文子串
//                    if ((end - start) == 0 || (end - start) < (i + 1 - sums[ignore][s.charAt(i)])) {
//                        start = sums[ignore][s.charAt(i)] - 1;
//                        end = i;
//                        break;
//                    }
//                    ignore++;
//                }
//            }else {
//                sums[0][s.charAt(i)] = i + 1; // 数组值为 索引+1
//            }
//        }
//        return s.substring(start, end+1); // 返回最大回文子串
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 一次失败的体验:
 *     记录相同字符的下标, 按顺序存放到二维数组中, 若出现相同的字符, 遍历数组, 找到回文子串
 *     解答成功:
 * 			执行耗时:1381 ms,击败了5.01% 的Java用户
 * 			内存消耗:41.4 MB,击败了49.70% 的Java用户
 * 2. 暴力双循环 	Time Limit Exceeded	超时
 * 3. 遍历字符串，将各个点当成中点，以中心向左右遍历查询回文数
 *     a. 先往后遍历相同字符，以这些字符作为中点
 *     解答成功:
 * 			执行耗时:9 ms,击败了95.46% 的Java用户
 * 			内存消耗:37.6 MB,击败了97.96% 的Java用户
 */
}