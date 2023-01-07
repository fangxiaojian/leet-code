//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 305 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays{    
    public static void main(String[] args) {      
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();       
        // TO TEST
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        solution.intersection(nums1, nums2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int j = 0;
        int[] result = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            if ((i > 0 && nums1[i] != nums1[i - 1]) || i == 0) {
                for (; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        result[index++] = nums1[i];
                        break;
                    } else if (nums1[i] < nums2[j]) {
                        break;
                    }
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:2 ms,击败了95.12% 的Java用户
 * 		内存消耗:38.6 MB,击败了68.40% 的Java用户
 */
}