# 837. New 21 Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/new-21-game/

---

## Solution: Sliding Window DP — O(n) time, O(n) space

**Idea:** dp[i] = probability of reaching exactly i points. dp[i] = sum(dp[i-maxPts..i-1]) / maxPts for i < k; for i ≥ k (stopped), dp[i] contributes to answer. Use a sliding window sum to maintain the sum efficiently.

**Algorithm:**
1. dp[0] = 1; windowSum = 1.
2. For i from 1 to n: dp[i] = windowSum / maxPts (if i < k add to windowSum; if i > maxPts subtract dp[i - maxPts - 1]).
3. Sum dp[k..n].

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — dp array |
