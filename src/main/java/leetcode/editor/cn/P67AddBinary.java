//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 431 👎 0


package leetcode.editor.cn;
//Java：二进制求和
public class P67AddBinary{    
    public static void main(String[] args) {      
        Solution solution = new P67AddBinary().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int temp = 0;
            for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
                if (i < 0) {  // a 为 null
                    while (temp == 1) {
                        if (j < 0) {
                            result.append(temp);
                            return result.reverse().toString();
                        }else {
                            temp += (b.charAt(j--) - '0');
                            result.append(temp % 2);
                            temp /= 2;
                        }
                    }
                    while (j >= 0) {
                        result.append(b.charAt(j--));
                    }
                } else if (j < 0) {
                    while (temp == 1) {
                        if (i < 0) {
                            result.append(temp);
                            return result.reverse().toString();
                        }else {
                            temp += a.charAt(i--) - '0';
                            result.append(temp % 2);
                            temp /= 2;
                        }
                    }
                    while (i >= 0) {
                        result.append(a.charAt(i--));
                    }
                } else {
                    temp += (a.charAt(i) - '0' + b.charAt(j) - '0');
                    result.append(temp % 2);
                    temp /= 2;
                }
            }
            if (temp == 1) {
                result.append(temp);
            }
            return result.reverse().toString();
        }
    }
// 3.
//class Solution {
//    public String addBinary(String a, String b) {
//        StringBuilder result = new StringBuilder();
//        int temp = 0;
//        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
//            if (i < 0) {
//                if (temp == 1) {
//                    if (b.charAt(j) == '1') {
//                        result.append(0);
//                    } else {
//                        result.append(temp);
//                        temp = 0;
//                    }
//                } else {
//                    result.append(b.charAt(j));
//                }
//            } else if (j < 0) {
//                if (temp == 1) {
//                    if (a.charAt(i) == '1') {
//                        result.append(0);
//                    } else {
//                        result.append(temp);
//                        temp = 0;
//                    }
//                } else {
//                    result.append(a.charAt(i));
//                }
//            } else {
//                temp += (a.charAt(i) - '0' + b.charAt(j) - '0');
//                result.append(temp % 2);
//                temp /= 2;
//            }
//        }
//        if (temp == 1) {
//            result.append(temp);
//        }
//        return result.reverse().toString();
//    }
//}
// 2.
//class Solution {
//    public String addBinary(String a, String b) {
//        StringBuilder result = new StringBuilder();
//        if (a.length() > b.length()) {
//            for (int i = 0; i < a.length() - b.length(); i++) {
//                result.append("0");
//            }
//            b = result+b;
//        } else if (a.length() < b.length()) {
//            for (int i = 0; i < b.length() - a.length(); i++) {
//                result.append("0");
//            }
//            a = result+a;
//        }
//        result.setLength(0);
//        int temp = 0;
//        for (int i = a.length() - 1; i >= 0; i--) {
//            temp = a.charAt(i) - '0' + b.charAt(i) - '0' + temp;
//            result.insert(0, temp%2);
//            temp /= 2;
//        }
//        if (temp == 1) {
//            result.insert(0, temp);
//        }
//        return result.toString();
//    }
//}
// 1.
//class Solution {
//    public String addBinary(String a, String b) {
//        Stack stack = new Stack();
//        StringBuffer result = new StringBuffer();
//        char temp = '0';
//        int aSize = a.length()-1;
//        int bSize = b.length()-1;
//        for (; aSize >= 0 && bSize >= 0; aSize--, bSize--) {
//            if (a.charAt(aSize) == '1' && b.charAt(bSize) == '1') {
//                stack.push(temp);
//                temp = '1';
//            } else if (a.charAt(aSize) == '1' || b.charAt(bSize) == '1') {
//                if (temp == '1') {
//                    stack.push('0');
//                } else {
//                    stack.push('1');
//                }
//            } else {
//                stack.push(temp);
//                temp = '0';
//            }
//        }
//        if (aSize >= 0) {
//            while (temp == '1' && aSize >= 0) {
//                if (a.charAt(aSize) == '1') {
//                    stack.push('0');
//                } else {
//                    stack.push(temp);
//                    temp = '0';
//                }
//                aSize--;
//            }
//            if (temp == '1' && aSize < 0) {
//                result.append(temp);
//                temp = '0';
//            } else {
//                result.append(a.toCharArray(), 0, aSize+1);
//            }
//        } else if (bSize >= 0) {
//            while (temp == '1' && bSize >= 0) {
//                if (b.charAt(bSize) == '1') {
//                    stack.push('0');
//                } else {
//                    stack.push(temp);
//                    temp = '0';
//                }
//                bSize--;
//            }
//            if (temp == '1' && bSize < 0) {
//                result.append(temp);
//                temp = '0';
//            } else {
//                result.append(b.toCharArray(), 0, bSize+1);
//            }
//        }
//        if (temp == '1') {
//            result.append(temp);
//        }
//        while (!stack.empty()) {
//            result.append(stack.pop());
//        }
//        return result.toString();
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 就字符串层面, 代码比较复杂, 不推荐
 *     结果:
 *     解答成功:
 * 			执行耗时:4 ms,击败了26.21% 的Java用户
 * 			内存消耗:40.5 MB,击败了7.69% 的Java用户
 * 2. 先将两个字符串补为等长的两个字符串, 在遍历一遍, 计算是否要进位
 *     结果:
 *     解答成功:
 * 			执行耗时:3 ms,击败了59.88% 的Java用户
 * 			内存消耗:39.7 MB,击败了7.69% 的Java用户
 *
 * 	3. 优化代码, 不在前面补'0', 直接判断, 若到底了, 就直接判断另外不为空的字符串
 * 	   结果：
 * 	   解答成功:
 * 			执行耗时:2 ms,击败了98.60% 的Java用户
 * 			内存消耗:38.2 MB,击败了7.69% 的Java用户
 */
}