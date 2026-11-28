# 2919. Minimum Increment Operations to Make Array Beautiful — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful/

---

## Solution: DP — O(n) time, O(1) space

**Idea:** For every window of 3 consecutive elements, at least one must be `>= k`. Define `dp[i]` = minimum cost to make the array beautiful up to index `i`, where index `i` is the element we last "fixed" (made >= k). The cost to fix index `i` is `max(0, k - nums[i])`. From `dp[i]`, we can jump to `dp[i+1]`, `dp[i+2]`, or `dp[i+3]` (the next position that must be fixed).

**Algorithm:**
1. Let `cost(i) = max(0, k - nums[i])`.
2. DP: `dp[i] = cost(i) + min(dp[i-1], dp[i-2], dp[i-3])` with `dp[-1] = dp[-2] = dp[-3] = 0`.
3. The answer is `min(dp[n-1], dp[n-2], dp[n-3])` — at least one of the last 3 must be fixed.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
