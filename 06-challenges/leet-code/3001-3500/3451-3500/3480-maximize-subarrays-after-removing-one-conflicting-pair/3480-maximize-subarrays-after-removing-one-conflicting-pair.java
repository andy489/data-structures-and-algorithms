// https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/

// Solution: Greedy Sweep — O(n + m) time, O(n) space
class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // For each right endpoint b, store all left endpoints a (a < b)
        List<List<Integer>> byRight = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            byRight.add(new ArrayList<>());
        }
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            byRight.get(b).add(a);
        }
        long total = 0;
        long[] bonus = new long[n + 1]; // bonus[i] = extra subarrays if pair i removed
        int limit = 0; // current minLeft
        // We track top-2 limits and which pair caused them
        int lim1 = 0, lim2 = 0;
        // For each right endpoint compute gain
        // We compute: without any removal, count = sum of (r - limit) for r=1..n
        // Then find best pair to remove
        // Track the constraint index that sets lim1
        int[] limitCauser = new int[n + 1]; // which pair sets the limit at each r
        // Simplified: compute total and bonus array
        int curLimit = 0;
        long baseTotal = 0;
        long[] bonusArr = new long[conflictingPairs.length + 1];
        // Map from pair index to its (a,b)
        // Reindex: pair i corresponds to conflictingPairs[i]
        int[] pa = new int[conflictingPairs.length];
        int[] pb = new int[conflictingPairs.length];
        List<List<int[]>> byB = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            byB.add(new ArrayList<>());
        }
        for (int i = 0; i < conflictingPairs.length; i++) {
            pa[i] = Math.min(conflictingPairs[i][0], conflictingPairs[i][1]);
            pb[i] = Math.max(conflictingPairs[i][0], conflictingPairs[i][1]);
            byB.get(pb[i]).add(new int[]{pa[i], i});
        }
        // top1Limit, top2Limit at each step
        int t1 = 0, t2 = 0, t1idx = -1;
        for (int r = 1; r <= n; r++) {
            for (int[] entry : byB.get(r)) {
                int a = entry[0], idx = entry[1];
                if (a >= t1) {
                    t2 = t1;
                    t1 = a;
                    t1idx = idx;
                } else if (a > t2) {
                    t2 = a;
                }
            }
            baseTotal += r - t1;
            // If we remove t1idx, the limit becomes t2
            if (t1idx >= 0) {
                bonusArr[t1idx] += t1 - t2;
            }
        }
        long best = 0;
        for (long b : bonusArr) {
            best = Math.max(best, b);
        }
        return baseTotal + best;
    }
}
