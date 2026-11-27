// https://leetcode.com/problems/minimum-operations-to-achieve-at-least-k-peaks/
class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return 0;
        }
        // Max peaks in a circular array of size n is n/2
        if (k > n / 2) {
            return -1;
        }

        int best = Integer.MAX_VALUE;

        // Try placing peaks starting at each index s, every 2 positions
        for (int s = 0; s < n; s++) {
            int cost = 0;
            int peaks = 0;
            int pos = s;
            // Greedily place k peaks
            for (int p = 0; p < k; p++) {
                int prev = (pos - 1 + n) % n;
                int next = (pos + 1) % n;
                int need = Math.max(nums[prev], nums[next]) + 1 - nums[pos];
                if (need > 0) {
                    cost += need;
                }
                peaks++;
                pos = (pos + 2) % n;
            }
            best = Math.min(best, cost);
        }

        return best;
    }
}
