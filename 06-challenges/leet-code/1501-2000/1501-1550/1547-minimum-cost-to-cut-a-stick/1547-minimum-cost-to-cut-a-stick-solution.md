# 1547. Minimum Cost to Cut a Stick — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

---

## Solution: Interval DP — O(m^3) time, O(m^2) space

**Idea:** Augment the cuts array with 0 and n as endpoints. Use interval DP: `dp[left][right]` = minimum cost to make all cuts between positions `c[left]` and `c[right]`. The cost of the first cut in this segment is always `c[right] - c[left]` (the full length). Try all possible first cuts in the interval.

**Algorithm:**
1. Sort cuts and add 0 and n as endpoints to form array `c` of size m+2.
2. `dp[left][right]` for intervals of increasing length.
3. `dp[left][right] = min over mid in (left, right) of dp[left][mid] + dp[mid][right] + c[right] - c[left]`.
4. Answer is `dp[0][m+1]`.

**Complexity:**

| | |
|---|---|
| Time | O(m^3) — m = number of cuts (at most 100), so 10^6 operations |
| Space | O(m^2) — the DP table |
