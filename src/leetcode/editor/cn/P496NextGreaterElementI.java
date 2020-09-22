//给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
//比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈 
// 👍 269 👎 0


package leetcode.editor.cn;
//Java：下一个更大元素 I
public class P496NextGreaterElementI{    
    public static void main(String[] args) {      
        Solution solution = new P496NextGreaterElementI().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length <= 0) {
            return nums1;
        }
        // 创建 num1 数组的标识数组, 0 初始化, 1 找到相同的数, 2 找到下一个比其大的值
        int[] flag = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (flag[j] == 0 && nums1[j] == nums2[i]) {
                    flag[j] = 1;
                } else if (flag[j] == 1 && nums1[j] < nums2[i]) {
                    flag[j] = 2;
                    nums1[j] = nums2[i];
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (flag[i] != 2) {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 使用数组标识, 0 初始化, 1 找到相同的数, 2 找到下一个比其大的值
 *        最后再遍历一遍数组, 将标识不是2的改为 -1
 *        解答成功:
 * 			执行耗时:12 ms,击败了5.25% 的Java用户
 * 			内存消耗:38.9 MB,击败了71.36% 的Java用户
 */
}