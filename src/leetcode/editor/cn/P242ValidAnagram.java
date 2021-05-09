//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 259 👎 0


package leetcode.editor.cn;
//Java：有效的字母异位词
public class P242ValidAnagram{    
    public static void main(String[] args) {      
        Solution solution = new P242ValidAnagram().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (hash[t.charAt(i)-'a'] > 0) {
                hash[t.charAt(i)-'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 将字母-'a'后可以得到26个数字(0->25),存入数组中,字符串s遍历存入数组,字符串t遍历从数组中移除
 * 解答成功:
 * 		执行耗时:4 ms,击败了61.55% 的Java用户
 * 		内存消耗:38.7 MB,击败了53.65% 的Java用户
 */
}