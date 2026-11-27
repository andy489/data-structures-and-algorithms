# 1687. Delivering Boxes from Storage to Ports — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/

---

## Solution: Sliding Window + DP — O(n) time, O(n) space

**Idea:** `dp[i]` = minimum trips to deliver first `i` boxes. For a window `[j, i]` of boxes we can load together (respecting maxBoxes/maxWeight), the cost is `dp[j-1] + trips(j, i) + 1` (1 for the final return trip).

The number of trips within window `[j, i]` = number of port changes + 1. Use a sliding window with a running count of port changes to compute this in O(1) per step.

**Algorithm:**
1. Precompute `changes[i]` = 1 if `boxes[i][0] != boxes[i-1][0]` else 0.
2. Use monotone sliding window: maintain left pointer, weight, box count.
3. `dp[i] = dp[j-1] + (port_changes from j to i) + 2` (go + return).
4. Optimize with the observation that `dp` is non-decreasing.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
