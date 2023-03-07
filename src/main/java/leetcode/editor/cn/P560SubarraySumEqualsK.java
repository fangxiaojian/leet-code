package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 1837 👎 0

public class P560SubarraySumEqualsK{

    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(solution.subarraySum(nums, k));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int temp = 0;
        int tempSum = 0;
        int count = 0;
        int[] tempArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            tempArr[i] = tempSum;
            temp = 0;
            if (tempSum == k) {
                count++;
            }
            while (temp < i) {
                if (tempArr[i] - tempArr[temp++] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：从左到右累加，并将累加的数记录在数组中
 *      计算当前数的左边有没有连续子数组的和为k
 * 解答成功:
 * 	执行耗时:1940 ms,击败了5.14% 的Java用户
 * 	内存消耗:43.1 MB,击败了95.50% 的Java用户
 */
}