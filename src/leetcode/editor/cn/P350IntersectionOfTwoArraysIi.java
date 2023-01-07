//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 429 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：两个数组的交集 II
public class P350IntersectionOfTwoArraysIi{    
    public static void main(String[] args) {      
        Solution solution = new P350IntersectionOfTwoArraysIi().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
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
           for (; j < nums2.length; j++) {
               if (nums1[i] == nums2[j]) {
                    result[index++] = nums1[i];
                    j++;
                    break;
                } else if (nums1[i] < nums2[j]) {
                    break;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.5 MB,击败了76.85% 的Java用户
 */
}