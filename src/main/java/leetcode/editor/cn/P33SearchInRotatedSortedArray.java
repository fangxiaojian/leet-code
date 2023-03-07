package leetcode.editor.cn;

//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2520 👎 0

public class P33SearchInRotatedSortedArray{

    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();

        int[] nums = {5,6,7,8,1,2,3,4};
        int target = 8;
        System.out.println(solution.search(nums, 4));
        System.out.println(solution.search(nums, 5));
        System.out.println(solution.search(nums, 6));
        System.out.println(solution.search(nums, 7));
        System.out.println(solution.search(nums, 8));
        System.out.println(solution.search(nums, 1));
        System.out.println(solution.search(nums, 2));
        System.out.println(solution.search(nums, 3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            }
            if (left + 1 >= right) {
                return -1;
            }
            int middle = ((right + left) / 2 == left) ? left + 1 : (right + left) / 2;
            if (nums[left] < nums[right]) {
                if (target > nums[left] && target <= nums[middle]) {
                    right = middle;
                } else if (target < nums[right] && target >= nums[middle]) {
                    left = middle;
                } else {
                    return -1;
                }
            } else if (nums[left] > nums[right]) {
                if (target > nums[middle]) {
                    if (target < nums[right] || nums[middle] > nums[left]) {
                        left = middle;
                    } else {
                        right = middle;
                    }
                } else {
                    if (target > nums[left] || nums[middle] < nums[right]) {
                        right = middle;
                    }else {
                        left = middle;
                    }
                }
            } else {
                return -1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：二分查找，画图，图形是两个递增的一次函数
 *
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:41.2 MB,击败了40.21% 的Java用户
 */
}