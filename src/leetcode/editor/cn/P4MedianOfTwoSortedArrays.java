//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package leetcode.editor.cn;
//Java：寻找两个正序数组的中位数
public class P4MedianOfTwoSortedArrays{    
    public static void main(String[] args) {      
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();       
        // TO TEST
        int[] nums1 = {2};
        int[] nums2 = {1, 3, 4, 5, 6, 7};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 假设数组已排序
        boolean isOdd = (nums1.length + nums2.length) % 2 == 0 ? false : true; // 判断数组个数是否为奇数
        int count = (nums1.length + nums2.length) / 2; // 循环次数
        if (!isOdd) {
            count--;
        }
        int n1 = 0, n2 = 0;
        for (int i = 0; i < count; i++) {
            if (n1 < nums1.length && n2 < nums2.length) {
                if (nums1[n1] <= nums2[n2]) {
                    n1++;
                } else {
                    n2++;
                }
            } else {
                if (n1 >= nums1.length) {
                    n2 = (count - i + n2);
                    break;
                } else {
                    n1 = (count - i + n1);
                    break;
                }
            }
        }
        if (isOdd) {
            if (n1 < nums1.length && n2 < nums2.length) {
                return nums1[n1] >= nums2[n2] ? nums2[n2] : nums1[n1];
            } else {
                return n1 >= nums1.length ? nums2[n2] : nums1[n1];
            }
        } else {
            if (n1 < nums1.length && n2 < nums2.length) {
                int a = nums1[n1] >= nums2[n2] ? nums2[n2++] : nums1[n1++];
                int b;
                if (n1 < nums1.length && n2 < nums2.length) {
                    b = nums1[n1] >= nums2[n2] ? nums2[n2] : nums1[n1];
                } else {
                    b = n1 >= nums1.length ? nums2[n2] : nums1[n1];
                }
                return 1.0*(a + b) / 2;
            } else {
                return n1 >= nums1.length ? 1.0*(nums2[n2]+nums2[n2+1])/2 : 1.0*(nums1[n1]+nums1[n1+1])/2;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 假设是已排好序的两个数组(测试结果: 假设成立)
 *     计算奇\偶数, 奇数: 循环次数为 ((nums1.length + nums2.length) / 2)
 *                 偶数: 循环次数为 ((nums1.length + nums2.length) / 2 - 1)
 *     计算中间数
 *         奇数就为 当前数
 *         偶数就是 当前数+下一个数的平均数
 *     解答成功:
 * 			执行耗时:3 ms,击败了61.88% 的Java用户
 * 			内存消耗:40.7 MB,击败了100.00% 的Java用户
  */

}