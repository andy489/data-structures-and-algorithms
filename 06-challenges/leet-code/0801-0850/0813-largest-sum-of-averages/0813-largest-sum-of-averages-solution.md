# 813. Largest Sum of Averages — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-sum-of-averages/

---

## Solution: Dynamic Programming — O(k·n²) time, O(n) space

**Idea:** dp[j] = best score partitioning first j elements. Use prefix sums for fast average computation.

**Algorithm:**
1. Build prefix sum array.
2. dp[j] = max average of nums[0..j-1] in one group initially.
3. For each partition from 2 to k: for each j, try all split points m; dp[j] = max(dp[m] + avg(m..j)).

**Complexity:**

| | |
|---|---|
| Time | O(k·n²) — k rounds, n² transitions |
| Space | O(n) — 1D DP array |
