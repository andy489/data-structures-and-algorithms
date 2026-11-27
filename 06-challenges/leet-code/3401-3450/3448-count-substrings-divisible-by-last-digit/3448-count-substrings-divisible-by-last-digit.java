// https://leetcode.com/problems/count-substrings-divisible-by-last-digit/
class Solution {
    public long countSubstrings(String s) {
        int n = s.length();
        long total = 0;
        for (int r = 0; r < n; r++) {
            int d = s.charAt(r) - '0';
            if (d == 0) {
                continue;
            }
            int num = 0;
            int pow10 = 1;
            for (int l = r; l >= 0; l--) {
                int digit = s.charAt(l) - '0';
                num = (num + digit * pow10) % d;
                pow10 = pow10 * 10 % d;
                if (num == 0) {
                    total++;
                }
            }
        }
        return total;
    }
}
