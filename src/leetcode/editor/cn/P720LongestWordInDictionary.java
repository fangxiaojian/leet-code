//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表 
// 👍 109 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：词典中最长的单词
public class P720LongestWordInDictionary{    
    public static void main(String[] args) {      
        Solution solution = new P720LongestWordInDictionary().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    private int index = 0;
    public String longestWord(String[] words) {
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                longestWord(words, i);
            }
        }

        return words[index];
    }

    private void longestWord(String[] words, int i) {
        for (int j = i+1; j < words.length; j++) {
            if (words[j].length() == words[i].length() + 1 && words[i].equals(words[j].substring(0, words[i].length()))) {
                longestWord(words, j);
                index = words[index].length() < words[j].length() ? j : index;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:93 ms,击败了5.08% 的Java用户
 * 		内存消耗:38.6 MB,击败了89.74% 的Java用户
 */
}