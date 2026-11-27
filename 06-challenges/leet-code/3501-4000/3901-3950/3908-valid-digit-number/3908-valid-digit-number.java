// https://leetcode.com/problems/valid-digit-number/
class Solution {
    public boolean validDigitNumber(int n, int x) {
        String s = Integer.toString(n);
        char cx = (char) ('0' + x);
        return s.indexOf(cx) != -1 && s.charAt(0) != cx;
    }
}
