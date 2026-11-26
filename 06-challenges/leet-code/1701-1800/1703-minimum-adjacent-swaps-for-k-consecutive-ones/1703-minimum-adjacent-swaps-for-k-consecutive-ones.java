// https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/

// Solution: Sliding Window + Prefix Sum — O(n) time, O(n) space
class Solution {
    public int minMoves(int[] nums, int k) {
        List<Long> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pos.add((long) i - pos.size());
            }
        }
        int m = pos.size();
        long[] prefix = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = prefix[i] + pos.get(i);
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i + k <= m; i++) {
            int mid = i + k / 2;
            long leftCost = pos.get(mid) * (mid - i) - (prefix[mid] - prefix[i]);
            long rightCost = (prefix[i + k] - prefix[mid + 1]) - pos.get(mid) * (i + k - mid - 1);
            result = Math.min(result, leftCost + rightCost);
        }
        return (int) result;
    }
}
