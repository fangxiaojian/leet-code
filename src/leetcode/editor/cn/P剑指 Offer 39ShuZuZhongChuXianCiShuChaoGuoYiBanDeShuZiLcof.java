//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 77 👎 0


package leetcode.editor.cn;
//Java：数组中出现次数超过一半的数字
class P剑指Offer39ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer39ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int majorityElement(int[] nums) {
        int[][] index = new int[nums.length/2+1][2];
        int target = 0;
        for (int num : nums) {
            for (int j = 0; j < index.length; j++) {
                if ((index[j][0] == 0 && index[j][1]==0) || index[j][0] == num) {
                    target = j;
                    index[j][0] = num;
                    break;
                }
            }
            index[target][1]++;
            if (index[target][1]*2 >= nums.length) {
                return num;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:4 ms,击败了31.14% 的Java用户
 * 		内存消耗:43.8 MB,击败了22.94% 的Java用户
 */
}