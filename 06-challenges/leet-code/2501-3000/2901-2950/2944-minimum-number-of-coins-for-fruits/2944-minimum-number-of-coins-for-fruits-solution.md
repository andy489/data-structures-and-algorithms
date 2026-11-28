# 2944. Minimum Number of Coins for Fruits — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-coins-for-fruits/

---

## Solution: DP with Monotonic Deque — O(n) time, O(n) space

**Idea:** Define `dp[i]` = minimum coins to acquire all fruits from index `i` to `n-1` (0-indexed). Buying fruit `i` (cost `prices[i]`) lets you take the next `i` fruits for free, so you next need to buy some fruit `j` where `j > i + i = 2*i`. Thus `dp[i] = prices[i] + min(dp[i+1 .. 2*i+2])`. Use a monotonic deque to get range minimum in O(1) amortized.

**Algorithm:**
1. Traverse `i` from `n-1` down to 0.
2. Maintain a deque of indices in increasing order of `dp` value.
3. For index `i`, the valid next choices are `j` in `[i+1, 2*i+2]` (1-indexed: fruit `i+1` can cover up to fruit `2*(i+1) = 2i+2`).
4. Remove from front of deque any index outside the window `[i+1, 2i+2]`.
5. `dp[i] = prices[i] + dp[deque.front]`.
6. Maintain deque from back (pop indices with `dp` >= current `dp[i]`).
7. Answer is `dp[0]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
