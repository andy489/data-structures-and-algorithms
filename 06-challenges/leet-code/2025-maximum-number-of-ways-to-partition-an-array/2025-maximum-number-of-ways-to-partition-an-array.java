// https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/

// Solution: Prefix Sums + HashMap — O(n) time, O(n) space
class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) { prefix[i] = prefix[i - 1] + nums[i]; }
        long total = prefix[n - 1];
        // no op
        int res = 0;
        if (total % 2 == 0) {
            for (int i = 0; i < n - 1; i++) { if (prefix[i] == total / 2) { res++; } }
        }
        Map<Long, Integer> left = new HashMap<>(), right = new HashMap<>();
        for (int i = 1; i < n; i++) { right.merge(prefix[i - 1], 1, Integer::sum); }
        for (int j = 0; j < n; j++) {
            long newTotal = total - nums[j] + k;
            if (newTotal % 2 == 0) {
                long half = newTotal / 2;
                long diff = k - nums[j];
                int cnt = left.getOrDefault(half - diff, 0) + right.getOrDefault(half, 0);
                res = Math.max(res, cnt);
            }
            right.merge(prefix[j], -1, Integer::sum);
            if (j < n - 1) { left.merge(prefix[j], 1, Integer::sum); }
        }
        return res;
    }
}
