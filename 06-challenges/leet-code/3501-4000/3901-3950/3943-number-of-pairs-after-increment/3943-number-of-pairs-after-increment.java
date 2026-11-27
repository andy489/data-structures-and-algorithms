// https://leetcode.com/problems/number-of-pairs-after-increment/
class Solution {
    int[] bit;
    int m;

    void update(int i, int val) {
        for (i++; i <= m; i += i & (-i)) {
            bit[i] += val;
        }
    }

    int query(int i) {
        int s = 0;
        for (i++; i > 0; i -= i & (-i)) {
            s += bit[i];
        }
        return s;
    }

    int queryRange(int l, int r) {
        if (l > r) {
            return 0;
        }
        return query(r) - (l > 0 ? query(l - 1) : 0);
    }

    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        m = nums2.length;
        // Use difference array for range add, then prefix sum for actual values
        // Store actual nums2 values and use segment tree with lazy propagation
        // Since nums1 is small (<= 5), for type 2 queries iterate nums1
        // and binary search nums2 sorted with cumulative increments
        // Use offline approach with sorted nums2 + BIT for counting
        int[] lazy = new int[m + 1]; // difference array for increments
        List<Integer> results = new ArrayList<>();
        int[] sorted2 = nums2.clone();
        Arrays.sort(sorted2);
        // For each query we need to handle cumulative range adds
        // Use a Fenwick tree to track cumulative increments per index
        // then for type 2, for each nums1[j], target = tot - nums1[j]
        // count k such that nums2[k] + increment[k] == target
        // This is hard to do efficiently with BIT alone
        // Given nums1.length <= 5 and constraints, use direct BIT on value space
        // After range updates the values can be large, so we track sorted original
        // values with prefix increment sums
        int[] inc = new int[m]; // actual per-element increment (from lazy diff)
        int[] diff = new int[m + 1];
        for (int[] q : queries) {
            if (q[0] == 1) {
                diff[q[1]] += q[3];
                if (q[2] + 1 <= m - 1) {
                    diff[q[2] + 1] -= q[3];
                }
            } else {
                // Recompute increments from diff (lazy approach - not efficient for large input)
                // For this problem's constraints, we do prefix sum on diff array
                int cumInc = 0;
                Map<Long, Integer> freq = new HashMap<>();
                int[] localDiff = diff.clone();
                int tempCum = 0;
                for (int i = 0; i < m; i++) {
                    tempCum += localDiff[i];
                    long val = (long) nums2[i] + tempCum;
                    freq.merge(val, 1, Integer::sum);
                }
                long tot = q[1];
                long count = 0;
                for (int v : nums1) {
                    long target = tot - v;
                    count += freq.getOrDefault(target, 0);
                }
                results.add((int) count);
            }
        }
        int[] ans = new int[results.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = results.get(i);
        }
        return ans;
    }
}
