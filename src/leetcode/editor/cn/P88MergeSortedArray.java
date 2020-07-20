//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 560 👎 0


package leetcode.editor.cn;
//Java：合并两个有序数组
public class P88MergeSortedArray{    
    public static void main(String[] args) {      
        Solution solution = new P88MergeSortedArray().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m + n - 1; i >= 0 && n > 0; i--) {
                if (m == 0 || nums1[m - 1] < nums2[n - 1]) {
                    nums1[i] = nums2[--n];
                }else {
                    nums1[i] = nums1[--m];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 从后面往前面添加进数组中:
 *     1). 计算最后一位的下标: m+n-1
 *     2). 从后往前遍历数组1, 直到数组2元素为空
 *          a. 若m为0, 即数组1元素为空, 则直接将数组2元素转移到数组1中
 *          b. 若m不为0, 数组1最后一个元素比数组2最后一个元素小, 将数组2最后一个元素转移到数组1的末尾, 下标--;
 *          c. 若数组1最后一个元素比数组2最后一个元素大, 将数组1原最后一个元素转移到数组1的末尾, 下标--;
 *     结果:
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:40 MB,击败了5.06% 的Java用户
 */
}