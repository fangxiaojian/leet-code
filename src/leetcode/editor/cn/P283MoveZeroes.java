//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 731 👎 0


package leetcode.editor.cn;
//Java：移动零
public class P283MoveZeroes{    
    public static void main(String[] args) {      
        Solution solution = new P283MoveZeroes().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
            int p1=0; // 指向0
            int p2=0; // 指向非0
            int temp;
            while (p2 < nums.length && p1 <nums.length) {
                if (nums[p1] != 0) {
                    p1++;
                }else if (nums[p2] != 0) {
                    if (p2 < p1) {
                        p2 = p1+1;
                        continue;
                    }
                    temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                    p1++;
                }
                if (nums[p2] == 0) {
                    p2++;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1 p1 指向 为0 的位置, p2 指向 非0 的位置
 *        当p1 为0, p2 为非0 并且p1<p2 时
 *        互换位置.
 *        解答成功:
 * 				执行耗时:0 ms,击败了100.00% 的Java用户
 * 				内存消耗:39.4 MB,击败了13.48% 的Java用户
 */
}