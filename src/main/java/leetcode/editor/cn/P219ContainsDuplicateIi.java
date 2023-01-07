//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 201 👎 0


package leetcode.editor.cn;
//Java：存在重复元素 II
public class P219ContainsDuplicateIi{    
    public static void main(String[] args) {      
        Solution solution = new P219ContainsDuplicateIi().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && i - j <= k; j--) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 遍历数组,然后往后遍历最多k位元素,判断数组是否重复
 *     解答成功:
 * 			执行耗时:1557 ms,击败了17.60% 的Java用户
 * 			内存消耗:42.2 MB,击败了96.81% 的Java用户
 */
}