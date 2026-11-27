// https://leetcode.com/problems/maximum-frequency-after-subarray-operation/
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int countK = 0;
        for (int num : nums) {
            if (num == k) {
                countK++;
            }
        }

        int best = 0;
        for (int v = 1; v <= 50; v++) {
            if (v == k) {
                continue;
            }
            // Kadane's: +1 for v, -1 for k, 0 otherwise
            int cur = 0;
            int maxGain = 0;
            for (int num : nums) {
                if (num == v) {
                    cur++;
                } else if (num == k) {
                    cur--;
                }
                if (cur < 0) {
                    cur = 0;
                }
                if (cur > maxGain) {
                    maxGain = cur;
                }
            }
            int total = countK + maxGain;
            if (total > best) {
                best = total;
            }
        }

        return best;
    }
}
