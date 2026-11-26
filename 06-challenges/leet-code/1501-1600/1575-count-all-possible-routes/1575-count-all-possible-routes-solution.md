# 1575. Count All Possible Routes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-all-possible-routes/

---

## Solution: Top-Down DP with Memoization — O(n^2 * fuel) time, O(n * fuel) space

**Idea:** Define `dp(cur, fuel)` = number of ways to reach `finish` from city `cur` with `fuel` remaining. At each city, we can go to any other city by paying the absolute distance cost. Memoize by `(cur, fuel)`.

**Algorithm:**
1. Base: if `fuel < 0`, return 0.
2. If memoized, return cached value.
3. Start with 1 if `cur == finish`, else 0.
4. Try moving to each other city; add `dp(next, fuel - cost)` if affordable.
5. Return cached result.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * fuel) — n cities * fuel states * n transitions |
| Space | O(n * fuel) — memoization table |
