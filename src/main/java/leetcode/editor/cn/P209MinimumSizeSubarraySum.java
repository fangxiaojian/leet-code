package leetcode.editor.cn;

//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1600 👎 0

public class P209MinimumSizeSubarraySum{

    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();

        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;

        System.out.println(solution.minSubArrayLen(target, nums));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int tempSum = 0;
        int minLength = nums.length;
        for (end = 0; end < nums.length; end++) {
            if (nums[end] >= target) {
                return 1;
            }
            tempSum += nums[end];
            while (tempSum - nums[start] >= target) {
                tempSum -= nums[start++];
            }
            if (tempSum >= target) {
                minLength = Math.min(minLength, end + 1 - start);
            }
        }
        if (tempSum >= target) {
            while (tempSum - nums[--end] >= target) {
                tempSum -= nums[end];
            }
            return Math.min(minLength, end + 1 - start);
        } else {
            return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：滑动窗口，窗口中记录的值为大于target的值，记录此时的个数的最小值
 * 解答成功:
 * 	执行耗时:2 ms,击败了15.15% 的Java用户
 * 	内存消耗:48.3 MB,击败了98.90% 的Java用户
 */
}