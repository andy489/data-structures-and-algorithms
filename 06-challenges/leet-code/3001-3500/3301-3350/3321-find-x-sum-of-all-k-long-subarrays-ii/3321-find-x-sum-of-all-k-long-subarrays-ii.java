// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] answer = new long[n - k + 1];
        Map<Integer, Long> freq = new HashMap<>();
        // TreeSet with (freq, value), sorted descending
        // Using long[] {freq, value} won't work directly, use a comparator
        TreeSet<long[]> top = new TreeSet<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        TreeSet<long[]> bottom = new TreeSet<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        long[] topSum = {0};

        // Helper to move max of bottom to top
        // Helper to move min of top to bottom
        for (int i = 0; i < n; i++) {
            // Add nums[i] to window
            int v = nums[i];
            long oldFreq = freq.getOrDefault(v, 0L);
            long newFreq = oldFreq + 1;
            freq.put(v, newFreq);
            // Remove old entry from top or bottom
            if (oldFreq > 0) {
                long[] key = {oldFreq, v};
                if (top.remove(key)) {
                    topSum[0] -= oldFreq * v;
                } else {
                    bottom.remove(key);
                }
            }
            // Add new entry to bottom first
            bottom.add(new long[]{newFreq, v});
            // Rebalance: move top x from bottom to top
            rebalance(top, bottom, topSum, x);

            if (i >= k - 1) {
                answer[i - k + 1] = topSum[0];
                // Remove nums[i - k + 1] from window
                int rem = nums[i - k + 1];
                long remFreq = freq.get(rem);
                long[] remKey = {remFreq, rem};
                if (top.remove(remKey)) {
                    topSum[0] -= remFreq * rem;
                } else {
                    bottom.remove(remKey);
                }
                if (remFreq > 1) {
                    bottom.add(new long[]{remFreq - 1, rem});
                }
                freq.put(rem, remFreq - 1);
                if (freq.get(rem) == 0) {
                    freq.remove(rem);
                }
                rebalance(top, bottom, topSum, x);
            }
        }
        return answer;
    }

    private void rebalance(TreeSet<long[]> top, TreeSet<long[]> bottom, long[] topSum, int x) {
        while (top.size() > x) {
            long[] min = top.pollFirst();
            topSum[0] -= min[0] * min[1];
            bottom.add(min);
        }
        while (top.size() < x && !bottom.isEmpty()) {
            long[] max = bottom.pollLast();
            topSum[0] += max[0] * max[1];
            top.add(max);
        }
    }
}
