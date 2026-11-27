# 1703. Minimum Adjacent Swaps for K Consecutive Ones — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/

---

## Solution: Sliding Window + Prefix Sum — O(n) time, O(n) space

**Idea:** Collect positions of all `1`s. For a sliding window of `k` ones, the optimal meeting point is the median. The cost to move `k` ones together equals the sum of distances to their median. Using prefix sums on positions allows O(1) cost calculation per window.

To avoid index offsets, subtract `i` from each position `pos[i]` (transforming to a "compressed" coordinate where consecutive 1s have equal positions). Then the total swaps for a window is the sum of distances from each position to the median.

**Algorithm:**
1. Extract positions of all `1`s into array `pos`.
2. Build prefix sum array on `pos`.
3. Slide a window of size `k` over `pos`:
   - Median index is `mid = i + k/2`.
   - Cost = `pos[mid] * (mid - i) - prefixSum[mid] + prefixSum[i]` (right half) minus left half offset.
   - Adjust for the shifting offset: subtract the triangular number offset.
4. Track the minimum cost.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass after collecting positions |
| Space | O(n) — positions and prefix sum arrays |
