//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 292 👎 0


package leetcode.editor.cn;

//Java：存在重复元素
public class P217ContainsDuplicate{    
    public static void main(String[] args) {      
        Solution solution = new P217ContainsDuplicate().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            } else if (nums[i] < nums[i - 1]) {
                int temp = 0;
                for (int j = i-1; j >= 0; j--) {
                    if (nums[j] > nums[j+1]) {
                        temp = nums[j+1];
                        nums[j+1] = nums[j];
                        nums[j] = temp;
                    } else if (nums[j] == nums[j + 1]) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 排序比较, 从左往右遍历,小的放前面,大的放后面,遇到相同的返回true
 *     解答成功:
 * 			执行耗时:3 ms,击败了99.36% 的Java用户
 * 			内存消耗:43.3 MB,击败了98.36% 的Java用户
 */
}