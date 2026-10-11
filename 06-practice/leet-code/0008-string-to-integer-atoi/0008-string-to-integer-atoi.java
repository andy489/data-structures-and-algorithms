// https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
        if (s.length() == 0) {
            return 0;
        }
        
        char leadingChar = s.charAt(0);
        
        int cursor = 0;
        int sign = 1;
        int len = s.length();
        
        long res = 0;
        
        if (leadingChar == '+') {
            cursor++;
        }
        
        if (leadingChar == '-') {
            sign = -1;
            cursor++;
        }
        
        for (int i = cursor; i < len; ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            
            res = res * 10 + s.charAt(i) - '0';
            
            if (res > Integer.MAX_VALUE) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        return (int) res * sign;
    }
}
