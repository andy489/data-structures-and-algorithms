// https://leetcode.com/problems/smallest-substring-with-identical-characters-i/

// Solution: Binary Search + Greedy Check — O(n log n) time, O(1) space
class Solution {
    public int minLength(String s, int numOps) {
        int n = s.length();
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canAchieve(s, numOps, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canAchieve(String s, int numOps, int maxLen) {
        int n = s.length();
        if (maxLen == 1) {
            // Count flips for alternating pattern starting with '0' vs '1'
            int flips0 = 0, flips1 = 0;
            for (int i = 0; i < n; i++) {
                char expected0 = (char) ('0' + (i % 2));
                char expected1 = (char) ('0' + ((i + 1) % 2));
                if (s.charAt(i) != expected0) {
                    flips0++;
                }
                if (s.charAt(i) != expected1) {
                    flips1++;
                }
            }
            return Math.min(flips0, flips1) <= numOps;
        }
        int flips = 0;
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == c) {
                j++;
            }
            int runLen = j - i;
            flips += (runLen - 1) / maxLen;
            i = j;
        }
        return flips <= numOps;
    }
}
