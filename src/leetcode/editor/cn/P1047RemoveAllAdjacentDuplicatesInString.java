//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 86 👎 0


package leetcode.editor.cn;

//Java：删除字符串中的所有相邻重复项
public class P1047RemoveAllAdjacentDuplicatesInString{    
    public static void main(String[] args) {      
        Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public String removeDuplicates(String S) {
        if (S == null || ("").equals(S)) {
            return "";
        }
//        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        char[] result = new char[chars.length];
        int index = 0;
        for (char c : chars) {
            if (index == 0) {
//                stack.push(chars[i]);
                result[index++] = c;
            } else {
                if (result[index-1] == c) {
//                    stack.pop();
                    index--;
                } else {
//                    stack.push(chars[i]);
                    result[index++] = c;
                }
            }
        }
        return new String(result, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 1. 使用  栈
 * 解答成功:
 * 		执行耗时:18 ms,击败了72.79% 的Java用户
 * 		内存消耗:39.4 MB,击败了63.32% 的Java用户
 *
 * 	2. 使用 数组
 * 	解答成功:
 * 		执行耗时:4 ms,击败了99.92% 的Java用户
 * 		内存消耗:39.5 MB,击败了52.87% 的Java用户
 */
}