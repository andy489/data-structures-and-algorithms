// https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        // Monotonic decreasing deque of indices
        // Invariant: deque holds indices of "left-to-right maxima" in current window
        // cost = sum over consecutive pairs (prev, cur) in deque of (nums[cur] - nums[prev]) * (prev - prevPrev)
        // When adding r: pop indices whose value < nums[r], add their contribution to cost
        // When removing l: if l is at deque front, remove it; subtract contribution
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                int idx = deque.pollLast();
                int prevIdx = deque.isEmpty() ? l - 1 : deque.peekLast();
                cost += (long) (nums[r] - nums[idx]) * (idx - prevIdx);
            }
            deque.addLast(r);
            while (cost > k) {
                // Remove l from window; if l is deque front, remove it
                if (deque.peekFirst() == l) {
                    deque.pollFirst();
                }
                // Find the new "effective front" after removing l
                // Cost change: the front element now spans from l+1 instead of l
                // If deque front != l, the top of deque has value nums[front] > nums[l]
                // so removing l reduces cost by: how much l contributes
                // Actually: cost was computed as sum of rises between deque elements
                // Removing l: if l was deque front, it no longer contributes 0 itself
                // but the range from l to next deque element shrinks by 1
                // Cost reduction = nums[deque.front] - nums[l] (if nums[l] < nums[deque.front])
                // But if l was the front, we already removed it - new front has value >= old value
                // This is complex; use simpler: subtract nums[deque.peekFirst()] - nums[l] if applicable
                // Actually the standard approach: cost of making [l..r] non-decreasing
                // = sum of max(0, running_max - nums[i]) for i in [l+1..r]
                // When l increases by 1: the new running max might change
                // The O(n) way: track that when l moves past deque.front, recalculate
                // For simplicity and correctness, recompute from new l
                l++;
                // After l moves, if deque front < l, pop it
                while (!deque.isEmpty() && deque.peekFirst() < l) {
                    deque.pollFirst();
                }
                cost = computeCost(nums, l, r);
            }
            ans += (r - l + 1);
        }
        return ans;
    }

    private long computeCost(int[] nums, int l, int r) {
        long c = 0;
        int maxVal = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < maxVal) {
                c += maxVal - nums[i];
            } else {
                maxVal = nums[i];
            }
        }
        return c;
    }
}
