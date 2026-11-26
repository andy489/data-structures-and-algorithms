# 1553. Minimum Number of Days to Eat N Oranges — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/

---

## Solution: Memoized Recursion — O(log^2 n) time, O(log^2 n) space

**Idea:** Instead of decrementing by 1 each time (which would be O(n)), observe that the optimal path always reaches a divisor of 2 or 3 by paying a few extra 1-steps first. So from `n`, we try `n % 2` steps to reach `n/2`, or `n % 3` steps to reach `n/3`. This creates O(log^2 n) unique states.

**Algorithm:**
1. Base cases: `minDays(0) = 0`, `minDays(1) = 1`.
2. Recurrence: `minDays(n) = 1 + min(n%2 + minDays(n/2), n%3 + minDays(n/3))`.
3. Memoize results to avoid recomputation.

**Complexity:**

| | |
|---|---|
| Time | O(log^2 n) — number of distinct states in the recursion tree |
| Space | O(log^2 n) — memoization table |
