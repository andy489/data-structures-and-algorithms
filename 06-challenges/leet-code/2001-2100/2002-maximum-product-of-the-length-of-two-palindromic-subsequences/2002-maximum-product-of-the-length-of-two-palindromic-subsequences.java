// https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

// Solution: Bitmask Enumeration — O(3^n) time, O(2^n) space
class Solution {
    public int maxProduct(String s) {
        int n = s.length(), full = 1 << n;
        int[] palin = new int[full];
        for (int mask = 1; mask < full; mask++) {
            if (isPalin(s, mask)) { palin[mask] = Integer.bitCount(mask); }
        }
        int res = 0;
        for (int mask = 1; mask < full; mask++) {
            if (palin[mask] == 0) { continue; }
            int comp = (full - 1) ^ mask;
            for (int sub = comp; sub > 0; sub = (sub - 1) & comp) {
                if (palin[sub] > 0) { res = Math.max(res, palin[mask] * palin[sub]); }
            }
        }
        return res;
    }
    private boolean isPalin(String s, int mask) {
        int[] chars = new int[Integer.bitCount(mask)];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((mask >> i & 1) == 1) { chars[idx++] = s.charAt(i); }
        }
        for (int l = 0, r = chars.length - 1; l < r; l++, r--) {
            if (chars[l] != chars[r]) { return false; }
        }
        return true;
    }
}
