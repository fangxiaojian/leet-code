//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters{    
    public static void main(String[] args) {      
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();       
        // TO TEST
        String s = "abba";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution{
    public int lengthOfLongestSubstring(String s) {
        int[] sums = new int[128];
        int countMax = 0; // 最大不重复数
        int tempIndex = 0;  // 临时不重复数
        int lastRepeat = 0; // 上一个重复数的下标
        for (int i = 0; i < s.length(); i++) {
            // 不重复 --- 临时数+1
            if (sums[s.charAt(i)] == 0) {
                tempIndex++;
            } else { // 重复了
                // 重复数在上一次重复的右边 ----- abba 问题
                if ((sums[s.charAt(i)] - 1) >= lastRepeat) {
                    lastRepeat = sums[s.charAt(i)] - 1; // 更新重复数下标
                    countMax = countMax > tempIndex ? countMax : tempIndex; // 判断最大重复数
                    tempIndex = i - (sums[s.charAt(i)] - 1); // 计算重复数之间有多少字符 --- 为得到真正索引值:-1
                } else {  // 重复数在上一次重复数的左边 ---- 直接 +1
                    tempIndex++;
                }
            }
            sums[s.charAt(i)] = i + 1; // 数组值为 索引+1
        }
        return countMax > tempIndex ? countMax : tempIndex;
    }
}



/****************************                  2                ********************************/
//class Solution{
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || "".equals(s)) {
//            return 0;
//        }
//        ArrayDeque<Character> queue = new ArrayDeque<>();
//        char[] chars = s.toCharArray();
//        int countMax = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (queue.contains(chars[i])) {
//                countMax = countMax > queue.size() ? countMax : queue.size();
//                char c = queue.removeLast();
//                while (c != chars[i]) {
//                    c = queue.removeLast();
//                }
//                queue.addFirst(chars[i]);
//            } else {
//                queue.addFirst(chars[i]);
//            }
//        }
//        return countMax > queue.size() ? countMax : queue.size();
//    }
//}
/***********************************************************************************************/


/****************************                  1                ********************************/
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || "".equals(s)) {
//            return 0;
//        }
//        Set<Character> set = new HashSet<>();
//        char[] chars = s.toCharArray();
//        int countMax = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (set.contains(chars[i])) {
//                countMax = countMax > set.size() ? countMax : set.size();
//                set = new HashSet<>();
//                set.add(chars[i]);
//            } else {
//                set.add(chars[i]);
//            }
//        }
//        return countMax > set.size() ? countMax : set.size();
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/***********************************************************************************************/

/**
 * 思路
 * 1. 采用set集合存放,当发现字符与集合中数据相同时,计算集合中元素个数,并删除集合重新计算
 *      错误 ---- dvdf 结果为 3 --- 但这种方法会删除 v, 得到结果 2 --- Over
 * 2. 采用队列  从头进, 判断字符是否在队列中, 若存在则计算队列中元素个数, 并将该字符及之前添加的字符从尾移除
 *     解答成功:
 * 			执行耗时:27 ms,击败了19.76% 的Java用户
 * 			内存消耗:40.3 MB,击败了5.20% 的Java用户
 * 	   P.S.: 执行慢, 消耗大
 * 3. 从评论中收到启发
 *     ASCII 编码中一共 128 个字符
 *     所以创建容量为 128 的一维数组
 *     默认数组值为 0;
 *     字符对应的下标的数组值为 0 时 ---- 即 sum[char] == 0;
 *     存放其不重复数组的个数,
 *     若不为 0 ------ 即 sum[char] != 0;
 *     判断是否为最大不为空字符数
 *     并更新数组下标值
 *
 *     解答成功:
 * 			执行耗时:4 ms,击败了89.89% 的Java用户
 * 			内存消耗:39.9 MB,击败了5.20% 的Java用户
  */
}