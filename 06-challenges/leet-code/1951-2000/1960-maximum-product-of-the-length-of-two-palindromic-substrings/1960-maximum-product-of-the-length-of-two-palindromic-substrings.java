// https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-substrings/
class Solution {
    public long maxProduct(String s) {
        int n = s.length();
        int[] radius = manacher(s);

        long[] left = new long[n];
        long[] right = new long[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int r = radius[i];
            int start = i - r;
            int len = 2 * r + 1;
            if (start + len - 1 < n) {
                left[start + len - 1] = Math.max(left[start + len - 1], len);
            }
        }
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i], left[i - 1]);
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1];
        }
        for (int i = 0; i < n; i++) {
            int r = radius[i];
            int start = i - r;
            int len = 2 * r + 1;
            right[start] = Math.max(right[start], len);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i], right[i + 1]);
        }

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, left[i] * right[i + 1]);
        }
        return ans;
    }

    private int[] manacher(String s) {
        int n = s.length();
        int[] p = new int[n];
        int c = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (i < r) {
                p[i] = Math.min(r - i, p[2 * c - i]);
            }
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n
                    && s.charAt(i - p[i] - 1) == s.charAt(i + p[i] + 1)) {
                p[i]++;
            }
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        return p;
    }
}
