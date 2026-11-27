# 1626. Best Team With No Conflicts — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/best-team-with-no-conflicts/

---

## Solution: Sort + DP (LIS variant) — O(n^2) time, O(n) space

**Idea:** Sort players by `(age, score)`. A conflict-free team corresponds to picking a subsequence where scores are non-decreasing (since ages are non-decreasing after sorting). This is exactly the Maximum Sum Increasing Subsequence (non-strictly) problem.

**Algorithm:**
1. Create player pairs `(age, score)` and sort by `(age, score)` ascending.
2. Let `dp[i]` = maximum total score of a valid team ending with player `i`.
3. For each `i`, check all `j < i`: if `score[j] <= score[i]`, then `dp[i] = max(dp[i], dp[j] + score[i])`.
4. Return `max(dp)`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — O(n log n) sort + O(n^2) DP |
| Space | O(n) — DP array |
