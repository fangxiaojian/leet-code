//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 
//
// 示例： 
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 提示： 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。 
// 
// Related Topics 位运算 回溯算法 
// 👍 171 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二进制手表
public class P401BinaryWatch{    
    public static void main(String[] args) {      
        Solution solution = new P401BinaryWatch().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    private List<String> watch = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    times.add(parseWatch(h, m));
                }
            }
        }
        return times;
    }

    private String parseWatch(int hour, int minute) {
        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(":");
        if(minute < 10) {
            sb.append(0);
        }
        sb.append(minute);
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * Integer.bitCount(h) 计算 二进制 1 的个数
 * public static int bitCount(int i) {
 *         // HD, Figure 5-2
 *         i = i - ((i >>> 1) & 0x55555555);
 *         i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
 *         i = (i + (i >>> 4)) & 0x0f0f0f0f;
 *         i = i + (i >>> 8);
 *         i = i + (i >>> 16);
 *         return i & 0x3f;
 * }
 * 解答成功:
 * 		执行耗时:1 ms,击败了97.92% 的Java用户
 * 		内存消耗:37.1 MB,击败了95.06% 的Java用户
 */
}