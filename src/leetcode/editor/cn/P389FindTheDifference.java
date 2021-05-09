//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表 
// 👍 156 👎 0


package leetcode.editor.cn;

//Java：找不同
public class P389FindTheDifference{    
    public static void main(String[] args) {      
        Solution solution = new P389FindTheDifference().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public char findTheDifference(String s, String t) {
        // s 与 t 相同, 就是多了一个数,
        // 用 ^ 异或操作,将 s t 串联起来, 最后得到的数,就是结果
        char[] sStr = s.toCharArray();
        char[] tStr = t.toCharArray();
        char ans = tStr[tStr.length - 1];
        for (int i = 0; i < sStr.length; i++) {
            ans = (char) (ans ^ sStr[i]);
            ans = (char) (ans ^ tStr[i]);
        }
        return ans;
    }
}
// 1. 暴力破解
//class Solution {
//    public char findTheDifference(String s, String t) {
//        // 先来个暴力破解试试手
//        char[] sStr = s.toCharArray();
//        char[] tStr = t.toCharArray();
//        Arrays.sort(sStr);
//        Arrays.sort(tStr);
//        for (int i = 0; i < sStr.length; i++) {
//            if (sStr[i] != tStr[i]) {
//                return tStr[i];
//            }
//        }
//        return tStr[tStr.length - 1];
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 1. 暴力破解
 * 解答成功:
 * 		执行耗时:4 ms,击败了27.46% 的Java用户
 * 		内存消耗:37.4 MB,击败了15.80% 的Java用户
 *
 * 	2. 异或操作
 * 	解答成功:
 * 		执行耗时:2 ms,击败了73.11% 的Java用户
 * 		内存消耗:37.1 MB,击败了43.46% 的Java用户
 *
 * 	3. 将 s 转换成数组再进行操作,利用空间换时间
 * 	解答成功:
 * 		执行耗时:1 ms,击败了100.00% 的Java用户
 * 		内存消耗:37.4 MB,击败了14.19% 的Java用户
 */
}