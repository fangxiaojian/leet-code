//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：找到所有数组中消失的数字
public class P448FindAllNumbersDisappearedInAnArray{    
    public static void main(String[] args) {      
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 将数组元素对应的位置置为负数,代表该位置有值.
 *         再遍历一次数组,找到不为负数的下标,就是数组缺失的数字了
 *         解答成功:
 * 				执行耗时:8 ms,击败了42.37% 的Java用户
 * 				内存消耗:47.9 MB,击败了36.59% 的Java用户
 */
}