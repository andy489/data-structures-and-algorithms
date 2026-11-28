// https://leetcode.com/problems/select-k-disjoint-special-substrings/

// Solution: Greedy Interval Counting — O(n) time, O(1) space
class Solution {
    public boolean maxSubstringLength(String s, int k) {
        int n = s.length();
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        // For each character, determine the minimal special interval
        // Expand interval to include all chars within [first[c], last[c]]
        List<int[]> intervals = new ArrayList<>();
        boolean[] used = new boolean[26];
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1 || used[c]) {
                continue;
            }
            int lo = first[c], hi = last[c];
            boolean changed = true;
            while (changed) {
                changed = false;
                for (int i = lo; i <= hi; i++) {
                    int cc = s.charAt(i) - 'a';
                    if (first[cc] < lo) {
                        lo = first[cc];
                        changed = true;
                    }
                    if (last[cc] > hi) {
                        hi = last[cc];
                        changed = true;
                    }
                }
            }
            // Check this interval is not the entire string
            if (lo == 0 && hi == n - 1) {
                continue;
            }
            // Mark all chars in [lo, hi] as used
            for (int i = lo; i <= hi; i++) {
                used[s.charAt(i) - 'a'] = true;
            }
            intervals.add(new int[]{lo, hi});
        }
        // Count non-overlapping intervals (already non-overlapping by construction)
        // Sort by end, greedy count
        intervals.sort((a, b) -> a[1] - b[1]);
        int count = 0, prevEnd = -1;
        for (int[] iv : intervals) {
            if (iv[0] > prevEnd) {
                count++;
                prevEnd = iv[1];
            }
        }
        return count >= k;
    }
}
