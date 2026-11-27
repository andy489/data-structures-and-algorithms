// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        int lo = 0, hi = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                lo--;
                hi++;
            } else if (s.charAt(i) == '(') {
                lo++;
                hi++;
            } else {
                lo--;
                hi--;
            }
            if (hi < 0) {
                return false;
            }
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
