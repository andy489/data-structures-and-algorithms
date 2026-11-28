// https://leetcode.com/problems/maximum-balanced-subsequence-sum/

// Solution: BIT / Fenwick Tree with Coordinate Compression — O(n log n) time, O(n) space
class Solution {
    private long[] bit;
    private int size;

    private void update(int pos, long val) {
        for (pos++; pos <= size; pos += pos & (-pos)) {
            bit[pos] = Math.max(bit[pos], val);
        }
    }

    private long query(int pos) {
        long res = Long.MIN_VALUE;
        for (pos++; pos > 0; pos -= pos & (-pos)) {
            res = Math.max(res, bit[pos]);
        }
        return res;
    }

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] - i;
        }
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        sorted = Arrays.stream(sorted).distinct().toArray();
        Map<Integer, Integer> compress = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            compress.put(sorted[i], i);
        }
        size = sorted.length;
        bit = new long[size + 1];
        Arrays.fill(bit, Long.MIN_VALUE);

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int pos = compress.get(a[i]);
            long prev = query(pos);
            long dp = nums[i] + (prev < 0 ? 0 : prev);
            ans = Math.max(ans, dp);
            update(pos, dp);
        }
        return ans;
    }
}
