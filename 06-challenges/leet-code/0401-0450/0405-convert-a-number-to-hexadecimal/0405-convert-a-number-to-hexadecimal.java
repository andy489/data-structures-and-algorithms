// https://leetcode.com/problems/convert-a-number-to-hexadecimal/

// Solution: Bit Masking — O(1) time, O(1) space
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(hexChars[num & 0xf]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
