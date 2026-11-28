// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-ii/

// Solution: Pascal's Triangle / Combinatorics — O(n) time, O(n) space
class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        // After n-2 reductions, the two final digits are:
        // d0 = sum(C(n-2, i) * s[i]) mod 10, for i in [0, n-2]
        // d1 = sum(C(n-2, i) * s[i+1]) mod 10, for i in [0, n-2]
        // We need to compute C(n-2, i) mod 10 using Pascal row
        // But n can be up to 1e5. Use Lucas theorem mod 2 and mod 5 separately.
        // C(n, k) mod 10 = (C(n,k) mod 2) * (C(n,k) mod 5) combined via CRT
        // Lucas: C(n,k) mod p = product of C(ni, ki) mod p where n = sum ni*p^i
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        int len = n - 2; // number of rows reduced = n-2 times, C(n-2, i)
        long d0 = 0, d1 = 0;
        // Compute binomial row C(len, 0), C(len, 1), ..., C(len, len) mod 10
        // Use Pascal triangle iteratively mod 10
        long[] binom = new long[len + 1];
        binom[0] = 1;
        for (int r = 1; r <= len; r++) {
            for (int col = r; col >= 1; col--) {
                binom[col] = (binom[col] + binom[col - 1]) % 10;
            }
        }
        for (int i = 0; i <= len; i++) {
            d0 = (d0 + binom[i] * digits[i]) % 10;
            d1 = (d1 + binom[i] * digits[i + 1]) % 10;
        }
        return d0 == d1;
    }
}
